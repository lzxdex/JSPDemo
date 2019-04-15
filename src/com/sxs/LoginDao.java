package com.sxs;

import java.sql.*;

public class LoginDao {
    String URL = "jdbc:mysql://127.0.0.1:3306/mydata";
    String NAME = "root";
    String PWD = "";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     *  连接mysql
     * @param name 用户名
     * @param pwd   密码
     * @return 1登录成功 0 登录失败  -1系统错误
     */
    public int login(String name ,String pwd){
        Connection conn =null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            conn= DriverManager.getConnection(URL,NAME,PWD);
            String sql = "select * from users where UserName = ? and PasswordCode = ? and IsUse = 1";
            pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,pwd);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                if(rs.getInt(1)!=0){
                    count = 1;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
    public int register(String name ,String pwd){
        Connection conn =null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            conn = DriverManager.getConnection(URL,NAME,PWD);
            String sql = "INSERT into users (UserName,PasswordCode,IsUse) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,pwd);
            pstmt.setInt(3,1);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
//    /**
//     *  连接sql
//     * @param name 用户名
//     * @param pwd   密码
//     * @return 1登录成功 0 登录失败  -1系统错误
//     */
//    public int login(String name ,String pwd){
//        Connection conn =null;
//        PreparedStatement pstmt = null;
//        int count = 0;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //不知道为什么我这里不能写成"jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=book"
//            conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=INewlandCloud","sa","123");
//            String sql = "select * from UserData where name = ? and password = ? and IsUse = 1";
//            pstmt  = conn.prepareStatement(sql);
//            pstmt.setString(1,name);
//            pstmt.setString(2,pwd);
//            ResultSet rs = pstmt.executeQuery();
//            if(rs.next()){
//                count = rs.getInt(1);
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//            return -1;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return -1;
//        }finally{
//            if(conn != null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(pstmt != null){
//                try {
//                    pstmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return count;
//    }

}
