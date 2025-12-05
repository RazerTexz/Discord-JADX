package com.discord.stores;

import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreNavigation.kt */
/* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$oAuthStateHandler$1 */
/* loaded from: classes2.dex */
public final class C6283xf2a8aacf extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6283xf2a8aacf(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = activityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        Uri oAuthUri = modelGlobalNavigation.getOAuthUri();
        if (!Intrinsics3.areEqual(oAuthUri, Uri.EMPTY)) {
            AppScreen2 appScreen2 = AppScreen2.f524g;
            if (!appActivity.m8347g(AppScreen2.f520c)) {
                WidgetOauth2Authorize.INSTANCE.launch(appActivity, oAuthUri);
                StoreAuthentication authentication = StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getAuthentication();
                Uri uri = Uri.EMPTY;
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                authentication.setOAuthUriSubject(uri);
                return true;
            }
        }
        return false;
    }
}
