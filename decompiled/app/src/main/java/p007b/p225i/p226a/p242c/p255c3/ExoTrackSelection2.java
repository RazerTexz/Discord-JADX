package p007b.p225i.p226a.p242c.p255c3;

import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;

/* JADX INFO: renamed from: b.i.a.c.c3.j, reason: use source file name */
/* JADX INFO: compiled from: ExoTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ExoTrackSelection2 extends TrackSelection {

    /* JADX INFO: renamed from: b.i.a.c.c3.j$b */
    /* JADX INFO: compiled from: ExoTrackSelection.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b */
    int mo2723b();

    /* JADX INFO: renamed from: c */
    void mo2728c(boolean z2);

    /* JADX INFO: renamed from: e */
    void mo2724e();

    /* JADX INFO: renamed from: g */
    void mo2725g();

    /* JADX INFO: renamed from: h */
    Format2 mo2731h();

    /* JADX INFO: renamed from: i */
    void mo2726i(float f);

    /* JADX INFO: renamed from: j */
    void mo2732j();

    /* JADX INFO: renamed from: k */
    void mo2733k();

    /* JADX INFO: renamed from: b.i.a.c.c3.j$a */
    /* JADX INFO: compiled from: ExoTrackSelection.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final TrackGroup f6259a;

        /* JADX INFO: renamed from: b */
        public final int[] f6260b;

        /* JADX INFO: renamed from: c */
        public final int f6261c;

        public a(TrackGroup trackGroup, int... iArr) {
            this.f6259a = trackGroup;
            this.f6260b = iArr;
            this.f6261c = 0;
        }

        public a(TrackGroup trackGroup, int[] iArr, int i) {
            this.f6259a = trackGroup;
            this.f6260b = iArr;
            this.f6261c = i;
        }
    }
}
