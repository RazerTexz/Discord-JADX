package p007b.p225i.p226a.p288f.p313h.p318e;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.h.e.b */
/* loaded from: classes3.dex */
public class C3478b {

    /* renamed from: a */
    public static final /* synthetic */ int f9647a = 0;

    static {
        C3478b.class.getClassLoader();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m4406a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
