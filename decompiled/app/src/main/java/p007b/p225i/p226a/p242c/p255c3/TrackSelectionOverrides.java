package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.ImmutableCollection;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.ImmutableMap2;
import p007b.p225i.p355b.p357b.RegularImmutableMap;

/* compiled from: TrackSelectionOverrides.java */
/* renamed from: b.i.a.c.c3.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class TrackSelectionOverrides implements Bundleable {

    /* renamed from: j */
    public static final TrackSelectionOverrides f6270j = new TrackSelectionOverrides(RegularImmutableMap.f12015m);

    /* renamed from: k */
    public static final Bundleable.a<TrackSelectionOverrides> f6271k = C2638d.f6180a;

    /* renamed from: l */
    public final ImmutableMap2<TrackGroup, a> f6272l;

    public TrackSelectionOverrides(Map<TrackGroup, a> map) {
        this.f6272l = ImmutableMap2.m6273a(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionOverrides.class != obj.getClass()) {
            return false;
        }
        return this.f6272l.equals(((TrackSelectionOverrides) obj).f6272l);
    }

    public int hashCode() {
        return this.f6272l.hashCode();
    }

    /* compiled from: TrackSelectionOverrides.java */
    /* renamed from: b.i.a.c.c3.o$a */
    public static final class a implements Bundleable {

        /* renamed from: j */
        public static final /* synthetic */ int f6273j = 0;

        /* renamed from: k */
        public final TrackGroup f6274k;

        /* renamed from: l */
        public final ImmutableList2<Integer> f6275l;

        public a(TrackGroup trackGroup) {
            this.f6274k = trackGroup;
            C3404f.m4189A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            int i2 = 0;
            while (i < trackGroup.f5661k) {
                Integer numValueOf = Integer.valueOf(i);
                Objects.requireNonNull(numValueOf);
                int i3 = i2 + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.m6260a(objArrCopyOf.length, i3));
                }
                objArrCopyOf[i2] = numValueOf;
                i++;
                i2 = i3;
            }
            this.f6275l = ImmutableList2.m6262l(objArrCopyOf, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6274k.equals(aVar.f6274k) && this.f6275l.equals(aVar.f6275l);
        }

        public int hashCode() {
            return (this.f6275l.hashCode() * 31) + this.f6274k.hashCode();
        }

        public a(TrackGroup trackGroup, List<Integer> list) {
            if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.f5661k)) {
                throw new IndexOutOfBoundsException();
            }
            this.f6274k = trackGroup;
            this.f6275l = ImmutableList2.m6264n(list);
        }
    }
}
