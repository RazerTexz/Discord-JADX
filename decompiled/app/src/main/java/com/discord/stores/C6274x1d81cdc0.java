package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p513e0.KClass;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6274x1d81cdc0 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6274x1d81cdc0 INSTANCE = new C6274x1d81cdc0();

    public C6274x1d81cdc0() {
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
        if (appActivity.m8347g(Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetVoiceCallIncoming.class), Reflection2.getOrCreateKotlinClass(WidgetVoiceCallIncoming.SystemCallIncoming.class)})) || !modelGlobalNavigation.getIncomingCall()) {
            return modelGlobalNavigation.getIncomingCall();
        }
        AppScreen2.m157e(appActivity, WidgetVoiceCallIncoming.class, null, 4);
        return true;
    }
}
