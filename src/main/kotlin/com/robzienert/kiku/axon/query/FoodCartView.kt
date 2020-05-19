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
package com.robzienert.kiku.axon.query

import java.util.UUID

data class FoodCartView(
  val foodCartId: UUID,
  val products: MutableMap<UUID, Int>
) {

  fun addProducts(productId: UUID, amount: Int) =
    products.compute(productId) { _, quantity -> (quantity ?: 0) + amount }

  fun removeProducts(productId: UUID, amount: Int) {
    val leftOverQuantity = products.compute(productId) { _, quantity -> (quantity ?: 0) - amount }
    if (leftOverQuantity == 0) {
      products.remove(productId)
    }
  }
}
