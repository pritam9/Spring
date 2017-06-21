<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <link rel="shortcut icon" href="favicon.ico" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="<%=request.getContextPath()%>">mHealth</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#page-top">Home</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#team">Team</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#contact">Contact</a>
                    </li>
                    <%
                    	if(request.getSession().getAttribute("user") != null){
                    %>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/dashboard">Dashboard</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/resourcesPage">Resources</a>
                    </li>
                    <%
                    } %>
                    <%
                    	if(request.getSession().getAttribute("user") == null){
                    %>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/login">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/register">Register</a>
                    </li>
                    <%
                    } else {
                     
                    %>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/logout">Logout</a>
                    </li>
                    <% } %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>