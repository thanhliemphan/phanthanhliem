<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <html>
        <style>
          <%@include file="/resources/css/main.css" %>
        </style>
        <jsp:include page="header.jsp" />

        <body>
          <div class="contain pt-10">
                      <!-- Input group -->
                      <div class="mt-10">
                        <p>
                          <c:out value="${msg}" />
                        </p>
                        <c:if test="${empty detailsList}">
                          <p>No data</p>
                        </c:if>
                        <c:if test="${not empty detailsList}">
                          <table class="table">
                            <thead class="thead-dark">
                              <tr>
                                <th scope="col">Order Details Id</th>
                                <th scope="col">Order Id</th>
                                <th scope="col">Order Date</th>
                                <th scope="col">Product Name</th>
                                <th scope="col">Quantity</th>
                              </tr>
                            </thead>
                            <tbody>
                              <c:forEach var="detail" items="${detailsList}" varStatus="e">
                                <tr>
                                  <td>${detail.orderDetailsId}</td>
                                  <td>${detail.order.orderId}</td>
                                  <td>${detail.order.orderDate}</td>
                                  <td>${detail.product.productName}</td>
                                  <td>${detail.quantity}</td>
                              </c:forEach>
                            </tbody>
                          </table>
                        </c:if>
                       <div>
                     </div>
                  </body>
        </body>

        </html>