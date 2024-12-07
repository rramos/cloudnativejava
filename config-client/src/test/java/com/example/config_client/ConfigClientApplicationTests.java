package com.example.config_client;

import com.github.dockerjava.api.DockerClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.ComposeContainer;
import org.testcontainers.containers.Container;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.startupcheck.StartupCheckStrategy;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.containers.wait.strategy.WaitAllStrategy;
import org.testcontainers.containers.wait.strategy.WaitStrategy;
import org.testcontainers.utility.DockerImageName;

import org.springframework.boot.test.web.client.TestRestTemplate;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.time.Duration;
import java.util.Map;

@SpringBootTest(classes = ConfigClientApplication.class,
		properties = {
				"spring.config.use-legacy-processing=true",
				"spring.cloud.config.enabled:true" })
class ConfigClientApplicationTests {

	private static final Integer PORT = 8888;
	private static final String APPNAME = "user-service";
	private static final String APPENV = "dev";

	public static final GenericContainer<?> container = new GenericContainer<>(
			DockerImageName.parse("hyness/spring-cloud-config-server"))
			.withEnv("SPRING_CLOUD_CONFIG_SERVER_GIT_URI","https://github.com/rramos/config-server.git")
			.withExposedPorts(PORT)
			.withStartupTimeout(Duration.ofSeconds(30))
			;

	@BeforeAll
	static void beforeAll() { container.start(); }

	@AfterAll
	static void afterAll() { container.stop();}

	@Test
	@SuppressWarnings("unchecked")
	public void contextLoads() {
		Map<String,String> res = new TestRestTemplate().getForObject("http://localhost:" + PORT + "/" + APPNAME + "/" + APPENV, Map.class);
		//assertThat(res).containsKey("propertySources");
	}
}
