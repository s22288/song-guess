package com.example.guesssong.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genreName;

    @Column(length = 2000)
    private String description;
    private String photo;
    @JsonManagedReference
    @OneToMany(mappedBy = "genre" ,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<>();

}
