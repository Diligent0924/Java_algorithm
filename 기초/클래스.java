package 기초;

class Person {
    String name;
    int age;
    void eat(){
        System.out.print(name + "님의 나이는 " + age + "입니다.");
    }
}

public class 클래스 {
    
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "홍길동";
        person1.age = 20;
        person1.eat();
    }
}
