import cn.wh3t.util.ImageDownload;
import org.junit.Test;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-20 11:50
 * @description:
 */

public class testDownload {

    @Test
    public void testDownloadImages() throws Exception {
        ImageDownload imageDownload = new ImageDownload();
        imageDownload.downloadImages("https://c2.hoopchina.com.cn/uploads/star/event/images/190120/877a9e0180d606d784159797c545ca337605fc0c.jpg",
                                    "1"+".png",
                                    "G:\\StudyTest\\Toutiao\\src\\main\\webapp\\images\\img\\downloadImages");
    }
}
