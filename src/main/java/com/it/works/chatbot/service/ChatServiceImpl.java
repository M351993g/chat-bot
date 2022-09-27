package com.it.works.chatbot.service;

import com.it.works.chatbot.dto.ChatRequest;
import com.it.works.chatbot.dto.ChatResponse;
import com.it.works.chatbot.dto.PredictedIntent;
import com.it.works.chatbot.entitty.Reply;
import com.it.works.chatbot.repo.IntentMessageRepo;
import com.it.works.chatbot.repo.ReplyRepo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    private final IntentMessageRepo intentMessageRepo;
    private final ReplyRepo replyRepo;

    public ChatServiceImpl(IntentMessageRepo intentMessageRepo, ReplyRepo replyRepo) {
        this.intentMessageRepo = intentMessageRepo;
        this.replyRepo = replyRepo;
    }

    @Override
    public ChatResponse getAppropriateReply(ChatRequest chatRequest) {
        List<PredictedIntent> predictedIntentList = intentMessageRepo.getPredicatedIntentList(chatRequest.getMessage());
        if (!predictedIntentList.isEmpty()) {
            Optional<PredictedIntent> predictedIntent = predictedIntentList.stream()
                    .max(Comparator.comparing(PredictedIntent::getConfidence));
            if (predictedIntent.isPresent()) {
                Reply reply = replyRepo.findByIntentId(predictedIntent.get().getIntentId());
                // we can use map struct here for do mapping instead of object builder, but no need for this now :)
                return ChatResponse.builder().id(reply.getId()).message(reply.getText()).build();
            }
        }
        return ChatResponse.builder().message("AI could not give the correct answer.").build();
    }
}
