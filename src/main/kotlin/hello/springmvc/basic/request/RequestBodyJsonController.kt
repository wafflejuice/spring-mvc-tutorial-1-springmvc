package hello.springmvc.basic.request

import Slf4j
import Slf4j.Companion.logger
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import hello.springmvc.basic.HelloData
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Controller
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@Controller
class RequestBodyJsonController {

    //    val objectMapper = ObjectMapper()
    val objectMapper = jacksonObjectMapper()
//    val objectMapper = ObjectMapper().registerKotlinModule()
//    val objectMapper = jsonMapper {
//        addModule(kotlinModule())
//    }

    @PostMapping("/request-body-json-v1")
    fun requestBodyJsonV1(
        request: HttpServletRequest,
        response: HttpServletResponse
    ) {
        val inputStream = request.inputStream
        val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)

        logger.info("messageBody=${messageBody}")
        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
        logger.info("username=${helloData.username}, age=${helloData.age}")

        response.writer.write("ok")
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    fun requestBodyJsonV2(
        @RequestBody messageBody: String
    ): String {
        logger.info("messageBody=${messageBody}")
        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
        logger.info("username=${helloData.username}, age=${helloData.age}")

        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    fun requestBodyJsonV3(
        @RequestBody helloData: HelloData
    ): String {
        logger.info("username=${helloData.username}, age=${helloData.age}")

        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    fun requestBodyJsonV4(
        data: HttpEntity<HelloData>
    ): String {
        val helloData = data.body
        logger.info("username=${helloData?.username}, age=${helloData?.age}")

        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    fun requestBodyJsonV5(
        @RequestBody helloData: HelloData
    ): HelloData {
        logger.info("username=${helloData.username}, age=${helloData.age}")

        return helloData
    }
}
