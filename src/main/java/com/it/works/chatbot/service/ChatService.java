package com.it.works.chatbot.service;

import com.it.works.chatbot.dto.ChatRequest;
import com.it.works.chatbot.dto.ChatResponse;

public interface ChatService {

    ChatResponse getAppropriateReply(ChatRequest chatRequest);

}
