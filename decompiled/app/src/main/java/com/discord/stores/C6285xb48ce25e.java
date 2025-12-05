package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.tos.WidgetTos;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: StoreNavigation.kt */
/* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1 */
/* loaded from: classes2.dex */
public final class C6285xb48ce25e extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6285xb48ce25e INSTANCE = new C6285xb48ce25e();

    public C6285xb48ce25e() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        boolean zM8348h = appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetTos.class));
        boolean z2 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.TOS_UPDATE_ACKNOWLEDGMENT;
        boolean z3 = modelGlobalNavigation.getUserRequiredAction() == RequiredAction.AGREEMENTS;
        boolean z4 = (z2 || z3) && !zM8348h;
        boolean z5 = (z2 || z3 || !zM8348h) ? false : true;
        if (z4) {
            WidgetTos.INSTANCE.show(appActivity, z2);
        } else if (z5) {
            AppScreen2.m155c(appActivity, false, null, 6);
        } else if (!z2 && !z3) {
            return false;
        }
        return true;
    }
}
