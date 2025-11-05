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
import b.a.a.b.d;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import b.k.a.a.f;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;

/* compiled from: WidgetEditProfileBannerSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet extends AppBottomSheet {
    private static final String ARG_DEFAULT_BANNER_COLOR_HEX = "ARG_DEFAULT_BANNER_COLOR_HEX";
    private static final String ARG_HAS_BANNER_IMAGE = "ARG_HAS_BANNER_IMAGE";
    private static final String ARG_INITIAL_COLOR_PREVIEW_HEX = "ARG_INITIAL_COLOR_PREVIEW_HEX";
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ColorPickerDialog colorPickerDialog;
    private int defaultBannerColor;

    /* renamed from: isGuildContext$delegate, reason: from kotlin metadata */
    private final Lazy isGuildContext;
    private Function0<Unit> onChangeProfileBannerImage;
    private Function1<? super Integer, Unit> onColorSelected;
    private Function0<Unit> onRemoveProfileBannerImage;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEditProfileBannerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Long l, String str, String str2, boolean z2, FragmentManager fragmentManager, Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
            companion.show((i & 1) != 0 ? null : l, str, str2, z2, fragmentManager, (i & 32) != 0 ? WidgetEditProfileBannerSheet$Companion$show$1.INSTANCE : function0, (i & 64) != 0 ? WidgetEditProfileBannerSheet$Companion$show$2.INSTANCE : function02, (i & 128) != 0 ? WidgetEditProfileBannerSheet$Companion$show$3.INSTANCE : function1);
        }

        public final void show(Long guildId, String defaultBannerColorHex, String initialColorPreviewHex, boolean hasBannerImage, FragmentManager fragmentManager, Function0<Unit> onChangeProfileBannerImage, Function0<Unit> onRemoveProfileBannerImage, Function1<? super Integer, Unit> onColorSelected) {
            m.checkNotNullParameter(defaultBannerColorHex, "defaultBannerColorHex");
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(onChangeProfileBannerImage, "onChangeProfileBannerImage");
            m.checkNotNullParameter(onRemoveProfileBannerImage, "onRemoveProfileBannerImage");
            m.checkNotNullParameter(onColorSelected, "onColorSelected");
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

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$configureUi$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Ref$ObjectRef $bannerColor;

        public AnonymousClass1(Ref$ObjectRef ref$ObjectRef) {
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

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$configureUi$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ EditProfileBannerSheetViewModel.ViewState $viewState;

        public AnonymousClass2(EditProfileBannerSheetViewModel.ViewState viewState) {
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

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$isGuildContext$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Boolean> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(WidgetEditProfileBannerSheet.this).getLong("com.discord.intent.extra.EXTRA_GUILD_ID") > 0;
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$launchColorPicker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements f {
        public AnonymousClass1() {
        }

        @Override // b.k.a.a.f
        public void onColorReset(int dialogId) {
            WidgetEditProfileBannerSheet.access$getViewModel$p(WidgetEditProfileBannerSheet.this).updateColorPreview(null);
            WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(null);
        }

        @Override // b.k.a.a.f
        public void onColorSelected(int dialogId, int selectedColor) {
            EditProfileBannerSheetViewModel editProfileBannerSheetViewModelAccess$getViewModel$p = WidgetEditProfileBannerSheet.access$getViewModel$p(WidgetEditProfileBannerSheet.this);
            ColorCompat colorCompat = ColorCompat.INSTANCE;
            editProfileBannerSheetViewModelAccess$getViewModel$p.updateColorPreview(colorCompat.getColorHexFromColorInt(selectedColor));
            WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(Integer.valueOf(colorCompat.removeAlphaComponent(selectedColor)));
        }

        @Override // b.k.a.a.f
        public void onDialogDismissed(int dialogId) {
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<EditProfileBannerSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditProfileBannerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditProfileBannerSheetViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetEditProfileBannerSheet.access$configureUi(WidgetEditProfileBannerSheet.this, viewState);
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet.access$navigateToUpsellModal(WidgetEditProfileBannerSheet.this);
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet.this.getOnRemoveProfileBannerImage().invoke();
            WidgetEditProfileBannerSheet.this.dismiss();
        }
    }

    public WidgetEditProfileBannerSheet() {
        super(false, 1, null);
        this.onChangeProfileBannerImage = WidgetEditProfileBannerSheet$onChangeProfileBannerImage$1.INSTANCE;
        this.onRemoveProfileBannerImage = WidgetEditProfileBannerSheet$onRemoveProfileBannerImage$1.INSTANCE;
        this.onColorSelected = WidgetEditProfileBannerSheet$onColorSelected$1.INSTANCE;
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEditProfileBannerSheet$binding$2.INSTANCE, null, 2, null);
        this.isGuildContext = g.lazy(new AnonymousClass2());
        WidgetEditProfileBannerSheet$viewModel$2 widgetEditProfileBannerSheet$viewModel$2 = new WidgetEditProfileBannerSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(EditProfileBannerSheetViewModel.class), new WidgetEditProfileBannerSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetEditProfileBannerSheet$viewModel$2));
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
        MaterialTextView materialTextView = getBinding().e;
        m.checkNotNullExpressionValue(materialTextView, "binding.bannerColorItemTitle");
        materialTextView.setText(b.k(this, R.string.change_identity_profile_color, new Object[0], null, 4));
        MaterialTextView materialTextView2 = getBinding().c;
        m.checkNotNullExpressionValue(materialTextView2, "binding.bannerChangeImageItemTitle");
        materialTextView2.setText(b.k(this, R.string.change_identity_profile_banner, new Object[0], null, 4));
        MaterialTextView materialTextView3 = getBinding().g;
        m.checkNotNullExpressionValue(materialTextView3, "binding.bannerRemoveImageItem");
        materialTextView3.setText(b.k(this, R.string.change_identity_reset_banner, new Object[0], null, 4));
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
                    Logger.e$default(AppLog.g, a.w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
                }
            }
            if (((Integer) ref$ObjectRef.element) != null) {
                ImageView imageView = getBinding().f;
                m.checkNotNullExpressionValue(imageView, "binding.bannerColorPreview");
                ColorCompatKt.tintWithColor(imageView, ((Integer) ref$ObjectRef.element).intValue());
            }
            ImageView imageView2 = getBinding().f;
            m.checkNotNullExpressionValue(imageView2, "binding.bannerColorPreview");
            imageView2.setVisibility(((Integer) ref$ObjectRef.element) == null ? 4 : 0);
            getBinding().d.setOnClickListener(new AnonymousClass1(ref$ObjectRef));
            MaterialButton materialButton = getBinding().h;
            m.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellButton");
            materialButton.setVisibility(viewState.getShowPremiumUpsell() ? 0 : 8);
            MaterialButton materialButton2 = getBinding().h;
            m.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellButton");
            if ((materialButton2.getVisibility() == 0) && !getViewModel().getUpsellViewedTracked()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.CustomProfileBannerUpsell, new Traits.Location(Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER, null, null, 24, null), null, null, 12, null);
                getViewModel().setUpsellViewedTracked(true);
            }
            getBinding().f2369b.setOnClickListener(new AnonymousClass2(viewState));
        }
        KotlinExtensionsKt.getExhaustive(Unit.a);
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
        ColorPickerDialog.k kVar = new ColorPickerDialog.k();
        kVar.h = initialColor;
        kVar.f3148s = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundPrimary);
        kVar.i = false;
        kVar.j = false;
        kVar.f = 0;
        kVar.a = R.string.user_settings_banner_color_title;
        kVar.r = ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        kVar.f3149x = fontUtils.getThemedFontResId(getContext(), R.attr.font_display_bold);
        kVar.l = true;
        kVar.e = R.string.color_picker_use_default;
        kVar.p = ColorCompat.getThemedColor(getContext(), R.attr.color_brand);
        kVar.d = R.string.select;
        kVar.w = ColorCompat.getColor(getContext(), R.color.white);
        kVar.f3150y = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_semibold);
        kVar.t = ColorCompat.getThemedColor(getContext(), R.attr.colorTextMuted);
        kVar.u = R.drawable.drawable_cpv_edit_text_background;
        kVar.f3151z = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogA = kVar.a();
        colorPickerDialogA.k = new AnonymousClass1();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogA.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
        this.colorPickerDialog = colorPickerDialogA;
    }

    private final void navigateToUpsellModal() {
        d.Companion companion = d.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.CustomProfileUpsellModal;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        String string = b.i(resources, R.string.premium_profile_customization_upsell_header, new Object[0], null, 4).toString();
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        companion.a(parentFragmentManager, premiumUpsellType, R.drawable.img_profile_banner_value_prop, string, b.i(resources2, R.string.premium_profile_customization_upsell_body, new Object[0], null, 4).toString(), Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_edit_profile_banner_sheet;
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEditProfileBannerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence charSequenceI;
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().h.setOnClickListener(new AnonymousClass1());
        getBinding().g.setOnClickListener(new AnonymousClass2());
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_HAS_BANNER_IMAGE);
        MaterialTextView materialTextView = getBinding().c;
        m.checkNotNullExpressionValue(materialTextView, "binding.bannerChangeImageItemTitle");
        if (z2) {
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            charSequenceI = b.i(resources, R.string.user_settings_change_profile_banner, new Object[0], null, 4);
        } else {
            Resources resources2 = getResources();
            m.checkNotNullExpressionValue(resources2, "resources");
            charSequenceI = b.i(resources2, R.string.user_settings_upload_banner, new Object[0], null, 4);
        }
        materialTextView.setText(charSequenceI);
        MaterialTextView materialTextView2 = getBinding().g;
        m.checkNotNullExpressionValue(materialTextView2, "binding.bannerRemoveImageItem");
        materialTextView2.setVisibility(z2 ? 0 : 8);
    }

    public final void setOnChangeProfileBannerImage(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onChangeProfileBannerImage = function0;
    }

    public final void setOnColorSelected(Function1<? super Integer, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onColorSelected = function1;
    }

    public final void setOnRemoveProfileBannerImage(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onRemoveProfileBannerImage = function0;
    }
}
