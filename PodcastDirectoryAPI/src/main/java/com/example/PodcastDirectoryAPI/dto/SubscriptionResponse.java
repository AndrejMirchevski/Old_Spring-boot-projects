package com.example.PodcastDirectoryAPI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SubscriptionResponse {

    private Long id, userId, podcastId;
    private LocalDateTime subscribedAt;
}
