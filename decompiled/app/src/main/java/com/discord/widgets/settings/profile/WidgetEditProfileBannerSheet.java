package com.discord.widgets.settings.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.SingleValuePropPremiumUpsellDialog;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p007b.p440k.p441a.p442a.ColorPickerDialogListener;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet extends AppBottomSheet {
    private static final String ARG_DEFAULT_BANNER_COLOR_HEX = "ARG_DEFAULT_BANNER_COLOR_HEX";
    private static final String ARG_HAS_BANNER_IMAGE = "ARG_HAS_BANNER_IMAGE";
    private static final String ARG_INITIAL_COLOR_PREVIEW_HEX = "ARG_INITIAL_COLOR_PREVIEW_HEX";
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ColorPickerDialog colorPickerDialog;
    private int defaultBannerColor;

    /* JADX INFO: renamed from: isGuildContext$delegate, reason: from kotlin metadata */
    private final Lazy isGuildContext;
    private Function0<Unit> onChangeProfileBannerImage;
    private Function1<? super Integer, Unit> onColorSelected;
    private Function0<Unit> onRemoveProfileBannerImage;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetEditProfileBannerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, Long l, String str, String str2, boolean z2, FragmentManager fragmentManager, Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
            companion.show((i & 1) != 0 ? null : l, str, str2, z2, fragmentManager, (i & 32) != 0 ? WidgetEditProfileBannerSheet2.INSTANCE : function0, (i & 64) != 0 ? WidgetEditProfileBannerSheet3.INSTANCE : function02, (i & 128) != 0 ? WidgetEditProfileBannerSheet4.INSTANCE : function1);
        }

        public final void show(Long guildId, String defaultBannerColorHex, String initialColorPreviewHex, boolean hasBannerImage, FragmentManager fragmentManager, Function0<Unit> onChangeProfileBannerImage, Function0<Unit> onRemoveProfileBannerImage, Function1<? super Integer, Unit> onColorSelected) {
            Intrinsics3.checkNotNullParameter(defaultBannerColorHex, "defaultBannerColorHex");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(onChangeProfileBannerImage, "onChangeProfileBannerImage");
            Intrinsics3.checkNotNullParameter(onRemoveProfileBannerImage, "onRemoveProfileBannerImage");
            Intrinsics3.checkNotNullParameter(onColorSelected, "onColorSelected");
            WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = new WidgetEditProfileBannerSheet();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetEditProfileBannerSheet.ARG_DEFAULT_BANNER_COLOR_HEX, defaultBannerColorHex);
            bundle.putString(WidgetEditProfileBannerSheet.ARG_INITIAL_COLOR_PREVIEW_HEX, initialColorPreviewHex);
            bundle.putBoolean(WidgetEditProfileBannerSheet.ARG_HAS_BANNER_IMAGE, hasBannerImage);
            if (guildId != null) {
                bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            widgetEditProfileBannerSheet.setArguments(bundle);
            widgetEditProfileBannerSheet.setOnChangeProfileBannerImage(onChangeProfileBannerImage);
            widgetEditProfileBannerSheet.setOnRemoveProfileBannerImage(onRemoveProfileBannerImage);
            widgetEditProfileBannerSheet.setOnColorSelected(onColorSelected);
            widgetEditProfileBannerSheet.show(fragmentManager, WidgetEditProfileBannerSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$configureUi$1 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class ViewOnClickListenerC99611 implements View.OnClickListener {
        public final /* synthetic */ Ref$ObjectRef $bannerColor;

        public ViewOnClickListenerC99611(Ref$ObjectRef ref$ObjectRef) {
            this.$bannerColor = ref$ObjectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = WidgetEditProfileBannerSheet.this;
            Integer num = (Integer) this.$bannerColor.element;
            WidgetEditProfileBannerSheet.access$launchColorPicker(widgetEditProfileBannerSheet, num != null ? num.intValue() : WidgetEditProfileBannerSheet.access$getDefaultBannerColor$p(widgetEditProfileBannerSheet));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$configureUi$2 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class ViewOnClickListenerC99622 implements View.OnClickListener {
        public final /* synthetic */ EditProfileBannerSheetViewModel.ViewState $viewState;

        public ViewOnClickListenerC99622(EditProfileBannerSheetViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getShowPremiumUpsell()) {
                WidgetEditProfileBannerSheet.access$navigateToUpsellModal(WidgetEditProfileBannerSheet.this);
            } else {
                WidgetEditProfileBannerSheet.this.getOnChangeProfileBannerImage().invoke();
                WidgetEditProfileBannerSheet.this.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$isGuildContext$2 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class C99632 extends Lambda implements Function0<Boolean> {
        public C99632() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(WidgetEditProfileBannerSheet.this).getLong("com.discord.intent.extra.EXTRA_GUILD_ID") > 0;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$launchColorPicker$1 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class C99641 implements ColorPickerDialogListener {
        public C99641() {
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onColorReset(int dialogId) {
            WidgetEditProfileBannerSheet.access$getViewModel$p(WidgetEditProfileBannerSheet.this).updateColorPreview(null);
            WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(null);
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onColorSelected(int dialogId, int selectedColor) {
            EditProfileBannerSheetViewModel editProfileBannerSheetViewModelAccess$getViewModel$p = WidgetEditProfileBannerSheet.access$getViewModel$p(WidgetEditProfileBannerSheet.this);
            ColorCompat colorCompat = ColorCompat.INSTANCE;
            editProfileBannerSheetViewModelAccess$getViewModel$p.updateColorPreview(colorCompat.getColorHexFromColorInt(selectedColor));
            WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(Integer.valueOf(colorCompat.removeAlphaComponent(selectedColor)));
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onDialogDismissed(int dialogId) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class C99651 extends Lambda implements Function1<EditProfileBannerSheetViewModel.ViewState, Unit> {
        public C99651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditProfileBannerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditProfileBannerSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetEditProfileBannerSheet.access$configureUi(WidgetEditProfileBannerSheet.this, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class ViewOnClickListenerC99661 implements View.OnClickListener {
        public ViewOnClickListenerC99661() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet.access$navigateToUpsellModal(WidgetEditProfileBannerSheet.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class ViewOnClickListenerC99672 implements View.OnClickListener {
        public ViewOnClickListenerC99672() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet.this.getOnRemoveProfileBannerImage().invoke();
            WidgetEditProfileBannerSheet.this.dismiss();
        }
    }

    public WidgetEditProfileBannerSheet() {
        super(false, 1, null);
        this.onChangeProfileBannerImage = WidgetEditProfileBannerSheet6.INSTANCE;
        this.onRemoveProfileBannerImage = WidgetEditProfileBannerSheet8.INSTANCE;
        this.onColorSelected = WidgetEditProfileBannerSheet7.INSTANCE;
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEditProfileBannerSheet5.INSTANCE, null, 2, null);
        this.isGuildContext = LazyJVM.lazy(new C99632());
        WidgetEditProfileBannerSheet9 widgetEditProfileBannerSheet9 = new WidgetEditProfileBannerSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EditProfileBannerSheetViewModel.class), new WidgetEditProfileBannerSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetEditProfileBannerSheet9));
    }

    public static final /* synthetic */ void access$configureUi(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, EditProfileBannerSheetViewModel.ViewState viewState) {
        widgetEditProfileBannerSheet.configureUi(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ int access$getDefaultBannerColor$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.defaultBannerColor;
    }

    public static final /* synthetic */ EditProfileBannerSheetViewModel access$getViewModel$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.getViewModel();
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, int i) {
        widgetEditProfileBannerSheet.launchColorPicker(i);
    }

    public static final /* synthetic */ void access$navigateToUpsellModal(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        widgetEditProfileBannerSheet.navigateToUpsellModal();
    }

    public static final /* synthetic */ void access$setDefaultBannerColor$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, int i) {
        widgetEditProfileBannerSheet.defaultBannerColor = i;
    }

    private final void configureStringsForGuild() {
        MaterialTextView materialTextView = getBinding().f16494e;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.bannerColorItemTitle");
        materialTextView.setText(FormatUtils.m219k(this, C5419R.string.change_identity_profile_color, new Object[0], null, 4));
        MaterialTextView materialTextView2 = getBinding().f16492c;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.bannerChangeImageItemTitle");
        materialTextView2.setText(FormatUtils.m219k(this, C5419R.string.change_identity_profile_banner, new Object[0], null, 4));
        MaterialTextView materialTextView3 = getBinding().f16496g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.bannerRemoveImageItem");
        materialTextView3.setText(FormatUtils.m219k(this, C5419R.string.change_identity_reset_banner, new Object[0], null, 4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Integer] */
    private final void configureUi(EditProfileBannerSheetViewModel.ViewState viewState) {
        if (viewState instanceof EditProfileBannerSheetViewModel.ViewState) {
            String bannerColorHex = viewState.getBannerColorHex();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            if (isGuildContext()) {
                configureStringsForGuild();
            }
            if (bannerColorHex != null) {
                try {
                    ref$ObjectRef.element = Integer.valueOf(Color.parseColor(bannerColorHex));
                } catch (IllegalArgumentException e) {
                    Logger.e$default(AppLog.f14950g, outline.m883w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
                }
            }
            if (((Integer) ref$ObjectRef.element) != null) {
                ImageView imageView = getBinding().f16495f;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.bannerColorPreview");
                ColorCompat2.tintWithColor(imageView, ((Integer) ref$ObjectRef.element).intValue());
            }
            ImageView imageView2 = getBinding().f16495f;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.bannerColorPreview");
            imageView2.setVisibility(((Integer) ref$ObjectRef.element) == null ? 4 : 0);
            getBinding().f16493d.setOnClickListener(new ViewOnClickListenerC99611(ref$ObjectRef));
            MaterialButton materialButton = getBinding().f16497h;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellButton");
            materialButton.setVisibility(viewState.getShowPremiumUpsell() ? 0 : 8);
            MaterialButton materialButton2 = getBinding().f16497h;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellButton");
            if ((materialButton2.getVisibility() == 0) && !getViewModel().getUpsellViewedTracked()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.CustomProfileBannerUpsell, new Traits.Location(Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER, null, null, 24, null), null, null, 12, null);
                getViewModel().setUpsellViewedTracked(true);
            }
            getBinding().f16491b.setOnClickListener(new ViewOnClickListenerC99622(viewState));
        }
        KotlinExtensions.getExhaustive(Unit.f27425a);
    }

    private final WidgetEditProfileBannerSheetBinding getBinding() {
        return (WidgetEditProfileBannerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final EditProfileBannerSheetViewModel getViewModel() {
        return (EditProfileBannerSheetViewModel) this.viewModel.getValue();
    }

    private final boolean isGuildContext() {
        return ((Boolean) this.isGuildContext.getValue()).booleanValue();
    }

    private final void launchColorPicker(@ColorInt int initialColor) {
        ColorPickerDialog.C11163k c11163k = new ColorPickerDialog.C11163k();
        c11163k.f21754h = initialColor;
        c11163k.f21765s = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundPrimary);
        c11163k.f21755i = false;
        c11163k.f21756j = false;
        c11163k.f21752f = 0;
        c11163k.f21747a = C5419R.string.user_settings_banner_color_title;
        c11163k.f21764r = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        c11163k.f21770x = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_display_bold);
        c11163k.f21758l = true;
        c11163k.f21751e = C5419R.string.color_picker_use_default;
        c11163k.f21762p = ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand);
        c11163k.f21750d = C5419R.string.select;
        c11163k.f21769w = ColorCompat.getColor(getContext(), C5419R.color.white);
        c11163k.f21771y = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_semibold);
        c11163k.f21766t = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextMuted);
        c11163k.f21767u = C5419R.drawable.drawable_cpv_edit_text_background;
        c11163k.f21772z = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogM9275a = c11163k.m9275a();
        colorPickerDialogM9275a.f21719k = new C99641();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogM9275a.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
        this.colorPickerDialog = colorPickerDialogM9275a;
    }

    private final void navigateToUpsellModal() {
        SingleValuePropPremiumUpsellDialog.Companion companion = SingleValuePropPremiumUpsellDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.CustomProfileUpsellModal;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        String string = FormatUtils.m217i(resources, C5419R.string.premium_profile_customization_upsell_header, new Object[0], null, 4).toString();
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        companion.m117a(parentFragmentManager, premiumUpsellType, C5419R.drawable.img_profile_banner_value_prop, string, FormatUtils.m217i(resources2, C5419R.string.premium_profile_customization_upsell_body, new Object[0], null, 4).toString(), Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_edit_profile_banner_sheet;
    }

    public final Function0<Unit> getOnChangeProfileBannerImage() {
        return this.onChangeProfileBannerImage;
    }

    public final Function1<Integer, Unit> getOnColorSelected() {
        return this.onColorSelected;
    }

    public final Function0<Unit> getOnRemoveProfileBannerImage() {
        return this.onRemoveProfileBannerImage;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
        ColorPickerDialog colorPickerDialog = this.colorPickerDialog;
        if (colorPickerDialog != null) {
            colorPickerDialog.dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEditProfileBannerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C99651(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence charSequenceM217i;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f16497h.setOnClickListener(new ViewOnClickListenerC99661());
        getBinding().f16496g.setOnClickListener(new ViewOnClickListenerC99672());
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_HAS_BANNER_IMAGE);
        MaterialTextView materialTextView = getBinding().f16492c;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.bannerChangeImageItemTitle");
        if (z2) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            charSequenceM217i = FormatUtils.m217i(resources, C5419R.string.user_settings_change_profile_banner, new Object[0], null, 4);
        } else {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            charSequenceM217i = FormatUtils.m217i(resources2, C5419R.string.user_settings_upload_banner, new Object[0], null, 4);
        }
        materialTextView.setText(charSequenceM217i);
        MaterialTextView materialTextView2 = getBinding().f16496g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.bannerRemoveImageItem");
        materialTextView2.setVisibility(z2 ? 0 : 8);
    }

    public final void setOnChangeProfileBannerImage(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onChangeProfileBannerImage = function0;
    }

    public final void setOnColorSelected(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onColorSelected = function1;
    }

    public final void setOnRemoveProfileBannerImage(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onRemoveProfileBannerImage = function0;
    }
}
