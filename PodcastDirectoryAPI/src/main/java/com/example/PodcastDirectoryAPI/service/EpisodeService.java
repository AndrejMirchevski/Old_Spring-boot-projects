package com.example.PodcastDirectoryAPI.service;

import com.example.PodcastDirectoryAPI.dto.EpisodeCreateRequest;
import com.example.PodcastDirectoryAPI.dto.EpisodeResponse;
import com.example.PodcastDirectoryAPI.entity.EpisodeEntity;
import com.example.PodcastDirectoryAPI.entity.PodcastEntity;
import com.example.PodcastDirectoryAPI.exception.BusinessRuleException;
import com.example.PodcastDirectoryAPI.exception.RecourseNotFound;
import com.example.PodcastDirectoryAPI.repository.EpisodeRepository;
import com.example.PodcastDirectoryAPI.repository.PodcastRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final PodcastRepository podcastRepository;

    //Create an episode
    @Transactional
    public EpisodeResponse createEpisode(Long podcastId, EpisodeCreateRequest request){

        PodcastEntity podcast = podcastRepository.findById(podcastId).orElseThrow(
                () -> new RecourseNotFound("missing podcast by id " + podcastId)
        );

        Integer maxEpisodeNumber = episodeRepository.findByMaxEpisodesNumber(podcastId);
        int nextEpisodeNumber = (maxEpisodeNumber == null) ? 1 : maxEpisodeNumber + 1;

        if(request.getTitle() == null){
            throw new BusinessRuleException("Episode title can not be empty");
        }

        EpisodeEntity episode = new EpisodeEntity();

        episode.setTitle(request.getTitle());
        episode.setDescription(request.getDescription());
        episode.setEpisodeNumber(nextEpisodeNumber);
        episode.setPublishedAt(LocalDateTime.now());

        EpisodeEntity saved = episodeRepository.save(episode);

        return mapToResponse(saved);

    }

    //mapper
    private EpisodeResponse mapToResponse(EpisodeEntity episode){
        EpisodeResponse response = new EpisodeResponse();
        response.setId(episode.getId());
        response.setEpisodeNumber(episode.getEpisodeNumber());
        response.setTitle(episode.getTitle());
        response.setDescription(episode.getDescription());
        response.setPublishedAt(episode.getPublishedAt());

        return  response;
    }
}
