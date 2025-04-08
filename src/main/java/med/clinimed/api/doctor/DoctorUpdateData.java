package med.clinimed.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.clinimed.api.endereco.EnderecoData;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoData endereco) {
}
