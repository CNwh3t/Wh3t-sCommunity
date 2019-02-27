package cn.wh3t.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-20 11:41
 * @description: 根据路径下载图片
 */

public class ImageDownload {

    public void downloadImages(String urlString,String fileName,String savePath) throws Exception {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(5*1000); //设置5s超时
        InputStream inputStream = connection.getInputStream();

        //5M
        byte[] bytes = new byte[1024 * 1024 * 5];
        //读取到的数据长度
        int len;
        //输出文件流
        File file = new File(savePath);
        if (file.exists()){
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file.getPath() + "\\" + fileName);
        //读取
        while ((len = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len);
        }

        //断开
        fileOutputStream.close();
        inputStream.close();

    }

}
