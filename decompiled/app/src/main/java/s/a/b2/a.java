package s.a.b2;

import android.os.Handler;
import android.os.Looper;
import d0.d0.f;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import s.a.h0;
import s.a.l;
import s.a.l1;
import s.a.m0;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public final class a extends s.a.b2.b implements h0 {
    public volatile a _immediate;
    public final a j;
    public final Handler k;
    public final String l;
    public final boolean m;

    /* compiled from: HandlerDispatcher.kt */
    /* renamed from: s.a.b2.a$a, reason: collision with other inner class name */
    public static final class C0645a implements m0 {
        public final /* synthetic */ Runnable k;

        public C0645a(Runnable runnable) {
            this.k = runnable;
        }

        @Override // s.a.m0
        public void dispose() {
            a.this.k.removeCallbacks(this.k);
        }
    }

    /* compiled from: Runnable.kt */
    public static final class b implements Runnable {
        public final /* synthetic */ CancellableContinuation k;

        public b(CancellableContinuation cancellableContinuation) {
            this.k = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.k.i(a.this, Unit.a);
        }
    }

    /* compiled from: HandlerDispatcher.kt */
    public static final class c extends o implements Function1<Throwable, Unit> {
        public final /* synthetic */ Runnable $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Runnable runnable) {
            super(1);
            this.$block = runnable;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            a.this.k.removeCallbacks(this.$block);
            return Unit.a;
        }
    }

    public a(Handler handler, String str, boolean z2) {
        super(null);
        this.k = handler;
        this.l = str;
        this.m = z2;
        this._immediate = z2 ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
        }
        this.j = aVar;
    }

    @Override // s.a.l1
    public l1 H() {
        return this.j;
    }

    @Override // s.a.h0
    public void c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        b bVar = new b(cancellableContinuation);
        this.k.postDelayed(bVar, f.coerceAtMost(j, 4611686018427387903L));
        ((l) cancellableContinuation).f(new c(bVar));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.k.post(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).k == this.k;
    }

    public int hashCode() {
        return System.identityHashCode(this.k);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !this.m || (m.areEqual(Looper.myLooper(), this.k.getLooper()) ^ true);
    }

    @Override // s.a.l1, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strI = I();
        if (strI != null) {
            return strI;
        }
        String string = this.l;
        if (string == null) {
            string = this.k.toString();
        }
        return this.m ? b.d.b.a.a.w(string, ".immediate") : string;
    }

    @Override // s.a.b2.b, s.a.h0
    public m0 x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        this.k.postDelayed(runnable, f.coerceAtMost(j, 4611686018427387903L));
        return new C0645a(runnable);
    }
}
