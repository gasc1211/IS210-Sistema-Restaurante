package com.is210q12022.is210.sistema.restaurante;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbManager {

    private Connection connection;
    private Statement request;
    private ResultSet results;

    private void Connect() {
        String url = "jdbc:sqlserver://is210-sistema-restaurante.database.windows.net:1433;database=Restaurante;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        String login = "devLogin";
        String password = "is210-2022-student!";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Connection Successful...");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println("Connection Failed!");
            System.out.println(ex);
        }
    }

    private void Disconnect() {
        try {
            connection.close();
            System.out.println("Disconnection Successful...");
        } catch (SQLException ex) {
            System.out.println("Disconnection Failed!");
            System.out.println(ex);
        }
    }

    private void executeSQL(String query){
        this.Connect();
        try{
            request = connection.createStatement();
            results = request.executeQuery(query);
            System.out.println("Query executed successfully...");
        } catch(SQLException ex){
            System.out.println("Query failed!");
            System.out.println(ex);
        }
    }

    public ArrayList<userObjectModel> fetchUsersData(){
        ArrayList<userObjectModel> dbResults = new ArrayList<>();
        try {
            this.executeSQL("SELECT * FROM users");
            while (results.next()) {
                userObjectModel user = new userObjectModel();
                user.setUserId(results.getInt("userId"));
                user.setUsername(results.getString("username"));
                user.setPassword(results.getString("password"));
                user.setUserType(results.getInt("userType"));
                dbResults.add(user);
            }
            System.out.println("Data fetched successfully...");
        } catch(SQLException ex){
            System.out.println("Failed to fetch data!");
            System.out.println(ex);
        }
        this.Disconnect();
        return dbResults;
    }

    public ArrayList<productObjectModel> fetchProductsData(){
        ArrayList<productObjectModel> dbResults = new ArrayList<>();
        try {
            this.executeSQL("SELECT * FROM products");
            while (results.next()) {
                productObjectModel product = new productObjectModel();
                product.setProductId(results.getInt("productId"));
                product.setProductName(results.getString("name"));
                product.setPrice(results.getFloat("price"));
                product.setInventory(results.getInt("inventory"));
                dbResults.add(product);
            }
            System.out.println("Data fetched successfully...");
        } catch(SQLException ex){
            System.out.println("Failed to fetch data!");
            System.out.println(ex);
        }
        this.Disconnect();
        return dbResults;
    }

    public ArrayList<invoiceObjectModel> fetchInvoicesData(){
        ArrayList<invoiceObjectModel> dbResults = new ArrayList<>();
        try {
            this.executeSQL("SELECT * FROM invoices");
            while (results.next()) {
                invoiceObjectModel invoice = new invoiceObjectModel();
                invoice.setInvoiceId(results.getInt("invoiceId"));
                invoice.setDatetime(results.getDate("date"));
                invoice.setSubTotal(results.getFloat("subTotal"));
                invoice.setTaxes(results.getFloat("taxes"));
                invoice.setTotal(results.getFloat("total"));
                dbResults.add(invoice);
            }
            System.out.println("Data fetched successfully...");
        } catch(SQLException ex){
            System.out.println("Failed to fetch data!");
            System.out.println(ex);
        }
        this.Disconnect();
        return dbResults;
    }
    
    public Boolean authenticate(userObjectModel user) {
        Boolean authState = false;
        try {
            this.executeSQL("SELECT username, password FROM users WHERE username='" + user.getUsername() + "'");
            results.next();
            if (!user.getPassword().equals(results.getString("password"))){
                throw new SecurityException();
            } else {
                System.out.println("Authentication Succesful....");
                authState = true;
            }
        } catch(SecurityException | SQLException ex){
            System.out.println("Failed to authenticate user!");
            System.out.println(ex);
        }
        this.Disconnect();
        return authState;
    }
    
    public void insertUser(userObjectModel user){
        this.Connect();
        try {
            String query = "INSERT INTO users (username, password, userType) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getUserType());
            statement.execute();
            System.out.println("Insertion Succesful...");
        } catch(SQLException ex) {
            System.out.println("Failed to insert values!");
            System.out.println(ex);
        }
        this.Disconnect();
    }
    
    public void deleteUser(String userId){
        this.Connect();
        try {
            request = connection.createStatement();
            request.execute("DELETE FROM users WHERE userId = '" + userId + "'");
            System.out.println("Deletion Succesful...");
        } catch(SQLException ex) {
            System.out.println("Failed to delete entry!");
            System.out.println(ex);
        }
        this.Disconnect();
    }
    
    public void updateUser(userObjectModel user) {
        this.Connect();
        try {
            String query = ("UPDATE users SET username=?, password=?, userType=? WHERE userId=?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getUserType());
            statement.setInt(4, user.getUserId());
            statement.execute();
            System.out.println("Update Succesful...");
        } catch(SQLException ex) {
            System.out.println("Failed to update entry!");
            System.out.println(ex);
        }
        this.Disconnect();
    }
    
    public  ArrayList<invoiceObjectModel> LastInvoicesData(){
        ArrayList<invoiceObjectModel> dbResults = new ArrayList<>();
        try {
            this.executeSQL("SELECT * FROM invoices WHERE invoiceId=(SELECT max(invoiceId) FROM invoices)");
            while (results.next()) {
                invoiceObjectModel invoice = new invoiceObjectModel();
                invoice.setInvoiceId(results.getInt("invoiceId"));
                invoice.setDatetime(results.getDate("date"));
                invoice.setSubTotal(results.getFloat("subTotal"));
                invoice.setTaxes(results.getFloat("taxes"));
                invoice.setTotal(results.getFloat("total"));
                dbResults.add(invoice);
            }
            System.out.println("Data fetched successfully...");
        } catch(SQLException ex){
            System.out.println("Failed to fetch data!");
            System.out.println(ex);
        }
        this.Disconnect();
        return dbResults;
    }
    
    public boolean registerInvoices(invoiceObjectModel usr){
        this.Connect();
        PreparedStatement ps = null;
        String sql = "INSERT INTO invoices (date, subTotal, taxes, total) VALUES (NOW(),?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setFloat(1, usr.getSubTotal());
            ps.setFloat(2, usr.getTaxes());
            ps.setFloat(3, usr.getTotal());
            ps.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(invoiceObjectModel.class.getName()).log(Level.SEVERE, null, ex);
            this.Disconnect();
            return false;
        }
    }
}
