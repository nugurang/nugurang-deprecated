package com.nugurang.graphql.mutation;

import com.nugurang.dto.VoteDto;
import com.nugurang.dto.VoteInputDto;
import com.nugurang.service.VoteService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteMutation implements GraphQLMutationResolver {

    private final VoteService voteService;

    public VoteDto createVote(VoteInputDto voteInputDto) {
        return voteService.createVote(voteInputDto).toDto();
    }

    public VoteDto updateVote(VoteInputDto voteInputDto, Long voteId) {
        return voteService.updateVote(voteInputDto, voteId).toDto();
    }

    public Long deleteVote(Long voteId) {
        voteService.deleteVote(voteId);
        return voteId;
    }
}
