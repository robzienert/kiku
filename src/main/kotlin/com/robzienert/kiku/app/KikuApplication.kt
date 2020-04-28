package com.robzienert.kiku.app

import com.robzienert.kiku.core.CoreContext
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class KikuApplication {
  val log by lazy { LoggerFactory.getLogger(javaClass) }

  init {
    log.info("kiku")
  }
}

fun main(args: Array<String>) {
  SpringApplicationBuilder()
    .parent(CoreContext::class.java)
    .child(KikuApplication::class.java)
    .build()
    .run(*args)
}
