package com.example.repository.impl;

import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {

    private static List<String> languagesList = new ArrayList<>();

    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
    }

    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public List<String> showLanguagesList() {
        return this.languagesList;
    }

    @Override
    public List<Integer> showPageSizeList() {
        return this.pageSizeList;
    }
}
