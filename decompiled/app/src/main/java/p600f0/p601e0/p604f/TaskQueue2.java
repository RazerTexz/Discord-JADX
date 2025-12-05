package p600f0.p601e0.p604f;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.TaskRunner;

/* compiled from: TaskQueue.kt */
/* renamed from: f0.e0.f.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class TaskQueue2 {

    /* renamed from: a */
    public boolean f25414a;

    /* renamed from: b */
    public Task2 f25415b;

    /* renamed from: c */
    public final List<Task2> f25416c;

    /* renamed from: d */
    public boolean f25417d;

    /* renamed from: e */
    public final TaskRunner f25418e;

    /* renamed from: f */
    public final String f25419f;

    public TaskQueue2(TaskRunner taskRunner, String str) {
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f25418e = taskRunner;
        this.f25419f = str;
        this.f25416c = new ArrayList();
    }

    /* renamed from: d */
    public static /* synthetic */ void m10151d(TaskQueue2 taskQueue2, Task2 task2, long j, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue2.m10154c(task2, j);
    }

    /* renamed from: a */
    public final void m10152a() {
        byte[] bArr = Util7.f25397a;
        synchronized (this.f25418e) {
            if (m10153b()) {
                this.f25418e.m10161e(this);
            }
        }
    }

    /* renamed from: b */
    public final boolean m10153b() {
        Task2 task2 = this.f25415b;
        if (task2 != null) {
            if (task2 == null) {
                Intrinsics3.throwNpe();
            }
            if (task2.f25412d) {
                this.f25417d = true;
            }
        }
        boolean z2 = false;
        for (int size = this.f25416c.size() - 1; size >= 0; size--) {
            if (this.f25416c.get(size).f25412d) {
                Task2 task22 = this.f25416c.get(size);
                Objects.requireNonNull(TaskRunner.f25422c);
                if (TaskRunner.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(task22, this, "canceled");
                }
                this.f25416c.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    /* renamed from: c */
    public final void m10154c(Task2 task2, long j) {
        Intrinsics3.checkParameterIsNotNull(task2, "task");
        synchronized (this.f25418e) {
            if (!this.f25414a) {
                if (m10155e(task2, j, false)) {
                    this.f25418e.m10161e(this);
                }
            } else if (task2.f25412d) {
                Objects.requireNonNull(TaskRunner.f25422c);
                if (TaskRunner.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(task2, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Objects.requireNonNull(TaskRunner.f25422c);
                if (TaskRunner.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(task2, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* renamed from: e */
    public final boolean m10155e(Task2 task2, long j, boolean z2) {
        String string;
        Intrinsics3.checkParameterIsNotNull(task2, "task");
        Objects.requireNonNull(task2);
        Intrinsics3.checkParameterIsNotNull(this, "queue");
        TaskQueue2 taskQueue2 = task2.f25409a;
        if (taskQueue2 != this) {
            if (!(taskQueue2 == null)) {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
            task2.f25409a = this;
        }
        long jMo10165c = this.f25418e.f25429j.mo10165c();
        long j2 = jMo10165c + j;
        int iIndexOf = this.f25416c.indexOf(task2);
        if (iIndexOf != -1) {
            if (task2.f25410b <= j2) {
                TaskRunner.b bVar = TaskRunner.f25422c;
                if (TaskRunner.f25421b.isLoggable(Level.FINE)) {
                    C3404f.m4283e(task2, this, "already scheduled");
                }
                return false;
            }
            this.f25416c.remove(iIndexOf);
        }
        task2.f25410b = j2;
        TaskRunner.b bVar2 = TaskRunner.f25422c;
        if (TaskRunner.f25421b.isLoggable(Level.FINE)) {
            if (z2) {
                StringBuilder sbM833U = outline.m833U("run again after ");
                sbM833U.append(C3404f.m4268a0(j2 - jMo10165c));
                string = sbM833U.toString();
            } else {
                StringBuilder sbM833U2 = outline.m833U("scheduled after ");
                sbM833U2.append(C3404f.m4268a0(j2 - jMo10165c));
                string = sbM833U2.toString();
            }
            C3404f.m4283e(task2, this, string);
        }
        Iterator<Task2> it = this.f25416c.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().f25410b - jMo10165c > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f25416c.size();
        }
        this.f25416c.add(size, task2);
        return size == 0;
    }

    /* renamed from: f */
    public final void m10156f() {
        byte[] bArr = Util7.f25397a;
        synchronized (this.f25418e) {
            this.f25414a = true;
            if (m10153b()) {
                this.f25418e.m10161e(this);
            }
        }
    }

    public String toString() {
        return this.f25419f;
    }
}
