package server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IssueTrackingApplication

fun main(args: Array<String>) {
	runApplication<IssueTrackingApplication>(*args)
}
