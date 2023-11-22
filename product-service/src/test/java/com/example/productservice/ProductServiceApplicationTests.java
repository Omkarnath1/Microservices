package com.example.productservice;

import com.example.productservice.DTO.ProductRequest;
import com.example.productservice.DTO.ProductResponse;
import com.example.productservice.Repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

//	@Container
//	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//	@Autowired
//	private ProductRepository productRepository;
//
//
//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
//		dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//	}
//
//	@Test
//	void shouldCreateProduct() throws Exception {
//		ProductRequest productRequest = getProductRequest();
//		String productRequestString = objectMapper.writeValueAsString(productRequest);
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(productRequestString))
//				.andExpect(status().isCreated());
//		Assertions.assertEquals(1, productRepository.findAll().size());
//	}
//
//	@Test
//	void shouldGetAllProducts() throws Exception {
//		// Perform a GET request to the "/api/products" endpoint
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
//				.andExpect(status().isOk())
//				.andReturn();
//
//		// Verify the response content
//		String responseBody = result.getResponse().getContentAsString();
//
//		// Deserialize the response content to a list of products
//		List<ProductResponse> productList = objectMapper.readValue(responseBody, new TypeReference<List<ProductResponse>>() {});
//
//		// Perform assertions on the list of products
//		Assertions.assertNotNull(productList);
//		Assertions.assertFalse(productList.isEmpty());
//		Assertions.assertEquals(1, productList.size()); // Adjust based on your expected result
//
//		// Perform additional assertions based on your specific use case
//		// For example, verify the properties of the returned products
//		ProductResponse firstProduct = productList.get(0);
//		Assertions.assertEquals("iPhone 13", firstProduct.getName());
//		Assertions.assertEquals("iPhone 13", firstProduct.getDescription());
//		Assertions.assertEquals(BigDecimal.valueOf(1200), firstProduct.getPrice());
//	}
//
//	private ProductRequest getProductRequest() {
//		return ProductRequest.builder()
//				.name("iPhone 13")
//				.description("iPhone 13")
//				.price(BigDecimal.valueOf(1200))
//				.build();
//	}

}
