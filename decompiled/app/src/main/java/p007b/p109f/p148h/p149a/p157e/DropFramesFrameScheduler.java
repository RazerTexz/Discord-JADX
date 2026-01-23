package p007b.p109f.p148h.p149a.p157e;

import androidx.annotation.VisibleForTesting;
import p007b.p109f.p148h.p149a.p150a.AnimationInformation;

/* JADX INFO: renamed from: b.f.h.a.e.a, reason: use source file name */
/* JADX INFO: compiled from: DropFramesFrameScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class DropFramesFrameScheduler {

    /* JADX INFO: renamed from: a */
    public final AnimationInformation f3561a;

    /* JADX INFO: renamed from: b */
    public long f3562b = -1;

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        this.f3561a = animationInformation;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public int m1166a(long j) {
        int i = 0;
        long jMo1144e = 0;
        do {
            jMo1144e += (long) this.f3561a.mo1144e(i);
            i++;
        } while (j >= jMo1144e);
        return i - 1;
    }

    /* JADX INFO: renamed from: b */
    public long m1167b() {
        long j = this.f3562b;
        if (j != -1) {
            return j;
        }
        this.f3562b = 0L;
        int iMo1142a = this.f3561a.mo1142a();
        for (int i = 0; i < iMo1142a; i++) {
            this.f3562b += (long) this.f3561a.mo1144e(i);
        }
        return this.f3562b;
    }
}
