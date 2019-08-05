package vn.zalopay.gitlab.phuctt4.rock.paper.scissors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserLoginForm;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.TopResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.client.AuthGrpcClient;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.client.SessionGrpcClient;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.jwt.JwtTokenUtil;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.SessionService;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	SessionGrpcClient sessionGrpcClient;
	AuthGrpcClient authGrpcClient;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SessionService sessionService;

	@Test
	public void testRegister() throws Exception {
		UserLoginForm userLoginForm = new UserLoginForm();
		userLoginForm.setUsername(UUID.randomUUID().toString());
		userLoginForm.setPassword("password");
		mockMvc.perform(post("/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userLoginForm)))
				.andExpect(jsonPath("$.message", is("Registering successfully")));
	}

	@Test
	public void testRegister_UserExist() throws Exception {
		UserLoginForm userLoginForm = new UserLoginForm();
		userLoginForm.setUsername("tranphucbol");
		userLoginForm.setPassword("password");
		mockMvc.perform(post("/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userLoginForm)))
				.andExpect(jsonPath("$.error", is("Username existed")));
	}

	@Test
	public void testLogin() throws Exception {
		UserLoginForm userLoginForm = new UserLoginForm();
		userLoginForm.setUsername("tranphucbol");
		userLoginForm.setPassword("password");
		mockMvc.perform(post("/auth")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userLoginForm)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.token").exists());
	}

	@Test
	public void testLoginFail_WrongPassword() throws Exception {
		UserLoginForm userLoginForm = new UserLoginForm();
		userLoginForm.setUsername("tranphucbol");
		userLoginForm.setPassword("password12");
		mockMvc.perform(post("/auth")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userLoginForm)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.error", is("Wrong username or password")));
	}

	@Test
	public void testLoginFail_WrongUsername() throws Exception {
		UserLoginForm userLoginForm = new UserLoginForm();
		userLoginForm.setUsername("tranphucbol12");
		userLoginForm.setPassword("password");
		mockMvc.perform(post("/auth")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userLoginForm)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.error", is("Wrong username or password")));
	}

	@Test
	public void testCreateSession() throws Exception {
		mockMvc.perform(post("/sessions")
				.header("Authorization", "Bearer " + jwtTokenUtil.generateToken("tranphucbol")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.id").exists());
	}

	@Test
	public void testPlay() throws Exception {
		Session session = new Session();
		sessionService.createSession("tranphucbol", session);

		mockMvc.perform(post("/sessions/" + session.getId() + "?type=1")
				.header("Authorization", "Bearer " + jwtTokenUtil.generateToken("tranphucbol")))
				.andDo(print())
				.andExpect(jsonPath("$.result").exists());
	}

	@Test
	public void testTop() throws Exception {
		mockMvc.perform(get("/top/100")
				.header("Authorization", "Bearer " + jwtTokenUtil.generateToken("tranphucbol")))
				.andExpect(jsonPath("$.data", hasSize(100)));
	}

	@Test
	public void testHistory() throws Exception {
		mockMvc.perform(get("/sessions")
				.header("Authorization", "Bearer " + jwtTokenUtil.generateToken("tranphucbol")))
				.andDo(print())
				.andExpect(jsonPath("$.data").exists());
	}

	@Before
	public void init() {
		sessionGrpcClient = new SessionGrpcClient(jwtTokenUtil.generateToken("tranphucbol"));
		authGrpcClient = new AuthGrpcClient();
	}

	@Test
	public void testGrpcAuth() {
		System.out.println(authGrpcClient.auth("tranphucbol", "password"));
	}

	@Test
	public void testGrpcRegister() {
		System.out.println(authGrpcClient.register(UUID.randomUUID().toString(), "password"));
	}

	@Test
	public void testGrpcClient() {
		sessionGrpcClient.createSession();
		Assert.assertTrue(true);
	}

	@Test
	public void testGrpcPlay() {
		Long id = sessionGrpcClient.createSession();
		List<String> results = Arrays.asList("WIN", "LOSE", "DRAW");
		String result = sessionGrpcClient.play(id, 1);
		Assert.assertTrue(results.contains(result));
	}

	@Test
	public void testGetAllHistory() {
		HistoryResponse response = sessionGrpcClient.getAllHistory();
		response.getDataList().forEach(System.out::println);
	}

	@Test
	public void testGetTopUser() {
        TopResponse response = sessionGrpcClient.getTopLimit(100);
        response.getDataList().forEach(System.out::println);
    }
}
