package p007b.p008a.p058v;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AcknowledgedTooltipsCache.kt */
/* renamed from: b.a.v.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class AcknowledgedTooltipsCache {

    /* renamed from: a */
    public final SharedPreferences f1999a;

    public AcknowledgedTooltipsCache() {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.f1999a = sharedPreferences;
    }

    public AcknowledgedTooltipsCache(SharedPreferences sharedPreferences, int i) {
        SharedPreferences sharedPreferences2 = (i & 1) != 0 ? SharedPreferencesProvider.INSTANCE.get() : null;
        Intrinsics3.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.f1999a = sharedPreferences2;
    }
}
