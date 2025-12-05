package p007b.p225i.p361c.p365k.p367d;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* renamed from: b.i.c.k.d.a */
/* loaded from: classes3.dex */
public final class C4563a implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final zza createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        String strM468R4 = null;
        zzc zzcVar = null;
        String strM468R5 = null;
        Bundle bundleM453M = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strM468R = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 2:
                    strM468R2 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 3:
                    strM468R3 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 4:
                    strM468R4 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 5:
                    zzcVar = (zzc) AnimatableValueParser.m465Q(parcel, i, zzc.CREATOR);
                    break;
                case 6:
                    strM468R5 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 7:
                    bundleM453M = AnimatableValueParser.m453M(parcel, i);
                    break;
                default:
                    AnimatableValueParser.m510d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zza(strM468R, strM468R2, strM468R3, strM468R4, zzcVar, strM468R5, bundleM453M);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
