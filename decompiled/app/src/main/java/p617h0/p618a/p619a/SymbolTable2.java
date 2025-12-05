package p617h0.p618a.p619a;

import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: SymbolTable.java */
/* renamed from: h0.a.a.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class SymbolTable2 {

    /* renamed from: a */
    public final ClassWriter2 f26347a;

    /* renamed from: c */
    public int f26349c;

    /* renamed from: d */
    public String f26350d;

    /* renamed from: e */
    public int f26351e;

    /* renamed from: i */
    public int f26355i;

    /* renamed from: j */
    public ByteVector2 f26356j;

    /* renamed from: k */
    public int f26357k;

    /* renamed from: l */
    public a[] f26358l;

    /* renamed from: b */
    public final ClassReader2 f26348b = null;

    /* renamed from: f */
    public a[] f26352f = new a[256];

    /* renamed from: g */
    public int f26353g = 1;

    /* renamed from: h */
    public ByteVector2 f26354h = new ByteVector2();

    public SymbolTable2(ClassWriter2 classWriter2) {
        this.f26347a = classWriter2;
    }

    /* renamed from: r */
    public static int m10622r(int i, int i2) {
        return (i + i2) & Integer.MAX_VALUE;
    }

    /* renamed from: s */
    public static int m10623s(int i, String str, String str2, int i2) {
        return Integer.MAX_VALUE & (((i2 + 1) * str2.hashCode() * str.hashCode()) + i);
    }

    /* renamed from: t */
    public static int m10624t(int i, String str, String str2, String str3) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i);
    }

    /* renamed from: u */
    public static int m10625u(int i, String str, String str2, String str3, int i2) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode() * i2) + i);
    }

    /* renamed from: a */
    public Symbol2 m10626a(Handle2 handle2, Object... objArr) {
        boolean z2;
        ByteVector2 byteVector2 = this.f26356j;
        if (byteVector2 == null) {
            byteVector2 = new ByteVector2();
            this.f26356j = byteVector2;
        }
        for (Object obj : objArr) {
            m10627b(obj);
        }
        int i = byteVector2.f26154b;
        byteVector2.m10538j(m10634i(handle2.f26237a, handle2.f26238b, handle2.f26239c, handle2.f26240d, handle2.f26241e).f26340a);
        byteVector2.m10538j(objArr.length);
        for (Object obj2 : objArr) {
            byteVector2.m10538j(m10627b(obj2).f26340a);
        }
        int i2 = byteVector2.f26154b - i;
        int iHashCode = handle2.hashCode();
        for (Object obj3 : objArr) {
            iHashCode ^= obj3.hashCode();
        }
        int i3 = iHashCode & Integer.MAX_VALUE;
        byte[] bArr = this.f26356j.f26153a;
        a[] aVarArr = this.f26352f;
        for (a aVar = aVarArr[i3 % aVarArr.length]; aVar != null; aVar = aVar.f26360i) {
            if (aVar.f26341b == 64 && aVar.f26359h == i3) {
                int i4 = (int) aVar.f26345f;
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        z2 = true;
                        break;
                    }
                    if (bArr[i + i5] != bArr[i4 + i5]) {
                        z2 = false;
                        break;
                    }
                    i5++;
                }
                if (z2) {
                    this.f26356j.f26154b = i;
                    return aVar;
                }
            }
        }
        int i6 = this.f26355i;
        this.f26355i = i6 + 1;
        a aVar2 = new a(i6, 64, i, i3);
        m10643v(aVar2);
        return aVar2;
    }

    /* renamed from: b */
    public Symbol2 m10627b(Object obj) {
        if (obj instanceof Integer) {
            return m10630e(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return m10630e(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return m10630e(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return m10630e(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return m10630e(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return m10631f(4, Float.floatToRawIntBits(((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return m10632g(5, ((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return m10632g(6, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
        }
        if (obj instanceof String) {
            return m10638m(8, (String) obj);
        }
        if (obj instanceof Type2) {
            Type2 type2 = (Type2) obj;
            int iM10654i = type2.m10654i();
            return iM10654i == 10 ? m10628c(type2.m10653g()) : iM10654i == 11 ? m10638m(16, type2.m10651d()) : m10628c(type2.m10651d());
        }
        if (obj instanceof Handle2) {
            Handle2 handle2 = (Handle2) obj;
            return m10634i(handle2.f26237a, handle2.f26238b, handle2.f26239c, handle2.f26240d, handle2.f26241e);
        }
        if (!(obj instanceof ConstantDynamic2)) {
            throw new IllegalArgumentException(outline.m881v("value ", obj));
        }
        ConstantDynamic2 constantDynamic2 = (ConstantDynamic2) obj;
        return m10629d(17, constantDynamic2.f26190a, constantDynamic2.f26191b, m10626a(constantDynamic2.f26192c, constantDynamic2.f26193d).f26340a);
    }

    /* renamed from: c */
    public Symbol2 m10628c(String str) {
        return m10638m(7, str);
    }

    /* renamed from: d */
    public final Symbol2 m10629d(int i, String str, String str2, int i2) {
        int iM10623s = m10623s(i, str, str2, i2);
        for (a aVarM10642q = m10642q(iM10623s); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iM10623s && aVarM10642q.f26345f == i2 && aVarM10642q.f26343d.equals(str) && aVarM10642q.f26344e.equals(str2)) {
                return aVarM10642q;
            }
        }
        this.f26354h.m10534f(i, i2, m10636k(str, str2));
        int i3 = this.f26353g;
        this.f26353g = i3 + 1;
        a aVar = new a(i3, i, null, str, str2, i2, iM10623s);
        m10643v(aVar);
        return aVar;
    }

    /* renamed from: e */
    public Symbol2 m10630e(int i) {
        return m10631f(3, i);
    }

    /* renamed from: f */
    public final Symbol2 m10631f(int i, int i2) {
        int iM10622r = m10622r(i, i2);
        for (a aVarM10642q = m10642q(iM10622r); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iM10622r && aVarM10642q.f26345f == i2) {
                return aVarM10642q;
            }
        }
        ByteVector2 byteVector2 = this.f26354h;
        byteVector2.m10535g(i);
        byteVector2.m10537i(i2);
        int i3 = this.f26353g;
        this.f26353g = i3 + 1;
        a aVar = new a(i3, i, i2, iM10622r);
        m10643v(aVar);
        return aVar;
    }

    /* renamed from: g */
    public final Symbol2 m10632g(int i, long j) {
        int i2 = (int) j;
        int i3 = (int) (j >>> 32);
        int i4 = (i + i2 + i3) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(i4); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == i4 && aVarM10642q.f26345f == j) {
                return aVarM10642q;
            }
        }
        int i5 = this.f26353g;
        ByteVector2 byteVector2 = this.f26354h;
        byteVector2.m10535g(i);
        int i6 = byteVector2.f26154b;
        if (i6 + 8 > byteVector2.f26153a.length) {
            byteVector2.m10530b(8);
        }
        byte[] bArr = byteVector2.f26153a;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i3 >>> 24);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (i3 >>> 16);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i3 >>> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) i3;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i2 >>> 24);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i2 >>> 16);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i2 >>> 8);
        bArr[i13] = (byte) i2;
        byteVector2.f26154b = i13 + 1;
        this.f26353g += 2;
        a aVar = new a(i5, i, j, i4);
        m10643v(aVar);
        return aVar;
    }

    /* renamed from: h */
    public final a m10633h(int i, String str, String str2, String str3) {
        int iM10624t = m10624t(i, str, str2, str3);
        for (a aVarM10642q = m10642q(iM10624t); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iM10624t && aVarM10642q.f26342c.equals(str) && aVarM10642q.f26343d.equals(str2) && aVarM10642q.f26344e.equals(str3)) {
                return aVarM10642q;
            }
        }
        this.f26354h.m10534f(i, m10638m(7, str).f26340a, m10636k(str2, str3));
        int i2 = this.f26353g;
        this.f26353g = i2 + 1;
        a aVar = new a(i2, i, str, str2, str3, 0L, iM10624t);
        m10643v(aVar);
        return aVar;
    }

    /* renamed from: i */
    public Symbol2 m10634i(int i, String str, String str2, String str3, boolean z2) {
        int iM10625u = m10625u(15, str, str2, str3, i);
        for (a aVarM10642q = m10642q(iM10625u); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 15 && aVarM10642q.f26359h == iM10625u && aVarM10642q.f26345f == i && aVarM10642q.f26342c.equals(str) && aVarM10642q.f26343d.equals(str2) && aVarM10642q.f26344e.equals(str3)) {
                return aVarM10642q;
            }
        }
        if (i <= 4) {
            this.f26354h.m10532d(15, i, m10633h(9, str, str2, str3).f26340a);
        } else {
            this.f26354h.m10532d(15, i, m10633h(z2 ? 11 : 10, str, str2, str3).f26340a);
        }
        int i2 = this.f26353g;
        this.f26353g = i2 + 1;
        a aVar = new a(i2, 15, str, str2, str3, i, iM10625u);
        m10643v(aVar);
        return aVar;
    }

    /* renamed from: j */
    public Symbol2 m10635j(String str) {
        return m10638m(19, str);
    }

    /* renamed from: k */
    public int m10636k(String str, String str2) {
        int iHashCode = ((str2.hashCode() * str.hashCode()) + 12) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 12 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26343d.equals(str) && aVarM10642q.f26344e.equals(str2)) {
                return aVarM10642q.f26340a;
            }
        }
        this.f26354h.m10534f(12, m10637l(str), m10637l(str2));
        int i = this.f26353g;
        this.f26353g = i + 1;
        m10643v(new a(i, 12, str, str2, iHashCode));
        return i;
    }

    /* renamed from: l */
    public int m10637l(String str) {
        int iHashCode = (str.hashCode() + 1) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 1 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q.f26340a;
            }
        }
        ByteVector2 byteVector2 = this.f26354h;
        byteVector2.m10535g(1);
        int length = str.length();
        if (length > 65535) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i = byteVector2.f26154b;
        if (i + 2 + length > byteVector2.f26153a.length) {
            byteVector2.m10530b(length + 2);
        }
        byte[] bArr = byteVector2.f26153a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i2 + 1;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 1 || cCharAt > 127) {
                byteVector2.f26154b = i3;
                byteVector2.m10529a(str, i4, 65535);
                break;
            }
            bArr[i3] = (byte) cCharAt;
            i4++;
            i3++;
        }
        byteVector2.f26154b = i3;
        int i5 = this.f26353g;
        this.f26353g = i5 + 1;
        m10643v(new a(i5, 1, str, iHashCode));
        return i5;
    }

    /* renamed from: m */
    public final Symbol2 m10638m(int i, String str) {
        int iHashCode = (str.hashCode() + i) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q;
            }
        }
        this.f26354h.m10533e(i, m10637l(str));
        int i2 = this.f26353g;
        this.f26353g = i2 + 1;
        a aVar = new a(i2, i, str, iHashCode);
        m10643v(aVar);
        return aVar;
    }

    /* renamed from: n */
    public int m10639n(String str) {
        int iHashCode = (str.hashCode() + 128) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 128 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q.f26340a;
            }
        }
        return m10640o(new a(this.f26357k, 128, str, iHashCode));
    }

    /* renamed from: o */
    public final int m10640o(a aVar) {
        if (this.f26358l == null) {
            this.f26358l = new a[16];
        }
        int i = this.f26357k;
        a[] aVarArr = this.f26358l;
        if (i == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.f26358l = aVarArr2;
        }
        a[] aVarArr3 = this.f26358l;
        int i2 = this.f26357k;
        this.f26357k = i2 + 1;
        aVarArr3[i2] = aVar;
        m10643v(aVar);
        return aVar.f26340a;
    }

    /* renamed from: p */
    public int m10641p(String str, int i) {
        int iHashCode = (str.hashCode() + Opcodes.LOR + i) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 129 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26345f == i && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q.f26340a;
            }
        }
        return m10640o(new a(this.f26357k, Opcodes.LOR, str, i, iHashCode));
    }

    /* renamed from: q */
    public final a m10642q(int i) {
        a[] aVarArr = this.f26352f;
        return aVarArr[i % aVarArr.length];
    }

    /* renamed from: v */
    public final a m10643v(a aVar) {
        int i = this.f26351e;
        a[] aVarArr = this.f26352f;
        if (i > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i2 = (length * 2) + 1;
            a[] aVarArr2 = new a[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                a aVar2 = this.f26352f[i3];
                while (aVar2 != null) {
                    int i4 = aVar2.f26359h % i2;
                    a aVar3 = aVar2.f26360i;
                    aVar2.f26360i = aVarArr2[i4];
                    aVarArr2[i4] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f26352f = aVarArr2;
        }
        this.f26351e++;
        int i5 = aVar.f26359h;
        a[] aVarArr3 = this.f26352f;
        int length2 = i5 % aVarArr3.length;
        aVar.f26360i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    /* compiled from: SymbolTable.java */
    /* renamed from: h0.a.a.v$a */
    public static class a extends Symbol2 {

        /* renamed from: h */
        public final int f26359h;

        /* renamed from: i */
        public a f26360i;

        public a(int i, int i2, String str, String str2, String str3, long j, int i3) {
            super(i, i2, str, str2, str3, j);
            this.f26359h = i3;
        }

        public a(int i, int i2, String str, int i3) {
            super(i, i2, null, null, str, 0L);
            this.f26359h = i3;
        }

        public a(int i, int i2, String str, long j, int i3) {
            super(i, i2, null, null, str, j);
            this.f26359h = i3;
        }

        public a(int i, int i2, String str, String str2, int i3) {
            super(i, i2, null, str, str2, 0L);
            this.f26359h = i3;
        }

        public a(int i, int i2, long j, int i3) {
            super(i, i2, null, null, null, j);
            this.f26359h = i3;
        }
    }
}
