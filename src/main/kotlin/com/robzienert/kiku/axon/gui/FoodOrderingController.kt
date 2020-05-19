/*
 * Copyright 2020 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.robzienert.kiku.axon.gui

import com.robzienert.kiku.axon.api.CreateFoodCartCommand
import com.robzienert.kiku.axon.api.DeselectProductCommand
import com.robzienert.kiku.axon.api.FindFoodCartQuery
import com.robzienert.kiku.axon.api.SelectProductCommand
import com.robzienert.kiku.axon.query.FoodCartView
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.concurrent.CompletableFuture


@RestController
@RequestMapping("/foodCart")
class FoodOrderingController(
  private val commandGateway: CommandGateway,
  private val queryGateway: QueryGateway
) {

  @PostMapping
  fun createFoodCart(): CompletableFuture<UUID> =
    commandGateway.send(CreateFoodCartCommand(UUID.randomUUID()))

  @PutMapping("/{foodCartId}/select")
  fun selectProduct(
    @PathVariable("foodCartId") foodCartId: String,
    @RequestParam("productId") productId: String,
    @RequestParam("quantity") quantity: Int
  ) {
    // TODO(rz): Kotlin ext functions needed for CommandGateway
    commandGateway.send<Any>(
      SelectProductCommand(UUID.fromString(foodCartId), UUID.fromString(productId), quantity)
    )
  }

  @PutMapping("/{foodCartId}/deselect")
  fun deselectProduct(@PathVariable("foodCartId") foodCartId: String,
                      @RequestParam("productId") productId: String,
                      @RequestParam("quantity") quantity: Int) {
    commandGateway.send<Any>(DeselectProductCommand(
      UUID.fromString(foodCartId), UUID.fromString(productId), quantity!!
    ))
  }

  @GetMapping("/{foodCartId}")
  fun findFoodCart(@PathVariable("foodCartId") foodCartId: String): CompletableFuture<FoodCartView> =
    queryGateway.query(
      FindFoodCartQuery(UUID.fromString(foodCartId)),
      ResponseTypes.instanceOf(FoodCartView::class.java)
    )
}
