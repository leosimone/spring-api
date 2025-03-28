package med.clinimed.api.doctor;

public record DoctorListData(String nome, String email, String crm, Especialidade especialidade) {

    public DoctorListData(Doctor doctor) {
        this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
    }
}
