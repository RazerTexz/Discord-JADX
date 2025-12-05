package p007b.p225i.p226a.p242c.p257e3;

import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: DefaultAllocator.java */
/* renamed from: b.i.a.c.e3.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultAllocator {

    /* renamed from: a */
    public final boolean f6562a;

    /* renamed from: b */
    public final int f6563b;

    /* renamed from: c */
    public final Allocation[] f6564c;

    /* renamed from: d */
    public int f6565d;

    /* renamed from: e */
    public int f6566e;

    /* renamed from: f */
    public int f6567f;

    /* renamed from: g */
    public Allocation[] f6568g;

    public DefaultAllocator(boolean z2, int i) {
        AnimatableValueParser.m531j(i > 0);
        AnimatableValueParser.m531j(true);
        this.f6562a = z2;
        this.f6563b = i;
        this.f6567f = 0;
        this.f6568g = new Allocation[100];
        this.f6564c = new Allocation[1];
    }

    /* renamed from: a */
    public synchronized void m2858a(Allocation[] allocationArr) {
        int i = this.f6567f;
        int length = allocationArr.length + i;
        Allocation[] allocationArr2 = this.f6568g;
        if (length >= allocationArr2.length) {
            this.f6568g = (Allocation[]) Arrays.copyOf(allocationArr2, Math.max(allocationArr2.length * 2, i + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            Allocation[] allocationArr3 = this.f6568g;
            int i2 = this.f6567f;
            this.f6567f = i2 + 1;
            allocationArr3[i2] = allocation;
        }
        this.f6566e -= allocationArr.length;
        notifyAll();
    }

    /* renamed from: b */
    public synchronized void m2859b(int i) {
        boolean z2 = i < this.f6565d;
        this.f6565d = i;
        if (z2) {
            m2860c();
        }
    }

    /* renamed from: c */
    public synchronized void m2860c() {
        int iMax = Math.max(0, Util2.m2998f(this.f6565d, this.f6563b) - this.f6566e);
        int i = this.f6567f;
        if (iMax >= i) {
            return;
        }
        Arrays.fill(this.f6568g, iMax, i, (Object) null);
        this.f6567f = iMax;
    }
}
