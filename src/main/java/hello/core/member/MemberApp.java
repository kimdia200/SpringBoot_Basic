package hello.core.member;

import hello.core.AppConfig;

public class MemberApp  {
    public static void main(String[] args) {
        MemberService memberService = new AppConfig().memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
