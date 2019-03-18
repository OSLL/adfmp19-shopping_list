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
        if (!listMap.containsKey(name)) {
            listNames.add(name)
        }
        listMap[name] = arrayListOf()
    }

    fun replaceExistingList(name : String, list : ArrayList<ProductItem>) {
        if (!listMap.containsKey(name)) {
            listNames.add(name)
        }
        listMap[name] = list
    }

    fun initToDemo() {
        replaceExistingList("первый список",
                arrayListOf(ProductItem("ряженка", "кг", 1f)))
        replaceExistingList("Ещё список",
                arrayListOf(ProductItem("картошка")))
    }
}