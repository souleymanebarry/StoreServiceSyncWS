package com.barry.service;

import  java.util.List;

import com.barry.entities.Store;

public interface StoreService {

    List<Store> fetchAllStore();

    Store getStoreByCode(String code);

    Store createStore(Store store);

    void deleteStoreByCode(String code);
}
