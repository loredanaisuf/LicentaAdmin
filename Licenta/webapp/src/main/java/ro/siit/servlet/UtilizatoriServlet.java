package ro.siit.servlet;



import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import ro.siit.model.Masina;
import ro.siit.model.Remorca;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceMasina;
import ro.siit.service.ServiceRemorca;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/utilizatori"})
public class UtilizatoriServlet extends HttpServlet {
    private ServiceUtilizator serviceUtilizator;
    private ServiceMasina serviceMasina;
    private ServiceRemorca serviceRemorca;

    @Override
    public void init() throws ServletException {
        this.serviceUtilizator = new ServiceUtilizator();
        this.serviceMasina = new ServiceMasina();
        this.serviceRemorca =  new ServiceRemorca();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (null == action) ? "list" : action;
        switch (action){
            case("addMasina"):
                req.getRequestDispatcher("/jsps/formMasina.jsp").forward(req,resp);
                action = "null";
                break;

            case("editMasina"):
                String nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                Masina masina = serviceMasina.getCar(nrInmatriculare);
                req.setAttribute("CarToEdit", masina);
                req.getRequestDispatcher("/jsps/formMasina.jsp").forward(req,resp);
                break;

            case("deleteMasina"):
                nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                serviceMasina.deleteCar(nrInmatriculare);

            case("masini"):
                List<Masina> masini = this.serviceMasina.getCars();
                req.setAttribute("CarsTobeDisplayed", masini);
                req.getRequestDispatcher("/jsps/listaMasini.jsp").forward(req, resp);
                break;

            case("addRemorca"):
                req.getRequestDispatcher("/jsps/formRemorca.jsp").forward(req,resp);
                action = "null";
                break;

            case("editRemorca"):
                nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                Remorca remorca = serviceRemorca.getTrail(nrInmatriculare);
                req.setAttribute("TrailToEdit", remorca);
                req.getRequestDispatcher("/jsps/formRemorca.jsp").forward(req,resp);
                break;

            case("deleteRemorca"):
                nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                serviceRemorca.deleteTrail(nrInmatriculare);

            case("remorci"):
                List<Remorca> remorci = this.serviceRemorca.getTrails();
                req.setAttribute("TrailsTobeDisplayed", remorci);
                req.getRequestDispatcher("/jsps/listaRemorci.jsp").forward(req, resp);
                break;


            case("add"):
                req.getRequestDispatcher("/jsps/formUtilizator.jsp").forward(req,resp);
                action = "null";
                break;

            case("edit"):
                String userId = req.getParameter("id");
                Utilizator utilizator = serviceUtilizator.getUser(UUID.fromString(userId));
                req.setAttribute("UserToEdit", utilizator);
                req.getRequestDispatcher("/jsps/formUtilizator.jsp").forward(req,resp);
                action = "null";
                break;

            case("delete"):
                userId = req.getParameter("id");
                System.out.println("id-ul este: " + userId);
                serviceUtilizator.deleteUser(UUID.fromString(userId));
                action = "null";



            default:
                List<Utilizator> utilizatori = this.serviceUtilizator.getUsers();
                req.setAttribute("UsersTobeDisplayed", utilizatori);
                req.getRequestDispatcher("/jsps/listaUtilizatori.jsp").forward(req,resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (null == action) ? "list" : action;
        switch (action){
            case("addRemorca"):
                String idRemorca = req.getParameter("nrInmatriculareRemorca");
                Integer anulFabricatieiR = Integer.valueOf(req.getParameter("anFabricatieRemorca"));
                String itpR = req.getParameter("itpRemorca");
                serviceRemorca.addTrail(new Remorca(idRemorca, anulFabricatieiR, itpR));


                List<Remorca> remorci = this.serviceRemorca.getTrails();
                req.setAttribute("TrailsTobeDisplayed", remorci);
                req.getRequestDispatcher("/jsps/listaRemorci.jsp").forward(req, resp);
                break;

            case("editRemorca"):
                idRemorca = req.getParameter("nrInmatriculareRemorca");
                anulFabricatieiR = Integer.valueOf(req.getParameter("anFabricatieRemorca"));
                itpR = req.getParameter("itpRemorca");
                serviceRemorca.updateTrail(new Remorca(idRemorca, anulFabricatieiR, itpR));

                remorci = this.serviceRemorca.getTrails();
                req.setAttribute("TrailsTobeDisplayed", remorci);
                req.getRequestDispatcher("/jsps/listaRemorci.jsp").forward(req, resp);
                break;


            case("addMasina"):
                String nrInmatriculare = req.getParameter("nrInmatriculareMasina");
                String marca = req.getParameter("marcaMasina");
                System.out.println("marca : " + marca);
                System.out.println("string an : " + req.getParameter("anMasina"));
                String anulFabricatiei = req.getParameter("anMasina");
                System.out.println("int an : " + anulFabricatiei);
                String nrInmatriculareRemorca = req.getParameter("nrInmatriculareRemorca");
                String itp = req.getParameter("itpMasina");
                System.out.println("itp : " + itp);
                String rca = req.getParameter("rcaMasina");
                String casco = req.getParameter("cascoMasina");
                String rovignieta = req.getParameter("rovignietaMasina");
                serviceMasina.addCar(new Masina(nrInmatriculare, marca, anulFabricatiei, nrInmatriculareRemorca, itp, rca, casco, rovignieta));

                List<Masina> masini = this.serviceMasina.getCars();
                req.setAttribute("CarsTobeDisplayed", masini);
                req.getRequestDispatcher("/jsps/listaMasini.jsp").forward(req, resp);
                break;

            case("editMasina"):
                nrInmatriculare = req.getParameter("id");
                marca = req.getParameter("marcaMasina");
                System.out.println("marca : " + marca);
                anulFabricatiei = req.getParameter("anMasina");
                nrInmatriculareRemorca = req.getParameter("nrInmatriculareRemorca");
                itp = req.getParameter("itpMasina");
                System.out.println("marca : " + itp);
                rca = req.getParameter("rcaMasina");
                casco = req.getParameter("cascoMasina");
                rovignieta = req.getParameter("rovignietaMasina");
                serviceMasina.updateCar(new Masina(nrInmatriculare, marca, anulFabricatiei, nrInmatriculareRemorca, itp, rca, casco, rovignieta));

                masini = this.serviceMasina.getCars();
                req.setAttribute("CarsTobeDisplayed", masini);
                req.getRequestDispatcher("/jsps/listaMasini.jsp").forward(req, resp);
                break;


            case("add"):
                String nume = req.getParameter("numeUtilizator");
                String prenume = req.getParameter("prenumeUtilizator");
                String telefon = req.getParameter("telefonUtilizator");
                String idMasina = req.getParameter("idMasinaUtilizator");
                String email = req.getParameter("emailUtilizator");
                String parola = req.getParameter("parolaUtilizator");
                serviceUtilizator.addUser(new Utilizator(UUID.randomUUID(), nume, prenume, telefon, idMasina, email, parola));

                break;

            case("edit"):
                String userId = req.getParameter("id");
                System.out.println("id-ul este: " + userId);
                nume = req.getParameter("numeUtilizator");
                prenume = req.getParameter("prenumeUtilizator");
                telefon = req.getParameter("telefonUtilizator");
                idMasina = req.getParameter("idMasinaUtilizator");
                email = req.getParameter("emailUtilizator");
                parola = req.getParameter("parolaUtilizator");
                serviceUtilizator.updateUser(new Utilizator(UUID.fromString(userId),nume, prenume, telefon, idMasina, email, parola));
                break;
        }

        List<Utilizator> utilizatori = this.serviceUtilizator.getUsers();
        req.setAttribute("UsersTobeDisplayed", utilizatori);
        req.getRequestDispatcher("/jsps/listaUtilizatori.jsp").forward(req,resp);

    }
}
