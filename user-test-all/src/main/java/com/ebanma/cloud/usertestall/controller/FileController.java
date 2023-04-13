package com.ebanma.cloud.usertestall.controller;

import com.ebanma.cloud.usertestall.domain.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @author 黄贵龙
 * @version $ Id: FileController, v 0.1 2023/03/29 10:11 86139 Exp $
 */
@RestController
@RequestMapping("/api/file")
public class FileController {

    @RequestMapping("upload")
    public Result<String> upload(@NotNull MultipartFile file) {
        return Result.success(file.getOriginalFilename());
    }
}
