import java.time.LocalDate;
import java.util.ArrayList;

public class Garcon {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private Long telefone;
    private String sexo;
    private Double salarioFixo;
    private ArrayList<Mesa> listaMesas = new ArrayList<>();
    public Garcon(final String nome,
                  final String cpf,
                  final String dataNascimento,
                  final String email,
                  final Long telefone,
                  final String sexo,
                  final Double salarioFixo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.salarioFixo = salarioFixo;
    }

    public ArrayList<Mesa> getListaMesas() {return listaMesas;}
    public void setMesa(Mesa mesa) {this.listaMesas.add(mesa);}

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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(Double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }
}
