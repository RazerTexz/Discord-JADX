package p600f0;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: EventListener.kt */
/* renamed from: f0.t, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class EventListener {

    /* renamed from: a */
    public static final EventListener f25962a = new a();

    /* compiled from: EventListener.kt */
    /* renamed from: f0.t$a */
    public static final class a extends EventListener {
    }

    /* compiled from: EventListener.kt */
    /* renamed from: f0.t$b */
    public interface b {
        /* renamed from: a */
        EventListener mo10115a(Call2 call2);
    }

    /* renamed from: a */
    public void m10393a(Call2 call2, Connection2 connection2) {
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(connection2, "connection");
    }
}
