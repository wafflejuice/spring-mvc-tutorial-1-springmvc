package hello.springmvc.basic.requestmapping

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class MappingController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/hello-basic")
    fun helloBasic(): String {
        logger.info("helloBasic")
        
        return "ok"
    }

    @RequestMapping(value = ["/mapping-get-v1"], method = [RequestMethod.GET])
    fun mappingGetV1(): String {
        logger.info("mappingGetV1")

        return "ok"
    }

    @GetMapping(value = ["/mapping-get-v2"])
    fun mappingGetV2(): String {
        logger.info("mappingGetV2")

        return "ok"
    }

    @GetMapping(value = ["/mapping/{userId}"])
    fun mappingPath(
        @PathVariable("userId") data: String
    ): String {
        logger.info("mappingPath userId=${data}")

        return "ok"
    }

    @GetMapping(value = ["/mapping/users/{userId}/orders/{orderId}"])
    fun mappingPath(
        @PathVariable userId: String,
        @PathVariable orderId: Long
    ): String {
        logger.info("mappingPath userId=${userId}, orderId=${orderId}")

        return "ok"
    }

    @GetMapping(value = ["/mapping-param"], params = ["mode=debug"])
    fun mappingParam(): String {
        logger.info("mappingParam")

        return "ok"
    }

    @GetMapping(value = ["/mapping-header"], headers = ["mode=debug"])
    fun mappingHeader(): String {
        logger.info("mappingHeader")

        return "ok"
    }

    @PostMapping(value = ["/mapping-consume"], consumes = ["application/json"])
    fun mappingConsumes(): String {
        logger.info("mappingConsumes")

        return "ok"
    }

    @PostMapping(value = ["/mapping-produce"], produces = ["text/html"])
    fun mappingProduces(): String {
        logger.info("mappingProduces")

        return "ok"
    }
}