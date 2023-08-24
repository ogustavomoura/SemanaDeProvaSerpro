package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import entities.Account;

public class AccountTest {

    @Test
    public void isDepositWorkingProperly(){
        Account account = new Account(8532, "Alex Green", 500);
        account.depositar(200);
        Assertions.assertEquals(700.0, account.getBalance());
    } 

    @Test void isWithdrawWorkingProperly(){
        Account account = new Account(8532, "Alex Green", 700);
        account.saque(300);
        Assertions.assertEquals(395, account.getBalance());
    }
}
