package com.ebanma.cloud.demo.domain.service;

import org.springframework.stereotype.Component;

/**
 * @author hgl
 * @version $ Id: DefaultIdGenerator, v 0.1 2023/05/21 10:54 86139 Exp $
 */
@Component
public class DefaultIdGenerator implements IdGenerator{
    @Override
    public Long next() {
        return null;
    }
}
