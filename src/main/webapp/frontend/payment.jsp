<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: josue
  Date: 15/10/2021
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Title Page-->
    <title>Pago</title>
    <link href="../assets/css/payment.css" rel="stylesheet" media="all">
</head>

<body class="animsition">
    <t:base-page>
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Pago con tarjeta de credito</strong>
                                    <small>Ingrese los detalles de su tarjeta</small>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <label><strong>Cantidad:&nbsp;</strong>${number}</label>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col">
                                            <label><strong>Total:&nbsp;</strong>$${total}</label>
                                        </div>
                                    </div>
                                    <br><hr><br>
                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label for="name">Nombre</label>
                                                <input class="form-control" id="name" type="text" placeholder="Ingrese su nombre">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label for="cardNumber">Número de tarjeta de crédito</label>
                                                <div class="input-group">
                                                    <input id="cardNumber" class="form-control" type="text" placeholder="0000 0000 0000 0000" autocomplete="email">
                                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i class="mdi mdi-credit-card"></i>
                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-4">
                                            <label for="ccmonth">Mes</label>
                                            <select class="form-control" id="ccmonth">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                                <option>8</option>
                                                <option>9</option>
                                                <option>10</option>
                                                <option>11</option>
                                                <option>12</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <label for="ccyear">Año</label>
                                            <select class="form-control" id="ccyear">
                                                <option>2021</option>
                                                <option>2022</option>
                                                <option>2023</option>
                                                <option>2024</option>
                                                <option>2025</option>
                                                <option>2026</option>
                                                <option>2027</option>
                                                <option>2028</option>
                                                <option>2029</option>
                                            </select>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label for="cvv">CVV</label>
                                                <input class="form-control" id="cvv" type="text" placeholder="123">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-center card-footer">
                                    <button id="btnPay" class="au-btn au-btn-icon au-btn--green">
                                        <i class="zmdi"></i>PAGAR</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>
    </t:base-page>

    <script src="../assets/js/payment.js"></script>

    <script type="application/javascript">
        var id = "${id}";
        var list = ${list};
    </script>
</body>

</html>

