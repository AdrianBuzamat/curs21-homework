package ro.fasttrackit.curs21homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21homework.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
