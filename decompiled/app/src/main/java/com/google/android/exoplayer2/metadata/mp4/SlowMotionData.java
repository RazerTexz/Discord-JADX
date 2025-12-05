package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p279z2.Metadata2;

/* loaded from: classes3.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new C10740a();

    /* renamed from: j */
    public final List<Segment> f20013j;

    public static final class Segment implements Parcelable {
        public static final Parcelable.Creator<Segment> CREATOR = new C10739a();

        /* renamed from: j */
        public final long f20014j;

        /* renamed from: k */
        public final long f20015k;

        /* renamed from: l */
        public final int f20016l;

        /* renamed from: com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment$a */
        public class C10739a implements Parcelable.Creator<Segment> {
            @Override // android.os.Parcelable.Creator
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public Segment[] newArray(int i) {
                return new Segment[i];
            }
        }

        public Segment(long j, long j2, int i) {
            AnimatableValueParser.m531j(j < j2);
            this.f20014j = j;
            this.f20015k = j2;
            this.f20016l = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.f20014j == segment.f20014j && this.f20015k == segment.f20015k && this.f20016l == segment.f20016l;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.f20014j), Long.valueOf(this.f20015k), Integer.valueOf(this.f20016l)});
        }

        public String toString() {
            return Util2.m3003k("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f20014j), Long.valueOf(this.f20015k), Integer.valueOf(this.f20016l));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f20014j);
            parcel.writeLong(this.f20015k);
            parcel.writeInt(this.f20016l);
        }
    }

    /* renamed from: com.google.android.exoplayer2.metadata.mp4.SlowMotionData$a */
    public class C10740a implements Parcelable.Creator<SlowMotionData> {
        @Override // android.os.Parcelable.Creator
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public SlowMotionData[] newArray(int i) {
            return new SlowMotionData[i];
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.f20013j = list;
        boolean z2 = false;
        if (!list.isEmpty()) {
            long j = list.get(0).f20015k;
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (list.get(i).f20014j < j) {
                    z2 = true;
                    break;
                } else {
                    j = list.get(i).f20015k;
                    i++;
                }
            }
        }
        AnimatableValueParser.m531j(!z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f20013j.equals(((SlowMotionData) obj).f20013j);
    }

    public int hashCode() {
        return this.f20013j.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: n */
    public /* synthetic */ void mo8878n(MediaMetadata.b bVar) {
        Metadata2.m3894c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return Metadata2.m3892a(this);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f20013j);
        return outline.m857j(strValueOf.length() + 21, "SlowMotion: segments=", strValueOf);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f20013j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: y */
    public /* synthetic */ Format2 mo8880y() {
        return Metadata2.m3893b(this);
    }
}
