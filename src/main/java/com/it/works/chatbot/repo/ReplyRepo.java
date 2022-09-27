package com.it.works.chatbot.repo;

import com.it.works.chatbot.entitty.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepo extends JpaRepository<Reply, Long> {

    Reply findByIntentId(Long id);

}
