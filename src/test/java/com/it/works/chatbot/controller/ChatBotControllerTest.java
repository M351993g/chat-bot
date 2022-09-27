package com.it.works.chatbot.controller;

import com.it.works.chatbot.dto.ChatRequest;
import com.it.works.chatbot.dto.ChatResponse;
import com.it.works.chatbot.service.ChatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ChatBotController.class)
class ChatBotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatService chatService;

    @Test
    void getChatReply() throws Exception {
        ChatResponse chatResponse = ChatResponse.builder().id(5L).message("Hello :) How can I help you?").build();
        Mockito.when(chatService.getAppropriateReply(Mockito.any(ChatRequest.class))).thenReturn(chatResponse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/chatbot/reply")
                .param("botIdentifier", "4455")
                .param("message", "hello");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{id:5,message:'Hello :) How can I help you?'}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}