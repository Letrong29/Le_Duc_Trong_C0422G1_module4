package com.example.backend.controller;

import com.example.backend.model.Smartphone;
import com.example.backend.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/smartphone")
public class HomeController {

    @Autowired
    private ISmartphoneService iSmartphoneService;

    @GetMapping("/home")
    public ResponseEntity<Page<Smartphone>> goHome(@PageableDefault(size = 5) Pageable pageable,
                                                   Optional<String> keySearch) {

        String keyVal = keySearch.orElse("");

        Page<Smartphone> smartphonePage = this.iSmartphoneService.findAll(pageable, keyVal);

        return new ResponseEntity<>(smartphonePage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Smartphone> save(@RequestBody Smartphone smartphone){

        return new ResponseEntity<>(this.iSmartphoneService.save(smartphone),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePhone(@RequestBody Smartphone phone){

        this.iSmartphoneService.remove(phone);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Smartphone> findById(@RequestParam int id){

        Optional<Smartphone> smartphone = this.iSmartphoneService.findById(id);

        if (!smartphone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(smartphone.get(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Smartphone> update(@RequestBody Smartphone phone){

        return new ResponseEntity<>(this.iSmartphoneService.save(phone),
                HttpStatus.OK);
    }
}
