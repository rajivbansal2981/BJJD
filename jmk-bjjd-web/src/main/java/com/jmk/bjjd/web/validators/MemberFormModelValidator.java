package com.jmk.bjjd.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.web.form.MemberFormModel;

@Component
public class MemberFormModelValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return MemberFormModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberFormModel memberModel = (MemberFormModel) target;
		if (memberModel.getSevas() != null) {
			for (int i = 0; i < memberModel.getSevas().size(); i++) {
				SevaModel sevaModel = memberModel.getSevas().get(i);
				if (sevaModel.getDescription() == null
						|| "".equals(sevaModel.getDescription().trim())) {
					errors.rejectValue("sevas[" + i + "].description",
							"seva.details.error",
							"Enter the correct seva details");
				}
			}
		}
	}

}
