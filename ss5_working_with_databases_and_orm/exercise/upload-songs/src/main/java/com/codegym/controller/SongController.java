package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
@PropertySource("classpath:upload_file.properties")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model) {

        List<Song> songs = iSongService.findAll();

        model.addAttribute("songs", songs);

        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {

        ModelAndView modelAndView = new ModelAndView("/create");

        modelAndView.addObject("songForm", new SongForm());

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {

        MultipartFile multipartFile = songForm.getLinkFile();

        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(songForm.getLinkFile().getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Song song = new Song(songForm.getId(), songForm.getSongName(), songForm.getArtistName(), fileName);

        iSongService.save(song);

        ModelAndView modelAndView = new ModelAndView("/create");

        modelAndView.addObject("songForm", songForm);

        modelAndView.addObject("message", "Created new product successfully !");

        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idSong, Model model){

        Song song = this.iSongService.findById(idSong);

        this.iSongService.remove(song);

        model.addAttribute("songs", this.iSongService.findAll());

        return "/index";
    }
}
