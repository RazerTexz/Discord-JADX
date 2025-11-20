package b.o.a.n.v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* compiled from: CameraOrchestrator.java */
/* loaded from: classes3.dex */
public class a {
    public static final b.o.a.b a = new b.o.a.b(a.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public final b f1941b;
    public final ArrayDeque<c<?>> c = new ArrayDeque<>();
    public boolean d = false;
    public final Object e = new Object();

    /* compiled from: CameraOrchestrator.java */
    /* renamed from: b.o.a.n.v.a$a, reason: collision with other inner class name */
    public class CallableC0174a implements Callable<Task<Void>> {
        public final /* synthetic */ Runnable j;

        public CallableC0174a(a aVar, Runnable runnable) {
            this.j = runnable;
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            this.j.run();
            return b.i.a.f.e.o.f.Z(null);
        }
    }

    /* compiled from: CameraOrchestrator.java */
    public interface b {
    }

    /* compiled from: CameraOrchestrator.java */
    public static class c<T> {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource<T> f1942b = new TaskCompletionSource<>();
        public final Callable<Task<T>> c;
        public final boolean d;
        public final long e;

        public c(String str, Callable callable, boolean z2, long j, CallableC0174a callableC0174a) {
            this.a = str;
            this.c = callable;
            this.d = z2;
            this.e = j;
        }
    }

    public a(@NonNull b bVar) {
        this.f1941b = bVar;
    }

    public static void a(a aVar, c cVar) {
        if (!aVar.d) {
            StringBuilder sbU = b.d.b.a.a.U("mJobRunning was not true after completing job=");
            sbU.append(cVar.a);
            throw new IllegalStateException(sbU.toString());
        }
        aVar.d = false;
        aVar.c.remove(cVar);
        b.o.a.r.g gVar = b.o.a.n.i.this.k;
        gVar.f.postDelayed(new b.o.a.n.v.b(aVar), 0L);
    }

    @NonNull
    public Task<Void> b(@NonNull String str, boolean z2, @NonNull Runnable runnable) {
        return d(str, z2, 0L, new CallableC0174a(this, runnable));
    }

    @NonNull
    public Task<Void> c(@NonNull String str, boolean z2, long j, @NonNull Runnable runnable) {
        return d(str, z2, j, new CallableC0174a(this, runnable));
    }

    @NonNull
    public final <T> Task<T> d(@NonNull String str, boolean z2, long j, @NonNull Callable<Task<T>> callable) {
        a.a(1, str.toUpperCase(), "- Scheduling.");
        c<?> cVar = new c<>(str, callable, z2, System.currentTimeMillis() + j, null);
        synchronized (this.e) {
            this.c.addLast(cVar);
            b.o.a.n.i.this.k.f.postDelayed(new b.o.a.n.v.b(this), j);
        }
        return cVar.f1942b.a;
    }

    public void e(@NonNull String str, int i) {
        synchronized (this.e) {
            ArrayList arrayList = new ArrayList();
            for (c<?> cVar : this.c) {
                if (cVar.a.equals(str)) {
                    arrayList.add(cVar);
                }
            }
            a.a(0, "trim: name=", str, "scheduled=", Integer.valueOf(arrayList.size()), "allowed=", Integer.valueOf(i));
            int iMax = Math.max(arrayList.size() - i, 0);
            if (iMax > 0) {
                Collections.reverse(arrayList);
                Iterator it = arrayList.subList(0, iMax).iterator();
                while (it.hasNext()) {
                    this.c.remove((c) it.next());
                }
            }
        }
    }
}
