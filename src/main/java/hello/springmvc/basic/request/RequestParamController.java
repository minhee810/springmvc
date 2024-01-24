package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age ={}", username, age);
        response.getWriter().write("ok!");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge) {

        log.info("username ={}, age ={}", memberName, memberAge);

        return "ok";
    }

    // @RequestParam("") 생략 가능 단 파리미터 이름을 매개변수와 동일하게 설정해야함.
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {

        log.info("username ={}, age ={}", username, age);

        return "ok";
    }

    // 단순 타입인 경우 (String, Integer, int)  @RequestParam 없어도 가능. 단, 매핑 이름이 동일해야 함.
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {

        log.info("username ={}, age ={}", username, age);

        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,   // 꼭 있어야 함.
                                       @RequestParam(required = false) Integer age) {    // 꼭 없어도 됨.

        log.info("username ={}, age ={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,   // 꼭 있어야 함.
                                       @RequestParam(required = false, defaultValue = "-1") int age) {    // 꼭 없어도 됨.

        log.info("username ={}, age ={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {    // 꼭 없어도 됨.

        log.info("username ={}, age ={}", paramMap.get("username") );

        return "ok";
    }

}
