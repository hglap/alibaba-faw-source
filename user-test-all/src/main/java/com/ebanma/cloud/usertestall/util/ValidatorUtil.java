package com.ebanma.cloud.usertestall.util;


import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 手动校验器，用于service层校验
 * @author 黄贵龙
 * @version $ Id: ValidatorUtil, v 0.1 2023/03/22 14:15 86139 Exp $
 */
public class ValidatorUtil {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 参数校验
     * @param object
     * @param groups
     * @param <T>
     */
    public static <T> void validate(T object, Class... groups) {
        Set<ConstraintViolation<T>> validate =
                validator.validate(object, groups);

        // 如果校验结果不为空，拼装校验结果信息
        if (!CollectionUtils.isEmpty(validate)) {
            StringBuilder exceptionMessage = new StringBuilder();
            validate.forEach(constraintViolation -> {
                exceptionMessage.append(constraintViolation.getMessage());
            });

            throw new RuntimeException(exceptionMessage.toString());
        }
    }
}
