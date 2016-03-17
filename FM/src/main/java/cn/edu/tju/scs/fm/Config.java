package cn.edu.tju.scs.fm;

import cn.edu.tju.scs.fm.service.captcha.IPreLoginHandler;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by jack on 2016/3/8.
 */

public class Config implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    private IPreLoginHandler preLoginHandler; // 登录前预处理器

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
       this.resourceLoader = resourceLoader;
    }

    public IPreLoginHandler getPreLoginHandler() {
        return preLoginHandler;
    }

    public void setPreLoginHandler(IPreLoginHandler preLoginHandler) {
        this.preLoginHandler = preLoginHandler;
    }

    public void refreshConfig(){

    }

    public void destroy(){

    }
}
