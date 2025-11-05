package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNux;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncMode;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.hubs.HubEmailArgs;
import com.discord.widgets.hubs.HubEmailEntryPoint;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.nux.WidgetGuildTemplates;
import d0.t.g0;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreNavigation.kt */
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$nuxStateNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* compiled from: StoreNavigation.kt */
    /* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$nuxStateNavHandler$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
            m.checkNotNullParameter(nuxState, "it");
            return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$nuxStateNavHandler$1(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = activityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(modelGlobalNavigation, "model");
        Experiment userExperiment = StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getExperiments().getUserExperiment("2021-04_contact_sync_android_main", modelGlobalNavigation.getNuxState().getPostRegister());
        boolean z2 = userExperiment != null && userExperiment.getBucket() == 1;
        if (!modelGlobalNavigation.getNuxState().getPostRegister()) {
            return false;
        }
        if (!z2 || modelGlobalNavigation.getNuxState().getContactSyncCompleted()) {
            StoreNotices notices = StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNotices();
            WidgetHubEmailFlow.Companion companion = WidgetHubEmailFlow.INSTANCE;
            String name = companion.getNAME();
            m.checkNotNullExpressionValue(name, "WidgetHubEmailFlow.NAME");
            if (!notices.hasBeenSeen(name) && !appActivity.h(a0.getOrCreateKotlinClass(WidgetHubEmailFlow.class)) && GrowthTeamFeatures.INSTANCE.isHubOnboardingEnabled()) {
                j.d(appActivity, WidgetHubEmailFlow.class, new HubEmailArgs(null, 0, HubEmailEntryPoint.Onboarding, 3, null));
                StoreNotices notices2 = StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNotices();
                String name2 = companion.getNAME();
                m.checkNotNullExpressionValue(name2, "WidgetHubEmailFlow.NAME");
                StoreNotices.markSeen$default(notices2, name2, 0L, 2, null);
            } else if (!appActivity.h(a0.getOrCreateKotlinClass(WidgetGuildTemplates.class)) && !appActivity.h(a0.getOrCreateKotlinClass(WidgetHome.class)) && !appActivity.h(a0.getOrCreateKotlinClass(WidgetHubEmailFlow.class))) {
                WidgetGuildTemplates.INSTANCE.launch(appActivity, CreateGuildTrigger.NUF, true);
                StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNux().updateNux(AnonymousClass1.INSTANCE);
            }
        } else if (!appActivity.h(a0.getOrCreateKotlinClass(WidgetContactSync.class))) {
            ContactSyncFlowAnalytics.INSTANCE.trackStart(true, g0.mapOf(d0.o.to("location_page", "Onboarding")));
            WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, appActivity, ContactSyncMode.ONBOARDING, false, false, false, 28, null);
        }
        return true;
    }
}
