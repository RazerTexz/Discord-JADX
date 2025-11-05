package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func2;

/* compiled from: WidgetUserAccountVerifyBase.kt */
/* loaded from: classes.dex */
public abstract class WidgetUserAccountVerifyBase extends AppFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EMAIL_ALLOWED = "INTENT_EMAIL_ALLOWED";
    private static final String INTENT_MODE = "INTENT_MODE";
    private static final String INTENT_PHONE_ALLOWED = "INTENT_PHONE_ALLOWED";
    private boolean isEmailAllowed;
    private boolean isPhoneAllowed;
    public Mode mode;

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Intent getLaunchIntent(Mode mode, boolean phoneAllowed, boolean emailAllowed) {
            m.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent();
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_PHONE_ALLOWED, phoneAllowed);
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_EMAIL_ALLOWED, emailAllowed);
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_MODE, mode.ordinal());
            return intent;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    public enum Mode {
        UNFORCED,
        FORCED,
        NO_HISTORY_FROM_USER_SETTINGS
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$getShouldDismissObservable$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<RequiredAction, MeUser, Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(RequiredAction requiredAction, MeUser meUser) {
            return call2(requiredAction, meUser);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean call2(RequiredAction requiredAction, MeUser meUser) {
            boolean z2;
            if (WidgetUserAccountVerifyBase.this.getIsPhoneAllowed()) {
                UserUtils userUtils = UserUtils.INSTANCE;
                m.checkNotNullExpressionValue(meUser, "me");
                z2 = !userUtils.getHasPhone(meUser);
            }
            boolean z3 = WidgetUserAccountVerifyBase.this.getIsEmailAllowed() && !meUser.isVerified();
            WidgetUserAccountVerifyBase widgetUserAccountVerifyBase = WidgetUserAccountVerifyBase.this;
            m.checkNotNullExpressionValue(requiredAction, "requiredAction");
            return Boolean.valueOf(WidgetUserAccountVerifyBase.access$computeShouldDismiss(widgetUserAccountVerifyBase, z2, z3, requiredAction));
        }
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase) {
            super(1, widgetUserAccountVerifyBase, WidgetUserAccountVerifyBase.class, "handleIsAuthorized", "handleIsAuthorized(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetUserAccountVerifyBase.access$handleIsAuthorized((WidgetUserAccountVerifyBase) this.receiver, z2);
        }
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$setOptionsMenu$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_settings_log_out) {
                return;
            }
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetUserAccountVerifyBase(@LayoutRes int i) {
        super(i);
        this.isPhoneAllowed = true;
        this.isEmailAllowed = true;
    }

    public static final /* synthetic */ boolean access$computeShouldDismiss(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase, boolean z2, boolean z3, RequiredAction requiredAction) {
        return widgetUserAccountVerifyBase.computeShouldDismiss(z2, z3, requiredAction);
    }

    public static final /* synthetic */ void access$handleIsAuthorized(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase, boolean z2) {
        widgetUserAccountVerifyBase.handleIsAuthorized(z2);
    }

    private final boolean computeShouldDismiss(boolean isMissingPhone, boolean isMissingEmailOrUnverified, RequiredAction requiredAction) {
        Mode mode = this.mode;
        if (mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        if (mode == Mode.UNFORCED) {
            return true;
        }
        Mode mode2 = this.mode;
        if (mode2 == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        if (mode2 == Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            return true;
        }
        if (isMissingPhone && requiredAction == RequiredAction.REQUIRE_VERIFIED_PHONE) {
            return true;
        }
        return (isMissingPhone || isMissingEmailOrUnverified) && requiredAction == RequiredAction.REQUIRE_VERIFIED_EMAIL;
    }

    public static final Intent getLaunchIntent(Mode mode, boolean z2, boolean z3) {
        return INSTANCE.getLaunchIntent(mode, z2, z3);
    }

    private final Observable<Boolean> getShouldDismissObservable() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableJ = Observable.j(companion.getUserRequiredActions().observeUserRequiredAction(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new AnonymousClass1());
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…requiredAction)\n        }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationBuffered(observableJ).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        return observableR;
    }

    private final void handleIsAuthorized(boolean isAuthorized) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            if (isAuthorized) {
                return;
            }
            j.c(context, false, null, 6);
        }
    }

    private final void setOptionsMenu() {
        Mode mode = this.mode;
        if (mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        AppFragment.setActionBarOptionsMenu$default(this, mode == Mode.FORCED ? R.menu.menu_settings_logout : R.menu.menu_empty, AnonymousClass1.INSTANCE, null, 4, null);
    }

    public final Mode getMode() {
        Mode mode = this.mode;
        if (mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        return mode;
    }

    /* renamed from: isEmailAllowed, reason: from getter */
    public final boolean getIsEmailAllowed() {
        return this.isEmailAllowed;
    }

    public final boolean isForced() {
        Mode mode = this.mode;
        if (mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        return mode == Mode.FORCED;
    }

    /* renamed from: isPhoneAllowed, reason: from getter */
    public final boolean getIsPhoneAllowed() {
        return this.isPhoneAllowed;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int intExtra = getMostRecentIntent().getIntExtra(INTENT_MODE, -1);
        Mode.values();
        if (intExtra >= 0 && 3 > intExtra) {
            this.mode = Mode.values()[intExtra];
            setOptionsMenu();
            this.isPhoneAllowed = getMostRecentIntent().getBooleanExtra(INTENT_PHONE_ALLOWED, this.isPhoneAllowed);
            this.isEmailAllowed = getMostRecentIntent().getBooleanExtra(INTENT_EMAIL_ALLOWED, this.isEmailAllowed);
            return;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("Invalid mode passed into ");
        sbU.append(WidgetUserAccountVerifyBase.class.getName());
        Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getShouldDismissObservable(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    public final void setEmailAllowed(boolean z2) {
        this.isEmailAllowed = z2;
    }

    public final void setMode(Mode mode) {
        m.checkNotNullParameter(mode, "<set-?>");
        this.mode = mode;
    }

    public final void setPhoneAllowed(boolean z2) {
        this.isPhoneAllowed = z2;
    }
}
