package org.goodgoodgood.webredirector.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.goodgoodgood.webredirector.config.EnvironmentConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MainController.class)
class WebRedirectorApplicationTests {

	@MockBean
	private EnvironmentConfig environmentConfig;
	
	@Autowired
	private MockMvc mvc;

	@Test
	void handleAllRequest() throws Exception {
		//given
		String requestPath = "/some-path";

		//when
		when(environmentConfig.getRedirectUrl())
			.thenReturn("https://naver.com");

		//then
		mvc.perform(get(requestPath))
			.andExpect(status().is(302));
	}

}
