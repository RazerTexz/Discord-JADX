package p007b.p109f.p148h.p149a.p157e;

import androidx.annotation.VisibleForTesting;
import p007b.p109f.p148h.p149a.p150a.AnimationInformation;

/* compiled from: DropFramesFrameScheduler.java */
/* renamed from: b.f.h.a.e.a, reason: use source file name */
/* loaded from: classes.dex */
public class DropFramesFrameScheduler {

    /* renamed from: a */
    public final AnimationInformation f3561a;

    /* renamed from: b */
    public long f3562b = -1;

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        this.f3561a = animationInformation;
    }

    @VisibleForTesting
    /* renamed from: a */
    public int m1166a(long j) {
        int i = 0;
        long jMo1144e = 0;
        do {
            jMo1144e += this.f3561a.mo1144e(i);
            i++;
        } while (j >= jMo1144e);
        return i - 1;
    }

    /* renamed from: b */
    public long m1167b() {
        long j = this.f3562b;
        if (j != -1) {
            return j;
        }
        this.f3562b = 0L;
        int iMo1142a = this.f3561a.mo1142a();
        for (int i = 0; i < iMo1142a; i++) {
            this.f3562b += this.f3561a.mo1144e(i);
        }
        return this.f3562b;
    }
}
