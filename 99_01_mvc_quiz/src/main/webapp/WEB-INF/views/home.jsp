<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<c:set var="url" value="<%= request.getContextPath() %>"/>
	<title>Home</title>
	<link href="<c:url value="/resources/css/test.css"/>" rel="stylesheet">
	<link href="${ url }/css/test02.css" rel="stylesheet" >
	<script type="text/javascript" src="${ url }/js/test.js"></script>
</head>	
<body>
url : ${url }<br>
<c:url value="/resources/img/car01.png" var="path"/> <!-- 이미지 불러오기 -->
path : ${ path }<br>
req : <%=request.getContextPath() %><br>
page : ${ pageContext.request.contextPath }/resources/img/car01.png<br>
<img src="${path }" width="100" height="100">
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<button type="button" onclick="test()">click</button>
</body>
</html>
