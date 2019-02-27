import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-20 15:21
 * @description:
 */

public class ReduceImages {

    @Test
    public void testReduceImages(){

        String path = "G:\\StudyTest\\Toutiao\\src\\main\\webapp\\images\\img\\downloadImages";
        String fileName = "news-23857402019-01-20 10-26-39.png";
        try {
            Thumbnails.of(path+"\\"+fileName)
                    .forceSize(100,80)
                    .toFile(path+"\\reduceImages\\"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
