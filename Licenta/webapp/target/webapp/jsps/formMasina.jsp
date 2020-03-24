<%--
  Created by IntelliJ IDEA.
  User: Loredana Isuf
  Date: 3/24/2020
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="row" style="align-items: center; margin-top: 100px;">

        <div class="col-sm-6" style="background-color: #f2f2f2;" >
            <h1 style="text-align: center; color: #660020; margin-top: 60px; margin-right: 5px;">~Adaugare Masina~</h1>
                <div style="align-items: center; background-color: #f2f2f2;">
                    <form method="post">
                        <div class="form-group">
                            <label for="nrInmatriculare" style="margin-top: 30px;">Numarul de inmatriculare</label>
                            <input type="text"class="form-control" id="nrInmatriculare"  name="nrInmatriculareMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.nrInmatriculare}">
                        </div>
                        <div class="form-group">
                            <label for="marca">Marca</label>
                            <input type="text"class="form-control" id="marca"  name="marcaMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.marca}">
                        </div>
                        <div class="form-group">
                            <label for="an">Anul fabricatiei</label>
                            <input type="text"class="form-control" id="an"  name="anMasina" value="${requestScope.CarToEdit.anulFabricatiei}">
                        </div>
                        <div class="form-group" style="margin-bottom: 10px">
                            <label for="nrInmatriculareR" >Numarul de inmatriculare remorca</label>
                            <input type="text"class="form-control" id="nrInmatriculareR"  name="nrInmatriculareRemorca" aria-describedby="emailHelp" value="${requestScope.CarToEdit.nrInmatriculareRemorca}">
                        </div>


                </div>
        </div>

        <div class="col-sm-6">
            <div style="align-items: center; background-color: #f2f2f2;  padding: 15px;">

                    <div class="form-group">
                        <label for="itp"style="margin-top: 30px;" >ITP valabil pana </label>
                        <input type="date"class="form-control" id="itp"  name="itpMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.itp}">
                    </div>
                    <div class="form-group">
                        <label for="rca" >Asigurare RCA valabila pana</label>
                        <input type="date"class="form-control" id="rca"  name="rcaMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.rca}">
                    </div>
                    <div class="form-group">
                        <label for="casco" >Asigurare CASCO valabila pana</label>
                        <input type="date"class="form-control" id="casco"  name="cascoMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.casco}">
                    </div>
                    <div class="form-group">
                        <label for="rovignieta">Rovignieta valabila pana</label>
                        <input type="date" class="form-control" id="rovignieta" name="rovignietaMasina" value="${requestScope.CarToEdit.rovignieta}">
                    </div>

                    <!-- <button type="submit" class="btn btn-primary" style="margin-bottom: 60px;">${requestScope.CarToEdit eq null ? 'Adauga' : 'Editeaza'}</button> -->
                    <button type="submit" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 90px;" >${requestScope.CarToEdit eq null ? 'Adauga' : 'Editeaza'}</button>

                </form>
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
