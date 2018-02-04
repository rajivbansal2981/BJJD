<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/member/saveMember" var="editMember" htmlEscape="true"/>
<script src="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/jquery-ui-1.11.4/external/jquery/jquery.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.js" />" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.min.css" />" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.css" />" type="text/css"/>
<script type="text/javascript">
$(document).ready(function() {

	$('#joiningDate').datepicker({
		changeMonth:true,
		changeYear:true
	});
	
	$('#dateOfBirth').datepicker({
		changeMonth:true,
		changeYear:true
	});
	
//	$('#saveMember').click(function(e){
//		alert("Add Button");
//	   	document.getElementById("memberForm").submit();
//	});
	
	function readURL() {
		//	rehide the image and remove its current "src",
		//	this way if the new image doesn't load,
		//	then the image element is "gone" for now
		$('#image').attr('src', '').hide();
		if (this.files && this.files[0]) {
			var reader = new FileReader();
			$(reader).load(function(e) {
				$('#image')
					//	first we set the attribute of "src" thus changing the image link
					.attr('src', e.target.result)	//	this will now call the load event on the image
			});
			reader.readAsDataURL(this.files[0]);
		}
	}

//		below makes use of jQuery chaining. This means the same element is returned after each method, so we don't need to call it again
	$('#image')
		.load(function(e) {
			//	$(this) is the jQuery OBJECT of this which is the element we've called on this load method
			$(this)
				.css('height', '100px').show();})
		.hide();	//	done

	 $("#fileUpload").change(readURL);
	//Settings for tab
	 $(function() {
		    $( "#tabs" ).tabs();
	  });
	  
	  $( "#tabs" ).tabs({
		heightStyle: "auto"
	  });
});

	
</script>
<body>
<!-- *********Pending Items
Reporting Lead - to fetch the all member details having the role of TL
Roles- Assign multiple roles
Reference- to select the member id
 -->
<table>
	<tr>
		<td style="height:50px;">&nbsp;</td>
	</tr>
