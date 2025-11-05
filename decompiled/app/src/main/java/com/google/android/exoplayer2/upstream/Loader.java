package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import b.i.a.c.a3.e0;
import b.i.a.c.a3.h0;
import b.i.a.c.a3.m;
import b.i.a.c.f3.q;
import b.i.a.c.x2.h;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class Loader {
    public static final c a = new c(2, -9223372036854775807L, null);

    /* renamed from: b, reason: collision with root package name */
    public static final c f2978b = new c(3, -9223372036854775807L, null);
    public final ExecutorService c;

    @Nullable
    public d<? extends e> d;

    @Nullable
    public IOException e;

    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnexpectedLoaderException(Throwable th) {
            String simpleName = th.getClass().getSimpleName();
            String message = th.getMessage();
            super(b.d.b.a.a.l(b.d.b.a.a.b(message, simpleName.length() + 13), "Unexpected ", simpleName, ": ", message), th);
        }
    }

    public interface b<T extends e> {
        void b(T t, long j, long j2, boolean z2);

        void d(T t, long j, long j2);

        c o(T t, long j, long j2, IOException iOException, int i);
    }

    public static final class c {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final long f2979b;

        public c(int i, long j, a aVar) {
            this.a = i;
            this.f2979b = j;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final class d<T extends e> extends Handler implements Runnable {
        public final int j;
        public final T k;
        public final long l;

        @Nullable
        public b<T> m;

        @Nullable
        public IOException n;
        public int o;

        @Nullable
        public Thread p;
        public boolean q;
        public volatile boolean r;

        public d(Looper looper, T t, b<T> bVar, int i, long j) {
            super(looper);
            this.k = t;
            this.m = bVar;
            this.j = i;
            this.l = j;
        }

        public void a(boolean z2) {
            this.r = z2;
            this.n = null;
            if (hasMessages(0)) {
                this.q = true;
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.q = true;
                    ((e0.a) this.k).h = true;
                    Thread thread = this.p;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z2) {
                Loader.this.d = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                b<T> bVar = this.m;
                Objects.requireNonNull(bVar);
                bVar.b(this.k, jElapsedRealtime, jElapsedRealtime - this.l, true);
                this.m = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(long j) {
            b.c.a.a0.d.D(Loader.this.d == null);
            Loader loader = Loader.this;
            loader.d = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                this.n = null;
                loader.c.execute(this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.r) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                this.n = null;
                Loader loader = Loader.this;
                ExecutorService executorService = loader.c;
                d<? extends e> dVar = loader.d;
                Objects.requireNonNull(dVar);
                executorService.execute(dVar);
                return;
            }
            if (i == 3) {
                throw ((Error) message.obj);
            }
            Loader.this.d = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.l;
            b<T> bVar = this.m;
            Objects.requireNonNull(bVar);
            if (this.q) {
                bVar.b(this.k, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    bVar.d(this.k, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    q.b("LoadTask", "Unexpected exception handling load completed", e);
                    Loader.this.e = new UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.n = iOException;
            int i3 = this.o + 1;
            this.o = i3;
            c cVarO = bVar.o(this.k, jElapsedRealtime, j, iOException, i3);
            int i4 = cVarO.a;
            if (i4 == 3) {
                Loader.this.e = this.n;
            } else if (i4 != 2) {
                if (i4 == 1) {
                    this.o = 1;
                }
                long jMin = cVarO.f2979b;
                if (jMin == -9223372036854775807L) {
                    jMin = Math.min((this.o - 1) * 1000, 5000);
                }
                b(jMin);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            try {
                synchronized (this) {
                    z2 = !this.q;
                    this.p = Thread.currentThread();
                }
                if (z2) {
                    String simpleName = this.k.getClass().getSimpleName();
                    b.c.a.a0.d.f(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                    try {
                        ((e0.a) this.k).b();
                        b.c.a.a0.d.d0();
                    } catch (Throwable th) {
                        b.c.a.a0.d.d0();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.p = null;
                    Thread.interrupted();
                }
                if (this.r) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.r) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (OutOfMemoryError e2) {
                if (this.r) {
                    return;
                }
                q.b("LoadTask", "OutOfMemory error loading stream", e2);
                obtainMessage(2, new UnexpectedLoaderException(e2)).sendToTarget();
            } catch (Error e3) {
                if (!this.r) {
                    q.b("LoadTask", "Unexpected error loading stream", e3);
                    obtainMessage(3, e3).sendToTarget();
                }
                throw e3;
            } catch (Exception e4) {
                if (this.r) {
                    return;
                }
                q.b("LoadTask", "Unexpected exception loading stream", e4);
                obtainMessage(2, new UnexpectedLoaderException(e4)).sendToTarget();
            }
        }
    }

    public interface e {
    }

    public interface f {
    }

    public static final class g implements Runnable {
        public final f j;

        public g(f fVar) {
            this.j = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 e0Var = (e0) this.j;
            for (h0 h0Var : e0Var.D) {
                h0Var.s(true);
                DrmSession drmSession = h0Var.i;
                if (drmSession != null) {
                    drmSession.b(h0Var.e);
                    h0Var.i = null;
                    h0Var.h = null;
                }
            }
            m mVar = (m) e0Var.w;
            h hVar = mVar.f828b;
            if (hVar != null) {
                hVar.release();
                mVar.f828b = null;
            }
            mVar.c = null;
        }
    }

    public Loader(String str) {
        String strConcat = str.length() != 0 ? "ExoPlayer:Loader:".concat(str) : new String("ExoPlayer:Loader:");
        int i = b.i.a.c.f3.e0.a;
        this.c = Executors.newSingleThreadExecutor(new b.i.a.c.f3.d(strConcat));
    }

    public static c a(boolean z2, long j) {
        return new c(z2 ? 1 : 0, j, null);
    }

    public boolean b() {
        return this.d != null;
    }
}
