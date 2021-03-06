<%--
  Created by IntelliJ IDEA.
  User: Loredana Isuf
  Date: 3/24/2020
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<!doctype html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Masini</title>
</head>
<body>

<div class="container" style="background-color: #f2f2f2;">


    <!-- As a heading -->
    <nav class="navbar navbar-light" style="background-color: #660020; margin-right: -15px; margin-left: -15px;">

        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent">
                <div class="p-4">
                    <a href="?action=list">
                        <p   style=" color: white;">Utilizatori</p>
                    </a>
                    <a href="?action=masini">
                        <p   style=" color: white;">Masini</p>
                    </a>
                    <a href="?action=remorci">
                        <p   style=" color: white;">Remorci</p>
                    </a>
                    <a href="?action=remorci">
                        <p  style=" color: white;">Vezi locatiile</p>
                    </a>
                </div>
            </div>
            <nav class="navba">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </nav>
        </div>

        <span class="navbar-brand mb-0 h1" style=" color: white; margin-left: -200px;">~SC FIRMA TRANS SRL~</span>


        <form class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Cauta" aria-label="Search">

        </form>


    </nav>

    <div class="row">

        <div class="col-sm-12">

        </div>

    </div>

    <div class="row"></div>
    <div class="row">
        <table class="table table-striped" style="margin-top: 40px;">
            <thead class=".thead-dark">
            <tr>
                <th scope="col">NrInmatriculare</th>
                <th scope="col">Marca</th>
                <th scope="col">AnFabricatie</th>
                <th scope="col">NrInmatriculareRemorca</th>
                <th scope="col">ITP</th>
                <th scope="col">AsigurareRCA</th>
                <th scope="col">AsigurareCasco</th>
                <th scope="col">Rovigieta</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="masina" items="${requestScope.CarsTobeDisplayed}">
                <tr>
                    <th>${masina.nrInmatriculare}</th>
                    <td>${masina.marca}</td>
                    <td>${masina.anulFabricatiei}</td>
                    <td>${masina.nrInmatriculareRemorca}</td>
                    <td>${masina.itp}</td>
                    <td>${masina.rca}</td>
                    <td>${masina.casco}</td>
                    <td>${masina.rovignieta}</td>
                    <td>
                        <!-- <button type="button" class="btn btn-success" onclick="window.location.href='?action=edit&id=${utilizator.id}'">Edit</button> -->
                        <a href="?action=editMasina&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Editeaza" style="color: rgba(0, 0, 0, 0.54); "><span class="material-icons">edit</span> </a>
                        <a href="?action=deleteMasina&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Sterge" style="color: rgba(0, 0, 0, 0.54); "><span class="material-icons">delete</span></a>
                        <!--<a href="?action=delete&id=${utilizator.id}">
                            <button type="button" class="btn btn-danger">Delete</button>
                        </a> -->

                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>

    <div class="row">

        <div class="col-sm-12">
            <a href="?action=addMasina">
                <button type="button" style="background-color: #660020; color:white; padding: 10px; margin: 20px;" >Adauga masina</button>
            </a>


        </div>

    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>

