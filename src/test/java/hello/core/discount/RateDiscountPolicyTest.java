package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new AppConfig().discountPolicy();

    @Test
    @DisplayName("VIP는 20% 할인이 적용되어야 한다")
    void vip() {
        //given
        Member vip = new Member(1L, "VIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(vip, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("Basic는 0% 할인이 적용되어야 한다")
    void basic() {
        //given
        Member basic = new Member(1L, "VIP", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(basic, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}