package com.it.works.chatbot.entitty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "intent_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IntentMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false, foreignKey = @ForeignKey(name = "fk_message_intent") , referencedColumnName = "id")

    private Message message;

    @ManyToOne
    @JoinColumn(name = "intent_id", nullable = false, foreignKey = @ForeignKey(name = "fk_intent_message"), referencedColumnName = "id")
    private Intent intent;

    @Column(name = "confidence", nullable = false)
    private Integer confidence;

}