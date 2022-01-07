package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest_3 {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        //타입으로 하는경우 같은타입이 여러개 일경우 불편한점이있다.
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByName2(){
        //하지만 구체타입으로 적으면 구현에 의존하기때문에 좋은코드가 아니다.
        //그냥 되나 안되나만 확인한 정도라고 생각하면 좋을듯
        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
//        ac.getBean("xxxx",MemberService.class);
        //assertThrows를 사용하는건 jupiter
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,() -> ac.getBean("xxxx",MemberService.class));
    }
}
