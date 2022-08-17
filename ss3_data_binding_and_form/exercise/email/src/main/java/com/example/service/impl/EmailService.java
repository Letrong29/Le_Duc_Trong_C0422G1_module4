package com.example.service.impl;

import com.example.repository.IEmailRepository;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> showLanguagesList() {
        return this.iEmailRepository.showLanguagesList();
    }

    @Override
    public List<Integer> showPageSizeList() {
        return this.iEmailRepository.showPageSizeList();
    }
}
