package com.example.PodcastDirectoryAPI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportResponse {

    private Long podcastId;

    private String podcastTitle;

    private Long subscriberCount;
}