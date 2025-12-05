package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p279z2.Metadata2;

/* loaded from: classes3.dex */
public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new C10723a();

    /* renamed from: j */
    public final String f19955j;

    /* renamed from: k */
    public final String f19956k;

    /* renamed from: com.google.android.exoplayer2.metadata.flac.VorbisComment$a */
    public class C10723a implements Parcelable.Creator<VorbisComment> {
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
        this.f19955j = str;
        this.f19956k = str2;
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
        return this.f19955j.equals(vorbisComment.f19955j) && this.f19956k.equals(vorbisComment.f19956k);
    }

    public int hashCode() {
        return this.f19956k.hashCode() + outline.m863m(this.f19955j, 527, 31);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: n */
    public void mo8878n(MediaMetadata.b bVar) {
        String str = this.f19955j;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.f7409c = this.f19956k;
                break;
            case "TITLE":
                bVar.f7407a = this.f19956k;
                break;
            case "DESCRIPTION":
                bVar.f7413g = this.f19956k;
                break;
            case "ALBUMARTIST":
                bVar.f7410d = this.f19956k;
                break;
            case "ARTIST":
                bVar.f7408b = this.f19956k;
                break;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return Metadata2.m3892a(this);
    }

    public String toString() {
        String str = this.f19955j;
        String str2 = this.f19956k;
        return outline.m861l(outline.m841b(str2, outline.m841b(str, 5)), "VC: ", str, "=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19955j);
        parcel.writeString(this.f19956k);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: y */
    public /* synthetic */ Format2 mo8880y() {
        return Metadata2.m3893b(this);
    }

    public VorbisComment(Parcel parcel) {
        String string = parcel.readString();
        int i = Util2.f6708a;
        this.f19955j = string;
        this.f19956k = parcel.readString();
    }
}
