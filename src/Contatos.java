import java.util.Objects;

public class Contatos {

    private String nome;
    private int Idade;
    private String CPF;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public Contatos(String nome, int idade, String CPF, String telefone) throws NullPointerException,AgeNotAllowed {
        Objects.requireNonNull(nome,"NAME IS NULL");
        Objects.requireNonNull(telefone,"NUMBER IS NULL");
        Objects.requireNonNull(CPF,"CPF IS NULL");

        if(idade < 18){
            throw new AgeNotAllowed("A pessoa precisa ser maior de 18 anos");
        }else{
            setNome(nome);
            setIdade(idade);
            setTelefone(telefone);
            setCPF(CPF);
        }
    }

    @Override
    public String toString() {
        return "Contatos{" +
                "nome='" + nome + '\'' +
                ", Idade=" + Idade +
                ", CPF='" + CPF + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contatos contatos = (Contatos) o;
        return Objects.equals(CPF, contatos.CPF) && Objects.equals(telefone, contatos.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF, telefone);
    }
}

