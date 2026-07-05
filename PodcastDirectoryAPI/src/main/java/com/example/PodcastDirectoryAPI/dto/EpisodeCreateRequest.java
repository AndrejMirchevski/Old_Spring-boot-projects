package com.example.PodcastDirectoryAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EpisodeCreateRequest {

    @NotBlank(message = "title of episode required")
    @Size(max = 255, message = "Title cannot be longer then 255 characters")
    private String title;

    @Size(max = 255 ,message = "description can not be longer then 255 charaters")
    private String description;
}
