package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNux;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncMode;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.guilds.invite.WidgetGuildInvite;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.Tuples;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6280x79e1178 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNavigation.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 60, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6280x79e1178(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = activityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        StoreInviteSettings.InviteCode inviteCode = modelGlobalNavigation.getInviteCode();
        if (inviteCode == null) {
            return false;
        }
        boolean postRegisterWithInvite = modelGlobalNavigation.getNuxState().getPostRegisterWithInvite();
        Experiment userExperiment = StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getExperiments().getUserExperiment("2021-04_contact_sync_android_main", true);
        boolean z2 = postRegisterWithInvite && (userExperiment != null && userExperiment.getBucket() == 1) && modelGlobalNavigation.getUserHasPhone();
        if (postRegisterWithInvite && z2 && !modelGlobalNavigation.getNuxState().getContactSyncCompleted()) {
            if (!appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetContactSync.class))) {
                ContactSyncFlowAnalytics.INSTANCE.trackStart(true, MapsJVM.mapOf(Tuples.m10073to("location_page", "Onboarding")));
                WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, appActivity, ContactSyncMode.ONBOARDING, false, false, false, 28, null);
            }
        } else {
            if (appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetGuildInvite.class))) {
                return false;
            }
            WidgetGuildInvite.INSTANCE.launch(appActivity, inviteCode);
            StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNux().updateNux(AnonymousClass1.INSTANCE);
        }
        return true;
    }
}
