<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <style>
        body {
            background-color: whitesmoke;
            font-size: 30px;
        }
        h3   {
            color: red;
        }
        td    {
            color: black;
            width: 200px;
            height: 30px;
        }
        .divC{
            border: solid 2px;
            position: relative;
        }
        .div1{
            width: 40%;
            position: absolute;
        }
        .div2{
            width: 58%;
            position: absolute;
            right: 0;
        }
        table tr td p{
                 
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="divC">
            <div class="div1">
                <h3 >Nhóm sản phẩm</h3><br>
                <a href="OptionServlet?option=Guitars">Guitars</a><br>
                <a href="OptionServlet?option=Basses">Basses</a><br>
                <a href="OptionServlet?option=Drums">Drums</a>
            </div>
            <div class="div2">
                <h3>Danh sách sản phẩm</h3>
                <table border="1">
                    <form action="">
                        <tr style="background-color: orange">
                            <td><p>STT</p></td>
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
                    </form>
                </table>
                <div>
                    <a href="formAdd.jsp">Tạo mới</a>
                </div>
            </div>
        </div>
    </body>
</html>
