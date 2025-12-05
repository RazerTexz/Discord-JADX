package com.discord.app;

import android.R;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import com.discord.C5419R;
import com.discord.app.AppTransitionActivity;
import com.discord.models.domain.ModelUserSettings;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.bugreports.BugReportManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.ToolbarTitleLayout;
import com.discord.widgets.debugging.WidgetFatalCrash;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppActivity3;
import p007b.p008a.p018d.AppEventHandlerActivity;
import p007b.p008a.p018d.AppPermissions;
import p007b.p008a.p018d.AppScreen;
import p007b.p008a.p018d.AppScreen2;
import p507d0.LazyJVM;
import p507d0.p508a0.MathJVM;
import p507d0.p513e0.KClass;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* compiled from: AppActivity.kt */
/* loaded from: classes.dex */
public class AppActivity extends AppEventHandlerActivity implements AppComponent {

    /* renamed from: m */
    public static boolean f14908m;

    /* renamed from: n */
    public static final Intent f14909n = new Intent();

    /* renamed from: o */
    public static boolean f14910o = true;

    /* renamed from: p, reason: from kotlin metadata */
    public final LinkedHashMap<Integer, Function1<Intent, Unit>> newIntentListeners = new LinkedHashMap<>();

    /* renamed from: q, reason: from kotlin metadata */
    public int originalFontScale = -1;

    /* renamed from: r, reason: from kotlin metadata */
    public String originalLocale = "";

    /* renamed from: s, reason: from kotlin metadata */
    public boolean refreshEnabled = true;

    /* renamed from: t, reason: from kotlin metadata */
    public final Subject<Void, Void> unsubscribeSignal;

    /* renamed from: u, reason: from kotlin metadata */
    public Toolbar toolbar;

    /* renamed from: v, reason: from kotlin metadata */
    public final Lazy screen;

    /* renamed from: w, reason: from kotlin metadata */
    public Intent mostRecentIntent;

    /* renamed from: x, reason: from kotlin metadata */
    public final AppPermissions2 appPermissions;

    /* compiled from: AppActivity.kt */
    public static final class AppAction extends AppActivity {

        /* renamed from: y, reason: from kotlin metadata */
        public final Lazy screen = LazyJVM.lazy(new C5431a());

        /* compiled from: AppActivity.kt */
        /* renamed from: com.discord.app.AppActivity$AppAction$a */
        public static final class C5431a extends Lambda implements Function0<Class<? extends AppFragment>> {
            public C5431a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Class<? extends AppFragment> invoke() {
                int iHashCode;
                String action = AppAction.this.m8343c().getAction();
                return (action != null && ((iHashCode = action.hashCode()) == -1173264947 ? action.equals("android.intent.action.SEND") : !(iHashCode == -1103390587 ? !action.equals("com.discord.intent.action.SDK") : !(iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE"))))) ? WidgetIncomingShare.class : WidgetTabsHost.class;
            }
        }

        @Override // com.discord.app.AppActivity
        /* renamed from: d */
        public Class<? extends AppComponent> mo8344d() {
            return (Class) this.screen.getValue();
        }

        @Override // com.discord.app.AppActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (AppActivity.f14908m) {
                finish();
            }
        }
    }

    /* compiled from: AppActivity.kt */
    public static final class Call extends AppActivity {

        /* renamed from: y, reason: from kotlin metadata */
        public final Class<? extends AppComponent> screen = WidgetCallFullscreen.class;

        @Override // com.discord.app.AppActivity
        /* renamed from: d */
        public Class<? extends AppComponent> mo8344d() {
            return this.screen;
        }
    }

    /* compiled from: AppActivity.kt */
    public static final class IncomingCall extends AppActivity {

        /* renamed from: y, reason: from kotlin metadata */
        public final Class<? extends AppComponent> screen = WidgetVoiceCallIncoming.SystemCallIncoming.class;

        @Override // com.discord.app.AppActivity
        /* renamed from: d */
        public Class<? extends AppComponent> mo8344d() {
            return this.screen;
        }
    }

