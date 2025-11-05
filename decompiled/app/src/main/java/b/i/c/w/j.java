package b.i.c.w;

import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements b.i.c.q.b {
    public final FirebaseMessaging.a a;

    public j(FirebaseMessaging.a aVar) {
        this.a = aVar;
    }

    @Override // b.i.c.q.b
    public final void a(b.i.c.q.a aVar) {
        FirebaseMessaging.a aVar2 = this.a;
        if (aVar2.b()) {
            FirebaseMessaging.this.f.execute(new k(aVar2));
        }
    }
}
