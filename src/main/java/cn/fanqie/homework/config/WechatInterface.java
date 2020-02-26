package cn.fanqie.homework.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class WechatInterface {
    /**
     * 微信接口
     * @param appid
     * @param code
     * @param secret
     * @return
     */
    public static String getopenid(String appid, String code, String secret) {
        if (!Tools.isNotNull(code) || !Tools.isNotNull(appid)
                || !Tools.isNotNull(secret)) {
            return null;
        }
        BufferedReader in = null;
        // appid和secret是开发者分别是小程序ID和小程序密钥，开发者通过微信公众平台-》设置-》开发设置就可以直接获取，
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + appid + "&secret=" + secret + "&js_code=" + code
                + "&grant_type=authorization_code";
        try {
            URL weChatUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = weChatUrl.openConnection();
            // 设置通用的请求属性
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    /**
     * 获取微信小程序码转换接口
     * @param appid
     * @param secret
     * @return
     */
    public static String getaccess_token (String appid, String secret) {
        if (!Tools.isNotNull(appid) || !Tools.isNotNull(secret)) {
            return null;
        }
        BufferedReader in = null;
        // appid和secret是开发者分别是小程序ID和小程序密钥，开发者通过微信公众平台-》设置-》开发设置就可以直接获取，
        /*https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=秘钥*/
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ appid + "&secret="+ secret;
        try {
            URL weChatUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = weChatUrl.openConnection();
            // 设置通用的请求属性
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
