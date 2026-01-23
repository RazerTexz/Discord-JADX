package p007b.p109f.p148h.p149a.p151b.p154f;

import p007b.p109f.p148h.p149a.p150a.AnimationInformation;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableBackend;
import p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendImpl;

/* JADX INFO: renamed from: b.f.h.a.b.f.a, reason: use source file name */
/* JADX INFO: compiled from: AnimatedDrawableBackendAnimationInformation.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawableBackendAnimationInformation implements AnimationInformation {

    /* JADX INFO: renamed from: a */
    public final AnimatedDrawableBackend f3526a;

    public AnimatedDrawableBackendAnimationInformation(AnimatedDrawableBackend animatedDrawableBackend) {
        this.f3526a = animatedDrawableBackend;
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationInformation
    /* JADX INFO: renamed from: a */
    public int mo1142a() {
        return ((AnimatedDrawableBackendImpl) this.f3526a).m1196b();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationInformation
    /* JADX INFO: renamed from: b */
    public int mo1143b() {
        return ((AnimatedDrawableBackendImpl) this.f3526a).f3626c.mo1178b();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationInformation
    /* JADX INFO: renamed from: e */
    public int mo1144e(int i) {
        return ((AnimatedDrawableBackendImpl) this.f3526a).f3628e[i];
    }
}
