/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Digital;

/**
 *
 * @author hoandk
 */
public class DigitalDAO extends DBContext {

    //Get top 1 news from database order by time post
    public Digital getTop1() {
        try {
            Digital d = new Digital();
            String sql = "SELECT top 1[ID]\n"
                    + "      ,[title]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "      ,[author]\n"
                    + "      ,[timePost]\n"
                    + "      ,[shortDes]\n"
                    + "  FROM [digital] "
                    + "ORDER BY timePost DESC";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                d.setID(rs.getInt("ID"));
                d.setTitle(rs.getString("title"));
                d.setDescription(rs.getString("description"));
                d.setImage(rs.getString("image"));
                d.setAuthor(rs.getString("author"));
                d.setTimePost(rs.getDate("timePost"));
                d.setShortDes(rs.getString("shortDes"));
            }
            return d;
        } catch (SQLException ex) {
            Logger.getLogger(DigitalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //get news by id
    public Digital getbyID(int id) {
        try {
            Digital d = new Digital();
            String sql = "SELECT [ID]\n"
                    + "      ,[title]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "      ,[author]\n"
                    + "      ,[timePost]\n"
                    + "      ,[shortDes]\n"
                    + "  FROM [digital] WHERE ID = ? ";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                d.setID(rs.getInt("ID"));
                d.setTitle(rs.getString("title"));
                d.setDescription(rs.getString("description"));
                d.setImage(rs.getString("image"));
                d.setAuthor(rs.getString("author"));
                d.setTimePost(rs.getDate("timePost"));
                d.setShortDes(rs.getString("shortDes"));
            }
            return d;
        } catch (SQLException ex) {
            Logger.getLogger(DigitalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //Get top 5 news from database except the news has ID=id order by time post 

    public ArrayList<Digital> getTop5(int id) {
        try {
            ArrayList<Digital> list = new ArrayList<>();
            String sql = "SELECT top 5 [ID]\n"
                    + "      ,[title]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "      ,[author]\n"
                    + "      ,[timePost]\n"
                    + "      ,[shortDes]\n"
                    + "  FROM [digital]\n"
                    + "  WHERE ID != (?)\n"
                    + "  ORDER BY timePost DESC";
//                    + "  (SELECT  ID FROM digital WHERE ID = ?)"
//                  
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Digital d = new Digital();
                d.setID(rs.getInt("ID"));
                d.setTitle(rs.getString("title"));
                d.setDescription(rs.getString("description"));
                d.setImage(rs.getString("image"));
                d.setAuthor(rs.getString("author"));
                d.setTimePost(rs.getDate("timePost"));
                d.setShortDes(rs.getString("shortDes"));
                list.add(d);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DigitalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //get list of news base on search txt and index of page
    public ArrayList<Digital> getPagePaging(String search, int index) {
        try {
            ArrayList<Digital> list = new ArrayList<>();
            String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER \n"
                    + "(ORDER BY timePost DESC) AS r,* \n"
                    + "FROM digital  WHERE title LIKE '%" + search + "%')\n"
                    + "AS a WHERE r \n"
                    + "BETWEEN ?*3-2 and ?*3";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, index);
            stm.setInt(2, index);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Digital d = new Digital();
                d.setID(rs.getInt("ID"));
                d.setTitle(rs.getString("title"));
                d.setDescription(rs.getString("description"));
                d.setImage(rs.getString("image"));
                d.setAuthor(rs.getString("author"));
                d.setTimePost(rs.getDate("timePost"));
                d.setShortDes(rs.getString("shortDes"));
                list.add(d);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DigitalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //get number of news can search by searchtxt
    public int countRowDigital(String search) {
        String sql = "SELECT COUNT(*) AS TotalRow FROM digital\n";

        if (search != null) {
            sql += "WHERE title LIKE '%" + search + "%'";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("TotalRow");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

//    public static void main(String[] args) {
//        Digital d = new Digital();
//        DigitalDAO dDAO = new DigitalDAO();
//        d = dDAO.getTop1();
//        ArrayList<Digital> list = dDAO.getPagePaging("a", 1);
//        int a = dDAO.countRowDigital("");
//        System.out.println(a);
//    }
}
