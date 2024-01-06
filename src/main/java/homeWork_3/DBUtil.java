package homeWork_3;

import java.util.HashMap;

/**
 * 模拟数据库
 * @author wan
 *
 */
public class DBUtil {
    //实例化
    private static DBUtil instance = new DBUtil();
    // 定义users集合，用于模拟数据库
    private HashMap<String,UserBean> users = new HashMap<String,UserBean>();
    private DBUtil() {
        // 向数据库(users)中存入两条数据
        UserBean user1 = new UserBean();
        user1.setName("admin");
        user1.setPassword("123456");
        user1.setEmail("admin@163.com");
        users.put("admin ",user1);
        UserBean user2 = new UserBean();
        user2.setName("zhangsan");
        user2.setPassword("123456");
        user2.setEmail("zhangsan@163.com");
        users.put("zhangsan ",user2);
    }
    public static DBUtil getInstance()	{
        return instance;
    }
    // 获取数据库(users)中的数据
    public UserBean getUser(String userName) {
        UserBean user = (UserBean) users.get(userName);
        return user;
    }
    // 向数据库(users)插入数据
    public boolean insertUser(UserBean user) {
        if(user == null) {
            return false;
        }
        String userName = user.getName();
        if(users.get(userName) != null) {
            return false;
        }
        users.put(userName,user);
        return true;
    }}