package com.example.service.impl;

import com.example.repository.IDictionaryRepository;
import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository iDictionaryRepository;

    @Override
    public String trans(String keySearch) {
        return iDictionaryRepository.trans(keySearch);
    }
}
