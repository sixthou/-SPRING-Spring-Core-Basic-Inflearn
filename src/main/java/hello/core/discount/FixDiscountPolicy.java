package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import javax.naming.spi.DirObjectFactory;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int Discount(final Member member, final int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
