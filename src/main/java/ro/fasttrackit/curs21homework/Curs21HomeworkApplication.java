package ro.fasttrackit.curs21homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21homework.model.*;
import ro.fasttrackit.curs21homework.repository.*;

import java.util.List;

@SpringBootApplication
public class Curs21HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs21HomeworkApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(
            ActorRepository actorRepository,
            MovieRatingRepository movieRatingRepository,
            MovieRepository movieRepository,
            ReviewRepository reviewRepository,
            StudioRepository studioRepository) {
        return args -> {

            Studio warnerBros = studioRepository.save(new Studio("Warner Bros.", "Leavesden"));
            Studio columbiaPictures = studioRepository.save(new Studio("Columbia Pictures", "California"));
            Studio paramountPictures = studioRepository.save(new Studio("Paramount Pictures", "Hollywood"));

            Actor denzelWashington = actorRepository.save(new Actor("Denzel Washington", 1966));
            Actor morganFreeman = actorRepository.save(new Actor("Morgan Freeman", 1937));
            Actor marlonBrando = actorRepository.save(new Actor("Marlon Brando", 1924));
            Actor alPacino = actorRepository.save(new Actor("Al Pacino", 1940));

            movieRepository.saveAll(List.of(
                    new Movie("The Shawshank Redemption", 1994)
                    , new Movie("The Godfather", 1972, new MovieRating(8.7, "Users reviews")
                            , List.of(
                            new Review("Best movie, ever", "AlexanderR")
                            , new Review("seen it fourth time", "lara")
                    ), columbiaPictures, List.of(
                            marlonBrando, alPacino
                    ))
                    , new Movie("The Dark Knight", 2008, null, List.of(), paramountPictures, List.of(
                            denzelWashington, morganFreeman
                    ))
                    , new Movie("Angry Men", 1957, null, List.of(), warnerBros, List.of(
                            denzelWashington, marlonBrando
                    ))
            ));
        };
    }

}
