package ro.fasttrackit.curs21homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21homework.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
