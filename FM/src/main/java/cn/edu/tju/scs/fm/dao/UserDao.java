package cn.edu.tju.scs.fm.dao;

import cn.edu.tju.scs.fm.domain.LoginInfo;

/**
 *
 * Created by jack on 2016/3/8.
 */
public interface UserDao {
    public boolean hasMatchUser(String username,String password);
}
