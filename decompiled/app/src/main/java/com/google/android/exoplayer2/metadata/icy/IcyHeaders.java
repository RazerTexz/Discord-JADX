package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p279z2.Metadata2;

/* loaded from: classes3.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new C10724a();

    /* renamed from: j */
    public final int f19957j;

    /* renamed from: k */
    @Nullable
    public final String f19958k;

    /* renamed from: l */
    @Nullable
    public final String f19959l;

    /* renamed from: m */
    @Nullable
    public final String f19960m;

    /* renamed from: n */
    public final boolean f19961n;

    /* renamed from: o */
    public final int f19962o;

    /* renamed from: com.google.android.exoplayer2.metadata.icy.IcyHeaders$a */
    public class C10724a implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IcyHeaders[] newArray(int i) {
            return new IcyHeaders[i];
        }
    }

    public IcyHeaders(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z2, int i2) {
        AnimatableValueParser.m531j(i2 == -1 || i2 > 0);
        this.f19957j = i;
        this.f19958k = str;
        this.f19959l = str2;
        this.f19960m = str3;
        this.f19961n = z2;
        this.f19962o = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IcyHeaders m8881a(Map<String, List<String>> map) {
        boolean z2;
        int i;
        List<String> list;
        String str;
        List<String> list2;
        String str2;
        List<String> list3;
        String str3;
        List<String> list4;
        boolean zEquals;
        List<String> list5;
        int i2;
        List<String> list6 = map.get("icy-br");
        int i3 = -1;
        boolean z3 = true;
        if (list6 != null) {
            String str4 = list6.get(0);
            try {
                i2 = Integer.parseInt(str4) * 1000;
                if (i2 > 0) {
                    z2 = true;
                } else {
                    try {
                        String strValueOf = String.valueOf(str4);
                        Log.w("IcyHeaders", strValueOf.length() != 0 ? "Invalid bitrate: ".concat(strValueOf) : new String("Invalid bitrate: "));
                        z2 = false;
                        i2 = -1;
                    } catch (NumberFormatException unused) {
                        String strValueOf2 = String.valueOf(str4);
                        Log.w("IcyHeaders", strValueOf2.length() != 0 ? "Invalid bitrate header: ".concat(strValueOf2) : new String("Invalid bitrate header: "));
                        i = i2;
                        z2 = false;
                        list = map.get("icy-genre");
                        if (list == null) {
                        }
                        list2 = map.get("icy-name");
                        if (list2 == null) {
                        }
                        list3 = map.get("icy-url");
                        if (list3 == null) {
                        }
                        list4 = map.get("icy-pub");
                        if (list4 == null) {
                        }
                        list5 = map.get("icy-metaint");
                        if (list5 != null) {
                        }
                        if (z2) {
                        }
                    }
                }
                i = i2;
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
        } else {
            z2 = false;
            i = -1;
        }
        list = map.get("icy-genre");
        if (list == null) {
            str = list.get(0);
            z2 = true;
        } else {
            str = null;
        }
        list2 = map.get("icy-name");
        if (list2 == null) {
            str2 = list2.get(0);
            z2 = true;
        } else {
            str2 = null;
        }
        list3 = map.get("icy-url");
        if (list3 == null) {
            str3 = list3.get(0);
            z2 = true;
        } else {
            str3 = null;
        }
        list4 = map.get("icy-pub");
        if (list4 == null) {
            zEquals = list4.get(0).equals("1");
            z2 = true;
        } else {
            zEquals = false;
        }
        list5 = map.get("icy-metaint");
        if (list5 != null) {
            String str5 = list5.get(0);
            try {
                int i4 = Integer.parseInt(str5);
                if (i4 > 0) {
                    i3 = i4;
                } else {
                    try {
                        String strValueOf3 = String.valueOf(str5);
                        Log.w("IcyHeaders", strValueOf3.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf3) : new String("Invalid metadata interval: "));
                        z3 = z2;
                    } catch (NumberFormatException unused3) {
                        i3 = i4;
                        String strValueOf4 = String.valueOf(str5);
                        Log.w("IcyHeaders", strValueOf4.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf4) : new String("Invalid metadata interval: "));
                        if (z2) {
                        }
                    }
                }
                z2 = z3;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z2) {
            return new IcyHeaders(i, str, str2, str3, zEquals, i3);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.f19957j == icyHeaders.f19957j && Util2.m2993a(this.f19958k, icyHeaders.f19958k) && Util2.m2993a(this.f19959l, icyHeaders.f19959l) && Util2.m2993a(this.f19960m, icyHeaders.f19960m) && this.f19961n == icyHeaders.f19961n && this.f19962o == icyHeaders.f19962o;
    }

    public int hashCode() {
        int i = (527 + this.f19957j) * 31;
        String str = this.f19958k;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19959l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f19960m;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f19961n ? 1 : 0)) * 31) + this.f19962o;
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
        String str = this.f19959l;
        String str2 = this.f19958k;
        int i = this.f19957j;
        int i2 = this.f19962o;
        StringBuilder sbM831S = outline.m831S(outline.m841b(str2, outline.m841b(str, 80)), "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        sbM831S.append("\", bitrate=");
        sbM831S.append(i);
        sbM831S.append(", metadataInterval=");
        sbM831S.append(i2);
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19957j);
        parcel.writeString(this.f19958k);
        parcel.writeString(this.f19959l);
        parcel.writeString(this.f19960m);
        boolean z2 = this.f19961n;
        int i2 = Util2.f6708a;
        parcel.writeInt(z2 ? 1 : 0);
        parcel.writeInt(this.f19962o);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: y */
    public /* synthetic */ Format2 mo8880y() {
        return Metadata2.m3893b(this);
    }

    public IcyHeaders(Parcel parcel) {
        this.f19957j = parcel.readInt();
        this.f19958k = parcel.readString();
        this.f19959l = parcel.readString();
        this.f19960m = parcel.readString();
        int i = Util2.f6708a;
        this.f19961n = parcel.readInt() != 0;
        this.f19962o = parcel.readInt();
    }
}
