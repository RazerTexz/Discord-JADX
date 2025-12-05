package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* compiled from: Utils.java */
/* renamed from: b.i.c.m.d.k.j1, reason: use source file name */
/* loaded from: classes3.dex */
public class Utils5 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ Callable f12325j;

    /* renamed from: k */
    public final /* synthetic */ TaskCompletionSource f12326k;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Utils.java */
    /* renamed from: b.i.c.m.d.k.j1$a */
    public class a<T> implements InterfaceC4353a<T, Void> {
        public a() {
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
        /* renamed from: a */
        public Void mo4012a(@NonNull Task task) throws Exception {
            if (task.mo6021p()) {
                TaskCompletionSource taskCompletionSource = Utils5.this.f12326k;
                taskCompletionSource.f20845a.m6024s(task.mo6017l());
                return null;
            }
            TaskCompletionSource taskCompletionSource2 = Utils5.this.f12326k;
            taskCompletionSource2.f20845a.m6025t(task.mo6016k());
            return null;
        }
    }

    public Utils5(Callable callable, TaskCompletionSource taskCompletionSource) {
        this.f12325j = callable;
        this.f12326k = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((Task) this.f12325j.call()).mo6013h(new a());
        } catch (Exception e) {
            this.f12326k.f20845a.m6025t(e);
        }
    }
}
