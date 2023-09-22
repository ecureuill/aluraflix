package com.ecureuill.aluraflix.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecureuill.aluraflix.application.dtos.VideoRequest;
import com.ecureuill.aluraflix.application.dtos.VideoResponse;
import com.ecureuill.aluraflix.application.exceptions.VideoNotFoundException;
import com.ecureuill.aluraflix.application.services.VideoService;
import com.ecureuill.aluraflix.domain.video.Video;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoController {
  
  private final VideoService videoService;
  
  @GetMapping
  public ResponseEntity<List<VideoResponse>> getVideos(){
    List<Video> videos = videoService.findAll();
    return ResponseEntity.ok(VideoResponse.from(videos));
  } 

  @GetMapping("/{id}")
  public ResponseEntity<VideoResponse> getVideo(@PathVariable UUID id) throws VideoNotFoundException {
    Video video = videoService.findById(id);
    return ResponseEntity.ok(VideoResponse.from(video));
  }

  @PostMapping
  public ResponseEntity<VideoResponse> createVideo(@RequestBody @Valid VideoRequest data) {
    Video video = videoService.save(data);
    return ResponseEntity.ok(VideoResponse.from(video));
  }

  @PutMapping("/{id}")
  public ResponseEntity<VideoResponse> updateVideo(@PathVariable UUID id,@RequestBody @Valid VideoRequest data) throws VideoNotFoundException {
    Video video = videoService.update(id, data);
    return ResponseEntity.ok(VideoResponse.from(video));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVideo(@PathVariable UUID id) throws VideoNotFoundException {
    videoService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
