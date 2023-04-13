package com.ebanma.cloud.usertestall.service;

import com.ebanma.cloud.usertestall.domain.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 黄贵龙
 * @version $ Id: UserServiceImplTest, v 0.1 2023/03/26 21:29 86139 Exp $
 */
@SpringBootTest
class UserServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService userService;

    @Test
    void save() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("username1");
        userDTO.setPassword("password1");
        userDTO.setEmail("email@email.com");
        userDTO.setAge(1);
        userDTO.setPhone("15011110000");
        userDTO.setVersion(1L);
        int save = userService.save(userDTO);
        logger.info("{}", save);
    }

    /**
     * 乐观锁使用的规则
     * 1. 如果更新数据中不带有version字段：不使用乐观锁，并且version不会累加
     * 2. 如果更新字段中带有version，但与数据库中不一致，更新失败
     * 3. 如果带有version，并且与数据库中一致，更新成功，并且version会累加
     */
    @Test
    void update() {
        Long id = 1638176212234821634L;

        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("password10000");
        userDTO.setAge(100);
        userDTO.setVersion(1L);

        int update = userService.update(id, userDTO);

        logger.info("{}", update);
    }

    @Test
    void delete() {
        int delete = userService.delete(1638176212234821634L);

        logger.info("{}", delete);
    }

}
