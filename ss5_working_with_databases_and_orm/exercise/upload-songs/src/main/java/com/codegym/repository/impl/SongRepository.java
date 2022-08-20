package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {

    private List<Song> songs = new ArrayList<>();

    @Override
    public List<Song> findAll() {

        TypedQuery<Song> query = BaseRepository.entityManager.createQuery("select s from Song s", Song.class);

        return query.getResultList();

    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.persist(song);

        entityTransaction.commit();
    }

    @Override
    public Song findById(int id) {
        return BaseRepository.entityManager.find(Song.class, id);
    }

    @Override
    public void remove(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.remove(song);

        entityTransaction.commit();
    }
}
