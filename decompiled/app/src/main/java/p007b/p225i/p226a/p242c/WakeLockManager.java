package p007b.p225i.p226a.p242c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* compiled from: WakeLockManager.java */
/* renamed from: b.i.a.c.q2, reason: use source file name */
/* loaded from: classes3.dex */
public final class WakeLockManager {

    /* renamed from: a */
    @Nullable
    public final PowerManager f7457a;

    /* renamed from: b */
    @Nullable
    public PowerManager.WakeLock f7458b;

    /* renamed from: c */
    public boolean f7459c;

    /* renamed from: d */
    public boolean f7460d;

    public WakeLockManager(Context context) {
        this.f7457a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    /* renamed from: a */
    public final void m3357a() {
        PowerManager.WakeLock wakeLock = this.f7458b;
        if (wakeLock == null) {
            return;
        }
        if (this.f7459c && this.f7460d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
