package com.example.guesssong.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "singer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;

        @JsonManagedReference
    @OneToMany(mappedBy = "singer" ,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<>();
}
