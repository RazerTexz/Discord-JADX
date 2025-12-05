package p007b.p225i.p226a.p242c.p255c3;

import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;

/* compiled from: ExoTrackSelection.java */
/* renamed from: b.i.a.c.c3.j, reason: use source file name */
/* loaded from: classes3.dex */
public interface ExoTrackSelection2 extends TrackSelection {

    /* compiled from: ExoTrackSelection.java */
    /* renamed from: b.i.a.c.c3.j$b */
    public interface b {
    }

    /* renamed from: b */
    int mo2723b();

    /* renamed from: c */
    void mo2728c(boolean z2);

    /* renamed from: e */
    void mo2724e();

    /* renamed from: g */
    void mo2725g();

    /* renamed from: h */
    Format2 mo2731h();

    /* renamed from: i */
    void mo2726i(float f);

    /* renamed from: j */
    void mo2732j();

    /* renamed from: k */
    void mo2733k();

    /* compiled from: ExoTrackSelection.java */
    /* renamed from: b.i.a.c.c3.j$a */
    public static final class a {

        /* renamed from: a */
        public final TrackGroup f6259a;

        /* renamed from: b */
        public final int[] f6260b;

        /* renamed from: c */
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
