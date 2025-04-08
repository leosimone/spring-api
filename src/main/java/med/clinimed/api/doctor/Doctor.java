package med.clinimed.api.doctor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.clinimed.api.endereco.Endereco;

@Table(name="doctors")
@Entity(name="Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean active;

    public Doctor(DoctorData data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Endereco(data.endereco());
        this.active = true;
    }

    public void updateInfo(@Valid DoctorUpdateData data) {
        if(data.nome() != null) this.nome = data.nome();
        if(data.telefone() != null) this.telefone = data.telefone();
        if(data.endereco() != null) this.endereco.updateAddress(data.endereco());
    }

    public void deleteLogical() {
      this.active = false;
    }
}
