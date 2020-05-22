package com.william.mall_portal;

import com.william.pojo.req.PublicReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
public class WilliamPortalApplicationTests {

	PublicReq publicReq = new PublicReq();
	String uid = "";

	// 我的足迹,带分页
	@Test
	public void getFootList(){
	}

	@Test
	public void contextLoads() {
	}

}
