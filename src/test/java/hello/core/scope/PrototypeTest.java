package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean PrototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean PrototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        System.out.println("prototypeBean1 = " + PrototypeBean1);
        System.out.println("prototypeBean2 = " + PrototypeBean2);
        Assertions.assertThat(PrototypeBean1).isNotSameAs(PrototypeBean2);
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean{
        @Scope("singleton")
        static class SingletonBean {
            @PostConstruct
            public void init() {
                System.out.println("SingleTonBean.init");

            }

            @PreDestroy
            public void destroy() {
                System.out.println("SingletonBean.destroy");
            }
        }
    }

}
