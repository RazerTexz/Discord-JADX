package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.a.b.TypeAdapterRegistrar;
import b.i.d.GsonBuilder;
import com.google.gson.Gson;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: AnalyticsFormattedMonetizationRequirements.kt */
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.AnalyticsFormattedMonetizationRequirements$Companion$gsonInstance$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsFormattedMonetizationRequirements2 extends Lambda implements Function0<Gson> {
    public static final AnalyticsFormattedMonetizationRequirements2 INSTANCE = new AnalyticsFormattedMonetizationRequirements2();

    public AnalyticsFormattedMonetizationRequirements2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Gson invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Gson invoke() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        TypeAdapterRegistrar.a(gsonBuilder);
        return gsonBuilder.a();
    }
}
