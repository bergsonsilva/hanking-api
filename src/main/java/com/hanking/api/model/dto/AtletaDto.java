package com.hanking.api.model.dto;

import com.hanking.api.model.Atleta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtletaDto {

    private String id;
    private String nome;
    private String graduacao;
    private List<String> pontuacao;
    private String totalPonto;
    private String totalBonus;

    public Atleta toEntity(AtletaDto dto) {
        Atleta entity = new Atleta();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setGraduacao(dto.getGraduacao());
        entity.setPontuacao(dto.getPontuacao());
        entity.setTotalBonus(dto.getTotalBonus());
        entity.setTotalPonto(dto.getTotalPonto());
        return entity;
    }

}
