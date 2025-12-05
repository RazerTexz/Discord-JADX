package p007b.p225i.p226a.p242c.p243a3;

import java.io.IOException;
import p007b.p225i.p226a.p242c.SeekParameters;
import p007b.p225i.p226a.p242c.p243a3.SequenceableLoader;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;

/* compiled from: MediaPeriod.java */
/* renamed from: b.i.a.c.a3.x, reason: use source file name */
/* loaded from: classes3.dex */
public interface MediaPeriod extends SequenceableLoader {

    /* compiled from: MediaPeriod.java */
    /* renamed from: b.i.a.c.a3.x$a */
    public interface a extends SequenceableLoader.a<MediaPeriod> {
        /* renamed from: b */
        void mo2563b(MediaPeriod mediaPeriod);
    }

    /* renamed from: c */
    long mo2479c();

    /* renamed from: e */
    void mo2481e() throws IOException;

    /* renamed from: f */
    long mo2482f(long j);

    /* renamed from: g */
    boolean mo2483g(long j);

    /* renamed from: h */
    boolean mo2484h();

    /* renamed from: i */
    long mo2485i(long j, SeekParameters seekParameters);

    /* renamed from: k */
    long mo2487k();

    /* renamed from: l */
    void mo2488l(a aVar, long j);

    /* renamed from: m */
    long mo2489m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    /* renamed from: n */
    TrackGroupArray mo2490n();

    /* renamed from: q */
    long mo2493q();

    /* renamed from: r */
    void mo2494r(long j, boolean z2);

    /* renamed from: s */
    void mo2495s(long j);
}
