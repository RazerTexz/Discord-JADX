package p007b.p225i.p226a.p288f.p298d;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: renamed from: b.i.a.f.d.v */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3247v implements InterfaceC4353a {

    /* JADX INFO: renamed from: a */
    public final C3227b f9288a;

    /* JADX INFO: renamed from: b */
    public final Bundle f9289b;

    public C3247v(C3227b c3227b, Bundle bundle) {
        this.f9288a = c3227b;
        this.f9289b = bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public final Object mo4012a(Task task) {
        C3227b c3227b = this.f9288a;
        Bundle bundle = this.f9289b;
        Objects.requireNonNull(c3227b);
        if (!task.mo6021p()) {
            return task;
        }
        Bundle bundle2 = (Bundle) task.mo6017l();
        return !(bundle2 != null && bundle2.containsKey("google.messenger")) ? task : c3227b.m4000b(bundle).mo6023r(ExecutorC3251z.f9295j, C3248w.f9290a);
    }
}
