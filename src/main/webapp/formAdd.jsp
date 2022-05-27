

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            width: 800px;
            border: solid 2px;
            position: relative;
            left: 50%;
            transform: translateX(-50%);
            font-size: 30px;
            padding: 0 10px 30px;
        }
        h2{
            text-align: center;
        }
        input , select{
            width: 300px;
            height: 30px;
            border-radius: 10px;
        }
        select{
            height: 35px;
            width: 310px;
            border: solid 2px;
        }
        .submitBtn{
            width: 100px;
            height: 40px;
            border-radius: 5px;
            background-color: orange;
            margin-left: 200px;
            position: relative;
            left: 100%;
        }
        .submitBtn:hover {
            background-color: yellowgreen;
            color: orange;
        }
        table{
            position: relative;
            left: 50%;
            transform: translateX(-50%);
        }
    </style>
    <body>
        <h2>Thêm sản Phẩm</h2>
        <table>
            <form action="AddServlet" id="add">
                <tr>
                    <td>Tên sản phẩm</td>
                    <td><input name="name" type="text"/></td>
                </tr>
                <tr>
                    <td>Giá sản phẩm</td>
                    <td><input name="price" type="text"/></td>
                </tr>
                <tr>
                    <td>Nhóm sản phẩm</td>
                    <td>
                        <select name="category" id="category" form="add">
                            <option value="Guitars">Guitars</option>
                            <option value="Basses">Basses</option>
                            <option value="Drums">Drums</option>
                        </select>
                    </td>                
                </tr>
                <tr>
                    <td>
                        <input class="submitBtn" type="submit" value="Thêm">
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
