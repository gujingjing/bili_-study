package com.gjj.propertydelegate

/**
 * author: gujingjing
 * created on: 2020/8/6 4:12 PM
 * description:
 */
class PropertyDelegateTest {

    private val name by lazy { "name" }
    private lateinit var age: User

    private fun init() {
        if (::age.isLateinit) {

        }
        age = User()
    }

    class User {

    }
}