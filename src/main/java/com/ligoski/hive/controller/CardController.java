package com.ligoski.hive.controller;

import com.ligoski.hive.domain.Card;
import com.ligoski.hive.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class CardController {

    @Autowired
    CardService service;

    /**
     * {@code POST  /cards} : Create a new card.
     */
    @PostMapping("/cards")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Card> createCard(@RequestBody Card card) {
        return service.createCard(card);
    }

    /**
     * {@code PUT  /cards} : Updates an existing card.
     */
    @PutMapping("/cards/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Card> updateCard(@PathVariable String id, @RequestBody Card card) {
        return service.updateCard(id, card);
    }

    /**
     * {@code GET  /cards} : get all the cards.
     */
    @GetMapping("/cards")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Card> getAllQueryCards(@RequestParam(required = false) String status) {
        if (status != null) {
            return service.getCardsByStatus(status);
        }
        return service.getCards();
    }

    /**
     * {@code GET  /cards} : get card by id.
     */
    @GetMapping("/cards/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Card> getAllCards(@PathVariable String id) {
        return service.getCard(id);
    }

    /**
     * {@code DELETE  /cards/:id} : delete the "id" card.
     */
    @DeleteMapping("/cards/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCard(@PathVariable String id) {
        return service.deleteCard(id);
    }
}
