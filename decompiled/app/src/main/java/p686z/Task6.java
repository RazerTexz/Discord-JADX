package p686z;

import bolts.ExecutorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Task.java */
/* renamed from: z.g, reason: use source file name */
/* loaded from: classes.dex */
public class Task6<TResult> {

    /* renamed from: a */
    public static final ExecutorService f27977a;

    /* renamed from: b */
    public static final Executor f27978b;

    /* renamed from: c */
    public static final Executor f27979c;

    /* renamed from: d */
    public static Task6<?> f27980d;

    /* renamed from: e */
    public static Task6<Boolean> f27981e;

    /* renamed from: f */
    public static Task6<Boolean> f27982f;

    /* renamed from: h */
    public boolean f27984h;

    /* renamed from: i */
    public boolean f27985i;

    /* renamed from: j */
    public TResult f27986j;

    /* renamed from: k */
    public Exception f27987k;

    /* renamed from: l */
    public boolean f27988l;

    /* renamed from: g */
    public final Object f27983g = new Object();

    /* renamed from: m */
    public List<Continuation3<TResult, Void>> f27989m = new ArrayList();

    static {
        BoltsExecutors boltsExecutors = BoltsExecutors.f27965a;
        f27977a = boltsExecutors.f27966b;
        f27978b = boltsExecutors.f27967c;
        f27979c = AndroidExecutors.f27960a.f27964e;
        f27980d = new Task6<>((Object) null);
        f27981e = new Task6<>(Boolean.TRUE);
        f27982f = new Task6<>(Boolean.FALSE);
        new Task6(true);
    }

    public Task6() {
    }

    /* renamed from: a */
    public static <TResult> Task6<TResult> m11366a(Callable<TResult> callable, Executor executor) {
        TaskCompletionSource2 taskCompletionSource2 = new TaskCompletionSource2();
        try {
            executor.execute(new Task5(taskCompletionSource2, callable));
        } catch (Exception e) {
            taskCompletionSource2.m11375b(new ExecutorException(e));
        }
        return taskCompletionSource2.f27990a;
    }

    /* renamed from: c */
    public static <TResult> Task6<TResult> m11367c(Exception exc) {
        boolean z2;
        Task6<TResult> task6 = new Task6<>();
        synchronized (task6.f27983g) {
            z2 = false;
            if (!task6.f27984h) {
                task6.f27984h = true;
                task6.f27987k = exc;
                task6.f27988l = false;
                task6.f27983g.notifyAll();
                task6.m11371f();
                z2 = true;
            }
        }
        if (z2) {
            return task6;
        }
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    /* renamed from: b */
    public <TContinuationResult> Task6<TContinuationResult> m11368b(Continuation3<TResult, TContinuationResult> continuation3) {
        boolean z2;
        Executor executor = f27978b;
        TaskCompletionSource2 taskCompletionSource2 = new TaskCompletionSource2();
        synchronized (this.f27983g) {
            synchronized (this.f27983g) {
                z2 = this.f27984h;
            }
            if (!z2) {
                this.f27989m.add(new Task3(this, taskCompletionSource2, continuation3, executor));
            }
        }
        if (z2) {
            try {
                executor.execute(new Task4(taskCompletionSource2, continuation3, this));
            } catch (Exception e) {
                taskCompletionSource2.m11375b(new ExecutorException(e));
            }
        }
        return taskCompletionSource2.f27990a;
    }

    /* renamed from: d */
    public Exception m11369d() {
        Exception exc;
        synchronized (this.f27983g) {
            exc = this.f27987k;
            if (exc != null) {
                this.f27988l = true;
            }
        }
        return exc;
    }

    /* renamed from: e */
    public boolean m11370e() {
        boolean z2;
        synchronized (this.f27983g) {
            z2 = m11369d() != null;
        }
        return z2;
    }

    /* renamed from: f */
    public final void m11371f() {
        synchronized (this.f27983g) {
            Iterator<Continuation3<TResult, Void>> it = this.f27989m.iterator();
            while (it.hasNext()) {
                try {
                    it.next().mo1510a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f27989m = null;
        }
    }

    /* renamed from: g */
    public boolean m11372g() {
        synchronized (this.f27983g) {
            if (this.f27984h) {
                return false;
            }
            this.f27984h = true;
            this.f27985i = true;
            this.f27983g.notifyAll();
            m11371f();
            return true;
        }
    }

    /* renamed from: h */
    public boolean m11373h(TResult tresult) {
        synchronized (this.f27983g) {
            if (this.f27984h) {
                return false;
            }
            this.f27984h = true;
            this.f27986j = tresult;
            this.f27983g.notifyAll();
            m11371f();
            return true;
        }
    }

    public Task6(TResult tresult) {
        m11373h(tresult);
    }

    public Task6(boolean z2) {
        if (z2) {
            m11372g();
        } else {
            m11373h(null);
        }
    }
}
