package free.guru.backend.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {
    @Value("${video.storage.path}")
    private Path videoStoragePath;

    @Override
    public Resource loadVideoAsResource(String videoName) throws IOException {
        Path videoPath = videoStoragePath.resolve(videoName);

        return new UrlResource(videoPath.toUri());
    }

    @Override
    public String storeVideoToFileSystem(MultipartFile video) throws IOException {
        String extension = FilenameUtils.getExtension(video.getOriginalFilename());
        String filename = UUID.randomUUID() + "." + extension;

        Path destination = videoStoragePath.resolve(Paths.get(filename)).normalize().toAbsolutePath();

        try (InputStream inputStream = video.getInputStream()) {
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
        }

        return filename;
    }
}
