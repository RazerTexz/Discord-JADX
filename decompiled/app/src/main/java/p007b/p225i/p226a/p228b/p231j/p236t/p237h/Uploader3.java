package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendResponse;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.PersistedEvent;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.i, reason: use source file name */
/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Uploader3 implements SynchronizationGuard.a {

    /* JADX INFO: renamed from: a */
    public final Uploader6 f5376a;

    /* JADX INFO: renamed from: b */
    public final BackendResponse f5377b;

    /* JADX INFO: renamed from: c */
    public final Iterable f5378c;

    /* JADX INFO: renamed from: d */
    public final TransportContext f5379d;

    /* JADX INFO: renamed from: e */
    public final int f5380e;

    public Uploader3(Uploader6 uploader6, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        this.f5376a = uploader6;
        this.f5377b = backendResponse;
        this.f5378c = iterable;
        this.f5379d = transportContext;
        this.f5380e = i;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard.a
    public Object execute() {
        Uploader6 uploader6 = this.f5376a;
        BackendResponse backendResponse = this.f5377b;
        Iterable<PersistedEvent> iterable = this.f5378c;
        TransportContext transportContext = this.f5379d;
        int i = this.f5380e;
        if (backendResponse.mo2365c() == BackendResponse.a.TRANSIENT_ERROR) {
            uploader6.f5387c.mo2399n0(iterable);
            uploader6.f5388d.mo2382a(transportContext, i + 1);
            return null;
        }
        uploader6.f5387c.mo2398m(iterable);
        if (backendResponse.mo2365c() == BackendResponse.a.OK) {
            uploader6.f5387c.mo2401v(transportContext, backendResponse.mo2364b() + uploader6.f5391g.mo2413a());
        }
        if (!uploader6.f5387c.mo2397l0(transportContext)) {
            return null;
        }
        uploader6.f5388d.mo2382a(transportContext, 1);
        return null;
    }
}
