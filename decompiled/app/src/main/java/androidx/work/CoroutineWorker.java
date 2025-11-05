package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import b.i.a.f.e.o.f;
import b.i.b.d.a.a;
import d0.l;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.g;
import d0.w.i.a.k;
import d0.z.d.m;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import s.a.f1;
import s.a.k0;
import s.a.u;

/* compiled from: CoroutineWorker.kt */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final u job;

    /* compiled from: CoroutineWorker.kt */
    /* renamed from: androidx.work.CoroutineWorker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CoroutineWorker.this.getFuture$work_runtime_ktx_release().isCancelled()) {
                f.t(CoroutineWorker.this.getJob(), null, 1, null);
            }
        }
    }

    /* compiled from: CoroutineWorker.kt */
    @e(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object L$0;
        public int label;
        private CoroutineScope p$;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 anonymousClass1 = CoroutineWorker.this.new AnonymousClass1(continuation);
            anonymousClass1.p$ = (CoroutineScope) obj;
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
            try {
                if (i == 0) {
                    l.throwOnFailure(obj);
                    CoroutineScope coroutineScope = this.p$;
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
                    l.throwOnFailure(obj);
                }
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().setException(th);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.checkParameterIsNotNull(context, "appContext");
        m.checkParameterIsNotNull(workerParameters, "params");
        this.job = new f1(null);
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        m.checkExpressionValueIsNotNull(settableFutureCreate, "SettableFuture.create()");
        this.future = settableFutureCreate;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        TaskExecutor taskExecutor = getTaskExecutor();
        m.checkExpressionValueIsNotNull(taskExecutor, "taskExecutor");
        settableFutureCreate.addListener(anonymousClass1, taskExecutor.getBackgroundExecutor());
        this.coroutineContext = k0.a;
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
    public final u getJob() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, Continuation<? super Unit> continuation) throws Throwable {
        Object objU;
        a<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        m.checkExpressionValueIsNotNull(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                objU = foregroundAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            s.a.l lVar = new s.a.l(b.intercepted(continuation), 1);
            foregroundAsync.addListener(new CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2(lVar, foregroundAsync), DirectExecutor.INSTANCE);
            objU = lVar.u();
            if (objU == c.getCOROUTINE_SUSPENDED()) {
                g.probeCoroutineSuspended(continuation);
            }
        }
        return objU == c.getCOROUTINE_SUSPENDED() ? objU : Unit.a;
    }

    public final Object setProgress(Data data, Continuation<? super Unit> continuation) throws Throwable {
        Object objU;
        a<Void> progressAsync = setProgressAsync(data);
        m.checkExpressionValueIsNotNull(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                objU = progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            s.a.l lVar = new s.a.l(b.intercepted(continuation), 1);
            progressAsync.addListener(new CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$1(lVar, progressAsync), DirectExecutor.INSTANCE);
            objU = lVar.u();
            if (objU == c.getCOROUTINE_SUSPENDED()) {
                g.probeCoroutineSuspended(continuation);
            }
        }
        return objU == c.getCOROUTINE_SUSPENDED() ? objU : Unit.a;
    }

    @Override // androidx.work.ListenableWorker
    public final a<ListenableWorker.Result> startWork() {
        f.H0(f.c(getCoroutineContext().plus(this.job)), null, null, new AnonymousClass1(null), 3, null);
        return this.future;
    }
}
