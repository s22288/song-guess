package com.example.guesssong.entities.repositories;

import com.example.guesssong.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
//    SELECT column FROM table
//ORDER BY RAND()
//LIMIT 1

    @Query("SELECT s.name FROM Song s where s.name not like %:used% ORDER BY RAND() LIMIT 2")
    List<String> getTwoRandomSongsNames(String used);
}
