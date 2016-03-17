package cn.edu.tju.scs.fm.web;

import cn.edu.tju.scs.fm.Config;
import cn.edu.tju.scs.fm.domain.LoginInfo;
import cn.edu.tju.scs.fm.domain.LoginResult;
import cn.edu.tju.scs.fm.service.captcha.IPreLoginHandler;
import cn.edu.tju.scs.fm.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * User controller
 * Created by jack on 2016/3/8.
 */

@Controller
public class UserController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    Config config;
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(){
        return "../../index";
    }

    @RequestMapping("/preLogin")
    @ResponseBody
    public Object preLogin(HttpSession session) throws Exception{
        // 取出已经配置好的登录预处理器
        IPreLoginHandler preLoginHandler = config.getPreLoginHandler();
        if(preLoginHandler == null){
            throw new Exception("没有配置 preLoginHandler，无法执行预处理");
        }
        return preLoginHandler.handle(session);
    }

    /**
     * 登录验证
     * @param loginInfo
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public
    String login(LoginInfo loginInfo,HttpSession session,ModelMap map) throws Exception{
        logger.info("正在进行校验！");
        LoginResult result = new LoginResult();
        return userService.validateUser(session,loginInfo,map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/logout")
    public String logout(HttpSession session){
        logger.info("正在注销！");
        session.invalidate();
        return "redirect:/";
    }
}
