package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return this.iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return this.iSongRepository.findById(id);
    }

    @Override
    public void remove(Song song) {
        this.iSongRepository.remove(song);
    }
}
