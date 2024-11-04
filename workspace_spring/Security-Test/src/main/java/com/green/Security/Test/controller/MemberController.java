package com.green.Security.Test.controller;
import com.green.Security.Test.service.MemberService;
import com.green.Security.Test.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor //의존성 주입방식 > final 쓸때는 애 써줘야함! , 애는 요구되는(필수매개변수만) 넘겨줌!!!
// @NoArgsConstructor
// @AllArgsConstructor //클래스에서 선언된 모든 필드를 매개변수로 받는다.
public class MemberController {
    //의존성 주입방식 : 생성자 주입(적극권장), setter 주입, 필드 주입
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    // final 이 들어가면 값을 반드시 넣어줘야함 값이 안들어가면 오류 생김.
    // 단 객체 만들어지고 값을 넣으면 무조건 마지막에 들어가고 변하지않음!!!!!!!!!!!!
    // final 를 넣는 이유는 안전성 때문에!!!!!나중에 일어날 수 있는 버그를 방지하기위해서 붙이는게 좋음!

    //ex)
    // int a = 10; 그냥
    // final int a = 10  초기화가 되어버리면 값을 절대 못바꿈! 그래서 안전성이 올라감.

    /*
    @RequiredArgsConstructor
    무조건 final 이 들어가면 필수값이 설정이 되기때무넹 애는 전달함
    이런 애들은 전달하지 않음 왜냐면 !
    int number; -> 0
    private  PasswordEncoder passwordEncoder; -> null 값을 받기 때무에
    받을려면 반드시 final 을 넣어줘야함
    */

    /*
    @Autowired // 생성자 의존성 주입
                                            // 생성자들 ▽
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    } 자동으로 @Autowired 가 생기게 만들도록 만들어준거임 > @RequiredArgsConstructor를 쓰면 위에꺼 안만들어도되는거임! 의존성 알아서 만들어줌 애가 !!
    */


    //로그인 할 수 있는 페이지로 이동
    @GetMapping("/loginForm")
    public String loginForm(){
        String name = "java";

        // name 변수의 값을 암호화 , encode: 암호화
        String encodedName = passwordEncoder.encode(name);
        System.out.println(encodedName);
        // 똑같은 데이터를 호출해도 암호화를 설정해놓으면 암호화는 중복이 되지않음! 매번 똑같은 데이터라도 암호값이 다르게 나옴!!
        // 복구화는 없음 -> 그래서 임시비밀번호를 발급하거나 비밀번호를 새로 바꾸는거임!!!
        // 이렇게 호출하면 run 창에 $2a$10$d7G7unQY.N1AGCZ.f4abi.S1/kpiKgqhBsDZrgF8az4nqfnGTzAwG << 이렇게 암호화 뜸!

        String encodedName1 = passwordEncoder.encode(name);
        System.out.println(encodedName);

        // 첫번째 매개변수 : 암호화 되지않는 데이터
        // 두번째 매개변수 : 암호화 된 데이터
        // 복구화는 없습니다!!!@!@!!
       boolean result1 = passwordEncoder.matches("java", encodedName); // matches : 매치, 해석 : 애랑 같은거니?
       boolean result2 = passwordEncoder.matches("java", encodedName1);
       boolean result3 = passwordEncoder.matches("java1", encodedName);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        return "로그인 페이지로 이동";
    }

    //회원가입 페이지 이동
    @GetMapping("/joinForm")
    public String joinForm(){
        return "회원가입 페이지로 이동";
    }

    //회원가입
    @PostMapping("/join")
    public String join(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);

        //비밀번호 암호화
        String encodedPw = passwordEncoder.encode(memberVO.getMemPw()); //membervo 안에 비밀번호를 암호화하랏!
        memberVO.setMemPw(encodedPw);

        //기본권한
        memberVO.setMemRole("USER");
        memberService.join(memberVO);
        return "회원가입 성공!";
    }
}
