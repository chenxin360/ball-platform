package com.zshnb.ballplatform.controller.front;

import com.zshnb.ballplatform.BaseTest;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.dto.UserDto;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.RegisterRequest;
import com.zshnb.ballplatform.request.UpdateInfoRequest;
import java.lang.reflect.Type;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class UserControllerTest extends BaseTest {
	private ResponseEntity<Response> register() {
		RegisterRequest request = new RegisterRequest();
		request.setUsername("zsh");
		request.setPassword("abc");
		return restTemplate.postForEntity("/front/user/register", request, Response.class);
	}

	private ResponseEntity<Response<UserDto>> login() {
		LoginRequest request = new LoginRequest();
		request.setUsername("zsh");
		request.setPassword("abc");
		ParameterizedTypeReference<Response<UserDto>> ref = new ParameterizedTypeReference<Response<UserDto>>() {
			@Override
			public Type getType() {
				return super.getType();
			}
		};
		return restTemplate.exchange("/front/user/login", HttpMethod.POST,
			new HttpEntity<>(request), ref);
	}

	@Test
	public void testRegister() {
		ResponseEntity responseEntity = register();
		assert responseEntity.getStatusCode().is2xxSuccessful();
	}

	@Test
	public void testLogin() {
		register();
		ResponseEntity responseEntity = login();
		assert responseEntity.getStatusCode().is2xxSuccessful();

		LoginRequest request = new LoginRequest();
		request.setUsername("aaa");
		request.setPassword("aaa");
		responseEntity = restTemplate.postForEntity("/front/user/login", request, Response.class);
		assert responseEntity.getStatusCode().is4xxClientError();
	}

	@Test
	public void testUpdateInfo() {
		register();
		ResponseEntity<Response<UserDto>> loginResponse = login();
		UserDto dto = loginResponse.getBody().getData();

		UpdateInfoRequest updateInfoRequest = new UpdateInfoRequest();
		updateInfoRequest.setId(dto.getId());
		updateInfoRequest.setAge(19);
		updateInfoRequest.setSex("man");

		ResponseEntity<Response> updateInfoResponse = restTemplate.postForEntity("/front/user/update-info",
			updateInfoRequest, Response.class);
		assert updateInfoResponse.getStatusCode().is2xxSuccessful();

		loginResponse = login();
		dto = loginResponse.getBody().getData();
		assert dto.getAge().equals(19);
		assert dto.getSex().equals("man");
	}
}
