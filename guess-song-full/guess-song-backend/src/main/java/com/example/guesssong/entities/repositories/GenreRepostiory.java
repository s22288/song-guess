package com.example.guesssong.entities.repositories;

import com.example.guesssong.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepostiory extends JpaRepository<Genre, Long> {
}
