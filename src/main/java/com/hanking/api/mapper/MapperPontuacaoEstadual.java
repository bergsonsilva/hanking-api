package com.hanking.api.mapper;

import com.hanking.api.type.TypePontuacaoEstadual;

import java.util.HashMap;
import java.util.Map;

public class MapperPontuacaoEstadual {

    public static Map<String, Integer> map() {
        Map<String,Integer> pontuacao = new HashMap<>();
        pontuacao.put(TypePontuacaoEstadual.VITORIA.name(),10);
        pontuacao.put(TypePontuacaoEstadual.UNANIMIDADE.name(),3);
        pontuacao.put(TypePontuacaoEstadual.DIVIDIDA.name(),1);
        pontuacao.put(TypePontuacaoEstadual.NCT_FINALIZACAO_R1.name(),10);
        pontuacao.put(TypePontuacaoEstadual.NCT_FINALIZACAO_R2.name(),7);
        pontuacao.put(TypePontuacaoEstadual.NCT_FINALIZACAO_R3.name(),3);
        pontuacao.put(TypePontuacaoEstadual.NCT_FINALIZACAO_R4.name(),2);
        pontuacao.put(TypePontuacaoEstadual.NCT_FINALIZACAO_R5.name(),1);
        return pontuacao;
    }
}
