package p659s.p660a;

import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: s.a.p0 */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13139p0 implements InterfaceC13169z0 {

    /* JADX INFO: renamed from: j */
    public final boolean f27881j;

    public C13139p0(boolean z2) {
        this.f27881j = z2;
    }

    @Override // p659s.p660a.InterfaceC13169z0
    /* JADX INFO: renamed from: a */
    public boolean mo11281a() {
        return this.f27881j;
    }

    @Override // p659s.p660a.InterfaceC13169z0
    public C13131m1 getList() {
        return null;
    }

    public String toString() {
        return outline.m820H(outline.m833U("Empty{"), this.f27881j ? "Active" : "New", '}');
    }
}
