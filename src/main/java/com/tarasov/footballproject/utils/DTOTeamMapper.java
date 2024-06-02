package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.get.GetTeamDTO;
import com.tarasov.footballproject.dto.post.PostTeamDTO;
import com.tarasov.footballproject.entities.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DTOTeamMapper implements Function<GetTeamDTO, PostTeamDTO> {

    @Override
    public PostTeamDTO apply(GetTeamDTO getTeamDTO) {
        return new PostTeamDTO(
                getTeamDTO.getTeamName(),
                getTeamDTO.getTeamCity(),
                getTeamDTO.getTeamStadium()
        );
    }
}