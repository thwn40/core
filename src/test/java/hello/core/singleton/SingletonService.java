package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
/*
싱글톤의 문제점
1.구체클래스의 의존하기된다
2.OCP를 위반할 가능성이 높다
3.자식클래스를 만들기 어렵다
 */
