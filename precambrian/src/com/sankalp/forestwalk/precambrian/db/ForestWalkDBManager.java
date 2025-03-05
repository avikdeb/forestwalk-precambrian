package com.sankalp.forestwalk.precambrian.db;

import java.sql.*;

public class ForestWalkDBManager {

    private Connection connection;
    private String url;
    private String schema;
    private String user;
    private String password;

    public String getUrl() {
        return url;
    }

    public String getSchema() {
        return schema;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public ForestWalkDBManager() {
        connection = null;
        url = "jdbc:mysql://localhost:3306";
        schema = "forestwalk_pc";
        user = "root";
        password = "root";
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(getUrl()
                    +"/"+getSchema(),
                    getUser(),
                    getPassword());
            if (connection==null) {
                System.out.println("[ERROR] Database connection is NULL.");
            }
        } catch (Exception e) {
            System.out.println("[ERROR] Exception caught. Please refer stack trace.");
            e.printStackTrace();
        }
        return connection;
    }

    public void closeMySQLConnection(Connection conn) {
        try {
            if (conn!=null) {
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // INSERT new user
    public void createUser(Connection conn, String username) throws SQLException {
        String insertSQL = "INSERT INTO forestwalk_pc.user (username) VALUES (?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(insertSQL);

            // Set parameters
            pstmt.setString(1, username);
            int rowAffected = pstmt.executeUpdate();
            System.out.println("[INFO] [INSER user] Row affected : "
                    +rowAffected
                    +", user : "
                    +username);

        } catch(SQLException e){
            e.printStackTrace();
        }
        pstmt.close();
    }

    // Get user id by username
    public int getUserIdByUsername(Connection conn, String username) throws SQLException {
        String selectSQL = "SELECT iduser FROM forestwalk_pc.user WHERE username = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int iduser = 0;
        try {
            pstmt = conn.prepareStatement(selectSQL);

            // Set parameters
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                iduser = rs.getInt("iduser");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        rs.close();
        pstmt.close();
        return iduser;
    }
}
