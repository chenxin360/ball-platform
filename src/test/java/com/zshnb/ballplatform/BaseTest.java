package com.zshnb.ballplatform;

import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.RegisterRequest;
import java.lang.reflect.Type;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = {BallPlatformTestApplication.class}, webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class BaseTest {
	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	private TruncateService truncateService;

	protected String username = "zsh";
	protected String password = "password";
	public RegisterRequest registerRequest;
	public LoginRequest loginRequest;

	@Before
	public void before() {
		registerRequest = new RegisterRequest();
		registerRequest.setUsername(username);
		registerRequest.setPassword(password);
		loginRequest = new LoginRequest();
		loginRequest.setUsername(username);
		loginRequest.setPassword(password);
	}

	@After
	public void after() throws SQLException {
		truncateService.truncate();
	}
}
