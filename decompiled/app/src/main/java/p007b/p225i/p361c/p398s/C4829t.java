package p007b.p225i.p361c.p398s;

import android.util.Pair;
import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: renamed from: b.i.c.s.t */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4829t implements InterfaceC4353a {

    /* JADX INFO: renamed from: a */
    public final C4830u f12892a;

    /* JADX INFO: renamed from: b */
    public final Pair f12893b;

    public C4829t(C4830u c4830u, Pair pair) {
        this.f12892a = c4830u;
        this.f12893b = pair;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public final Object mo4012a(Task task) {
        C4830u c4830u = this.f12892a;
        Pair pair = this.f12893b;
        synchronized (c4830u) {
            c4830u.f12895b.remove(pair);
        }
        return task;
    }
}
