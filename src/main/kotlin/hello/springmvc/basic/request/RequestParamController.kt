package hello.springmvc.basic.request

import Slf4j
import Slf4j.Companion.logger
import hello.springmvc.basic.HelloData
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
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

    @ResponseBody
    @RequestMapping("/request-param-v2")
    fun requestParamV2(
        @RequestParam("username") memberName: String,
        @RequestParam("age") memberAge: Int,
    ): String {
        logger.info("username=${memberName}, age=${memberAge}")

        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    fun requestParamV3(
        @RequestParam username: String,
        @RequestParam age: Int,
    ): String {
        logger.info("username=${username}, age=${age}")

        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    fun requestParamV4(
        username: String,
        age: Int,
    ): String {
        logger.info("username=${username}, age=${age}")

        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    fun requestParamRequired(
        @RequestParam(required = true) username: String,
        @RequestParam(required = false) age: Int?,
    ): String {
        logger.info("username=${username}, age=${age}")

        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    fun requestParamDefault(
        @RequestParam(defaultValue = "guest") username: String,
        @RequestParam(defaultValue = "-1") age: Int?,
    ): String {
        logger.info("username=${username}, age=${age}")

        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    fun requestParamMap(
        @RequestParam paramMap: Map<String, Any>,
    ): String {
        logger.info("username=${paramMap["username"]}, age=${paramMap["age"]}")

        return "ok"
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    fun modelAttributeV1(@ModelAttribute helloData: HelloData): String {
        logger.info("username=${helloData.username} age=${helloData.age}")

        return "ok"
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    fun modelAttributeV2(helloData: HelloData): String {
        logger.info("username=${helloData.username} age=${helloData.age}")

        return "ok"
    }
}
