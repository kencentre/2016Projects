package cn.edu.tju.scs.fm.domain;

/**
 * 登录信息
 * Created by jack on 2016/3/8.
 */
public class LoginInfo {
    private String username;
    private String password;
    private String captcha;

    public LoginInfo(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
