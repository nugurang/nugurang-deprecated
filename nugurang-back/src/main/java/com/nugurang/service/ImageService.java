package com.nugurang.service;

import com.nugurang.dao.ImageDao;
import com.nugurang.entity.ImageEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageDao imageDao;

    public ImageEntity createImage(String imageAddress) {
        return imageDao.save(
            ImageEntity
            .builder()
            .address(imageAddress)
            .build()
        );
    }

    public Optional<ImageEntity> getImage(Long id) {
        return imageDao.findById(id);
    }

    public Optional<ImageEntity> getImage(String address) {
        return imageDao.findByAddress(address);
    }

    public void deleteImage(Long id) {
        imageDao.deleteById(id);
    }
}
