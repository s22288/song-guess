package com.example.guesssong.service;

import com.example.guesssong.entities.Song;
import com.example.guesssong.service.helpClasses.SongWithAlternatives;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongSerivice {

     List<Song> findAllSongs();

     List<SongWithAlternatives> getRadnom8Songs();

    SongWithAlternatives getTwoRandomSongsNamesAndOneCorrect(Song song);

     List<String> getTwoRandomSongNames(String used);




}
