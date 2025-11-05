package com.discord.widgets.chat.input.emoji;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiAutocompletePremiumUpsellFeatureFlag.kt */
/* loaded from: classes2.dex */
public final class EmojiAutocompletePremiumUpsellFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(EmojiAutocompletePremiumUpsellFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* compiled from: EmojiAutocompletePremiumUpsellFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final EmojiAutocompletePremiumUpsellFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = EmojiAutocompletePremiumUpsellFeatureFlag.access$getINSTANCE$cp();
            Companion companion = EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE;
            return (EmojiAutocompletePremiumUpsellFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EmojiAutocompletePremiumUpsellFeatureFlag() {
        this(null, 1, null);
    }

    public EmojiAutocompletePremiumUpsellFeatureFlag(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-03_nitro_emoji_autocomplete_upsell_android", true);
        return (userExperiment != null ? userExperiment.getBucket() : 0) != 0;
    }

    public /* synthetic */ EmojiAutocompletePremiumUpsellFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}
