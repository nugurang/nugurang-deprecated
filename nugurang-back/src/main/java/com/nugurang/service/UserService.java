package com.nugurang.service;

import com.nugurang.dao.UserDao;
import com.nugurang.entity.UserEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final OAuth2Service oauth2Service;

    public Optional<UserEntity> getCurrentUser() {
        return userDao.findByOauth2ProviderAndOauth2Id(
            oauth2Service.getProvider(),
            oauth2Service.getId()
        );
    }
}
