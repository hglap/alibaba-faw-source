package com.ebanma.cloud.usertestall.util;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 常见元对象处理程序
 *
 * @author 黄贵龙
 * @version $ Id: CommonMetaObjectHandler, v 0.1 2023/03/22 10:27 86139 Exp $
 * @date 2023/03/22
 */
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("新建时，开始填充系统字段");
        }
        this.strictInsertFill(metaObject, "created", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "modified", LocalDateTime.class, LocalDateTime.now());

        this.strictInsertFill(metaObject, "creator", String.class, "TODO 从上下文获取当前人");
        this.strictInsertFill(metaObject, "operator", String.class, "TODO 从上下文获取当前人");

        this.strictInsertFill(metaObject, "deleted", Integer.class, 0);
        this.strictInsertFill(metaObject, "version", Long.class, 1L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("更新时，开始填充系统字段！");
        }

        this.strictUpdateFill(metaObject, "modified", LocalDateTime.class, LocalDateTime.now());

        this.strictUpdateFill(metaObject, "operator", String.class, "TODO 从上下文获取修改人");
    }
}
