package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccessibilityBinding;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.t.n;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetSettingsAccessibility.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccessibility extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccessibility.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager stickersAnimationRadioManager;

    /* compiled from: WidgetSettingsAccessibility.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetSettingsAccessibility.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean allowAnimatedEmoji;
        private final boolean autoPlayGifs;
        private final int currentStickerAnimationSettings;
        private final boolean reducedMotionEnabled;

        /* compiled from: WidgetSettingsAccessibility.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableH = Observable.h(companion.getAccessibility().observeReducedMotionEnabled(), companion.getUserSettings().observeIsAnimatedEmojisEnabled(false), companion.getUserSettings().observeIsAutoPlayGifsEnabled(false), companion.getUserSettings().observeStickerAnimationSettings(false), WidgetSettingsAccessibility$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…ngs\n          )\n        }");
                return observableH;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(boolean z2, boolean z3, boolean z4, int i) {
            this.reducedMotionEnabled = z2;
            this.allowAnimatedEmoji = z3;
            this.autoPlayGifs = z4;
            this.currentStickerAnimationSettings = i;
        }

        public static /* synthetic */ Model copy$default(Model model, boolean z2, boolean z3, boolean z4, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = model.reducedMotionEnabled;
            }
            if ((i2 & 2) != 0) {
                z3 = model.allowAnimatedEmoji;
            }
            if ((i2 & 4) != 0) {
                z4 = model.autoPlayGifs;
            }
            if ((i2 & 8) != 0) {
                i = model.currentStickerAnimationSettings;
            }
            return model.copy(z2, z3, z4, i);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAllowAnimatedEmoji() {
            return this.allowAnimatedEmoji;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        /* renamed from: component4, reason: from getter */
        public final int getCurrentStickerAnimationSettings() {
            return this.currentStickerAnimationSettings;
        }

        public final Model copy(boolean reducedMotionEnabled, boolean allowAnimatedEmoji, boolean autoPlayGifs, int currentStickerAnimationSettings) {
            return new Model(reducedMotionEnabled, allowAnimatedEmoji, autoPlayGifs, currentStickerAnimationSettings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.reducedMotionEnabled == model.reducedMotionEnabled && this.allowAnimatedEmoji == model.allowAnimatedEmoji && this.autoPlayGifs == model.autoPlayGifs && this.currentStickerAnimationSettings == model.currentStickerAnimationSettings;
        }

        public final boolean getAllowAnimatedEmoji() {
            return this.allowAnimatedEmoji;
        }

        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        public final int getCurrentStickerAnimationSettings() {
            return this.currentStickerAnimationSettings;
        }

        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.reducedMotionEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.allowAnimatedEmoji;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.autoPlayGifs;
            return ((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.currentStickerAnimationSettings;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(reducedMotionEnabled=");
            sbU.append(this.reducedMotionEnabled);
            sbU.append(", allowAnimatedEmoji=");
            sbU.append(this.allowAnimatedEmoji);
            sbU.append(", autoPlayGifs=");
            sbU.append(this.autoPlayGifs);
            sbU.append(", currentStickerAnimationSettings=");
            return a.B(sbU, this.currentStickerAnimationSettings, ")");
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$configureStickerAnimationRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ int $stickerAnimationSetting;

        public AnonymousClass1(int i) {
            this.$stickerAnimationSetting = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserSettings().setStickerAnimationSettings(WidgetSettingsAccessibility.this.getAppActivity(), this.$stickerAnimationSetting);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).f2589b;
            m.checkNotNullExpressionValue(WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).f2589b, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
            checkedSetting.g(!r0.isChecked(), true);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).c;
            m.checkNotNullExpressionValue(WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).c, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
            checkedSetting.g(!r0.isChecked(), true);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSettingsAccessibility widgetSettingsAccessibility) {
            super(1, widgetSettingsAccessibility, WidgetSettingsAccessibility.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "p1");
            WidgetSettingsAccessibility.access$configureUI((WidgetSettingsAccessibility) this.receiver, model);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreAccessibility accessibility = StoreStream.INSTANCE.getAccessibility();
            m.checkNotNullExpressionValue(bool, "it");
            accessibility.setReducedMotionEnabled(bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
            AppActivity appActivity = WidgetSettingsAccessibility.this.getAppActivity();
            m.checkNotNullExpressionValue(bool, "checked");
            userSettings.setIsAnimatedEmojisEnabled(appActivity, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<Boolean> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
            m.checkNotNullExpressionValue(bool, "checked");
            userSettings.setIsAutoPlayGifsEnabled(bool.booleanValue());
        }
    }

    public WidgetSettingsAccessibility() {
        super(R.layout.widget_settings_accessibility);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccessibility$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccessibility widgetSettingsAccessibility, Model model) {
        widgetSettingsAccessibility.configureUI(model);
    }

    public static final /* synthetic */ WidgetSettingsAccessibilityBinding access$getBinding$p(WidgetSettingsAccessibility widgetSettingsAccessibility) {
        return widgetSettingsAccessibility.getBinding();
    }

    private final void configureStickerAnimationRadio(int currentStickerAnimationSettings, CheckedSetting radio, int stickerAnimationSetting) {
        radio.e(new AnonymousClass1(stickerAnimationSetting));
        RadioManager radioManager = this.stickersAnimationRadioManager;
        if (radioManager == null || currentStickerAnimationSettings != stickerAnimationSetting || radioManager == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureUI(Model model) {
        CheckedSetting checkedSetting = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccessibilityReducedMotionSwitch");
        checkedSetting.setChecked(model.getReducedMotionEnabled());
        if (!model.getReducedMotionEnabled()) {
            CheckedSetting checkedSetting2 = getBinding().f2589b;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
            checkedSetting2.setChecked(model.getAllowAnimatedEmoji());
            int currentStickerAnimationSettings = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting3 = getBinding().i;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.stickersAlwaysAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings, checkedSetting3, 0);
            int currentStickerAnimationSettings2 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting4 = getBinding().j;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.stickersAnimateOnInteraction");
            configureStickerAnimationRadio(currentStickerAnimationSettings2, checkedSetting4, 1);
            int currentStickerAnimationSettings3 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting5 = getBinding().k;
            m.checkNotNullExpressionValue(checkedSetting5, "binding.stickersNeverAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings3, checkedSetting5, 2);
            CheckedSetting checkedSetting6 = getBinding().c;
            m.checkNotNullExpressionValue(checkedSetting6, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
            checkedSetting6.setChecked(model.getAutoPlayGifs());
            getBinding().f2589b.e(new AnonymousClass1());
            getBinding().c.e(new AnonymousClass2());
            return;
        }
        getBinding().f2589b.b(R.string.accessibility_reduced_motion_settings_override);
        CheckedSetting checkedSetting7 = getBinding().f2589b;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
        checkedSetting7.setChecked(false);
        Iterator it = n.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}).iterator();
        while (it.hasNext()) {
            ((CheckedSetting) it.next()).b(R.string.stickers_auto_play_help_disabled);
        }
        if (model.getCurrentStickerAnimationSettings() != 2) {
            RadioManager radioManager = this.stickersAnimationRadioManager;
            if (radioManager != null) {
                CheckedSetting checkedSetting8 = getBinding().j;
                m.checkNotNullExpressionValue(checkedSetting8, "binding.stickersAnimateOnInteraction");
                radioManager.a(checkedSetting8);
            }
        } else {
            RadioManager radioManager2 = this.stickersAnimationRadioManager;
            if (radioManager2 != null) {
                CheckedSetting checkedSetting9 = getBinding().k;
                m.checkNotNullExpressionValue(checkedSetting9, "binding.stickersNeverAnimate");
                radioManager2.a(checkedSetting9);
            }
        }
        CheckedSetting checkedSetting10 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting10, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
        checkedSetting10.setChecked(false);
        getBinding().c.b(R.string.accessibility_reduced_motion_settings_override);
    }

    private final WidgetSettingsAccessibilityBinding getBinding() {
        return (WidgetSettingsAccessibilityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetSettingsAccessibility.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        setActionBarTitle(R.string.accessibility);
        setActionBarSubtitle(R.string.user_settings);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().g.setOnCheckedListener(AnonymousClass2.INSTANCE);
        LinkifiedTextView linkifiedTextView = getBinding().e;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccessib…yReducedMotionDescription");
        b.n(linkifiedTextView, R.string.accessibility_prefers_reduced_motion_description, new Object[]{f.a.a(360040613412L, null)}, null, 4);
        getBinding().f2589b.setOnCheckedListener(new AnonymousClass3());
        getBinding().c.setOnCheckedListener(AnonymousClass4.INSTANCE);
        this.stickersAnimationRadioManager = new RadioManager(n.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}));
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().f, getBinding().d, getBinding().h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
