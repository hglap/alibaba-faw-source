package com.ebanma.cloud.usertestall.service.impl;

import com.ebanma.cloud.usertestall.domain.common.ErrorCode;
import com.ebanma.cloud.usertestall.exception.BusinessException;
import com.ebanma.cloud.usertestall.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author 黄贵龙
 * @version $ Id: LocalFileServiceImpl, v 0.1 2023/03/29 10:17 86139 Exp $
 */
@Service("LocalFileServiceImpl")
public class LocalFileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(LocalFileServiceImpl.class);

    private static final String BUCKET = "uploads";

    @Override
    public void upload(InputStream inputStream, String filename) {
        // 拼接文件上传路径
        String path = BUCKET + "/" + filename;

        //定义输入，输出流（TWR）
        try (
                InputStream innerInputStream = inputStream;

        ) {

        } catch (Exception e) {

        }
    }

    @Override
    public void upload(File file) {

        try {
            upload(Files.newInputStream(file.toPath()), file.getName());
        } catch (IOException e) {
            logger.error("文件上传失败！", e);
            throw new BusinessException(ErrorCode.FILE_UPLOAD_FAILURE);
        }

    }
}
