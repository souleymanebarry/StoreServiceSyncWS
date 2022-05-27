package com.barry.service.impl;

import com.barry.entities.Store;
import com.barry.exceptions.AppException;
import com.barry.repositories.StoreRepository;
import com.barry.service.StoreService;
import com.barry.util.MappingUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;


@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private static final Logger LOGGER = LogManager.getLogger(StoreServiceImpl.class);

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> fetchAllStore() {
        StopWatch watch = new StopWatch();
        watch.start();
        List<Store> storeList = storeRepository.findAll();
        if (CollectionUtils.isEmpty(storeList)) {
            LOGGER.error("The store must not be empty");
            throw new AppException("The store must not be empty");
        }
        watch.stop();
        LOGGER.info("store fetching finished in: {} ms for {} StoreList!",watch.getTime(), storeList.size());
        return storeList;
    }

    @Override
    public Store getStoreByCode(String code) {
        MappingUtils.checkIfValidateCode(code);
        return storeRepository.findById(code)
                .orElseThrow(()-> new AppException("code not found"));
    }

    @Override
    public Store createStore(Store store) {
        MappingUtils.checkIfValidateCode(store.getCode());
        Optional<Store> optStore = storeRepository.findById(store.getCode());
        if (optStore.isPresent()){
            LOGGER.error("Store Already exists");
            throw new AppException("Store Already exists");
        }
        return storeRepository.save(store);
    }

    @Override
    public void deleteStoreByCode(String code) {
        MappingUtils.checkIfValidateCode(code);
        storeRepository.deleteById(code);
    }
}
