<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/expense/uploadExpenses" var="uploadExpenses" htmlEscape="true"/>
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
<form action="${uploadExpenses}" method="POST" enctype="multipart/form-data">
					<table	class="border_admin1" style="width:990px;" style="text-align: center;" >
						 <tr>
							<td style="text-align:center" class="legend"><B>Expense Upload Form</B></td>
						</tr>
					</table>
	
    					<table style="width:990px;" style="text-align: center;" >
						 <tr>
							<td width="19%">&nbsp;</td>
							<td align="left" class="txt_adminblack"><b>Upload the file:</b></td>
							<td class="txt_adminblack"><input type="file" id="fileUpload" name="fileUpload" />
								Press here to upload the file!
							<td>&nbsp;</td>
						</tr>
			</table>
				<table style="width:900px;" align="left" >
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
									<td colspan="2" width="19%">&nbsp;</td>
									<td>&nbsp;</td>
									<td><input id="uploadExpense" style="width:140px;" type="submit" value="Add Member" class="button"/></td>
									<td>&nbsp;</td>
						</tr>
						<tr>
								<td colspan="4">&nbsp;</td>
						</tr>
					</table>
</form>
</body>
