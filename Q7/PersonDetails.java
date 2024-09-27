

class Person{
    private String name;
    private int age;
    // Constructor
    public Person(String name, int age){
        this.name = name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
}

public class PersonDetails{
    public static void main(String[] args){
        //System.out.println("Kushal");
        Person p1 = new Person("Kushal Obroy",22);
        Person p2 = new Person("Kusum", 21);
        System.out.println(p1.getName()+" "+p1.getAge()+" years old");
        System.out.println(p2.getName()+" "+p2.getAge()+" years old");

        p1.setAge(0);
        p2.setName("Neha");
        System.out.println("Updated Name & Age :");
        System.out.println(p1.getName()+" "+p1.getAge()+" years old");
        System.out.println(p2.getName()+" "+p2.getAge()+" years old");

    }
}