package com.discord.utilities.analytics;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: InstallReferrer.kt */
/* renamed from: com.discord.utilities.analytics.InstallReferrer$sharedPreferences$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InstallReferrer3 extends Lambda implements Function0<SharedPreferences> {
    public static final InstallReferrer3 INSTANCE = new InstallReferrer3();

    public InstallReferrer3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SharedPreferences invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SharedPreferences invoke() {
        return SharedPreferencesProvider.INSTANCE.get();
    }
}
