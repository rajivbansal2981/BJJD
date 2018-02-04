<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<head>
<link rel="stylesheet" media="screen" href="<c:url value="/resources/menu/css/verticalmenu.css" />" type="text/css" ></link>
<script type="text/javascript" src="<c:url value="/resources/menu/js/jquery.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/menu/js/verticalmenu.js" />" ></script>
<spring:url value="/member/viewMemberPage" var="viewMemberPage" htmlEscape="true"/>
<spring:url value="/member/editMemberPage/member/add" var="editMemberPage" htmlEscape="true" />
<spring:url value="/expense/listExpensePage" var="viewExpenseListPage" htmlEscape="true" />
<spring:url value="/expense/uploadExpensePage" var="uploadExpensePage" htmlEscape="true" />
<%-- <spring:url value="/member/editMemberPage?module=member&mode=add" var="editMemberPage" htmlEscape="true" /> --%>
</head>
<table>
	<tr>
		<td height="47"></td>
	</tr>
	
</table>

<nav id='cssmenu'>
<ul>
   <li><a href='#'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Member</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>Manage</span></a>
            <ul>
               <li><a href='${editMemberPage}'><span>Add</span></a></li>
			   <li><a href='${viewMemberPage}'><span>View/Modify</span></a></li>
               <li class='last'><a href='#'><span>Upload Bulk</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Report</span></a>
            <ul>
               <li><a href='#'><span>Basic</span></a></li>
               <li class='last'><a href='#'><span>Detailed</span></a></li>
            </ul>
         </li>
      </ul>
   </li>
    <li class='active has-sub'><a href='#'><span>Guest</span></a>
      <ul>
         <li><a href='#'><span>Manage</span></a></li>
         <li><a href='#'><span>Report</span></a></li>
	 </ul>
   </li>
    <li class='active has-sub'><a href='#'><span>Expense</span></a>
      <ul>
         <li><a href='${uploadExpensePage}'><span>Upload Expenses</span></a></li>
         <li><a href='${viewExpenseListPage}'><span>View Expenses</span></a></li>
	 </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Collection</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>Member Collection</span></a>
            <ul>
               <li><a href='${editMemberPage}'><span>Add/View/Modify</span></a></li>
			   <li><a href='#'><span>Add Multiple</span></a></li>
               <li class='last'><a href='#'><span>Upload Bulk</span></a></li>
            </ul>
         </li>
		 <li class='has-sub'><a href='#'><span>Guest Collection</span></a>
            <ul>
               <li><a href='#'><span>Add/View/Modify</span></a></li>
			   <li><a href='#'><span>Add Multiple</span></a></li>
             </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Report</span></a>
            <ul>
               <li><a href='#'><span>Basic</span></a></li>
               <li class='last'><a href='#'><span>Detailed</span></a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li><a href='#'><span>Darbar Festivals</span></a></li>
   <li><a href='#'><span>Meeting</span></a></li>
   <li><a href='#'><span>Upcoming Projects</span></a></li>
   <li><a href='#'><span>Actions To Be Taken</span></a></li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</nav>
