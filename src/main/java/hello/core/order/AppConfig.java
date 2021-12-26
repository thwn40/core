package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Bean memberService -> new MemoryMemberRepository()
//@Bean orderService -> new MemoryMemberRepository()

@Configuration
public class AppConfig {

   /*
    System.out.println("AppConfig.memberService");
    System.out.println("AppConfig.memberRepository");
    System.out.println("AppConfig.memberRepository");
    System.out.println("AppConfig.orderService");
    System.out.println("AppConfig.memberRepository");
    System.out.println("AppConfig.discountPolicy");
    */

    /*
    System.out.println("AppConfig.memberService");
    System.out.println("AppConfig.memberRepository");
    System.out.println("AppConfig.orderService");
    어떠한 방법을 통해서든 싱글톤을 보장해준다
     */
    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();

    }

    @Bean

    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }




}
