package p007b.p106e.p108b;

import com.discord.widgets.chat.input.MentionUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p617h0.p618a.p619a.ClassWriter2;
import p617h0.p618a.p619a.Label2;
import p617h0.p618a.p619a.MethodVisitor2;
import p617h0.p618a.p619a.Type2;

/* JADX INFO: renamed from: b.e.b.d, reason: use source file name */
/* JADX INFO: compiled from: MethodAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class MethodAccess {

    /* JADX INFO: renamed from: a */
    public String[] f3014a;

    /* JADX INFO: renamed from: b */
    public Class[][] f3015b;

    /* JADX INFO: renamed from: a */
    public static void m923a(Class cls, ArrayList<Method> arrayList) {
        for (Method method : cls.getDeclaredMethods()) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                arrayList.add(method);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static MethodAccess m924b(Class cls) {
        Class[][] clsArr;
        String str;
        MethodVisitor2 methodVisitor2;
        Class<?> clsM891a;
        int i;
        Label2 label2;
        Label2[] label2Arr;
        MethodVisitor2 methodVisitor22;
        Class[][] clsArr2;
        String str2;
        Class[] clsArr3;
        ArrayList arrayList = new ArrayList();
        boolean zIsInterface = cls.isInterface();
        if (zIsInterface) {
            m925e(cls, arrayList);
        } else {
            for (Class superclass = cls; superclass != Object.class; superclass = superclass.getSuperclass()) {
                m923a(superclass, arrayList);
            }
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        Class[][] clsArr4 = new Class[size][];
        Class[] clsArr5 = new Class[size];
        for (int i2 = 0; i2 < size; i2++) {
            Method method = (Method) arrayList.get(i2);
            strArr[i2] = method.getName();
            clsArr4[i2] = method.getParameterTypes();
            clsArr5[i2] = method.getReturnType();
        }
        String name = cls.getName();
        String strM883w = outline.m883w(name, "MethodAccess");
        if (strM883w.startsWith("java.")) {
            strM883w = outline.m883w("reflectasm.", strM883w);
        }
        AccessClassLoader accessClassLoaderM889b = AccessClassLoader.m889b(cls);
        try {
            clsM891a = accessClassLoaderM889b.loadClass(strM883w);
            clsArr = clsArr4;
        } catch (ClassNotFoundException unused) {
            synchronized (accessClassLoaderM889b) {
                try {
                    clsM891a = accessClassLoaderM889b.loadClass(strM883w);
                    clsArr = clsArr4;
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strM883w.replace('.', MentionUtils.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtils.SLASH_CHAR);
                    ClassWriter2 classWriter2 = new ClassWriter2(1);
                    classWriter2.m10565c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
                    MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, "<init>", "()V", null, null);
                    methodVisitor2M10567e.mo10612t(25, 0);
                    methodVisitor2M10567e.m10607o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
                    methodVisitor2M10567e.mo10597e(Opcodes.RETURN);
                    methodVisitor2M10567e.mo10606n(0, 0);
                    MethodVisitor2 methodVisitor2M10567e2 = classWriter2.m10567e(Opcodes.LOR, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                    if (arrayList.isEmpty()) {
                        clsArr = clsArr4;
                        str = strM883w;
                        methodVisitor2 = methodVisitor2M10567e2;
                    } else {
                        methodVisitor2M10567e2.mo10612t(25, 1);
                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, strReplace2);
                        methodVisitor2M10567e2.mo10612t(58, 4);
                        methodVisitor2M10567e2.mo10612t(21, 2);
                        Label2[] label2Arr2 = new Label2[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            label2Arr2[i3] = new Label2();
                        }
                        Label2 label22 = new Label2();
                        methodVisitor2M10567e2.mo10609q(0, size - 1, label22, label2Arr2);
                        StringBuilder sb = new StringBuilder(128);
                        int i4 = 0;
                        while (i4 < size) {
                            methodVisitor2M10567e2.mo10601i(label2Arr2[i4]);
                            if (i4 == 0) {
                                i = i4;
                                label2 = label22;
                                label2Arr = label2Arr2;
                                methodVisitor22 = methodVisitor2M10567e2;
                                methodVisitor2M10567e2.mo10595c(1, 1, new Object[]{strReplace2}, 0, null);
                            } else {
                                i = i4;
                                label2 = label22;
                                label2Arr = label2Arr2;
                                methodVisitor22 = methodVisitor2M10567e2;
                                methodVisitor22.mo10595c(3, 0, null, 0, null);
                            }
                            methodVisitor2M10567e2 = methodVisitor22;
                            methodVisitor2M10567e2.mo10612t(25, 4);
                            sb.setLength(0);
                            sb.append('(');
                            int i5 = i;
                            Class[] clsArr6 = clsArr4[i5];
                            Class cls2 = clsArr5[i5];
                            int i6 = 0;
                            int i7 = size;
                            while (i6 < clsArr6.length) {
                                Class[] clsArr7 = clsArr5;
                                methodVisitor2M10567e2.mo10612t(25, 3);
                                methodVisitor2M10567e2.mo10599g(16, i6);
                                methodVisitor2M10567e2.mo10597e(50);
                                Type2 type2M10648j = Type2.m10648j(clsArr6[i6]);
                                switch (type2M10648j.m10654i()) {
                                    case 1:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Boolean");
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                                        break;
                                    case 2:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Character");
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                                        break;
                                    case 3:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Byte");
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                                        break;
                                    case 4:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Short");
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                                        break;
                                    case 5:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Integer");
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                                        break;
                                    case 6:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Float");
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                                        break;
                                    case 7:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Long");
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                                        break;
                                    case 8:
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Double");
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        methodVisitor2M10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                                        break;
                                    case 9:
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, type2M10648j.m10651d());
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        break;
                                    case 10:
                                        clsArr3 = clsArr6;
                                        methodVisitor2M10567e2.mo10611s(Opcodes.CHECKCAST, type2M10648j.m10653g());
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        break;
                                    default:
                                        clsArr2 = clsArr4;
                                        str2 = strM883w;
                                        clsArr3 = clsArr6;
                                        break;
                                }
                                sb.append(type2M10648j.m10651d());
                                i6++;
                                clsArr6 = clsArr3;
                                clsArr5 = clsArr7;
                                clsArr4 = clsArr2;
                                strM883w = str2;
                            }
                            Class[][] clsArr8 = clsArr4;
                            Class[] clsArr9 = clsArr5;
                            String str3 = strM883w;
                            sb.append(')');
                            sb.append(Type2.m10646e(cls2));
                            methodVisitor2M10567e2.m10607o(zIsInterface ? Opcodes.INVOKEINTERFACE : Modifier.isStatic(((Method) arrayList.get(i5)).getModifiers()) ? Opcodes.INVOKESTATIC : Opcodes.INVOKEVIRTUAL, strReplace2, strArr[i5], sb.toString());
                            switch (Type2.m10648j(cls2).m10654i()) {
                                case 0:
                                    methodVisitor2M10567e2.mo10597e(1);
                                    break;
                                case 1:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                                    break;
                                case 2:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                                    break;
                                case 3:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                                    break;
                                case 4:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                                    break;
                                case 5:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    break;
                                case 6:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                                    break;
                                case 7:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                                    break;
                                case 8:
                                    methodVisitor2M10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                                    break;
                            }
                            methodVisitor2M10567e2.mo10597e(Opcodes.ARETURN);
                            i4 = i5 + 1;
                            size = i7;
                            label2Arr2 = label2Arr;
                            clsArr5 = clsArr9;
                            clsArr4 = clsArr8;
                            strM883w = str3;
                            label22 = label2;
                        }
                        clsArr = clsArr4;
                        str = strM883w;
                        methodVisitor2M10567e2.mo10601i(label22);
                        methodVisitor2 = methodVisitor2M10567e2;
                        methodVisitor2M10567e2.mo10595c(3, 0, null, 0, null);
                    }
                    methodVisitor2.mo10611s(Opcodes.NEW, "java/lang/IllegalArgumentException");
                    methodVisitor2.mo10597e(89);
                    methodVisitor2.mo10611s(Opcodes.NEW, "java/lang/StringBuilder");
                    methodVisitor2.mo10597e(89);
                    methodVisitor2.mo10602j("Method not found: ");
                    methodVisitor2.m10607o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
                    methodVisitor2.mo10612t(21, 2);
                    methodVisitor2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
                    methodVisitor2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                    methodVisitor2.m10607o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
                    methodVisitor2.mo10597e(Opcodes.ATHROW);
                    methodVisitor2.mo10606n(0, 0);
                    strM883w = str;
                    clsM891a = accessClassLoaderM889b.m891a(strM883w, classWriter2.m10564b());
                }
            }
        }
        try {
            MethodAccess methodAccess = (MethodAccess) clsM891a.newInstance();
            methodAccess.f3014a = strArr;
            methodAccess.f3015b = clsArr;
            return methodAccess;
        } catch (Throwable th) {
            throw new RuntimeException(outline.m883w("Error constructing method access class: ", strM883w), th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m925e(Class cls, ArrayList<Method> arrayList) {
        m923a(cls, arrayList);
        for (Class<?> cls2 : cls.getInterfaces()) {
            m925e(cls2, arrayList);
        }
    }

    /* JADX INFO: renamed from: c */
    public int m926c(String str, Class... clsArr) {
        int length = this.f3014a.length;
        for (int i = 0; i < length; i++) {
            if (this.f3014a[i].equals(str) && Arrays.equals(clsArr, this.f3015b[i])) {
                return i;
            }
        }
        StringBuilder sbM837Y = outline.m837Y("Unable to find non-private method: ", str, " ");
        sbM837Y.append(Arrays.toString(clsArr));
        throw new IllegalArgumentException(sbM837Y.toString());
    }

    /* JADX INFO: renamed from: d */
    public abstract Object m927d(Object obj, int i, Object... objArr);
}
