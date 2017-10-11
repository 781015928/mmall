package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by aimld on 2017/10/5.
 */
@Service("iFileService")
public class FileService implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileService.class);

    public String upload(MultipartFile file,String path){
        String originalFilename = file.getOriginalFilename();
        //扩展名
        //abc.jpg
        //保证上传过来的文件名相同不覆盖
        String fileExtensionName = originalFilename.substring(originalFilename.indexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名:{},上传的路径:{}，新文件名:{}",originalFilename,path,uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            //文件已经上传成功

            //todo 将targetFile上传到FTP服务器
            FTPUtil.uploadFile(Lists.<File>newArrayList(targetFile));
            //已经上传ftp服务器上
            //todo 上传完之后，删除upload下面的文件夹
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
        }
        return targetFile.getName();
    }
}
