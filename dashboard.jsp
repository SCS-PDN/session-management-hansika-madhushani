<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.Course" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h2>Welcome, ${username}!</h2>

<h3>Available Courses</h3>
<table border="1">
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Instructor</th>
        <th>Action</th>
    </tr>
    <%
        List<Course> courses = (List<Course>) request.getAttribute("courses");
        if (courses != null) {
            for (Course course : courses) {
    %>
    <tr>
        <td><%= course.getCourseId() %></td>
        <td><%= course.getCourseName() %></td>
        <td><%= course.getInstructor() %></td>
        <td><a href="EnrollServlet?courseId=<%= course.getCourseId() %>">Enroll</a></td>
    </tr>
    <%
            }
        }
    %>
</table>

<h3>Enrolled Courses</h3>
<ul>
    <%
        List<String> enrolledCourses = (List<String>) request.getAttribute("enrolled");
        if (enrolledCourses != null && !enrolledCourses.isEmpty()) {
            for (String cid : enrolledCourses) {
    %>
        <li><%= cid %></li>
    <%
            }
        } else {
    %>
        <li>No courses enrolled.</li>
    <%
        }
    %>
</ul>

<form method="post" action="LogoutServlet">
    <input type="submit" value="Logout">
</form>

</body>
</html>
