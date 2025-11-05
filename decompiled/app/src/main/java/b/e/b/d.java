package b.e.b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import h0.a.a.f;
import h0.a.a.p;
import h0.a.a.q;
import h0.a.a.w;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;

/* compiled from: MethodAccess.java */
/* loaded from: classes.dex */
public abstract class d {
    public String[] a;

    /* renamed from: b, reason: collision with root package name */
    public Class[][] f455b;

    public static void a(Class cls, ArrayList<Method> arrayList) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                arrayList.add(method);
            }
        }
    }

    public static d b(Class cls) throws SecurityException {
        Class[][] clsArr;
        String str;
        q qVar;
        Class<?> clsA;
        int i;
        p pVar;
        p[] pVarArr;
        q qVar2;
        Class[][] clsArr2;
        String str2;
        Class[] clsArr3;
        ArrayList arrayList = new ArrayList();
        boolean zIsInterface = cls.isInterface();
        if (zIsInterface) {
            e(cls, arrayList);
        } else {
            for (Class superclass = cls; superclass != Object.class; superclass = superclass.getSuperclass()) {
                a(superclass, arrayList);
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
        String strW = b.d.b.a.a.w(name, "MethodAccess");
        if (strW.startsWith("java.")) {
            strW = b.d.b.a.a.w("reflectasm.", strW);
        }
        a aVarB = a.b(cls);
        try {
            clsA = aVarB.loadClass(strW);
            clsArr = clsArr4;
        } catch (ClassNotFoundException unused) {
            synchronized (aVarB) {
                try {
                    clsA = aVarB.loadClass(strW);
                    clsArr = clsArr4;
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strW.replace('.', MentionUtilsKt.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtilsKt.SLASH_CHAR);
                    f fVar = new f(1);
                    fVar.c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
                    q qVarE = fVar.e(1, "<init>", "()V", null, null);
                    qVarE.t(25, 0);
                    qVarE.o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
                    qVarE.e(Opcodes.RETURN);
                    qVarE.n(0, 0);
                    q qVarE2 = fVar.e(Opcodes.LOR, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                    if (arrayList.isEmpty()) {
                        clsArr = clsArr4;
                        str = strW;
                        qVar = qVarE2;
                    } else {
                        qVarE2.t(25, 1);
                        qVarE2.s(Opcodes.CHECKCAST, strReplace2);
                        qVarE2.t(58, 4);
                        qVarE2.t(21, 2);
                        p[] pVarArr2 = new p[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            pVarArr2[i3] = new p();
                        }
                        p pVar2 = new p();
                        qVarE2.q(0, size - 1, pVar2, pVarArr2);
                        StringBuilder sb = new StringBuilder(128);
                        int i4 = 0;
                        while (i4 < size) {
                            qVarE2.i(pVarArr2[i4]);
                            if (i4 == 0) {
                                i = i4;
                                pVar = pVar2;
                                pVarArr = pVarArr2;
                                qVar2 = qVarE2;
                                qVarE2.c(1, 1, new Object[]{strReplace2}, 0, null);
                            } else {
                                i = i4;
                                pVar = pVar2;
                                pVarArr = pVarArr2;
                                qVar2 = qVarE2;
                                qVar2.c(3, 0, null, 0, null);
                            }
                            qVarE2 = qVar2;
                            qVarE2.t(25, 4);
                            sb.setLength(0);
                            sb.append('(');
                            int i5 = i;
                            Class[] clsArr6 = clsArr4[i5];
                            Class cls2 = clsArr5[i5];
                            int i6 = 0;
                            int i7 = size;
                            while (i6 < clsArr6.length) {
                                Class[] clsArr7 = clsArr5;
                                qVarE2.t(25, 3);
                                qVarE2.g(16, i6);
                                qVarE2.e(50);
                                w wVarJ = w.j(clsArr6[i6]);
                                switch (wVarJ.i()) {
                                    case 1:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Boolean");
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                                        break;
                                    case 2:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Character");
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                                        break;
                                    case 3:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Byte");
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                                        break;
                                    case 4:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Short");
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                                        break;
                                    case 5:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Integer");
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                                        break;
                                    case 6:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Float");
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                                        break;
                                    case 7:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Long");
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                                        break;
                                    case 8:
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, "java/lang/Double");
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        qVarE2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                                        break;
                                    case 9:
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, wVarJ.d());
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        break;
                                    case 10:
                                        clsArr3 = clsArr6;
                                        qVarE2.s(Opcodes.CHECKCAST, wVarJ.g());
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        break;
                                    default:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        break;
                                }
                                sb.append(wVarJ.d());
                                i6++;
                                clsArr6 = clsArr3;
                                clsArr5 = clsArr7;
                                clsArr4 = clsArr2;
                                strW = str2;
                            }
                            Class[][] clsArr8 = clsArr4;
                            Class[] clsArr9 = clsArr5;
                            String str3 = strW;
                            sb.append(')');
                            sb.append(w.e(cls2));
                            qVarE2.o(zIsInterface ? Opcodes.INVOKEINTERFACE : Modifier.isStatic(((Method) arrayList.get(i5)).getModifiers()) ? Opcodes.INVOKESTATIC : Opcodes.INVOKEVIRTUAL, strReplace2, strArr[i5], sb.toString());
                            switch (w.j(cls2).i()) {
                                case 0:
                                    qVarE2.e(1);
                                    break;
                                case 1:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                                    break;
                                case 2:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                                    break;
                                case 3:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                                    break;
                                case 4:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                                    break;
                                case 5:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    break;
                                case 6:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                                    break;
                                case 7:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                                    break;
                                case 8:
                                    qVarE2.o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                                    break;
                            }
                            qVarE2.e(Opcodes.ARETURN);
                            i4 = i5 + 1;
                            size = i7;
                            pVarArr2 = pVarArr;
                            clsArr5 = clsArr9;
                            clsArr4 = clsArr8;
                            strW = str3;
                            pVar2 = pVar;
                        }
                        clsArr = clsArr4;
                        str = strW;
                        qVarE2.i(pVar2);
                        qVar = qVarE2;
                        qVarE2.c(3, 0, null, 0, null);
                    }
                    qVar.s(Opcodes.NEW, "java/lang/IllegalArgumentException");
                    qVar.e(89);
                    qVar.s(Opcodes.NEW, "java/lang/StringBuilder");
                    qVar.e(89);
                    qVar.j("Method not found: ");
                    qVar.o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
                    qVar.t(21, 2);
                    qVar.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
                    qVar.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                    qVar.o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
                    qVar.e(Opcodes.ATHROW);
                    qVar.n(0, 0);
                    strW = str;
                    clsA = aVarB.a(strW, fVar.b());
                }
            }
        }
        try {
            d dVar = (d) clsA.newInstance();
            dVar.a = strArr;
            dVar.f455b = clsArr;
            return dVar;
        } catch (Throwable th) {
            throw new RuntimeException(b.d.b.a.a.w("Error constructing method access class: ", strW), th);
        }
    }

    public static void e(Class cls, ArrayList<Method> arrayList) throws SecurityException {
        a(cls, arrayList);
        for (Class<?> cls2 : cls.getInterfaces()) {
            e(cls2, arrayList);
        }
    }

    public int c(String str, Class... clsArr) {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            if (this.a[i].equals(str) && Arrays.equals(clsArr, this.f455b[i])) {
                return i;
            }
        }
        StringBuilder sbY = b.d.b.a.a.Y("Unable to find non-private method: ", str, " ");
        sbY.append(Arrays.toString(clsArr));
        throw new IllegalArgumentException(sbY.toString());
    }

    public abstract Object d(Object obj, int i, Object... objArr);
}
