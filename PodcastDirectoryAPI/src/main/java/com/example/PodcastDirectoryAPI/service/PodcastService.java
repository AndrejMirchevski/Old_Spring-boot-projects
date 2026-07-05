package com.example.PodcastDirectoryAPI.service;

import com.example.PodcastDirectoryAPI.dto.PodcastCreateRequest;
import com.example.PodcastDirectoryAPI.dto.PodcastResponse;
import com.example.PodcastDirectoryAPI.entity.PodcastEntity;
import com.example.PodcastDirectoryAPI.exception.RecourseNotFound;
import com.example.PodcastDirectoryAPI.repository.PodcastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PodcastService {

    private final PodcastRepository podcastRepository;

    //create
    public PodcastResponse createPodcast(PodcastCreateRequest request){
        PodcastEntity podcast = new PodcastEntity();

        podcast.setTitle(request.getTitle());
        podcast.setCategory(request.getCategory());
        podcast.setDescription(request.getDescription());
        podcast.setLanguage(request.getLanguage());
        podcast.setHostName(request.getHostName());

        PodcastEntity saved = podcastRepository.save(podcast);

        return mapToResponse(saved);
    }

    //get podcast by id
    public PodcastResponse getPodcastById(Long podcastId){
        PodcastEntity podcast = podcastRepository.findById(podcastId).orElseThrow(
                () -> new RecourseNotFound("missing podcast by id " + podcastId));

        return mapToResponse(podcast);
    }

    // List
    public List<PodcastResponse> getAllPodcasts(){
        return podcastRepository.findByDeletedAtIsNull().stream().map(this::mapToResponse).toList();
    }



    //Mapper
    private PodcastResponse mapToResponse(PodcastEntity podcast){
        PodcastResponse response = new PodcastResponse();
        response.setId(podcast.getId());
        response.setTitle(podcast.getTitle());
        response.setCategory(podcast.getCategory());
        response.setLanguage(podcast.getLanguage());
        response.setHostName(podcast.getHostName());
        response.setDescription(podcast.getDescription());

        return response;
    }
}
