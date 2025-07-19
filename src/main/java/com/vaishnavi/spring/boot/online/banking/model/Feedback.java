package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Feedback {
    private int feedbackId;
    private int userId;
    private String message;
    private int rating;         // 1 to 5
    private Date submittedAt;

    public void setFeedbackId(int i) {
    }
}


