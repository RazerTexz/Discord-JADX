package p007b.p225i.p361c.p406w;

import com.google.firebase.messaging.FirebaseMessaging;
import p007b.p225i.p361c.p396q.Event3;
import p007b.p225i.p361c.p396q.EventHandler2;

/* JADX INFO: renamed from: b.i.c.w.j */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4872j implements EventHandler2 {

    /* JADX INFO: renamed from: a */
    public final FirebaseMessaging.C11088a f13027a;

    public C4872j(FirebaseMessaging.C11088a c11088a) {
        this.f13027a = c11088a;
    }

    @Override // p007b.p225i.p361c.p396q.EventHandler2
    /* JADX INFO: renamed from: a */
    public final void mo6343a(Event3 event3) {
        FirebaseMessaging.C11088a c11088a = this.f13027a;
        if (c11088a.m9194b()) {
            FirebaseMessaging.this.f21453f.execute(new RunnableC4873k(c11088a));
        }
    }
}
