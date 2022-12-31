package org.goodgoodgood.webredirector.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.goodgoodgood.webredirector.config.EnvironmentConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MainController.class)
class MainControllerTests {

	@MockBean
	private EnvironmentConfig environmentConfig;
	
	@Autowired
	private MockMvc mvc;

	@Test
	void handleAllRequest() throws Exception {
		//given
		String requestPath = "/some-path";
		String redirectPath = "https://naver.com";
		
		//when
		when(environmentConfig.getRedirectUrl())
			.thenReturn(redirectPath);
		when(environmentConfig.getIsReservePath())
			.thenReturn(false);

		//then
		mvc.perform(get(requestPath))
			.andExpect(status().is(302))
			.andExpect(header().string("Location", redirectPath));
	}

	@Test
	void handleAllRequest_reserveRequestPath() throws Exception {
		//given
		String requestPath = "/some-path";
		String redirectPath = "https://naver.com";
		
		//when
		when(environmentConfig.getRedirectUrl())
			.thenReturn(redirectPath);
		when(environmentConfig.getIsReservePath())
			.thenReturn(true);

		//then
		mvc.perform(get(requestPath))
			.andExpect(status().is(302))
			.andExpect(header().string("Location", "https://naver.com/some-path"));
	}

}
