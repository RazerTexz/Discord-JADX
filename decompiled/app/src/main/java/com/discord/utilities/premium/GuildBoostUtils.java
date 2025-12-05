package com.discord.utilities.premium;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.guilds.GuildConstants;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p508a0.MathJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: GuildBoostUtils.kt */
/* loaded from: classes2.dex */
public final class GuildBoostUtils {
    public static final int DEFAULT_GUILD_BOOST_GUILD_COUNT = 1;
    public static final int DEFAULT_GUILD_BOOST_SLOT_COUNT = 1;
    public static final int GUILD_BOOST_COOLDOWN_DAYS = 7;
    public static final GuildBoostUtils INSTANCE = new GuildBoostUtils();

    /* compiled from: GuildBoostUtils.kt */
    public enum ModifyGuildBoostSlotResult {
        SUCCESS,
        FAILURE_MODIFYING_SLOT,
        FAILURE_UPDATING_SUBSCRIPTION
    }

    /* compiled from: GuildBoostUtils.kt */
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$1 */
    public static final class C68361<T> implements Action1<ModelGuildBoostSlot> {
        public final /* synthetic */ StoreGuildBoost $storeGuildBoost;

        public C68361(StoreGuildBoost storeGuildBoost) {
            this.$storeGuildBoost = storeGuildBoost;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelGuildBoostSlot modelGuildBoostSlot) {
            call2(modelGuildBoostSlot);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelGuildBoostSlot modelGuildBoostSlot) {
            StoreGuildBoost storeGuildBoost = this.$storeGuildBoost;
            Intrinsics3.checkNotNullExpressionValue(modelGuildBoostSlot, "it");
            storeGuildBoost.updateGuildBoostSlot(modelGuildBoostSlot);
        }
    }

    /* compiled from: GuildBoostUtils.kt */
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$2 */
    public static final class C68372<T, R> implements Func1<ModelGuildBoostSlot, Boolean> {
        public static final C68372 INSTANCE = new C68372();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(ModelGuildBoostSlot modelGuildBoostSlot) {
            return call2(modelGuildBoostSlot);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(ModelGuildBoostSlot modelGuildBoostSlot) {
            return Boolean.TRUE;
        }
    }

    /* compiled from: GuildBoostUtils.kt */
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$3 */
    public static final class C68383<T, R> implements Func1<Throwable, Boolean> {
        public static final C68383 INSTANCE = new C68383();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Throwable th) {
            return Boolean.FALSE;
        }
    }

    /* compiled from: GuildBoostUtils.kt */
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$4 */
    public static final class C68394<T, R> implements Func1<Boolean, Observable<? extends ModifyGuildBoostSlotResult>> {
        public final /* synthetic */ RestAPI $api;
        public final /* synthetic */ boolean $cancel;
        public final /* synthetic */ ModelSubscription $subscription;

        /* compiled from: GuildBoostUtils.kt */
        /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$4$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Void, ModifyGuildBoostSlotResult> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ ModifyGuildBoostSlotResult call(Void r1) {
                return call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ModifyGuildBoostSlotResult call2(Void r1) {
                return ModifyGuildBoostSlotResult.SUCCESS;
            }
        }

        /* compiled from: GuildBoostUtils.kt */
        /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$4$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<Throwable, ModifyGuildBoostSlotResult> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ ModifyGuildBoostSlotResult call(Throwable th) {
                return call2(th);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ModifyGuildBoostSlotResult call2(Throwable th) {
                return ModifyGuildBoostSlotResult.FAILURE_UPDATING_SUBSCRIPTION;
            }
        }

        public C68394(RestAPI restAPI, ModelSubscription modelSubscription, boolean z2) {
            this.$api = restAPI;
            this.$subscription = modelSubscription;
            this.$cancel = z2;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ModifyGuildBoostSlotResult> call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModifyGuildBoostSlotResult> call2(Boolean bool) {
            if (bool.booleanValue()) {
                return this.$api.updateSubscription(this.$subscription.getId(), new RestAPIParams.UpdateSubscription(null, null, null, GuildBoostUtils.INSTANCE.calculateAdditionalPlansWithGuildBoostAdjustment(this.$subscription, this.$cancel ? -1 : 1), 7, null)).m11083G(AnonymousClass1.INSTANCE).m11087M(AnonymousClass2.INSTANCE);
            }
            return new ScalarSynchronousObservable(ModifyGuildBoostSlotResult.FAILURE_MODIFYING_SLOT);
        }
    }

    private GuildBoostUtils() {
    }

