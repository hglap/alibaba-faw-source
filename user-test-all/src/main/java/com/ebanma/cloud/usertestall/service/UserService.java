package com.ebanma.cloud.usertestall.service;

import com.ebanma.cloud.usertestall.domain.common.PageQuery;
import com.ebanma.cloud.usertestall.domain.common.PageResult;
import com.ebanma.cloud.usertestall.domain.dto.UserDTO;
import com.ebanma.cloud.usertestall.domain.dto.UserQueryDTO;

import java.util.List;

/**
 * @author 黄贵龙
 * @version $ Id: UserService, v 0.1 2023/03/19 12:47 86139 Exp $
 */
public interface UserService {

    /**
     * 新增
     * @param userDTO
     * @return
     */
    int save(UserDTO userDTO);

    /**
     * 更新
     * @param id
     * @param userDTO
     * @return
     */
    int update(Long id, UserDTO userDTO);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery);
}
