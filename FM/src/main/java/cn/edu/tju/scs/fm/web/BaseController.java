package cn.edu.tju.scs.fm.web;

import cn.edu.tju.scs.fm.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BaseController 异常处理的基类
 * Created by jack on 2016/1/5.
 */
public class BaseController {
    @ExceptionHandler
    public void handleException(Exception ex, HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setAttribute("error", ex.getMessage());

        // 根据不同的错误返回不同的状态码
        if(ex instanceof UnauthorizedException){
//                response.sendError(401);
            response.sendRedirect("/");
        }else if(ex instanceof RuntimeException){
//            response.sendError(500);
            response.setStatus(500);
        }

    }
}
