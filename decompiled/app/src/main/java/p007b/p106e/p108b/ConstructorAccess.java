package p007b.p106e.p108b;

import com.discord.widgets.chat.input.MentionUtils;
import java.lang.reflect.Modifier;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p617h0.p618a.p619a.ClassWriter2;
import p617h0.p618a.p619a.MethodVisitor2;

/* JADX INFO: renamed from: b.e.b.b, reason: use source file name */
/* JADX INFO: compiled from: ConstructorAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstructorAccess<T> {
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> ConstructorAccess<T> m892a(Class<T> cls) {
        int modifiers;
        Class<?> clsM891a;
        Class<?> enclosingClass = cls.getEnclosingClass();
        boolean z2 = false;
        boolean z3 = (enclosingClass == null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? false : true;
        String name = cls.getName();
        String strM883w = outline.m883w(name, "ConstructorAccess");
        if (strM883w.startsWith("java.")) {
            strM883w = outline.m883w("reflectasm.", strM883w);
        }
        AccessClassLoader accessClassLoaderM889b = AccessClassLoader.m889b(cls);
        try {
            clsM891a = accessClassLoaderM889b.loadClass(strM883w);
        } catch (ClassNotFoundException unused) {
            synchronized (accessClassLoaderM889b) {
                try {
                    clsM891a = accessClassLoaderM889b.loadClass(strM883w);
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strM883w.replace('.', MentionUtils.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtils.SLASH_CHAR);
                    String strReplace3 = null;
                    if (z3) {
                        strReplace3 = enclosingClass.getName().replace('.', MentionUtils.SLASH_CHAR);
                        try {
                            modifiers = cls.getDeclaredConstructor(enclosingClass).getModifiers();
                            if (Modifier.isPrivate(modifiers)) {
                                throw new RuntimeException("Non-static member class cannot be created (the enclosing class constructor is private): " + cls.getName());
                            }
                            String str = strReplace3;
                            if (!Modifier.isPublic(modifiers)) {
                            }
                            ClassWriter2 classWriter2 = new ClassWriter2(0);
                            classWriter2.m10565c(Opcodes.V1_1, 33, strReplace, null, str, null);
                            MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, "<init>", "()V", null, null);
                            methodVisitor2M10567e.mo10612t(25, 0);
                            methodVisitor2M10567e.m10607o(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
                            methodVisitor2M10567e.mo10597e(Opcodes.RETURN);
                            methodVisitor2M10567e.mo10606n(1, 1);
                            MethodVisitor2 methodVisitor2M10567e2 = classWriter2.m10567e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            methodVisitor2M10567e2.mo10611s(Opcodes.NEW, strReplace2);
                            methodVisitor2M10567e2.mo10597e(89);
                            methodVisitor2M10567e2.m10607o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            methodVisitor2M10567e2.mo10597e(Opcodes.ARETURN);
                            methodVisitor2M10567e2.mo10606n(2, 1);
                            m893b(classWriter2, strReplace2, str);
                            clsM891a = accessClassLoaderM889b.m891a(strM883w, classWriter2.m10564b());
                        } catch (Exception e) {
                            throw new RuntimeException("Non-static member class cannot be created (missing enclosing class constructor): " + cls.getName(), e);
                        }
                    } else {
                        try {
                            modifiers = cls.getDeclaredConstructor(null).getModifiers();
                            if (Modifier.isPrivate(modifiers)) {
                                throw new RuntimeException("Class cannot be created (the no-arg constructor is private): " + cls.getName());
                            }
                            String str2 = strReplace3;
                            String str3 = !Modifier.isPublic(modifiers) ? "com/esotericsoftware/reflectasm/PublicConstructorAccess" : "com/esotericsoftware/reflectasm/ConstructorAccess";
                            ClassWriter2 classWriter22 = new ClassWriter2(0);
                            classWriter22.m10565c(Opcodes.V1_1, 33, strReplace, null, str3, null);
                            MethodVisitor2 methodVisitor2M10567e3 = classWriter22.m10567e(1, "<init>", "()V", null, null);
                            methodVisitor2M10567e3.mo10612t(25, 0);
                            methodVisitor2M10567e3.m10607o(Opcodes.INVOKESPECIAL, str3, "<init>", "()V");
                            methodVisitor2M10567e3.mo10597e(Opcodes.RETURN);
                            methodVisitor2M10567e3.mo10606n(1, 1);
                            MethodVisitor2 methodVisitor2M10567e22 = classWriter22.m10567e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            methodVisitor2M10567e22.mo10611s(Opcodes.NEW, strReplace2);
                            methodVisitor2M10567e22.mo10597e(89);
                            methodVisitor2M10567e22.m10607o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            methodVisitor2M10567e22.mo10597e(Opcodes.ARETURN);
                            methodVisitor2M10567e22.mo10606n(2, 1);
                            m893b(classWriter22, strReplace2, str2);
                            clsM891a = accessClassLoaderM889b.m891a(strM883w, classWriter22.m10564b());
                        } catch (Exception e2) {
                            throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e2);
                        }
                    }
                }
            }
        }
        try {
            ConstructorAccess<T> constructorAccess = (ConstructorAccess) clsM891a.newInstance();
            if (!(constructorAccess instanceof PublicConstructorAccess)) {
                if (cls.getPackage() == clsM891a.getPackage()) {
                    ClassLoader classLoader = cls.getClassLoader();
                    ClassLoader classLoader2 = clsM891a.getClassLoader();
                    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                    if (classLoader != null ? !(classLoader2 != null ? classLoader != classLoader2 : classLoader != systemClassLoader) : !(classLoader2 != null && classLoader2 != systemClassLoader)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(!z3 ? "Class cannot be created (the no-arg constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): " : "Non-static member class cannot be created (the enclosing class constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): ");
                    sb.append(cls.getName());
                    throw new RuntimeException(sb.toString());
                }
            }
            Objects.requireNonNull(constructorAccess);
            return constructorAccess;
        } catch (Throwable th) {
            throw new RuntimeException(outline.m883w("Exception constructing constructor access class: ", strM883w), th);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m893b(ClassWriter2 classWriter2, String str, String str2) {
        MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        if (str2 == null) {
            methodVisitor2M10567e.mo10611s(Opcodes.NEW, "java/lang/UnsupportedOperationException");
            methodVisitor2M10567e.mo10597e(89);
            methodVisitor2M10567e.mo10602j("Not an inner class.");
            methodVisitor2M10567e.m10607o(Opcodes.INVOKESPECIAL, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
            methodVisitor2M10567e.mo10597e(Opcodes.ATHROW);
            methodVisitor2M10567e.mo10606n(3, 2);
            return;
        }
        methodVisitor2M10567e.mo10611s(Opcodes.NEW, str);
        methodVisitor2M10567e.mo10597e(89);
        methodVisitor2M10567e.mo10612t(25, 1);
        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, str2);
        methodVisitor2M10567e.mo10597e(89);
        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        methodVisitor2M10567e.mo10597e(87);
        methodVisitor2M10567e.m10607o(Opcodes.INVOKESPECIAL, str, "<init>", "(L" + str2 + ";)V");
        methodVisitor2M10567e.mo10597e(Opcodes.ARETURN);
        methodVisitor2M10567e.mo10606n(4, 2);
    }

    /* JADX INFO: renamed from: c */
    public abstract T m894c();
}
