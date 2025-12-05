package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Store.kt */
/* loaded from: classes2.dex */
public class Store {
    public final SharedPreferences getPrefs() {
        return SharedPreferencesProvider.INSTANCE.get();
    }

    public final SharedPreferences getPrefsSessionDurable() {
        return SharedPreferencesProvider.INSTANCE.getPrefsSessionDurable();
    }

    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
    }
}
