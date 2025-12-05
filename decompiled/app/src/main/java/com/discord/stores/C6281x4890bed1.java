package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.WidgetUserMentions;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p009a.WidgetBlockRussianPurchasesDialog;
import p507d0.p513e0.KClass;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: StoreNavigation.kt */
/* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1 */
/* loaded from: classes2.dex */
public final class C6281x4890bed1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6281x4890bed1 INSTANCE = new C6281x4890bed1();

    public C6281x4890bed1() {
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
        if (modelGlobalNavigation.getNotice() == null) {
            return false;
        }
        List<KClass<? extends AppComponent>> validScreens = modelGlobalNavigation.getNotice().getValidScreens();
        boolean z2 = true;
        boolean z3 = validScreens != null && validScreens.contains(Reflection2.getOrCreateKotlinClass(WidgetHome.class)) && appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)) && modelGlobalNavigation.getNavigationTab() == NavigationTab.HOME;
        boolean z4 = validScreens != null && validScreens.contains(Reflection2.getOrCreateKotlinClass(WidgetUserMentions.class)) && appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)) && modelGlobalNavigation.getNavigationTab() == NavigationTab.MENTIONS;
        String name = modelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(WidgetBlockRussianPurchasesDialog.INSTANCE);
        boolean zAreEqual = Intrinsics3.areEqual(name, "Block Russian Purchases Dialog");
        if (validScreens != null && !appActivity.m8347g(validScreens) && !z3 && !z4 && !zAreEqual) {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        AppLog appLog = AppLog.f14950g;
        String name2 = modelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(appLog);
        Intrinsics3.checkNotNullParameter(name2, "noticeName");
        appLog.recordBreadcrumb("Notice [" + name2 + ']', NotificationCompat.CATEGORY_NAVIGATION);
        if (modelGlobalNavigation.getNotice().getAutoMarkSeen()) {
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), modelGlobalNavigation.getNotice().getName(), 0L, 2, null);
        }
        return modelGlobalNavigation.getNotice().show(appActivity);
    }
}
