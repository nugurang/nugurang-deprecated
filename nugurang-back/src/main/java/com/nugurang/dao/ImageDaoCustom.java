package com.nugurang.dao;

import com.nugurang.entity.ImageEntity;
import java.util.List;

public interface ImageDaoCustom {

    List<ImageEntity> findAllByArticleId(Long article);
}
