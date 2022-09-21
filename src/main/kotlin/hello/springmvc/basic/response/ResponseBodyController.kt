package hello.springmvc.basic.response

import Slf4j
import hello.springmvc.basic.HelloData
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@Slf4j
@RestController
class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    fun responseBodyV1(
        response: HttpServletResponse
    ) {
        response.writer.write("ok")
    }

    @GetMapping("/response-body-string-v2")
    fun responseBodyV2(): ResponseEntity<String> {
        return ResponseEntity("ok", HttpStatus.OK)
    }

    //    @ResponseBody
    @GetMapping("/response-body-string-v3")
    fun responseBodyV3(): String {
        return "ok"
    }

    @GetMapping("/response-body-json-v1")
    fun responseBodyJsonV1(): ResponseEntity<HelloData> {
        val helloData = HelloData(username = "userA", age = 20)

        return ResponseEntity(helloData, HttpStatus.OK)
    }

    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
    @GetMapping("/response-body-json-v2")
    fun responseBodyJsonV2(): HelloData {
        val helloData = HelloData(username = "userA", age = 20)

        return helloData
    }
}
