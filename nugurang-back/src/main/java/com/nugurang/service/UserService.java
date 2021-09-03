package com.nugurang.service;

import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.UserInputDto;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final BoardDao boardDao;
    private final ImageDao imageDao;
    private final UserDao userDao;
    private final OAuth2Service oauth2Service;

    public UserEntity createUser(UserInputDto userInputDto) {
        return userDao.save(
            UserEntity
            .builder()
            .oauth2Provider(oauth2Service.getProvider())
            .oauth2Id(oauth2Service.getId())
            .name(userInputDto.getName())
            .email(userInputDto.getEmail())
            .biography(userInputDto.getBiography())
            .image(userInputDto.getImage().flatMap((id) -> imageDao.findById(id)).orElse(null))
            .blog(
                boardDao.save(
                    BoardEntity
                    .builder()
                    .name(UUID.randomUUID().toString())
                    .build()
                )
            )
            .build()
        );
    }

    public Optional<UserEntity> getUser(Long userId) {
        return userDao.findById(userId);
    }

    public Optional<UserEntity> getUser(String userName) {
        return userDao.findByName(userName);
    }

    public Optional<UserEntity> getCurrentUser() {
        return userDao.findByOauth2ProviderAndOauth2Id(
            oauth2Service.getProvider(),
            oauth2Service.getId()
        );
    }

    public List<UserEntity> getUsers(Pageable pageable) {
        return userDao.findAll(pageable).getContent();
    }

    public List<UserEntity> getUsers(String userName, Pageable pageable) {
        return userDao.findAllByNameContainingIgnoreCase(userName, pageable).getContent();
    }

    private UserEntity updateUser(UserInputDto userInputDto, UserEntity userEntity) {
        userEntity.setName(userInputDto.getName());
        userEntity.setEmail(userInputDto.getEmail());
        userEntity.setBiography(userInputDto.getBiography());
        userEntity.setImage(
            userInputDto
            .getImage()
            .flatMap((id) -> imageDao.findById(id)).orElse(null)
        );
        return userDao.save(userEntity);
    }

    public UserEntity updateUser(UserInputDto userInputDto, Long userId) {
        return updateUser(userInputDto, userDao.findById(userId).get());
    }

    public UserEntity updateCurrentUser(UserInputDto userInputDto) {
        return updateUser(userInputDto, getCurrentUser().get());
    }

    public Long deleteUser(UserEntity userEntity) {
        Long userId = userEntity.getId();
        userDao.delete(userEntity);
        return userId;
    }

    public Long deleteUser(Long userId) {
        userDao.deleteById(userId);
        return userId;
    }

    public Long deleteCurrentUser() {
        return deleteUser(getCurrentUser().get());
    }
}
