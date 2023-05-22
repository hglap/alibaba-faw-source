package com.ebanma.cloud.usertestall.controller;

import com.ebanma.cloud.usertestall.domain.common.PageQuery;
import com.ebanma.cloud.usertestall.domain.common.PageResult;
import com.ebanma.cloud.usertestall.domain.common.Result;
import com.ebanma.cloud.usertestall.domain.dto.UserDTO;
import com.ebanma.cloud.usertestall.domain.dto.UserQueryDTO;
import com.ebanma.cloud.usertestall.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerUnitTest {


    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserDTO userDTO;

    private List<UserDTO> list;

    @Before
    public void setUp() throws Exception {
        // 数据初始化
        userDTO = new UserDTO();
        userDTO.setUsername("username");
        userDTO.setPassword("password");
        userDTO.setEmail("123661231@qq.com");
        userDTO.setAge(25);
        userDTO.setPhone("13977078880");
        userDTO.setVersion(1L);
        list = new ArrayList<>();
        list.add(userDTO);
    }


    @Test
    public void update() {
        Mockito.doReturn(1).when(userService).update(Mockito.any(Long.class),Mockito.any(UserDTO.class));
        Result success = userController.update(123456L,userDTO);
        Assertions.assertTrue(success.getSuccess());

        Mockito.doReturn(0).when(userService).update(Mockito.any(Long.class),Mockito.any(UserDTO.class));
        Result fail = userController.update(123456L,userDTO);
        Assertions.assertFalse(fail.getSuccess());

    }

    @Test
    public void save() {
        Mockito.doReturn(1).when(userService).save(Mockito.any(UserDTO.class));
        Result success = userController.save(userDTO);
        Assertions.assertTrue(success.getSuccess());
        Mockito.doReturn(0).when(userService).save(Mockito.any(UserDTO.class));
        Result fail = userController.save(userDTO);
        Assertions.assertFalse(fail.getSuccess());
    }

    @Test
    public void delete() {
        Mockito.doReturn(1).when(userService).delete(Mockito.any(Long.class));
        Result success = userController.delete(123L);
        Assertions.assertTrue(success.getSuccess());
        Mockito.doReturn(0).when(userService).delete(Mockito.any(Long.class));
        Result fail = userController.delete(123L);
        Assertions.assertFalse(fail.getSuccess());

    }

    @Test
    public void query() {
        PageResult<List<UserDTO>> pageResult = new PageResult<>();
        pageResult.setData(list);
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setUsername(userDTO.getUsername());
        Mockito.doReturn(pageResult).when(userService).query(Mockito.any(PageQuery.class));
        Result success = userController.query(1,1,userQueryDTO);
        Assertions.assertTrue(success.getSuccess());

        Mockito.doReturn(null).when(userService).query(Mockito.any(PageQuery.class));
        Result fail = userController.query(1,1,userQueryDTO);
        Assertions.assertFalse(fail.getSuccess());

    }
}