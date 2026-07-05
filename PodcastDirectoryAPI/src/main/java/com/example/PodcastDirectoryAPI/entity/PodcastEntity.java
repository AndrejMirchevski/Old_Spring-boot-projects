package com.example.PodcastDirectoryAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "podcasts")
@Getter
@Setter
@NoArgsConstructor
public class PodcastEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String hostName;

    @Column(length = 100)
    private String description;

    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "podcast")
    private List<EpisodeEntity> episodeEntities = new ArrayList<>();

    @OneToMany(mappedBy = "podcast")
    private List<SubscriptionEntity> subscriptionEntities = new ArrayList<>();
}
