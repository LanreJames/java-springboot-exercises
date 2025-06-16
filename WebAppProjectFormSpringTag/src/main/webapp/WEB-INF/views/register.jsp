<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #121212;
            color: #e0e0e0;
            margin: 0;
            padding: 0;
        }

        .form-container {
            width: 400px;
            margin: 60px auto;
            background-color: #1e1e1e;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.6);
        }

        h2 {
            text-align: center;
            color: #90caf9;
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin: 12px 0 5px;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #2a2a2a;
            color: #fff;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background-color: #2196f3;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #1976d2;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Registration Form</h2>
        <form:form method="post" modelAttribute="emps">
            <label for="id">ID</label>
            <form:input path="id" required="true"/>

            <label for="ename">Name</label>
            <form:input path="ename" required="true" />

            <label for="ecity">City</label>
            <form:input path="ecity" required="true" />

            <label for="esalary">Salary</label>
            <form:input path="esalary" step="0.01" required="true" />
            

            <input type="submit" value="register" />
        </form:form>
    </div>
</body>
</html>
