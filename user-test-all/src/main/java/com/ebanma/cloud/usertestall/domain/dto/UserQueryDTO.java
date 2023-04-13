package com.ebanma.cloud.usertestall.domain.dto;

import java.io.Serializable;

/**
 * @author 黄贵龙
 * @version $ Id: UserQueryDTO, v 0.1 2023/03/15 14:53 86139 Exp $
 */
public class UserQueryDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6388963865596623280L;

    /**
     * 用户名
     */
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
