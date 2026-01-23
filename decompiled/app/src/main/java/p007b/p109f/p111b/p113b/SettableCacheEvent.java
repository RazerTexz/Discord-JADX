package p007b.p109f.p111b.p113b;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: renamed from: b.f.b.b.i, reason: use source file name */
/* JADX INFO: compiled from: SettableCacheEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class SettableCacheEvent {

    /* JADX INFO: renamed from: a */
    public static final Object f3072a = new Object();

    /* JADX INFO: renamed from: b */
    public static SettableCacheEvent f3073b;

    /* JADX INFO: renamed from: c */
    public static int f3074c;

    /* JADX INFO: renamed from: d */
    public CacheKey f3075d;

    /* JADX INFO: renamed from: e */
    public SettableCacheEvent f3076e;

    /* JADX INFO: renamed from: a */
    public static SettableCacheEvent m961a() {
        synchronized (f3072a) {
            SettableCacheEvent settableCacheEvent = f3073b;
            if (settableCacheEvent == null) {
                return new SettableCacheEvent();
            }
            f3073b = settableCacheEvent.f3076e;
            settableCacheEvent.f3076e = null;
            f3074c--;
            return settableCacheEvent;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m962b() {
        synchronized (f3072a) {
            int i = f3074c;
            if (i < 5) {
                f3074c = i + 1;
                SettableCacheEvent settableCacheEvent = f3073b;
                if (settableCacheEvent != null) {
                    this.f3076e = settableCacheEvent;
                }
                f3073b = this;
            }
        }
    }
}
