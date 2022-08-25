package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping(value = {"list", ""})
    public String goList(Model model){

        model.addAttribute("songs",
                this.iSongService.showList());

        return "list-song";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model){

        model.addAttribute("songDto", new SongDto());

        return "create-song";
    }

    @PostMapping("/save")
    public String saveSong(@ModelAttribute @Validated SongDto songDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        new SongDto().validate(songDto, bindingResult);

        if (bindingResult.hasErrors()){
            return "create-song";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);

        this.iSongService.save(song);

        redirectAttributes.addFlashAttribute("msg",
                "successfully added new");

        return "redirect:/song";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id, Model model){

        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(this.iSongService.findById(id), songDto);

        model.addAttribute("songDto", songDto);

        return "edit-song";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){

        new SongDto().validate(songDto, bindingResult);

        if (bindingResult.hasErrors()){
            return "edit-song";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);

        this.iSongService.save(song);

        redirectAttributes.addFlashAttribute("msg",
                "successfully update");

        return "redirect:/song";
    }
}
