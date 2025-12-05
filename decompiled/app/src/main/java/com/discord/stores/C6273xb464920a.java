package com.discord.stores;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.authentication.AuthState;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetAuthForceChangePassword;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: StoreNavigation.kt */
/* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1 */
/* loaded from: classes2.dex */
public final class C6273xb464920a extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final C6273xb464920a INSTANCE = new C6273xb464920a();

    /* compiled from: StoreNavigation.kt */
    /* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<AppActivity, Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppActivity appActivity, Boolean bool) {
            invoke(appActivity, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(AppActivity appActivity, boolean z2) {
            Intrinsics3.checkNotNullParameter(appActivity, "context");
            Intent intentAddFlags = new Intent().addFlags(268468224);
            Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent()\n            .ad…FLAG_ACTIVITY_CLEAR_TASK)");
            AppScreen2.m154b(appActivity, z2, intentAddFlags);
        }
    }

    public C6273xb464920a() {
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
        AppScreen2 appScreen2 = AppScreen2.f524g;
        boolean zM8347g = appActivity.m8347g(AppScreen2.f518a);
        boolean zM8347g2 = appActivity.m8347g(AppScreen2.f519b);
        boolean zM8348h = appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetAuthForceChangePassword.class));
        boolean zIsInitializedForAuthedUser = modelGlobalNavigation.isInitializedForAuthedUser();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        if (!zIsInitializedForAuthedUser || (!(zM8347g || zM8348h) || modelGlobalNavigation.getAuthState() == null)) {
            if (modelGlobalNavigation.getAuthState() == null) {
                if (!zM8347g && !zM8347g2) {
                    anonymousClass1.invoke(appActivity, false);
                }
            } else if (!zM8347g && !zM8348h) {
                return false;
            }
        } else if (modelGlobalNavigation.getAuthState().getRequiredActions().isEmpty()) {
            anonymousClass1.invoke(appActivity, true);
        } else {
            if (zM8348h || !AuthState.INSTANCE.isUpdatePasswordRequired(modelGlobalNavigation.getAuthState())) {
                return false;
            }
            WidgetAuthForceChangePassword.INSTANCE.launch(appActivity);
        }
        return true;
    }
}
