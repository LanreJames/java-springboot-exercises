<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Response</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f2f2f2;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .response-box {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
        }

        .info {
            margin-top: 20px;
        }

        .info p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="response-box">
        <h2>Employee Submitted</h2>
        <div class="info">
            <p><strong>ID:</strong> ${emp.id}</p>
            <p><strong>Name:</strong> ${emp.ename}</p>
            <p><strong>City:</strong> ${emp.ecity}</p>
            <p><strong>Salary:</strong> ${emp.esalary}</p>
        </div>
    </div>
</body>
</html>