    /* compiled from: AppActivity.kt */
    public static final class Main extends AppActivity {
    }

    /* compiled from: AppActivity.kt */
    /* renamed from: com.discord.app.AppActivity$b */
    public static final class C5433b extends Lambda implements Function0<Unit> {

        /* renamed from: j */
        public static final C5433b f14925j = new C5433b();

        public C5433b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (AppActivity.f14910o) {
                AppActivity.f14910o = false;
                AppLog.m8358i("Application activity initialized.");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                ApplicationProvider applicationProvider = ApplicationProvider.INSTANCE;
                companion.initialize(applicationProvider.get());
                AnalyticsUtils.INSTANCE.initAppOpen(applicationProvider.get());
                AccessibilityMonitor.INSTANCE.initialize(applicationProvider.get());
                ShareUtils.INSTANCE.updateDirectShareTargets(applicationProvider.get());
                GooglePlayBillingManager.INSTANCE.init(applicationProvider.get());
                AppLog appLog = AppLog.f14950g;
                Intrinsics3.checkNotNullParameter(appLog, "logger");
                Application application = applicationProvider.get();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationProvider.get());
                Intrinsics3.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…pplicationProvider.get())");
                ScreenshotDetector.f18938a = new ScreenshotDetector(application, appLog, defaultSharedPreferences);
                BugReportManager.INSTANCE.init();
            }
        }
    }

    /* compiled from: AppActivity.kt */
    /* renamed from: com.discord.app.AppActivity$c */
    public static final class C5434c extends Lambda implements Function1<StoreUserSettingsSystem.Settings, Unit> {
        public C5434c() {
            super(1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
        @Override // kotlin.jvm.functions.Function1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Unit invoke(StoreUserSettingsSystem.Settings settings) {
            boolean z2;
            StoreUserSettingsSystem.Settings settings2 = settings;
            Intrinsics3.checkNotNullParameter(settings2, "it");
            AppActivity appActivity = AppActivity.this;
            boolean z3 = AppActivity.f14908m;
            Objects.requireNonNull(appActivity);
            Locale localeObject = ModelUserSettings.getLocaleObject(settings2.getLocale());
            Intrinsics3.checkNotNullExpressionValue(localeObject, "ModelUserSettings.getLocaleObject(model.locale)");
            if (!appActivity.m8346f(localeObject)) {
                String theme = settings2.getTheme();
                AppActivity3 appActivity3 = new AppActivity3(appActivity);
                appActivity3.this$0.getTheme().resolveAttribute(C5419R.attr.theme_name, new TypedValue(), true);
                if (!(!Intrinsics3.areEqual(r5.string, theme))) {
                    int fontScale = settings2.getFontScale();
                    FontUtils fontUtils = FontUtils.INSTANCE;
                    ContentResolver contentResolver = appActivity.getContentResolver();
                    Intrinsics3.checkNotNullExpressionValue(contentResolver, "contentResolver");
                    if (!((fontScale == -1 && appActivity.originalFontScale != fontUtils.getSystemFontScaleInt(contentResolver)) || !(fontScale == -1 || appActivity.originalFontScale == fontScale))) {
                        z2 = false;
                    }
                }
                if (z2) {
                    AppActivity.m8341i(AppActivity.this, false, 1, null);
                }
                return Unit.f27425a;
            }
            appActivity.m8342b(settings2.getLocale(), true);
            z2 = true;
            if (z2) {
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: AppActivity.kt */
    /* renamed from: com.discord.app.AppActivity$d */
    public static final class C5435d extends Lambda implements Function1<ScreenshotDetector.Screenshot, Unit> {
        public C5435d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ScreenshotDetector.Screenshot screenshot) {
            ScreenshotDetector.Screenshot screenshot2 = screenshot;
            Intrinsics3.checkNotNullParameter(screenshot2, "screenshot");
            BugReportManager.INSTANCE.get().onScreenshot(AppActivity.this, screenshot2);
            return Unit.f27425a;
        }
    }

    /* compiled from: AppActivity.kt */
    /* renamed from: com.discord.app.AppActivity$e */
    public static final class C5436e extends Lambda implements Function0<Class<? extends AppComponent>> {
        public C5436e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Class<? extends AppComponent> invoke() {
            Intent intent = AppActivity.this.getIntent();
            Class<? extends AppComponent> cls = (Class) (intent != null ? intent.getSerializableExtra("com.discord.intent.extra.EXTRA_SCREEN") : null);
            return cls != null ? cls : WidgetTabsHost.class;
        }
    }

    /* compiled from: AppActivity.kt */
    /* renamed from: com.discord.app.AppActivity$f */
    public static final class RunnableC5437f implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ View f14926j;

        /* renamed from: k */
        public final /* synthetic */ InputMethodManager f14927k;

        public RunnableC5437f(View view, InputMethodManager inputMethodManager) {
            this.f14926j = view;
            this.f14927k = inputMethodManager;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                View editText = this.f14926j;
                if ((editText instanceof TextInputLayout) && (editText = ((TextInputLayout) editText).getEditText()) == null) {
                    editText = this.f14926j;
                }
                editText.requestFocus();
                this.f14927k.showSoftInput(editText, 2);
            } catch (Exception e) {
                AppLog.f14950g.mo8362d("Error Opening/Closing the Keyboard", e);
            }
        }
    }

    /* compiled from: AppActivity.kt */
    /* renamed from: com.discord.app.AppActivity$g */
    public static final class ViewOnClickListenerC5438g implements View.OnClickListener {
        public ViewOnClickListenerC5438g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws Exception {
            AppActivity appActivity = AppActivity.this;
            boolean z2 = AppActivity.f14908m;
            appActivity.hideKeyboard(null);
            AppActivity.this.onBackPressed();
        }
    }

    public AppActivity() {
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
        this.screen = LazyJVM.lazy(new C5436e());
        this.mostRecentIntent = f14909n;
        int i = AppPermissions2.f14960a;
        Intrinsics3.checkNotNullParameter(this, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.appPermissions = new AppPermissions(this);
    }

    /* renamed from: i */
    public static void m8341i(AppActivity appActivity, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if (appActivity.refreshEnabled) {
            appActivity.finish();
            if (z2) {
                AppTransitionActivity.Transition transition = AppTransitionActivity.Transition.TYPE_FADE;
                appActivity.overridePendingTransition(transition.getAnimations().f14967c, transition.getAnimations().f14968d);
                appActivity.getIntent().putExtra("transition", transition);
            }
            AppScreen2.m156d(appActivity, appActivity.mo8344d(), appActivity.getIntent());
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (overrideConfiguration != null) {
            int i = overrideConfiguration.uiMode;
            Context baseContext = getBaseContext();
            Intrinsics3.checkNotNullExpressionValue(baseContext, "baseContext");
            Resources resources = baseContext.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "baseContext.resources");
            overrideConfiguration.setTo(resources.getConfiguration());
            overrideConfiguration.uiMode = i;
        }
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        C5433b.f14925j.invoke2();
        if (newBase == null) {
            newBase = this;
        }
        if (!f14910o) {
            Resources resources = newBase.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "oldContext.resources");
            Configuration configuration = resources.getConfiguration();
            float targetFontScaleFloat = FontUtils.INSTANCE.getTargetFontScaleFloat(newBase);
            configuration.fontScale = targetFontScaleFloat;
            this.originalFontScale = MathJVM.roundToInt(targetFontScaleFloat * 100.0f);
            newBase = newBase.createConfigurationContext(configuration);
            Intrinsics3.checkNotNullExpressionValue(newBase, "oldContext.createConfigurationContext(config)");
        }
        super.attachBaseContext(newBase);
    }

    /* renamed from: b */
    public final void m8342b(String localeString, boolean refreshIfChanged) {
        Locale localeObject = ModelUserSettings.getLocaleObject(localeString);
        Intrinsics3.checkNotNullExpressionValue(localeObject, "locale");
        if (m8346f(localeObject)) {
            Locale.setDefault(localeObject);
            if (Build.VERSION.SDK_INT >= 24) {
                Resources resources = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                resources.getConfiguration().setLocale(localeObject);
            } else {
                Resources resources2 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                resources2.getConfiguration().locale = localeObject;
            }
            Resources resources3 = getResources();
            Resources resources4 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
            Configuration configuration = resources4.getConfiguration();
            Resources resources5 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources5, "resources");
            resources3.updateConfiguration(configuration, resources5.getDisplayMetrics());
            if (refreshIfChanged) {
                m8341i(this, false, 1, null);
            }
        }
    }

    /* renamed from: c */
    public final Intent m8343c() {
        Intent intent = this.mostRecentIntent;
        Intent intent2 = f14909n;
        if (intent != intent2) {
            return intent;
        }
        Intent intent3 = getIntent();
        return intent3 != null ? intent3 : new Intent(intent2);
    }

    /* renamed from: d */
    public Class<? extends AppComponent> mo8344d() {
        return (Class) this.screen.getValue();
    }

    /* renamed from: e */
    public final ToolbarTitleLayout m8345e() {
        Toolbar toolbar = this.toolbar;
        View childAt = toolbar != null ? toolbar.getChildAt(0) : null;
        return (ToolbarTitleLayout) (childAt instanceof ToolbarTitleLayout ? childAt : null);
    }

    /* renamed from: f */
    public final boolean m8346f(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = resources.getConfiguration();
            Intrinsics3.checkNotNullExpressionValue(configuration, "resources.configuration");
            LocaleList locales = configuration.getLocales();
            Intrinsics3.checkNotNullExpressionValue(locales, "resources.configuration.locales");
            if (!locales.isEmpty()) {
                Resources resources2 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                Intrinsics3.checkNotNullExpressionValue(resources2.getConfiguration(), "resources.configuration");
                if (!(!Intrinsics3.areEqual(r0.getLocales().get(0), locale))) {
                    return false;
                }
            }
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
            if (resources3.getConfiguration().locale != null) {
                Intrinsics3.checkNotNullExpressionValue(getResources(), "resources");
                if (!(!Intrinsics3.areEqual(r0.getConfiguration().locale, locale))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: g */
    public final boolean m8347g(List<? extends KClass<? extends AppComponent>> screens) {
        Intrinsics3.checkNotNullParameter(screens, "screens");
        if ((screens instanceof Collection) && screens.isEmpty()) {
            return false;
        }
        Iterator<T> it = screens.iterator();
        while (it.hasNext()) {
            if (Intrinsics3.areEqual(JvmClassMapping.getJavaClass((KClass) it.next()), mo8344d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    /* renamed from: h */
    public final boolean m8348h(KClass<? extends AppComponent> screen) {
        Intrinsics3.checkNotNullParameter(screen, "screen");
        return Intrinsics3.areEqual(JvmClassMapping.getJavaClass(screen), mo8344d());
    }

    public final void hideKeyboard(View view) {
        m8352m(false, view);
    }

    /* renamed from: j */
    public final void m8349j(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (m8348h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class))) {
            return;
        }
        List<KClass<? extends AppFragment>> list = AppScreen2.f518a;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.addFlags(67108864);
        AppScreen2.m155c(context, false, intent, 2);
    }

    /* renamed from: k */
    public final Toolbar m8350k(boolean showHomeAsUp, @DrawableRes Integer iconRes, @StringRes Integer iconAccessibilityLabel) {
        Toolbar toolbar = this.toolbar;
        Drawable drawable = null;
        if (toolbar == null) {
            return null;
        }
        if (showHomeAsUp) {
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(toolbar, C5419R.attr.ic_action_bar_back, 0, 2, (Object) null);
            Context context = toolbar.getContext();
            if (iconRes != null) {
                themedDrawableRes$default = iconRes.intValue();
            }
            drawable = ContextCompat.getDrawable(context, themedDrawableRes$default);
            if (drawable != null) {
                androidx.core.graphics.drawable.DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(toolbar, C5419R.attr.colorInteractiveActive));
            }
            toolbar.setNavigationContentDescription(getString(C5419R.string.back));
        }
        toolbar.setNavigationIcon(drawable);
        if (iconAccessibilityLabel == null) {
            return toolbar;
        }
        toolbar.setNavigationContentDescription(getString(iconAccessibilityLabel.intValue()));
        return toolbar;
    }

    /* renamed from: l */
    public final Unit m8351l(CharSequence title, @DrawableRes Integer leftDrawable) {
        ToolbarTitleLayout toolbarTitleLayoutM8345e = m8345e();
        if (toolbarTitleLayoutM8345e == null) {
            return null;
        }
        int i = ToolbarTitleLayout.f19165j;
        toolbarTitleLayoutM8345e.m8564a(title, leftDrawable, null);
        return Unit.f27425a;
    }

    /* renamed from: m */
    public final void m8352m(boolean keyboardOpen, View view) {
        IBinder applicationWindowToken;
        View childAt;
        Object systemService = getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (view == null || (applicationWindowToken = view.getWindowToken()) == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            applicationWindowToken = (frameLayout == null || (childAt = frameLayout.getChildAt(0)) == null) ? null : childAt.getApplicationWindowToken();
        }
        if (keyboardOpen) {
            if (view != null) {
                view.postDelayed(new RunnableC5437f(view, inputMethodManager), 250L);
            }
        } else {
            try {
                inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 0);
            } catch (Exception e) {
                AppLog.f14950g.mo8362d("Error Opening/Closing the Keyboard", e);
            }
        }
    }

    /* renamed from: n */
    public final void m8353n(Toolbar toolbar) {
        this.toolbar = toolbar;
        if (m8345e() == null) {
            Toolbar toolbar2 = this.toolbar;
            if (toolbar2 != null) {
                toolbar2.addView(new ToolbarTitleLayout(this), 0);
            }
            ToolbarTitleLayout toolbarTitleLayoutM8345e = m8345e();
            if (toolbarTitleLayoutM8345e != null) {
                toolbarTitleLayoutM8345e.setBackground(ContextCompat.getDrawable(this, DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.selectableItemBackground, 0, 2, (Object) null)));
            }
            Toolbar toolbar3 = this.toolbar;
            if (toolbar3 != null) {
                toolbar3.setNavigationOnClickListener(new ViewOnClickListenerC5438g());
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C5432a c5432a = new C5432a(0, this);
        C5432a c5432a2 = new C5432a(1, this);
        try {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            String theme = companion.getUserSettingsSystem().getTheme();
            int i = 2131951650;
            if (Intrinsics3.areEqual(theme, ModelUserSettings.THEME_LIGHT)) {
                i = 2131951657;
            } else if (!Intrinsics3.areEqual(theme, ModelUserSettings.THEME_DARK) && Intrinsics3.areEqual(theme, ModelUserSettings.THEME_PURE_EVIL)) {
                i = 2131951652;
            }
            setTheme(i);
            m8342b(companion.getUserSettingsSystem().getLocale(), false);
            c5432a.invoke2();
            c5432a2.invoke2();
            if (m8348h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)) && companion.getTabsNavigation().getSelectedTab() == NavigationTab.HOME) {
                return;
            }
            companion.getAnalytics().appUiViewed(mo8344d());
        } catch (Exception e) {
            if (!m8348h(Reflection2.getOrCreateKotlinClass(WidgetFatalCrash.class))) {
                WidgetFatalCrash.Companion companion2 = WidgetFatalCrash.INSTANCE;
                String name = mo8344d().getName();
                Intrinsics3.checkNotNullExpressionValue(name, "screen.name");
                companion2.launch(this, e, name);
            }
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.newIntentListeners.clear();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            intent = f14909n;
        }
        this.mostRecentIntent = intent;
        f14908m = IntentUtils.INSTANCE.consumeExternalRoutingIntent(m8343c(), this);
        Intent intentM8343c = m8343c();
        Iterator<Map.Entry<Integer, Function1<Intent, Unit>>> it = this.newIntentListeners.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(intentM8343c);
        }
    }

    @Override // com.discord.app.AppTransitionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.unsubscribeSignal.onNext(null);
    }

    @Override // com.discord.app.AppTransitionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AppScreen2 appScreen2 = AppScreen2.f524g;
        Intrinsics3.checkNotNullParameter(this, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        boolean booleanExtra = m8343c().getBooleanExtra("INTENT_RECREATE", false);
        if (booleanExtra) {
            m8343c().removeExtra("INTENT_RECREATE");
            new Handler(Looper.getMainLooper()).post(new AppScreen(this));
        }
        if (booleanExtra) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if ((!Intrinsics3.areEqual(companion.getUserSettingsSystem().getLocale(), this.originalLocale)) && (!Intrinsics3.areEqual(this.originalLocale, ""))) {
            m8341i(this, false, 1, null);
            return;
        }
        this.originalLocale = companion.getUserSettingsSystem().getLocale();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.getUserSettingsSystem().observeSettings(true), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C5434c(), 62, (Object) null);
        ScreenshotDetector screenshotDetector = ScreenshotDetector.f18938a;
        if (screenshotDetector == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("screenshotDetector");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(screenshotDetector.publishSubject, this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C5435d(), 62, (Object) null);
    }

    public final void showKeyboard(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        m8352m(true, view);
    }

    /* compiled from: kotlin-style lambda group */
    /* renamed from: com.discord.app.AppActivity$a */
    /* loaded from: classes2.dex */
    public static final class C5432a extends Lambda implements Function0<Unit> {

        /* renamed from: j */
        public final /* synthetic */ int f14923j;

        /* renamed from: k */
        public final /* synthetic */ Object f14924k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5432a(int i, Object obj) {
            super(0);
            this.f14923j = i;
            this.f14924k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.f14923j;
            if (i == 0) {
                invoke2();
                return Unit.f27425a;
            }
            if (i != 1) {
                throw null;
            }
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            int i = this.f14923j;
            if (i != 0) {
                if (i == 1) {
                    Objects.requireNonNull((AppActivity) this.f14924k);
                    AppActivity appActivity = (AppActivity) this.f14924k;
                    if (appActivity.toolbar == null) {
                        appActivity.m8353n((Toolbar) appActivity.findViewById(C5419R.id.action_bar_toolbar));
                        return;
                    }
                    return;
                }
                throw null;
            }
            AppActivity appActivity2 = (AppActivity) this.f14924k;
            AppActivity.f14908m = IntentUtils.INSTANCE.consumeExternalRoutingIntent(appActivity2.m8343c(), appActivity2);
            Intent intentM8343c = ((AppActivity) this.f14924k).m8343c();
            AppActivity appActivity3 = (AppActivity) this.f14924k;
            Objects.requireNonNull(appActivity3);
            Serializable serializableExtra = intentM8343c != null ? intentM8343c.getSerializableExtra("transition") : null;
            if (!(serializableExtra instanceof AppTransitionActivity.Transition)) {
                serializableExtra = null;
            }
            AppTransitionActivity.Transition transition = (AppTransitionActivity.Transition) serializableExtra;
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                transition = AppTransitionActivity.Transition.TYPE_FADE_FAST;
            } else if (transition == null) {
                AppScreen2 appScreen2 = AppScreen2.f524g;
                transition = appActivity3.m8347g(AppScreen2.f521d) ? AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL : null;
            }
            appActivity3.f14964k = transition != null ? transition.getAnimations() : null;
            if (((AppActivity) this.f14924k).getSupportFragmentManager().findFragmentByTag(((AppActivity) this.f14924k).mo8344d().getName()) != null) {
                return;
            }
            AppScreen2 appScreen22 = AppScreen2.f524g;
            FragmentManager supportFragmentManager = ((AppActivity) this.f14924k).getSupportFragmentManager();
            AppActivity appActivity4 = (AppActivity) this.f14924k;
            AppScreen2.m158g(appScreen22, supportFragmentManager, appActivity4, appActivity4.mo8344d(), 0, false, null, null, 120);
        }
    }
}
