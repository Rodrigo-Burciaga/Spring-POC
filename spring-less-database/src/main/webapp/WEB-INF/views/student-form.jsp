<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student registration</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First Name: <form:input path="firstName"/>
    <br>
    Last Name: <form:input path="lastName"/>
    <input type="submit" value="enviar">
    <br>
    <br>
    Country:
    <form:select path="country">
        <form:options items="${student.countries}"/>
    </form:select>
    <br>
    <br>
    <form:radiobuttons path="language" items="${student.languages}"/>
    <br>
    <br>
    <form:checkboxes path="operatingSystemsSelected" items="${student.operatingSystems}"/>

</form:form>
</body>
</html>