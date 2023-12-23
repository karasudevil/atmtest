package com.sim.atmtest;

import com.sim.dao.LoginDAO;
import com.sim.model.Account;
import com.sim.service.LoginServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginServiceImp loginServiceImp;
    @MockBean
    private LoginDAO loginDAO;
    @Test
    public void accountInfo() throws Exception {

        Mockito.when(loginDAO.getAccountbyName("1")).thenReturn(new Account("1","114514","11",1000));
        Account account=loginServiceImp.accountInfo("1","114514");
        Assert.assertNotNull(account);
        Assert.assertEquals(account.getCashamount(), 1000);
        Assert.assertEquals(account.getAccountid(),"11");
    }
}
