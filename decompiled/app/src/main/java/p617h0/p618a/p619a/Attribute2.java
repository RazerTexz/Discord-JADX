package p617h0.p618a.p619a;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: Attribute.java */
/* renamed from: h0.a.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Attribute2 {

    /* renamed from: a */
    public final String f26148a;

    /* renamed from: b */
    public byte[] f26149b;

    /* renamed from: c */
    public Attribute2 f26150c;

    /* compiled from: Attribute.java */
    /* renamed from: h0.a.a.b$a */
    public static final class a {

        /* renamed from: a */
        public int f26151a;

        /* renamed from: b */
        public Attribute2[] f26152b = new Attribute2[6];

        /* renamed from: a */
        public void m10528a(Attribute2 attribute2) {
            boolean z2;
            while (attribute2 != null) {
                int i = 0;
                while (true) {
                    if (i >= this.f26151a) {
                        z2 = false;
                        break;
                    } else {
                        if (this.f26152b[i].f26148a.equals(attribute2.f26148a)) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z2) {
                    int i2 = this.f26151a;
                    Attribute2[] attribute2Arr = this.f26152b;
                    if (i2 >= attribute2Arr.length) {
                        Attribute2[] attribute2Arr2 = new Attribute2[attribute2Arr.length + 6];
                        System.arraycopy(attribute2Arr, 0, attribute2Arr2, 0, i2);
                        this.f26152b = attribute2Arr2;
                    }
                    Attribute2[] attribute2Arr3 = this.f26152b;
                    int i3 = this.f26151a;
                    this.f26151a = i3 + 1;
                    attribute2Arr3[i3] = attribute2;
                }
                attribute2 = attribute2.f26150c;
            }
        }
    }

    public Attribute2(String str) {
        this.f26148a = str;
    }

    /* renamed from: a */
    public final int m10523a(SymbolTable2 symbolTable2) {
        return m10524b(symbolTable2, null, 0, -1, -1);
    }

    /* renamed from: b */
    public final int m10524b(SymbolTable2 symbolTable2, byte[] bArr, int i, int i2, int i3) {
        ClassWriter2 classWriter2 = symbolTable2.f26347a;
        int length = 0;
        for (Attribute2 attribute2 = this; attribute2 != null; attribute2 = attribute2.f26150c) {
            symbolTable2.m10637l(attribute2.f26148a);
            length += attribute2.f26149b.length + 6;
        }
        return length;
    }

    /* renamed from: c */
    public final int m10525c() {
        int i = 0;
        for (Attribute2 attribute2 = this; attribute2 != null; attribute2 = attribute2.f26150c) {
            i++;
        }
        return i;
    }

    /* renamed from: d */
    public final void m10526d(SymbolTable2 symbolTable2, ByteVector2 byteVector2) {
        m10527e(symbolTable2, null, 0, -1, -1, byteVector2);
    }

    /* renamed from: e */
    public final void m10527e(SymbolTable2 symbolTable2, byte[] bArr, int i, int i2, int i3, ByteVector2 byteVector2) {
        ClassWriter2 classWriter2 = symbolTable2.f26347a;
        for (Attribute2 attribute2 = this; attribute2 != null; attribute2 = attribute2.f26150c) {
            byte[] bArr2 = attribute2.f26149b;
            int length = bArr2.length;
            outline.m878t0(symbolTable2, attribute2.f26148a, byteVector2, length);
            byteVector2.m10536h(bArr2, 0, length);
        }
    }
}
