package com.engineerscodes.app.Config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ConfigTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();

    }

    @Test
    @WithMockUser(username="admin",authorities = {"ks_admin"})
    public void TestUserWithRoleAdmin() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username="admin",authorities = {"ks_user"})
    public void TestUserWithRoleUser() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void TestWithNoAuth() throws Exception{
        this.mockMvc.perform(get("/all"))
                .andExpect(status().isUnauthorized());
    }

}
