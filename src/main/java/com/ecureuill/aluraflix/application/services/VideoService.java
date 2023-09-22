package com.ecureuill.aluraflix.application.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecureuill.aluraflix.application.dtos.VideoRequest;
import com.ecureuill.aluraflix.application.exceptions.VideoNotFoundException;
import com.ecureuill.aluraflix.domain.video.Video;
import com.ecureuill.aluraflix.infrastructure.repository.VideoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoService {

  private final VideoRepository videoRepository;
  
  public List<Video> findAll() {
    return videoRepository.findAll();
  }

  public Video findById(UUID id) throws VideoNotFoundException {
    return videoRepository.findById(id).orElseThrow(() -> new VideoNotFoundException(id));
  }

  public Video save(VideoRequest data) {
    Video video = data.toEntity();
    return videoRepository.save(video);
  }

  public Video update(UUID id, VideoRequest data) throws VideoNotFoundException {
    if(!videoRepository.existsById(id)){
      throw new VideoNotFoundException(id);
    }

    Video video = data.toEntity();
    video.setId(id);
    return videoRepository.save(video);
  }

  public void delete(UUID id) throws VideoNotFoundException {
    if(!videoRepository.existsById(id)){
      throw new VideoNotFoundException(id);
    }
    videoRepository.deleteById(id);
  }

}
