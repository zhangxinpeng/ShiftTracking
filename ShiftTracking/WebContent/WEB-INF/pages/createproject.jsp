<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shift Tracking | Create Project</title>
</head>
<body>


<s:form action="project-create.action">
Project ID: <s:textfield name="projectId"></s:textfield>
<br >
Project name: <s:textfield name="projectName"></s:textfield>
<br >
Project Manager: <s:textfield name="projectManager"></s:textfield>

Project Admins: <s:textfield name="admins"></s:textfield>
<br >


<s:submit>Create</s:submit>
</s:form>
</body>
</html>