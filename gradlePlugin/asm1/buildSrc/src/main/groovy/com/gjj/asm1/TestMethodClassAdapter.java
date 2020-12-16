package com.gjj.asm1;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * author: gujingjing
 * created on: 2020/12/16 5:33 PM
 * description:
 */
public class TestMethodClassAdapter extends ClassVisitor implements Opcodes {

    public TestMethodClassAdapter(ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        return (mv == null) ? null : new TestMethodVisitor(mv);
    }
}
