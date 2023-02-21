<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<c:import url="./template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="./template/header.jsp"></c:import>
<h1>
	zziwon world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:import url="./template/common_js.jsp"></c:import>
</body>
</html>
