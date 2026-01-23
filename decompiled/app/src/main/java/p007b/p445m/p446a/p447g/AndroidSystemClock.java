package p007b.p445m.p446a.p447g;

import android.os.SystemClock;
import p007b.p445m.p446a.Clock5;

/* JADX INFO: renamed from: b.m.a.g.a, reason: use source file name */
/* JADX INFO: compiled from: AndroidSystemClock.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidSystemClock implements Clock5 {
    @Override // p007b.p445m.p446a.Clock5
    /* JADX INFO: renamed from: a */
    public long mo7128a() {
        return System.currentTimeMillis();
    }

    @Override // p007b.p445m.p446a.Clock5
    /* JADX INFO: renamed from: b */
    public long mo7129b() {
        return SystemClock.elapsedRealtime();
    }
}
