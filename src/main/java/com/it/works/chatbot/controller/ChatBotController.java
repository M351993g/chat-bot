package com.it.works.chatbot.controller;

import com.it.works.chatbot.dto.ChatRequest;
import com.it.works.chatbot.dto.ChatResponse;
import com.it.works.chatbot.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {

    private final ChatService chatService;

    public ChatBotController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/reply")
    public ResponseEntity<ChatResponse> getChatReply(@RequestParam String botIdentifier, @RequestParam String message) {
        ChatRequest chatRequest = ChatRequest.builder().identifier(botIdentifier).message(message).build();
        return new ResponseEntity<>(chatService.getAppropriateReply(chatRequest), HttpStatus.OK);
    }

}
