package com.example.guesssong.entities.repositories;

import com.example.guesssong.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerReposiotory extends JpaRepository<Singer,Long> {
}
