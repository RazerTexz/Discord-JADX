package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.p374l.LogFileManager;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.n */
/* loaded from: classes3.dex */
public class CallableC4643n implements Callable<Void> {

    /* renamed from: j */
    public final /* synthetic */ long f12350j;

    /* renamed from: k */
    public final /* synthetic */ String f12351k;

    /* renamed from: l */
    public final /* synthetic */ C4663x f12352l;

    public CallableC4643n(C4663x c4663x, long j, String str) {
        this.f12352l = c4663x;
        this.f12350j = j;
        this.f12351k = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        if (this.f12352l.m6479p()) {
            return null;
        }
        LogFileManager logFileManager = this.f12352l.f12440t;
        logFileManager.f12473d.mo6495e(this.f12350j, this.f12351k);
        return null;
    }
}
