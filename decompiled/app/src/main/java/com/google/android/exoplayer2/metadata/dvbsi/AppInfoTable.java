package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.p279z2.Metadata2;

/* loaded from: classes3.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new C10720a();

    /* renamed from: j */
    public final int f19937j;

    /* renamed from: k */
    public final String f19938k;

    /* renamed from: com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable$a */
    public class C10720a implements Parcelable.Creator<AppInfoTable> {
        @Override // android.os.Parcelable.Creator
        public AppInfoTable createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            Objects.requireNonNull(string);
            return new AppInfoTable(parcel.readInt(), string);
        }

        @Override // android.os.Parcelable.Creator
        public AppInfoTable[] newArray(int i) {
            return new AppInfoTable[i];
        }
    }

    public AppInfoTable(int i, String str) {
        this.f19937j = i;
        this.f19938k = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        int i = this.f19937j;
        String str = this.f19938k;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append("Ait(controlCode=");
        sb.append(i);
        sb.append(",url=");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19938k);
        parcel.writeInt(this.f19937j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: y */
    public /* synthetic */ Format2 mo8880y() {
        return Metadata2.m3893b(this);
    }
}
