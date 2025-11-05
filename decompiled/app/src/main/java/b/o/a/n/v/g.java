package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.o.a.n.v.f;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: CameraStateOrchestrator.java */
/* loaded from: classes3.dex */
public class g<T> implements b.i.a.f.n.a<T, Task<T>> {
    public final /* synthetic */ f.b a;

    public g(f.b bVar) {
        this.a = bVar;
    }

    @Override // b.i.a.f.n.a
    public Object a(@NonNull Task task) throws Exception {
        if (task.p() || this.a.n) {
            f.b bVar = this.a;
            f.this.f = bVar.l;
        }
        return task;
    }
}
