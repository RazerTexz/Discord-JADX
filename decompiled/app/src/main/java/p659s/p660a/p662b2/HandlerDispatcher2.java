package p659s.p660a.p662b2;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.Delay;
import p659s.p660a.Job2;
import p659s.p660a.MainCoroutineDispatcher;

/* compiled from: HandlerDispatcher.kt */
/* renamed from: s.a.b2.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class HandlerDispatcher2 extends HandlerDispatcher3 implements Delay {
    public volatile HandlerDispatcher2 _immediate;

    /* renamed from: j */
    public final HandlerDispatcher2 f27718j;

    /* renamed from: k */
    public final Handler f27719k;

    /* renamed from: l */
    public final String f27720l;

    /* renamed from: m */
    public final boolean f27721m;

    /* compiled from: HandlerDispatcher.kt */
    /* renamed from: s.a.b2.a$a */
    public static final class a implements Job2 {

        /* renamed from: k */
        public final /* synthetic */ Runnable f27723k;

        public a(Runnable runnable) {
            this.f27723k = runnable;
        }

        @Override // p659s.p660a.Job2
        public void dispose() {
            HandlerDispatcher2.this.f27719k.removeCallbacks(this.f27723k);
        }
    }

    /* compiled from: Runnable.kt */
    /* renamed from: s.a.b2.a$b */
    public static final class b implements Runnable {

        /* renamed from: k */
        public final /* synthetic */ CancellableContinuation f27725k;

        public b(CancellableContinuation cancellableContinuation) {
            this.f27725k = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f27725k.mo10905i(HandlerDispatcher2.this, Unit.f27425a);
        }
    }

    /* compiled from: HandlerDispatcher.kt */
    /* renamed from: s.a.b2.a$c */
    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ Runnable $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Runnable runnable) {
            super(1);
            this.$block = runnable;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            HandlerDispatcher2.this.f27719k.removeCallbacks(this.$block);
            return Unit.f27425a;
        }
    }

    public HandlerDispatcher2(Handler handler, String str, boolean z2) {
        super(null);
        this.f27719k = handler;
        this.f27720l = str;
        this.f27721m = z2;
        this._immediate = z2 ? this : null;
        HandlerDispatcher2 handlerDispatcher2 = this._immediate;
        if (handlerDispatcher2 == null) {
            handlerDispatcher2 = new HandlerDispatcher2(handler, str, true);
            this._immediate = handlerDispatcher2;
        }
        this.f27718j = handlerDispatcher2;
    }

    @Override // p659s.p660a.MainCoroutineDispatcher
    /* renamed from: H */
    public MainCoroutineDispatcher mo11194H() {
        return this.f27718j;
    }

    @Override // p659s.p660a.Delay
    /* renamed from: c */
    public void mo11195c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        b bVar = new b(cancellableContinuation);
        this.f27719k.postDelayed(bVar, _Ranges.coerceAtMost(j, 4611686018427387903L));
        ((CancellableContinuationImpl5) cancellableContinuation).mo10902f(new c(bVar));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.f27719k.post(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerDispatcher2) && ((HandlerDispatcher2) obj).f27719k == this.f27719k;
    }

    public int hashCode() {
        return System.identityHashCode(this.f27719k);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !this.f27721m || (Intrinsics3.areEqual(Looper.myLooper(), this.f27719k.getLooper()) ^ true);
    }

    @Override // p659s.p660a.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strM11332I = m11332I();
        if (strM11332I != null) {
            return strM11332I;
        }
        String string = this.f27720l;
        if (string == null) {
            string = this.f27719k.toString();
        }
        return this.f27721m ? outline.m883w(string, ".immediate") : string;
    }

    @Override // p659s.p660a.p662b2.HandlerDispatcher3, p659s.p660a.Delay
    /* renamed from: x */
    public Job2 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        this.f27719k.postDelayed(runnable, _Ranges.coerceAtMost(j, 4611686018427387903L));
        return new a(runnable);
    }
}
