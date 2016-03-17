package cn.edu.tju.scs.fm.service.captcha;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 图形验证码登录预处理，用于生产验证码
 *
 * Created by jack on 2015/10/17.
 */
public class CaptchaPreLoginHandler implements  IPreLoginHandler{

    private final static String COODES = "0123456789";
    private final static int LEN = 4;
    @Override
    public Map<?, ?> handle(HttpSession session) throws Exception {
        Map<String,Object> ret = new HashMap<String,Object>();

        String code = randomCode();
        session.setAttribute(SESSION_ATTR_NAME,code);
        ret.put("imgData","data:image/png;base64,"+ Base64.getEncoder().encodeToString(generateImg(code)));

        return ret;
    }

    /**
     * 4 位随机数字字符
     *
     * @return
     */
    private String randomCode(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < LEN; ++i){
            sb.append(COODES.charAt(random.nextInt(COODES.length())));
        }
        return sb.toString();
    }

    /**
     * 绘制 PNG 图片
     *
     * @param code
     * @return
     * @throws java.io.IOException
     */
    private byte[] generateImg(String code) throws IOException{

        final int width = 75;
        final int height = 30;

        BufferedImage bimag = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimag.createGraphics();  // 绘图句柄

        // 背景
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);

        g.setColor(Color.GRAY);// 画笔颜色
        g.setFont(new Font("黑体",Font.BOLD,25));

        // 干扰线
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            g.drawLine(x1,y1,x2,y2);
        }

        for(int i= 0; i < LEN;i++){
            g.drawString(String.valueOf(code.charAt(i)),5 + 16 * i,25); // 每次 x 坐标 做5个偏移，画16个像素宽。y 轴放在25
        }
        g.dispose(); // 释放绘图句柄，释放资源，完成绘图

        // 输出,写到内存,以字节数字方式存在
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimag,"png",baos);
        baos.close();

        return baos.toByteArray();
    }
}
