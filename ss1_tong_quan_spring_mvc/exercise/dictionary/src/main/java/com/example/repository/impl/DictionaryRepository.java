package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    String[] vietnameseKey = {"sach", "but", "xin chao", "tam biet", "mot", "hai"};
    String[] englishKey = {"book", "pen", "hello", "goodbye", "one", "two"};

    @Override
    public String trans(String keySearch) {

        for (int i = 0, vietnameseKeyLength = vietnameseKey.length; i < vietnameseKeyLength; i++) {
            String keyWordVietNamese = vietnameseKey[i];
            if (keyWordVietNamese.equalsIgnoreCase(keySearch)) {
                return englishKey[i];
            }
        }

        for (int i = 0, englishKeyLength = englishKey.length; i < englishKeyLength; i++) {
            String keyWordEnglish = englishKey[i];
            if (keyWordEnglish.equalsIgnoreCase(keySearch)) {
                return vietnameseKey[i];
            }
        }

        return "không tồn tại";
    }
}
