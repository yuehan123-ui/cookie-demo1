package system.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3P0Utils {
    public static DataSource ds = null;
    // 初始化C3P0数据库连接池
    static {
        //与DBCP不同的是，c3p0不用手动加载配置文件，只需将配置文件放到resource目录即可
        // 使用c3p0-config.xml配置文件中的named-config节点中name属性的值
        // 如果不写，则默认调用default-config
        ds = new ComboPooledDataSource();
    }

    /**
     * 返回数据库对象
     *
     */
    public static DataSource getDataSource(){
        return ds;
    }


    /**
     * 得到数据库连接对象
     *
     *
     */
    public static Connection getConnection() {
        Connection conn;
        try {
            conn = ds.getConnection();
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("数据库忙，请调整数据库大小重试。");
        }
    }


}
