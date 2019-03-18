package com.example.company.myapplication

class DataHolder {
    private val listMap = mutableMapOf<String, ArrayList<ProductItem>>()

    private val listNames = listMap.keys.toMutableList()

    fun getListsNames() : MutableList<String> {
        return listNames
    }

    fun getListByName(name : String) : ArrayList<ProductItem> {
        return listMap[name]!!
    }

    fun insertEmptyList(name : String) {
        listMap[name] = arrayListOf()
        listNames.add(name)
    }

    fun replaceExistingList(name : String, list : ArrayList<ProductItem>) {
        listMap[name] = list
    }

    fun initToDemo() {
        listMap["первый список"] = arrayListOf(ProductItem("ряженка", "кг", 1f))
        listMap["Ещё список"] = arrayListOf(ProductItem("картошка"))
    }
}