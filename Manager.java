package lab1;

import java.util.Objects;
public class Manager extends Worker{

    private int salary;
    private int experience;

    public Manager(Worker obj){

        this.id = obj.getId();
        this.Firstname = obj.getFirstname();
        this.Name = obj.getName();
        this.Lastname = obj.getLastname();
        this.age = obj.getAge();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void growSalary(){
        if(this.experience > 5){
            this.salary = ((int) (this.salary*1.2));
        }
    }

    @Override
    public String toString(){

        return "\n Info about worker: [Worker_id -> " + id
                + "\nWorker Surname -> " + Firstname
                + "\nWorker Name -> " + Name
                + "\nWorker Lastname -> "+ Lastname
                + "\nWorker age -> "+ age
                + "]" +
                "\nManager has salary -> "+ salary
                + " and his work experience -> "
                + experience +"\n";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return salary == manager.salary && experience == manager.experience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, experience);
    }

    public static void main(String args[]){


        Manager m1 = new Manager(new Worker.Builder().setId(1).setFirstname("Ivanenko").setName("Ivan").setLastname("Petrovych").setAge(34).build());
        Manager m2 = new Manager(new Worker.Builder().setId(2).setFirstname("Maksymov").setName("Maks").setLastname("Petrovych").setAge(49).build());
        m1.setSalary(1500);
        m1.setExperience(4);

        m2.setSalary(2100);
        m2.setExperience(7);


        m1.growSalary();
    m2.growSalary();
       System.out.println(m1);
       System.out.println(m2);
    }

}
