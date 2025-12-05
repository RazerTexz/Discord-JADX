package p007b.p225i.p226a.p242c.p259f3;

import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
/* renamed from: b.i.a.c.f3.d */
/* loaded from: classes3.dex */
public final /* synthetic */ class ThreadFactoryC2735d implements ThreadFactory {

    /* renamed from: j */
    public final /* synthetic */ String f6699j;

    public /* synthetic */ ThreadFactoryC2735d(String str) {
        this.f6699j = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f6699j);
    }
}
