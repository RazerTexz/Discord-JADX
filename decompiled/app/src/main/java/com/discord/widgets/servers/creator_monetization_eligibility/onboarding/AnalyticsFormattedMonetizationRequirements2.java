package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.google.gson.Gson;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p017b.TypeAdapterRegistrar;
import p007b.p225i.p408d.GsonBuilder;
import p507d0.p592z.p594d.Lambda;

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
        TypeAdapterRegistrar.m147a(gsonBuilder);
        return gsonBuilder.m6851a();
    }
}
