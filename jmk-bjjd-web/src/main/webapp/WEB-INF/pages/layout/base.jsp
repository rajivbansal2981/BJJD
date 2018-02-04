<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel="stylesheet" media="screen" href="<c:url value="/resources/base/css/layout.css" />" type="text/css" />
		<link rel="stylesheet" media="screen" href="<c:url value="/resources/base/css/style.css" />" type="text/css" />
		<script src="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/jquery-ui-1.11.4/external/jquery/jquery.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.js" />" type="text/javascript"></script>
		<link rel="stylesheet" href="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.min.css" />" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/resources/jquery-ui-1.11.4/jquery-ui.css" />" type="text/css"/>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
<body>
	<table style="width:100%;align:center;cellpadding:0px;cellspacing:0px">
		<tr>
			<td>
				<table style="width:100%;align:center;cellpadding:0px;cellspacing:0px">
					<tr>
						<td><tiles:insertAttribute name="header"/></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table style="width:100%;align:center;cellpadding:0px;cellspacing:0px">
					<tr>
						<td><tiles:insertAttribute name="horizontalMenu"/></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table style="width:100%;align:center;cellpadding:0px;cellspacing:0px">
					<tr>
						<td style="width:10%"><tiles:insertAttribute name="verticalMenu"/></td>
						<td style="width:90%"><tiles:insertAttribute name="body"/></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table style="width:100%;align:center;cellpadding:0px;cellspacing:0px">
					<tr>
						<td><tiles:insertAttribute name="footer"/></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>