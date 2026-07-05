package com.example.PodcastDirectoryAPI.repository;

import com.example.PodcastDirectoryAPI.entity.PodcastEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PodcastRepository extends JpaRepository<PodcastEntity, Long> {

    List<PodcastEntity> findByDeletedAtIsNull();

    List<PodcastEntity> findByCategoryAndDeletedAtIsNull();

    List<PodcastEntity> findByLanguageAndDeletedAtIsNull();
}
