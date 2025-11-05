package com.discord.utilities.bugreports;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.bugreports.WidgetBugReport;
import d0.g;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

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
                m.throwUninitializedPropertyAccessException("bugReportManager");
            }
            return bugReportManagerAccess$getBugReportManager$cp;
        }

        public final void init() {
            BugReportManager.access$setBugReportManager$cp(new BugReportManager(SharedPreferencesProvider.INSTANCE.get(), null, 2, null));
            BugReportManager bugReportManagerAccess$getBugReportManager$cp = BugReportManager.access$getBugReportManager$cp();
            if (bugReportManagerAccess$getBugReportManager$cp == null) {
                m.throwUninitializedPropertyAccessException("bugReportManager");
            }
            bugReportManagerAccess$getBugReportManager$cp.setupSubscriptions();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportManager.kt */
    /* renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<MeUser, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            UserUtils userUtils = UserUtils.INSTANCE;
            m.checkNotNullExpressionValue(meUser, "it");
            return Boolean.valueOf(userUtils.isStaff(meUser));
        }
    }

    /* compiled from: BugReportManager.kt */
    /* renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            BugReportManager bugReportManager = BugReportManager.this;
            m.checkNotNullExpressionValue(bool, "isStaff");
            bugReportManager.setUserIsStaff(bool.booleanValue());
        }
    }

    public BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser) {
        m.checkNotNullParameter(sharedPreferences, "cache");
        m.checkNotNullParameter(storeUser, "storeUser");
        this.cache = sharedPreferences;
        this.storeUser = storeUser;
        this.settingsEnabled = true;
        this.screenshotDetector = g.lazy(BugReportManager$screenshotDetector$2.INSTANCE);
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
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(screenshot, "screenshot");
        if (isEnabled()) {
            WidgetBugReport.INSTANCE.launch(context, screenshot);
        }
    }

    public final void setBugReportingSettingEnabled(boolean enabled) {
        SharedPreferences.Editor editorEdit = this.cache.edit();
        m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, enabled);
        editorEdit.apply();
        this.settingsEnabled = enabled;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setUserIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setupSubscriptions() {
        Observable observableR = this.storeUser.observeMe(true).G(AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "storeUser.observeMe(emit… }.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, BugReportManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public /* synthetic */ BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser);
    }
}
