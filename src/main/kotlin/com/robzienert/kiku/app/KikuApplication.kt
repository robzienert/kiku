package com.robzienert.kiku.app

import com.robzienert.kiku.core.Attire
import com.robzienert.kiku.core.CoreContext
import com.robzienert.kiku.shared.SharedPostProcessor
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KikuApplication {
  val log by lazy { LoggerFactory.getLogger(javaClass) }

  init {
    log.info("kiku")
  }

  companion object {
    @Bean
    fun post2() = SharedPostProcessor("kiku")
  }
}

fun main(args: Array<String>) {
  SpringApplicationBuilder()
    .parent(CoreContext::class.java)
    .child(KikuApplication::class.java)
    .build()
    .run(*args)
}
