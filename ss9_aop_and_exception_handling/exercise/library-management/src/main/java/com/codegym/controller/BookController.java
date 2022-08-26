package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("library")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping(value = {"home", ""})
    public String goHome(Model model){

        model.addAttribute("books",
                this.iBookService.findAll());

        return "home";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam int id, Model model){

        model.addAttribute("book",
                this.iBookService.findById(id));

        return "detail";
    }

    @GetMapping("/rent")
    public String rentBook(@RequestParam int idRent) throws Exception {

        Book book = this.iBookService.findById(idRent);

        if (book.getAmount() == 0){
            throw new Exception();
        }else {
            book.setAmount(book.getAmount() - 1);

            this.iBookService.saveBook(book);
        }

        return "redirect:/library";
    }

    @GetMapping("/return-book")
    public String goReturnBook(){
        return "return-book";
    }

    @PostMapping("/return-book")
    public String returnBook(@RequestParam int idReturn) throws Exception {

        Book book = this.iBookService.findById(idReturn);

        if (book != null){
            if (book.getAmount() == book.getTotal()){
                throw new Exception();
            }else {
                book.setAmount(book.getAmount() + 1);

                this.iBookService.saveBook(book);
            }
        }else {
            throw new Exception();
        }

        return "redirect:/library";
    }

    @ExceptionHandler(value = Exception.class)
    public String goRentBookErr(){
        return "err-page";
    }
}
