package p007b.p452o.p453a.p465p;

import androidx.annotation.NonNull;
import p007b.p452o.p453a.CameraLogger;

/* compiled from: Frame.java */
/* renamed from: b.o.a.p.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Frame2 {

    /* renamed from: a */
    public static final CameraLogger f14053a = new CameraLogger(Frame2.class.getSimpleName());

    /* renamed from: b */
    public final FrameManager f14054b;

    /* renamed from: c */
    public Object f14055c = null;

    /* renamed from: d */
    public long f14056d = -1;

    /* renamed from: e */
    public long f14057e = -1;

    public Frame2(@NonNull FrameManager frameManager) {
        this.f14054b = frameManager;
    }

    /* renamed from: a */
    public long m7383a() {
        if (this.f14055c != null) {
            return this.f14056d;
        }
        f14053a.m7159a(3, "Frame is dead! time:", Long.valueOf(this.f14056d), "lastTime:", Long.valueOf(this.f14057e));
        throw new RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
    }

    /* renamed from: b */
    public void m7384b() {
        if (this.f14055c != null) {
            f14053a.m7159a(0, "Frame with time", Long.valueOf(this.f14056d), "is being released.");
            Object obj = this.f14055c;
            this.f14055c = null;
            this.f14056d = -1L;
            FrameManager frameManager = this.f14054b;
            if (frameManager.m7386b()) {
                frameManager.mo7380c(obj, frameManager.f14064g.offer(this));
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Frame2) && ((Frame2) obj).f14056d == this.f14056d;
    }
}
