package com.barry;


import com.barry.entities.Store;
import com.barry.repositories.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
    @Bean
    CommandLineRunner starter(StoreRepository storeRepository){
        return  args -> {
            storeRepository.save(new Store(UUID.randomUUID().toString(),
                    "PARIS","1 AV DE YORK","02",87000,"01"));
            storeRepository.save(new Store(UUID.randomUUID().toString(),
                    "LA ROCHELLE","RUE DUMONT CITY","01",17000,"017"));
            storeRepository.save(new Store(UUID.randomUUID().toString(),
                    "NEW YORK","1 AV  BROADWAY ","02",342,"34"));
            storeRepository.save(new Store(UUID.randomUUID().toString(),
                    "LOOS","RUE DE FLANDRE ","03",59200,"30"));
        };
    }
}
