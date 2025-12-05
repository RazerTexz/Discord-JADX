package p007b.p225i.p226a.p242c.p259f3;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* compiled from: SystemClock.java */
/* renamed from: b.i.a.c.f3.a0, reason: use source file name */
/* loaded from: classes3.dex */
public class SystemClock2 implements Clock4 {
    @Override // p007b.p225i.p226a.p242c.p259f3.Clock4
    /* renamed from: a */
    public long mo2949a() {
        return SystemClock.uptimeMillis();
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.Clock4
    /* renamed from: b */
    public HandlerWrapper mo2950b(Looper looper, @Nullable Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.Clock4
    /* renamed from: c */
    public void mo2951c() {
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.Clock4
    /* renamed from: d */
    public long mo2952d() {
        return SystemClock.elapsedRealtime();
    }
}
