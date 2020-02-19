<%--使用了JSTL的core库，前缀为c--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这里一定要加上isELIgnored="false",不然无法使用EL表达式${}--%>
<%--language="java"可省略，因为默认值就是java--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--下面这段代码是scriplet，使用了隐式对象pageContext和request，在pageContext中保存了一个属性path--%>
<%--注意path只能在本jsp页面被获取到--%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>Paper列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>论文列表 —— 显示所有论文</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <%--这里直接使用了在index.jsp页面中保存的pageContext.path--%>
            <a class="btn btn-primary" href="${path}/paper/toAddPaper">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>论文编号</th>
                    <th>论文名字</th>
                    <th>论文数量</th>
                    <th>论文详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <%--items为requestScope中的参数list--%>
                <%--<c:forEach var="paper" items="${requestScope.list}" varStatus="status">--%>
                <%--<c:forEach var="paper" items="${requestScope.get('list')}" varStatus="status">--%>
                <c:forEach var="paper" items="${list}" varStatus="status">
                    <tr>
                        <td>${paper.paperId}</td>
                        <td>${paper.paperName}</td>
                        <td>${paper.paperNum}</td>
                        <td>${paper.paperDetail}</td>
                        <td>
                            <%--这里直接使用了在index.jsp页面中保存的pageContext.path--%>
                            <a href="${path}/paper/toUpdatePaper?id=${paper.paperId}">更改</a> |
                            <a href="${path}/paper/del/${paper.paperId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>