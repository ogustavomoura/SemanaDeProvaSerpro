package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import entities.PessoaFisica;

public class PessoaFisicaTest {

    @Test
    public void isTaxWorkingProperly(){
        PessoaFisica PessoaFisica = new PessoaFisica("Alex", 50000.0, 2000.0);
        Assertions.assertEquals(11500.0, PessoaFisica.tax());
    }
    
}
