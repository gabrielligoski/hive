package com.ligoski.hive.repository;

import com.ligoski.hive.domain.Card;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String> {

    @Query("{'status': ?0 }")
    Flux<Card> findCardsByStatus(String status);

}
