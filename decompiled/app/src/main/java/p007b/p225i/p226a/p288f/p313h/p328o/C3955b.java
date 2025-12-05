package p007b.p225i.p226a.p288f.p313h.p328o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: b.i.a.f.h.o.b */
/* loaded from: classes3.dex */
public class C3955b {

    /* renamed from: a */
    public static final /* synthetic */ int f10492a = 0;

    static {
        C3955b.class.getClassLoader();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m5436a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
