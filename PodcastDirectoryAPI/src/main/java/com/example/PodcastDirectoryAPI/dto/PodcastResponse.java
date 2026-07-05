package com.example.PodcastDirectoryAPI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PodcastResponse {
    private Long id;
    private String title, category, language, hostName, description;
}
