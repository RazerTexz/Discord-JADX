package p007b.p225i.p361c.p406w;

import com.google.firebase.messaging.FirebaseMessaging;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;

/* JADX INFO: renamed from: b.i.c.w.h */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4870h implements InterfaceC4361e {

    /* JADX INFO: renamed from: a */
    public final FirebaseMessaging f13025a;

    public C4870h(FirebaseMessaging firebaseMessaging) {
        this.f13025a = firebaseMessaging;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
    public final void onSuccess(Object obj) {
        boolean z2;
        C4887y c4887y = (C4887y) obj;
        if (this.f13025a.f21452e.m9194b()) {
            if (c4887y.f13068j.m6829a() != null) {
                synchronized (c4887y) {
                    z2 = c4887y.f13067i;
                }
                if (z2) {
                    return;
                }
                c4887y.m6836g(0L);
            }
        }
    }
}
