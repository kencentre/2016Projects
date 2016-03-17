package cn.edu.tju.scs.fm.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by jack on 2015/10/16.
 */
public class StringUtils {

    public static String appendUrlParameter(String origUrl,String parameterName,
                                            String parameterVal){
        if(origUrl == null){
            return null;
        }

        String bound = origUrl.contains("?")?"&":"?";
        try{
            return origUrl + bound + parameterName + "=" +
                    URLEncoder.encode(parameterVal,"utf-8");
        }catch (UnsupportedEncodingException e){
            return null;
        }
    }

    /**
     * 生成标识，由31位的16进制字符组成，字母小写
     */
    public static String generateUniqueKey(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
