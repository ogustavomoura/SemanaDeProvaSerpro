package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import entities.PessoaJuridica;

public class PessoaJuridicaTest {

    @Test
    public void isTaxWorkingProperly(){
        PessoaJuridica pessoaJuridica = new PessoaJuridica("SoftTech", 400000.0, 25);
        Assertions.assertEquals(56000.00000000001, pessoaJuridica.tax());
    }
    
}
