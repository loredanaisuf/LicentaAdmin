package ro.siit.service;

import javafx.scene.input.DataFormat;
import ro.siit.model.Masina;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceMasina extends ServiceUtilizator {

    public Date getDate(String startDate){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        return sqlStartDate;
    }

    public void addCar(Masina masina){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO masini(numar_inmatriculare, marca, anul_fabricatiei, numar_inmatriculare_remorca,itp, asigurare_rca, asigurare_casco, rovignieta) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, masina.getNrInmatriculare());
            ps.setString(2, masina.getMarca());
            ps.setString(3, masina.getAnulFabricatiei());
            ps.setString(4, masina.getNrInmatriculareRemorca());
            ps.setDate(5, getDate(masina.getItp()));
            ps.setDate(6, getDate(masina.getRca()));
            ps.setDate(7, getDate(masina.getCasco()));
            ps.setDate(8, getDate(masina.getRovignieta()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(String nrInmatriculare){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Masina> getCars(){
        ArrayList<Masina> masini = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM masini");

            while(rs.next()){
                masini.add(new Masina(rs.getString("numar_inmatriculare"), rs.getString("marca"), rs.getString("anul_fabricatiei"), rs.getString("numar_inmatriculare_remorca"), rs.getString("itp"), rs.getString("asigurare_rca"), rs.getString("asigurare_casco"), rs.getString("rovignieta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return masini;
    }

    public Masina getCar(String nrInmatriculare){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM masini WHERE numar_inmatriculare = ?");
            ps.setString(1, nrInmatriculare);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Masina(rs.getString("numar_inmatriculare"), rs.getString("marca"), rs.getString("anul_fabricatiei"), rs.getString("numar_inmatriculare_remorca"), rs.getString("itp"), rs.getString("asigurare_rca"), rs.getString("asigurare_casco"), rs.getString("rovignieta"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCar(Masina masina){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE masini SET marca = ?, anul_fabricatiei = ?, numar_inmatriculare_remorca = ?, itp = ?, asigurare_rca = ?, asigurare_casco = ? , rovignieta = ? WHERE numar_inmatriculare = ?");
            ps.setString(8, masina.getNrInmatriculare());
            ps.setString(1, masina.getMarca());
            ps.setString(2, masina.getAnulFabricatiei());
            ps.setString(3, masina.getNrInmatriculareRemorca());
            ps.setDate(4, getDate(masina.getItp()));
            ps.setDate(5, getDate(masina.getRca()));
            ps.setDate(6, getDate(masina.getCasco()));
            ps.setDate(7, getDate(masina.getRovignieta()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
