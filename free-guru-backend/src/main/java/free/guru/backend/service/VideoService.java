package free.guru.backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VideoService {
    public Resource loadVideoAsResource(String videoName) throws IOException;
    public String storeVideoToFileSystem(MultipartFile video) throws IOException;
}
