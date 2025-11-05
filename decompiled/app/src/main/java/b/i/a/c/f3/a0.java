package b.i.a.c.f3;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* compiled from: SystemClock.java */
/* loaded from: classes3.dex */
public class a0 implements g {
    @Override // b.i.a.c.f3.g
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // b.i.a.c.f3.g
    public o b(Looper looper, @Nullable Handler.Callback callback) {
        return new b0(new Handler(looper, callback));
    }

    @Override // b.i.a.c.f3.g
    public void c() {
    }

    @Override // b.i.a.c.f3.g
    public long d() {
        return SystemClock.elapsedRealtime();
    }
}
