package p007b.p225i.p361c.p406w;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* JADX INFO: renamed from: b.i.c.w.f */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4868f implements InterfaceC4357c {

    /* JADX INFO: renamed from: a */
    public final EnhancedIntentService f13021a;

    /* JADX INFO: renamed from: b */
    public final Intent f13022b;

    public C4868f(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f13021a = enhancedIntentService;
        this.f13022b = intent;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
    public final void onComplete(Task task) {
        this.f13021a.lambda$onStartCommand$1$EnhancedIntentService(this.f13022b, task);
    }
}
