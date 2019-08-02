package vn.zalopay.gitlab.phuctt4.rock.paper.scissors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionGrpcClient;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.jwt.JwtTokenUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Test
	public void testGrpcClient() {
		SessionGrpcClient sessionGrpcClient = new SessionGrpcClient(jwtTokenUtil.generateToken("tranphucbol"));
		sessionGrpcClient.createSession();
		Assert.assertTrue(true);
	}

}
