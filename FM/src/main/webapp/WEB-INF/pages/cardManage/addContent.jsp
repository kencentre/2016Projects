<%@ page import="cn.edu.tju.scs.fm.domain.CardItem" %>
<%@ page import="java.math.BigDecimal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2016/3/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="card" class="cn.edu.tju.scs.fm.domain.Card"/>
<h2>
  添加银行卡
</h2>
<hr>

<form class="form-horizontal"  name="cardForm" infoState>
  <div class="form-group">
    <label for="cardNumber"  class="col-sm-2 control-label">卡号：</label>
    <div class="col-sm-6">
      <input name="cardNumber" value="${card.cardNumber}" type="text" class="form-control" id="cardNumber" placeholder="卡号" required>
    </div>
  </div>
  <div class="form-group">
    <label for="items" class="col-sm-2 control-label">包含项目:</label>
    <div class="col-sm-9">
      <ul id="items"  class="list-group">
        <c:forEach var="cardItem" items="${card.items}">
          <li  class="list-group-item">
            <div class="col-xs-3 ">
              <input type="text"  class="form-control" placeholder="项目名称" value="${cardItem.itemName}">
            </div>
            <div class="col-xs-3">
              <input id="owner" type="text" class="form-control" placeholder="负责人" value="${cardItem.itemOwner}">
            </div>
            <div class="col-xs-3">
              <input id="itemCount" type="text" class="form-control" placeholder="项目金额" value="${cardItem.itemCount}">
            </div>
            <!--<div class="col-xs-3">-->
            <!--<input id="itemCount" type="number" ng-model="item.itemCount"-->
            <!--class="form-control" placeholder="项目金额">-->
            <!--</div>-->

            <button type="button" class="btn btn-info"> 删除 </button>
          </li>
        </c:forEach>

        <br>
        <button type="button" class="btn btn-info" onclick="addItem()"> 添加 </button>
      </ul>
    </div>
  </div>
  <!--<div class="form-group" hidden>-->
  <!--<label for="money" class="col-sm-2 control-label">银行卡总金额：</label>-->
  <!--<div class="col-sm-6">-->
  <!--<input ng-model="card.money"  type="number" class="form-control" id="money" placeholder="金额" required>-->
  <!--</div>-->
  <!--</div>-->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-6">
      <button type="submit" class="btn btn-info" ng-disabled="cardForm.$invalid">确定</button>
      <button type="reset" class="btn btn-default">取消</button>
    </div>
  </div>
</form>

<script type="javascript">
  var items = "";
  function addItem(){
    items +=
     $("items").
  }

  $(document).ready(function() {
    addItem();
  });

</script>