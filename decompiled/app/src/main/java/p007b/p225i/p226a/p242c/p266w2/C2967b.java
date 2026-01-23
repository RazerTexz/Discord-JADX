package p007b.p225i.p226a.p242c.p266w2;

import p007b.p225i.p226a.p242c.p259f3.Consumer3;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* JADX INFO: renamed from: b.i.a.c.w2.b */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2967b implements Consumer3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Exception f7971a;

    public /* synthetic */ C2967b(Exception exc) {
        this.f7971a = exc;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.Consumer3
    public final void accept(Object obj) {
        ((DrmSessionEventListener.a) obj).m3591e(this.f7971a);
    }
}
