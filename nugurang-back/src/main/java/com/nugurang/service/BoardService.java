package com.nugurang.service;

import com.nugurang.dao.BoardDao;
import com.nugurang.dto.BoardInputDto;
import com.nugurang.entity.BoardEntity;
import com.nugurang.exception.NotFoundException;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;
    private final MutableAclService mutableAclService;
    private final OAuth2Service oauth2Service;

    @Transactional
    public BoardEntity createBoard(BoardInputDto boardInputDto) {
        final var board = boardDao.save(
            BoardEntity
            .builder()
            .name(boardInputDto.getName())
            .build()
        );

        final var oid = new ObjectIdentityImpl(BoardEntity.class, board.getId());
        final var acl = mutableAclService.createAcl(oid);
        final var auth = oauth2Service.getOAuth2AuthToken();
        final var sid = new PrincipalSid(auth);
        acl.insertAce(acl.getEntries().size(), BasePermission.READ, sid, true);
        acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, sid, true);
        acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, sid, true);
/*
        acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid("ADMIN"), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, new GrantedAuthoritySid("ADMIN"), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, new GrantedAuthoritySid("ADMIN"), true);
*/
        return board;
    }

    public BoardEntity getBoard(Long id) throws NotFoundException {
        return boardDao
            .findById(id)
            .orElseThrow(() -> NotFoundException
                .builder()
                .message("Board not found")
                .objectName("Board")
                .build()
            );
    }

    public BoardEntity getBoard(String name) throws NotFoundException {
        return boardDao
            .findByName(name)
            .orElseThrow(() -> NotFoundException
                .builder()
                .message("Board not found")
                .objectName("Board")
                .build()
            );
    }

    public List<BoardEntity> getBoards() {
        return boardDao.findAll();
    }

    public List<BoardEntity> getBoards(List<String> names) {
        return boardDao.findAllByNameIn(names);
    }

    public BoardEntity updateBoard(BoardInputDto boardInputDto, Long boardId) {
        final var boardEntity = boardDao.getById(boardId);
        boardEntity.setName(boardInputDto.getName());
        return boardDao.save(boardEntity);
    }

    public void deleteBoard(Long id) {
        boardDao.deleteById(id);
    }
}
