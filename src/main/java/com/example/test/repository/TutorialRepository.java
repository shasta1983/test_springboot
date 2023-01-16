package com.example.test.repository;

import com.example.test.entity.Tutorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

}
