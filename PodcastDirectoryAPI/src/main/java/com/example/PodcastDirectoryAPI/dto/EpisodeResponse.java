package com.example.PodcastDirectoryAPI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class EpisodeResponse {

    private Long id;
    private Integer episodeNumber;
    private String title, description;
    private LocalDateTime publishedAt;
}
