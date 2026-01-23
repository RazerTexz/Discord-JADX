package p007b.p225i.p226a.p242c.p256d3;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.d3.o, reason: use source file name */
/* JADX INFO: compiled from: TimeBar.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TimeBar {

    /* JADX INFO: renamed from: b.i.a.c.d3.o$a */
    /* JADX INFO: compiled from: TimeBar.java */
    public interface a {
        /* JADX INFO: renamed from: k */
        void mo2763k(TimeBar timeBar, long j);

        /* JADX INFO: renamed from: l */
        void mo2764l(TimeBar timeBar, long j, boolean z2);

        /* JADX INFO: renamed from: m */
        void mo2765m(TimeBar timeBar, long j);
    }

    /* JADX INFO: renamed from: a */
    void mo2761a(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    /* JADX INFO: renamed from: b */
    void mo2762b(a aVar);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z2);

    void setPosition(long j);
}
