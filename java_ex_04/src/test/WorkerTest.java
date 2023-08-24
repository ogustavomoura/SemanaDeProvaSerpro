package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class WorkerTest {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void isAddContractWorkingProperly(){
        // public Worker(String name, WorkerLevel level, Double baseSalary, Department department)
        // public Department(String name)
        Worker worker = new Worker("Alex", WorkerLevel.valueOf("MID_LEVEL"), 1500.0, new Department("Design"));
        HourContract hourContract = new HourContract(new Date(), 50.0, 5);
        worker.addContract(hourContract);
        List<HourContract> list = new ArrayList<>();
        list.add(hourContract);
        Assertions.assertEquals(list, worker.getContracts());
    }

    @Test
    public void isRemoveContractWorkingProperly(){
        Worker worker = new Worker("Alex", WorkerLevel.valueOf("MID_LEVEL"), 1500.0, new Department("Design"));
        HourContract hourContract1 = new HourContract(new Date(), 50.0, 5);
        HourContract hourContract2 = new HourContract(new Date(), 23.0, 2);
        worker.addContract(hourContract1);
        worker.addContract(hourContract2);
        worker.removeContract(hourContract1);
        List<HourContract> list = new ArrayList<>();
        list.add(hourContract1);
        list.add(hourContract2);
        list.remove(hourContract1);
        Assertions.assertEquals(list, worker.getContracts());
    }

    @Test
    public void isIncomeWorkingProperly() throws ParseException{
        double baseSalary = 1500.0;
        Worker worker = new Worker("Alex", WorkerLevel.valueOf("MID_LEVEL"), baseSalary, new Department("Design"));
        HourContract hourContract1 = new HourContract(sdf.parse("23/08/2023"), 50.0, 5);
        HourContract hourContract2 = new HourContract(sdf.parse("12/05/2023"), 23.0, 2);
        worker.addContract(hourContract1);
        worker.addContract(hourContract2);
        double expectedIncome = 1500.0 + 50.0 * 5;
        Assertions.assertEquals(expectedIncome, worker.income(2023, 8));
    }
    
}
