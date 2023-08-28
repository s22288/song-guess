package com.example.guesssong.service.helpClasses;

import com.example.guesssong.entities.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SongWithAlternatives {
    private Song correctSong;

    private List<String> alternatives;

    public SongWithAlternatives(Song correctSong, List<String> alternatives) {
        this.correctSong = correctSong;
        this.alternatives = alternatives;
    }
}
