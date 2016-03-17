package cn.edu.tju.scs.fm.service.impl;

import cn.edu.tju.scs.fm.Constant;
import cn.edu.tju.scs.fm.dao.UserDao;
import cn.edu.tju.scs.fm.domain.LoginInfo;
import cn.edu.tju.scs.fm.service.captcha.IPreLoginHandler;
import cn.edu.tju.scs.fm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

/**
 * Created by jack on 2016/3/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String validateUser(HttpSession httpSession,LoginInfo loginInfo,ModelMap map) {
        String captcha = (String)httpSession.getAttribute(IPreLoginHandler.SESSION_ATTR_NAME);
        if(!captcha.equalsIgnoreCase(loginInfo.getCaptcha())){
            map.addAttribute("error",true);
            map.addAttribute("captchaError","验证码错误！");
            return "forward:/";
        }
        if(userDao.hasMatchUser(loginInfo.getUsername(),loginInfo.getPassword())){
            httpSession.setAttribute(Constant.SESSION_USER,loginInfo.getUsername());
            return "redirect:/cards";
        }else {
            map.addAttribute("error",true);
            map.addAttribute("userInfoError","用户名或密码错误！");
            return "forward:/";
        }
    }
}