</table>
<form:form id="memberForm" modelAttribute="memberFormModel" action="${editMember}" method="POST" enctype="multipart/form-data">
<div id="tabs" class="border_admin" style="width:990px;" align="center" >
					<table	class="border_admin1" style="width:990px;" align="center" >
						 <tr>
							<td style="text-align:center" class="legend"><B>Member Management Form</B></td>
						</tr>
					</table>
	
  <ul>
    <li><a href="#tabs-1">Basic</a></li>
    <li><a href="#tabs-2">Address</a></li>
    <li><a href="#tabs-3">Seva</a></li>
    <li><a href="#tabs-4">Contact</a></li>
    <li><a href="#tabs-5">Roles & Reporting</a>
  </ul>
  <div id="tabs-1">
    <table style="width:990px;" align="center" >
						 <tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="fileUpload">Photo:</form:label></b></td>
							<td class="txt_adminblack"><form:input type="file" id="fileUpload" path="fileUpload" />
								<img id="image" src="#" alt="your image" />
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="id">Member ID</form:label></b></td>
							<td class="txt_adminblack"><form:input id="id" path="id" name="id" size="20" maxlength="50" type="text" cssClass="txt_textbox" cssStyle="width:50px" /></td>
							<td class="txt_adminblack">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="firstName">First Name:</form:label></b></td>
							<td class="txt_adminblack"><form:input id="firstName" path="firstName" name="firstName" size="20" maxlength="50" type="text" cssClass="txt_textbox" cssStyle="width:150px" /><span class="asterisk_input" ></span></td>
							<td class="txt_adminblack"><form:errors path="firstName" cssClass="error" /></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="lastName">Last Name :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="lastName" path="lastName" name="lastName" cssClass="txt_textbox" cssStyle="width:150px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="dateOfBirth">Date of Birth :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="dateOfBirth" path="dateOfBirth" name="dateOfBirth" cssClass="txt_textbox" cssStyle="width:120px" /><span class="asterisk_input" ></span></td>
							<td class="txt_adminblack"><form:errors path="dateOfBirth" cssClass="error" /></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="fatherName">Father Name :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="fatherName" path="fatherName" name="fatherName" cssClass="txt_textbox" cssStyle="width:150px" /><span class="asterisk_input" ></span></td>
							<td class="txt_adminblack"><form:errors path="fatherName" cssClass="error"/></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="joiningDate">Joining Date :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="joiningDate" path="joiningDate" name="joiningDate" cssClass="txt_textbox" cssStyle="width:120px" /><span class="asterisk_input" ></span></td>
							<td class="txt_adminblack"><form:errors path="joiningDate" cssClass="error"/></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="active">Active:</form:label></b></td>
							<td class="txt_adminblack">
								<form:radiobutton path="active" value="true"/>Yes
								<form:radiobutton path="active" value="false" />No
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="dressIssued">Dress Issued :</form:label></b></td>
							<td class="txt_adminblack">
								<form:radiobutton path="dressIssued" value="true"/>Yes
								<form:radiobutton path="dressIssued" value="false" />No
							<td>&nbsp;</td>
						</tr>
		</table>
	 </div>
  <div id="tabs-2">
   		<table style="width:990px;" align="center" >
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.flatNo">Flat No :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="flatNo" path="mailingAddress.flatNo" name="flatNo" cssClass="txt_textbox" cssStyle="width:50px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.streetNo">Street :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="streetNo" path="mailingAddress.streetNo" name="streetNo" cssClass="txt_textbox" cssStyle="width:80px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.addressLine1">Address Line 1 :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="addressLine1" path="mailingAddress.addressLine1" name="addressLine1" cssClass="txt_textbox" cssStyle="width:200px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.addressLine2">Address Line 2 :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="addressLine2" path="mailingAddress.addressLine2" name="addressLine2" cssClass="txt_textbox" cssStyle="width:200px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.landmark">Landmark:</form:label></b></td>
							<td class="txt_adminblack"><form:input id="landmark" path="mailingAddress.landmark" name="landmark" cssClass="txt_textbox" cssStyle="width:200px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.city">City :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="city" path="mailingAddress.city" name="city" cssClass="txt_textbox" cssStyle="width:120px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.state">State :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="state" path="mailingAddress.state" name="state" cssClass="txt_textbox" cssStyle="width:120px" /><span class="asterisk_input" ></span></td>
							<td class="txt_adminblack"><form:errors path="mailingAddress.state" cssClass="error" /></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mailingAddress.pinCode">Pin Code :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="pinCode" path="mailingAddress.pinCode" name="pinCode" cssClass="txt_textbox" cssStyle="width:70px"  /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
		</table>
	</div>
  <div id="tabs-3">
		<table  style="width:990px;" class="border_admin" >
			 			<tr>
							<td colspan="6">&nbsp;</td>
						</tr>
						<tr>
							<th align="left">Applicable</th>
							<th align="left">Category</th>
							<th align="left">Day</th>
							<th align="left">Day In Month</th>
							<th align="left">Description</th> 
						</tr>
						<c:forEach items="${sevaCategories}" var="sevaCategory" varStatus="status">
						<tr>
								<td>
									<form:checkbox cssClass="txt_textbox" path="sevas[${status.index}].applicable" />
								</td>
								<td >
									<input type="hidden" name="sevas[${status.index}].sevaCategory.id" value="${sevaCategory.id}" />
									<form:label cssClass="txt_textbox"  path="sevas[${status.index}].sevaCategory.name" name="sevas[${status.index}].sevaCategory.name" >${sevaCategory.name}</form:label>
								</td>
								<td class="txt_adminblack">
									<form:select cssClass="txt_textbox" path="sevas[${status.index}].day">
										<c:forEach items='${days}' var="day">
											<form:option id="dayId" value='${day}'>${day.displayName}</form:option>
										</c:forEach>
									</form:select>
								</td>
								<td class="txt_adminblack">
									<form:select cssClass="txt_textbox" path="sevas[${status.index}].dayNumberInMonth">
										<c:forEach items='${dayNumbersInMonth}' var="dayNumberInMonth">
											<form:option id="dayNumberInMonthId" value='${dayNumberInMonth}'>${dayNumberInMonth.displayName}</form:option>
										</c:forEach>
									</form:select>
								</td>
								<td><form:input cssClass="txt_textbox" path="sevas[${status.index}].description"  /></td>
								<td><form:errors path="sevas[${status.index}].description" cssClass="error" /></td>
						</tr>
						</c:forEach>
		</table>
	</div>
	<div id="tabs-4">
		<table style="width:990px;" align="center" >
			 			<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mobileNo1">Mobile :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="mobileNo1" path="mobileNo1" name="mobileNo1" cssClass="txt_textbox" cssStyle="width:120px" /><span class="asterisk_input" ></span></td>
							<td class="txt_adminblack"><form:errors path="mobileNo1" cssClass="error" /></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="mobileNo2">Alternate Mobile :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="mobileNo2" path="mobileNo2" name="mobileNo2" cssClass="txt_textbox" cssStyle="width:120px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="emailId">Email :</form:label></b></td>
							<td class="txt_adminblack"><form:input id="emailId" path="emailId" name="emailId" cssClass="txt_textbox" cssStyle="width:200px" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
		</table>
	</div>
	<div id="tabs-5">
		<table style="width:990px;" align="center" >
		
			 			<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="roles">Role :</form:label></b></td>
							<td class="txt_adminblack">
								<form:select path="roles" multiple="true" cssClass="txt_textbox" cssStyle="width:150px;height:59px">
									<c:forEach items='${userRoles}' var="role">
										<form:option id="userRole" value='${role.id}'>${role.name}</form:option>
									</c:forEach>
								</form:select>
							</td>
							<td class="txt_adminblack"></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b><form:label path="reportingLead">Reporting :</form:label></b></td>
							<td class="txt_adminblack">
								<form:select path="reportingLead" cssClass="txt_textbox" cssStyle="width:150px">
									<c:forEach items='${teamLeaders}' var="teamLeader">
										<form:option id="teamLeader" value='${teamLeader.id}'>${teamLeader.firstName} ${teamLeader.lastName}</form:option>
									</c:forEach>
								</form:select>
							</td>
							<td class="txt_adminblack"></td>
						</tr>
						
		</table>
	</div>
	<table style="width:900px;" align="left" >
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
									<td colspan="2" width="19%">&nbsp;</td>
									<td>&nbsp;</td>
									<td><input id="saveMember" style="width:140px;" type="submit" value="Add Member" class="button"/></td>
									<td>&nbsp;</td>
						</tr>
						<tr>
								<td colspan="4">&nbsp;</td>
						</tr>
					</table>
	</div>
</form:form>
</body>
