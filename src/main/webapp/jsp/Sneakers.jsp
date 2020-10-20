<%@ page import="java.util.Queue" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.PriorityQueue" %>
<%@include file="header.jsp"%>
<%@include file="navbar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="list">
    <div class="container">
        <div style="display: flex; flex-direction: row; justify-content: space-between;">
            <h1>Sneakers</h1>
        </div>
        <hr>
        <div class="row">
            <table cellpadding="2" cellspacing="2" border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Photo</th>
                    <th>Price</th>
                    <th>Buy</th>
                </tr>
                <c:forEach var="product" items="${sessionScope.sneaker }">
                    <tr>
                        <td>${product.id }</td>
                        <td>${product.name }</td>
                        <td>
                            <img src="${product.photo }" width="120">
                        </td>
                        <td>${product.price }</td>
                        <td align="center">
                            <input type="hidden" value="${product.name }" name="${product.name }">
                            <a href="${pageContext.request.contextPath }/cart?&action=buy&id=${product.id }">Add to cart</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<style>
    *{
        font-family: 'Patua One', cursive;
    }
    .list{
        margin: 20px;
    }
    .list .container{
        padding: 50px;
    }
    .list .col-md-3{
        opacity: .5;
        transition: .5s;
        transform: scale(.9);
        position: relative;
    }
    .list .col-md-3:hover{
        opacity: 1;
        transform: scale(1);
    }
    .col-md-3:hover .centered{
        opacity: 1;
        transform: scale(3);
    }
    #asd
    {
        position: fixed; width: 100%; z-index: +1;
    }
</style>
<%@include file="footer.jps.jsp"%>
