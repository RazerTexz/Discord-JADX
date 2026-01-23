package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.user.account.WidgetUserAccountVerify;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6286xacd9c7fd extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6286xacd9c7fd INSTANCE = new C6286xacd9c7fd();

    public C6286xacd9c7fd() {
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
        AppScreen2 appScreen2 = AppScreen2.f524g;
        boolean zM8347g = appActivity.m8347g(AppScreen2.f522e);
        boolean z2 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_EMAIL || modelGlobalNavigation.getUserRequiredAction() == RequiredAction.REQUIRE_VERIFIED_PHONE;
        if (zM8347g || !z2) {
            return z2;
        }
        WidgetUserAccountVerify.INSTANCE.launch(appActivity, modelGlobalNavigation.getUserRequiredAction());
        return true;
    }
}
