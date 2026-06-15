
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>
        <dec:title default="Đăng nhập"/>
    </title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="<c:url value='/web/vendor/bootstrap/css/bootstrap.min.css'/>">

    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet"
          href="<c:url value='/login/style.css'/>">

    <!-- JQuery -->
    <script src="<c:url value='/web/vendor/jquery/jquery.min.js'/>"></script>

    <!-- Bootstrap JS -->
    <script src="<c:url value='/web/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

</head>

<body id="LoginForm" style="background-color: #2c7659;">

<div class="container">

    <dec:body/>

</div>

</body>

</html>