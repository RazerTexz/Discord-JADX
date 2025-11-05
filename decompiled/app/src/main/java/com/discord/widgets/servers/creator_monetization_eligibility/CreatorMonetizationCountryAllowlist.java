package com.discord.widgets.servers.creator_monetization_eligibility;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CreatorMonetizationCountryAllowlist.kt */
/* loaded from: classes2.dex */
public final class CreatorMonetizationCountryAllowlist {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(CreatorMonetizationCountryAllowlist$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* compiled from: CreatorMonetizationCountryAllowlist.kt */
    public static final class Companion {
        private Companion() {
        }

        public final CreatorMonetizationCountryAllowlist getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = CreatorMonetizationCountryAllowlist.access$getINSTANCE$cp();
            Companion companion = CreatorMonetizationCountryAllowlist.INSTANCE;
            return (CreatorMonetizationCountryAllowlist) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CreatorMonetizationCountryAllowlist() {
        this(null, 1, null);
    }

    public CreatorMonetizationCountryAllowlist(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isUserInEligibleCountry() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2022-04_creator_monetization_country_allowlist", false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ CreatorMonetizationCountryAllowlist(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}
