package p007b.p225i.p361c.p369m.p370d.p380q.p382d;

import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.CreateReportRequest;

/* compiled from: CompositeCreateReportSpiCall.java */
/* renamed from: b.i.c.m.d.q.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public class CompositeCreateReportSpiCall implements CreateReportSpiCall {

    /* renamed from: a */
    public final DefaultCreateReportSpiCall f12716a;

    /* renamed from: b */
    public final NativeCreateReportSpiCall f12717b;

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.f12716a = defaultCreateReportSpiCall;
        this.f12717b = nativeCreateReportSpiCall;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p382d.CreateReportSpiCall
    /* renamed from: a */
    public boolean mo6678a(CreateReportRequest createReportRequest, boolean z2) {
        int iM758h = C1563b.m758h(createReportRequest.f12711c.mo6675d());
        if (iM758h == 0) {
            this.f12716a.mo6678a(createReportRequest, z2);
            return true;
        }
        if (iM758h != 1) {
            return false;
        }
        this.f12717b.mo6678a(createReportRequest, z2);
        return true;
    }
}
