package com.gjj.asm1;

import com.android.build.gradle.AppExtension;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * author: gujingjing
 * created on: 2020/12/16 4:59 PM
 * description:
 */
class ASMPlugin2 implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        System.out.println("this is ASMPlugin2");
        //registerTransform
        AppExtension android = project.getExtensions().getByType(AppExtension.class);
        android.registerTransform(new AsmTransform(project));
    }
}
