package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.io.IOException;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* JADX INFO: renamed from: b.i.a.c.a3.a0, reason: use source file name */
/* JADX INFO: compiled from: MediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaSource2 {

    /* JADX INFO: renamed from: b.i.a.c.a3.a0$a */
    /* JADX INFO: compiled from: MediaSource.java */
    public static final class a extends MediaPeriodId {
        public a(Object obj) {
            super(obj);
        }

        /* JADX INFO: renamed from: b */
        public a m2460b(Object obj) {
            return new a(this.f5732a.equals(obj) ? this : new MediaPeriodId(obj, this.f5733b, this.f5734c, this.f5735d, this.f5736e));
        }

        public a(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public a(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public a(MediaPeriodId mediaPeriodId) {
            super(mediaPeriodId);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.a0$b */
    /* JADX INFO: compiled from: MediaSource.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo2445a(MediaSource2 mediaSource2, Timeline timeline);
    }

    /* JADX INFO: renamed from: a */
    void mo2446a(b bVar);

    /* JADX INFO: renamed from: b */
    void mo2447b(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    /* JADX INFO: renamed from: c */
    void mo2448c(MediaSourceEventListener mediaSourceEventListener);

    /* JADX INFO: renamed from: d */
    void mo2449d(b bVar);

    /* JADX INFO: renamed from: e */
    MediaItem2 mo2450e();

    /* JADX INFO: renamed from: f */
    void mo2451f(Handler handler, DrmSessionEventListener drmSessionEventListener);

    /* JADX INFO: renamed from: g */
    void mo2452g(DrmSessionEventListener drmSessionEventListener);

    /* JADX INFO: renamed from: h */
    void mo2453h() throws IOException;

    /* JADX INFO: renamed from: i */
    boolean mo2454i();

    /* JADX INFO: renamed from: j */
    void mo2455j(MediaPeriod mediaPeriod);

    @Nullable
    /* JADX INFO: renamed from: k */
    Timeline mo2456k();

    /* JADX INFO: renamed from: l */
    void mo2457l(b bVar, @Nullable TransferListener transferListener);

    /* JADX INFO: renamed from: m */
    void mo2458m(b bVar);

    /* JADX INFO: renamed from: n */
    MediaPeriod mo2459n(a aVar, DefaultAllocator defaultAllocator, long j);
}
