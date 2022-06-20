package wnbook.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000121600186";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCjn/6ac/kLysopL+t0N2t5++ktunyF7r+/iniHVhb4hQu2C+oM8nc1/EGVWrqHlDI0v1T2JqozW5MXxMVUgFmDsnX7s6z5VAvIrTIdwCrKiUIJ+lc504iPrDvpXaZbLkhsLpIolHBu+TveGjRPA5g3ACHcjS5dhpY3KpaiQXBrNwwm8Gpr2cl1Hyciv/4GFsyWlGJh8ZIk8K2ExZ6/pmfY6TRij/SEzDO8jq5MNl4Ub+VR20lMzosNtdh/XfxWj4iVA32IviRV4PkoKxSujD0JURzx3zwKrAc4OWIfPH2YocVwF+MnbWYKdeU0pFKi9IjpgskOerNuA1/XJJSAwVHbAgMBAAECggEAOZVc7M5TnyrG6qfKnSPD1zIoZcdze08CfE4nDLnna56m+HJI9DWAbqdQDVfYvU4SPS34oIgK7fgUVBETwSFKX2a2ztX00eoaG42YTZALfyu+6fQILnmbXbSngQFMQlqPckMRfOaAiw17XDasogIJ15FcWVn2L0PmKZP7Xy7YeWJd5NccCEQ6qA/MsgGbVXyc8ZeY9Df4i4F6I/5bEWDVt5cHK/YlYbMufxcprv6W4sAebFQ9EWkZ+bsSxHjLruKJ68QZ/g1nkSmzziPJo/zb+LuapInWcCyQmpuVbSjOVDEq/LlTaV+jV7PsFZb+cjZMKZT72KH6PBI8tKlq2d9PwQKBgQDUaTFVLTJYlU3POSnVSD+KLZ0c0PpCMTXlLNU+NPCB1qcGnZXa9iot2kZO+nFeGBMB3BLFj/insnLfsOyMz8EMfY6TMCszXtIJKnjBwhDXcjM8hBIdCADLH4NxKDUvAbxYz0GosjtGtBITy1MnHGTWa/Faphn58Ikvn+ibMC2KvQKBgQDFM+D+V5pa+5VxHE7imjvtc6js0PpeCDgZtYZdWR5r/3QB3u9t6lpzbvZQ3bWpZPneFTtm0Ox+XRH+wsVvcPt+3PY6U9/diNkSW2GcRaZ2qnqhpfWrBR8xt26jK8sQdxzXpr0COD9jt87Gj7tTYb84qcamHAl+o8mnCZ0fXzRkdwKBgDSlGcAFoqvH3XAVt+OPs4fYxE7nEI+lSLlTQkrXriBQBjeiiQiq6EtTBQgAFGcAyn00gUaL51IQ7V25qPdBapRg7hxW3O4vexkgeKt1IN11BXPjO+YMHL47QkWidIQBByBvxdM80Wo1qSFUzHguFmP6fug7sMZ8slOma21DJJZ1AoGAVPT2t1xySUQdq68wZPthWfj8C5o0YpJT6O+FRW4BZzGUfsHWkJnoAdcKEuiRPLsd0ol/H9peKEpcWE780/fuwUbcZWCBD2XHbtsjgDmZb4IedsmSvuzj9X07EtzpDNzj9hwFTZGB7angUTbW0yNHSFgMFr/5by+MzoObx0oyvh0CgYBeYLPJnYPLnezEW7wlbDMqIzJKejuQty8HSa0bjYLckSSY5UfFjjzHe5Cj8xTn+PnCBSpi0mc1+4HSTavdeizQs6wgacHMfzy8CNG3NiYZtQMKOfrlhSOe5GbxfIXco7PsUNVzRcdk8Hk7fuBi0Dz8RFu2ljwvJqHUTBaEt4oCDA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv3/rsd5VBXeLycRVlukUpo2SXks7WOgNw8G2k2Kvdu3YaDapLH7k5E1PnXCVo8+cIJ5F9eqcRKyzDwiepaSVgwYBohNRktBLcnS0kv7ZKW0E9IOcClwaBBfX4cKf6Lh6G+1Dvmd/uSSANE5GEPgKchz2tRQ27HgPmm1XAE18nnDT+osLMHkAMPAi21LBR2pIGBV555VQ797y3eJo4UHi4bGCTLQTwikjcR4NflhHCLVKJXsCKSSKJSH624g4Maz0fGx22rTu5SHaviTWYm8Eoy/7M196lVyqspbOIyR4LelHRnWcOKaimm90Z2uz/v1l81qeE67RJgy5bORk3MxQEwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/wnbook060/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/wnbook060/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "d:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

