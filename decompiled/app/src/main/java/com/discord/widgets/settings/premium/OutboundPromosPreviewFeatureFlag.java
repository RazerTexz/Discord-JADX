package com.discord.widgets.settings.premium;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.Intrinsics3;

/* compiled from: OutboundPromosPreviewFeatureFlag.kt */
/* loaded from: classes2.dex */
public final class OutboundPromosPreviewFeatureFlag {
    private final StoreExperiments storeExperiments;

    public OutboundPromosPreviewFeatureFlag(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-06_preview_promotions", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }
}
