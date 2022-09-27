package com.it.works.chatbot.repo;

import com.it.works.chatbot.dto.PredictedIntent;
import com.it.works.chatbot.entitty.IntentMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IntentMessageRepo extends JpaRepository<IntentMessage, Long> {

    @Query("SELECT new com.it.works.chatbot.dto.PredictedIntent(intent.id, intent.name, imessage.confidence) " +
            "FROM IntentMessage imessage left join imessage.intent intent left join imessage.message message " +
            "WHERE lower(message.text) = lower(?1)")
    List<PredictedIntent> getPredicatedIntentList(String message);

}
