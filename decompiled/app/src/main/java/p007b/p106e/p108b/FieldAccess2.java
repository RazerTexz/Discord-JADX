package p007b.p106e.p108b;

import com.discord.widgets.chat.input.MentionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p617h0.p618a.p619a.ClassWriter2;
import p617h0.p618a.p619a.Label2;
import p617h0.p618a.p619a.MethodVisitor2;
import p617h0.p618a.p619a.Type2;

/* compiled from: FieldAccess.java */
/* renamed from: b.e.b.c, reason: use source file name */
/* loaded from: classes.dex */
public abstract class FieldAccess2 {

    /* renamed from: a */
    public String[] f3013a;

    /* renamed from: a */
    public static FieldAccess2 m895a(Class cls) {
        Class<?> clsM891a;
        ArrayList arrayList = new ArrayList();
        Class superclass = cls;
        while (true) {
            if (superclass == Object.class) {
                break;
            }
            for (Field field : superclass.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isPrivate(modifiers)) {
                    arrayList.add(field);
                }
            }
            superclass = superclass.getSuperclass();
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        Class[] clsArr = new Class[arrayList.size()];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((Field) arrayList.get(i)).getName();
            clsArr[i] = ((Field) arrayList.get(i)).getType();
        }
        String name = cls.getName();
        String strM883w = outline.m883w(name, "FieldAccess");
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
                    ClassWriter2 classWriter2 = new ClassWriter2(0);
                    classWriter2.m10565c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/FieldAccess", null);
                    MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, "<init>", "()V", null, null);
                    methodVisitor2M10567e.mo10612t(25, 0);
                    methodVisitor2M10567e.m10607o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
                    methodVisitor2M10567e.mo10597e(Opcodes.RETURN);
                    methodVisitor2M10567e.mo10606n(1, 1);
                    m896m(classWriter2, strReplace2, arrayList);
                    m899p(classWriter2, strReplace2, arrayList);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26362b);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26362b);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26364d);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26364d);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26365e);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26365e);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26366f);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26366f);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26368h);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26368h);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26369i);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26369i);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26367g);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26367g);
                    m897n(classWriter2, strReplace2, arrayList, Type2.f26363c);
                    m900q(classWriter2, strReplace2, arrayList, Type2.f26363c);
                    m898o(classWriter2, strReplace2, arrayList);
                    clsM891a = accessClassLoaderM889b.m891a(strM883w, classWriter2.m10564b());
                }
            }
        }
        try {
            FieldAccess2 fieldAccess2 = (FieldAccess2) clsM891a.newInstance();
            fieldAccess2.f3013a = strArr;
            return fieldAccess2;
        } catch (Throwable th) {
            throw new RuntimeException(outline.m883w("Error constructing field access class: ", strM883w), th);
        }
    }

    /* renamed from: m */
    public static void m896m(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList) {
        int i;
        MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        methodVisitor2M10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            for (int i2 = 0; i2 < size; i2++) {
                label2Arr[i2] = new Label2();
            }
            Label2 label2 = new Label2();
            methodVisitor2M10567e.mo10609q(0, size - 1, label2, label2Arr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                methodVisitor2M10567e.mo10601i(label2Arr[i3]);
                methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                methodVisitor2M10567e.mo10612t(25, 1);
                methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, str);
                methodVisitor2M10567e.mo10594b(180, str, field.getName(), Type2.m10646e(field.getType()));
                switch (Type2.m10648j(field.getType()).m10654i()) {
                    case 1:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                        break;
                    case 2:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                        break;
                    case 3:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        break;
                    case 4:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        break;
                    case 5:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        break;
                    case 6:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        break;
                    case 7:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        break;
                    case 8:
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                        break;
                }
                methodVisitor2M10567e.mo10597e(Opcodes.ARETURN);
            }
            methodVisitor2M10567e.mo10601i(label2);
            methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
        }
        m901r(methodVisitor2M10567e);
        methodVisitor2M10567e.mo10606n(i, 3);
    }

    /* renamed from: n */
    public static void m897n(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList, Type2 type2) {
        String str2;
        int i;
        String strM10651d = type2.m10651d();
        int iM10654i = type2.m10654i();
        int i2 = Opcodes.IRETURN;
        switch (iM10654i) {
            case 1:
                str2 = "getBoolean";
                break;
            case 2:
                str2 = "getChar";
                break;
            case 3:
                str2 = "getByte";
                break;
            case 4:
                str2 = "getShort";
                break;
            case 5:
                str2 = "getInt";
                break;
            case 6:
                i2 = Opcodes.FRETURN;
                str2 = "getFloat";
                break;
            case 7:
                i2 = Opcodes.LRETURN;
                str2 = "getLong";
                break;
            case 8:
                i2 = 175;
                str2 = "getDouble";
                break;
            default:
                i2 = Opcodes.ARETURN;
                str2 = "get";
                break;
        }
        MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, str2, outline.m883w("(Ljava/lang/Object;I)", strM10651d), null, null);
        methodVisitor2M10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            Label2 label2 = new Label2();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                if (Type2.m10648j(arrayList.get(i3).getType()).equals(type2)) {
                    label2Arr[i3] = new Label2();
                } else {
                    label2Arr[i3] = label2;
                    z2 = true;
                }
            }
            Label2 label22 = new Label2();
            methodVisitor2M10567e.mo10609q(0, size - 1, label22, label2Arr);
            for (int i4 = 0; i4 < size; i4++) {
                Field field = arrayList.get(i4);
                if (!label2Arr[i4].equals(label2)) {
                    methodVisitor2M10567e.mo10601i(label2Arr[i4]);
                    methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                    methodVisitor2M10567e.mo10612t(25, 1);
                    methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, str);
                    methodVisitor2M10567e.mo10594b(180, str, field.getName(), strM10651d);
                    methodVisitor2M10567e.mo10597e(i2);
                }
            }
            if (z2) {
                methodVisitor2M10567e.mo10601i(label2);
                methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                m902s(methodVisitor2M10567e, type2.m10650c());
            }
            methodVisitor2M10567e.mo10601i(label22);
            methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
            i = 5;
        }
        m901r(methodVisitor2M10567e);
        methodVisitor2M10567e.mo10606n(i, 3);
    }

    /* renamed from: o */
    public static void m898o(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList) {
        int i;
        MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null);
        methodVisitor2M10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            Label2 label2 = new Label2();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2).getType().equals(String.class)) {
                    label2Arr[i2] = new Label2();
                } else {
                    label2Arr[i2] = label2;
                    z2 = true;
                }
            }
            Label2 label22 = new Label2();
            methodVisitor2M10567e.mo10609q(0, size - 1, label22, label2Arr);
            for (int i3 = 0; i3 < size; i3++) {
                if (!label2Arr[i3].equals(label2)) {
                    methodVisitor2M10567e.mo10601i(label2Arr[i3]);
                    methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                    methodVisitor2M10567e.mo10612t(25, 1);
                    methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, str);
                    methodVisitor2M10567e.mo10594b(180, str, arrayList.get(i3).getName(), "Ljava/lang/String;");
                    methodVisitor2M10567e.mo10597e(Opcodes.ARETURN);
                }
            }
            if (z2) {
                methodVisitor2M10567e.mo10601i(label2);
                methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                m902s(methodVisitor2M10567e, "String");
            }
            methodVisitor2M10567e.mo10601i(label22);
            methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
            i = 5;
        }
        m901r(methodVisitor2M10567e);
        methodVisitor2M10567e.mo10606n(i, 3);
    }

    /* renamed from: p */
    public static void m899p(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList) {
        int i;
        MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        methodVisitor2M10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            for (int i2 = 0; i2 < size; i2++) {
                label2Arr[i2] = new Label2();
            }
            Label2 label2 = new Label2();
            methodVisitor2M10567e.mo10609q(0, size - 1, label2, label2Arr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                Type2 type2M10648j = Type2.m10648j(field.getType());
                methodVisitor2M10567e.mo10601i(label2Arr[i3]);
                methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                methodVisitor2M10567e.mo10612t(25, 1);
                methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, str);
                methodVisitor2M10567e.mo10612t(25, 3);
                switch (type2M10648j.m10654i()) {
                    case 1:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Boolean");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                        break;
                    case 2:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Character");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                        break;
                    case 3:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Byte");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                        break;
                    case 4:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Short");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                        break;
                    case 5:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Integer");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                        break;
                    case 6:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Float");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                        break;
                    case 7:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Long");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                        break;
                    case 8:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Double");
                        methodVisitor2M10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                        break;
                    case 9:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, type2M10648j.m10651d());
                        break;
                    case 10:
                        methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, type2M10648j.m10653g());
                        break;
                }
                methodVisitor2M10567e.mo10594b(Opcodes.PUTFIELD, str, field.getName(), type2M10648j.m10651d());
                methodVisitor2M10567e.mo10597e(Opcodes.RETURN);
            }
            methodVisitor2M10567e.mo10601i(label2);
            methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
        }
        m901r(methodVisitor2M10567e);
        methodVisitor2M10567e.mo10606n(i, 4);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* renamed from: q */
    public static void m900q(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList, Type2 type2) {
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        int i2;
        int i3;
        String strM10651d = type2.m10651d();
        switch (type2.m10654i()) {
            case 1:
                str2 = "setBoolean";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 2:
                str2 = "setChar";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 3:
                str2 = "setByte";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 4:
                str2 = "setShort";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 5:
                str2 = "setInt";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 6:
                i = 23;
                str3 = "setFloat";
                str5 = str3;
                i2 = 4;
                break;
            case 7:
                i = 22;
                str4 = "setLong";
                str5 = str4;
                i2 = 5;
                break;
            case 8:
                i = 24;
                str4 = "setDouble";
                str5 = str4;
                i2 = 5;
                break;
            default:
                str3 = "set";
                i = 25;
                str5 = str3;
                i2 = 4;
                break;
        }
        MethodVisitor2 methodVisitor2M10567e = classWriter2.m10567e(1, str5, outline.m886y("(Ljava/lang/Object;I", strM10651d, ")V"), null, null);
        methodVisitor2M10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i3 = 6;
        } else {
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            Label2 label2 = new Label2();
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                if (Type2.m10648j(arrayList.get(i4).getType()).equals(type2)) {
                    label2Arr[i4] = new Label2();
                } else {
                    label2Arr[i4] = label2;
                    z2 = true;
                }
            }
            Label2 label22 = new Label2();
            methodVisitor2M10567e.mo10609q(0, size - 1, label22, label2Arr);
            for (int i5 = 0; i5 < size; i5++) {
                if (!label2Arr[i5].equals(label2)) {
                    methodVisitor2M10567e.mo10601i(label2Arr[i5]);
                    methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                    methodVisitor2M10567e.mo10612t(25, 1);
                    methodVisitor2M10567e.mo10611s(Opcodes.CHECKCAST, str);
                    methodVisitor2M10567e.mo10612t(i, 3);
                    methodVisitor2M10567e.mo10594b(Opcodes.PUTFIELD, str, arrayList.get(i5).getName(), strM10651d);
                    methodVisitor2M10567e.mo10597e(Opcodes.RETURN);
                }
            }
            if (z2) {
                methodVisitor2M10567e.mo10601i(label2);
                methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
                m902s(methodVisitor2M10567e, type2.m10650c());
            }
            methodVisitor2M10567e.mo10601i(label22);
            methodVisitor2M10567e.mo10595c(3, 0, null, 0, null);
            i3 = 5;
        }
        m901r(methodVisitor2M10567e);
        methodVisitor2M10567e.mo10606n(i3, i2);
    }

    /* renamed from: r */
    public static MethodVisitor2 m901r(MethodVisitor2 methodVisitor2) {
        methodVisitor2.mo10611s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        methodVisitor2.mo10597e(89);
        methodVisitor2.mo10611s(Opcodes.NEW, "java/lang/StringBuilder");
        methodVisitor2.mo10597e(89);
        methodVisitor2.mo10602j("Field not found: ");
        methodVisitor2.m10607o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.mo10612t(21, 2);
        methodVisitor2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        methodVisitor2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        methodVisitor2.m10607o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.mo10597e(Opcodes.ATHROW);
        return methodVisitor2;
    }

    /* renamed from: s */
    public static MethodVisitor2 m902s(MethodVisitor2 methodVisitor2, String str) {
        methodVisitor2.mo10611s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        methodVisitor2.mo10597e(89);
        methodVisitor2.mo10611s(Opcodes.NEW, "java/lang/StringBuilder");
        methodVisitor2.mo10597e(89);
        methodVisitor2.mo10602j("Field not declared as " + str + ": ");
        methodVisitor2.m10607o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.mo10612t(21, 2);
        methodVisitor2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        methodVisitor2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        methodVisitor2.m10607o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.mo10597e(Opcodes.ATHROW);
        return methodVisitor2;
    }

    /* renamed from: A */
    public abstract void m903A(Object obj, int i, long j);

    /* renamed from: B */
    public abstract void m904B(Object obj, int i, short s2);

    /* renamed from: b */
    public abstract Object m905b(Object obj, int i);

    /* renamed from: c */
    public abstract boolean m906c(Object obj, int i);

    /* renamed from: d */
    public abstract byte m907d(Object obj, int i);

    /* renamed from: e */
    public abstract char m908e(Object obj, int i);

    /* renamed from: f */
    public abstract double m909f(Object obj, int i);

    /* renamed from: g */
    public abstract float m910g(Object obj, int i);

    /* renamed from: h */
    public int m911h(String str) {
        int length = this.f3013a.length;
        for (int i = 0; i < length; i++) {
            if (this.f3013a[i].equals(str)) {
                return i;
            }
        }
        throw new IllegalArgumentException(outline.m883w("Unable to find non-private field: ", str));
    }

    /* renamed from: i */
    public abstract int m912i(Object obj, int i);

    /* renamed from: j */
    public abstract long m913j(Object obj, int i);

    /* renamed from: k */
    public abstract short m914k(Object obj, int i);

    /* renamed from: l */
    public abstract String m915l(Object obj, int i);

    /* renamed from: t */
    public abstract void m916t(Object obj, int i, Object obj2);

    /* renamed from: u */
    public abstract void m917u(Object obj, int i, boolean z2);

    /* renamed from: v */
    public abstract void m918v(Object obj, int i, byte b2);

    /* renamed from: w */
    public abstract void m919w(Object obj, int i, char c);

    /* renamed from: x */
    public abstract void m920x(Object obj, int i, double d);

    /* renamed from: y */
    public abstract void m921y(Object obj, int i, float f);

    /* renamed from: z */
    public abstract void m922z(Object obj, int i, int i2);
}
