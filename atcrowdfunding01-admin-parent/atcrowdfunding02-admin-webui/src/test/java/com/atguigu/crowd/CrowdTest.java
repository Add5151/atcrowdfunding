package com.atguigu.crowd;

/**
 * @author long
 * @create 2023-04-25 15:06
 */
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 这里用junit5进行测试
@SpringJUnitConfig(locations = "classpath:spring-persist-mybatis.xml")
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void  testConnection() throws SQLException{
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testInsertAdmin(){
        Admin admin;
        admin = new Admin(null,"Rachel","123123","rui","rui@qq.com",null);
        int count = adminMapper.insert(admin);
        System.out.println(count);
    }
    @Autowired
    private AdminService adminService;

    @Test
    public void testTx() {
        Admin admin = new Admin(null, "mei Lee", "123456", "mei", "mei@qq.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        adminService.saveAdmin(admin);
    }
}
