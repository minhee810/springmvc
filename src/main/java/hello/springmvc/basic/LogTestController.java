package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
//    private final Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping("/log-test")
    public String logTest() {

        String name = "spring";

        // 잘못된 예
        log.trace("trace log = " + name);

        log.info("info log = {}", name);      // 중요한 정보, 운영 시스템에서도 봐야할 정보
        log.trace("trace log = {} ", name);
        log.debug("debug log = {}", name);    // debug 시, 개발 서버에서 보는 로그
        log.warn("warm log = {}", name);       // 경고, 위험한 것
        log.error("error log = {}", name);      // 에러
        return "ok";
    }

}
