package com.discord.widgets.mobile_reports;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReportsFeatureFlag.kt */
/* loaded from: classes2.dex */
public final class ReportsFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ReportsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean isEnabled() {
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-03_mobile_can_view_in_app_reports", true);
            return userExperiment != null && userExperiment.getBucket() == 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
