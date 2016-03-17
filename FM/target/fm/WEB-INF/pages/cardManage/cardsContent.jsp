<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<article>
  <h2>选择银行卡</h2>
  <hr>
  <ul class="cards">
    <c:forEach var="card" items="${cards}">
      <li class="card">
        <div><a  target="_self">${card}</a></div>
      </li>
    </c:forEach>
  </ul>
</article>
