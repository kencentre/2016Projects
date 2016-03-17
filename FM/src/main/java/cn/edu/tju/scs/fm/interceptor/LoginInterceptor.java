package cn.edu.tju.scs.fm.interceptor;

import cn.edu.tju.scs.fm.Constant;
import cn.edu.tju.scs.fm.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class LoginInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// excluded URLs:
		String requestUri = request.getRequestURI();
		logger.info("请求的uri:" + requestUri);
		System.out.println("请求的uri:" + requestUri);
		for (String url : excludedUrls) {
			if (requestUri.endsWith(url)) {
				return true;
			}
		}

		// 进行登录状态验证
        logger.info("session id :" + request.getSession().getId());
		Object adminName = request.getSession().getAttribute(Constant.SESSION_USER);
		logger.info("admin 名字：" + adminName);
		if (adminName == null) {
			System.out.println("尚未登录，调到登录页面");
			response.sendRedirect(request.getContextPath()+"/");
//			throw new UnauthorizedException("401 未登录");
//			return false;
		}
        return true;
	}

	@Override
	public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
			modelAndView)throws Exception {

		System.out.println("postHandle");


	}

	@Override
	public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		System.out.println("afterCompletion");
	}
}
