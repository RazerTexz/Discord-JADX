package androidx.core.location;

import android.location.Location;
import d0.z.d.m;

/* compiled from: Location.kt */
/* loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(Location location) {
        m.checkNotNullParameter(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        m.checkNotNullParameter(location, "<this>");
        return location.getLongitude();
    }
}
