package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import d0.l;
import d0.w.f;
import d0.w.h.c;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import s.a.a.n;
import s.a.k0;
import s.a.m0;
import s.a.u1;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* compiled from: CoroutineLiveData.kt */
    /* renamed from: androidx.lifecycle.CoroutineLiveData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CoroutineLiveData.access$setBlockRunner$p(CoroutineLiveData.this, null);
        }
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? f.j : coroutineContext, (i & 2) != 0 ? 5000L : j, function2);
    }

    public static final /* synthetic */ BlockRunner access$getBlockRunner$p(CoroutineLiveData coroutineLiveData) {
        return coroutineLiveData.blockRunner;
    }

    public static final /* synthetic */ void access$setBlockRunner$p(CoroutineLiveData coroutineLiveData, BlockRunner blockRunner) {
        coroutineLiveData.blockRunner = blockRunner;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) continuation;
            int i = coroutineLiveData$clearSource$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
            }
        }
        Object obj = coroutineLiveData$clearSource$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData$clearSource$1.label;
        if (i2 == 0) {
            l.throwOnFailure(obj);
            EmittedSource emittedSource = this.emittedSource;
            if (emittedSource != null) {
                coroutineLiveData$clearSource$1.L$0 = this;
                coroutineLiveData$clearSource$1.label = 1;
                if (emittedSource.disposeNow(coroutineLiveData$clearSource$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            coroutineLiveData = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
            l.throwOnFailure(obj);
        }
        coroutineLiveData.emittedSource = null;
        return Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super m0> continuation) {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) continuation;
            int i = coroutineLiveData$emitSource$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
            }
        }
        Object objAddDisposableSource = coroutineLiveData$emitSource$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData$emitSource$1.label;
        if (i2 == 0) {
            l.throwOnFailure(objAddDisposableSource);
            coroutineLiveData$emitSource$1.L$0 = this;
            coroutineLiveData$emitSource$1.L$1 = liveData;
            coroutineLiveData$emitSource$1.label = 1;
            if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            liveData2 = liveData;
            coroutineLiveData = this;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                l.throwOnFailure(objAddDisposableSource);
                EmittedSource emittedSource = (EmittedSource) objAddDisposableSource;
                coroutineLiveData.emittedSource = emittedSource;
                return emittedSource;
            }
            LiveData<T> liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
            CoroutineLiveData<T> coroutineLiveData2 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
            l.throwOnFailure(objAddDisposableSource);
            liveData2 = liveData3;
            coroutineLiveData = coroutineLiveData2;
        }
        coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
        coroutineLiveData$emitSource$1.L$1 = null;
        coroutineLiveData$emitSource$1.label = 2;
        objAddDisposableSource = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
        if (objAddDisposableSource == coroutine_suspended) {
            return coroutine_suspended;
        }
        EmittedSource emittedSource2 = (EmittedSource) objAddDisposableSource;
        coroutineLiveData.emittedSource = emittedSource2;
        return emittedSource2;
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }

    public CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        m.checkNotNullParameter(coroutineContext, "context");
        m.checkNotNullParameter(function2, "block");
        u1 u1Var = new u1((Job) coroutineContext.get(Job.INSTANCE));
        CoroutineDispatcher coroutineDispatcher = k0.a;
        this.blockRunner = new BlockRunner<>(this, function2, j, b.i.a.f.e.o.f.c(n.f3830b.H().plus(coroutineContext).plus(u1Var)), new AnonymousClass1());
    }
}
