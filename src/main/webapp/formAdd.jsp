

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <th>Thêm sản Phẩm</th>
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
                    <input type="submit" name="Thêm">
                </td>
            </tr>
        </form>
    </table>
</body>
</html>
