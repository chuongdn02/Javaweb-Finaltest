<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <style>
        body {
            background-color: whitesmoke;
            font-size: 30px;
            width: 1280px;
            position: relative;
            left: 50%;
            transform: translateX(-50%);
        }
        h3   {
            color: red;
        }
        .title td{
            height: 50px;
        }
        td    {
            color: black;
            width: 200px;
            padding-left: 15px;
        }
        .container{
            border: solid 2px;
            position: relative;
        }
        .child-1{
            width: 25%;
            position: absolute;
            padding-left: 50px;
            border: solid 2px;
            margin-left: -2px;
            margin-top: -2px;
            height: 100%;
        }
        .child-2{
            width: 70%;
            position: relative;
            right: -30%;
        }
        .child-2 a{
            text-decoration: none;
            font-style: italic;
        }
        a:hover{
            color: orange;
        }
        .child-2 a:hover{
            color: red;
        }
        .addBtn{
            margin: 20px;
            width: 150px;
            height: 50px;
            border: solid 1px;
            border-radius: 5px;
            background-color: orange;
            position: relative;
            right: -70%;
        }
        .addBtn:hover {
            background-color: yellowgreen;
            color: orange;
        }
        .addBtn:hover a{
            color: chocolate;
        }
        .addBtn a{
            position: absolute;
            left: 16%;
            top: 16%;
            text-decoration: none;
            font-style: normal;
        }
        a{
            color: black;
        }


    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <div class="container">
            <div class="child-1">
                <h3 >Nhóm sản phẩm</h3>
                <a href="ViewServlet">ALL</a><br>
                <a href="OptionServlet?option=Guitars">Guitars</a><br>
                <a href="OptionServlet?option=Basses">Basses</a><br>
                <a href="OptionServlet?option=Drums">Drums</a>
            </div>
            <div class="child-2">
                <h3>Danh sách sản phẩm</h3>
                <table border="1">
                    <tr class="title" style="background-color: orange">
                        <td>STT</td>
                        <td>Tên SP</td>
                        <td>Giá SP</td>
                        <td>Thao tác</td>
                    </tr>
                    <c:forEach var="p" items="${list}">
                        <tr>
                            <td>${p.stt}</td>
                            <td>${p.name}</td>
                            <td>${p.price}</td>
                            <td><a href="DeleteServlet?id=${p.id}">Delete</a></td>
                        </tr>
                    </c:forEach>    
                </table>
                <div class="addBtn">
                    <a href="formAdd.jsp">Tạo mới</a>
                </div>
            </div>
        </div>
    </body>
</html>
