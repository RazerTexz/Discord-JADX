package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierDesignBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p600f0.p601e0.Util7;
import p658rx.functions.Action1;

/* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildRoleSubscriptionTierDesign.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";
    private static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_HIDE_HEADER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: defaultColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultColor;

    /* renamed from: hideHeader$delegate, reason: from kotlin metadata */
    private final Lazy hideHeader;
    private final Action1<String> memberBadgeImageSelectedResult;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierDesign newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionTierDesign newInstance(boolean hideHeader) {
            WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign = new WidgetGuildRoleSubscriptionTierDesign();
            widgetGuildRoleSubscriptionTierDesign.setArguments(Bundle2.bundleOf(Tuples.m10073to(WidgetGuildRoleSubscriptionTierDesign.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionTierDesign;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$1 */
    public static final class C85031 extends Lambda implements Function0<Unit> {
        public static final C85031 INSTANCE = new C85031();

        public C85031() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$2 */
    public static final class C85042 extends Lambda implements Function0<Unit> {
        public C85042() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildRoleSubscriptionTierDesign.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBoundOrOnResume$1 */
    public static final class C85051 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C85051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierDesign.access$configureUI(WidgetGuildRoleSubscriptionTierDesign.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$setupMemberColor$2 */
    public static final class ViewOnClickListenerC85062 implements View.OnClickListener {
        public final /* synthetic */ int $currentColor;

        public ViewOnClickListenerC85062(int i) {
            this.$currentColor = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierDesign.access$launchColorPicker(WidgetGuildRoleSubscriptionTierDesign.this, this.$currentColor);
        }
    }

    public WidgetGuildRoleSubscriptionTierDesign() {
        super(C5419R.layout.widget_guild_role_subscription_tier_design);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDesign2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8499xc56e8221(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierDesign7.INSTANCE));
        this.hideHeader = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierDesign4(this));
        this.memberBadgeImageSelectedResult = new WidgetGuildRoleSubscriptionTierDesign6(this);
        this.defaultColor = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierDesign3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierDesign.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        return widgetGuildRoleSubscriptionTierDesign.getViewModel();
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign, int i) {
        widgetGuildRoleSubscriptionTierDesign.launchColorPicker(i);
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        Integer memberColor = guildRoleSubscriptionTier.getMemberColor();
        int iIntValue = memberColor != null ? memberColor.intValue() : getDefaultColor();
        setupMemberColor(iIntValue);
        getBinding().f16969g.updateImage(guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().f16971i.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().f16970h.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
    }

    private final WidgetGuildRoleSubscriptionTierDesignBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierDesignBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getDefaultColor() {
        return ((Number) this.defaultColor.getValue()).intValue();
    }

    private final boolean getHideHeader() {
        return ((Boolean) this.hideHeader.getValue()).booleanValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void launchColorPicker(@ColorInt int currentColor) {
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), C5419R.string.guild_role_subscription_tier_design_member_color_label, currentColor);
        colorPickerDialogBuildColorPickerDialog.f21719k = new WidgetGuildRoleSubscriptionTierDesign5(this);
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void setupMemberColor(@ColorInt int currentColor) {
        View view = getBinding().f16964b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.guildRoleSubscriptionTierAppearanceColor");
        Drawable drawable = ContextCompat.getDrawable(requireContext(), C5419R.drawable.rounded_rectangle_4dp_radius);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(new PorterDuffColorFilter(currentColor, PorterDuff.Mode.SRC_ATOP));
        } else {
            drawable = null;
        }
        if (drawable == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        view.setBackground(drawable);
        getBinding().f16965c.setOnClickListener(new ViewOnClickListenerC85062(currentColor));
        TextView textView = getBinding().f16966d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscri…onTierAppearanceColorText");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.CHANNELS_CHAR);
        String strM10143x = Util7.m10143x(currentColor);
        Objects.requireNonNull(strM10143x, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strM10143x.substring(2);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        textView.setText(sb.toString());
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.memberBadgeImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.memberBadgeImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16969g.configureUI(C85031.INSTANCE, new C85042());
        getViewModel().setDefaultMemberColor(getDefaultColor());
        TextView textView = getBinding().f16968f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierAppearanceTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        if (getHideHeader()) {
            getBinding().f16967e.setPadding(0, DimenUtils.dpToPixels(16), 0, 0);
            return;
        }
        TextView textView2 = getBinding().f16967e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscri…ionTierAppearanceSubtitle");
        textView2.setPadding(0, 0, 0, 0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierDesign.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85051(), 62, (Object) null);
    }
}
