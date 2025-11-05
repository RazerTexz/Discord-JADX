package b.i.a.c;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

/* compiled from: WifiLockManager.java */
/* loaded from: classes3.dex */
public final class r2 {

    @Nullable
    public final WifiManager a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public WifiManager.WifiLock f1059b;
    public boolean c;
    public boolean d;

    public r2(Context context) {
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public final void a() {
        WifiManager.WifiLock wifiLock = this.f1059b;
        if (wifiLock == null) {
            return;
        }
        if (this.c && this.d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
