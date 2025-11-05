package com.discord.widgets.botuikit;

import com.discord.api.botuikit.ComponentType;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComponentExperiments.kt */
/* loaded from: classes2.dex */
public final class BotComponentExperiments implements ComponentExperiments {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static BotComponentExperiments botComponentExperiments;
    private final StoreExperiments storeExperiments;

    /* compiled from: ComponentExperiments.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ComponentExperiments get(StoreExperiments storeExperiments) {
            m.checkNotNullParameter(storeExperiments, "storeExperiments");
            BotComponentExperiments botComponentExperiments = getBotComponentExperiments();
            if (botComponentExperiments != null) {
                return botComponentExperiments;
            }
            BotComponentExperiments botComponentExperiments2 = new BotComponentExperiments(storeExperiments);
            setBotComponentExperiments(botComponentExperiments2);
            return botComponentExperiments2;
        }

        public final BotComponentExperiments getBotComponentExperiments() {
            return BotComponentExperiments.access$getBotComponentExperiments$cp();
        }

        public final void setBotComponentExperiments(BotComponentExperiments botComponentExperiments) {
            BotComponentExperiments.access$setBotComponentExperiments$cp(botComponentExperiments);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ComponentType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ComponentType.UNKNOWN.ordinal()] = 1;
            iArr[ComponentType.ACTION_ROW.ordinal()] = 2;
            iArr[ComponentType.BUTTON.ordinal()] = 3;
            iArr[ComponentType.SELECT.ordinal()] = 4;
            iArr[ComponentType.TEXT.ordinal()] = 5;
        }
    }

    public BotComponentExperiments(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ BotComponentExperiments access$getBotComponentExperiments$cp() {
        return botComponentExperiments;
    }

    public static final /* synthetic */ void access$setBotComponentExperiments$cp(BotComponentExperiments botComponentExperiments2) {
        botComponentExperiments = botComponentExperiments2;
    }

    public final StoreExperiments getStoreExperiments() {
        return this.storeExperiments;
    }

    @Override // com.discord.widgets.botuikit.ComponentExperiments
    public boolean isEnabled(ComponentType componentType) {
        m.checkNotNullParameter(componentType, "componentType");
        int iOrdinal = componentType.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isExperimentEnabled(String experimentName) {
        m.checkNotNullParameter(experimentName, "experimentName");
        Experiment userExperiment = this.storeExperiments.getUserExperiment(experimentName, false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }
}
