package hello.springmvc.basic.request

import Slf4j
import Slf4j.Companion.logger
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@Controller
class RequestParamController {
    @RequestMapping("/request-param-v1")
    fun requestParamV1(
        request: HttpServletRequest,
        response: HttpServletResponse,
    ) {
        val username = request.getParameter("username")
        val age = request.getParameter("age").toInt()

        logger.info("username=${username}, age=${age}")

        response.writer.write("ok")
    }
}
