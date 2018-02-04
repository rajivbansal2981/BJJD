<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>BHAVYA JAG JANNI DARBAR</title>
		
		<link rel="stylesheet" media="screen" href="<c:url value="/resources/base/css/layout.css" />" type="text/css" />
		<link rel="stylesheet" media="screen" href="<c:url value="/resources/base/css/style.css" />" type="text/css" />
			
		<script type="text/javascript">
			function submiLoginForm(){
				//document.forms[0].submit();
				 document.getElementById("loginForm").submit();
			}
		</script>
		</head>
	<body>
		<form:form id="loginForm" commandName="userModel" name="loginForm" action="j_spring_security_check" method="POST">
			<table style="width:600px;align:center;cellpadding:0px;cellspacing:0px" align="center" >
						<tr>
							<td align="left" class="header_container" height="60"><h1><font class="main_header_font"><b>Bhavya Jag Janni Darbar</b></font></h1></td>
						</tr>
						<tr>
							<td height="180"></td>
						</tr>
						<tr>
						<td align="center">
							<table style="width:419px;bgcolor:#FFFFFF;height:50px;cellpadding:0px;cellspacing:0px;"  class="border_admin">
								<tr>
									<td colspan="4" class="legend"><B>LOGIN</B></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td  colspan="4" align="left" class="txt_adminblack">${message}</td>
								</tr>
								<tr>
									<td width="19%">&nbsp;</td>
									<td class="txt_adminblack"><b><form:label path="userName">User Name</form:label></b></td>
									<td><form:input id="userName" path="userName" name="userName" size="20" maxlength="50" type="text" cssClass="txt_textbox" cssStyle="width:140px" /></td>
									<td>&nbsp;</td>
							</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td width="19%">&nbsp;</td>
									<td align="left" class="txt_adminblack"><b><form:label path="password">Password </form:label></b></td>
									<td><form:password id="password" path="password" name="password" cssClass="txt_textbox" cssStyle="width:140px" />
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td width="19%">&nbsp;</td>
									<td align="left" class="txt_adminblack"><b><form:label path="userType">User Type </form:label></b></td>
									<td>
										<form:select cssClass="txt_textbox" path="userType">
											<form:option value="MEMBER">MEMBER</form:option>
											<form:option value="GUEST">GUEST</form:option>
										</form:select>
									</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4" align="center"><input id=submitBtn" name="submitBtn" type="submit" onclick="javascript:submiLoginForm();" value="Sign In" class="button"/></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
		</form:form>
	</body>
</html>