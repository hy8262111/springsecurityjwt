package com.example.springsecuritoauth2jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.URLEncoder;

/**
 * Created by mrt on 2018/5/18.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/userlogin", "/userlogout", "/userjwt", "/v2/api-docs", "/swagger-resources/configuration/ui",
                "/swagger-resources", "/swagger-resources/configuration/security",
                "/swagger-ui.html", "/controller/volatileAndCAS", "/controller/getcookie", "/controller/**");

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public static void main(String[] args) throws Exception{
        /*Function<Double, String> function = t -> "aaa";
        String apply = function.apply(1D);
        System.out.println(apply);


        Predicate<Integer> predicate = i -> i > 0;
        boolean test = predicate.test(-9);
        System.out.println(test);

        Consumer<String> consumer = i -> System.out.println(i);
        consumer.accept("aaa");

        Supplier<String> supplier = () -> "aaa";
        String s = supplier.get();
        System.out.println(s);*/

        /*System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());*/
        //http://localhost:8081/pageA
        //http%3A%2F%2Flocalhost%3A8081%2FpageA
        System.out.println(URLEncoder.encode("http://localhost:8081/pageA","UTF-8"));

        //http://localhost:8081/pageA?asdad=12312312&12312131=123123123
        //http%3A%2F%2Flocalhost%3A8081%2FpageA%3Fasdad%3D12312312%2612312131%3D123123123
        //http%3A%2F%2Flocalhost%3A8081%2FpageA%3Fasdad%3D12312312%2612312131%3D123123123
        System.out.println(URLEncoder.encode("http://localhost:8081/pageA?asdad=12312312&12312131=123123123","UTF-8"));
//        System.out.println(IntStream.rangeClosed(1, 100).sum());
//        IntStream ints = new Random().ints(10,100,200);
//        ints.forEach(u1-> System.out.println(u1));
    }
}
