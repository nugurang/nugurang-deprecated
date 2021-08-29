package com.nugurang.graphql.resolver;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.VoteDto;
import com.nugurang.dto.VoteTypeDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VoteResolver implements GraphQLResolver<VoteDto> {
    private final UserDao userDao;
    private final ArticleDao articledDao;
    private final VoteTypeDao voteTypeDao;

    public UserDto user(VoteDto voteDto) {
        return null;
    }

    public ArticleDto article(VoteDto voteDto) {
        return null;
    }

    public VoteTypeDto voteType(VoteDto voteDto) {
        return null;
    }

}
