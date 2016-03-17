package cn.edu.tju.scs.fm.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * 用户登录信息
 * Created by jack on 2016/1/3.
 */
public class LoginLog extends BaseDomain{
    private Long logId;
    private Long account;
    private String ip;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;

    public LoginLog(){
        
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
