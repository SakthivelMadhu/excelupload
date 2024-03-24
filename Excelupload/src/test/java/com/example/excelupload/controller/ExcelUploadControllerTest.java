package com.example.excelupload.controller;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ExcelUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUploadExcelFile() throws Exception {
        byte[] fileContent = {}; // Provide sample file content for testing
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/upload")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .content(fileContent))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
    }
}
