package cn.edu.tju.scs.fm.service;

import cn.edu.tju.scs.fm.domain.LoginInfo;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

/**
 * Created by jack on 2016/3/8.
 */
public interface UserService {
    public String validateUser(HttpSession httpSession,LoginInfo loginInfo,ModelMap map);

}
