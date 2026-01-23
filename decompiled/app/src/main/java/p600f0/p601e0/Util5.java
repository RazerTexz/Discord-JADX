package p600f0.p601e0;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Call2;
import p600f0.EventListener;

/* JADX INFO: renamed from: f0.e0.a, reason: use source file name */
/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Util5 implements EventListener.b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ EventListener f25394a;

    public Util5(EventListener eventListener) {
        this.f25394a = eventListener;
    }

    @Override // p600f0.EventListener.b
    /* JADX INFO: renamed from: a */
    public EventListener mo10115a(Call2 call2) {
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        return this.f25394a;
    }
}
