package com.zshnb.ballplatform;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = {BallPlatformTestApplication.class}, webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class BaseTest {
	@Autowired
	protected RestTemplate restTemplate;
}
