package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.k, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader5 implements SynchronizationGuard.a {

    /* renamed from: a */
    public final Uploader6 f5382a;

    /* renamed from: b */
    public final TransportContext f5383b;

    /* renamed from: c */
    public final int f5384c;

    public Uploader5(Uploader6 uploader6, TransportContext transportContext, int i) {
        this.f5382a = uploader6;
        this.f5383b = transportContext;
        this.f5384c = i;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard.a
    public Object execute() {
        Uploader6 uploader6 = this.f5382a;
        uploader6.f5388d.mo2382a(this.f5383b, this.f5384c + 1);
        return null;
    }
}
