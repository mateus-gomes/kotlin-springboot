package br.com.mateusgomes

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun getGreeting(
        @RequestParam(value = "name", defaultValue = "world")
        name: String?
    ): Greeting{
        return Greeting(counter.getAndIncrement(), "Hello, $name!")
    }
}