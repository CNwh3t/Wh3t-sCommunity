package cn.wh3t.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-16 18:48
 * @description:
 */

@Controller
public class FileController {

    @RequestMapping(path = {"/upload"},method = RequestMethod.POST)
    public String upload(MultipartFile image, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = image.getOriginalFilename();
        File dir = new File(path,fileName);
        if (!dir.exists()){
            dir.mkdirs();
        }
        //multipartFile自带解析方法
        image.transferTo(dir);
        return "userInfo";

    }
}
