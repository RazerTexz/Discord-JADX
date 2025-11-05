package androidx.view;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import s.a.a.n;
import s.a.k0;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: classes.dex */
public final class BlockRunner<T> {
    private final Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> block;
    private Job cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final Function0<Unit> onDone;
    private Job runningJob;
    private final CoroutineScope scope;
    private final long timeoutInMs;

    /* compiled from: CoroutineLiveData.kt */
    @e(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {Opcodes.NEW}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                long jAccess$getTimeoutInMs$p = BlockRunner.access$getTimeoutInMs$p(BlockRunner.this);
                this.label = 1;
                if (f.P(jAccess$getTimeoutInMs$p, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            if (!BlockRunner.access$getLiveData$p(BlockRunner.this).hasActiveObservers()) {
                Job jobAccess$getRunningJob$p = BlockRunner.access$getRunningJob$p(BlockRunner.this);
                if (jobAccess$getRunningJob$p != null) {
                    f.t(jobAccess$getRunningJob$p, null, 1, null);
                }
                BlockRunner.access$setRunningJob$p(BlockRunner.this, null);
            }
            return Unit.a;
        }
    }

    /* compiled from: CoroutineLiveData.kt */
    @e(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {Opcodes.ARETURN}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(BlockRunner.access$getLiveData$p(BlockRunner.this), ((CoroutineScope) this.L$0).getCoroutineContext());
                Function2 function2Access$getBlock$p = BlockRunner.access$getBlock$p(BlockRunner.this);
                this.label = 1;
                if (function2Access$getBlock$p.invoke(liveDataScopeImpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            BlockRunner.access$getOnDone$p(BlockRunner.this).invoke();
            return Unit.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, long j, CoroutineScope coroutineScope, Function0<Unit> function0) {
        m.checkNotNullParameter(coroutineLiveData, "liveData");
        m.checkNotNullParameter(function2, "block");
        m.checkNotNullParameter(coroutineScope, "scope");
        m.checkNotNullParameter(function0, "onDone");
        this.liveData = coroutineLiveData;
        this.block = function2;
        this.timeoutInMs = j;
        this.scope = coroutineScope;
        this.onDone = function0;
    }

    public static final /* synthetic */ Function2 access$getBlock$p(BlockRunner blockRunner) {
        return blockRunner.block;
    }

    public static final /* synthetic */ CoroutineLiveData access$getLiveData$p(BlockRunner blockRunner) {
        return blockRunner.liveData;
    }

    public static final /* synthetic */ Function0 access$getOnDone$p(BlockRunner blockRunner) {
        return blockRunner.onDone;
    }

    public static final /* synthetic */ Job access$getRunningJob$p(BlockRunner blockRunner) {
        return blockRunner.runningJob;
    }

    public static final /* synthetic */ long access$getTimeoutInMs$p(BlockRunner blockRunner) {
        return blockRunner.timeoutInMs;
    }

    public static final /* synthetic */ void access$setRunningJob$p(BlockRunner blockRunner, Job job) {
        blockRunner.runningJob = job;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        CoroutineScope coroutineScope = this.scope;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        this.cancellationJob = f.H0(coroutineScope, n.f3830b.H(), null, new AnonymousClass1(null), 2, null);
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
