package lab1;

import java.util.*;
import lab1.Company;
import lab1.Worker;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompanyTest {

    @Test(dataProvider = "in1")
    public void testFilter(List<Worker> list1, List<Worker> list2){
        assertEquals(list1,list2);
    }

    @DataProvider
    public Object[][] in1(){
        Worker w1 = new Worker.Builder().setId(1).setFirstname("Petrenko").setName("Petro").setLastname("Petrovych").setAge(35).build();
        Worker w2 = new Worker.Builder().setId(3).setFirstname("Ivanenko").setName("Ivan").setLastname("Ivanovych").setAge(40).build();
        Worker w3 = new Worker.Builder().setId(4).setFirstname("Maksymov").setName("Maksym").setLastname("Maksymovych").setAge(36).build();
        Worker w4 = new Worker.Builder().setId(5).setFirstname("Loza").setName("Ihor").setLastname("Petrovych").setAge(19).build();
        Worker w5 = new Worker.Builder().setId(7).setFirstname("Vatin").setName("Volodymyr").setLastname("Viktorovych").setAge(35).build();
        Worker w6 = new Worker.Builder().setId(2).setFirstname("Stepanov").setName("Stepan").setLastname("Stepanovych").setAge(41).build();
        Worker w7 = new Worker.Builder().setId(6).setFirstname("Kyznecov").setName("Oleh").setLastname("Dmytrovych").setAge(54).build();

        List<Worker> list = new ArrayList<Worker>();
        List<Worker> list1 = new ArrayList<Worker>();
        list.add(w1);
        list.add(w2);
        list.add(w3);
        list.add(w4);
        list.add(w5);

        list1.add(w1);
        list1.add(w2);
        list1.add(w3);
        list1.add(w4);
        list1.add(w5);
        list1.add(w6);
        list1.add(w7);

        return new Object[][]{{Company.filter(list1),list}};
    }

    @Test(dataProvider = "in2")
    public void testSort(List <Worker> list1, List<Worker> list2){
        assertEquals(list1,list2);
    }

    @DataProvider
    public Object[][] in2(){
        Worker w1 = new Worker.Builder().setId(1).setFirstname("Petrenko").setName("Petro").setLastname("Petrovych").setAge(35).build();
        Worker w2 = new Worker.Builder().setId(3).setFirstname("Ivanenko").setName("Ivan").setLastname("Ivanovych").setAge(40).build();
        Worker w3 = new Worker.Builder().setId(4).setFirstname("Maksymov").setName("Maksym").setLastname("Maksymovych").setAge(36).build();
        Worker w4 = new Worker.Builder().setId(5).setFirstname("Loza").setName("Ihor").setLastname("Petrovych").setAge(19).build();
        Worker w5 = new Worker.Builder().setId(7).setFirstname("Vatin").setName("Volodymyr").setLastname("Viktorovych").setAge(35).build();


        List<Worker> list = new ArrayList<Worker>();
        List<Worker> expectedlist = new ArrayList<Worker>();


        list.add(w1);
        list.add(w2);
        list.add(w3);
        list.add(w4);
        list.add(w5);

        expectedlist.add(w2);
        expectedlist.add(w4);
        expectedlist.add(w3);
        expectedlist.add(w1);
        expectedlist.add(w5);

        return new Object[][] {{Company.sort(list), expectedlist}};
    }
}
