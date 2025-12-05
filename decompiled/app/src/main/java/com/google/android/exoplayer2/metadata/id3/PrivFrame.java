package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* loaded from: classes3.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new C10734a();

    /* renamed from: k */
    public final String f19998k;

    /* renamed from: l */
    public final byte[] f19999l;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.PrivFrame$a */
    public class C10734a implements Parcelable.Creator<PrivFrame> {
        @Override // android.os.Parcelable.Creator
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PrivFrame[] newArray(int i) {
            return new PrivFrame[i];
        }
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f19998k = str;
        this.f19999l = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return Util2.m2993a(this.f19998k, privFrame.f19998k) && Arrays.equals(this.f19999l, privFrame.f19999l);
    }

    public int hashCode() {
        String str = this.f19998k;
        return Arrays.hashCode(this.f19999l) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f19989j;
        String str2 = this.f19998k;
        return outline.m859k(outline.m841b(str2, outline.m841b(str, 8)), str, ": owner=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19998k);
        parcel.writeByteArray(this.f19999l);
    }

    public PrivFrame(Parcel parcel) {
        super("PRIV");
        String string = parcel.readString();
        int i = Util2.f6708a;
        this.f19998k = string;
        this.f19999l = parcel.createByteArray();
    }
}
