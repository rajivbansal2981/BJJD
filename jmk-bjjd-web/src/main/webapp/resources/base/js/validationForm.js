/*******************************************************
* Client  : Godfrey Phillips India Ltd (GPI)
* Project : Merchandising Management System
* File    : validationForm.js
* Created : March 12, 2007
* Purpose : Validate Form Text Inputs values
*******************************************************/

var M_REG_EXP_NAMES = [
						"Number",
						"AlphanumericWithUnderscoreMask",
						"AlphanumericWithUnderscoreMasknLength",
						"NounNamesMask",
						"GeneralTextMask",
						"Email"
					  ];
var M_REG_EXP = [
				 "^[0-9]*$",
				 "^[a-zA-Z]{1}[a-zA-Z0-9_]*$",
				 "^[a-zA-Z]{1}[a-zA-Z0-9_]*.{5,30}$",
				 "^[a-zA-Z]{1}[a-zA-Z0-9\_' ]*$",
				 "^[a-zA-Z0-9\-\.\,\/#()\n\r ]*$",
				 "^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$"
				 ];

/*
	 @Purpose : Function to validate text against the predefined regular expressions
	  @param object (paramObj : form field object )
	 @param string (p_strPredefinedRegexName : predefined Reguler Expression Name)
	 @exception : No Action
*/
function validateTextAgnstExpr(paramObj, p_strPredefinedRegexName){
	try{
		if(p_strPredefinedRegexName!="" && paramObj!=null){
			for(var i = 0; i < M_REG_EXP_NAMES.length; i++){
				if(p_strPredefinedRegexName==M_REG_EXP_NAMES[i]){
					var lobjRegExp = new RegExp(M_REG_EXP[i]);
					return lobjRegExp.test(paramObj.value.trim()); // return true if matches the expression; else returns false
				}
			}
			alert("Regular Expression Name not found");
		}else{
			return false;
		}
	}
	catch(e){
		alertException("validationForm.js|validateTextAgnstExpr",e);
	}
}
/*
	 @Purpose : Function to validate text against the custom regular expressions
	 @param object (paramObj : form field object )
	 @param string (p_strCustomRegexPattern : Reguler Expression pattren text)
	 @exception : No Action
*/
function validateTextAgnstCustomExpr(paramObj,p_strCustomRegexPattern){
	try{
		if(p_strCustomRegexPattern!=""  && paramObj!=null){
			var lobjRegExp = new RegExp(p_strCustomRegexPattern);
			return lobjRegExp.test(paramObj.value.trim()); // return true if matches the expression; else returns false
		}else{
			return false;
		}
	}catch(e){
		alertException("validationForm.js|validateTextAgnstCustomExpr",e);
	}
}