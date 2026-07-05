package com.example.PodcastDirectoryAPI.repository;

import com.example.PodcastDirectoryAPI.entity.EpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<EpisodeEntity, Long> {
    List<EpisodeEntity> findByPodcastIdAndDeletedAtIsNull(Long podcastId);

    @Query("SELECT MAX(e.episodeNumber) FROM Episode e where e.podcast.id = :podcastId AND e.deletedAt IS NULL")
    Integer findByMaxEpisodesNumber(Long podcastId);
}
