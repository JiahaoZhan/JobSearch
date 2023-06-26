package com.example.jobsearch.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class MySQLTableCreation {
    public static void main(String[] args) {
        try {


            // Step 1 Connect to MySQL.
            System.out.println("Connecting to " + MySQLDBUtil.URL);
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DriverManager.getConnection(MySQLDBUtil.URL);


            if (conn == null) {
                return;
            }


            // Step 2 Drop tables in case they exist.
            Statement statement = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS keywords";
            statement.executeUpdate(sql);


            sql = "DROP TABLE IF EXISTS history";
            statement.executeUpdate(sql);


            sql = "DROP TABLE IF EXISTS jobs";
            statement.executeUpdate(sql);


            sql = "DROP TABLE IF EXISTS users";
            statement.executeUpdate(sql);




            // Step 3 Create new tables
            sql = "CREATE TABLE jobs ("
                    + "job_id VARCHAR(255) NOT NULL,"
                    + "title VARCHAR(255),"
                    + "company VARCHAR(255),"
                    + "salary_is_predicted VARCHAR(255),"
                    + "location VARCHAR(255),"
                    + "redirect_url VARCHAR(255),"
                    + "latitude VARCHAR(255),"
                    + "longitude VARCHAR(255),"
                    + "contract_time VARCHAR(255),"
                    + "description VARCHAR(255),"
                    + "created VARCHAR(255),"
                    + "category VARCHAR(255),"
                    + "salary_max VARCHAR(255),"
                    + "salary_min VARCHAR(255),"
                    + "PRIMARY KEY (job_id)" //primary key for jobs
                    + ")";
            statement.executeUpdate(sql);


            sql = "CREATE TABLE users ("
                    + "username VARCHAR(255) NOT NULL,"
                    + "password VARCHAR(255) NOT NULL,"
                    + "first_name VARCHAR(255),"
                    + "last_name VARCHAR(255),"
                    + "PRIMARY KEY (username)"  //primary key for users
                    + ")";
            statement.executeUpdate(sql);


            sql = "CREATE TABLE keywords ("
                    + "job_id VARCHAR(255) NOT NULL,"
                    + "keyword VARCHAR(255) NOT NULL,"
                    + "PRIMARY KEY (job_id, keyword)," //normally we dont use tow columns to set up a table
                    + "FOREIGN KEY (job_id) REFERENCES jobs(job_id)"
                    + ")";
            statement.executeUpdate(sql);


            sql = "CREATE TABLE history ("
                    + "username VARCHAR(255) NOT NULL,"
                    + "job_id VARCHAR(255) NOT NULL,"
                    + "last_favor_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                    + "PRIMARY KEY (username, job_id),"
                    + "FOREIGN KEY (username) REFERENCES users(username),"
                    + "FOREIGN KEY (job_id) REFERENCES jobs(job_id)"
                    + ")";
            statement.executeUpdate(sql);


            // Step 4: insert fake user 1111/3229c1097c00d497a0fd282d586be050
            sql = "INSERT INTO users VALUES('1111', '3229c1097c00d497a0fd282d586be050', 'John', 'Smith')";
            statement.executeUpdate(sql);


            conn.close();
            System.out.println("Import done successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
