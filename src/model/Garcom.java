package model;

import constate.TipoSexo;

import java.util.ArrayList;
import java.util.Date;

public class Garcom {

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private Long telefone;
    private TipoSexo sexo;
    private Double salarioFixo;
    private ArrayList<Mesa> listaMesas = new ArrayList<>();

    public Garcom() {
    }

    public Garcom(
            final Long id,
            final String nome,
            final String cpf,
            final Date dataNascimento,
            final String email,
            final Long telefone,
            final TipoSexo sexo,
            final Double salarioFixo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.salarioFixo = salarioFixo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setListaMesas(ArrayList<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }

    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void setMesa(Mesa mesa) {
        this.listaMesas.add(mesa);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public Double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(Double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }
}
