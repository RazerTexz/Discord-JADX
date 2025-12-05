package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;

/* compiled from: BaseTrackSelection.java */
/* renamed from: b.i.a.c.c3.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseTrackSelection implements ExoTrackSelection2 {

    /* renamed from: a */
    public final TrackGroup f6187a;

    /* renamed from: b */
    public final int f6188b;

    /* renamed from: c */
    public final int[] f6189c;

    /* renamed from: d */
    public final Format2[] f6190d;

    /* renamed from: e */
    public int f6191e;

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i) {
        AnimatableValueParser.m426D(iArr.length > 0);
        Objects.requireNonNull(trackGroup);
        this.f6187a = trackGroup;
        int length = iArr.length;
        this.f6188b = length;
        this.f6190d = new Format2[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f6190d[i2] = trackGroup.f5662l[iArr[i2]];
        }
        Arrays.sort(this.f6190d, C2635a.f6177j);
        this.f6189c = new int[this.f6188b];
        int i3 = 0;
        while (true) {
            int i4 = this.f6188b;
            if (i3 >= i4) {
                long[] jArr = new long[i4];
                return;
            }
            int[] iArr2 = this.f6189c;
            Format2 format2 = this.f6190d[i3];
            int i5 = 0;
            while (true) {
                Format2[] format2Arr = trackGroup.f5662l;
                if (i5 >= format2Arr.length) {
                    i5 = -1;
                    break;
                } else if (format2 == format2Arr[i5]) {
                    break;
                } else {
                    i5++;
                }
            }
            iArr2[i3] = i5;
            i3++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelection
    /* renamed from: a */
    public final TrackGroup mo2727a() {
        return this.f6187a;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: c */
    public /* synthetic */ void mo2728c(boolean z2) {
        ExoTrackSelection.m2750b(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelection
    /* renamed from: d */
    public final Format2 mo2729d(int i) {
        return this.f6190d[i];
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: e */
    public void mo2724e() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.f6187a == baseTrackSelection.f6187a && Arrays.equals(this.f6189c, baseTrackSelection.f6189c);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelection
    /* renamed from: f */
    public final int mo2730f(int i) {
        return this.f6189c[i];
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: g */
    public void mo2725g() {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: h */
    public final Format2 mo2731h() {
        return this.f6190d[mo2723b()];
    }

    public int hashCode() {
        if (this.f6191e == 0) {
            this.f6191e = Arrays.hashCode(this.f6189c) + (System.identityHashCode(this.f6187a) * 31);
        }
        return this.f6191e;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: i */
    public void mo2726i(float f) {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: j */
    public /* synthetic */ void mo2732j() {
        ExoTrackSelection.m2749a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: k */
    public /* synthetic */ void mo2733k() {
        ExoTrackSelection.m2751c(this);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelection
    /* renamed from: l */
    public final int mo2734l(int i) {
        for (int i2 = 0; i2 < this.f6188b; i2++) {
            if (this.f6189c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelection
    public final int length() {
        return this.f6189c.length;
    }
}
