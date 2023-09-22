package com.ecureuill.aluraflix.application.dtos;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.ecureuill.aluraflix.domain.video.Video;

public record VideoResponse(
  UUID id,
  String title,
  String description,
  String url
) {
  public static VideoResponse from(Video video){
    return new VideoResponse(video.getId(), video.getTitle(), video.getDescription(), video.getUrl());
  }

  public static List<VideoResponse> from(List<Video> videos){
    return videos.stream().map(VideoResponse::from).collect(Collectors.toList());
  }
}
