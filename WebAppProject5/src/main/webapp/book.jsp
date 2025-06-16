<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crystal Crumbs</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #121212;
            color: #e0e0e0;
            margin: 0;
            padding: 0;
        }

        .container {
            margin: 50px auto;
            padding: 30px;
            width: 500px;
            background-color: #1e1e1e;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.5);
            text-align: center;
        }

        h1 {
            color: #90caf9;
            margin-bottom: 20px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        ul li {
            background-color: #2a2a2a;
            margin: 10px 0;
            padding: 12px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        ul li:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Display Data from Loops</h1>
        <ul>
            <c:forEach var="name" items="${books}">
                <li>${name}</li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
