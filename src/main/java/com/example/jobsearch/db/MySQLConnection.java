package com.example.jobsearch.db;


import com.example.jobsearch.entity.job.Job;

import java.sql.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


//users click at "save" / "unsave" on frontend, and we will need servlets to update db on backend
public class MySQLConnection {
    private Connection conn;


    public MySQLConnection() {
        //try, catch: try{} and if fails then do catch{}
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(MySQLDBUtil.URL);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    public void savejob(Job job) {
//        if (conn == null) {
//            System.err.println("DB connection failed");
//            return;
//        }
//        String insertjobSql = "INSERT IGNORE INTO jobs VALUES (?, ?, ?, ?, ?)"; //"?" : placeholder, columns
//        //ignore: if there's a same job existed, we ignore it
//        try {
//            PreparedStatement statement = conn.prepareStatement(insertjobSql);
//            statement.setString(1, job.getId());
//            statement.setString(2, job.getTitle());
//            statement.setString(3, job.getLocation());
//            statement.setString(4, job.getRedirect_url()); //SQL starts from 1, not 0
//            statement.executeUpdate(); //insert data completed
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        String insertKeywordSql = "INSERT IGNORE INTO keywords VALUES (?, ?)"; //"?" : placeholder, columns
//        // ignore: if there's a same job existed, we ignore it
//        try {
//            for (String keyword : job.getKeywords()) {
//                PreparedStatement statement = conn.prepareStatement(insertKeywordSql);
//                statement = conn.prepareStatement(insertKeywordSql);
//                statement.setString(1, job.getId());
//                statement.setString(2, keyword);
//                statement.executeUpdate();
//            } //we use for loop to insert keywords
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//    }
//    public void setFavoritejobs(String userId, Job job) {
//        if (conn == null) {
//            System.err.println("DB connection failed");
//            return;
//        }
//        //save job to db first
//        savejob(job);
//        String sql = "INSERT IGNORE INTO history (user_id, job_id) VALUES (?, ?)"; //time will automatically filled in
//        try {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, userId);
//            statement.setString(2, job.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void unsetFavoritejobs(String userId, String jobId) {
//        if (conn == null) {
//            System.err.println("DB connection failed");
//            return;
//        }
//        //no need to delete jobs from db
//        String sql = "DELETE FROM history WHERE user_id = ? AND job_id = ?"; //?: input arguments
//        //delete all jobs which match the user id and job id
//        try {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, userId);
//            statement.setString(2, jobId);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public Set<String> getFavoritejobIds(String userId) {
//        if (conn == null) {
//            System.err.println("DB connection failed");
//            return new HashSet<>();
//        }
//
//
//        Set<String> favoritejobs = new HashSet<>();
//
//
//        try {
//            String sql = "SELECT job_id FROM history WHERE user_id = ?";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, userId);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                String jobId = rs.getString("job_id");
//                favoritejobs.add(jobId);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        return favoritejobs;
//    }
//
//
//    public Set<Job> getFavoritejobs(String userId) {
//        if (conn == null) {
//            System.err.println("DB connection failed");
//            return new HashSet<>();
//        }
//        Set<Job> favoritejobs = new HashSet<>();
//        Set<String> favoritejobIds = getFavoritejobIds(userId);
//
//
//        String sql = "SELECT * FROM jobs WHERE job_id = ?";
//        try {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            for (String jobId : favoritejobIds) {
//                statement.setString(1, jobId);
//                ResultSet rs = statement.executeQuery();
//                if (rs.next()) {
//                    favoritejobs.add(new Job(rs.getString("job_id")
//                            ,rs.getString("title")
//                            ,rs.getString("location")
//                       salary_min = salary_min;
//                            ,rs.getString("redirect_url")
//                            ,rs.getString("latitude")
//                            ,rs.getString("longitude")
//                            ,rs.getString("contract_time")
//                            ,rs.getString("description")
//                            ,rs.getString("created")
//                            ,rs.getString("category")
//                            ));
//
//
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return favoritejobs;
//    }
//    public Set<String> getKeywords(String jobId) {
//        if (conn == null) {
//            System.err.println("DB connection failed");
//            return Collections.emptySet();
//        }
//        Set<String> keywords = new HashSet<>();
//        String sql = "SELECT keyword from keywords WHERE job_id = ? ";
//        try {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, jobId);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                String keyword = rs.getString("keyword");
//                keywords.add(keyword);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return keywords;
//    }
    public String getFullname(String userId) {
        if (conn == null) {
            System.err.println("DB connection failed");
            return "";
        }
        //set up an empty name
        String name = "";
        //get first name and last name, and combine them together
        String sql = "SELECT first_name, last_name FROM users WHERE user_id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                name = rs.getString("first_name") + " " + rs.getString("last_name");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return name;
    }
    //check database to verify log in
    public boolean verifyLogin(String userId, String password) {
        if (conn == null) {
            System.err.println("DB connection failed");
            return false;
        }
        //need to verify both ID and password
        String sql = "SELECT user_id FROM users WHERE user_id = ? AND password = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    //insert user
    public boolean addUser(String userId, String password, String firstname, String lastname) {
        if (conn == null) {
            System.err.println("DB connection failed");
            return false;
        }


        String sql = "INSERT IGNORE INTO users VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, password);
            statement.setString(3, firstname);
            statement.setString(4, lastname);


            return statement.executeUpdate() == 1; //1 --> true  0 --> false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
