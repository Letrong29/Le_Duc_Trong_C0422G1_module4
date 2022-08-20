package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {

    private int id;

    private String songName;

    private String artistName;

    private String type;

    private MultipartFile linkFile;

    public SongForm() {
    }

    public SongForm(int id, String songName, String artistName, String type, MultipartFile linkFile) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
        this.type = type;
        this.linkFile = linkFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(MultipartFile linkFile) {
        this.linkFile = linkFile;
    }
}
