<%--
  Created by IntelliJ IDEA.
  User: weixf
  Date: 2017/12/28
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>秒杀商品</title>
</head>
<body>
    <!--
        商品在页面写死，没有读取数据库，考虑后面升级页面静态化
    -->
    <table border="1">
        <tr>
            <td>商品名称</td>
            <td>商品编码</td>
            <td>商品价格</td>
        </tr>

        <tr>
            <td>iphone X 128G ,双卡双待</td>
            <td>iphone X</td>
            <td>￥：8000</td>
        </tr>
        <tr>

            <td>
                <img src="../code/createImageCode">
            </td>
            <td>
                <input type="text" name="checkCode" id="checkCode" size="20"/>
            </td>
            <td>
                <button>秒杀</button>
            </td>
        </tr>
    </table>

</body>
</html>
