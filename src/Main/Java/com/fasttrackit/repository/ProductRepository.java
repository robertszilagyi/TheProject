//package com.fasttrackit.repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductRepository
//{
//
//
//    public static void createProduct(String username, String password ) throws ClassNotFoundException, SQLException
//    {
//
//// 2. define connection params to db
//        final String URL = "jdbc:postgresql://54.93.65.5:5432/robertszilagyi";
//        final String USERNAME = "fasttrackit_dev";
//        final String PASSWORD = "fasttrackit_dev";
//
//        // 3. obtain a connection
//        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//        // 4. create a query statement
//        PreparedStatement pSt = conn.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?,?)");
//        pSt.setString(1, "username");
//        pSt.setString(2, "password");
//
//        // 5. execute a prepared statement
//        int rowInserted = pSt.executeUpdate();
//
//        // 6. close the objects
//        pSt.close();
//        conn.close();
//    }
//
//    private static List findAllProduct() throws ClassNotFoundException, SQLException
//        {
//            Class.forName("");
//
//            final String URL = "jdbc:postgresql://54.93.65.5:5432/robertszilagyi";
//            final String USERNAME = "fasttrackit_dev";
//            final String PASSWORD = "fasttrackit_dev";
//
//            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            Statement st = conn.createStatement();
//
//            ResultSet rs = st.executeQuery("");
//
//            List<Users> listOfUsers = new ArrayList();
//            while (rs.next())
//            {
//                Users u = new Users();
//                u.setUsername(rs.getString("username"));
//                u.setPassword(rs.getString("password"));
//
//                listOfUsers.add(u);
//
//
//            }
//
//            rs.close();
//            st.close();
//            conn.close();
//
//            return listOfUsers;
//        }
//
//    public void updateProduc() throws ClassCastException, SQLException
//    {
//// 2. define connection params to db
//        final String URL = "jdbc:postgresql://54.93.65.5:5432/robertszilagyi";
//        final String USERNAME = "fasttrackit_dev";
//        final String PASSWORD = "fasttrackit_dev";
//
//        // 3. obtain a connection
//        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//        // 4. create a query statement
//        PreparedStatement pSt = conn.prepareStatement("UPDATE USERS SET PASSWORD=? WHERE USERNAME=?"); //so we have 3 params
//        pSt.setString(1, "da");
//        pSt.setString(2, "da1");
//
//
//
//        // 5. execute a prepared statement
//        int rowsUpdated = pSt.executeUpdate();
//
//        // 6. close the objects
//        pSt.close();
//        conn.close();
//    }
//
//    public void deleteProduct() throws ClassNotFoundException, SQLException
//    {
//        final String URL = "jdbc:postgresql://54.93.65.5:5432/ionel7";
//        final String USERNAME = "fasttrackit_dev";
//        final String PASSWORD = "fasttrackit_dev";
//
//        // 3. obtain a connection
//        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//        // 4. create a query statement
//        PreparedStatement pSt = conn.prepareStatement("DELETE FROM USERS WHERE id=?");
//        pSt.setLong(1, 50);
//
//        // 5. execute a prepared statement
//        int rowsDeleted = pSt.executeUpdate();
//        System.out.println(rowsDeleted + " rows were deleted.");
//        // 6. close the objects
//        pSt.close();
//        conn.close();
//    }
//
//
//}
