package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p359d.p360a.ListenableFuture8;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.C13110f1;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.CompletableJob;
import p659s.p660a.Dispatchers;

/* compiled from: CoroutineWorker.kt */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final CompletableJob job;

    /* compiled from: CoroutineWorker.kt */
    /* renamed from: androidx.work.CoroutineWorker$1 */
    public static final class RunnableC07111 implements Runnable {
        public RunnableC07111() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CoroutineWorker.this.getFuture$work_runtime_ktx_release().isCancelled()) {
                C3404f.m4343t(CoroutineWorker.this.getJob(), null, 1, null);
            }
        }
    }

    /* compiled from: CoroutineWorker.kt */
    @DebugMetadata(m10084c = "androidx.work.CoroutineWorker$startWork$1", m10085f = "CoroutineWorker.kt", m10086l = {68}, m10087m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$startWork$1 */
    public static final class C07141 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object L$0;
        public int label;

        /* renamed from: p$ */
        private CoroutineScope f162p$;

        public C07141(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkParameterIsNotNull(continuation, "completion");
            C07141 c07141 = CoroutineWorker.this.new C07141(continuation);
            c07141.f162p$ = (CoroutineScope) obj;
            return c07141;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07141) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    CoroutineScope coroutineScope = this.f162p$;
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = coroutineWorker.doWork(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().setException(th);
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkParameterIsNotNull(context, "appContext");
        Intrinsics3.checkParameterIsNotNull(workerParameters, "params");
        this.job = new C13110f1(null);
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        Intrinsics3.checkExpressionValueIsNotNull(settableFutureCreate, "SettableFuture.create()");
        this.future = settableFutureCreate;
        RunnableC07111 runnableC07111 = new RunnableC07111();
        TaskExecutor taskExecutor = getTaskExecutor();
        Intrinsics3.checkExpressionValueIsNotNull(taskExecutor, "taskExecutor");
        settableFutureCreate.addListener(runnableC07111, taskExecutor.getBackgroundExecutor());
        this.coroutineContext = Dispatchers.f27866a;
    }

    public static /* synthetic */ void coroutineContext$annotations() {
    }

    public abstract Object doWork(Continuation<? super ListenableWorker.Result> continuation);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    /* renamed from: getJob$work_runtime_ktx_release, reason: from getter */
    public final CompletableJob getJob() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, Continuation<? super Unit> continuation) throws Throwable {
        Object objM11326u;
        ListenableFuture8<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        Intrinsics3.checkExpressionValueIsNotNull(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                objM11326u = foregroundAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
            foregroundAsync.addListener(new ListenableFuture2(cancellableContinuationImpl5, foregroundAsync), DirectExecutor.INSTANCE);
            objM11326u = cancellableContinuationImpl5.m11326u();
            if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
        }
        return objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED() ? objM11326u : Unit.f27425a;
    }

    public final Object setProgress(Data data, Continuation<? super Unit> continuation) throws Throwable {
        Object objM11326u;
        ListenableFuture8<Void> progressAsync = setProgressAsync(data);
        Intrinsics3.checkExpressionValueIsNotNull(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                objM11326u = progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
            progressAsync.addListener(new ListenableFuture(cancellableContinuationImpl5, progressAsync), DirectExecutor.INSTANCE);
            objM11326u = cancellableContinuationImpl5.m11326u();
            if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
        }
        return objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED() ? objM11326u : Unit.f27425a;
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture8<ListenableWorker.Result> startWork() {
        C3404f.m4211H0(C3404f.m4275c(getCoroutineContext().plus(this.job)), null, null, new C07141(null), 3, null);
        return this.future;
    }
}
