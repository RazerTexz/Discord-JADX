package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.c2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3608c2 implements InterfaceC3594b2 {

    /* JADX INFO: renamed from: a */
    @GuardedBy("GservicesLoader.class")
    public static C3608c2 f9871a;

    /* JADX INFO: renamed from: b */
    public final Context f9872b;

    /* JADX INFO: renamed from: c */
    public final ContentObserver f9873c;

    public C3608c2(Context context) {
        this.f9872b = context;
        C3650f2 c3650f2 = new C3650f2();
        this.f9873c = c3650f2;
        context.getContentResolver().registerContentObserver(C3848u1.f10333a, true, c3650f2);
    }

    /* JADX INFO: renamed from: a */
    public static C3608c2 m4602a(Context context) {
        C3608c2 c3608c2;
        synchronized (C3608c2.class) {
            if (f9871a == null) {
                f9871a = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C3608c2(context) : new C3608c2();
            }
            c3608c2 = f9871a;
        }
        return c3608c2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3594b2
    /* JADX INFO: renamed from: g */
    public final Object mo4567g(String str) {
        if (this.f9872b == null) {
            return null;
        }
        try {
            return (String) C3404f.m4248T1(new C3664g2(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    public C3608c2() {
        this.f9872b = null;
        this.f9873c = null;
    }
}
