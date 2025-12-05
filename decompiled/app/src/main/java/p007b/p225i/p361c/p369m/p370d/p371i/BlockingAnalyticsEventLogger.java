package p007b.p225i.p361c.p369m.p370d.p371i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p361c.p369m.p370d.Logger3;

/* compiled from: BlockingAnalyticsEventLogger.java */
/* renamed from: b.i.c.m.d.i.c, reason: use source file name */
/* loaded from: classes3.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {

    /* renamed from: a */
    public final CrashlyticsOriginAnalyticsEventLogger f12247a;

    /* renamed from: b */
    public final Object f12248b = new Object();

    /* renamed from: c */
    public CountDownLatch f12249c;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit) {
        this.f12247a = crashlyticsOriginAnalyticsEventLogger;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventLogger
    /* renamed from: a */
    public void mo6386a(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.f12248b) {
            Logger3 logger3 = Logger3.f12227a;
            logger3.m6371b("Logging Crashlytics event to Firebase");
            this.f12249c = new CountDownLatch(1);
            this.f12247a.f12251a.mo6338a("clx", str, bundle);
            logger3.m6371b("Awaiting app exception callback from FA...");
            try {
                if (this.f12249c.await(500, TimeUnit.MILLISECONDS)) {
                    logger3.m6371b("App exception callback received from FA listener.");
                } else {
                    logger3.m6371b("Timeout exceeded while awaiting app exception callback from FA listener.");
                }
            } catch (InterruptedException unused) {
                Logger3.f12227a.m6371b("Interrupted while awaiting app exception callback from FA listener.");
            }
            this.f12249c = null;
        }
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventReceiver
    /* renamed from: b */
    public void mo6387b(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.f12249c;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
