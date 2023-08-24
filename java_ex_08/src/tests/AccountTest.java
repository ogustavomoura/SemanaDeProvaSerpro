package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import entities.Account;
import exceptions.BusinessException;

public class AccountTest {
    
    @Test
    public void isDepositWorkingProperly(){
        // public Account(Integer number, String holder, Double balance, Double withdrawLimit)
        Account account = new Account(8021, "Bob Brown", 500.0, 300.0);
        account.deposit(250.0);
        Assertions.assertEquals(750.0, account.getBalance());
    }

    @Test
    public void isWithdrawWorkingProperly(){
        // public Account(Integer number, String holder, Double balance, Double withdrawLimit)
        Account account = new Account(8021, "Bob Brown", 500.0, 300.0);
        account.withdraw(100.0);
        Assertions.assertEquals(400.0, account.getBalance());
    }

    @Test
    public void isWithdrawExceedsLimitWorkingProperly(){
        // public Account(Integer number, String holder, Double balance, Double withdrawLimit)
        Account account = new Account(8021, "Bob Brown", 500.0, 300.0);
        
        Exception exception = assertThrows(BusinessException.class, () -> 
            { 
            account.withdraw(400.0); 
            });

        String expectedMessage = "Valor do saque excede o limite disponível!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void isWithdrawNoAvailableBalanceAndNoAvailableBalanceWorkingProperly(){
        Account account = new Account(8021, "Bob Brown", 500.0, 300.0);
        
        Exception exception = assertThrows(BusinessException.class, () -> 
            { 
            account.withdraw(800.0); 
            });

        String expectedMessage = "Valor do saque excede o limite disponível!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void isWithdrawNoAvailableBalanceWorkingProperly(){
        Account account = new Account(8021, "Bob Brown", 200.0, 300.0);
        
        Exception exception = assertThrows(BusinessException.class, () -> 
            { 
            account.withdraw(250.0); 
            });

        String expectedMessage = "Valor do saque excede o saldo disponível!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
