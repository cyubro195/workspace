package com.green.Security.Test.config;

import jakarta.websocket.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// 이 클래스에서 시큐리티의 인증 및 인가에 대한 설정
@Configuration // 클래스에 대한 객체 생성 어노테이션
@EnableWebSecurity // 해당 클래스가 시큐리티 설정 클래스임을 인지
public class SecurityConfig {

    //메소드 만들기
    // 비밀번호를 암호화 시켜줄 수 있는 객체 생성 메서드
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

/*   시큐리티의 인증 및 인가에 대한 설정을 진행하는 메서드
     이러한 메서드는 공식문서에 가이드에 설명된 내용을 토대로 구현

     프로젝트 생성 시 security 를 사용하겠다고 선언만 하면
     우리가 만든 모든 요청에 대해서 인증을 받도록 기본설정이 되어있어
     어떠한 페이지로도 접근할 수 없다.

     아래 메서드에서 인증 및 인가 설정을 하게되면 기본적으로 모든 요청을 막던 설정이
     우리가 작성한 코드의 설정대로 진행하게 된다.

*/
    // ▼ 런 하자마자 실행됨
    @Bean // : 지금까지와의 어노테이션과 다르게 메서드 위에 작성한다. 이 어노테이션은 메서드의 리턴 데이터를 객체로 생성하는 기능
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
        //csrf - Cross-site Request Forgery
        //csrf 공격에 대한 방기재를 사용하지않겠다.
        // jwt 로그인은 csrf 공격에 상대적으로 안전하기 때문에 사용안함
        // @@@ jwt 토큰에 대해서 좀 찾아좍!!!!
        httpSecurity.csrf(auth -> auth.disable());

        // form 로그인 방식을 미사용으로 지정
        // react를 제외한 나머지 전통적인 프론트 단(thymeleaf,jsp)을 만드는 기술을 사용할 때는 form 방식의 로그인 채택
        httpSecurity.formLogin(auth -> auth.disable());

        // http basic 인증방식 미사용
        // http basic : 요청헤더에 id,pw 값을 담아서 백서버에 전달하는 방식
        // 보안에 취약하기 때문에 요즘에 안 씀. > 대체적으로 체험용 학생들이 씀..
        // http basic 방식을 사용하면 로그인 정보를 백서버의 세션에 저장
        httpSecurity.httpBasic(auth -> auth.disable());

        // 백서버의 세션 사용을 비활성화
        httpSecurity.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // STATELESS:상태가 없다는 뜻
        );

        //인증 및 인가 설정
        httpSecurity.authorizeHttpRequests(
                auth -> auth.requestMatchers(
                "/",
                "/member/loginForm",
                "/member/joinForm",
                "/member/join" ).permitAll() // "/" 요청은 누구나 접근가능
                .anyRequest().authenticated() // ▲ 나머지 요청은 인증받아야 접근가능
        );
        return httpSecurity.build();
    }

}
