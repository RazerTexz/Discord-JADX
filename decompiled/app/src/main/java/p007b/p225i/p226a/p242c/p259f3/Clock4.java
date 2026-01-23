package p007b.p225i.p226a.p242c.p259f3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.f3.g, reason: use source file name */
/* JADX INFO: compiled from: Clock.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Clock4 {

    /* JADX INFO: renamed from: a */
    public static final Clock4 f6720a = new SystemClock2();

    /* JADX INFO: renamed from: a */
    long mo2949a();

    /* JADX INFO: renamed from: b */
    HandlerWrapper mo2950b(Looper looper, @Nullable Handler.Callback callback);

    /* JADX INFO: renamed from: c */
    void mo2951c();

    /* JADX INFO: renamed from: d */
    long mo2952d();
}
