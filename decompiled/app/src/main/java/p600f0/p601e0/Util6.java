package p600f0.p601e0;

import java.util.concurrent.ThreadFactory;

/* compiled from: Util.kt */
/* renamed from: f0.e0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Util6 implements ThreadFactory {

    /* renamed from: j */
    public final /* synthetic */ String f25395j;

    /* renamed from: k */
    public final /* synthetic */ boolean f25396k;

    public Util6(String str, boolean z2) {
        this.f25395j = str;
        this.f25396k = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f25395j);
        thread.setDaemon(this.f25396k);
        return thread;
    }
}
