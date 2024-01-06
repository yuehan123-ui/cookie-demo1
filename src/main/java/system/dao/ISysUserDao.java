package system.dao;


import java.util.List;

import system.model.SysUser;

/**
 * 数据库持久层
 * @author wan
 *
 */
public interface ISysUserDao {

    /**
     * 查询所有
     *
     */
    List<SysUser> getAll();
}
