package org.example.bookmyshow.repos;

import org.example.bookmyshow.models.Show_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<Show_,Long> {
}
