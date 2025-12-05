package p007b.p225i.p226a.p242c.p256d3;

import androidx.annotation.Nullable;

/* compiled from: TimeBar.java */
/* renamed from: b.i.a.c.d3.o, reason: use source file name */
/* loaded from: classes3.dex */
public interface TimeBar {

    /* compiled from: TimeBar.java */
    /* renamed from: b.i.a.c.d3.o$a */
    public interface a {
        /* renamed from: k */
        void mo2763k(TimeBar timeBar, long j);

        /* renamed from: l */
        void mo2764l(TimeBar timeBar, long j, boolean z2);

        /* renamed from: m */
        void mo2765m(TimeBar timeBar, long j);
    }

    /* renamed from: a */
    void mo2761a(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    /* renamed from: b */
    void mo2762b(a aVar);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z2);

    void setPosition(long j);
}
