package b.i.a.c.d3;

import androidx.annotation.Nullable;

/* compiled from: TimeBar.java */
/* loaded from: classes3.dex */
public interface o {

    /* compiled from: TimeBar.java */
    public interface a {
        void k(o oVar, long j);

        void l(o oVar, long j, boolean z2);

        void m(o oVar, long j);
    }

    void a(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    void b(a aVar);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z2);

    void setPosition(long j);
}
