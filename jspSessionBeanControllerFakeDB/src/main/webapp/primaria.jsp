<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="businessDelegate" class="es.manzano.ejemplo.jspjdbc.business.BusinessDelegate" scope="session"/>
<jsp:getProperty name="businessDelegate" property="reset"/>
<jsp:setProperty name="businessDelegate" property="id" param="id"/>
<jsp:setProperty name="businessDelegate" property="campo1" param="campo1"/>
<jsp:setProperty name="businessDelegate" property="campo2" param="campo2"/>
<jsp:setProperty name="businessDelegate" property="campo3" param="campo3"/>
<jsp:setProperty name="businessDelegate" property="operacion" param="operacion"/>


<%-- <c:set var="saveStatus" value="${user.save()}" /> --%>

<html>
<head>
 <title>Aplicación</title>
</head>
<body>
<div align="center">
<h1>Principal</h1>
</div>
<br/>
<%@include file="menu.jsp" %>
<%@include file="mensaje.jsp" %>
<div align="center">
<table>
        <tr>
            <th>ID</th>
            <th>Campos 1</th>
            <th>Campos 2</th>
            <th>Campos 3</th>
        </tr>
        <c:forEach items="${businessDelegate.getAllPrimaria()}" var="elemento">
            <tr>
                <td>${elemento.id}</td>
                <td>${elemento.campo1}</td>
                <td>${elemento.campo2}</td>
                <td>${elemento.campo3}</td>
                <td>
                    <form action="primariaform.jsp" method="post">
                        <input type="hidden" name="id" value="${elemento.id}">
                        <input type="submit" name="operacion" value="Edit"  >
                    </form>
                <td>
                    <form action="primaria.jsp" method="post">
                        <input type="hidden" name="id" value="${elemento.id}">
                        <input type="submit" name="operacion" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>        
    </table>
                    <form action="primariaform.jsp" method="post">                        
                        <input type="submit" name="operacion" value="Nuevo">
                    </form>
    
    
</div>
</body>
</html>
