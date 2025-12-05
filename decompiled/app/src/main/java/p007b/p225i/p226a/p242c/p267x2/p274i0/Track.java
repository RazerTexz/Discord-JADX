package p007b.p225i.p226a.p242c.p267x2.p274i0;

import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.Format2;

/* compiled from: Track.java */
/* renamed from: b.i.a.c.x2.i0.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class Track {

    /* renamed from: a */
    public final int f8460a;

    /* renamed from: b */
    public final int f8461b;

    /* renamed from: c */
    public final long f8462c;

    /* renamed from: d */
    public final long f8463d;

    /* renamed from: e */
    public final long f8464e;

    /* renamed from: f */
    public final Format2 f8465f;

    /* renamed from: g */
    public final int f8466g;

    /* renamed from: h */
    @Nullable
    public final long[] f8467h;

    /* renamed from: i */
    @Nullable
    public final long[] f8468i;

    /* renamed from: j */
    public final int f8469j;

    /* renamed from: k */
    @Nullable
    public final TrackEncryptionBox[] f8470k;

    public Track(int i, int i2, long j, long j2, long j3, Format2 format2, int i3, @Nullable TrackEncryptionBox[] trackEncryptionBoxArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f8460a = i;
        this.f8461b = i2;
        this.f8462c = j;
        this.f8463d = j2;
        this.f8464e = j3;
        this.f8465f = format2;
        this.f8466g = i3;
        this.f8470k = trackEncryptionBoxArr;
        this.f8469j = i4;
        this.f8467h = jArr;
        this.f8468i = jArr2;
    }

    @Nullable
    /* renamed from: a */
    public TrackEncryptionBox m3731a(int i) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.f8470k;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i];
    }
}
