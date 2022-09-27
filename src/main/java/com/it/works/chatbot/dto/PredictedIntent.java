package com.it.works.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PredictedIntent {

    private Long intentId;
    private String intentName;
    private Integer confidence;

}
