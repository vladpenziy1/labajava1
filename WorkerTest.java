package lab1;

import lab1.Worker;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkerTest {

    @Test(dataProvider = "test1")
    public void testSetterId(int id1){
        Worker ob1 = new Worker.Builder().setId(id1).build();
        assertEquals(ob1.getId(),id1);
    }

    @DataProvider
    public Object[][] test1(){
        return new Object[][] {{30},{40}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "test2")
    public void test1SetterId(int id1){
        Worker ob1 = new Worker.Builder().setId(id1).build();
    }

    @DataProvider
    public Object[][] test2(){
        return new Object[][] {{-10}};
    }

    @Test(dataProvider = "test3")
    public void testSetterFirsname(String value){
        Worker ob = new Worker.Builder().setFirstname(value).build();
        assertEquals(ob.getFirstname(),value);
    }

    @DataProvider
    public Object[][] test3(){
        return new Object[][] {{"Ivanenko"}};
    }


    @Test(dataProvider = "test4")
    public void testSetterName(String value){
        Worker ob = new Worker.Builder().setName(value).build();
        assertEquals(ob.getName(),value);
    }

    @DataProvider
    public Object[][] test4(){
        return new Object[][] {{"Ivan"}};
    }


    @Test(dataProvider = "test5")
    public void testSetterLastname(String value){
        Worker ob = new Worker.Builder().setLastname(value).build();
        assertEquals(ob.getLastname(),value);
    }

    @DataProvider
    public Object[][] test5(){
        return new Object[][] {{"Ivanovych"}};
    }


    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "test6")
    public void test1SetterInformation(String value, String value1, String value2){
        Worker ob = new Worker.Builder().setFirstname(value).setName(value1).setLastname(value2).build();
    }

    @DataProvider
    public Object[][] test6(){
        return new Object[][] {{"Petrenko","petro","Petrovych"}};
    }


    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "test7")
    public void testSetterAge(int age){
        Worker ob = new Worker.Builder().setAge(age).build();
    }

    @DataProvider
    public Object[][] test7(){
        return new Object[][] {{15}};
    }


    @Test(dataProvider = "test8")
    public void test1SetterAge(int age){
        Worker ob = new Worker.Builder().setAge(age).build();
        assertEquals(ob.getAge(),age);
    }

    @DataProvider
    public Object[][] test8(){
        return new Object[][] {{40}};
    }



    Worker ob3 = new Worker.Builder().setId(30).setFirstname("Franko").setName("Ivan").setLastname("Yakovych").setAge(55).build();
    Worker ob4 = new Worker.Builder().setId(30).setFirstname("Franko").setName("Ivan").setLastname("Yakovych").setAge(55).build();

    Worker ob5 = new Worker.Builder().setId(25).setFirstname("Marsimov").setName("Viktor").setLastname("Dmytrovych").setAge(50).build();
    Worker ob6 = new Worker.Builder().setId(25).setFirstname("Marsimov").setName("Viktor").setLastname("Dmytrovych").setAge(51).build();

    @Test(dataProvider = "test10")
    public void testEquals(Worker obj1, Worker obj2, boolean res){
        assertEquals(obj1.equals(obj2), res);
    }

    @DataProvider
    public Object[][] test10(){
        return new Object[][] {{ob3,ob4,true},{ob5,ob6,false}};
    }
}
