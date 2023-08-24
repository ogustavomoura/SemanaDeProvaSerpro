package test;

import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import entities.HourContract;

public class HourContractTest {
    
    @Test
    public void isTotalValueWorkingProperly(){
        // public HourContract(Date date, Double valuePerHour, Integer hours) 
        HourContract hourContract = new HourContract(new Date(), 50.0, 5);
        Assertions.assertEquals(250.0, hourContract.totalValue()); 
    }
}
