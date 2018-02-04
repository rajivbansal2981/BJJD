<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<table>
	<tr>
		<td style="height:50px;">&nbsp;</td>
	</tr>
</table>
					<table	class="border_admin1" style="width:990px;" align="center" >
						 <tr>
							<td style="text-align:center" class="legend"><B>Member Details</B></td>
						</tr>
					</table>
    				<table style="width:990px;" align="center" >
						 <tr>
							<td style="text-align:center" class="legend" colspan="4"><B>Basics</B></td>
						</tr>
						<tr>
						<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b>Photo:</b></td>
							<td class="txt_adminblack"><img src="data:image/jpeg;base64,${imageContent}" alt="Photo1" >
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b>First Name</b></td>
							<td class="txt_adminblack">${memberFormModel.firstName}</td>
							<td class="txt_adminblack"></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b>Last Name :</b></td>
							<td class="txt_adminblack">${memberFormModel.lastName}</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b>Date of Birth :</b></td>
							<td class="txt_adminblack">${memberFormModel.dateOfBirth}</td>
							<td class="txt_adminblack"></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
					</table>
</body>
