package com.ecureuill.aluraflix.application.exceptions;

import java.util.UUID;

public class VideoNotFoundException extends Exception {
  public VideoNotFoundException(UUID id) {
    super("Video " + id + " not found");
  }

}
