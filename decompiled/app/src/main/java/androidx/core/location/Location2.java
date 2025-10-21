package androidx.core.location;

import android.location.Location;
import d0.z.d.Intrinsics3;

/* compiled from: Location.kt */
/* renamed from: androidx.core.location.LocationKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Location2 {
    public static final double component1(Location location) {
        Intrinsics3.checkNotNullParameter(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        Intrinsics3.checkNotNullParameter(location, "<this>");
        return location.getLongitude();
    }
}
