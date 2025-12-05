package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.p279z2.Metadata2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* loaded from: classes3.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new C10738a();

    /* renamed from: j */
    public final long f20008j;

    /* renamed from: k */
    public final long f20009k;

    /* renamed from: l */
    public final long f20010l;

    /* renamed from: m */
    public final long f20011m;

    /* renamed from: n */
    public final long f20012n;

    /* renamed from: com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata$a */
    public class C10738a implements Parcelable.Creator<MotionPhotoMetadata> {
        @Override // android.os.Parcelable.Creator
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MotionPhotoMetadata[] newArray(int i) {
            return new MotionPhotoMetadata[i];
        }
    }

    public MotionPhotoMetadata(long j, long j2, long j3, long j4, long j5) {
        this.f20008j = j;
        this.f20009k = j2;
        this.f20010l = j3;
        this.f20011m = j4;
        this.f20012n = j5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        return this.f20008j == motionPhotoMetadata.f20008j && this.f20009k == motionPhotoMetadata.f20009k && this.f20010l == motionPhotoMetadata.f20010l && this.f20011m == motionPhotoMetadata.f20011m && this.f20012n == motionPhotoMetadata.f20012n;
    }

    public int hashCode() {
        return C3404f.m4352v0(this.f20012n) + ((C3404f.m4352v0(this.f20011m) + ((C3404f.m4352v0(this.f20010l) + ((C3404f.m4352v0(this.f20009k) + ((C3404f.m4352v0(this.f20008j) + 527) * 31)) * 31)) * 31)) * 31);
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
        long j = this.f20008j;
        long j2 = this.f20009k;
        long j3 = this.f20010l;
        long j4 = this.f20011m;
        long j5 = this.f20012n;
        StringBuilder sbM830R = outline.m830R(218, "Motion photo metadata: photoStartPosition=", j, ", photoSize=");
        sbM830R.append(j2);
        sbM830R.append(", photoPresentationTimestampUs=");
        sbM830R.append(j3);
        sbM830R.append(", videoStartPosition=");
        sbM830R.append(j4);
        sbM830R.append(", videoSize=");
        sbM830R.append(j5);
        return sbM830R.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f20008j);
        parcel.writeLong(this.f20009k);
        parcel.writeLong(this.f20010l);
        parcel.writeLong(this.f20011m);
        parcel.writeLong(this.f20012n);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: y */
    public /* synthetic */ Format2 mo8880y() {
        return Metadata2.m3893b(this);
    }

    public MotionPhotoMetadata(Parcel parcel, C10738a c10738a) {
        this.f20008j = parcel.readLong();
        this.f20009k = parcel.readLong();
        this.f20010l = parcel.readLong();
        this.f20011m = parcel.readLong();
        this.f20012n = parcel.readLong();
    }
}
