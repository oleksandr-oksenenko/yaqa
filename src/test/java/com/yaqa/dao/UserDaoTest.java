package com.yaqa.dao;

import com.yaqa.config.DaoConfig;
import com.yaqa.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Test
@ContextConfiguration(classes = DaoConfig.class)
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserDao userDao;

    public void getByUsername_hp() {
        final String username = "username";
        final String password = "password";
        final UserEntity user = new UserEntity();

        user.setUsername(username);
        user.setPassword(password);

        userDao.save(user);

        final UserEntity actualUser = userDao.getByUsername(username);

        assertNotNull(actualUser.getId());
        assertEquals(actualUser.getUsername(), username);
        assertEquals(actualUser.getPassword(), password);
    }
}