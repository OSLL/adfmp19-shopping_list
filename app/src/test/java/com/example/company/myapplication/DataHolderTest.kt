package com.example.company.myapplication

import junit.framework.Assert.assertEquals
import org.junit.Test

class DataHolderTest {
    @Test
    fun testChangingListNamesList() {
        val dataholder = DataHolder()
        val namesList = dataholder.getListsNames()

        assertEquals(0, namesList.size)

        dataholder.insertEmptyList("newList")

        assertEquals(1, namesList.size)
        assertEquals("newList", namesList[0])
    }

    @Test
    fun testGettingList() {
        val dataholder = DataHolder()

        dataholder.insertEmptyList("newList")

        dataholder.replaceExistingList("newList",
                arrayListOf(ProductItem("Колбаса")))

        assertEquals(1, dataholder.getListsNames().size)
        assertEquals(ProductItem("Колбаса").toString(),
                dataholder.getListByName("newList")[0].toString())
    }
}