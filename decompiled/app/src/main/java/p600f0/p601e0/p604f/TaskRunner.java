package p600f0.p601e0.p604f;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util6;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: f0.e0.f.d, reason: use source file name */
/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskRunner {

    /* JADX INFO: renamed from: a */
    public static final TaskRunner f25420a;

    /* JADX INFO: renamed from: b */
    public static final Logger f25421b;

    /* JADX INFO: renamed from: c */
    public static final b f25422c = new b(null);

    /* JADX INFO: renamed from: d */
    public int f25423d;

    /* JADX INFO: renamed from: e */
    public boolean f25424e;

    /* JADX INFO: renamed from: f */
    public long f25425f;

    /* JADX INFO: renamed from: g */
    public final List<TaskQueue2> f25426g;

    /* JADX INFO: renamed from: h */
    public final List<TaskQueue2> f25427h;

    /* JADX INFO: renamed from: i */
    public final Runnable f25428i;

    /* JADX INFO: renamed from: j */
    public final a f25429j;

    /* JADX INFO: renamed from: f0.e0.f.d$a */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo10163a(TaskRunner taskRunner);

        /* JADX INFO: renamed from: b */
        void mo10164b(TaskRunner taskRunner, long j);

        /* JADX INFO: renamed from: c */
        long mo10165c();

        void execute(Runnable runnable);
    }

    /* JADX INFO: renamed from: f0.e0.f.d$b */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: f0.e0.f.d$c */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class c implements a {

        /* JADX INFO: renamed from: a */
        public final ThreadPoolExecutor f25430a;

        public c(ThreadFactory threadFactory) {
            Intrinsics3.checkParameterIsNotNull(threadFactory, "threadFactory");
            this.f25430a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // p600f0.p601e0.p604f.TaskRunner.a
        /* JADX INFO: renamed from: a */
        public void mo10163a(TaskRunner taskRunner) {
            Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // p600f0.p601e0.p604f.TaskRunner.a
        /* JADX INFO: renamed from: b */
        public void mo10164b(TaskRunner taskRunner, long j) throws InterruptedException {
            Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                taskRunner.wait(j2, (int) j3);
            }
        }

        @Override // p600f0.p601e0.p604f.TaskRunner.a
        /* JADX INFO: renamed from: c */
        public long mo10165c() {
            return System.nanoTime();
        }

        @Override // p600f0.p601e0.p604f.TaskRunner.a
        public void execute(Runnable runnable) {
            Intrinsics3.checkParameterIsNotNull(runnable, "runnable");
            this.f25430a.execute(runnable);
        }
    }

    /* JADX INFO: renamed from: f0.e0.f.d$d */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Task2 task2M10159c;
            while (true) {
                synchronized (TaskRunner.this) {
                    task2M10159c = TaskRunner.this.m10159c();
                }
                if (task2M10159c == null) {
                    return;
                }
                TaskQueue2 taskQueue2 = task2M10159c.f25409a;
                if (taskQueue2 == null) {
                    Intrinsics3.throwNpe();
                }
                long jMo10165c = -1;
                b bVar = TaskRunner.f25422c;
                boolean zIsLoggable = TaskRunner.f25421b.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jMo10165c = taskQueue2.f25418e.f25429j.mo10165c();
                    C3404f.m4283e(task2M10159c, taskQueue2, "starting");
                }
                try {
                    TaskRunner.m10157a(TaskRunner.this, task2M10159c);
                    if (zIsLoggable) {
                        long jMo10165c2 = taskQueue2.f25418e.f25429j.mo10165c() - jMo10165c;
                        StringBuilder sbM833U = outline.m833U("finished run in ");
                        sbM833U.append(C3404f.m4268a0(jMo10165c2));
                        C3404f.m4283e(task2M10159c, taskQueue2, sbM833U.toString());
                    }
                } finally {
                }
            }
        }
    }

    static {
        String str = Util7.f25403g + " TaskRunner";
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        f25420a = new TaskRunner(new c(new Util6(str, true)));
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics3.checkExpressionValueIsNotNull(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f25421b = logger;
    }

    public TaskRunner(a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, "backend");
        this.f25429j = aVar;
        this.f25423d = 10000;
        this.f25426g = new ArrayList();
        this.f25427h = new ArrayList();
        this.f25428i = new d();
    }

    /* JADX INFO: renamed from: a */
    public static final void m10157a(TaskRunner taskRunner, Task2 task2) {
        Objects.requireNonNull(taskRunner);
        byte[] bArr = Util7.f25397a;
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task2.f25411c);
        try {
            long jMo10150a = task2.mo10150a();
            synchronized (taskRunner) {
                taskRunner.m10158b(task2, jMo10150a);
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (taskRunner) {
                taskRunner.m10158b(task2, -1L);
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10158b(Task2 task2, long j) {
        byte[] bArr = Util7.f25397a;
        TaskQueue2 taskQueue2 = task2.f25409a;
        if (taskQueue2 == null) {
            Intrinsics3.throwNpe();
        }
        if (!(taskQueue2.f25415b == task2)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean z2 = taskQueue2.f25417d;
        taskQueue2.f25417d = false;
        taskQueue2.f25415b = null;
        this.f25426g.remove(taskQueue2);
        if (j != -1 && !z2 && !taskQueue2.f25414a) {
            taskQueue2.m10155e(task2, j, true);
        }
        if (!taskQueue2.f25416c.isEmpty()) {
            this.f25427h.add(taskQueue2);
        }
    }

    /* JADX INFO: renamed from: c */
    public final Task2 m10159c() {
        boolean z2;
        byte[] bArr = Util7.f25397a;
        while (!this.f25427h.isEmpty()) {
            long jMo10165c = this.f25429j.mo10165c();
            long jMin = RecyclerView.FOREVER_NS;
            Iterator<TaskQueue2> it = this.f25427h.iterator();
            Task2 task2 = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                Task2 task22 = it.next().f25416c.get(0);
                long jMax = Math.max(0L, task22.f25410b - jMo10165c);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task2 != null) {
                        z2 = true;
                        break;
                    }
                    task2 = task22;
                }
            }
            if (task2 != null) {
                byte[] bArr2 = Util7.f25397a;
                task2.f25410b = -1L;
                TaskQueue2 taskQueue2 = task2.f25409a;
                if (taskQueue2 == null) {
                    Intrinsics3.throwNpe();
                }
                taskQueue2.f25416c.remove(task2);
                this.f25427h.remove(taskQueue2);
                taskQueue2.f25415b = task2;
                this.f25426g.add(taskQueue2);
                if (z2 || (!this.f25424e && (!this.f25427h.isEmpty()))) {
                    this.f25429j.execute(this.f25428i);
                }
                return task2;
            }
            if (this.f25424e) {
                if (jMin < this.f25425f - jMo10165c) {
                    this.f25429j.mo10163a(this);
                }
                return null;
            }
            this.f25424e = true;
            this.f25425f = jMo10165c + jMin;
            try {
                try {
                    this.f25429j.mo10164b(this, jMin);
                } catch (InterruptedException unused) {
                    m10160d();
                }
            } finally {
                this.f25424e = false;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final void m10160d() {
        for (int size = this.f25426g.size() - 1; size >= 0; size--) {
            this.f25426g.get(size).m10153b();
        }
        for (int size2 = this.f25427h.size() - 1; size2 >= 0; size2--) {
            TaskQueue2 taskQueue2 = this.f25427h.get(size2);
            taskQueue2.m10153b();
            if (taskQueue2.f25416c.isEmpty()) {
                this.f25427h.remove(size2);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m10161e(TaskQueue2 taskQueue2) {
        Intrinsics3.checkParameterIsNotNull(taskQueue2, "taskQueue");
        byte[] bArr = Util7.f25397a;
        if (taskQueue2.f25415b == null) {
            if (!taskQueue2.f25416c.isEmpty()) {
                List<TaskQueue2> list = this.f25427h;
                Intrinsics3.checkParameterIsNotNull(list, "$this$addIfAbsent");
                if (!list.contains(taskQueue2)) {
                    list.add(taskQueue2);
                }
            } else {
                this.f25427h.remove(taskQueue2);
            }
        }
        if (this.f25424e) {
            this.f25429j.mo10163a(this);
        } else {
            this.f25429j.execute(this.f25428i);
        }
    }

    /* JADX INFO: renamed from: f */
    public final TaskQueue2 m10162f() {
        int i;
        synchronized (this) {
            i = this.f25423d;
            this.f25423d = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new TaskQueue2(this, sb.toString());
    }
}
