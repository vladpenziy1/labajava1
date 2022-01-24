package lab1;

import java.util.*;
import java.util.regex.Pattern;

import lab1.Worker;
import lab1.Company;
import lab1.Worker.Builder;

public class City {
    private String nameCity;
    private String nameCountry;
    private List<Company> masiv = new ArrayList<Company>();
    public static String Patt = "S[a-z]+";

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }


    @Override
    public String toString() {
        return "\nCity: [name city -> " + nameCity
                + "\nname country -> " + nameCountry
                + "\nlist company in this city -> " + masiv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return nameCity.equals(city.nameCity) && nameCountry.equals(city.nameCountry) && masiv.equals(city.masiv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameCity, nameCountry, masiv);
    }

    public static void main(String args[]){

        Worker Worker1 = new Builder().setId(1).setFirstname("Petrenko").setName("Petro").setLastname("Petrovych").setAge(35).build();
        Worker Worker2 = new Builder().setId(2).setFirstname("Stepanov").setName("Stepan").setLastname("Stepanovych").setAge(41).build();
        Worker Worker3 = new Builder().setId(3).setFirstname("Ivanenko").setName("Ivan").setLastname("Ivanovych").setAge(40).build();
        Worker Worker4 = new Builder().setId(4).setFirstname("Maksymov").setName("Maksym").setLastname("Maksymovych").setAge(36).build();
        Worker Worker5 = new Builder().setId(5).setFirstname("Loza").setName("Ihor").setLastname("Petrovych").setAge(19).build();
        Worker Worker6 = new Builder().setId(6).setFirstname("Kyznecov").setName("Oleh").setLastname("Dmytrovych").setAge(54).build();
        Worker Worker7 = new Builder().setId(7).setFirstname("Vatin").setName("Volodymyr").setLastname("Viktorovych").setAge(35).build();

        List<Worker> l1 = new ArrayList<Worker>();
        List<Worker> l2 = new ArrayList<Worker>();
        List<Worker> l3 = new ArrayList<Worker>();
        List<Worker> l4 = new ArrayList<Worker>();


        l1.add(Worker1);
        l1.add(Worker2);
        l2.add(Worker3);
        l2.add(Worker4);
        l3.add(Worker5);
        l3.add(Worker6);
        l3.add(Worker7);
        l4.add(Worker2);
        l4.add(Worker5);

        Company obj1 = new Company.Create().setNameCompany("Glovo").setNumberCompany(1).setListWorkers(l1).createCompany();
        Company obj2 = new Company.Create().setNameCompany("Nova poshta").setNumberCompany(2).setListWorkers(l2).createCompany();
        Company obj3 = new Company.Create().setNameCompany("Softserve").setNumberCompany(3).setListWorkers(l3).createCompany();
        Company obj4 = new Company.Create().setNameCompany("Science").setNumberCompany(4).setListWorkers(l4).createCompany();

        City ob = new City();
        ob.setNameCity("Chernivtsi");
        ob.setNameCountry("Ukraine");
        ob.masiv.add(obj1);
        ob.masiv.add(obj2);
        ob.masiv.add(obj3);
        ob.masiv.add(obj4);

      for (int i = 0; i < ob.masiv.size();i++){
         if(Pattern.matches(Patt,ob.masiv.get(i).getNameCompany())){
             for(int j = 0; j < ob.masiv.get(i).getList().size(); j++){
                 if(ob.masiv.get(i).getList().get(j).getAge() > 40){
                     System.out.println(ob.masiv.get(i).getList().get(j));
                 }
             }
         }


      }


    }
}
