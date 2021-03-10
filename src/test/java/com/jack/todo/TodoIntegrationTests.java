package com.jack.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Complete Integration tests for the Todo application - TODO GET all, GET id, PATCH id, DELETE id
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoIntegrationTests {
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate;
	HttpHeaders headers;
	JSONObject todoJsonObject;
	
	private final ObjectMapper objectMapper = new ObjectMapper();	
	
	@BeforeEach
	public void init() throws Exception{
		restTemplate = new TestRestTemplate();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		todoJsonObject = new JSONObject();
		todoJsonObject.put("title", "testing");
		todoJsonObject.put("dueDate", "2020-12-12");

	}
	/*
	 *  Should return a TodoItem in JSON format when a POST request is made with title and dueDate.
	 */
	@Test
	public void testCreate_ReturnsTodoItem() throws Exception{
		// Given
		HttpEntity<String> request = new HttpEntity<String>(todoJsonObject.toString(),headers);
		// When
		String response = restTemplate.postForObject(
				createURLWithPort("/todos"), request, String.class);
		
		// Expect
		JsonNode root = objectMapper.readTree(response);
		assertNotNull(response);
		assertEquals(root.path("title").asText(), "testing");
		assertEquals(root.path("dueDate").asText(), "2020-12-12");
		assertNotNull(root.path("id").asText());
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
}
