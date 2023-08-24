package entities;

public class PessoaFisica extends Pessoa{

    private Double gastosComSaude; 

    public PessoaFisica(){

    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public Double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(Double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public Double tax() {
        if (getRendaAnual() < 20000) return getRendaAnual() * 0.15 - gastosComSaude * 0.5;
        else return getRendaAnual() * 0.25 - gastosComSaude * 0.5;
    }


    
}
