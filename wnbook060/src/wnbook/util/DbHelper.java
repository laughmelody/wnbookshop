package wnbook.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbHelper {
    private static String url;
    private static String user;
    private static String password;
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String driver = bundle.getString("jdbc.driver");
        url = bundle.getString("jdbc.url");
        user = bundle.getString("jdbc.user");
        password = bundle.getString("jdbc.password");

//        Properties p =new Properties();
//        try {
//            p.load(DbHelper.class.getClassLoader().getResourceAsStream("db.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String driver = p.getProperty("jdbc.driver");
//        url = p.getProperty("jdbc.url");
//        user = p.getProperty("jdbc.user");
//        password = p.getProperty("jdbc.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        public static Connection getConnection(){
            try {
                return DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
}