    public static /* synthetic */ int calculatePercentToNextTier$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.calculatePercentToNextTier(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int calculateTotalProgress$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.calculateTotalProgress(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int getBoostTier$default(GuildBoostUtils guildBoostUtils, long j, int i, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.getBoostTier(j, i, storeExperiments2, storeGuilds);
    }

    private final GuildBoostTierAmounts getBoostTierAmounts(long guildId, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Guild guild = storeGuilds.getGuild(guildId);
        boolean z2 = false;
        boolean z3 = guild != null && guild.hasFeature(GuildFeature.BOOSTING_TIERS_EXPERIMENT_SMALL_GUILD);
        Guild guild2 = storeGuilds.getGuild(guildId);
        if (guild2 != null && guild2.hasFeature(GuildFeature.BOOSTING_TIERS_EXPERIMENT_MEDIUM_GUILD)) {
            z2 = true;
        }
        Experiment guildExperiment = storeExperiments.getGuildExperiment("2022-03_boosting_tiers_small_guilds", guildId, z3);
        Experiment guildExperiment2 = storeExperiments.getGuildExperiment("2022-03_boosting_tiers_medium_guilds", guildId, z2);
        return (!z3 || ((guildExperiment == null || guildExperiment.getBucket() != 1) && (guildExperiment == null || guildExperiment.getBucket() != 2))) ? (!z2 || ((guildExperiment2 == null || guildExperiment2.getBucket() != 1) && (guildExperiment2 == null || guildExperiment2.getBucket() != 2))) ? GuildConstants.getGUILD_BOOST_TIER_AMOUNTS() : GuildConstants.getGUILD_BOOST_TIER_AMOUNTS_EXP_MEDIUM_GUILDS() : GuildConstants.getGUILD_BOOST_TIER_AMOUNTS_EXP_SMALL_GUILDS();
    }

    public static /* synthetic */ int getBoostsRequiredForTier$default(GuildBoostUtils guildBoostUtils, long j, int i, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.getBoostsRequiredForTier(j, i, storeExperiments2, storeGuilds);
    }

    private final int getCurrentTierSubs(GuildBoostTierAmounts boostTierAmounts, int premiumTier) {
        if (premiumTier == 1) {
            return boostTierAmounts.getTier1Boosts();
        }
        if (premiumTier == 2) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (premiumTier != 3) {
            return 0;
        }
        return boostTierAmounts.getTier3Boosts();
    }

    private final int getNextTierSubs(GuildBoostTierAmounts boostTierAmounts, int premiumTier) {
        if (premiumTier == 1) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (premiumTier == 2) {
            return boostTierAmounts.getTier3Boosts();
        }
        if (premiumTier != 3) {
            return boostTierAmounts.getTier1Boosts();
        }
        return 0;
    }

    private final Observable<ModifyGuildBoostSlotResult> modifyGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, boolean cancel, StoreGuildBoost storeGuildBoost) {
        Observable<ModifyGuildBoostSlotResult> observableM11082A = (cancel ? api.cancelSubscriptionSlot(slotId) : api.uncancelSubscriptionSlot(slotId)).m11098X(Schedulers2.m10875c()).m11115u(new C68361(storeGuildBoost)).m11083G(C68372.INSTANCE).m11087M(C68383.INSTANCE).m11082A(new C68394(api, subscription, cancel));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "apiObs\n        .subscrib…N }\n          }\n        }");
        return observableM11082A;
    }

    public final List<ModelSubscription.SubscriptionAdditionalPlan> calculateAdditionalPlansWithGuildBoostAdjustment(ModelSubscription subscription, int guildBoostAdjustment) {
        Object next;
        Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        ModelSubscription.SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
        List<ModelSubscription.SubscriptionAdditionalPlan> premiumAdditionalPlans = renewalMutations == null ? subscription.getPremiumAdditionalPlans() : renewalMutations.getPremiumAdditionalPlans();
        Iterator<T> it = premiumAdditionalPlans.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan = (ModelSubscription.SubscriptionAdditionalPlan) next;
            if (subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()) {
                break;
            }
        }
        ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan2 = (ModelSubscription.SubscriptionAdditionalPlan) next;
        int quantity = (subscriptionAdditionalPlan2 != null ? subscriptionAdditionalPlan2.getQuantity() : 0) + guildBoostAdjustment;
        if (quantity < 0 || subscriptionAdditionalPlan2 == null) {
            Logger.e$default(AppLog.f14950g, "Error calculating additional_plans adjustment, new sub count:" + quantity, null, null, 6, null);
            return subscription.getPremiumAdditionalPlans();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : premiumAdditionalPlans) {
            ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan3 = (ModelSubscription.SubscriptionAdditionalPlan) obj;
            if ((subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()) ? false : true) {
                arrayList.add(obj);
            }
        }
        return quantity == 0 ? arrayList : _Collections.plus((Collection) arrayList, (Iterable) CollectionsJVM.listOf(new ModelSubscription.SubscriptionAdditionalPlan(subscriptionAdditionalPlan2.getPlanId(), quantity)));
    }

    public final int calculatePercentToNextTier(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        return MathJVM.roundToInt(((subscriptionCount - getCurrentTierSubs(boostTierAmounts, premiumTier)) / getNextTierSubs(boostTierAmounts, premiumTier)) * 100);
    }

    public final int calculateTotalProgress(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        int nextTierSubs = getNextTierSubs(boostTierAmounts, premiumTier);
        int currentTierSubs = getCurrentTierSubs(boostTierAmounts, premiumTier);
        return MathJVM.roundToInt((((subscriptionCount - currentTierSubs) / (nextTierSubs - currentTierSubs)) * 33.3f) + (premiumTier * 33.3f));
    }

    public final Observable<ModifyGuildBoostSlotResult> cancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        Intrinsics3.checkNotNullParameter(api, "api");
        Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, true, storeGuildBoost);
    }

    public final int getBoostTier(long guildId, int guildBoostCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        if (guildBoostCount >= boostTierAmounts.getTier3Boosts()) {
            return 3;
        }
        if (guildBoostCount >= boostTierAmounts.getTier2Boosts()) {
            return 2;
        }
        return guildBoostCount >= boostTierAmounts.getTier1Boosts() ? 1 : 0;
    }

    public final int getBoostsRequiredForTier(long guildId, int tier, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        if (tier == 1) {
            return boostTierAmounts.getTier1Boosts();
        }
        if (tier == 2) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (tier != 3) {
            return 0;
        }
        return boostTierAmounts.getTier3Boosts();
    }

    public final Observable<ModifyGuildBoostSlotResult> uncancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        Intrinsics3.checkNotNullParameter(api, "api");
        Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, false, storeGuildBoost);
    }
}
