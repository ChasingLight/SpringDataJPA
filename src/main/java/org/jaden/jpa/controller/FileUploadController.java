package org.jaden.jpa.controller;

import org.apache.commons.io.FilenameUtils;
import org.jaden.jpa.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by JadenOliver on 2017/7/17.
 *
 * 支付分账接口
 */
@Controller
public class FileUploadController {

    @Autowired
    private HttpServletRequest request;

    private static String UPLOAD_DIRECTORY = PropertiesUtil.get("fileupload.directory", "");

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file){
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                //测试获取项目目录
                System.out.println("项目运行的根目录是：" + request.getSession().getServletContext().getRealPath("/"));

                //判断文件目录是否存在，否则自动生成
                File directory = new File(UPLOAD_DIRECTORY);
                if (!directory.exists()){
                    directory.mkdirs();
                }

                if (file.getSize() > 30000)
                    return new ModelAndView("uploadFail","msg",file.getOriginalFilename()+"超过了30k");

                // 文件保存路径
                String filePath = FilenameUtils.concat(UPLOAD_DIRECTORY, file.getOriginalFilename());
                // 转存文件
                file.transferTo(new File(filePath));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //跳转视图
        return new ModelAndView("uploadSuccess","msg",file.getOriginalFilename());
    }

    /**
     * 多个文件上传
     * @param files
     * @return
     */
    @RequestMapping(value = "uploadFiles", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("files") MultipartFile[] files){
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];

                //保存文件
                String filePath = FilenameUtils.concat(UPLOAD_DIRECTORY, file.getOriginalFilename());
                // 转存文件
                try {
                    file.transferTo(new File(filePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //跳转视图
        return new ModelAndView("uploadSuccess","msg",files.length+"个文件");
    }


}
