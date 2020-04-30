// Posted from EduTools plugin
class Cat {

    private String name;
    private int age;
    public static int counter = 0;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        Cat.counter++;
        if(Cat.counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return Cat.counter;
    }
}