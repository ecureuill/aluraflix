package com.ecureuill.aluraflix.application.dtos;

import com.ecureuill.aluraflix.domain.video.Video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VideoRequest(
  @NotBlank
  String title,
  @NotBlank
  String description,
  @NotNull
  @Pattern(regexp = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()!@:%_\\+.~#?&\\/\\/=]*)")
  String url
) {

  public Video toEntity() {
    return new Video(null, title, description, url);
  }
  
}
