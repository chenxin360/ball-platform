package com.zshnb.ballplatform.controller.front;

import com.zshnb.ballplatform.BaseTest;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.RegisterRequest;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class UserControllerTest extends BaseTest {

	@Test
	public void testRegister() {
		RegisterRequest request = new RegisterRequest();
		request.setUsername("abc");
		request.setPassword("abc");
		ResponseEntity<Response> responseEntity = restTemplate.postForEntity("/front/user/register", request, Response.class);
		assert responseEntity.getStatusCode().is2xxSuccessful();
	}

	@Test
	public void testLogin() {
		LoginRequest request = new LoginRequest();
		request.setUsername("abc");
		request.setPassword("abc");
		ResponseEntity<Response> responseEntity = restTemplate.postForEntity("/front/user/login", request, Response.class);
		assert responseEntity.getStatusCode().is2xxSuccessful();
		request.setPassword("aaa");
		responseEntity = restTemplate.postForEntity("/front/user/login", request, Response.class);
		assert responseEntity.getBody().getCode() == 400;
	}
}
