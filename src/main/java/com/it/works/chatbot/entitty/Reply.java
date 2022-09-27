package com.it.works.chatbot.entitty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "text", nullable = false, length = 50)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "intent_id", referencedColumnName = "id")
    private Intent intent;

}