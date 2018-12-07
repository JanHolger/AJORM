package eu.bebendorf.ajorm.wrapper;

import java.sql.*;

public class MySQL extends BaseSQL {

    private Connection c = null;
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;


    public MySQL(String ho, int po, String db, String un, String pw) {
        host=ho;
        port=po;
        database=db;
        username=un;
        password=pw;
    }

    public Connection getConnection(){
        if(c==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + port + "/" + this.database + "?user=" + this.username + "&password=" + this.password + "&autoReconnect=" + true + "&failOverReadOnly=false&maxReconnects=" + 5);
            } catch (SQLException e) {
                System.out.println("Fehler: bei openConnection()[MySQL.java]  SQLException   " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Fehler: bei openConnection()[MySQL.java]  ClassNotFoundException");
            }
        }
        try {
            if(c==null||c.isClosed()){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    c = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + 3306 + "/" + this.database + "?user=" + this.username + "&password=" + this.password + "&autoReconnect=" + true + "&failOverReadOnly=false&maxReconnects=" + 5);
                } catch (SQLException e) {
                    System.out.println("Fehler: bei openConnection()[MySQL.java]  SQLException   " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("Fehler: bei openConnection()[MySQL.java]  ClassNotFoundException");
                }
            }
        } catch (SQLException e) {e.printStackTrace();}
        return c;
    }



}

