package p007b.p225i.p226a.p242c;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.concurrent.TimeoutException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p259f3.SystemHandlerWrapper;

/* compiled from: PlayerMessage.java */
/* renamed from: b.i.a.c.b2, reason: use source file name */
/* loaded from: classes3.dex */
public final class PlayerMessage {

    /* renamed from: a */
    public final b f5742a;

    /* renamed from: b */
    public final a f5743b;

    /* renamed from: c */
    public final Clock4 f5744c;

    /* renamed from: d */
    public final Timeline f5745d;

    /* renamed from: e */
    public int f5746e;

    /* renamed from: f */
    @Nullable
    public Object f5747f;

    /* renamed from: g */
    public Looper f5748g;

    /* renamed from: h */
    public int f5749h;

    /* renamed from: i */
    public boolean f5750i;

    /* renamed from: j */
    public boolean f5751j;

    /* renamed from: k */
    public boolean f5752k;

    /* compiled from: PlayerMessage.java */
    /* renamed from: b.i.a.c.b2$a */
    public interface a {
    }

    /* compiled from: PlayerMessage.java */
    /* renamed from: b.i.a.c.b2$b */
    public interface b {
        /* renamed from: r */
        void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(a aVar, b bVar, Timeline timeline, int i, Clock4 clock4, Looper looper) {
        this.f5743b = aVar;
        this.f5742a = bVar;
        this.f5745d = timeline;
        this.f5748g = looper;
        this.f5744c = clock4;
        this.f5749h = i;
    }

    /* renamed from: a */
    public synchronized boolean m2597a(long j) throws InterruptedException, TimeoutException {
        boolean z2;
        AnimatableValueParser.m426D(this.f5750i);
        AnimatableValueParser.m426D(this.f5748g.getThread() != Thread.currentThread());
        long jMo2952d = this.f5744c.mo2952d() + j;
        while (true) {
            z2 = this.f5752k;
            if (z2 || j <= 0) {
                break;
            }
            this.f5744c.mo2951c();
            wait(j);
            j = jMo2952d - this.f5744c.mo2952d();
        }
        if (!z2) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.f5751j;
    }

    /* renamed from: b */
    public synchronized boolean m2598b() {
        return false;
    }

    /* renamed from: c */
    public synchronized void m2599c(boolean z2) {
        this.f5751j = z2 | this.f5751j;
        this.f5752k = true;
        notifyAll();
    }

    /* renamed from: d */
    public PlayerMessage m2600d() {
        AnimatableValueParser.m426D(!this.f5750i);
        AnimatableValueParser.m531j(true);
        this.f5750i = true;
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = (ExoPlayerImplInternal2) this.f5743b;
        synchronized (exoPlayerImplInternal2) {
            if (exoPlayerImplInternal2.f7060I || !exoPlayerImplInternal2.f7084r.isAlive()) {
                Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
                m2599c(false);
            } else {
                ((SystemHandlerWrapper.b) exoPlayerImplInternal2.f7083q.mo2962i(14, this)).m2965b();
            }
        }
        return this;
    }

    /* renamed from: e */
    public PlayerMessage m2601e(@Nullable Object obj) {
        AnimatableValueParser.m426D(!this.f5750i);
        this.f5747f = obj;
        return this;
    }

    /* renamed from: f */
    public PlayerMessage m2602f(int i) {
        AnimatableValueParser.m426D(!this.f5750i);
        this.f5746e = i;
        return this;
    }
}
