package com.example.guesssong.controller;

import com.example.guesssong.entities.Song;
import com.example.guesssong.service.helpClasses.SongWithAlternatives;
import com.example.guesssong.service.serviceImplement.SongServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GameController {
  private   SongServiceImpl songService = new SongServiceImpl();

    public GameController(SongServiceImpl songService) {
        this.songService = songService;
    }

    @GetMapping
    @RequestMapping(value = "/songs")
    public ResponseEntity<List<SongWithAlternatives>> getAllSongs(){
        List<SongWithAlternatives> radnom8Songs = songService.getRadnom8Songs();
        return  ResponseEntity.ok(radnom8Songs);

    }
}
