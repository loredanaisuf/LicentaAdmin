package ro.siit.service;

import ro.siit.model.Remorca;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceRemorca extends ServiceUtilizator {
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

    public List<Remorca> getTrails(){
        ArrayList<Remorca> remorci = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM remorci");
            while(rs.next()){
                remorci.add(new Remorca(rs.getString("id_remorca"), rs.getInt("anul_fabricatiei"), rs.getString("itp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return remorci;
    }

    public Remorca getTrail(String idRemorca){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM remorci WHERE id_remorca = ?");
            ps.setString(1, idRemorca);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Remorca(idRemorca, rs.getInt("anul_fabricatiei"), rs.getString("itp"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTrail(Remorca remorca){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO remorci(id_remorca, anul_fabricatiei, itp) VALUES (?, ? ,?)");
            ps.setString(1, remorca.getIdRemorca());
            ps.setInt(2, remorca.getAnulFabricatiei());
            ps.setDate(3, getDate(remorca.getItp()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrail(String idRemorca){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM remorci WHERE id_remorca = ?");
            ps.setString(1, idRemorca);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTrail(Remorca remorca){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE remorci SET anul_fabricatiei = ?, itp = ? WHERE id_remorca = ?");
            ps.setString(3, remorca.getIdRemorca());
            ps.setInt(1, remorca.getAnulFabricatiei());
            ps.setDate(2, getDate(remorca.getItp()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
