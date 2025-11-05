package com.discord.stores;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.models.authentication.AuthState;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetAuthForceChangePassword;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreNavigation.kt */
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1 extends o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1();

    /* compiled from: StoreNavigation.kt */
    /* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<AppActivity, Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppActivity appActivity, Boolean bool) {
            invoke(appActivity, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(AppActivity appActivity, boolean z2) {
            m.checkNotNullParameter(appActivity, "context");
            Intent intentAddFlags = new Intent().addFlags(268468224);
            m.checkNotNullExpressionValue(intentAddFlags, "Intent()\n            .ad…FLAG_ACTIVITY_CLEAR_TASK)");
            j.b(appActivity, z2, intentAddFlags);
        }
    }

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1() {
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
        j jVar = j.g;
        boolean zG = appActivity.g(j.a);
        boolean zG2 = appActivity.g(j.f58b);
        boolean zH = appActivity.h(a0.getOrCreateKotlinClass(WidgetAuthForceChangePassword.class));
        boolean zIsInitializedForAuthedUser = modelGlobalNavigation.isInitializedForAuthedUser();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        if (!zIsInitializedForAuthedUser || (!(zG || zH) || modelGlobalNavigation.getAuthState() == null)) {
            if (modelGlobalNavigation.getAuthState() == null) {
                if (!zG && !zG2) {
                    anonymousClass1.invoke(appActivity, false);
                }
            } else if (!zG && !zH) {
                return false;
            }
        } else if (modelGlobalNavigation.getAuthState().getRequiredActions().isEmpty()) {
            anonymousClass1.invoke(appActivity, true);
        } else {
            if (zH || !AuthState.INSTANCE.isUpdatePasswordRequired(modelGlobalNavigation.getAuthState())) {
                return false;
            }
            WidgetAuthForceChangePassword.INSTANCE.launch(appActivity);
        }
        return true;
    }
}
