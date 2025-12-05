package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p361c.p369m.p370d.Logger3;

/* compiled from: ExecutorUtils.java */
/* renamed from: b.i.c.m.d.k.t0, reason: use source file name */
/* loaded from: classes3.dex */
public class ExecutorUtils2 extends BackgroundPriorityRunnable {

    /* renamed from: j */
    public final /* synthetic */ String f12391j;

    /* renamed from: k */
    public final /* synthetic */ ExecutorService f12392k;

    /* renamed from: l */
    public final /* synthetic */ long f12393l;

    /* renamed from: m */
    public final /* synthetic */ TimeUnit f12394m;

    public ExecutorUtils2(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.f12391j = str;
        this.f12392k = executorService;
        this.f12393l = j;
        this.f12394m = timeUnit;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.BackgroundPriorityRunnable
    /* renamed from: a */
    public void mo6398a() {
        try {
            Logger3 logger3 = Logger3.f12227a;
            logger3.m6371b("Executing shutdown hook for " + this.f12391j);
            this.f12392k.shutdown();
            if (this.f12392k.awaitTermination(this.f12393l, this.f12394m)) {
                return;
            }
            logger3.m6371b(this.f12391j + " did not shut down in the allocated time. Requesting immediate shutdown.");
            this.f12392k.shutdownNow();
        } catch (InterruptedException unused) {
            Logger3.f12227a.m6371b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f12391j));
            this.f12392k.shutdownNow();
        }
    }
}
