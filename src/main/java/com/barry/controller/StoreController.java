package com.barry.controller;

import com.barry.entities.Store;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RequestMapping(path ="/stores")
public interface StoreController {

    @GetMapping
    ResponseEntity<List<Store>> fetchAllStore();

    @GetMapping("/{code}")
    ResponseEntity<Store> getStoreByCode(@PathVariable(name = "code") String code);

    @PostMapping
    ResponseEntity<Store> createStoreByCode(@RequestBody Store store);

    @DeleteMapping("/{code}")
    ResponseEntity<Void> deleteStoreByCode(@PathVariable(name = "code") String code);

}
