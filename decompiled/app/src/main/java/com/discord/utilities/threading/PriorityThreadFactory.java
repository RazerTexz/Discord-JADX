package com.discord.utilities.threading;

import java.util.concurrent.ThreadFactory;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PriorityThreadFactory.kt */
/* loaded from: classes2.dex */
public final class PriorityThreadFactory implements ThreadFactory {
    private final int threadPriority;

    public PriorityThreadFactory(int i) {
        this.threadPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Intrinsics3.checkNotNullParameter(runnable, "runnable");
        Thread thread = new Thread(runnable);
        thread.setPriority(this.threadPriority);
        return thread;
    }
}
