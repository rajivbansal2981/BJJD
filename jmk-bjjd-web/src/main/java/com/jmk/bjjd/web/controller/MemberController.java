package com.jmk.bjjd.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jmk.bjjd.enums.Day;
import com.jmk.bjjd.enums.DayNumberInMonth;
import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.PhotoUploadModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.web.facade.MemberMgmtServiceFacade;
import com.jmk.bjjd.web.facade.SevaCategoryMgmtServiceFacade;
import com.jmk.bjjd.web.form.MemberFormModel;
import com.jmk.bjjd.web.utils.UserUtility;
import com.jmk.bjjd.web.validators.MemberFormModelValidator;

@Controller("memberController")
public class MemberController {
	
	private static Mapper mapper = new DozerBeanMapper();
	
	@Autowired
	private SevaCategoryMgmtServiceFacade sevaCategoryMgmtServiceFacade;
	
	@Autowired
	private MemberMgmtServiceFacade memberMgmtServiceFacade;
	
	@Autowired
	private MemberFormModelValidator memberFormModelValidator;
	
	private Logger logger=LoggerFactory.getLogger(MemberController.class);

	
	@RequestMapping("member/editMemberPage/{module}/{mode}")
	public String editMemberPage(@ModelAttribute("memberFormModel")MemberFormModel memberFormModel,@PathVariable("module")String module,@PathVariable("mode")String mode){
		logger.info("Module" + module);
		logger.info("Mode : " + mode);
		return "editMemberPage";
	}
	
	
	@RequestMapping("viewMemberPage")
	public String viewMemberPage(@ModelAttribute("memberFormModel")MemberFormModel memberFormModel){
		return "viewMemberPage";
	}
	
	@ModelAttribute("sevaCategories")
	public List<SevaCategoryModel> sevaCategories(){
		logger.info("UserUtility.getLoggedInUser()" + UserUtility.getLoggedInUser());
		logger.info("UserUtility.getLoggedInUser().getUserModel()" + UserUtility.getLoggedInUser().getUserModel());
		logger.info("UserUtility.getLoggedInUser().getUserModel().getTenantId()" + UserUtility.getLoggedInUser().getUserModel().getTenantId());
		List<SevaCategoryModel> sevaCategories=sevaCategoryMgmtServiceFacade.fetchAllRecords(UserUtility.getLoggedInUser().getUserModel().getTenantId());
		return sevaCategories;
	}
	
	@ModelAttribute("teamLeaders")
	public List<MemberModel> teamLeaders(){
		List<MemberModel> teamLeaders=memberMgmtServiceFacade.findTeamLeadersByTenantId(UserUtility.getLoggedInUser().getUserModel().getTenantId());
		return teamLeaders;
	}
	
	@ModelAttribute("userRoles")
	public List<RoleModel> userRoles(){
		List<RoleModel> userRoles=memberMgmtServiceFacade.findRolesByTenantId(UserUtility.getLoggedInUser().getUserModel().getTenantId());
		return userRoles;
	}
	
	@ModelAttribute("days")
	public List<Day> getDays(){
		List<Day> days=Arrays.asList(Day.values());
		return days;
	}
	
//	@ModelAttribute("roles")
//	public List<RoleModel> getRoles(){
//		return null;
//	}
//	
	@ModelAttribute("teamLeaders")
	public List<MemberModel> getTeamLeaders(){
		return null;
	}
	
	@ModelAttribute("dayNumbersInMonth")
	public List<DayNumberInMonth> getDayNumbersInTheMonth(){
		List<DayNumberInMonth> dayNumbersInTheMonth=Arrays.asList(DayNumberInMonth.values());
		return dayNumbersInTheMonth;
	}
	
	@RequestMapping(value="member/saveMember",method=RequestMethod.POST)
	public String saveMember(@Valid @ModelAttribute("memberFormModel") MemberFormModel memberFormModel,HttpServletRequest request,BindingResult result,Model model,
			final RedirectAttributes redirectAttributes
			) throws IllegalStateException, IOException {
		logger.info(memberFormModel.toString());
		
	//	memberFormModelValidator.validate(memberFormModel, result);
		if (result.hasErrors()) {
			return "editMemberPage";
		}
		/*FileOutputStream fos = new FileOutputStream("F:\\Member.ser");
		SerializationUtils.serialize(memberFormModel, fos);*/
		MemberModel memberModel=map(memberFormModel,MemberModel.class);
		File file=null;
		if (memberFormModel.getFileUpload() != null) {
        	logger.info(memberFormModel.getFileUpload().getOriginalFilename());
        	file=new File(request.getServletContext().getRealPath("/")).getParentFile();
        	logger.info("FILEPATH1: "+file.getCanonicalPath());
            PhotoUploadModel photoUpload = new PhotoUploadModel();
            photoUpload.setName(memberFormModel.getFileUpload().getOriginalFilename());
            memberFormModel.getFileUpload().transferTo(new File(file.getParentFile().getAbsolutePath()+"/bjjd/member_photos/"+memberModel.getFirstName()+".jpeg"));
            memberModel.setPhotoUpload(photoUpload);
		}
		
		
		memberModel = memberMgmtServiceFacade.saveRecord(memberModel);
		memberFormModel=map(memberModel,MemberFormModel.class);
		
		redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		
		try (FileInputStream fis = new FileInputStream(new File(file.getParentFile().getAbsolutePath()+"/bjjd/member_photos/"+memberModel.getFirstName()+".jpeg"));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			int b;
			byte[] buffer = new byte[1024*10];
			while ((-1!= fis.read(buffer))) {
				baos.write(buffer);
			}

			byte[] fileBytes = baos.toByteArray();
			String encodedString = Base64.encodeBase64String(fileBytes);
			logger.info("FILEPATH: "+encodedString);
			model.addAttribute("imageContent", encodedString);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return "viewMemberPage";
	}
	
	public static <T> T map(Object source,Class<T> destinationClass){
		T mappedClass=null;
		if(source!=null){
			mappedClass= mapper.map(source, destinationClass);
		}
		return mappedClass;
	}
	

}
