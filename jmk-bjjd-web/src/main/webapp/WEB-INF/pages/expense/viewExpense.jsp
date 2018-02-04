<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net/el"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
					<table	class="border_admin1" style="width:990px;" align="center" >
						 <tr>
							<td style="text-align:center" class="legend"><B>Expense Details</B></td>
						</tr>
					</table>
					<table style="width:990px;" align="center" >
						<tr>
							<td>
								<display:table name="expenseList" id="expense" pagesize="3" export="true" sort="list">
									<display:column property="id" title="Voucher No" sortable="true" headerClass="sortable" />
									<display:column property="paidTo" title="Paid To" sortable="true" headerClass="sortable" />
									<display:column property="description" title="Description" sortable="true" headerClass="sortable" />
									<display:column property="amount" title="Amount" sortable="true" headerClass="sortable" />
								</display:table>
							</td>
							
						</tr>
					</table>
</body>
