package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.client.WidgetClientOutdated;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreNavigation.kt */
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(modelGlobalNavigation, "model");
        boolean zH = appActivity.h(a0.getOrCreateKotlinClass(WidgetClientOutdated.class));
        if (modelGlobalNavigation.getClientOutdated()) {
            if (zH) {
                return true;
            }
            WidgetClientOutdated.INSTANCE.launch(appActivity);
            return true;
        }
        if (modelGlobalNavigation.getClientOutdated() || !zH) {
            return modelGlobalNavigation.getClientOutdated();
        }
        j.c(appActivity, false, null, 6);
        return true;
    }
}
