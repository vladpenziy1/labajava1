package lab1;

import java.util.*;

import lab1.Worker;
public class Company {

    private String nameCompany;
    private int numberCompany;
    private List<Worker> list;


    public String getNameCompany() {
        return nameCompany;
    }

    public int getNumberCompany() {
        return numberCompany;
    }

    public List<Worker> getList() {
        return list;
    }


    public static class Create{

        private Company company;

        public Create(){
            company = new Company();
        }

        public Create setNameCompany(String NameCompany){
            company.nameCompany = NameCompany;
            return this;
        }

        public Create setNumberCompany(int NumberCompany){
            company.numberCompany = NumberCompany;
            return this;
        }

        public Create setListWorkers(List<Worker> list){
            company.list = list;
            return this;
        }

        public Company createCompany(){
            return company;
        }
    }


    public static List<Worker> filter(List<Worker> list){

        for(int i = list.size()-1; i >=0 ;i--){
            if(list.get(i).getAge() > 40) {
                list.remove(i);
            }
        }

        return list;
    }

    public static List<Worker> sort(List<Worker> list){
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object WorkerOne, Object WorkerTwo) {
                return ((Worker) WorkerOne).getFirstname().compareTo(((Worker) WorkerTwo).getFirstname());
            }
        });

        return list;
    }

    @Override
    public String toString(){
        return "Name company: -> " + nameCompany
                + "\nCode company: -> " + numberCompany
                + "\nList workers: -> "+list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return numberCompany == company.numberCompany && nameCompany.equals(company.nameCompany) && list.equals(company.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameCompany, numberCompany, list);
    }

    public static void main(String args[]) {

        Worker Worker1 = new Worker.Builder().setId(1).setFirstname("Petrenko").setName("Petro").setLastname("Petrovych").setAge(35).build();
        Worker Worker2 = new Worker.Builder().setId(2).setFirstname("Stepanov").setName("Stepan").setLastname("Stepanovych").setAge(41).build();
        Worker Worker3 = new Worker.Builder().setId(3).setFirstname("Ivanenko").setName("Ivan").setLastname("Ivanovych").setAge(40).build();
        Worker Worker4 = new Worker.Builder().setId(4).setFirstname("Maksymov").setName("Maksym").setLastname("Maksymovych").setAge(36).build();
        Worker Worker5 = new Worker.Builder().setId(5).setFirstname("Loza").setName("Ihor").setLastname("Petrovych").setAge(19).build();
        Worker Worker6 = new Worker.Builder().setId(6).setFirstname("Kyznecov").setName("Oleh").setLastname("Dmytrovych").setAge(54).build();
        Worker Worker7 = new Worker.Builder().setId(7).setFirstname("Vatin").setName("Volodymyr").setLastname("Viktorovych").setAge(35).build();

        List<Worker> l = new ArrayList<Worker>();
        l.add(Worker1);
        l.add(Worker2);
        l.add(Worker3);
        l.add(Worker4);
        l.add(Worker5);
        l.add(Worker6);
        l.add(Worker7);

        List<Worker> l2 = new ArrayList<Worker>();
        List<Worker> l3 = new ArrayList<Worker>();


        l2 = filter(l);


        l3 = sort(l2);
        Company obj = new Company.Create().setNameCompany("Glovo").setNumberCompany(1).setListWorkers(l3).createCompany();

         System.out.println(obj);
    }
}
