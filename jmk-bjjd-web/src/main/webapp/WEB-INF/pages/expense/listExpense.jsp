<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>
<head>
	<spring:url value="/expense/generateExpenseVouchers" var="actionOnExpenseList" htmlEscape="true" />

   <spring:url value="/resources/datatable-1.10.15/js/jquery-1.12.4.min.js"  var="jqueryJs" />
   <spring:url value="/resources/datatable-1.10.15/js/jquery.dataTables.js"  var="datatableJs" />
   <spring:url value="/resources/datatable-1.10.15/js/jquery.dataTables.min.js"  var="datatableMinJs" />
   <spring:url value="/resources/datatable-1.10.15/js/dataTables.jqueryui.min.js"  var="jqueryUIMinJs" />
   <spring:url value="/resources/datatable-1.10.15/extensions/select-1.2.2/js/dataTables.select.min.js"  var="selectJs" />
   <spring:url value="/resources/datatable-1.10.15/extensions/select-1.2.2/js/dataTables.select.min.js"  var="selectJs" />
   <spring:url value="/resources/datatable-1.10.15/extensions/buttons-13.1/js/dataTables.buttons.min.js"  var="buttonJs" />
   
   <spring:url value="/resources/datatable-1.10.15/css/jquery.dataTables.css" var="jquerydataTablesCss" />
   <spring:url value="/resources/datatable-1.10.15/css/jquery.dataTables.min.css" var="jquerydataTablesMinCss" />
   <spring:url value="/resources/datatable-1.10.15/css/dataTables.jqueryui.min.css" var="jqueryUIMinCss" />
   <spring:url value="/resources/datatable-1.10.15/themes/smoothness/jquery-ui.css" var="jqueryUIThemesCss" />
   <spring:url value="/resources/datatable-1.10.15/extensions/select-1.2.2/css/select.dataTables.min.css" var="selectCss" />
   <spring:url value="/resources/datatable-1.10.15/extensions/buttons-13.1/css/buttons.dataTables.min.css" var="buttonCss" />
   
   <script src="${jqueryJs}" type="text/javascript"></script>
   <script src="${datatableJs}" type="text/javascript"></script>
   <script src="${datatableMinJs}" type="text/javascript"></script>
    <script src="${jqueryUIMinJs}" type="text/javascript"></script>
    <script src="${selectJs}" type="text/javascript"></script>
    <script src="${buttonJs}" type="text/javascript"></script>
    
	<link href="${jquerydataTablesCss}" rel="stylesheet" type="text/css"/>
   <link href="${jquerydataTablesMinCss}" rel="stylesheet" type="text/css"/>
   <link href="${jqueryUIMinCss}" rel="stylesheet" type="text/css"/>
   <link href="${jqueryUIThemesCss}" rel="stylesheet" type="text/css"/>
   <link href="${selectCss}" rel="stylesheet" type="text/css"/>
   <link href="${buttonCss}" rel="stylesheet" type="text/css"/>
</head>


<script type="text/javascript">

$(document).ready(function(){
	var data=eval('${expenseList}');
	var table=$('#example').dataTable({
		"data":data,
		"columns":[
		 {"data":"id"},
		 {"data":"id"},
		 {"data":"dateString"},
		 {"data":"description"},
		 {"data":"amount"}
        ],
        "paging":true,
		"pageLength":10,
		"jQueryUI": true,
		"processing":true,
		"columnDefs": [ 
		{
        "render": function ( data, type, row ) {
            return data.split("#").join("<br/>");
        },
		"targets":3
   		},
   		{
            'targets': 0,
            'render': function (data, type, full, meta){
                return '<input type="checkbox" name="id[]" value="' + $('<div/>').text(data).html() + '">';
            }
         }
		]
	});
});
</script>
<body>
<form id="frm-example" action="${actionOnExpenseList}" method="POST">
					<table align="center" >
						 <tr>
							<td width="19%">&nbsp;</td>
						</tr>
					</table>
					<BR>
					<BR>
					<table	class="legend" align="left" >
						 <tr>
							<td><B>Expense Details</B></td>
						</tr>
					</table>
					<table	class="legend" align="left" >
						 <tr>
							<td>Enter the vouchers numbers to be print:</td>
							<td><input type="text" name="idsToBePrint" /></td>
						</tr>
					</table>
					<table	id="example" class="display" align="center" >
						<thead>
						 <tr>
						 	<th>ID</th>
							<th>Voucher No</th>
							<th>Date</th>
							<th>Description</th>
							<th>Amount</th>
						</tr>
						</thead>
					</table>
					<table align="center" >
					<tr>
									
									<td><input id="printInvoices" style="width:140px;" type="submit" value="Print Expense Vouchers" class="button"/></td>
									
						</tr>
					</table>
					</form>
</body>