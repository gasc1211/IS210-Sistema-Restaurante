/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is210q12022.is210.sistema.restaurante;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Cesar Maldonado
 */
public class conexion {
    private Connection connection;
    private ResultSet results;

    private void Connect() {
        String url = "";
        String login = "";
        String password = "";
        try {
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Connection Successful...");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void Disconnect() {
        try {
            connection.close();
            System.out.println("Connection Terminated Successfully...");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void Query(String query){
        try{
            this.Connect();
            Statement request = connection.createStatement();
            results = request.executeQuery(query);
            System.out.println("Query executed successfully...");
        } catch(Exception ex){
            System.out.println("Query failed!");
            System.out.println(ex);
        }
    }

    public ArrayList<userObjectModel> fetchUsersData(){
        ArrayList<userObjectModel> dbResults = new ArrayList<>();
        try {
            Query("SELECT * FROM users");
            while (results.next()) {
                userObjectModel user = new userObjectModel();
                user.setUserId(results.getInt("userId"));
                user.setUsername(results.getString("username"));
                user.setPassword(results.getString("password"));
                user.setUserType(results.getInt("userType"));
                dbResults.add(user);
            }
            this.Disconnect();
            System.out.println("Data fetched successfully...");
        } catch(Exception ex){
            System.out.println("Failed to fetch data!");
            System.out.println(ex);
        }
        return dbResults;
    }

    public ArrayList<productObjectModel> fetchProductsData(){
        ArrayList<productObjectModel> dbResults = new ArrayList<>();
        try {
            Query("SELECT * FROM products");
            while (results.next()) {
                productObjectModel product = new productObjectModel();
                product.setProductId(results.getInt("productId"));
                product.setProductName(results.getString("name"));
                product.setPrice(results.getFloat("price"));
                product.setInventory(results.getInt("inventory"));
                dbResults.add(product);
            }
            this.Disconnect();
            System.out.println("Data fetched successfully...");
        } catch(Exception ex){
            System.out.println("Failed to fetch data!");
            System.out.println(ex);
        }
        return dbResults;
    }

    public ArrayList<invoiceObjectModel> fetchInvoicesData(){
        ArrayList<invoiceObjectModel> dbResults = new ArrayList<>();
        try {
            Query("SELECT * FROM invoices");
            while (results.next()) {
                invoiceObjectModel invoice = new invoiceObjectModel();
                invoice.setInvoiceId(results.getInt("invoiceId"));
                invoice.setDatetime(results.getDate("date"));
                invoice.setSubTotal(results.getFloat("subTotal"));
                invoice.setTaxes(results.getFloat("taxes"));
                invoice.setTotal(results.getFloat("total"));
                dbResults.add(invoice);
            }
            this.Disconnect();
            System.out.println("Data fetched successfully...");
        } catch(Exception ex){
            System.out.println("Failed to fetch data!");
            System.out.println(ex);
        }
        return dbResults;
    }

}

