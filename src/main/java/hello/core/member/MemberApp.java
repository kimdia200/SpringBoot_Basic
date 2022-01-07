package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp  {
    public static void main(String[] args) {
//        MemberService memberService = new AppConfig().memberService();

        //어노테이션 기반 컨텍스르를 만들어서 @configuration 에서 설정한 Bean을 사용 할 수 있다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
