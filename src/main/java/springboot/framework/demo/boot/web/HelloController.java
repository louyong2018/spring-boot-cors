package springboot.framework.demo.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
//        for (Cookie cookie:request.getCookies()){
//            System.out.println(cookie.getName());
//        }
        System.out.println(request.getHeader("Origin"));
        System.out.println(request.getRemoteHost());
        return "index";
    }

}
