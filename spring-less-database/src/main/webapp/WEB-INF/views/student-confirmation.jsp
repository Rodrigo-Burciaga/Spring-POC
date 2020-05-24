<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Confirmation</title>
</head>
<body>
The Student is confirmed: ${student.firstName} ${student.lastName}
<br>
Selected country: ${student.country}
<br>
Favorite Language: ${student.language}
<br>
    <ul>
        <c:forEach items="${student.operatingSystemsSelected}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>

</body>
</html>