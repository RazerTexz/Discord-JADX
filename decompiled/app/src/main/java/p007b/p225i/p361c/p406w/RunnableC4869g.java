package p007b.p225i.p361c.p406w;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* renamed from: b.i.c.w.g */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4869g implements Runnable {

    /* renamed from: j */
    public final FirebaseMessaging f13023j;

    /* renamed from: k */
    public final FirebaseInstanceId f13024k;

    public RunnableC4869g(FirebaseMessaging firebaseMessaging, FirebaseInstanceId firebaseInstanceId) {
        this.f13023j = firebaseMessaging;
        this.f13024k = firebaseInstanceId;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseMessaging firebaseMessaging = this.f13023j;
        FirebaseInstanceId firebaseInstanceId = this.f13024k;
        if (firebaseMessaging.f21452e.m9194b()) {
            firebaseInstanceId.m9186i();
        }
    }
}
