package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {

    private int id;

    private String songName;

    private String artistName;

    private MultipartFile linkFile;

    public SongForm() {
    }

    public SongForm(int id, String songName, String artistName, MultipartFile linkFile) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
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

    public MultipartFile getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(MultipartFile linkFile) {
        this.linkFile = linkFile;
    }
}
