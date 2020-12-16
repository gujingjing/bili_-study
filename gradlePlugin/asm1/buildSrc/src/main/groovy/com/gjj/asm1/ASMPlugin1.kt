package com.gjj.asm1

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * author: gujingjing
 * created on: 2020/12/16 4:27 PM
 * description:
 */
class ASMPlugin1 : Plugin<Project> {

    override fun apply(project: Project) {
        println("this is ASMPlugin1")
    }

}