package ba.unsa.etf.rpr.lab9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {

    private static GeografijaDAO instance = null;
    private Connection conn;
    private String url;
    private PreparedStatement gg,dajGradove, dajDrzavuPoId, dajDrzavuPoNazivu, brisiGrad, brisiDrzavu,dodajGrad,dodajDrzavu,izmijeniGrad,dajGrad;

    public static GeografijaDAO getInstance(){
        if(instance==null) instance=new GeografijaDAO();
        return instance;
    }
    private GeografijaDAO(){
        try{
            //url = "jdbc:sqlite:" + System.getProperty("user.host") + ".lv9.db";
            //conn = DriverManager.getConnection(url);
            conn= DriverManager.getConnection("jdbc:sqlite:src/lv9.db");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            regenerisiBazu();
        }
        try{
            dajDrzavuPoId=conn.prepareStatement("SELECT * FROM drzava WHERE id=?");
            dajDrzavuPoNazivu=conn.prepareStatement("SELECT * FROM drzava WHERE naziv=?");
            brisiGrad=conn.prepareStatement("DELETE FROM grad WHERE drzava=?");
            brisiDrzavu=conn.prepareStatement("DELETE FROM drzava WHERE naziv=?");
            dodajGrad=conn.prepareStatement("INSERT INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (?,?,?,?)");
            dodajDrzavu=conn.prepareStatement("INSERT INTO drzava (id,naziv,glavni_grad) VALUES (?,?,?)");
            izmijeniGrad=conn.prepareStatement("UPDATE grad SET naziv=?,broj_stanovnika=?,drzava=? WHERE id=?");
            dajGrad=conn.prepareStatement("SELECT * FROM grad WHERE drzava=?");
            dajGradove=conn.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            gg=conn.prepareStatement("SELECT g.* FROM grad g, drzava d WHERE d.naziv=? AND g.id=d.glavni_grad");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void regenerisiBazu() {

        Scanner ulaz=null;
        try{
            ulaz=new Scanner(new FileInputStream("C:/Users/User/IdeaProjects/lv9/src/lv9.db"));
            String sqlUpit="";
            while(ulaz.hasNext()){
                sqlUpit+=ulaz.nextLine();
                if ( sqlUpit.length() > 1 && sqlUpit.charAt( sqlUpit.length()-1 ) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
            ulaz.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }


    }



    public void vratiNaDefault() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM grad");
        stmt.executeUpdate("DELETE FROM drzava");
        regenerisiBazu();
    }



    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> gradoviLista=new ArrayList<>();
        try {
            ResultSet rs = dajGradove.executeQuery();
            while (rs.next()) {
                Grad g=new Grad(rs.getInt(1), rs.getString(2),rs.getInt(3),null);
                g.setDrzava(dajDrzavu(rs.getInt(4),g));
                gradoviLista.add(g);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return gradoviLista;
    }

    private Drzava dajDrzavu(int i, Grad g){
        try{
            dajDrzavuPoId.setInt(1,i);
            ResultSet rs=dajDrzavuPoId.executeQuery();
            if(!rs.next()) return null;
            return new Drzava(rs.getInt(1), rs.getString(2), g);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Grad glavniGrad(String drzava){
        try {
            gg.setString(1,drzava);
            ResultSet rs = gg.executeQuery();
            if(!rs.next()) return null;
            Grad g=new Grad(rs.getInt(1),rs.getString(2), rs.getInt(3),null);
            g.setDrzava(dajDrzavu(rs.getInt(4),g));
            return g;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private void obrisiDrzavu(String drzava){
        try{
            dajDrzavuPoNazivu.setString(1,drzava);
            ResultSet rs=dajDrzavuPoNazivu.executeQuery();
            int pom=0;
            if(rs.next()){
                pom=rs.getInt(1);
                brisiGrad.setInt(1,pom);
                brisiGrad.executeUpdate();
                brisiDrzavu.setString(1,drzava);
                brisiDrzavu.executeUpdate();
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void dodajGrad (Grad grad){
        try {
            dodajGrad.setInt(1, grad.getId());
            dodajGrad.setString(2, grad.getNaziv());
            dodajGrad.setInt(3,grad.getBrojStanovnika());
            dodajGrad.setInt(4,grad.getDrzava().getId());
            dodajGrad.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void dodajDrzavu(Drzava drzava){
        try {
            dodajDrzavu.setInt(1,drzava.getId());
            dodajDrzavu.setString(2,drzava.getNaziv());
            dodajDrzavu.setInt(3,drzava.getGlavniGrad().getId());
            dodajDrzavu.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void izmijeniGrad (Grad grad){
        try {
            izmijeniGrad.setInt(4, grad.getId());
            izmijeniGrad.setString(1,grad.getNaziv());
            izmijeniGrad.setInt(2,grad.getBrojStanovnika());
            izmijeniGrad.setInt(3,grad.getDrzava().getId());
            izmijeniGrad.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    Drzava nadjiDrzavu(String drzava){
        try {
            dajDrzavuPoNazivu.setString(1, drzava);
            ResultSet rs=dajDrzavuPoNazivu.executeQuery();
            if(!rs.next()) return null;
            Drzava d=new Drzava(rs.getInt(1), rs.getString(2),null);
            int gg=rs.getInt(3);
            dajGrad.setInt(1,gg);
            ResultSet rs2=dajGrad.executeQuery();
            Grad g=new Grad(rs2.getInt(1), rs2.getString(2),rs2.getInt(3),null);
            g.setDrzava(d);
            d.setGlavniGrad(g);
            return d;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }



}
