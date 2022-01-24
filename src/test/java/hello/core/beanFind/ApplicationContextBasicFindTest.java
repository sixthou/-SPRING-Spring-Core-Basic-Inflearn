package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("빈 이름으로 조회")
    @Test
    void findBeanByName() {
        //given
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //when
        //then
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @DisplayName("이름 없이 타입으로만 조회")
    @Test
    void findBeanByType() {
        //given
        MemberService memberService = ac.getBean(MemberService.class);
        //when
        //then
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @DisplayName("구체 타입으로 조회")
    @Test
    void findBeanByType2() {
        //given
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //when
        //then
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("빈 이름으로 조회X")
    @Test
    void findBeanByNameX() {
        //given
        //ac.getBean("xxxx", MemberService.class)
        //when
        //then
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
    }
}
