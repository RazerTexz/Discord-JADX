package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsLanguageBinding;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsLanguage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final String getAsStringInLocale(String locale) {
            if (locale == null) {
                return "English, USA";
            }
            switch (locale.hashCode()) {
                case 3141:
                    if (locale.equals("bg")) {
                    }
                    break;
                case 3184:
                    if (locale.equals("cs")) {
                    }
                    break;
                case 3197:
                    if (locale.equals("da")) {
                    }
                    break;
                case 3201:
                    if (locale.equals("de")) {
                    }
                    break;
                case 3239:
                    if (locale.equals("el")) {
                    }
                    break;
                case 3267:
                    if (locale.equals("fi")) {
                    }
                    break;
                case 3276:
                    if (locale.equals("fr")) {
                    }
                    break;
                case 3329:
                    if (locale.equals("hi")) {
                    }
                    break;
                case 3338:
                    if (locale.equals("hr")) {
                    }
                    break;
                case 3341:
                    if (locale.equals("hu")) {
                    }
                    break;
                case 3371:
                    if (locale.equals("it")) {
                    }
                    break;
                case 3383:
                    if (locale.equals("ja")) {
                    }
                    break;
                case 3428:
                    if (locale.equals("ko")) {
                    }
                    break;
                case 3464:
                    if (locale.equals("lt")) {
                    }
                    break;
                case 3518:
                    if (locale.equals("nl")) {
                    }
                    break;
                case 3521:
                    if (locale.equals("no")) {
                    }
                    break;
                case 3580:
                    if (locale.equals("pl")) {
                    }
                    break;
                case 3645:
                    if (locale.equals("ro")) {
                    }
                    break;
                case 3651:
                    if (locale.equals("ru")) {
                    }
                    break;
                case 3700:
                    if (locale.equals("th")) {
                    }
                    break;
                case 3710:
                    if (locale.equals("tr")) {
                    }
                    break;
                case 3734:
                    if (locale.equals("uk")) {
                    }
                    break;
                case 3763:
                    if (locale.equals("vi")) {
                    }
                    break;
                case 96598143:
                    if (locale.equals("en-GB")) {
                    }
                    break;
                case 96598594:
                    locale.equals("en-US");
                    break;
                case 96747053:
                    if (locale.equals("es-ES")) {
                    }
                    break;
                case 106935481:
                    if (locale.equals("pt-BR")) {
                    }
                    break;
                case 109766140:
                    if (locale.equals("sv-SE")) {
                    }
                    break;
                case 115813226:
                    if (locale.equals("zh-CN")) {
                    }
                    break;
                case 115813762:
                    if (locale.equals("zh-TW")) {
                    }
                    break;
            }
            return "English, USA";
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @DrawableRes
        public final int getLocaleFlagResId(String locale) {
            if (locale == null) {
                return C5419R.drawable.icon_flag_en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    if (locale.equals("bg")) {
                    }
                    break;
                case 3184:
                    if (locale.equals("cs")) {
                    }
                    break;
                case 3197:
                    if (locale.equals("da")) {
                    }
                    break;
                case 3201:
                    if (locale.equals("de")) {
                    }
                    break;
                case 3239:
                    if (locale.equals("el")) {
                    }
                    break;
                case 3267:
                    if (locale.equals("fi")) {
                    }
                    break;
                case 3276:
                    if (locale.equals("fr")) {
                    }
                    break;
                case 3329:
                    if (locale.equals("hi")) {
                    }
                    break;
                case 3338:
                    if (locale.equals("hr")) {
                    }
                    break;
                case 3341:
                    if (locale.equals("hu")) {
                    }
                    break;
                case 3371:
                    if (locale.equals("it")) {
                    }
                    break;
                case 3383:
                    if (locale.equals("ja")) {
                    }
                    break;
                case 3428:
                    if (locale.equals("ko")) {
                    }
                    break;
                case 3464:
                    if (locale.equals("lt")) {
                    }
                    break;
                case 3518:
                    if (locale.equals("nl")) {
                    }
                    break;
                case 3521:
                    if (locale.equals("no")) {
                    }
                    break;
                case 3580:
                    if (locale.equals("pl")) {
                    }
                    break;
                case 3645:
                    if (locale.equals("ro")) {
                    }
                    break;
                case 3651:
                    if (locale.equals("ru")) {
                    }
                    break;
                case 3700:
                    if (locale.equals("th")) {
                    }
                    break;
                case 3710:
                    if (locale.equals("tr")) {
                    }
                    break;
                case 3734:
                    if (locale.equals("uk")) {
                    }
                    break;
                case 3763:
                    if (locale.equals("vi")) {
                    }
                    break;
                case 96598143:
                    if (locale.equals("en-GB")) {
                    }
                    break;
                case 96598594:
                    locale.equals("en-US");
                    break;
                case 96747053:
                    if (locale.equals("es-ES")) {
                    }
                    break;
                case 106935481:
                    if (locale.equals("pt-BR")) {
                    }
                    break;
                case 109766140:
                    if (locale.equals("sv-SE")) {
                    }
                    break;
                case 115813226:
                    if (locale.equals("zh-CN")) {
                    }
                    break;
                case 115813762:
                    if (locale.equals("zh-TW")) {
                    }
                    break;
            }
            return C5419R.drawable.icon_flag_en_us;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @StringRes
        public final int getLocaleResId(String locale) {
            if (locale == null) {
                return C5419R.string.en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    if (locale.equals("bg")) {
                    }
                    break;
                case 3184:
                    if (locale.equals("cs")) {
                    }
                    break;
                case 3197:
                    if (locale.equals("da")) {
                    }
                    break;
                case 3201:
                    if (locale.equals("de")) {
                    }
                    break;
                case 3239:
                    if (locale.equals("el")) {
                    }
                    break;
                case 3267:
                    if (locale.equals("fi")) {
                    }
                    break;
                case 3276:
                    if (locale.equals("fr")) {
                    }
                    break;
                case 3329:
                    if (locale.equals("hi")) {
                    }
                    break;
                case 3338:
                    if (locale.equals("hr")) {
                    }
                    break;
                case 3341:
                    if (locale.equals("hu")) {
                    }
                    break;
                case 3371:
                    if (locale.equals("it")) {
                    }
                    break;
                case 3383:
                    if (locale.equals("ja")) {
                    }
                    break;
                case 3428:
                    if (locale.equals("ko")) {
                    }
                    break;
                case 3464:
                    if (locale.equals("lt")) {
                    }
                    break;
                case 3518:
                    if (locale.equals("nl")) {
                    }
                    break;
                case 3521:
                    if (locale.equals("no")) {
                    }
                    break;
                case 3580:
                    if (locale.equals("pl")) {
                    }
                    break;
                case 3645:
                    if (locale.equals("ro")) {
                    }
                    break;
                case 3651:
                    if (locale.equals("ru")) {
                    }
                    break;
                case 3700:
                    if (locale.equals("th")) {
                    }
                    break;
                case 3710:
                    if (locale.equals("tr")) {
                    }
                    break;
                case 3734:
                    if (locale.equals("uk")) {
                    }
                    break;
                case 3763:
                    if (locale.equals("vi")) {
                    }
                    break;
                case 96598143:
                    if (locale.equals("en-GB")) {
                    }
                    break;
                case 96598594:
                    locale.equals("en-US");
                    break;
                case 96747053:
                    if (locale.equals("es-ES")) {
                    }
                    break;
                case 106935481:
                    if (locale.equals("pt-BR")) {
                    }
                    break;
                case 109766140:
                    if (locale.equals("sv-SE")) {
                    }
                    break;
                case 115813226:
                    if (locale.equals("zh-CN")) {
                    }
                    break;
                case 115813762:
                    if (locale.equals("zh-TW")) {
                    }
                    break;
            }
            return C5419R.string.en_us;
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsLanguage.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class C96411 extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $locale;

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
            public static final class C132891 extends Lambda implements Function1<ModelUserSettings, Unit> {
                public C132891() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
                    invoke2(modelUserSettings);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ModelUserSettings modelUserSettings) {
                    Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
                    AppToast.m169g(WidgetSettingsLanguage.this.requireContext(), C5419R.string.language_updated, 0, null, 12);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str) {
                super(0);
                this.$locale = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithLocale(this.$locale)), false, 1, null), WidgetSettingsLanguage.this, null, 2, null), StoreUserSettings.class, WidgetSettingsLanguage.this.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C132891(), 60, (Object) null);
            }
        }

        public C96411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "locale");
            StoreStream.INSTANCE.getUserSettingsSystem().setLocale(str, true, new AnonymousClass1(str));
            AppActivity appActivity = WidgetSettingsLanguage.this.getAppActivity();
            if (appActivity != null) {
                appActivity.recreate();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class C96421 extends Lambda implements Function1<StoreUserSettingsSystem.Settings, Unit> {
        public C96421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserSettingsSystem.Settings settings) {
            invoke2(settings);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserSettingsSystem.Settings settings) {
            Intrinsics3.checkNotNullParameter(settings, "settings");
            WidgetSettingsLanguage.access$configureUI(WidgetSettingsLanguage.this, settings.getLocale());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class C96432<T> implements Action1<Boolean> {
        public static final C96432 INSTANCE = new C96432();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            userSettingsSystem.setIsLocaleSyncEnabled(bool.booleanValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
    public static final class ViewOnClickListenerC96443 implements View.OnClickListener {
        public ViewOnClickListenerC96443() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsLanguageSelect.INSTANCE.show(WidgetSettingsLanguage.this);
        }
    }

    public WidgetSettingsLanguage() {
        super(C5419R.layout.widget_settings_language);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsLanguage2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsLanguage widgetSettingsLanguage, String str) {
        widgetSettingsLanguage.configureUI(str);
    }

    private final void configureUI(String locale) {
        TextView textView = getBinding().f17995d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsLanguageCurrentText");
        Companion companion = INSTANCE;
        textView.setText(getString(companion.getLocaleResId(locale)));
        getBinding().f17994c.setImageResource(companion.getLocaleFlagResId(locale));
    }

    private final WidgetSettingsLanguageBinding getBinding() {
        return (WidgetSettingsLanguageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.language);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new C96411());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.getUserSettingsSystem().observeSettings(false), this, null, 2, null), WidgetSettingsLanguage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96421(), 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().f17997f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsLanguageSyncCheck");
        checkedSetting.setChecked(companion.getUserSettingsSystem().getIsLocaleSyncEnabled());
        getBinding().f17997f.setOnCheckedListener(C96432.INSTANCE);
        getBinding().f17993b.setOnClickListener(new ViewOnClickListenerC96443());
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f17996e, getBinding().f17998g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
