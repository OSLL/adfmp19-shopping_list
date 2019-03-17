package com.example.company.myapplication

import junit.framework.Assert.*
import org.junit.Assert
import org.junit.Test

class ProductItemTest {
    @Test
    fun defaultInitializationTest() {
        val pi = ProductItem("Картошка")

        assertEquals("Картошка", pi.name)
        assertEquals(1.0f, pi.quantity)
        assertEquals("кг", pi.unit)
    }

    @Test
    fun customInitializationTest() {
        val pi = ProductItem("Картошка", "литр", 1.5f)

        assertEquals("Картошка", pi.name)
        assertEquals(1.5f, pi.quantity)
        assertEquals("литр", pi.unit)
    }

    @Test
    fun toStringUnselectedTest() {
        val pi = ProductItem("Молоко", "литр", 1.5f)

        assertFalse(pi.isSelected)
        assertEquals("Молоко, 1.5 литр", pi.toString())
    }

    @Test
    fun toStringSelectedTest() {
        val pi = ProductItem("Молоко", "литр", 1.5f)

        pi.isSelected = true
        assertTrue(pi.isSelected)
        assertEquals("***Молоко, 1.5 литр***", pi.toString())
    }

    @Test
    fun randomItemTest() {
        val charPool = arrayListOf('a', 'b', 'c', 'd')
        val name = (1..5)
                .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("");
        val quantity = kotlin.random.Random.nextFloat()
        val units = arrayListOf("литр", "кг", "шт")
        val unit = units[kotlin.random.Random.nextInt(0, units.size)]
        val pi = ProductItem(name, unit, quantity)

        assertEquals(name + ", " + quantity.toString() + " " + unit, pi.toString())
    }


}