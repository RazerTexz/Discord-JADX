package p686z;

import bolts.ExecutorException;
import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* compiled from: Task.java */
/* renamed from: z.d, reason: use source file name */
/* loaded from: classes.dex */
public class Task3<TResult> implements Continuation3<TResult, Void> {

    /* renamed from: a */
    public final /* synthetic */ TaskCompletionSource2 f27969a;

    /* renamed from: b */
    public final /* synthetic */ Continuation3 f27970b;

    /* renamed from: c */
    public final /* synthetic */ Executor f27971c;

    public Task3(Task6 task6, TaskCompletionSource2 taskCompletionSource2, Continuation3 continuation3, Executor executor) {
        this.f27969a = taskCompletionSource2;
        this.f27970b = continuation3;
        this.f27971c = executor;
    }

    @Override // p686z.Continuation3
    /* renamed from: a */
    public Void mo1510a(Task6 task6) throws Exception {
        TaskCompletionSource2 taskCompletionSource2 = this.f27969a;
        Continuation3 continuation3 = this.f27970b;
        try {
            this.f27971c.execute(new Task4(taskCompletionSource2, continuation3, task6));
            return null;
        } catch (Exception e) {
            taskCompletionSource2.m11375b(new ExecutorException(e));
            return null;
        }
    }
}
