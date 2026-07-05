package com.example.PodcastDirectoryAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PodcastCreateRequest {

    @NotBlank(message = "Title of the podcast is requierd")
    @Size(max = 255, message = "max size of the title is 255 characters")
    private String title;

    @NotBlank(message = "category is requerd")
    private String category;

    @NotBlank(message = "language is required")
    @Size(max = 10, message = "language can not be more then 10 characters")
    private String language;

    @NotBlank(message = "Host name required")
    @Size(max = 20, message = "host name can not be more then 20 charaters")
    private String hostName;

    @Size(max = 100, message = "description can not be longer then 100 characters")
    private String description;
}
