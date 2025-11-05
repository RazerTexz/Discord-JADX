package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.i.a.f.n.c0;
import b.o.a.n.v.a;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* compiled from: CameraStateOrchestrator.java */
/* loaded from: classes3.dex */
public class f extends b.o.a.n.v.a {
    public e f;
    public e g;
    public int h;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: CameraStateOrchestrator.java */
    public class a<T> implements b.i.a.f.n.c<T> {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // b.i.a.f.n.c
        public void onComplete(@NonNull Task<T> task) {
            int i = this.a;
            f fVar = f.this;
            if (i == fVar.h) {
                fVar.g = fVar.f;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: CameraStateOrchestrator.java */
    public class b<T> implements Callable<Task<T>> {
        public final /* synthetic */ e j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;
        public final /* synthetic */ Callable m;
        public final /* synthetic */ boolean n;

        public b(e eVar, String str, e eVar2, Callable callable, boolean z2) {
            this.j = eVar;
            this.k = str;
            this.l = eVar2;
            this.m = callable;
            this.n = z2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            f fVar = f.this;
            if (fVar.f == this.j) {
                return ((Task) this.m.call()).j(b.o.a.n.i.this.k.g, new g(this));
            }
            b.o.a.n.v.a.a.a(2, this.k.toUpperCase(), "- State mismatch, aborting. current:", f.this.f, "from:", this.j, "to:", this.l);
            c0 c0Var = new c0();
            c0Var.u();
            return c0Var;
        }
    }

    public f(@NonNull a.b bVar) {
        super(bVar);
        e eVar = e.OFF;
        this.f = eVar;
        this.g = eVar;
        this.h = 0;
    }

    @NonNull
    public <T> Task<T> f(@NonNull e eVar, @NonNull e eVar2, boolean z2, @NonNull Callable<Task<T>> callable) {
        String str;
        int i = this.h + 1;
        this.h = i;
        this.g = eVar2;
        boolean z3 = !eVar2.f(eVar);
        if (z3) {
            str = eVar.name() + " << " + eVar2.name();
        } else {
            str = eVar.name() + " >> " + eVar2.name();
        }
        Task<T> taskD = d(str, z2, 0L, new b(eVar, str, eVar2, callable, z3));
        taskD.b(new a(i));
        return taskD;
    }
}
