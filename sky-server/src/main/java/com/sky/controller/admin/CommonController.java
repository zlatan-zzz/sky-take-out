package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {
    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传:{}", file);
        try {
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf("."));
            String object_name = UUID.randomUUID().toString()+suffix;
            String filepath = aliOssUtil.upload(file.getBytes(), object_name);
            return Result.success(filepath);
        } catch (IOException e) {
            log.error("文件上传失败,{}"+e);
            //throw new RuntimeException(e);

        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
