package com.hanking.api.model;

import com.hanking.api.model.dto.AtletaDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Atleta {

    @Id
    private String id;
    private String nome;
    private String graduacao;
    private List<String> pontuacao;
    private String totalPonto;
    private String totalBonus;

    public static AtletaDto toDto(Atleta atleta) {
        AtletaDto dto = new AtletaDto();
        dto.setId(atleta.getId());
        dto.setNome(atleta.getNome());
        dto.setGraduacao(atleta.getGraduacao());
        dto.setPontuacao(atleta.getPontuacao());
        dto.setTotalBonus(atleta.getTotalBonus());
        dto.setTotalPonto(atleta.getTotalPonto());
        return dto;
    }

}
