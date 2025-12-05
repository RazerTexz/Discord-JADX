package p007b.p225i.p226a.p288f.p313h.p327n;

import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* renamed from: b.i.a.f.h.n.j */
/* loaded from: classes3.dex */
public final class C3950j extends AbstractC3951k {

    /* renamed from: l */
    public final transient int f10487l;

    /* renamed from: m */
    public final transient int f10488m;
    public final /* synthetic */ AbstractC3951k zzc;

    public C3950j(AbstractC3951k abstractC3951k, int i, int i2) {
        this.zzc = abstractC3951k;
        this.f10487l = i;
        this.f10488m = i2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* renamed from: d */
    public final int mo5431d() {
        return this.zzc.mo5432e() + this.f10487l + this.f10488m;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* renamed from: e */
    public final int mo5432e() {
        return this.zzc.mo5432e() + this.f10487l;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* renamed from: g */
    public final Object[] mo5433g() {
        return this.zzc.mo5433g();
    }

    @Override // java.util.List
    public final Object get(int i) {
        C3404f.m4206F1(i, this.f10488m, "index");
        return this.zzc.get(i + this.f10487l);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3951k
    /* renamed from: h */
    public final AbstractC3951k mo5434h(int i, int i2) {
        C3404f.m4342s2(i, i2, this.f10488m);
        AbstractC3951k abstractC3951k = this.zzc;
        int i3 = this.f10487l;
        return abstractC3951k.mo5434h(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10488m;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3951k, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return mo5434h(i, i2);
    }
}
