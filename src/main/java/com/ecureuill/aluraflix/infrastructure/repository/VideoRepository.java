package com.ecureuill.aluraflix.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecureuill.aluraflix.domain.video.Video;

public interface VideoRepository extends JpaRepository<Video, UUID> {
  
}
