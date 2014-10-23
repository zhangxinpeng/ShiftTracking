<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shift Tracking | Login</title>
</head>
<body>
You are welcome

<s:form action="emp-loginValidate.action">
Email: <s:textfield name="email" label="Email"></s:textfield> <s:text name="e.g. tom@cn.ibm.com"></s:text>
<br />
Password: <s:textfield name="password" label="password" type="password"></s:textfield>
<br />

<s:submit></s:submit>
</s:form>
</body>
</html>