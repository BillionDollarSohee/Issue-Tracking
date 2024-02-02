package server

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class IssueTrackingApplication

fun main(args: Array<String>) {
	runApplication<IssueTrackingApplication>(*args)
}
