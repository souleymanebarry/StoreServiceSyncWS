package com.barry.controller.impl;

import com.barry.controller.StoreController;
import com.barry.entities.Store;
import com.barry.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StoreControllerImpl implements StoreController {

    private final StoreService storeService;

    public StoreControllerImpl(StoreService storeService) {
        this.storeService = storeService;
    }


    @Override
    public ResponseEntity<List<Store>> fetchAllStore() {
        return ResponseEntity.ok(storeService.fetchAllStore());
    }

    @Override
    public ResponseEntity<Store> getStoreByCode( String code) {
        return ResponseEntity.ok(storeService.getStoreByCode(code));
    }


    @Override
    public ResponseEntity<Store> createStoreByCode( Store store) {
        return ResponseEntity.ok(storeService.createStore(store));
    }


    @Override
    public ResponseEntity<Void> deleteStoreByCode(String code) {
        storeService.deleteStoreByCode(code);
        return ResponseEntity.noContent().build();
    }
}
