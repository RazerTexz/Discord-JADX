package com.discord.utilities.bugreports;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.bugreports.WidgetBugReport;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: BugReportManager.kt */
/* loaded from: classes2.dex */
public final class BugReportManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED = "prefs_ss_bug_reporting_enabled";
    private static BugReportManager bugReportManager;
    private final SharedPreferences cache;
    private boolean isStaff;

    /* renamed from: screenshotDetector$delegate, reason: from kotlin metadata */
    private final Lazy screenshotDetector;
    private boolean settingsEnabled;
    private final StoreUser storeUser;

    /* compiled from: BugReportManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BugReportManager get() {
            BugReportManager bugReportManagerAccess$getBugReportManager$cp = BugReportManager.access$getBugReportManager$cp();
            if (bugReportManagerAccess$getBugReportManager$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bugReportManager");
            }
            return bugReportManagerAccess$getBugReportManager$cp;
        }

        public final void init() {
            BugReportManager.access$setBugReportManager$cp(new BugReportManager(SharedPreferencesProvider.INSTANCE.get(), null, 2, null));
            BugReportManager bugReportManagerAccess$getBugReportManager$cp = BugReportManager.access$getBugReportManager$cp();
            if (bugReportManagerAccess$getBugReportManager$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bugReportManager");
            }
            bugReportManagerAccess$getBugReportManager$cp.setupSubscriptions();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportManager.kt */
    /* renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$1 */
    public static final class C67101<T, R> implements Func1<MeUser, Boolean> {
        public static final C67101 INSTANCE = new C67101();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            UserUtils userUtils = UserUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "it");
            return Boolean.valueOf(userUtils.isStaff(meUser));
        }
    }

    /* compiled from: BugReportManager.kt */
    /* renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$2 */
    public static final class C67112 extends Lambda implements Function1<Boolean, Unit> {
        public C67112() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            BugReportManager bugReportManager = BugReportManager.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "isStaff");
            bugReportManager.setUserIsStaff(bool.booleanValue());
        }
    }

    public BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "cache");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        this.cache = sharedPreferences;
        this.storeUser = storeUser;
        this.settingsEnabled = true;
        this.screenshotDetector = LazyJVM.lazy(BugReportManager2.INSTANCE);
        this.settingsEnabled = sharedPreferences.getBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, true);
    }

    public static final /* synthetic */ BugReportManager access$getBugReportManager$cp() {
        return bugReportManager;
    }

    public static final /* synthetic */ void access$setBugReportManager$cp(BugReportManager bugReportManager2) {
        bugReportManager = bugReportManager2;
    }

    private final ScreenshotDetector getScreenshotDetector() {
        return (ScreenshotDetector) this.screenshotDetector.getValue();
    }

    public final SharedPreferences getCache() {
        return this.cache;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    /* renamed from: isBugReportSettingEnabled, reason: from getter */
    public final boolean getSettingsEnabled() {
        return this.settingsEnabled;
    }

    public final boolean isEnabled() {
        return this.isStaff && this.settingsEnabled;
    }

    public final void onScreenshot(Context context, ScreenshotDetector.Screenshot screenshot) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(screenshot, "screenshot");
        if (isEnabled()) {
            WidgetBugReport.INSTANCE.launch(context, screenshot);
        }
    }

    public final void setBugReportingSettingEnabled(boolean enabled) {
        SharedPreferences.Editor editorEdit = this.cache.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, enabled);
        editorEdit.apply();
        this.settingsEnabled = enabled;
        getScreenshotDetector().m8505a(isEnabled());
    }

    public final void setUserIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
        getScreenshotDetector().m8505a(isEnabled());
    }

    public final void setupSubscriptions() {
        Observable observableM11112r = this.storeUser.observeMe(true).m11083G(C67101.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "storeUser.observeMe(emit… }.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableM11112r, BugReportManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C67112(), 62, (Object) null);
    }

    public /* synthetic */ BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser);
    }
}
