package cn.edu.tju.scs.fm.service.captcha;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录页前置处理器
 *
 * Created by jack on 2015/10/17.
 */
public interface IPreLoginHandler {

    public static final String SESSION_ATTR_NAME = "login_session_attr_name";

    /**
     * 前置处理
     * @param session
     * @return
     * @throws Exception
     */
    public abstract Map<?,?> handle(HttpSession session) throws Exception;
}
