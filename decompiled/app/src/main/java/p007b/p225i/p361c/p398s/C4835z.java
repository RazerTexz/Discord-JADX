package p007b.p225i.p361c.p398s;

import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p225i.p361c.p398s.ServiceConnectionC4812d0;

/* JADX INFO: renamed from: b.i.c.s.z */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4835z implements InterfaceC4357c {

    /* JADX INFO: renamed from: a */
    public final ServiceConnectionC4812d0.a f12917a;

    public C4835z(ServiceConnectionC4812d0.a aVar) {
        this.f12917a = aVar;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
    public final void onComplete(Task task) {
        this.f12917a.m6723a();
    }
}
