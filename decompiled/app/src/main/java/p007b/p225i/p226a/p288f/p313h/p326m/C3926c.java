package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: b.i.a.f.h.m.c */
/* loaded from: classes3.dex */
public class C3926c {

    /* renamed from: a */
    public static final /* synthetic */ int f10449a = 0;

    static {
        C3926c.class.getClassLoader();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m5401a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* renamed from: b */
    public static void m5402b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
