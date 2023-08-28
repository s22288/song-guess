package com.example.guesssong.initDb;

import com.example.guesssong.entities.Genre;
import com.example.guesssong.entities.Singer;
import com.example.guesssong.entities.Song;
import com.example.guesssong.entities.repositories.GenreRepostiory;
import com.example.guesssong.entities.repositories.SingerReposiotory;
import com.example.guesssong.entities.repositories.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class DbInit {
    @Bean
    CommandLineRunner commandLineRunner(SongRepository songRepository, SingerReposiotory singerReposiotory, GenreRepostiory genreRepostiory) {
        return args -> {

         Singer paktofonika = Singer.builder().name("Paktofonika").photo("https://static.polityka.pl/_resource/res/path/96/17/9617395a-1d32-4bfd-b042-feb58eeba068_f1400x900").build();
            Song jestemBogiem = Song.builder().name("Jestem Bogiem").photo("https://bonito.pl/zdjecia/5/7f-jestes-bogiem-muzyka-z-fi.jpg").mp3_path("jestembogiem.mp3").build();
//            Song maszStyla = Song.builder().name("Dla mnie masz styla").photo("https://imgs.search.brave.com/-a1PpjQSpviLFLCEr5ouvwZzNo_19KZRh08CTUEllL8/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pLnNj/ZG4uY28vaW1hZ2Uv/NjhlODZmMTY2YmRj/NmJmOThjY2NkOTE2/ZmQxMWJhYzY3YjRj/NGFiMg").mp3_path("maszstyla.mp3").build();
//           Song mlodaKrew = Song.builder().name("Młoda krew").photo("https://i.ytimg.com/vi/4cf1bLhHSOg/maxresdefault.jpg").mp3_path("mlodakrew.mp3").build();
           Song droga = Song.builder().name("Droga").photo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQksh_s6QQ8LtDSuqHVLs_c6pjc4kBPol4viQ&usqp=CAU").mp3_path("droga.mp3").build();

            // rockowe piosenki

            Song Highwaytohell = Song.builder().name("Highway to hell").photo("https://agrochowski.pl/environment/cache/images/0_0_productGfx_499389/2023_02_07-15_01-Office-Lens-3.jpg").mp3_path("highwaytohell.mp3").build();
            Song sweetHomealabama = Song.builder().name("sweet home alabama").photo("https://thumbs.dreamstime.com/b/alabama-sweet-home-united-states-best-quality-design-alabama-sweet-home-united-states-278978183.jpg").mp3_path("alabama.mp3").build();
            Song californication = Song.builder().name("Californication").photo("https://i.ytimg.com/vi/YlUKcNNmywk/maxresdefault.jpg").mp3_path("californication.mp3").build();

            Song heyJude = Song.builder().name("Hey jude").photo("https://i.ytimg.com/vi/A_MjCqQoLLA/maxresdefault.jpg").mp3_path("heyJude.mp3").build();

            Genre polishRap =new Genre();
            polishRap.setGenreName("Polski Rap");
            polishRap.setDescription("Rap (czasem zamiennie z wyrażeniem hip-hop) określany jest jako styl wykonawczy lub odrębny gatunek muzyczny powstały we wczesnych latach 70. XX wieku w Stanach Zjednoczonych Ameryki wśród disc jockeyów, a od końca lat 70. przez wykonawców zwanych raperami");
                   polishRap.setPhoto("https://static.wikia.nocookie.net/rap/images/2/21/123jatopeja.jpg/revision/latest/zoom-crop/width/500/height/500?cb=20141113175857&path-prefix=pl");
            Genre rock = Genre.builder().genreName("Rock").description("Rock – gatunek muzyki rozrywkowej powstały w połowie XX wieku w Stanach Zjednoczonych[1] (który wytworzył wokół siebie krąg subkultury młodzieżowej[1]) i ogólna nazwa szeregu stylów muzycznych, wywodzących się z rock and rolla oraz rhythm and bluesa i bluesa. Sama nazwa rock jest skrótem od rock and roll")
                    .photo("https://www.metalnews.pl/images/slipknot-1.jpg").build();

            polishRap.getSongs().add(jestemBogiem);
//            polishRap.getSongs().add(maszStyla);
//            polishRap.getSongs().add(mlodaKrew);
            polishRap.getSongs().add(droga);
            polishRap.getSongs().add(Highwaytohell);
            polishRap.getSongs().add(sweetHomealabama);
            polishRap.getSongs().add(californication);
            polishRap.getSongs().add(heyJude);


            Set<Genre> genres = new HashSet<>();
            genres.add(polishRap);
            genres.add(rock);

            genreRepostiory.saveAll(genres);

            };
    }
}
