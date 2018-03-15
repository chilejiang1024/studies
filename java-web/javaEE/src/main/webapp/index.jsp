<%--
  Created by IntelliJ IDEA.
  User: Zhili
  Date: 2018/3/8
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>wahahahaha</title>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
</head>

<body>

<input type="button" onClick="doFind();" value="调用一下"> <br>

<p class="ajaxP">aaaa</p>

<script type="text/javascript">
    function doFind() {
        $.ajax({
            cache: false,
            type: "get",
            url: "/javaee/index",
            async: false,
            error: function (request) {
                alert("发送请求失败！");
            },
            success: function (data) {
                console.log(data);
                $(".ajaxP").html(data);
            }
        });
    }
</script>

</body>
</html>
