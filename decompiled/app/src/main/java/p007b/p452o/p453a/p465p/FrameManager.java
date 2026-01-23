package p007b.p452o.p453a.p465p;

import android.graphics.ImageFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.LinkedBlockingQueue;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p473x.Size3;

/* JADX INFO: renamed from: b.o.a.p.c, reason: use source file name */
/* JADX INFO: compiled from: FrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FrameManager<T> {

    /* JADX INFO: renamed from: a */
    public static final CameraLogger f14058a = new CameraLogger(FrameManager.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public final int f14059b;

    /* JADX INFO: renamed from: c */
    public int f14060c = -1;

    /* JADX INFO: renamed from: d */
    public Size3 f14061d = null;

    /* JADX INFO: renamed from: e */
    public int f14062e = -1;

    /* JADX INFO: renamed from: f */
    public final Class<T> f14063f;

    /* JADX INFO: renamed from: g */
    public LinkedBlockingQueue<Frame2> f14064g;

    /* JADX INFO: renamed from: h */
    public Angles f14065h;

    public FrameManager(int i, @NonNull Class<T> cls) {
        this.f14059b = i;
        this.f14063f = cls;
        this.f14064g = new LinkedBlockingQueue<>(i);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Frame2 m7385a(@NonNull T t, long j) {
        if (!m7386b()) {
            throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
        }
        Frame2 frame2Poll = this.f14064g.poll();
        if (frame2Poll == null) {
            f14058a.m7159a(1, "getFrame for time:", Long.valueOf(j), "NOT AVAILABLE.");
            mo7380c(t, false);
            return null;
        }
        f14058a.m7159a(0, "getFrame for time:", Long.valueOf(j), "RECYCLING.");
        Angles angles = this.f14065h;
        Reference2 reference2 = Reference2.SENSOR;
        angles.m7358c(reference2, Reference2.OUTPUT, 2);
        this.f14065h.m7358c(reference2, Reference2.VIEW, 2);
        frame2Poll.f14055c = t;
        frame2Poll.f14056d = j;
        frame2Poll.f14057e = j;
        return frame2Poll;
    }

    /* JADX INFO: renamed from: b */
    public boolean m7386b() {
        return this.f14061d != null;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo7380c(@NonNull T t, boolean z2);

    /* JADX INFO: renamed from: d */
    public void mo7381d() {
        if (!m7386b()) {
            f14058a.m7159a(2, "release called twice. Ignoring.");
            return;
        }
        f14058a.m7159a(1, "release: Clearing the frame and buffer queue.");
        this.f14064g.clear();
        this.f14060c = -1;
        this.f14061d = null;
        this.f14062e = -1;
        this.f14065h = null;
    }

    /* JADX INFO: renamed from: e */
    public void mo7382e(int i, @NonNull Size3 size3, @NonNull Angles angles) {
        this.f14061d = size3;
        this.f14062e = i;
        this.f14060c = (int) Math.ceil(((double) ((size3.f14252k * size3.f14251j) * ImageFormat.getBitsPerPixel(i))) / 8.0d);
        for (int i2 = 0; i2 < this.f14059b; i2++) {
            this.f14064g.offer(new Frame2(this));
        }
        this.f14065h = angles;
    }
}
