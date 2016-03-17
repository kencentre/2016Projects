package cn.edu.tju.scs.fm.exception;

/**
 * 未授权异常
 * Created by jack on 2016/1/5.
 */
public class UnauthorizedException extends Exception{

    private static final long serialVersionUID = 1L;

    public UnauthorizedException(String message) {
        super(message);
    }
}
