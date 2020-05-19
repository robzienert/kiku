package com.robzienert.kiku.app

import com.robzienert.kiku.axon.AxonConfig
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(AxonConfig::class)
class KikuApplication {
  private val log by lazy { LoggerFactory.getLogger(javaClass) }

  init {
    log.info("kiku")
  }
}


fun main(args: Array<String>) {
  SpringApplicationBuilder()
    .sources(KikuApplication::class.java)
    .build()
    .run(*args)
}
