<%--
  Created by IntelliJ IDEA.
  User: Loredana Isuf
  Date: 3/13/2020
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Adaugare</title>
</head>
<body style="background-color:#660020 " >
<!-- style="background-image: url('./bg2.jpg');" -->
<div class="container">
    <div class="row" style="align-items: center; margin-top: 10px;">
        <div class="col-sm-3">
            <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2> -->
        </div>
        <div class="col-sm-6" style="background-color: #f2f2f2;" >
            <h1 style="text-align: center; color: #660020; margin-top: 30px;">~Adaugare Angajat~</h1>
                <div style="align-items: center; background-color: #f2f2f2;">
                    <form method="post">
                        <div class="form-group">
                            <label for="nume" style="margin-top: 30px;" >Nume</label>
                            <input type="text"class="form-control" id="nume"  name="numeUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.nume}">
                        </div>
                        <div class="form-group">
                            <label for="prenume" style="color: black;">Prenume</label>
                            <input type="text"class="form-control" id="prenume"  name="prenumeUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.prenume}">
                        </div>
                        <div class="form-group">
                            <label for="id_masina">Numarul de inmatriculare al masinii</label>
                            <input type="text"class="form-control" id="id_masina"  name="idMasinaUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.id_masina}">
                        </div>
                        <div class="form-group">
                            <label for="telefon" >Telefon</label>
                            <input type="text"class="form-control" id="telefon"  name="telefonUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.telefon}">
                        </div>
                        <div class="form-group">
                            <label for="email" >Email</label>
                            <input type="text"class="form-control" id="email"  name="emailUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.email}">
                        </div>
                        <div class="form-group">
                            <label for="parola">Parola</label>
                            <input type="text" class="form-control" id="parola" name="parolaUtilizator" value="${requestScope.UserToEdit.parola}">
                        </div>

                        <!-- <button type="button" class="btn btn-primary" style="margin-bottom: 60px;">${requestScope.UserToEdit eq null ? 'Adauga' : 'Edit'}</button> -->
                        <button type="submit" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;" >${requestScope.UserToEdit eq null ? 'Adauga' : 'Editeaza'}</button>

                    </form>
                </div>

                <div class="col-sm-3">
                    <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2> -->
                </div>

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
