package hello.core;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class HelloLombok {

    private String name;
    private  int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");
        String name = helloLombok.getName();
        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);

    }
}
