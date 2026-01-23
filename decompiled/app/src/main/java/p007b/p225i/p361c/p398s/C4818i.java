package p007b.p225i.p361c.p398s;

import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: renamed from: b.i.c.s.i */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4818i implements InterfaceC4353a {

    /* JADX INFO: renamed from: a */
    public final FirebaseInstanceId f12867a;

    /* JADX INFO: renamed from: b */
    public final String f12868b;

    /* JADX INFO: renamed from: c */
    public final String f12869c;

    public C4818i(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.f12867a = firebaseInstanceId;
        this.f12868b = str;
        this.f12869c = str2;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public final Object mo4012a(Task task) {
        return this.f12867a.m9189m(this.f12868b, this.f12869c);
    }
}
