package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.client.WidgetClientOutdated;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6276xe14e3735 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6276xe14e3735 INSTANCE = new C6276xe14e3735();

    public C6276xe14e3735() {
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
        boolean zM8348h = appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetClientOutdated.class));
        if (modelGlobalNavigation.getClientOutdated()) {
            if (zM8348h) {
                return true;
            }
            WidgetClientOutdated.INSTANCE.launch(appActivity);
            return true;
        }
        if (modelGlobalNavigation.getClientOutdated() || !zM8348h) {
            return modelGlobalNavigation.getClientOutdated();
        }
        AppScreen2.m155c(appActivity, false, null, 6);
        return true;
    }
}
