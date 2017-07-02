<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Cadastro de livros</title>
</head>
<body>

<c:url value="/products" var="url" />

<form action="${url}" method="post">
    <div>
        <label for="title">Título</label>
        <input type="text" name="title" id="title"/>
    </div>
    <div>
        <label for="description">Descrição</label>
        <textarea rows="10" cols="20" name="description"
                  id="description"></textarea>
    </div>

    <div>
        <c:forEach items="${types}" var="bookType" varStatus="status">
            <div>
                <label for="price_${bookType}">${bookType}</label>
                <input type="text" name="prices[${status.index}].value"
                       id="price_${bookType}"/>
               <input type="hidden"
                name="prices[${status.index}].bookType"
                value="${bookType}"/>
            </div>
        </c:forEach>
    </div>

    <div>
        <label for="numberOfPages">Número de páginas</label>
        <input type="text" name="numberOfPages"
               id="numberOfPages"/>
    </div>

    <div>
        <input type="submit" value="Enviar">
    </div>
</form>
</body>
</html>