package p617h0.p618a.p619a;

import org.objectweb.asm.ClassTooLargeException;
import org.objectweb.asm.MethodTooLargeException;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p617h0.p618a.p619a.Attribute2;

/* compiled from: ClassWriter.java */
/* renamed from: h0.a.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public class ClassWriter2 extends ClassVisitor2 {

    /* renamed from: A */
    public Attribute2 f26162A;

    /* renamed from: B */
    public int f26163B;

    /* renamed from: a */
    public int f26164a;

    /* renamed from: b */
    public final SymbolTable2 f26165b;

    /* renamed from: c */
    public int f26166c;

    /* renamed from: d */
    public int f26167d;

    /* renamed from: e */
    public int f26168e;

    /* renamed from: f */
    public int f26169f;

    /* renamed from: g */
    public int[] f26170g;

    /* renamed from: h */
    public FieldWriter2 f26171h;

    /* renamed from: i */
    public FieldWriter2 f26172i;

    /* renamed from: j */
    public MethodWriter2 f26173j;

    /* renamed from: k */
    public MethodWriter2 f26174k;

    /* renamed from: l */
    public int f26175l;

    /* renamed from: m */
    public ByteVector2 f26176m;

    /* renamed from: n */
    public int f26177n;

    /* renamed from: o */
    public int f26178o;

    /* renamed from: p */
    public int f26179p;

    /* renamed from: q */
    public int f26180q;

    /* renamed from: r */
    public ByteVector2 f26181r;

    /* renamed from: s */
    public AnnotationWriter2 f26182s;

    /* renamed from: t */
    public AnnotationWriter2 f26183t;

    /* renamed from: u */
    public AnnotationWriter2 f26184u;

    /* renamed from: v */
    public AnnotationWriter2 f26185v;

    /* renamed from: w */
    public ModuleWriter2 f26186w;

    /* renamed from: x */
    public int f26187x;

    /* renamed from: y */
    public int f26188y;

    /* renamed from: z */
    public ByteVector2 f26189z;

    public ClassWriter2(int i) {
        super(Opcodes.ASM7);
        this.f26165b = new SymbolTable2(this);
        if ((i & 2) != 0) {
            this.f26163B = 4;
        } else if ((i & 1) != 0) {
            this.f26163B = 1;
        } else {
            this.f26163B = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:412:0x0acf  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0acf A[EDGE_INSN: B:412:0x0acf->B:413:0x0ad0 BREAK  A[LOOP:39: B:405:0x0ab3->B:410:0x0ac2]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] m10563a(byte[] bArr, boolean z2) {
        String strM10545g;
        Attribute2 attribute2;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        ClassWriter2 classWriter2;
        String str6;
        String str7;
        String str8;
        String strM10561w;
        boolean z3;
        boolean z4;
        String str9;
        String str10;
        String str11;
        String str12;
        int i2;
        String str13;
        String str14;
        String str15;
        String str16;
        int i3;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        int i4;
        String str23;
        int i5;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        ClassReader2 classReader2;
        String str32;
        Context3 context3;
        int i6;
        String[] strArr;
        String[] strArr2;
        String str33;
        int i7;
        String str34;
        int i8;
        int i9;
        String[] strArr3;
        Attribute2.a aVar = new Attribute2.a();
        aVar.m10528a(this.f26162A);
        for (FieldWriter2 fieldWriter2 = this.f26171h; fieldWriter2 != null; fieldWriter2 = (FieldWriter2) fieldWriter2.f26216a) {
            aVar.m10528a(fieldWriter2.f26227l);
        }
        MethodWriter2 methodWriter2 = this.f26173j;
        while (true) {
            strM10545g = null;
            if (methodWriter2 == null) {
                break;
            }
            aVar.m10528a(methodWriter2.f26277M);
            aVar.m10528a(null);
            methodWriter2 = (MethodWriter2) methodWriter2.f26263b;
        }
        int i10 = aVar.f26151a;
        Attribute2[] attribute2Arr = new Attribute2[i10];
        System.arraycopy(aVar.f26152b, 0, attribute2Arr, 0, i10);
        this.f26171h = null;
        this.f26172i = null;
        this.f26173j = null;
        this.f26174k = null;
        this.f26182s = null;
        this.f26183t = null;
        this.f26184u = null;
        this.f26185v = null;
        this.f26186w = null;
        this.f26187x = 0;
        this.f26188y = 0;
        this.f26189z = null;
        this.f26162A = null;
        this.f26163B = z2 ? 3 : 0;
        ClassReader2 classReader22 = new ClassReader2(bArr, 0, false);
        int i11 = (z2 ? 8 : 0) | 256;
        Context3 context32 = new Context3();
        context32.f26194a = attribute2Arr;
        context32.f26195b = i11;
        char[] cArr = new char[classReader22.f26160f];
        context32.f26196c = cArr;
        int i12 = classReader22.f26161g;
        int iM10559u = classReader22.m10559u(i12);
        String strM10545g2 = classReader22.m10545g(i12 + 2, cArr);
        String strM10545g3 = classReader22.m10545g(i12 + 4, cArr);
        int iM10559u2 = classReader22.m10559u(i12 + 6);
        String[] strArr4 = new String[iM10559u2];
        int i13 = i12 + 8;
        for (int i14 = 0; i14 < iM10559u2; i14++) {
            strArr4[i14] = classReader22.m10545g(i13, cArr);
            i13 += 2;
        }
        int iM10541c = classReader22.m10541c();
        String strM10558t = null;
        Attribute2 attribute2M10543e = null;
        String strM10558t2 = null;
        String strM10545g4 = null;
        int i15 = iM10559u;
        int iM10559u3 = classReader22.m10559u(iM10541c - 2);
        String[] strArr5 = strArr4;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        String strM10560v = null;
        while (true) {
            attribute2 = attribute2M10543e;
            str = strM10558t;
            str2 = "Synthetic";
            str3 = strM10560v;
            str4 = "Deprecated";
            i = i16;
            str5 = strM10545g;
            if (iM10559u3 <= 0) {
                break;
            }
            String strM10558t3 = classReader22.m10558t(iM10541c, cArr);
            int i25 = i13;
            int iM10550l = classReader22.m10550l(iM10541c + 2);
            int i26 = iM10541c + 6;
            Context3 context33 = context32;
            if ("SourceFile".equals(strM10558t3)) {
                strM10558t = classReader22.m10558t(i26, cArr);
                strM10560v = str3;
                i16 = i;
                strM10545g = str5;
            } else {
                if ("InnerClasses".equals(strM10558t3)) {
                    i24 = i26;
                } else if ("EnclosingMethod".equals(strM10558t3)) {
                    i18 = i26;
                } else if ("NestHost".equals(strM10558t3)) {
                    strM10545g4 = classReader22.m10545g(i26, cArr);
                } else if ("NestMembers".equals(strM10558t3)) {
                    i23 = i26;
                } else if ("Signature".equals(strM10558t3)) {
                    strM10558t2 = classReader22.m10558t(i26, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(strM10558t3)) {
                    i19 = i26;
                } else if ("RuntimeVisibleTypeAnnotations".equals(strM10558t3)) {
                    i21 = i26;
                } else if ("Deprecated".equals(strM10558t3)) {
                    i15 |= 131072;
                } else if ("Synthetic".equals(strM10558t3)) {
                    i15 |= 4096;
                } else if ("SourceDebugExtension".equals(strM10558t3)) {
                    strM10560v = classReader22.m10560v(i26, iM10550l, new char[iM10550l]);
                    i16 = i;
                    strM10545g = str5;
                    strM10558t = str;
                } else if ("RuntimeInvisibleAnnotations".equals(strM10558t3)) {
                    i20 = i26;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(strM10558t3)) {
                    i22 = i26;
                } else if ("Module".equals(strM10558t3)) {
                    i16 = i26;
                    strM10545g = str5;
                    strM10560v = str3;
                    strM10558t = str;
                } else if ("ModuleMainClass".equals(strM10558t3)) {
                    strM10545g = classReader22.m10545g(i26, cArr);
                    i16 = i;
                    strM10560v = str3;
                    strM10558t = str;
                } else if ("ModulePackages".equals(strM10558t3)) {
                    i17 = i26;
                } else {
                    if ("BootstrapMethods".equals(strM10558t3)) {
                        str33 = str;
                        i7 = i26;
                        str34 = str3;
                        i8 = i;
                        i9 = i15;
                        strArr3 = strArr5;
                        attribute2M10543e = attribute2;
                    } else {
                        i7 = i26;
                        i8 = i;
                        str33 = str;
                        str34 = str3;
                        i9 = i15;
                        strArr3 = strArr5;
                        attribute2M10543e = classReader22.m10543e(attribute2Arr, strM10558t3, i7, iM10550l, cArr, -1, null);
                        attribute2M10543e.f26150c = attribute2;
                    }
                    strM10558t = str33;
                    i16 = i8;
                    i15 = i9;
                    strM10545g = str5;
                    strM10560v = str34;
                    iM10541c = i7 + iM10550l;
                    iM10559u3--;
                    strArr5 = strArr3;
                    i13 = i25;
                    context32 = context33;
                }
                i16 = i;
                strM10545g = str5;
                strM10560v = str3;
                strM10558t = str;
            }
            attribute2M10543e = attribute2;
            i7 = i26;
            strArr3 = strArr5;
            iM10541c = i7 + iM10550l;
            iM10559u3--;
            strArr5 = strArr3;
            i13 = i25;
            context32 = context33;
        }
        int i27 = i13;
        String str35 = "RuntimeInvisibleTypeAnnotations";
        String str36 = "RuntimeInvisibleAnnotations";
        Context3 context34 = context32;
        ClassReader2 classReader23 = classReader22;
        String str37 = "RuntimeVisibleTypeAnnotations";
        m10565c(classReader22.m10550l(classReader22.f26156b[1] - 7), i15, strM10545g2, strM10558t2, strM10545g3, strArr5);
        if ((i11 & 2) != 0 || (str == null && str3 == null)) {
            classWriter2 = this;
            str6 = "Signature";
        } else {
            classWriter2 = this;
            str6 = "Signature";
            if (str != null) {
                classWriter2.f26180q = classWriter2.f26165b.m10637l(str);
            }
            if (str3 != null) {
                ByteVector2 byteVector2 = new ByteVector2();
                byteVector2.m10529a(str3, 0, Integer.MAX_VALUE);
                classWriter2.f26181r = byteVector2;
            }
        }
        if (i != 0) {
            char[] cArr2 = context34.f26196c;
            String strM10558t4 = classReader23.m10558t(classReader23.f26156b[classReader23.m10559u(i)], cArr2);
            int iM10559u4 = classReader23.m10559u(i + 2);
            String strM10558t5 = classReader23.m10558t(i + 4, cArr2);
            int i28 = i + 6;
            SymbolTable2 symbolTable2 = classWriter2.f26165b;
            str7 = "RuntimeVisibleAnnotations";
            ModuleWriter2 moduleWriter2 = new ModuleWriter2(symbolTable2, symbolTable2.m10638m(19, strM10558t4).f26340a, iM10559u4, strM10558t5 == null ? 0 : classWriter2.f26165b.m10637l(strM10558t5));
            classWriter2.f26186w = moduleWriter2;
            if (str5 != null) {
                moduleWriter2.f26332q = symbolTable2.m10638m(7, str5).f26340a;
            }
            int i29 = i17;
            if (i29 != 0) {
                int iM10559u5 = classReader23.m10559u(i29);
                int i30 = i29 + 2;
                while (true) {
                    int i31 = iM10559u5 - 1;
                    if (iM10559u5 <= 0) {
                        break;
                    }
                    moduleWriter2.f26331p.m10538j(moduleWriter2.f26316a.m10638m(20, classReader23.m10553o(i30, cArr2)).f26340a);
                    moduleWriter2.f26330o++;
                    i30 += 2;
                    iM10559u5 = i31;
                }
            }
            int iM10559u6 = classReader23.m10559u(i28);
            int i32 = i28 + 2;
            while (true) {
                int i33 = iM10559u6 - 1;
                if (iM10559u6 <= 0) {
                    break;
                }
                String strM10552n = classReader23.m10552n(i32, cArr2);
                int iM10559u7 = classReader23.m10559u(i32 + 2);
                String strM10558t6 = classReader23.m10558t(i32 + 4, cArr2);
                i32 += 6;
                ByteVector2 byteVector22 = moduleWriter2.f26321f;
                String str38 = str2;
                byteVector22.m10538j(moduleWriter2.f26316a.m10638m(19, strM10552n).f26340a);
                byteVector22.m10538j(iM10559u7);
                byteVector22.m10538j(strM10558t6 == null ? 0 : moduleWriter2.f26316a.m10637l(strM10558t6));
                moduleWriter2.f26320e++;
                iM10559u6 = i33;
                str2 = str38;
            }
            str8 = str2;
            int iM10559u8 = classReader23.m10559u(i32);
            int i34 = i32 + 2;
            while (true) {
                int i35 = iM10559u8 - 1;
                if (iM10559u8 <= 0) {
                    break;
                }
                String strM10553o = classReader23.m10553o(i34, cArr2);
                int iM10559u9 = classReader23.m10559u(i34 + 2);
                int iM10559u10 = classReader23.m10559u(i34 + 4);
                i34 += 6;
                if (iM10559u10 != 0) {
                    strArr2 = new String[iM10559u10];
                    int i36 = i34;
                    for (int i37 = 0; i37 < iM10559u10; i37++) {
                        strArr2[i37] = classReader23.m10552n(i36, cArr2);
                        i36 += 2;
                    }
                    i34 = i36;
                } else {
                    strArr2 = null;
                }
                ByteVector2 byteVector23 = moduleWriter2.f26323h;
                byteVector23.m10538j(moduleWriter2.f26316a.m10638m(20, strM10553o).f26340a);
                byteVector23.m10538j(iM10559u9);
                if (strArr2 == null) {
                    moduleWriter2.f26323h.m10538j(0);
                } else {
                    moduleWriter2.f26323h.m10538j(strArr2.length);
                    for (String str39 : strArr2) {
                        moduleWriter2.f26323h.m10538j(moduleWriter2.f26316a.m10635j(str39).f26340a);
                    }
                }
                moduleWriter2.f26322g++;
                iM10559u8 = i35;
            }
            int iM10559u11 = classReader23.m10559u(i34);
            int i38 = i34 + 2;
            while (true) {
                int i39 = iM10559u11 - 1;
                if (iM10559u11 <= 0) {
                    break;
                }
                String strM10553o2 = classReader23.m10553o(i38, cArr2);
                int iM10559u12 = classReader23.m10559u(i38 + 2);
                int iM10559u13 = classReader23.m10559u(i38 + 4);
                i38 += 6;
                if (iM10559u13 != 0) {
                    strArr = new String[iM10559u13];
                    int i40 = i38;
                    for (int i41 = 0; i41 < iM10559u13; i41++) {
                        strArr[i41] = classReader23.m10552n(i40, cArr2);
                        i40 += 2;
                    }
                    i38 = i40;
                } else {
                    strArr = null;
                }
                ByteVector2 byteVector24 = moduleWriter2.f26325j;
                byteVector24.m10538j(moduleWriter2.f26316a.m10638m(20, strM10553o2).f26340a);
                byteVector24.m10538j(iM10559u12);
                if (strArr == null) {
                    moduleWriter2.f26325j.m10538j(0);
                } else {
                    moduleWriter2.f26325j.m10538j(strArr.length);
                    for (String str40 : strArr) {
                        moduleWriter2.f26325j.m10538j(moduleWriter2.f26316a.m10635j(str40).f26340a);
                    }
                }
                moduleWriter2.f26324i++;
                iM10559u11 = i39;
            }
            int iM10559u14 = classReader23.m10559u(i38);
            int i42 = i38 + 2;
            while (true) {
                int i43 = iM10559u14 - 1;
                if (iM10559u14 <= 0) {
                    break;
                }
                moduleWriter2.f26327l.m10538j(moduleWriter2.f26316a.m10638m(7, classReader23.m10545g(i42, cArr2)).f26340a);
                moduleWriter2.f26326k++;
                i42 += 2;
                iM10559u14 = i43;
            }
            int iM10559u15 = classReader23.m10559u(i42);
            int i44 = i42 + 2;
            while (true) {
                int i45 = iM10559u15 - 1;
                if (iM10559u15 <= 0) {
                    break;
                }
                String strM10545g5 = classReader23.m10545g(i44, cArr2);
                int iM10559u16 = classReader23.m10559u(i44 + 2);
                String[] strArr6 = new String[iM10559u16];
                int i46 = i44 + 4;
                for (int i47 = 0; i47 < iM10559u16; i47++) {
                    strArr6[i47] = classReader23.m10545g(i46, cArr2);
                    i46 += 2;
                }
                char[] cArr3 = cArr2;
                moduleWriter2.f26329n.m10538j(moduleWriter2.f26316a.m10638m(7, strM10545g5).f26340a);
                moduleWriter2.f26329n.m10538j(iM10559u16);
                for (int i48 = 0; i48 < iM10559u16; i48++) {
                    moduleWriter2.f26329n.m10538j(moduleWriter2.f26316a.m10628c(strArr6[i48]).f26340a);
                }
                moduleWriter2.f26328m++;
                iM10559u15 = i45;
                i44 = i46;
                cArr2 = cArr3;
            }
        } else {
            str7 = "RuntimeVisibleAnnotations";
            str8 = "Synthetic";
        }
        String str41 = strM10545g4;
        if (str41 != null) {
            classWriter2.f26187x = classWriter2.f26165b.m10638m(7, str41).f26340a;
        }
        int i49 = i18;
        if (i49 != 0) {
            String strM10545g6 = classReader23.m10545g(i49, cArr);
            int iM10559u17 = classReader23.m10559u(i49 + 2);
            String strM10558t7 = iM10559u17 == 0 ? null : classReader23.m10558t(classReader23.f26156b[iM10559u17], cArr);
            String strM10558t8 = iM10559u17 == 0 ? null : classReader23.m10558t(classReader23.f26156b[iM10559u17] + 2, cArr);
            classWriter2.f26177n = classWriter2.f26165b.m10638m(7, strM10545g6).f26340a;
            if (strM10558t7 != null && strM10558t8 != null) {
                classWriter2.f26178o = classWriter2.f26165b.m10636k(strM10558t7, strM10558t8);
            }
        }
        int i50 = i19;
        if (i50 != 0) {
            int iM10559u18 = classReader23.m10559u(i50);
            int iM10549k = i50 + 2;
            while (true) {
                int i51 = iM10559u18 - 1;
                if (iM10559u18 <= 0) {
                    break;
                }
                iM10549k = classReader23.m10549k(classWriter2.m10566d(classReader23.m10558t(iM10549k, cArr), true), iM10549k + 2, true, cArr);
                iM10559u18 = i51;
            }
        }
        int i52 = i20;
        if (i52 != 0) {
            int iM10559u19 = classReader23.m10559u(i52);
            int iM10549k2 = i52 + 2;
            while (true) {
                int i53 = iM10559u19 - 1;
                if (iM10559u19 <= 0) {
                    break;
                }
                iM10549k2 = classReader23.m10549k(classWriter2.m10566d(classReader23.m10558t(iM10549k2, cArr), false), iM10549k2 + 2, true, cArr);
                iM10559u19 = i53;
            }
        }
        int i54 = i21;
        if (i54 != 0) {
            int iM10559u20 = classReader23.m10559u(i54);
            int iM10549k3 = i54 + 2;
            while (true) {
                int i55 = iM10559u20 - 1;
                if (iM10559u20 <= 0) {
                    break;
                }
                int iM10556r = classReader23.m10556r(context34, iM10549k3);
                iM10549k3 = classReader23.m10549k(classWriter2.m10568f(context34.f26201h, context34.f26202i, classReader23.m10558t(iM10556r, cArr), true), iM10556r + 2, true, cArr);
                iM10559u20 = i55;
            }
        }
        int i56 = i22;
        if (i56 != 0) {
            int iM10559u21 = classReader23.m10559u(i56);
            int iM10549k4 = i56 + 2;
            while (true) {
                int i57 = iM10559u21 - 1;
                if (iM10559u21 <= 0) {
                    break;
                }
                int iM10556r2 = classReader23.m10556r(context34, iM10549k4);
                iM10549k4 = classReader23.m10549k(classWriter2.m10568f(context34.f26201h, context34.f26202i, classReader23.m10558t(iM10556r2, cArr), false), iM10556r2 + 2, true, cArr);
                iM10559u21 = i57;
            }
        }
        Attribute2 attribute22 = attribute2;
        while (attribute22 != null) {
            Attribute2 attribute23 = attribute22.f26150c;
            attribute22.f26150c = null;
            attribute22.f26150c = classWriter2.f26162A;
            classWriter2.f26162A = attribute22;
            attribute22 = attribute23;
        }
        int i58 = i23;
        if (i58 != 0) {
            int iM10559u22 = classReader23.m10559u(i58);
            int i59 = i58 + 2;
            while (true) {
                int i60 = iM10559u22 - 1;
                if (iM10559u22 <= 0) {
                    break;
                }
                String strM10545g7 = classReader23.m10545g(i59, cArr);
                if (classWriter2.f26189z == null) {
                    classWriter2.f26189z = new ByteVector2();
                }
                classWriter2.f26188y++;
                classWriter2.f26189z.m10538j(classWriter2.f26165b.m10638m(7, strM10545g7).f26340a);
                i59 += 2;
                iM10559u22 = i60;
            }
        }
        int i61 = i24;
        if (i61 != 0) {
            int iM10559u23 = classReader23.m10559u(i61);
            int i62 = i61 + 2;
            while (true) {
                int i63 = iM10559u23 - 1;
                if (iM10559u23 <= 0) {
                    break;
                }
                String strM10545g8 = classReader23.m10545g(i62, cArr);
                String strM10545g9 = classReader23.m10545g(i62 + 2, cArr);
                String strM10558t9 = classReader23.m10558t(i62 + 4, cArr);
                int iM10559u24 = classReader23.m10559u(i62 + 6);
                if (classWriter2.f26176m == null) {
                    classWriter2.f26176m = new ByteVector2();
                }
                Symbol2 symbol2M10638m = classWriter2.f26165b.m10638m(7, strM10545g8);
                if (symbol2M10638m.f26346g == 0) {
                    classWriter2.f26175l++;
                    classWriter2.f26176m.m10538j(symbol2M10638m.f26340a);
                    classWriter2.f26176m.m10538j(strM10545g9 == null ? 0 : classWriter2.f26165b.m10638m(7, strM10545g9).f26340a);
                    classWriter2.f26176m.m10538j(strM10558t9 == null ? 0 : classWriter2.f26165b.m10637l(strM10558t9));
                    classWriter2.f26176m.m10538j(iM10559u24);
                    symbol2M10638m.f26346g = classWriter2.f26175l;
                }
                i62 += 8;
                iM10559u23 = i63;
            }
        }
        int iM10559u25 = classReader23.m10559u(i27);
        int i64 = i27 + 2;
        while (true) {
            int i65 = iM10559u25 - 1;
            if (iM10559u25 <= 0) {
                break;
            }
            char[] cArr4 = context34.f26196c;
            int iM10559u26 = classReader23.m10559u(i64);
            String strM10558t10 = classReader23.m10558t(i64 + 2, cArr4);
            String strM10558t11 = classReader23.m10558t(i64 + 4, cArr4);
            int i66 = i64 + 6;
            int iM10559u27 = classReader23.m10559u(i66);
            i64 = i66 + 2;
            int i67 = iM10559u26;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            Attribute2 attribute24 = null;
            int i71 = 0;
            String strM10558t12 = null;
            Object objM10547i = null;
            while (true) {
                int i72 = iM10559u27 - 1;
                if (iM10559u27 <= 0) {
                    break;
                }
                String strM10558t13 = classReader23.m10558t(i64, cArr4);
                int iM10550l2 = classReader23.m10550l(i64 + 2);
                int i73 = i64 + 6;
                if ("ConstantValue".equals(strM10558t13)) {
                    int iM10559u28 = classReader23.m10559u(i73);
                    if (iM10559u28 == 0) {
                        str22 = str8;
                        objM10547i = null;
                        i4 = i65;
                        i6 = i67;
                        i5 = i71;
                        str23 = str37;
                        str24 = str36;
                        str25 = str7;
                        str26 = str35;
                        str32 = str26;
                        str31 = str6;
                        str28 = str22;
                        str27 = str23;
                        str30 = str4;
                        classReader2 = classReader23;
                        str29 = str24;
                        context3 = context34;
                        i71 = i5;
                        i67 = i6;
                    } else {
                        objM10547i = classReader23.m10547i(iM10559u28, cArr4);
                        str22 = str8;
                        i4 = i65;
                        i6 = i67;
                        i5 = i71;
                        str23 = str37;
                        str24 = str36;
                        str25 = str7;
                        str26 = str35;
                        str32 = str26;
                        str31 = str6;
                        str28 = str22;
                        str27 = str23;
                        str30 = str4;
                        classReader2 = classReader23;
                        str29 = str24;
                        context3 = context34;
                        i71 = i5;
                        i67 = i6;
                    }
                } else {
                    if (str6.equals(strM10558t13)) {
                        strM10558t12 = classReader23.m10558t(i73, cArr4);
                    } else if (str4.equals(strM10558t13)) {
                        i67 |= 131072;
                    } else {
                        str22 = str8;
                        if (str22.equals(strM10558t13)) {
                            i67 |= 4096;
                            i4 = i65;
                            i6 = i67;
                            i5 = i71;
                            str23 = str37;
                            str24 = str36;
                            str25 = str7;
                            str26 = str35;
                            str32 = str26;
                            str31 = str6;
                            str28 = str22;
                            str27 = str23;
                            str30 = str4;
                            classReader2 = classReader23;
                            str29 = str24;
                            context3 = context34;
                            i71 = i5;
                            i67 = i6;
                        } else {
                            i4 = i65;
                            String str42 = str7;
                            if (str42.equals(strM10558t13)) {
                                str32 = str35;
                                i68 = i73;
                                str31 = str6;
                                str28 = str22;
                                str30 = str4;
                                context3 = context34;
                                str27 = str37;
                                str29 = str36;
                                str25 = str42;
                                classReader2 = classReader23;
                            } else {
                                int i74 = i67;
                                str23 = str37;
                                if (str23.equals(strM10558t13)) {
                                    i70 = i73;
                                    i5 = i71;
                                    str24 = str36;
                                } else {
                                    i5 = i71;
                                    str24 = str36;
                                    if (str24.equals(strM10558t13)) {
                                        i69 = i73;
                                    } else {
                                        str25 = str42;
                                        str26 = str35;
                                        if (str26.equals(strM10558t13)) {
                                            i6 = i74;
                                            i5 = i73;
                                            str32 = str26;
                                            str31 = str6;
                                            str28 = str22;
                                            str27 = str23;
                                            str30 = str4;
                                            classReader2 = classReader23;
                                            str29 = str24;
                                            context3 = context34;
                                            i71 = i5;
                                            i67 = i6;
                                        } else {
                                            str27 = str23;
                                            str28 = str22;
                                            str29 = str24;
                                            str30 = str4;
                                            str31 = str6;
                                            classReader2 = classReader23;
                                            str32 = str26;
                                            context3 = context34;
                                            Attribute2 attribute2M10543e2 = classReader23.m10543e(context34.f26194a, strM10558t13, i73, iM10550l2, cArr4, -1, null);
                                            attribute2M10543e2.f26150c = attribute24;
                                            attribute24 = attribute2M10543e2;
                                            i67 = i74;
                                            i71 = i5;
                                        }
                                    }
                                }
                                i6 = i74;
                                str25 = str42;
                                str26 = str35;
                                str32 = str26;
                                str31 = str6;
                                str28 = str22;
                                str27 = str23;
                                str30 = str4;
                                classReader2 = classReader23;
                                str29 = str24;
                                context3 = context34;
                                i71 = i5;
                                i67 = i6;
                            }
                        }
                    }
                    str22 = str8;
                    i4 = i65;
                    i6 = i67;
                    i5 = i71;
                    str23 = str37;
                    str24 = str36;
                    str25 = str7;
                    str26 = str35;
                    str32 = str26;
                    str31 = str6;
                    str28 = str22;
                    str27 = str23;
                    str30 = str4;
                    classReader2 = classReader23;
                    str29 = str24;
                    context3 = context34;
                    i71 = i5;
                    i67 = i6;
                }
                i64 = i73 + iM10550l2;
                classReader23 = classReader2;
                context34 = context3;
                iM10559u27 = i72;
                str4 = str30;
                i65 = i4;
                str8 = str28;
                str36 = str29;
                str35 = str32;
                str6 = str31;
                str7 = str25;
                str37 = str27;
            }
            String str43 = str35;
            int i75 = i65;
            String str44 = str4;
            Attribute2 attribute25 = attribute24;
            ClassReader2 classReader24 = classReader23;
            int i76 = i71;
            String str45 = str37;
            String str46 = str36;
            String str47 = str8;
            String str48 = str7;
            String str49 = str6;
            Context3 context35 = context34;
            FieldWriter2 fieldWriter22 = new FieldWriter2(classWriter2.f26165b, i67, strM10558t10, strM10558t11, strM10558t12, objM10547i);
            if (classWriter2.f26171h == null) {
                classWriter2.f26171h = fieldWriter22;
            } else {
                classWriter2.f26172i.f26216a = fieldWriter22;
            }
            classWriter2.f26172i = fieldWriter22;
            if (i68 != 0) {
                int iM10559u29 = classReader24.m10559u(i68);
                int iM10549k5 = i68 + 2;
                while (true) {
                    int i77 = iM10559u29 - 1;
                    if (iM10559u29 <= 0) {
                        break;
                    }
                    iM10549k5 = classReader24.m10549k(fieldWriter22.m10570a(classReader24.m10558t(iM10549k5, cArr4), true), iM10549k5 + 2, true, cArr4);
                    iM10559u29 = i77;
                }
            }
            if (i69 != 0) {
                int iM10559u30 = classReader24.m10559u(i69);
                int iM10549k6 = i69 + 2;
                while (true) {
                    int i78 = iM10559u30 - 1;
                    if (iM10559u30 <= 0) {
                        break;
                    }
                    iM10549k6 = classReader24.m10549k(fieldWriter22.m10570a(classReader24.m10558t(iM10549k6, cArr4), false), iM10549k6 + 2, true, cArr4);
                    iM10559u30 = i78;
                }
            }
            if (i70 != 0) {
                int iM10559u31 = classReader24.m10559u(i70);
                int iM10549k7 = i70 + 2;
                while (true) {
                    int i79 = iM10559u31 - 1;
                    if (iM10559u31 <= 0) {
                        break;
                    }
                    int iM10556r3 = classReader24.m10556r(context35, iM10549k7);
                    iM10549k7 = classReader24.m10549k(fieldWriter22.m10571b(context35.f26201h, context35.f26202i, classReader24.m10558t(iM10556r3, cArr4), true), iM10556r3 + 2, true, cArr4);
                    iM10559u31 = i79;
                }
            }
            if (i76 != 0) {
                int iM10559u32 = classReader24.m10559u(i76);
                int iM10549k8 = i76 + 2;
                while (true) {
                    int i80 = iM10559u32 - 1;
                    if (iM10559u32 <= 0) {
                        break;
                    }
                    int iM10556r4 = classReader24.m10556r(context35, iM10549k8);
                    iM10549k8 = classReader24.m10549k(fieldWriter22.m10571b(context35.f26201h, context35.f26202i, classReader24.m10558t(iM10556r4, cArr4), false), iM10556r4 + 2, true, cArr4);
                    iM10559u32 = i80;
                }
            }
            Attribute2 attribute26 = attribute25;
            while (attribute26 != null) {
                Attribute2 attribute27 = attribute26.f26150c;
                attribute26.f26150c = null;
                attribute26.f26150c = fieldWriter22.f26227l;
                fieldWriter22.f26227l = attribute26;
                attribute26 = attribute27;
            }
            classReader23 = classReader24;
            context34 = context35;
            str4 = str44;
            iM10559u25 = i75;
            str8 = str47;
            str36 = str46;
            str35 = str43;
            str6 = str49;
            str7 = str48;
            str37 = str45;
        }
        String str50 = str35;
        String str51 = str4;
        ClassReader2 classReader25 = classReader23;
        String str52 = str37;
        String str53 = str36;
        String str54 = str8;
        String str55 = str7;
        String str56 = str6;
        Context3 context36 = context34;
        int i81 = 1;
        int iM10559u33 = classReader25.m10559u(i64);
        int i82 = i64 + 2;
        while (true) {
            int i83 = iM10559u33 - 1;
            if (iM10559u33 <= 0) {
                return m10564b();
            }
            char[] cArr5 = context36.f26196c;
            context36.f26197d = classReader25.m10559u(i82);
            context36.f26198e = classReader25.m10558t(i82 + 2, cArr5);
            int i84 = i82 + 4;
            context36.f26199f = classReader25.m10558t(i84, cArr5);
            int i85 = i82 + 6;
            int iM10559u34 = classReader25.m10559u(i85);
            int i86 = i85 + 2;
            int i87 = 0;
            int i88 = 0;
            boolean z5 = false;
            Attribute2 attribute28 = null;
            String[] strArr7 = null;
            int i89 = 0;
            int i90 = 0;
            int iM10559u35 = 0;
            int i91 = 0;
            int i92 = 0;
            int i93 = 0;
            int i94 = 0;
            int i95 = 0;
            int i96 = 0;
            while (true) {
                int i97 = iM10559u34 - 1;
                if (iM10559u34 <= 0) {
                    break;
                }
                String strM10558t14 = classReader25.m10558t(i86, cArr5);
                int iM10550l3 = classReader25.m10550l(i86 + 2);
                int i98 = i86 + 6;
                if ("Code".equals(strM10558t14)) {
                    if ((context36.f26195b & i81) == 0) {
                        i96 = i98;
                        str11 = str55;
                        str10 = str51;
                        i2 = i85;
                        str12 = str11;
                        str15 = str50;
                        str17 = str56;
                        str16 = str10;
                        i3 = i98;
                        str18 = str12;
                        str19 = str52;
                        str20 = str53;
                        str21 = str15;
                    } else {
                        str9 = str56;
                        str10 = str51;
                        str56 = str9;
                        str11 = str55;
                        i2 = i85;
                        str12 = str11;
                        str15 = str50;
                        str17 = str56;
                        str16 = str10;
                        i3 = i98;
                        str18 = str12;
                        str19 = str52;
                        str20 = str53;
                        str21 = str15;
                    }
                } else if ("Exceptions".equals(strM10558t14)) {
                    int iM10559u36 = classReader25.m10559u(i98);
                    String[] strArr8 = new String[iM10559u36];
                    int i99 = i98 + 2;
                    for (int i100 = 0; i100 < iM10559u36; i100++) {
                        strArr8[i100] = classReader25.m10545g(i99, cArr5);
                        i99 += 2;
                    }
                    strArr7 = strArr8;
                    i88 = i98;
                    str11 = str55;
                    str10 = str51;
                    i2 = i85;
                    str12 = str11;
                    str15 = str50;
                    str17 = str56;
                    str16 = str10;
                    i3 = i98;
                    str18 = str12;
                    str19 = str52;
                    str20 = str53;
                    str21 = str15;
                } else {
                    str9 = str56;
                    if (str9.equals(strM10558t14)) {
                        iM10559u35 = classReader25.m10559u(i98);
                        str10 = str51;
                        str56 = str9;
                        str11 = str55;
                        i2 = i85;
                        str12 = str11;
                        str15 = str50;
                        str17 = str56;
                        str16 = str10;
                        i3 = i98;
                        str18 = str12;
                        str19 = str52;
                        str20 = str53;
                        str21 = str15;
                    } else {
                        str10 = str51;
                        if (str10.equals(strM10558t14)) {
                            context36.f26197d |= 131072;
                            str56 = str9;
                            str11 = str55;
                            i2 = i85;
                            str12 = str11;
                            str15 = str50;
                            str17 = str56;
                            str16 = str10;
                            i3 = i98;
                            str18 = str12;
                            str19 = str52;
                            str20 = str53;
                            str21 = str15;
                        } else {
                            str56 = str9;
                            str11 = str55;
                            if (str11.equals(strM10558t14)) {
                                i90 = i98;
                                i2 = i85;
                                str12 = str11;
                                str15 = str50;
                                str17 = str56;
                                str16 = str10;
                                i3 = i98;
                                str18 = str12;
                                str19 = str52;
                                str20 = str53;
                                str21 = str15;
                            } else {
                                str12 = str11;
                                String str57 = str52;
                                if (str57.equals(strM10558t14)) {
                                    i2 = i85;
                                    i92 = i98;
                                } else {
                                    i2 = i85;
                                    if ("AnnotationDefault".equals(strM10558t14)) {
                                        i87 = i98;
                                    } else {
                                        str13 = str54;
                                        if (str13.equals(strM10558t14)) {
                                            context36.f26197d |= 4096;
                                            str17 = str56;
                                            str54 = str13;
                                            str16 = str10;
                                            i3 = i98;
                                            str19 = str57;
                                            str18 = str12;
                                            str20 = str53;
                                            str21 = str50;
                                            z5 = true;
                                        } else {
                                            str52 = str57;
                                            str14 = str53;
                                            if (str14.equals(strM10558t14)) {
                                                i91 = i98;
                                                str54 = str13;
                                                str53 = str14;
                                                str15 = str50;
                                                str17 = str56;
                                                str16 = str10;
                                                i3 = i98;
                                                str18 = str12;
                                                str19 = str52;
                                                str20 = str53;
                                                str21 = str15;
                                            } else {
                                                str53 = str14;
                                                str15 = str50;
                                                if (str15.equals(strM10558t14)) {
                                                    str54 = str13;
                                                    i93 = i98;
                                                } else {
                                                    str54 = str13;
                                                    if ("RuntimeVisibleParameterAnnotations".equals(strM10558t14)) {
                                                        i94 = i98;
                                                    } else if ("RuntimeInvisibleParameterAnnotations".equals(strM10558t14)) {
                                                        i95 = i98;
                                                    } else if ("MethodParameters".equals(strM10558t14)) {
                                                        i89 = i98;
                                                    } else {
                                                        str16 = str10;
                                                        i3 = i98;
                                                        str17 = str56;
                                                        str18 = str12;
                                                        str19 = str52;
                                                        str20 = str53;
                                                        str21 = str15;
                                                        Attribute2 attribute2M10543e3 = classReader25.m10543e(context36.f26194a, strM10558t14, i98, iM10550l3, cArr5, -1, null);
                                                        attribute2M10543e3.f26150c = attribute28;
                                                        z5 = z5;
                                                        i88 = i88;
                                                        attribute28 = attribute2M10543e3;
                                                        i87 = i87;
                                                    }
                                                }
                                                str17 = str56;
                                                str16 = str10;
                                                i3 = i98;
                                                str18 = str12;
                                                str19 = str52;
                                                str20 = str53;
                                                str21 = str15;
                                            }
                                        }
                                    }
                                }
                                str52 = str57;
                                str13 = str54;
                                str14 = str53;
                                str54 = str13;
                                str53 = str14;
                                str15 = str50;
                                str17 = str56;
                                str16 = str10;
                                i3 = i98;
                                str18 = str12;
                                str19 = str52;
                                str20 = str53;
                                str21 = str15;
                            }
                        }
                    }
                }
                i86 = i3 + iM10550l3;
                i85 = i2;
                str50 = str21;
                iM10559u34 = i97;
                str51 = str16;
                str53 = str20;
                str52 = str19;
                str55 = str18;
                str56 = str17;
                i81 = 1;
            }
            String str58 = str56;
            int i101 = i85;
            int i102 = i87;
            int i103 = i88;
            boolean z6 = z5;
            Attribute2 attribute29 = attribute28;
            String str59 = str55;
            String str60 = str51;
            String str61 = str52;
            String str62 = str53;
            String str63 = str50;
            int i104 = context36.f26197d;
            String str64 = context36.f26198e;
            String str65 = context36.f26199f;
            int i105 = iM10559u35;
            if (i105 == 0) {
                z3 = z6;
                strM10561w = null;
            } else {
                strM10561w = classReader25.m10561w(i105, cArr5);
                z3 = z6;
            }
            String str66 = str54;
            ClassReader2 classReader26 = classReader25;
            str51 = str60;
            String str67 = strM10561w;
            Context3 context37 = context36;
            MethodVisitor2 methodVisitor2M10567e = m10567e(i104, str64, str65, str67, strArr7);
            MethodWriter2 methodWriter22 = (MethodWriter2) methodVisitor2M10567e;
            int i106 = i86 - i82;
            boolean z7 = (context37.f26197d & 131072) != 0;
            int iM10559u37 = classReader26.m10559u(i84);
            SymbolTable2 symbolTable22 = methodWriter22.f26293d;
            if (classReader26 != symbolTable22.f26348b || iM10559u37 != methodWriter22.f26297h || i105 != methodWriter22.f26265A) {
                z4 = false;
                break;
            }
            int i107 = methodWriter22.f26294e;
            if (z7 == ((i107 & 131072) != 0)) {
                if (z3 == (symbolTable22.f26349c < 49 && (i107 & 4096) != 0)) {
                    if (i103 != 0) {
                        if (classReader26.m10559u(i103) == methodWriter22.f26314y) {
                            int i108 = i103 + 2;
                            for (int i109 = 0; i109 < methodWriter22.f26314y; i109++) {
                                if (classReader26.m10559u(i108) != methodWriter22.f26315z[i109]) {
                                    z4 = false;
                                    break;
                                }
                                i108 += 2;
                            }
                        }
                        methodWriter22.f26291a0 = i101;
                        methodWriter22.f26292b0 = i106 - 6;
                        z4 = true;
                    } else if (methodWriter22.f26314y == 0) {
                        methodWriter22.f26291a0 = i101;
                        methodWriter22.f26292b0 = i106 - 6;
                        z4 = true;
                    }
                }
            }
            if (!z4) {
                int i110 = i89;
                if (i110 != 0) {
                    int iM10544f = classReader26.m10544f(i110);
                    int i111 = i110 + 1;
                    while (true) {
                        int i112 = iM10544f - 1;
                        if (iM10544f <= 0) {
                            break;
                        }
                        String strM10558t15 = classReader26.m10558t(i111, cArr5);
                        int iM10559u38 = classReader26.m10559u(i111 + 2);
                        if (methodWriter22.f26276L == null) {
                            methodWriter22.f26276L = new ByteVector2();
                        }
                        methodWriter22.f26275K++;
                        ByteVector2 byteVector25 = methodWriter22.f26276L;
                        byteVector25.m10538j(strM10558t15 == null ? 0 : methodWriter22.f26293d.m10637l(strM10558t15));
                        byteVector25.m10538j(iM10559u38);
                        i111 += 4;
                        iM10544f = i112;
                    }
                }
                if (i102 != 0) {
                    ByteVector2 byteVector26 = new ByteVector2();
                    methodWriter22.f26274J = byteVector26;
                    AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(methodWriter22.f26293d, false, byteVector26, null);
                    classReader26.m10548j(annotationWriter2, i102, null, cArr5);
                    annotationWriter2.m10522g();
                }
                int i113 = i90;
                if (i113 != 0) {
                    int iM10559u39 = classReader26.m10559u(i113);
                    int iM10549k9 = i113 + 2;
                    while (true) {
                        int i114 = iM10559u39 - 1;
                        if (iM10559u39 <= 0) {
                            break;
                        }
                        iM10549k9 = classReader26.m10549k(methodVisitor2M10567e.mo10593a(classReader26.m10558t(iM10549k9, cArr5), true), iM10549k9 + 2, true, cArr5);
                        iM10559u39 = i114;
                    }
                }
                int i115 = i91;
                if (i115 != 0) {
                    int iM10559u40 = classReader26.m10559u(i115);
                    int iM10549k10 = i115 + 2;
                    while (true) {
                        int i116 = iM10559u40 - 1;
                        if (iM10559u40 <= 0) {
                            break;
                        }
                        iM10549k10 = classReader26.m10549k(methodVisitor2M10567e.mo10593a(classReader26.m10558t(iM10549k10, cArr5), false), iM10549k10 + 2, true, cArr5);
                        iM10559u40 = i116;
                    }
                }
                int i117 = i92;
                if (i117 != 0) {
                    int iM10559u41 = classReader26.m10559u(i117);
                    int iM10549k11 = i117 + 2;
                    while (true) {
                        int i118 = iM10559u41 - 1;
                        if (iM10559u41 <= 0) {
                            break;
                        }
                        int iM10556r5 = classReader26.m10556r(context37, iM10549k11);
                        iM10549k11 = classReader26.m10549k(methodVisitor2M10567e.mo10610r(context37.f26201h, context37.f26202i, classReader26.m10558t(iM10556r5, cArr5), true), iM10556r5 + 2, true, cArr5);
                        iM10559u41 = i118;
                    }
                }
                int i119 = i93;
                if (i119 != 0) {
                    int iM10559u42 = classReader26.m10559u(i119);
                    int iM10549k12 = i119 + 2;
                    while (true) {
                        int i120 = iM10559u42 - 1;
                        if (iM10559u42 <= 0) {
                            break;
                        }
                        int iM10556r6 = classReader26.m10556r(context37, iM10549k12);
                        iM10549k12 = classReader26.m10549k(methodVisitor2M10567e.mo10610r(context37.f26201h, context37.f26202i, classReader26.m10558t(iM10556r6, cArr5), false), iM10556r6 + 2, true, cArr5);
                        iM10559u42 = i120;
                    }
                }
                int i121 = i94;
                if (i121 != 0) {
                    classReader26.m10554p(methodVisitor2M10567e, context37, i121, true);
                }
                int i122 = i95;
                if (i122 != 0) {
                    classReader26.m10554p(methodVisitor2M10567e, context37, i122, false);
                }
                Attribute2 attribute210 = attribute29;
                while (attribute210 != null) {
                    Attribute2 attribute211 = attribute210.f26150c;
                    attribute210.f26150c = null;
                    attribute210.f26150c = methodWriter22.f26277M;
                    methodWriter22.f26277M = attribute210;
                    attribute210 = attribute211;
                }
                int i123 = i96;
                if (i123 != 0) {
                    classReader26.m10546h(methodVisitor2M10567e, context37, i123);
                }
            }
            iM10559u33 = i83;
            i82 = i86;
            classReader25 = classReader26;
            context36 = context37;
            str54 = str66;
            str50 = str63;
            str55 = str59;
            str56 = str58;
            str53 = str62;
            str52 = str61;
            i81 = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:337:0x06b3  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] m10564b() throws MethodTooLargeException, ClassTooLargeException {
        int iM10523a;
        int i;
        String str;
        int i2;
        String str2;
        String str3;
        int i3;
        int i4;
        int i5;
        String str4;
        String str5;
        int i6;
        int i7;
        int iM10518a;
        int iM10523a2;
        int iM10523a3 = (this.f26169f * 2) + 24;
        FieldWriter2 fieldWriter2 = this.f26171h;
        int i8 = 0;
        while (true) {
            iM10523a = 16;
            if (fieldWriter2 == null) {
                break;
            }
            i8++;
            if (fieldWriter2.f26222g != 0) {
                fieldWriter2.f26217b.m10637l("ConstantValue");
            } else {
                iM10523a = 8;
            }
            if ((fieldWriter2.f26218c & 4096) != 0) {
                SymbolTable2 symbolTable2 = fieldWriter2.f26217b;
                if (symbolTable2.f26349c < 49) {
                    symbolTable2.m10637l("Synthetic");
                    iM10523a += 6;
                }
            }
            if (fieldWriter2.f26221f != 0) {
                fieldWriter2.f26217b.m10637l("Signature");
                iM10523a += 8;
            }
            if ((fieldWriter2.f26218c & 131072) != 0) {
                fieldWriter2.f26217b.m10637l("Deprecated");
                iM10523a += 6;
            }
            AnnotationWriter2 annotationWriter2 = fieldWriter2.f26223h;
            if (annotationWriter2 != null) {
                iM10523a += annotationWriter2.m10518a("RuntimeVisibleAnnotations");
            }
            AnnotationWriter2 annotationWriter22 = fieldWriter2.f26224i;
            if (annotationWriter22 != null) {
                iM10523a += annotationWriter22.m10518a("RuntimeInvisibleAnnotations");
            }
            AnnotationWriter2 annotationWriter23 = fieldWriter2.f26225j;
            if (annotationWriter23 != null) {
                iM10523a += annotationWriter23.m10518a("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter2 annotationWriter24 = fieldWriter2.f26226k;
            if (annotationWriter24 != null) {
                iM10523a += annotationWriter24.m10518a("RuntimeInvisibleTypeAnnotations");
            }
            Attribute2 attribute2 = fieldWriter2.f26227l;
            if (attribute2 != null) {
                iM10523a += attribute2.m10523a(fieldWriter2.f26217b);
            }
            iM10523a3 += iM10523a;
            fieldWriter2 = (FieldWriter2) fieldWriter2.f26216a;
        }
        MethodWriter2 methodWriter2 = this.f26173j;
        int i9 = 0;
        while (true) {
            if (methodWriter2 == null) {
                ByteVector2 byteVector2 = this.f26176m;
                if (byteVector2 != null) {
                    iM10523a3 += byteVector2.f26154b + 8;
                    this.f26165b.m10637l("InnerClasses");
                    i = 1;
                } else {
                    i = 0;
                }
                if (this.f26177n != 0) {
                    i++;
                    iM10523a3 += 10;
                    this.f26165b.m10637l("EnclosingMethod");
                }
                if ((this.f26166c & 4096) != 0) {
                    str = "EnclosingMethod";
                    if ((this.f26164a & 65535) < 49) {
                        i++;
                        iM10523a3 += 6;
                        this.f26165b.m10637l("Synthetic");
                    }
                } else {
                    str = "EnclosingMethod";
                }
                if (this.f26179p != 0) {
                    i++;
                    iM10523a3 += 8;
                    this.f26165b.m10637l("Signature");
                }
                if (this.f26180q != 0) {
                    i++;
                    iM10523a3 += 8;
                    this.f26165b.m10637l("SourceFile");
                }
                ByteVector2 byteVector22 = this.f26181r;
                if (byteVector22 != null) {
                    i++;
                    iM10523a3 += byteVector22.f26154b + 6;
                    this.f26165b.m10637l("SourceDebugExtension");
                }
                if ((this.f26166c & 131072) != 0) {
                    i++;
                    iM10523a3 += 6;
                    this.f26165b.m10637l("Deprecated");
                }
                AnnotationWriter2 annotationWriter25 = this.f26182s;
                if (annotationWriter25 != null) {
                    i++;
                    iM10523a3 += annotationWriter25.m10518a("RuntimeVisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter26 = this.f26183t;
                if (annotationWriter26 != null) {
                    i++;
                    iM10523a3 += annotationWriter26.m10518a("RuntimeInvisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter27 = this.f26184u;
                if (annotationWriter27 != null) {
                    i++;
                    iM10523a3 += annotationWriter27.m10518a("RuntimeVisibleTypeAnnotations");
                }
                AnnotationWriter2 annotationWriter28 = this.f26185v;
                if (annotationWriter28 != null) {
                    i++;
                    iM10523a3 += annotationWriter28.m10518a("RuntimeInvisibleTypeAnnotations");
                }
                SymbolTable2 symbolTable22 = this.f26165b;
                if (symbolTable22.f26356j != null) {
                    symbolTable22.m10637l("BootstrapMethods");
                    i2 = symbolTable22.f26356j.f26154b + 8;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    i++;
                    SymbolTable2 symbolTable23 = this.f26165b;
                    if (symbolTable23.f26356j != null) {
                        symbolTable23.m10637l("BootstrapMethods");
                        i6 = symbolTable23.f26356j.f26154b + 8;
                    } else {
                        i6 = 0;
                    }
                    iM10523a3 += i6;
                }
                ModuleWriter2 moduleWriter2 = this.f26186w;
                String str6 = "ModuleMainClass";
                int i10 = i9;
                if (moduleWriter2 != null) {
                    str2 = "RuntimeInvisibleTypeAnnotations";
                    str3 = "RuntimeVisibleTypeAnnotations";
                    i += (moduleWriter2.f26330o > 0 ? 1 : 0) + 1 + (moduleWriter2.f26332q > 0 ? 1 : 0);
                    moduleWriter2.f26316a.m10637l("Module");
                    int i11 = moduleWriter2.f26321f.f26154b + 22 + moduleWriter2.f26323h.f26154b + moduleWriter2.f26325j.f26154b + moduleWriter2.f26327l.f26154b + moduleWriter2.f26329n.f26154b;
                    if (moduleWriter2.f26330o > 0) {
                        moduleWriter2.f26316a.m10637l("ModulePackages");
                        i11 += moduleWriter2.f26331p.f26154b + 8;
                    }
                    if (moduleWriter2.f26332q > 0) {
                        moduleWriter2.f26316a.m10637l("ModuleMainClass");
                        i11 += 8;
                    }
                    iM10523a3 += i11;
                } else {
                    str2 = "RuntimeInvisibleTypeAnnotations";
                    str3 = "RuntimeVisibleTypeAnnotations";
                }
                if (this.f26187x != 0) {
                    i++;
                    iM10523a3 += 8;
                    this.f26165b.m10637l("NestHost");
                }
                ByteVector2 byteVector23 = this.f26189z;
                if (byteVector23 != null) {
                    i++;
                    iM10523a3 += byteVector23.f26154b + 8;
                    this.f26165b.m10637l("NestMembers");
                }
                Attribute2 attribute22 = this.f26162A;
                if (attribute22 != null) {
                    int iM10525c = i + attribute22.m10525c();
                    iM10523a3 += this.f26162A.m10523a(this.f26165b);
                    i = iM10525c;
                }
                SymbolTable2 symbolTable24 = this.f26165b;
                int i12 = iM10523a3 + symbolTable24.f26354h.f26154b;
                int i13 = symbolTable24.f26353g;
                if (i13 > 65535) {
                    throw new ClassTooLargeException(this.f26165b.f26350d, i13);
                }
                ByteVector2 byteVector24 = new ByteVector2(i12);
                byteVector24.m10537i(-889275714);
                byteVector24.m10537i(this.f26164a);
                SymbolTable2 symbolTable25 = this.f26165b;
                byteVector24.m10538j(symbolTable25.f26353g);
                ByteVector2 byteVector25 = symbolTable25.f26354h;
                byteVector24.m10536h(byteVector25.f26153a, 0, byteVector25.f26154b);
                byteVector24.m10538j((~((this.f26164a & 65535) < 49 ? 4096 : 0)) & this.f26166c);
                byteVector24.m10538j(this.f26167d);
                byteVector24.m10538j(this.f26168e);
                byteVector24.m10538j(this.f26169f);
                for (int i14 = 0; i14 < this.f26169f; i14++) {
                    byteVector24.m10538j(this.f26170g[i14]);
                }
                byteVector24.m10538j(i8);
                FieldWriter2 fieldWriter22 = this.f26171h;
                while (fieldWriter22 != null) {
                    boolean z2 = fieldWriter22.f26217b.f26349c < 49;
                    byteVector24.m10538j((~(z2 ? 4096 : 0)) & fieldWriter22.f26218c);
                    byteVector24.m10538j(fieldWriter22.f26219d);
                    byteVector24.m10538j(fieldWriter22.f26220e);
                    int iM10525c2 = fieldWriter22.f26222g != 0 ? 1 : 0;
                    int i15 = fieldWriter22.f26218c;
                    String str7 = str6;
                    if ((i15 & 4096) != 0 && z2) {
                        iM10525c2++;
                    }
                    if (fieldWriter22.f26221f != 0) {
                        iM10525c2++;
                    }
                    if ((i15 & 131072) != 0) {
                        iM10525c2++;
                    }
                    if (fieldWriter22.f26223h != null) {
                        iM10525c2++;
                    }
                    if (fieldWriter22.f26224i != null) {
                        iM10525c2++;
                    }
                    if (fieldWriter22.f26225j != null) {
                        iM10525c2++;
                    }
                    if (fieldWriter22.f26226k != null) {
                        iM10525c2++;
                    }
                    Attribute2 attribute23 = fieldWriter22.f26227l;
                    if (attribute23 != null) {
                        iM10525c2 += attribute23.m10525c();
                    }
                    byteVector24.m10538j(iM10525c2);
                    if (fieldWriter22.f26222g != 0) {
                        outline.m878t0(fieldWriter22.f26217b, "ConstantValue", byteVector24, 2);
                        byteVector24.m10538j(fieldWriter22.f26222g);
                    }
                    if ((fieldWriter22.f26218c & 4096) != 0 && z2) {
                        outline.m878t0(fieldWriter22.f26217b, "Synthetic", byteVector24, 0);
                    }
                    if (fieldWriter22.f26221f != 0) {
                        outline.m878t0(fieldWriter22.f26217b, "Signature", byteVector24, 2);
                        byteVector24.m10538j(fieldWriter22.f26221f);
                    }
                    if ((fieldWriter22.f26218c & 131072) != 0) {
                        outline.m878t0(fieldWriter22.f26217b, "Deprecated", byteVector24, 0);
                    }
                    AnnotationWriter2 annotationWriter29 = fieldWriter22.f26223h;
                    if (annotationWriter29 != null) {
                        annotationWriter29.m10519c(fieldWriter22.f26217b.m10637l("RuntimeVisibleAnnotations"), byteVector24);
                    }
                    AnnotationWriter2 annotationWriter210 = fieldWriter22.f26224i;
                    if (annotationWriter210 != null) {
                        annotationWriter210.m10519c(fieldWriter22.f26217b.m10637l("RuntimeInvisibleAnnotations"), byteVector24);
                    }
                    AnnotationWriter2 annotationWriter211 = fieldWriter22.f26225j;
                    if (annotationWriter211 != null) {
                        str4 = str3;
                        annotationWriter211.m10519c(fieldWriter22.f26217b.m10637l(str4), byteVector24);
                    } else {
                        str4 = str3;
                    }
                    AnnotationWriter2 annotationWriter212 = fieldWriter22.f26226k;
                    if (annotationWriter212 != null) {
                        str5 = str2;
                        annotationWriter212.m10519c(fieldWriter22.f26217b.m10637l(str5), byteVector24);
                    } else {
                        str5 = str2;
                    }
                    Attribute2 attribute24 = fieldWriter22.f26227l;
                    if (attribute24 != null) {
                        attribute24.m10526d(fieldWriter22.f26217b, byteVector24);
                    }
                    fieldWriter22 = (FieldWriter2) fieldWriter22.f26216a;
                    str3 = str4;
                    str2 = str5;
                    str6 = str7;
                }
                String str8 = str6;
                String str9 = str2;
                String str10 = str3;
                byteVector24.m10538j(i10);
                boolean z3 = false;
                boolean z4 = false;
                for (MethodWriter2 methodWriter22 = this.f26173j; methodWriter22 != null; methodWriter22 = (MethodWriter2) methodWriter22.f26263b) {
                    z4 |= methodWriter22.f26310u > 0;
                    z3 |= methodWriter22.f26289Y;
                    methodWriter22.m10619y(byteVector24);
                }
                byteVector24.m10538j(i);
                if (this.f26176m != null) {
                    byteVector24.m10538j(this.f26165b.m10637l("InnerClasses"));
                    byteVector24.m10537i(this.f26176m.f26154b + 2);
                    byteVector24.m10538j(this.f26175l);
                    ByteVector2 byteVector26 = this.f26176m;
                    byteVector24.m10536h(byteVector26.f26153a, 0, byteVector26.f26154b);
                }
                if (this.f26177n != 0) {
                    outline.m878t0(this.f26165b, str, byteVector24, 4);
                    byteVector24.m10538j(this.f26177n);
                    byteVector24.m10538j(this.f26178o);
                }
                if ((this.f26166c & 4096) != 0 && (this.f26164a & 65535) < 49) {
                    outline.m878t0(this.f26165b, "Synthetic", byteVector24, 0);
                }
                if (this.f26179p != 0) {
                    i3 = 2;
                    outline.m878t0(this.f26165b, "Signature", byteVector24, 2);
                    byteVector24.m10538j(this.f26179p);
                } else {
                    i3 = 2;
                }
                if (this.f26180q != 0) {
                    outline.m878t0(this.f26165b, "SourceFile", byteVector24, i3);
                    byteVector24.m10538j(this.f26180q);
                }
                ByteVector2 byteVector27 = this.f26181r;
                if (byteVector27 != null) {
                    int i16 = byteVector27.f26154b;
                    outline.m878t0(this.f26165b, "SourceDebugExtension", byteVector24, i16);
                    i4 = 0;
                    byteVector24.m10536h(this.f26181r.f26153a, 0, i16);
                } else {
                    i4 = 0;
                }
                if ((this.f26166c & 131072) != 0) {
                    outline.m878t0(this.f26165b, "Deprecated", byteVector24, i4);
                }
                AnnotationWriter2 annotationWriter213 = this.f26182s;
                if (annotationWriter213 != null) {
                    annotationWriter213.m10519c(this.f26165b.m10637l("RuntimeVisibleAnnotations"), byteVector24);
                }
                AnnotationWriter2 annotationWriter214 = this.f26183t;
                if (annotationWriter214 != null) {
                    annotationWriter214.m10519c(this.f26165b.m10637l("RuntimeInvisibleAnnotations"), byteVector24);
                }
                AnnotationWriter2 annotationWriter215 = this.f26184u;
                if (annotationWriter215 != null) {
                    annotationWriter215.m10519c(this.f26165b.m10637l(str10), byteVector24);
                }
                AnnotationWriter2 annotationWriter216 = this.f26185v;
                if (annotationWriter216 != null) {
                    annotationWriter216.m10519c(this.f26165b.m10637l(str9), byteVector24);
                }
                SymbolTable2 symbolTable26 = this.f26165b;
                if (symbolTable26.f26356j != null) {
                    byteVector24.m10538j(symbolTable26.m10637l("BootstrapMethods"));
                    byteVector24.m10537i(symbolTable26.f26356j.f26154b + 2);
                    byteVector24.m10538j(symbolTable26.f26355i);
                    ByteVector2 byteVector28 = symbolTable26.f26356j;
                    byteVector24.m10536h(byteVector28.f26153a, 0, byteVector28.f26154b);
                }
                ModuleWriter2 moduleWriter22 = this.f26186w;
                if (moduleWriter22 != null) {
                    outline.m878t0(moduleWriter22.f26316a, "Module", byteVector24, moduleWriter22.f26321f.f26154b + 16 + moduleWriter22.f26323h.f26154b + moduleWriter22.f26325j.f26154b + moduleWriter22.f26327l.f26154b + moduleWriter22.f26329n.f26154b);
                    byteVector24.m10538j(moduleWriter22.f26317b);
                    byteVector24.m10538j(moduleWriter22.f26318c);
                    byteVector24.m10538j(moduleWriter22.f26319d);
                    byteVector24.m10538j(moduleWriter22.f26320e);
                    ByteVector2 byteVector29 = moduleWriter22.f26321f;
                    byteVector24.m10536h(byteVector29.f26153a, 0, byteVector29.f26154b);
                    byteVector24.m10538j(moduleWriter22.f26322g);
                    ByteVector2 byteVector210 = moduleWriter22.f26323h;
                    byteVector24.m10536h(byteVector210.f26153a, 0, byteVector210.f26154b);
                    byteVector24.m10538j(moduleWriter22.f26324i);
                    ByteVector2 byteVector211 = moduleWriter22.f26325j;
                    byteVector24.m10536h(byteVector211.f26153a, 0, byteVector211.f26154b);
                    byteVector24.m10538j(moduleWriter22.f26326k);
                    ByteVector2 byteVector212 = moduleWriter22.f26327l;
                    byteVector24.m10536h(byteVector212.f26153a, 0, byteVector212.f26154b);
                    byteVector24.m10538j(moduleWriter22.f26328m);
                    ByteVector2 byteVector213 = moduleWriter22.f26329n;
                    byteVector24.m10536h(byteVector213.f26153a, 0, byteVector213.f26154b);
                    if (moduleWriter22.f26330o > 0) {
                        byteVector24.m10538j(moduleWriter22.f26316a.m10637l("ModulePackages"));
                        byteVector24.m10537i(moduleWriter22.f26331p.f26154b + 2);
                        byteVector24.m10538j(moduleWriter22.f26330o);
                        ByteVector2 byteVector214 = moduleWriter22.f26331p;
                        byteVector24.m10536h(byteVector214.f26153a, 0, byteVector214.f26154b);
                    }
                    if (moduleWriter22.f26332q > 0) {
                        i5 = 2;
                        outline.m878t0(moduleWriter22.f26316a, str8, byteVector24, 2);
                        byteVector24.m10538j(moduleWriter22.f26332q);
                    } else {
                        i5 = 2;
                    }
                }
                if (this.f26187x != 0) {
                    outline.m878t0(this.f26165b, "NestHost", byteVector24, i5);
                    byteVector24.m10538j(this.f26187x);
                }
                if (this.f26189z != null) {
                    byteVector24.m10538j(this.f26165b.m10637l("NestMembers"));
                    byteVector24.m10537i(this.f26189z.f26154b + 2);
                    byteVector24.m10538j(this.f26188y);
                    ByteVector2 byteVector215 = this.f26189z;
                    byteVector24.m10536h(byteVector215.f26153a, 0, byteVector215.f26154b);
                }
                Attribute2 attribute25 = this.f26162A;
                if (attribute25 != null) {
                    attribute25.m10526d(this.f26165b, byteVector24);
                }
                return z3 ? m10563a(byteVector24.f26153a, z4) : byteVector24.f26153a;
            }
            int i17 = i9 + 1;
            if (methodWriter2.f26291a0 != 0) {
                iM10523a2 = methodWriter2.f26292b0 + 6;
                i7 = i17;
            } else {
                int i18 = methodWriter2.f26301l.f26154b;
                if (i18 <= 0) {
                    i7 = i17;
                    iM10518a = 8;
                } else {
                    if (i18 > 65535) {
                        throw new MethodTooLargeException(methodWriter2.f26293d.f26350d, methodWriter2.f26296g, methodWriter2.f26298i, methodWriter2.f26301l.f26154b);
                    }
                    methodWriter2.f26293d.m10637l("Code");
                    int i19 = methodWriter2.f26301l.f26154b + iM10523a;
                    int i20 = 0;
                    for (Handler5 handler5 = methodWriter2.f26302m; handler5 != null; handler5 = handler5.f26247f) {
                        i20++;
                    }
                    iM10518a = (i20 * 8) + 2 + i19 + 8;
                    if (methodWriter2.f26311v != null) {
                        SymbolTable2 symbolTable27 = methodWriter2.f26293d;
                        i7 = i17;
                        symbolTable27.m10637l(symbolTable27.f26349c >= 50 ? "StackMapTable" : "StackMap");
                        iM10518a += methodWriter2.f26311v.f26154b + 8;
                    } else {
                        i7 = i17;
                    }
                    if (methodWriter2.f26305p != null) {
                        methodWriter2.f26293d.m10637l("LineNumberTable");
                        iM10518a += methodWriter2.f26305p.f26154b + 8;
                    }
                    if (methodWriter2.f26307r != null) {
                        methodWriter2.f26293d.m10637l("LocalVariableTable");
                        iM10518a += methodWriter2.f26307r.f26154b + 8;
                    }
                    if (methodWriter2.f26309t != null) {
                        methodWriter2.f26293d.m10637l("LocalVariableTypeTable");
                        iM10518a += methodWriter2.f26309t.f26154b + 8;
                    }
                    AnnotationWriter2 annotationWriter217 = methodWriter2.f26312w;
                    if (annotationWriter217 != null) {
                        iM10518a += annotationWriter217.m10518a("RuntimeVisibleTypeAnnotations");
                    }
                    AnnotationWriter2 annotationWriter218 = methodWriter2.f26313x;
                    if (annotationWriter218 != null) {
                        iM10518a += annotationWriter218.m10518a("RuntimeInvisibleTypeAnnotations");
                    }
                }
                if (methodWriter2.f26314y > 0) {
                    methodWriter2.f26293d.m10637l("Exceptions");
                    iM10518a += (methodWriter2.f26314y * 2) + 8;
                }
                SymbolTable2 symbolTable28 = methodWriter2.f26293d;
                boolean z5 = symbolTable28.f26349c < 49;
                if ((methodWriter2.f26294e & 4096) != 0 && z5) {
                    symbolTable28.m10637l("Synthetic");
                    iM10518a += 6;
                }
                if (methodWriter2.f26265A != 0) {
                    methodWriter2.f26293d.m10637l("Signature");
                    iM10518a += 8;
                }
                if ((methodWriter2.f26294e & 131072) != 0) {
                    methodWriter2.f26293d.m10637l("Deprecated");
                    iM10518a += 6;
                }
                AnnotationWriter2 annotationWriter219 = methodWriter2.f26266B;
                if (annotationWriter219 != null) {
                    iM10518a += annotationWriter219.m10518a("RuntimeVisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter220 = methodWriter2.f26267C;
                if (annotationWriter220 != null) {
                    iM10518a += annotationWriter220.m10518a("RuntimeInvisibleAnnotations");
                }
                AnnotationWriter2[] annotationWriter2Arr = methodWriter2.f26269E;
                if (annotationWriter2Arr != null) {
                    int length = methodWriter2.f26268D;
                    if (length == 0) {
                        length = annotationWriter2Arr.length;
                    }
                    iM10518a += AnnotationWriter2.m10516b("RuntimeVisibleParameterAnnotations", annotationWriter2Arr, length);
                }
                AnnotationWriter2[] annotationWriter2Arr2 = methodWriter2.f26271G;
                if (annotationWriter2Arr2 != null) {
                    int length2 = methodWriter2.f26270F;
                    if (length2 == 0) {
                        length2 = annotationWriter2Arr2.length;
                    }
                    iM10518a += AnnotationWriter2.m10516b("RuntimeInvisibleParameterAnnotations", annotationWriter2Arr2, length2);
                }
                AnnotationWriter2 annotationWriter221 = methodWriter2.f26272H;
                if (annotationWriter221 != null) {
                    iM10518a += annotationWriter221.m10518a("RuntimeVisibleTypeAnnotations");
                }
                AnnotationWriter2 annotationWriter222 = methodWriter2.f26273I;
                if (annotationWriter222 != null) {
                    iM10518a += annotationWriter222.m10518a("RuntimeInvisibleTypeAnnotations");
                }
                if (methodWriter2.f26274J != null) {
                    methodWriter2.f26293d.m10637l("AnnotationDefault");
                    iM10518a += methodWriter2.f26274J.f26154b + 6;
                }
                if (methodWriter2.f26276L != null) {
                    methodWriter2.f26293d.m10637l("MethodParameters");
                    iM10523a2 = methodWriter2.f26276L.f26154b + 7 + iM10518a;
                } else {
                    iM10523a2 = iM10518a;
                }
                Attribute2 attribute26 = methodWriter2.f26277M;
                if (attribute26 != null) {
                    iM10523a2 += attribute26.m10523a(methodWriter2.f26293d);
                }
            }
            iM10523a3 += iM10523a2;
            methodWriter2 = (MethodWriter2) methodWriter2.f26263b;
            iM10523a = 16;
            i9 = i7;
        }
    }

    /* renamed from: c */
    public final void m10565c(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.f26164a = i;
        this.f26166c = i2;
        SymbolTable2 symbolTable2 = this.f26165b;
        int i3 = i & 65535;
        symbolTable2.f26349c = i3;
        symbolTable2.f26350d = str;
        this.f26167d = symbolTable2.m10638m(7, str).f26340a;
        if (str2 != null) {
            this.f26179p = this.f26165b.m10637l(str2);
        }
        this.f26168e = str3 == null ? 0 : this.f26165b.m10638m(7, str3).f26340a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f26169f = length;
            this.f26170g = new int[length];
            for (int i4 = 0; i4 < this.f26169f; i4++) {
                this.f26170g[i4] = this.f26165b.m10628c(strArr[i4]).f26340a;
            }
        }
        if (this.f26163B != 1 || i3 < 51) {
            return;
        }
        this.f26163B = 2;
    }

    /* renamed from: d */
    public final AnnotationWriter2 m10566d(String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.m10538j(this.f26165b.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26165b, true, byteVector2, this.f26182s);
            this.f26182s = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26165b, true, byteVector2, this.f26183t);
        this.f26183t = annotationWriter22;
        return annotationWriter22;
    }

    /* renamed from: e */
    public final MethodVisitor2 m10567e(int i, String str, String str2, String str3, String[] strArr) {
        MethodWriter2 methodWriter2 = new MethodWriter2(this.f26165b, i, str, str2, str3, strArr, this.f26163B);
        if (this.f26173j == null) {
            this.f26173j = methodWriter2;
        } else {
            this.f26174k.f26263b = methodWriter2;
        }
        this.f26174k = methodWriter2;
        return methodWriter2;
    }

    /* renamed from: f */
    public final AnnotationWriter2 m10568f(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        C3404f.m4256W0(i, byteVector2);
        TypePath2.m10655a(typePath2, byteVector2);
        byteVector2.m10538j(this.f26165b.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26165b, true, byteVector2, this.f26184u);
            this.f26184u = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26165b, true, byteVector2, this.f26185v);
        this.f26185v = annotationWriter22;
        return annotationWriter22;
    }
}
