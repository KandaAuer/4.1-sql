package com.example.sql;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProfileTests {

    private static final Logger logger = LoggerFactory.getLogger(ProfileTests.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testDevProfile() {
        logger.info("Testing 'dev' profile");
        String port = applicationContext.getEnvironment().getProperty("server.port");
        logger.debug("Loaded server.port = {}", port);

        assertThat(port).isEqualTo("8081");
    }

    @Test
    void testProdProfile() {
        logger.info("Testing 'prod' profile");
        String port = applicationContext.getEnvironment().getProperty("server.port");
        logger.debug("Loaded server.port = {}", port);

        assertThat(port).isEqualTo("8082");
    }

    @Test
    void testDefaultProfile() {
        logger.info("Testing default profile");
        String port = applicationContext.getEnvironment().getProperty("server.port");
        logger.debug("Loaded server.port = {}", port);

        assertThat(port).isEqualTo("8080");
    }
}
