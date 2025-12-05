package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new C0025a();

    /* renamed from: j */
    public int f54j;

    /* renamed from: k */
    public int f55k;

    /* renamed from: l */
    public int f56l;

    /* renamed from: m */
    public int f57m;

    /* renamed from: n */
    public int f58n;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$a */
    public class C0025a implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f54j = parcel.readInt();
        this.f56l = parcel.readInt();
        this.f57m = parcel.readInt();
        this.f58n = parcel.readInt();
        this.f55k = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f54j);
        parcel.writeInt(this.f56l);
        parcel.writeInt(this.f57m);
        parcel.writeInt(this.f58n);
        parcel.writeInt(this.f55k);
    }
}
