/**
 * Cookie 操作工具类
 * Created by jack on 2015/10/17.
 */

var Cookie = {

    /**
     * 按名称获取 cookie 值
     */
    get:function(name){
        var cookies = document.cookie;
        cookies = cookies.split(";");
        for(var i = 0,len = cookies.length;i < len;i++){

            var cookieItem = cookies[i];
            var pos = cookieItem.indexOf("=");
            var cname = unescape(cookieItem.substring(0,pos));
            var cval= unescape(cookieItem.substring(pos + 1));

            if(name == cname){
                return cval;
            }
        }
    },

    /**
     * 设置 cookie 值
     * @param name
     * @param val
     * @param path
     * @param exeMinute
     * @param domain
     * @param secure
     */
    set:function(name,val,path,expMinute,domain,secure){
        var cookieItem = name + "=" + escape(val);

        if(path){
            cookieItem += ";path=" + path;
        }

        if(expMinute){
            cookieItem += ";expires=" + new Date(new Date().getTime() + expMinute * 60 * 1000)
        }

        if(domain){
            cookieItem += ";domain=" + domain;
        }

        if(secure){
            cookieItem += ";secure";
        }

        document.cookie = cookieItem;
    },

    del:function(name){
        document.cookie = name + "=anyVal;expires=" + new Date(0).toGMTString();
    }
}