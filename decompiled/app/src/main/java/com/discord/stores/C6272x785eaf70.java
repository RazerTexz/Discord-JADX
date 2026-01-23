package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetAgeVerify;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6272x785eaf70 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6272x785eaf70 INSTANCE = new C6272x785eaf70();

    public C6272x785eaf70() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        boolean zM8348h = appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetAgeVerify.class));
        if (modelGlobalNavigation.getShouldShowAgeGate() != null && !zM8348h) {
            WidgetAgeVerify.INSTANCE.start(appActivity, modelGlobalNavigation.getShouldShowAgeGate() == StoreNavigation.AgeGate.NSFW_CHANNEL_AGE_GATE);
        } else if (modelGlobalNavigation.getShouldShowAgeGate() == null) {
            return false;
        }
        return true;
    }
}
