package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;
import p007b.p225i.p226a.p242c.p257e3.p258b0.CacheSpan;
import p007b.p225i.p226a.p242c.p257e3.p258b0.ContentMetadata2;
import p007b.p225i.p226a.p242c.p257e3.p258b0.ContentMetadataMutations;

/* loaded from: classes3.dex */
public interface Cache {

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.google.android.exoplayer2.upstream.cache.Cache$a */
    public interface InterfaceC10774a {
        /* renamed from: b */
        void mo2818b(Cache cache, CacheSpan cacheSpan);

        /* renamed from: c */
        void mo2819c(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);

        /* renamed from: d */
        void mo2820d(Cache cache, CacheSpan cacheSpan);
    }

    @WorkerThread
    /* renamed from: a */
    File mo2826a(String str, long j, long j2) throws CacheException;

    /* renamed from: b */
    ContentMetadata2 mo2827b(String str);

    @WorkerThread
    /* renamed from: c */
    void mo2828c(String str, ContentMetadataMutations contentMetadataMutations) throws CacheException;

    @WorkerThread
    /* renamed from: d */
    void mo2829d(CacheSpan cacheSpan);

    @Nullable
    @WorkerThread
    /* renamed from: e */
    CacheSpan mo2830e(String str, long j, long j2) throws CacheException;

    @WorkerThread
    /* renamed from: f */
    CacheSpan mo2831f(String str, long j, long j2) throws InterruptedException, CacheException;

    @WorkerThread
    /* renamed from: g */
    void mo2832g(File file, long j) throws CacheException;

    /* renamed from: h */
    long mo2833h();

    /* renamed from: i */
    void mo2834i(CacheSpan cacheSpan);
}
