package com.discord.stores;

import com.discord.stores.StoreStream;
import java.util.concurrent.ThreadFactory;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final class StoreStream$storeThreadScheduler$1 implements ThreadFactory {
    public static final StoreStream$storeThreadScheduler$1 INSTANCE = new StoreStream$storeThreadScheduler$1();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Thread thread = new Thread(runnable, companion.getSTORE_THREAD_NAME());
        thread.setPriority((int) 8.0d);
        companion.setSTORE_THREAD_ID(thread.getId());
        return thread;
    }
}
