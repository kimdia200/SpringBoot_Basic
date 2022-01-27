package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest_1 {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        // Bean에 선언한 이름들을 가져옴
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter 자동완성하면 바로 위의 배열이 포이치문으로 됨
        for (String beanDefinitionName : beanDefinitionNames) {
            //이름으로 객체를 하나 가져온다
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = "+beanDefinitionName+" object = "+bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        // Bean에 선언한 이름들을 가져옴
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter 자동완성하면 바로 위의 배열이 포이치문으로 됨
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition  beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            Object bean = ac.getBean(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("Application Bean name = "+beanDefinitionName+", object = "+bean);
            }else if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
                System.out.println("Infrastructure Bean name = "+beanDefinitionName+", object = "+bean);
            }
        }
    }
}
