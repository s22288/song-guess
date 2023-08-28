package com.example.guesssong.service.serviceImplement;

import com.example.guesssong.entities.Song;
import com.example.guesssong.entities.repositories.SongRepository;
import com.example.guesssong.service.SongSerivice;
import com.example.guesssong.service.helpClasses.SongWithAlternatives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class SongServiceImpl implements SongSerivice {
    @Autowired
    private SongRepository songRepository ;


    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<SongWithAlternatives> getRadnom8Songs() {
        List<Song> all = songRepository.findAll();
        Collections.shuffle(all);
        int radnomSerives =4;
        List<Song> randomSongs = all.subList(0, radnomSerives);
        List<SongWithAlternatives> quizSongs = new ArrayList<>();
        for (int i = 0; i < radnomSerives; i++) {
            SongWithAlternatives quizSong = getTwoRandomSongsNamesAndOneCorrect(randomSongs.get(i));
            quizSongs.add(quizSong);
        }

        return quizSongs;
    }

    @Override
    public SongWithAlternatives getTwoRandomSongsNamesAndOneCorrect(Song song) {

        List<String> songNames = getTwoRandomSongNames(song.getName());

        SongWithAlternatives withAlternatives = new SongWithAlternatives();
        withAlternatives.setCorrectSong(song);
        withAlternatives.setAlternatives(songNames);
        return withAlternatives;
    }

    @Override
    public List<String> getTwoRandomSongNames(String used) {
        List<String> twoRandomSongsNames = songRepository.getTwoRandomSongsNames(used);

        return twoRandomSongsNames;
    }
}
