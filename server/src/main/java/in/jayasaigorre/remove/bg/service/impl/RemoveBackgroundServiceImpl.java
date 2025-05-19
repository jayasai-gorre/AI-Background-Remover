package in.jayasaigorre.remove.bg.service.impl;

import in.jayasaigorre.remove.bg.client.ClipdropClient;
import in.jayasaigorre.remove.bg.service.RemoveBackgroundService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class RemoveBackgroundServiceImpl implements RemoveBackgroundService {
    @Value("${clipdrop.apikey}")
    private String apiKey;

    private final ClipdropClient clipdropClient;;

    @Override
    public byte[] removeBackground(MultipartFile file) {
        return clipdropClient.removeBackground(file, apiKey);
    }
}
