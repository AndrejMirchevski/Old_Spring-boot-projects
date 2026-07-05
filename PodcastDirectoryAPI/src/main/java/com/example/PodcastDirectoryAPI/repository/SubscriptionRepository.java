package com.example.PodcastDirectoryAPI.repository;

import com.example.PodcastDirectoryAPI.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    List<SubscriptionEntity> findByUserIdAndDeletedAtIsNull(Long userId);

    List<SubscriptionEntity> findByPodcastIdAndDeletedAtIsNull(Long podcastId);

    boolean existsByUserIdAndPodcastIdAndDeletedAtIsNull(Long userId, Long podcastId);

    Long countByPodcastIdAndDeletedAtIsNull(Long podcastId);

    @Query("""
        SELECT s.podcast.id, COUNT(s)
        FROM Subscription s
        WHERE s.deletedAt IS NULL
        GROUP BY s.podcast.id
        ORDER BY COUNT(s) DESC
    """)
    List<Object[]> findMostSubscribedPodcasts();
}
