package com.example.guesssong.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

@Entity
@Table(name = "song")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String photo;
    @Column(nullable = false,length = 1000)
    private String mp3_path;
    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
