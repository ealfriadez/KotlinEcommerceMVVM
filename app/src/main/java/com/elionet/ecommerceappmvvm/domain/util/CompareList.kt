package com.elionet.ecommerceappmvvm.domain.util

fun <T> isListEqual(list1: List<T>, list2: List<T>): Boolean {
    if(list1.size != list2.size) return false
    return list1.zip(list2).all { (a, b) -> a == b }
}