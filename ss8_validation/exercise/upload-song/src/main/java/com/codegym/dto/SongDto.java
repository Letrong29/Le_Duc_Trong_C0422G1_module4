package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private int id;

    @NotBlank(message = "please enter !")
    @Size(max = 800)
    private String name;

    @NotBlank(message =  "please enter !")
    @Size(max = 300)
    private String artist;

    @NotBlank(message =  "please enter !")
    @Size(max = 1000)
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

        if (!songDto.name.matches("^[a-zA-Z0-9]*$")){
            errors.rejectValue("name",
                    "creat.name",
                    "Wrong format !");
        }

        if (!songDto.artist.matches("^[a-zA-Z0-9]*$")){
            errors.rejectValue("artist",
                    "create.artist",
                    "Wrong format !");
        }

        if (!songDto.type.matches("^[a-zA-Z0-9,]*$")){
            errors.rejectValue("type",
                    "create.type",
                    "Wrong format !");
        }
    }
}
