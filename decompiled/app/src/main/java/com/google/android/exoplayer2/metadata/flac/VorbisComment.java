package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.p1;
import com.google.android.exoplayer2.metadata.Metadata;

/* loaded from: classes3.dex */
public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new a();
    public final String j;
    public final String k;

    public class a implements Parcelable.Creator<VorbisComment> {
        @Override // android.os.Parcelable.Creator
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public VorbisComment[] newArray(int i) {
            return new VorbisComment[i];
        }
    }

    public VorbisComment(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || VorbisComment.class != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.j.equals(vorbisComment.j) && this.k.equals(vorbisComment.k);
    }

    public int hashCode() {
        return this.k.hashCode() + b.d.b.a.a.m(this.j, 527, 31);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void n(p1.b bVar) {
        String str = this.j;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.c = this.k;
                break;
            case "TITLE":
                bVar.a = this.k;
                break;
            case "DESCRIPTION":
                bVar.g = this.k;
                break;
            case "ALBUMARTIST":
                bVar.d = this.k;
                break;
            case "ARTIST":
                bVar.f1050b = this.k;
                break;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] o0() {
        return b.i.a.c.z2.a.a(this);
    }

    public String toString() {
        String str = this.j;
        String str2 = this.k;
        return b.d.b.a.a.l(b.d.b.a.a.b(str2, b.d.b.a.a.b(str, 5)), "VC: ", str, "=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeString(this.k);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ j1 y() {
        return b.i.a.c.z2.a.b(this);
    }

    public VorbisComment(Parcel parcel) {
        String string = parcel.readString();
        int i = e0.a;
        this.j = string;
        this.k = parcel.readString();
    }
}
