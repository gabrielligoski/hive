package com.ligoski.hive.service;

import com.ligoski.hive.domain.Card;
import com.ligoski.hive.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Flux<Card> getCards() {
        return cardRepository.findAll();
    }

    public Flux<Card> getCardsByStatus(String status) {
        return cardRepository.findCardsByStatus(status);
    }

    public Mono<Card> getCard(String id) {
        return cardRepository.findById(id);
    }

    public Mono<Card> createCard(Card card) {
        return cardRepository.save(card);
    }

    public Mono<Card> updateCard(String id, Card card) {
        return cardRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty()).flatMap(
                optionalCard -> {
                    if (optionalCard.isPresent()) {
                        card.setId(id);
                        return cardRepository.save(card);
                    }
                    return Mono.empty();
                }
        );
    }

    public Mono<Void> deleteCard(String id) {
        return cardRepository.deleteById(id);
    }

}
