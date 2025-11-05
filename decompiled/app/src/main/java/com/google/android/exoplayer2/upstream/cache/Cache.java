package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.c.e3.b0.h;
import b.i.a.c.e3.b0.l;
import b.i.a.c.e3.b0.m;
import java.io.File;
import java.io.IOException;

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

    public interface a {
        void b(Cache cache, h hVar);

        void c(Cache cache, h hVar, h hVar2);

        void d(Cache cache, h hVar);
    }

    @WorkerThread
    File a(String str, long j, long j2) throws CacheException;

    l b(String str);

    @WorkerThread
    void c(String str, m mVar) throws CacheException;

    @WorkerThread
    void d(h hVar);

    @Nullable
    @WorkerThread
    h e(String str, long j, long j2) throws CacheException;

    @WorkerThread
    h f(String str, long j, long j2) throws InterruptedException, CacheException;

    @WorkerThread
    void g(File file, long j) throws CacheException;

    long h();

    void i(h hVar);
}
