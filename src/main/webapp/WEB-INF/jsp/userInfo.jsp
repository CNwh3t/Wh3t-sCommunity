<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="header.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>

<base href="<%=basePath%>"/>
<div id="main">


</div>
<div style="text-align: center">

    <table align="center">
        <tr>
            <th>用户名</th>
            <td>${user.userName}</td>
        </tr>
        <tr>
            <th>创建时间</th>
            <td>${user.createTime}</td>
        </tr>
        <tr>
            <th>性别</th>
            <td>${user.gender}</td>
        </tr>
        <tr>
            <th colspan="2">头像</th>
            <td>${user.image}</td>
            <td>
                <form action="/upload" enctype="multipart/form-data" method="post">
                    <input type="file" name="image"/>
                    <input type="submit" value="上传头像"/>
                </form>
            </td>
        </tr>
    </table>

</div>

<div>
    <form action="/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="image"/>
        <br/>
        <input type="submit" value="上传头像"/>
    </form>
</div>