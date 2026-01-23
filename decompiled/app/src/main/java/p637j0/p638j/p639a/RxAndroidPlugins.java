package p637j0.p638j.p639a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.j.a.a, reason: use source file name */
/* JADX INFO: compiled from: RxAndroidPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RxAndroidPlugins {

    /* JADX INFO: renamed from: a */
    public static final RxAndroidPlugins f26698a = new RxAndroidPlugins();

    /* JADX INFO: renamed from: b */
    public final AtomicReference<RxAndroidSchedulersHook> f26699b = new AtomicReference<>();

    /* JADX INFO: renamed from: a */
    public RxAndroidSchedulersHook m10737a() {
        if (this.f26699b.get() == null) {
            this.f26699b.compareAndSet(null, RxAndroidSchedulersHook.f26700a);
        }
        return this.f26699b.get();
    }
}
