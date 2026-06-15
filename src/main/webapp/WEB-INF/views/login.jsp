
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Đăng nhập</title>

    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="<c:url value='/web/vendor/bootstrap/css/bootstrap.min.css'/>">

    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

    <!-- CSS custom -->
    <link rel="stylesheet"
          href="<c:url value='/login/style.css'/>">

    <!-- JQuery -->
    <script src="<c:url value='/web/vendor/jquery/jquery.min.js'/>"></script>

    <!-- Bootstrap JS -->
    <script src="<c:url value='/web/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

</head>

<body style="background: #2c7659;">

<div class="container">

    <div class="row justify-content-center align-items-center"
         style="min-height: 100vh;">

        <div class="col-md-5">

            <div class="card shadow-lg border-0"
                 style="border-radius: 15px;">

                <div class="card-body p-5"
                     style="background-color: #35bf76; color: white; border-radius: 15px;">

                    <div class="text-center mb-4">

                        <h2 class="fw-bold">
                            LOGIN
                        </h2>

                        <p class="text-light">
                            Please enter your login and password!
                        </p>

                    </div>

                    <!-- ALERT -->

                    <c:if test="${param.incorrectAccount != null}">
                        <div class="alert alert-danger">
                            Username or password incorrect
                        </div>
                    </c:if>

                    <c:if test="${param.accessDenied != null}">
                        <div class="alert alert-danger">
                            You are not authorized
                        </div>
                    </c:if>

                    <c:if test="${param.sessionTimeout != null}">
                        <div class="alert alert-warning">
                            Session Timeout
                        </div>
                    </c:if>

                    <!-- FORM -->

                    <form action="j_spring_security_check"
                          method="post"
                          id="formLogin">

                        <!-- USERNAME -->

                        <div class="mb-3">

                            <label class="form-label">
                                Username
                            </label>

                            <input type="text"
                                   class="form-control"
                                   id="userName"
                                   name="j_username"
                                   placeholder="Tên đăng nhập">

                        </div>

                        <!-- PASSWORD -->

                        <div class="mb-3">

                            <label class="form-label">
                                Password
                            </label>

                            <input type="password"
                                   class="form-control"
                                   id="password"
                                   name="j_password"
                                   placeholder="Mật khẩu">

                        </div>

                        <!-- REMEMBER -->

                        <div class="form-check mb-3">

                            <input class="form-check-input"
                                   type="checkbox"
                                   id="remember">

                            <label class="form-check-label"
                                   for="remember">

                                Remember Password

                            </label>

                        </div>

                        <!-- FORGOT -->

                        <div class="mb-3 text-end">

                            <a href="#"
                               class="text-white text-decoration-none">

                                Forgot password?

                            </a>

                        </div>

                        <!-- BUTTON -->

                        <div class="d-grid">

                            <button type="submit"
                                    class="btn btn-primary">

                                Đăng nhập

                            </button>

                        </div>

                    </form>

                    <!-- SOCIAL -->

                    <div class="text-center mt-4">

                        <a href="#" class="text-white me-3">
                            <i class="fab fa-facebook-f"></i>
                        </a>

                        <a href="#" class="text-white me-3">
                            <i class="fab fa-twitter"></i>
                        </a>

                        <a href="#" class="text-white">
                            <i class="fab fa-google"></i>
                        </a>

                    </div>

                    <!-- SIGN UP -->

                    <div class="text-center mt-4">

                        <p>
                            Don't have an account?

                            <a href="#"
                               class="text-white fw-bold">

                                Sign Up

                            </a>

                        </p>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

</body>

</html>