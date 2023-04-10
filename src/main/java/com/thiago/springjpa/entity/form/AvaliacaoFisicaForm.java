package com.thiago.springjpa.entity.form;

import com.thiago.springjpa.entity.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O id do aluno precisa ser positivo")
    private Long alunoId;

    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O peso precisa ser positivo")
    private double peso;

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "A altura precisa ser positiva")
    private double altura;
}
