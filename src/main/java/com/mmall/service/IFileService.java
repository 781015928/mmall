package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by aimld on 2017/10/5.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
