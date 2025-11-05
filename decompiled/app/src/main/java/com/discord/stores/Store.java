package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.z.d.m;

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
        m.checkNotNullParameter(context, "context");
    }
}
