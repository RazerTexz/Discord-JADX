package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* compiled from: TracksInfo.java */
/* renamed from: b.i.a.c.p2, reason: use source file name */
/* loaded from: classes3.dex */
public final class TracksInfo implements Bundleable {

    /* renamed from: j */
    public static final TracksInfo f7433j;

    /* renamed from: k */
    public final ImmutableList2<a> f7434k;

    /* compiled from: TracksInfo.java */
    /* renamed from: b.i.a.c.p2$a */
    public static final class a implements Bundleable {

        /* renamed from: j */
        public final TrackGroup f7435j;

        /* renamed from: k */
        public final int[] f7436k;

        /* renamed from: l */
        public final int f7437l;

        /* renamed from: m */
        public final boolean[] f7438m;

        public a(TrackGroup trackGroup, int[] iArr, int i, boolean[] zArr) {
            int i2 = trackGroup.f5661k;
            AnimatableValueParser.m531j(i2 == iArr.length && i2 == zArr.length);
            this.f7435j = trackGroup;
            this.f7436k = (int[]) iArr.clone();
            this.f7437l = i;
            this.f7438m = (boolean[]) zArr.clone();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7437l == aVar.f7437l && this.f7435j.equals(aVar.f7435j) && Arrays.equals(this.f7436k, aVar.f7436k) && Arrays.equals(this.f7438m, aVar.f7438m);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f7438m) + ((((Arrays.hashCode(this.f7436k) + (this.f7435j.hashCode() * 31)) * 31) + this.f7437l) * 31);
        }
    }

    static {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        f7433j = new TracksInfo(RegularImmutableList.f12012l);
    }

    public TracksInfo(List<a> list) {
        this.f7434k = ImmutableList2.m6264n(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TracksInfo.class != obj.getClass()) {
            return false;
        }
        return this.f7434k.equals(((TracksInfo) obj).f7434k);
    }

    public int hashCode() {
        return this.f7434k.hashCode();
    }
}
