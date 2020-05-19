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
package com.robzienert.kiku.axon.command

import com.robzienert.kiku.axon.api.ConfirmOrderCommand
import com.robzienert.kiku.axon.api.CreateFoodCartCommand
import com.robzienert.kiku.axon.api.DeselectProductCommand
import com.robzienert.kiku.axon.api.FoodCartCreatedEvent
import com.robzienert.kiku.axon.api.OrderConfirmedEvent
import com.robzienert.kiku.axon.api.ProductDeselectedEvent
import com.robzienert.kiku.axon.api.ProductDeselectionException
import com.robzienert.kiku.axon.api.ProductSelectedEvent
import com.robzienert.kiku.axon.api.SelectProductCommand
import com.sun.org.apache.bcel.internal.generic.Select
import com.sun.org.apache.xpath.internal.operations.Bool
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import org.slf4j.LoggerFactory
import java.util.UUID

@Aggregate
class FoodCart {

  private val log by lazy { LoggerFactory.getLogger(javaClass) }

  @AggregateIdentifier
  private lateinit var foodCartId: UUID
  private val selectedProducts: MutableMap<UUID, Int> = mutableMapOf()
  private var confirmed: Boolean = false

  constructor() {
    // Required by axon
  }

  @CommandHandler
  constructor(command: CreateFoodCartCommand) {
    AggregateLifecycle.apply(FoodCartCreatedEvent(command.foodCartId))
  }

  @CommandHandler
  fun handle(command: SelectProductCommand) {
    AggregateLifecycle.apply(ProductSelectedEvent(foodCartId, command.productId, command.quantity))
  }

  @CommandHandler
  fun handle(command: DeselectProductCommand) {
    if (!selectedProducts.containsKey(command.proudctId)) {
      throw ProductDeselectionException("Cannot deselect a product which has not been selected for this food cart")
    }
    if (selectedProducts[command.proudctId]!! - command.quantity < 0) {
      throw ProductDeselectionException("Cannot deselect more products of ID [${command.proudctId}] than have been selected initially")
    }
    AggregateLifecycle.apply(ProductDeselectedEvent(foodCartId, command.proudctId, command.quantity))
  }

  @CommandHandler
  fun handle(command: ConfirmOrderCommand) {
    if (confirmed) {
      log.warn("Cannot confirm a food cart that is already confirmed")
      return
    }
    AggregateLifecycle.apply(OrderConfirmedEvent(foodCartId))
  }

  @EventSourcingHandler
  fun on(event: FoodCartCreatedEvent) {
    foodCartId = event.foodCartId
    selectedProducts.clear()
    confirmed = false
  }

  @EventSourcingHandler
  fun on(event: ProductSelectedEvent) {
    selectedProducts.merge(event.productId, event.quantity, Int::plus)
  }

  fun on(event: ProductDeselectedEvent) {
    selectedProducts.computeIfPresent(event.productId) { _: UUID, quantity: Int ->
      quantity - event.quantity
    }
  }

  fun on(event: OrderConfirmedEvent) {
    confirmed = true
  }
}
