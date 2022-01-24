package lab1;

import java.util.Objects;
import java.util.regex.Pattern;

public class Worker {
    protected int id;
    protected String Firstname;
    protected String Name;
    protected String Lastname;
    protected int age;

    public static String FirstNamePattern = "[A-Z][a-z]+";
    public int getId() {
        return id;
    }

    public String getFirstname(){
        return Firstname;
    }

    public String getName() {
        return Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public int getAge() {
        return age;
    }

    public static class Builder{

        private Worker person;

        public Builder(){
            person = new Worker();
        }

        public Builder setId(int id)
        {
            if(id >=0){
                person.id = id;

            }
            else{
                throw new IllegalArgumentException("ID must be more than 0\n");
            }
            return this;

        }

        public Builder setFirstname(String firstname)
        {
            if(Pattern.matches(FirstNamePattern,firstname)){
                person.Firstname = firstname;
                return this;
            }
            else{
                throw new IllegalArgumentException("Firstname must begin from capital letter and cannot consists of number\n");
            }
        }

        public Builder setName(String name)
        {
            if(Pattern.matches(FirstNamePattern,name)){
                person.Name= name;
                return this;
            }
            else{
                throw new IllegalArgumentException("Name must begin from capital letter and cannot consists of number\n");
            }
        }

        public Builder setLastname(String lastname)
        {
            if(Pattern.matches(FirstNamePattern,lastname)){
                person.Lastname = lastname;
                return this;
            }
            else{
                throw new IllegalArgumentException("Lastname must begin from capital letter and cannot consists of number\n");
            }
        }

        public Builder setAge(int age)
        {
            if(age > 18 && age < 60){

                person.age = age;
                return this;
            }
            else{
                throw new IllegalArgumentException("Age must be more than 18 and less than 60\n");
            }
        }

        public Worker build(){
            return person;
        }
    }

    @Override
    public String toString() {
        return "\n Info about worker: [Worker_id -> " + id
                + "\nWorker Surname -> " + Firstname
                + "\nWorker Name -> " + Name
                + "\nWorker Lastname -> "+ Lastname
                + "\nWorker age -> "+ age
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id && age == worker.age && Firstname.equals(worker.Firstname) && Name.equals(worker.Name) && Lastname.equals(worker.Lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Firstname, Name, Lastname, age);
    }

    public static void main(String args[]){
    }
}
