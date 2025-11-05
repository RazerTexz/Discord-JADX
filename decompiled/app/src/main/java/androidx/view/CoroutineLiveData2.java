package androidx.view;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* compiled from: CoroutineLiveData.kt */
/* renamed from: androidx.lifecycle.BlockRunner, reason: use source file name */
/* loaded from: classes.dex */
public final class CoroutineLiveData2<T> {
    private final Function2<CoroutineLiveData7<T>, Continuation<? super Unit>, Object> block;
    private Job cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final Function0<Unit> onDone;
    private Job runningJob;
    private final CoroutineScope scope;
    private final long timeoutInMs;

    /* compiled from: CoroutineLiveData.kt */
    @DebugMetadata(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {Opcodes.NEW}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                long jAccess$getTimeoutInMs$p = CoroutineLiveData2.access$getTimeoutInMs$p(CoroutineLiveData2.this);
                this.label = 1;
                if (f.P(jAccess$getTimeoutInMs$p, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            if (!CoroutineLiveData2.access$getLiveData$p(CoroutineLiveData2.this).hasActiveObservers()) {
                Job jobAccess$getRunningJob$p = CoroutineLiveData2.access$getRunningJob$p(CoroutineLiveData2.this);
                if (jobAccess$getRunningJob$p != null) {
                    f.t(jobAccess$getRunningJob$p, null, 1, null);
                }
                CoroutineLiveData2.access$setRunningJob$p(CoroutineLiveData2.this, null);
            }
            return Unit.a;
        }
    }

    /* compiled from: CoroutineLiveData.kt */
    @DebugMetadata(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {Opcodes.ARETURN}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineLiveData8 coroutineLiveData8 = new CoroutineLiveData8(CoroutineLiveData2.access$getLiveData$p(CoroutineLiveData2.this), ((CoroutineScope) this.L$0).getCoroutineContext());
                Function2 function2Access$getBlock$p = CoroutineLiveData2.access$getBlock$p(CoroutineLiveData2.this);
                this.label = 1;
                if (function2Access$getBlock$p.invoke(coroutineLiveData8, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            CoroutineLiveData2.access$getOnDone$p(CoroutineLiveData2.this).invoke();
            return Unit.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineLiveData2(CoroutineLiveData<T> coroutineLiveData, Function2<? super CoroutineLiveData7<T>, ? super Continuation<? super Unit>, ? extends Object> function2, long j, CoroutineScope coroutineScope, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(coroutineLiveData, "liveData");
        Intrinsics3.checkNotNullParameter(function2, "block");
        Intrinsics3.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics3.checkNotNullParameter(function0, "onDone");
        this.liveData = coroutineLiveData;
        this.block = function2;
        this.timeoutInMs = j;
        this.scope = coroutineScope;
        this.onDone = function0;
    }

    public static final /* synthetic */ Function2 access$getBlock$p(CoroutineLiveData2 coroutineLiveData2) {
        return coroutineLiveData2.block;
    }

    public static final /* synthetic */ CoroutineLiveData access$getLiveData$p(CoroutineLiveData2 coroutineLiveData2) {
        return coroutineLiveData2.liveData;
    }

    public static final /* synthetic */ Function0 access$getOnDone$p(CoroutineLiveData2 coroutineLiveData2) {
        return coroutineLiveData2.onDone;
    }

    public static final /* synthetic */ Job access$getRunningJob$p(CoroutineLiveData2 coroutineLiveData2) {
        return coroutineLiveData2.runningJob;
    }

    public static final /* synthetic */ long access$getTimeoutInMs$p(CoroutineLiveData2 coroutineLiveData2) {
        return coroutineLiveData2.timeoutInMs;
    }

    public static final /* synthetic */ void access$setRunningJob$p(CoroutineLiveData2 coroutineLiveData2, Job job) {
        coroutineLiveData2.runningJob = job;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        CoroutineScope coroutineScope = this.scope;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        this.cancellationJob = f.H0(coroutineScope, MainDispatchers.f3830b.H(), null, new AnonymousClass1(null), 2, null);
    }

    @MainThread
    public final void maybeRun() {
        Job job = this.cancellationJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = f.H0(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }
}
