package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsMediaBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.MultiValuePropPremiumUpsellDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* compiled from: WidgetSettingsMedia.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsMedia extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsMedia.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsMediaBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PREVIEW_MAX_SIZE_MB = "10";
    private StoreAccessibility accessibilitySettings;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private StoreUserSettings userSettings;

    /* compiled from: WidgetSettingsMedia.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsMedia.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsMedia.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$1 */
    public static final class C96461<T> implements Action1<Boolean> {
        public C96461() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
            AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            storeUserSettingsAccess$getUserSettings$p.setIsAttachmentMediaInline(appActivity, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsMedia.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$2 */
    public static final class C96472<T> implements Action1<Boolean> {
        public C96472() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            storeUserSettingsAccess$getUserSettings$p.setIsAutoImageCompressionEnabled(bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsMedia.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$3 */
    public static final class C96483 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetSettingsMedia.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                MultiValuePropPremiumUpsellDialog.Companion companion = MultiValuePropPremiumUpsellDialog.INSTANCE;
                FragmentManager childFragmentManager = WidgetSettingsMedia.this.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                MultiValuePropPremiumUpsellDialog.Companion.m114a(companion, childFragmentManager, 3, null, null, null, "Image Compression Settings", null, null, false, false, 988);
            }
        }

        public C96483() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("getNitro", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetSettingsMedia.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$4 */
    public static final class C96494<T> implements Action1<Boolean> {
        public C96494() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
            AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            storeUserSettingsAccess$getUserSettings$p.setIsEmbedMediaInlined(appActivity, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsMedia.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$5 */
    public static final class C96505<T> implements Action1<Boolean> {
        public C96505() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
            AppActivity appActivity = WidgetSettingsMedia.this.getAppActivity();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            storeUserSettingsAccess$getUserSettings$p.setIsRenderEmbedsEnabled(appActivity, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsMedia.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$6 */
    public static final class C96516<T> implements Action1<Boolean> {
        public C96516() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this);
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            storeUserSettingsAccess$getUserSettings$p.getIsSyncTextAndImagesEnabled(bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsMedia.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$onViewBound$7 */
    public static final class C96527<T> implements Action1<Boolean> {
        public C96527() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            analyticsTracker.stickerSuggestionsEnabledToggled(bool.booleanValue(), new Traits.Location(null, Traits.Location.Section.SETTINGS_TEXT_AND_IMAGES, null, null, null, 29, null));
            WidgetSettingsMedia.access$getUserSettings$p(WidgetSettingsMedia.this).setIsStickerSuggestionsEnabled(bool.booleanValue());
        }
    }

    public WidgetSettingsMedia() {
        super(C5419R.layout.widget_settings_media);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsMedia2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ StoreUserSettings access$getUserSettings$p(WidgetSettingsMedia widgetSettingsMedia) {
        StoreUserSettings storeUserSettings = widgetSettingsMedia.userSettings;
        if (storeUserSettings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        return storeUserSettings;
    }

    public static final /* synthetic */ void access$setUserSettings$p(WidgetSettingsMedia widgetSettingsMedia, StoreUserSettings storeUserSettings) {
        widgetSettingsMedia.userSettings = storeUserSettings;
    }

    private final WidgetSettingsMediaBinding getBinding() {
        return (WidgetSettingsMediaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.text_and_images);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        this.userSettings = companion.getUserSettings();
        this.accessibilitySettings = companion.getAccessibility();
        CheckedSetting checkedSetting = getBinding().f18006b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.attachmentsToggle");
        StoreUserSettings storeUserSettings = this.userSettings;
        if (storeUserSettings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting.setChecked(storeUserSettings.getIsAttachmentMediaInline());
        CheckedSetting.m8524i(getBinding().f18006b, FormatUtils.m219k(this, C5419R.string.inline_attachment_media_help, new Object[]{PREVIEW_MAX_SIZE_MB}, null, 4), false, 2);
        getBinding().f18006b.setOnCheckedListener(new C96461());
        getBinding().f18007c.setOnCheckedListener(new C96472());
        CheckedSetting checkedSetting2 = getBinding().f18007c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.compressionToggle");
        StoreUserSettings storeUserSettings2 = this.userSettings;
        if (storeUserSettings2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting2.setChecked(storeUserSettings2.getIsAutoImageCompressionEnabled());
        LinkifiedTextView linkifiedTextView = getBinding().f18008d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.compressionToggleSubtext");
        FormatUtils.m221m(linkifiedTextView, C5419R.string.image_compression_nitro_upsell, new Object[]{"getNitro"}, new C96483());
        CheckedSetting checkedSetting3 = getBinding().f18011g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsTextImagesEmbedsToggle");
        StoreUserSettings storeUserSettings3 = this.userSettings;
        if (storeUserSettings3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting3.setChecked(storeUserSettings3.getIsEmbedMediaInlined());
        getBinding().f18011g.setOnCheckedListener(new C96494());
        CheckedSetting checkedSetting4 = getBinding().f18012h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsTextImagesLinksToggle");
        StoreUserSettings storeUserSettings4 = this.userSettings;
        if (storeUserSettings4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting4.setChecked(storeUserSettings4.getIsRenderEmbedsEnabled());
        getBinding().f18012h.setOnCheckedListener(new C96505());
        CheckedSetting checkedSetting5 = getBinding().f18016l;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsTextImagesSyncToggle");
        StoreUserSettings storeUserSettings5 = this.userSettings;
        if (storeUserSettings5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting5.setChecked(storeUserSettings5.getIsSyncTextAndImagesEnabled());
        getBinding().f18016l.setOnCheckedListener(new C96516());
        CheckedSetting checkedSetting6 = getBinding().f18017m;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.stickersSuggestions");
        StoreUserSettings storeUserSettings6 = this.userSettings;
        if (storeUserSettings6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userSettings");
        }
        checkedSetting6.setChecked(storeUserSettings6.getIsStickerSuggestionsEnabled());
        getBinding().f18017m.setOnCheckedListener(new C96527());
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f18010f, getBinding().f18014j, getBinding().f18009e, getBinding().f18013i, getBinding().f18015k})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
