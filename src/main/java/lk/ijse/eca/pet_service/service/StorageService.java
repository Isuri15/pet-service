package lk.ijse.eca.pet_service.service;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class StorageService {

    @Value("${gcp.storage.bucket-name}")
    private String bucketName;

    private Storage storage;

    private Storage getStorage() {
        if (storage == null) {
            storage = StorageOptions.getDefaultInstance().getService();
        }
        return storage;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();

        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName)
                .setContentType(file.getContentType())
                .build();

        getStorage().create(blobInfo, file.getBytes());

        // Public URL format for GCS objects
        return String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);
    }

    public void deleteFile(String fileName) {
        getStorage().delete(bucketName, fileName);
    }
}