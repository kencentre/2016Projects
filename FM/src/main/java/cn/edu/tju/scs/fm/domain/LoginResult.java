package cn.edu.tju.scs.fm.domain;

/**
 * Created by jack on 2015/12/3.
 */
public class LoginResult {

    private Boolean result;
    private String captchaError;
    private String userInfoError;

    public LoginResult(){

    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getCaptchaError() {
        return captchaError;
    }

    public void setCaptchaError(String captchaError) {
        this.captchaError = captchaError;
    }

    public String getUserInfoError() {
        return userInfoError;
    }

    public void setUserInfoError(String userInfoError) {
        this.userInfoError = userInfoError;
    }
}
