package p007b.p225i.p226a.p288f.p299e.p310p;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.p.b */
/* loaded from: classes3.dex */
public class C3411b {

    /* renamed from: a */
    public static C3411b f9606a = new C3411b();

    /* renamed from: b */
    @Nullable
    public C3410a f9607b = null;

    @RecentlyNonNull
    /* renamed from: a */
    public static C3410a m4376a(@RecentlyNonNull Context context) {
        C3410a c3410a;
        C3411b c3411b = f9606a;
        synchronized (c3411b) {
            if (c3411b.f9607b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                c3411b.f9607b = new C3410a(context);
            }
            c3410a = c3411b.f9607b;
        }
        return c3410a;
    }
}
