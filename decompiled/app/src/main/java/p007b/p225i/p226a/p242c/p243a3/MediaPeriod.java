package p007b.p225i.p226a.p242c.p243a3;

import java.io.IOException;
import p007b.p225i.p226a.p242c.SeekParameters;
import p007b.p225i.p226a.p242c.p243a3.SequenceableLoader;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;

/* JADX INFO: renamed from: b.i.a.c.a3.x, reason: use source file name */
/* JADX INFO: compiled from: MediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaPeriod extends SequenceableLoader {

    /* JADX INFO: renamed from: b.i.a.c.a3.x$a */
    /* JADX INFO: compiled from: MediaPeriod.java */
    public interface a extends SequenceableLoader.a<MediaPeriod> {
        /* JADX INFO: renamed from: b */
        void mo2563b(MediaPeriod mediaPeriod);
    }

    /* JADX INFO: renamed from: c */
    long mo2479c();

    /* JADX INFO: renamed from: e */
    void mo2481e() throws IOException;

    /* JADX INFO: renamed from: f */
    long mo2482f(long j);

    /* JADX INFO: renamed from: g */
    boolean mo2483g(long j);

    /* JADX INFO: renamed from: h */
    boolean mo2484h();

    /* JADX INFO: renamed from: i */
    long mo2485i(long j, SeekParameters seekParameters);

    /* JADX INFO: renamed from: k */
    long mo2487k();

    /* JADX INFO: renamed from: l */
    void mo2488l(a aVar, long j);

    /* JADX INFO: renamed from: m */
    long mo2489m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    /* JADX INFO: renamed from: n */
    TrackGroupArray mo2490n();

    /* JADX INFO: renamed from: q */
    long mo2493q();

    /* JADX INFO: renamed from: r */
    void mo2494r(long j, boolean z2);

    /* JADX INFO: renamed from: s */
    void mo2495s(long j);
}
