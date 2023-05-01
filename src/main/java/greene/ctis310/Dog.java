package greene.ctis310;

public class Dog {
    //attributes
    private String name;
    private int age;
    private String breed;
    private String color;
    private int barked = 0;

    //constructors
    public Dog() {
        name = "Fido";
        age = 0;
        breed = "mutt";
        color = "brown";
    }

    public Dog(String name, int age, String breed, String color) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
    }

    //create a method that makes the dog bark
    public void bark() {
        barked++;
    }


    //getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getBarked() {
        return barked;
    }

    public void setBarked(int barked) {
        this.barked = barked;
    }

    //toString
    @Override
    public String toString() {
        return "Dog [age=" + age + ", breed=" + breed + ", color=" + color + ", name=" + name + "]";
    }
}
