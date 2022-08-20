package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String songName;

    private String artistName;

    private String linkFile;

    public Song() {
    }

    public Song(int id, String songName, String artistName, String linkFile) {
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

    public String getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(String linkFile) {
        this.linkFile = linkFile;
    }
}
