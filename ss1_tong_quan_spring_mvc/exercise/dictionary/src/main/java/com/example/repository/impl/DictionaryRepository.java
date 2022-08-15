package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("book", "sách");
        stringMap.put("pen", "bút");
        stringMap.put("hello", "xin chào");
        stringMap.put("goodbye", "tạm biệt");
        stringMap.put("one", "một");
        stringMap.put("two", "hai");
    }

    @Override
    public String trans(String keySearch) {
        if (stringMap.containsKey(keySearch)) {
            return stringMap.get(keySearch);
        }
        return "không tồn tại";
    }
}
