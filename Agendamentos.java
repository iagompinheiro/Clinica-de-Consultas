package co.iagomp;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Agendamentos {

    private DateTimeFormatter data;
    private String especialidade;

    public Agendamentos(DateTimeFormatter data, String especialidade) {
        this.data = data;
        this.especialidade = especialidade;
    }

    public DateTimeFormatter getData() {
        return data;
    }


    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamentos that = (Agendamentos) o;
        return Objects.equals(data, that.data) && Objects.equals(especialidade, that.especialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, especialidade);
    }
}
