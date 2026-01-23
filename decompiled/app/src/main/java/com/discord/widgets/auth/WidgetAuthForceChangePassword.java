package com.discord.widgets.auth;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetAuthForceChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthForceChangePassword extends WidgetSettingsAccountChangePassword {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetAuthForceChangePassword.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetAuthForceChangePassword.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthForceChangePassword$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetAuthForceChangePassword.kt */
    public static final class C71721<R> implements Func0<Boolean> {
        public static final C71721 INSTANCE = new C71721();

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            StoreStream.INSTANCE.getAuthentication().logout();
            return Boolean.TRUE;
        }
    }

    @Override // com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword
    public void onChangePasswordSuccess() {
        AnalyticsTracker.INSTANCE.trackForceUpdatePasswordSucceeded();
    }

    @Override // com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ImageView imageView = getBinding().f17819b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.authChangePasswordIcon");
        imageView.setVisibility(0);
        setOnBackPressed(C71721.INSTANCE, 0);
    }
}
