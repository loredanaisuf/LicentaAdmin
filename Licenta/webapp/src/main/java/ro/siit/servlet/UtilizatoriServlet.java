package ro.siit.servlet;



import ro.siit.model.Utilizator;
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

    @Override
    public void init() throws ServletException {
        this.serviceUtilizator = new ServiceUtilizator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (null == action) ? "list" : action;
        switch (action){
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
