package cn.edu.tju.scs.fm.dao.impl;

import cn.edu.tju.scs.fm.dao.UserDao;
import cn.edu.tju.scs.fm.domain.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jack on 2016/3/8.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean hasMatchUser(String username,String password) {
        String sql = "select count(*) from admins where adminName = ? and password = ?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
        return result >= 1;
    }
}
