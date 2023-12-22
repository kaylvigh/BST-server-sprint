package com.keyin;

import com.keyin.controller.TreeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TreeController.class)
public class TreeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetArchivedTreesEmptyList() throws Exception {
        String expectedJson = "[]";

        mockMvc.perform(get("/api/tree/archive"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    void testCreateTree() throws Exception {
        String numbers = "3 1 2";

        mockMvc.perform(post("/api/tree/create")
                        .param("numbers", numbers))
                .andExpect(status().isOk());
    }
}
