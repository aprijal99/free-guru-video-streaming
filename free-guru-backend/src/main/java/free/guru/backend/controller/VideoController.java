package free.guru.backend.controller;

import free.guru.backend.service.VideoService;
import free.guru.backend.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/video")
public class VideoController {
    private final VideoService videoService;

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadVideo(@RequestParam(name = "video") MultipartFile video) {
        try {
            String videoFilename = videoService.storeVideoToFileSystem(video);

            return Response.getResponse(HttpStatus.CREATED, Map.of("videoFilename", videoFilename));
        } catch (IOException e) {
            return Response.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
