package hello.springmvc.basic.request

import Slf4j
import Slf4j.Companion.logger
import org.springframework.http.HttpMethod
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@RestController
class RequestHeaderController {

    @RequestMapping("/headers")
    fun headers(
        request: HttpServletRequest,
        response: HttpServletResponse,
        httpMethod: HttpMethod,
        locale: Locale,
        @RequestHeader headerMap: MultiValueMap<String, String>,
        @RequestHeader("host") host: String,
        @CookieValue(value = "myCookie", required = false) cookie: String?
    ): String {
        logger.info("request=${request}")
        logger.info("response=${response}")
        logger.info("httpMethod=${httpMethod}")
        logger.info("locale=${locale}")
        logger.info("headerMap=${headerMap}")
        logger.info("host=${host}")
        logger.info("cookie=${cookie}")

        return "ok"
    }
}
