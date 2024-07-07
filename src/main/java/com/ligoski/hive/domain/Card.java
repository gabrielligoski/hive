package com.ligoski.hive.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "cards")
public class Card {
    @Id
    private String id;
    private String title;
    private String description;
    private String status;
}
