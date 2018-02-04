<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page session="true"%>
<spring:url value="/j_spring_security_logout" var="logout" htmlEscape="true"/>
<script type="text/javascript">
	function submitLogoutForm(){
		 document.getElementById("logoutForm").submit();
	}
</script>
<form:form id="logoutForm" method="POST" name="logoutForm" action="${logout}">
	<div class="header_container">
		<div class="header">
			<font class="main_header_font">Bhavya Jag Janni Darbar</font>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
			<font class="txt_adminblue">Welcome : ${pageContext.request.userPrincipal.name} | <a href="javascript:submitLogoutForm()">Logout</a></font>
			</c:if>
		</div>
	</div>
</form:form>