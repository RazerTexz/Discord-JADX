package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* renamed from: b.i.a.f.h.l.o */
/* loaded from: classes3.dex */
public final class ThreadFactoryC3768o implements ThreadFactory {

    /* renamed from: j */
    public ThreadFactory f10122j = Executors.defaultThreadFactory();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f10122j.newThread(runnable);
        threadNewThread.setName("ScionFrontendApi");
        return threadNewThread;
    }
}
