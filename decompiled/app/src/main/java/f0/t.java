package f0;

import androidx.core.app.NotificationCompat;

/* compiled from: EventListener.kt */
/* loaded from: classes3.dex */
public abstract class t {
    public static final t a = new a();

    /* compiled from: EventListener.kt */
    public static final class a extends t {
    }

    /* compiled from: EventListener.kt */
    public interface b {
        t a(e eVar);
    }

    public void a(e eVar, k kVar) {
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(kVar, "connection");
    }
}
