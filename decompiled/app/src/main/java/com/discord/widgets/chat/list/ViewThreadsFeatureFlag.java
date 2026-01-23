package com.discord.widgets.chat.list;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ViewThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewThreadsFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(ViewThreadsFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* JADX INFO: compiled from: ViewThreadsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ViewThreadsFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = ViewThreadsFeatureFlag.access$getINSTANCE$cp();
            Companion companion = ViewThreadsFeatureFlag.INSTANCE;
            return (ViewThreadsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ViewThreadsFeatureFlag() {
        this(null, 1, null);
    }

    public ViewThreadsFeatureFlag(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-02_view_threads", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ ViewThreadsFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}
