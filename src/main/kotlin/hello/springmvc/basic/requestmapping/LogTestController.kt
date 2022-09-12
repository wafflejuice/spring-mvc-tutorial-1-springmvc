package hello.springmvc.basic.requestmapping

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogTestController {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/log-test")
    fun logTest(): String {
        val name = "Spring"

        log.trace("trace log={}", name)
        log.debug("debug log={}", name)
        log.info(" info log={}", name)
        log.warn(" warn log={}", name)
        log.error("error log={}", name)

        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug("String concat log=$name")

        return "ok"
    }
}