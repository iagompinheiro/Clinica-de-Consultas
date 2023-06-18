package co.iagomp;

import java.util.Objects;

public class Paciente {
    private String nome;
    private long contato;

    public Paciente(String nome, long contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public long getContato() {
        return contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return contato == paciente.contato && Objects.equals(nome, paciente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, contato);
    }
}
