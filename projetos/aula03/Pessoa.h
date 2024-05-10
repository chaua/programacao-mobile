
class Pessoa {
public:
    // Construtor
    Pessoa();
    Pessoa(string nome, int idade);

    // Destrutor
    ~Pessoa();

    // Métodos
    void imprimir();
    void fazerAniversario();

    // Métodos acessores (getters) e mutantes (setter)
    string getNome();
    int getIdade();

    void setNome(string nome);
    void setIdade(int idade);

private:
    // Atributos
    string _nome;
    int _idade;

}