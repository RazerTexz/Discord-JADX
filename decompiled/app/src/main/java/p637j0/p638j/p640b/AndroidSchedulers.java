package p637j0.p638j.p640b;

import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.p638j.p639a.RxAndroidPlugins;
import p658rx.Scheduler;

/* JADX INFO: renamed from: j0.j.b.a, reason: use source file name */
/* JADX INFO: compiled from: AndroidSchedulers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidSchedulers {

    /* JADX INFO: renamed from: a */
    public static final AtomicReference<AndroidSchedulers> f26701a = new AtomicReference<>();

    /* JADX INFO: renamed from: b */
    public final Scheduler f26702b;

    public AndroidSchedulers() {
        Objects.requireNonNull(RxAndroidPlugins.f26698a.m10737a());
        this.f26702b = new LooperScheduler(Looper.getMainLooper());
    }

    /* JADX INFO: renamed from: a */
    public static Scheduler m10738a() {
        AtomicReference<AndroidSchedulers> atomicReference;
        AndroidSchedulers androidSchedulers;
        do {
            atomicReference = f26701a;
            androidSchedulers = atomicReference.get();
            if (androidSchedulers != null) {
                break;
            }
            androidSchedulers = new AndroidSchedulers();
        } while (!atomicReference.compareAndSet(null, androidSchedulers));
        return androidSchedulers.f26702b;
    }
}
