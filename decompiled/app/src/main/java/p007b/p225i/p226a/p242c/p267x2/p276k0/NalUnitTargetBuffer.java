package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: NalUnitTargetBuffer.java */
/* renamed from: b.i.a.c.x2.k0.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class NalUnitTargetBuffer {

    /* renamed from: a */
    public final int f8903a;

    /* renamed from: b */
    public boolean f8904b;

    /* renamed from: c */
    public boolean f8905c;

    /* renamed from: d */
    public byte[] f8906d;

    /* renamed from: e */
    public int f8907e;

    public NalUnitTargetBuffer(int i, int i2) {
        this.f8903a = i;
        byte[] bArr = new byte[i2 + 3];
        this.f8906d = bArr;
        bArr[2] = 1;
    }

    /* renamed from: a */
    public void m3788a(byte[] bArr, int i, int i2) {
        if (this.f8904b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f8906d;
            int length = bArr2.length;
            int i4 = this.f8907e;
            if (length < i4 + i3) {
                this.f8906d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f8906d, this.f8907e, i3);
            this.f8907e += i3;
        }
    }

    /* renamed from: b */
    public boolean m3789b(int i) {
        if (!this.f8904b) {
            return false;
        }
        this.f8907e -= i;
        this.f8904b = false;
        this.f8905c = true;
        return true;
    }

    /* renamed from: c */
    public void m3790c() {
        this.f8904b = false;
        this.f8905c = false;
    }

    /* renamed from: d */
    public void m3791d(int i) {
        AnimatableValueParser.m426D(!this.f8904b);
        boolean z2 = i == this.f8903a;
        this.f8904b = z2;
        if (z2) {
            this.f8907e = 3;
            this.f8905c = false;
        }
    }
}
