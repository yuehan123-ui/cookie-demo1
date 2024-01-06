package system.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import system.dao.ISysUserDao;
import system.model.SysUser;
import system.utils.C3P0Utils;

/**
 * 接口实现类   controller -> dao
 * @author wan
 *
 */
public class SysUserDaoImpl implements ISysUserDao {

    @Override
    public List<SysUser> getAll() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from student";
        //转换器
        BasicRowProcessor pro = new BasicRowProcessor(new GenerousBeanProcessor());
        List<SysUser> list = new ArrayList<>();
        try {
            list = qr.query(sql, new BeanListHandler<SysUser>(SysUser.class,pro));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

}
