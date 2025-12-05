package androidx.view;

import androidx.annotation.MainThread;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.Job2;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: CoroutineLiveData.kt */
/* renamed from: androidx.lifecycle.EmittedSource, reason: use source file name */
/* loaded from: classes.dex */
public final class CoroutineLiveData6 implements Job2 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    /* compiled from: CoroutineLiveData.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.EmittedSource$dispose$1", m10085f = "CoroutineLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.EmittedSource$dispose$1 */
    public static final class C04311 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C04311(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return CoroutineLiveData6.this.new C04311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04311) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            CoroutineLiveData6.access$removeSource(CoroutineLiveData6.this);
            return Unit.f27425a;
        }
    }

    /* compiled from: CoroutineLiveData.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.EmittedSource$disposeNow$2", m10085f = "CoroutineLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.EmittedSource$disposeNow$2 */
    public static final class C04322 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C04322(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return CoroutineLiveData6.this.new C04322(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04322) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            CoroutineLiveData6.access$removeSource(CoroutineLiveData6.this);
            return Unit.f27425a;
        }
    }

    public CoroutineLiveData6(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        Intrinsics3.checkNotNullParameter(liveData, "source");
        Intrinsics3.checkNotNullParameter(mediatorLiveData, "mediator");
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    public static final /* synthetic */ void access$removeSource(CoroutineLiveData6 coroutineLiveData6) {
        coroutineLiveData6.removeSource();
    }

    @MainThread
    private final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // p659s.p660a.Job2
    public void dispose() {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        C3404f.m4211H0(C3404f.m4275c(MainDispatchers.f27700b.mo11194H()), null, null, new C04311(null), 3, null);
    }

    public final Object disposeNow(Continuation<? super Unit> continuation) throws Throwable {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        Object objM4197C1 = C3404f.m4197C1(MainDispatchers.f27700b.mo11194H(), new C04322(null), continuation);
        return objM4197C1 == Intrinsics2.getCOROUTINE_SUSPENDED() ? objM4197C1 : Unit.f27425a;
    }
}
