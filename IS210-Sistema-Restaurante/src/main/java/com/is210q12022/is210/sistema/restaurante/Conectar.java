package com.is210q12022.is210.sistema.restaurante;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conectar {
        public static final String URL = "jdbc:sqlserver://is210-sistema-restaurante.database.windows.net:1433;databaseName=dbo;database=Restaurante;user=MasterChief@is210-sistema-restaurante;password={};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    public static final String USER = "devLogin";
    public static final String CLAVE = "is210-2022-student!";
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
