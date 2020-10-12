package com.nugurang.graphql;

import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardResolver implements GraphQLResolver<BoardDto> {
    private final UserDao userDao;
    private final ThreadDao threadDao;

    public List<UserDto> users(BoardDto boardDto) {
        return null;
    }

    public List<ThreadDto> threads(BoardDto boardDto, int page, int pageSize) {
        return null;
    }
}
