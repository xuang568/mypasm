

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    public static Connection getConnection(String db_driver, String db_url, String db_userName, String db_passWord) {
        Connection connection = null;
        //1.加载oracle驱动
        try {
            Class.forName(db_driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        //2.获得数据库连接
        try {
            connection = DriverManager.getConnection(db_url, db_userName, db_passWord);
        } catch (SQLException e) {
            e.printStackTrace();;
            return null;
        }
        return connection;
    }
}
