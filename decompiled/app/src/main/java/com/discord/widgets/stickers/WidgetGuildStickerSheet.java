package com.discord.widgets.stickers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildStickerSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.stickers.GuildStickerSheetViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.NumberFormat;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetGuildStickerSheet.kt */
/* loaded from: classes.dex */
public final class WidgetGuildStickerSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildStickerSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int VIEW_CONTENT = 0;
    private static final int VIEW_LOADING = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildStickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            if (sticker.getType() != StickerType.GUILD) {
                return;
            }
            WidgetGuildStickerSheet widgetGuildStickerSheet = new WidgetGuildStickerSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            widgetGuildStickerSheet.setArguments(bundle);
            widgetGuildStickerSheet.show(fragmentManager, WidgetGuildStickerSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildStickerSheet.kt */
    /* renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildStickerSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildStickerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildStickerSheetViewModel.ViewState viewState) {
            if (Intrinsics3.areEqual(viewState, GuildStickerSheetViewModel.ViewState.Loading.INSTANCE)) {
                WidgetGuildStickerSheet.access$showLoading(WidgetGuildStickerSheet.this);
            } else if (Intrinsics3.areEqual(viewState, GuildStickerSheetViewModel.ViewState.Dismiss.INSTANCE)) {
                WidgetGuildStickerSheet.this.dismiss();
            } else if (viewState instanceof GuildStickerSheetViewModel.ViewState.Loaded) {
                WidgetGuildStickerSheet.access$configureUI(WidgetGuildStickerSheet.this, (GuildStickerSheetViewModel.ViewState.Loaded) viewState);
            }
        }
    }

    public WidgetGuildStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildStickerSheet2.INSTANCE, null, 2, null);
        WidgetGuildStickerSheet5 widgetGuildStickerSheet5 = new WidgetGuildStickerSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildStickerSheetViewModel.class), new WidgetGuildStickerSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildStickerSheet5));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildStickerSheet widgetGuildStickerSheet, GuildStickerSheetViewModel.ViewState.Loaded loaded) {
        widgetGuildStickerSheet.configureUI(loaded);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        return widgetGuildStickerSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ GuildStickerSheetViewModel access$getViewModel$p(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        return widgetGuildStickerSheet.getViewModel();
    }

    public static final /* synthetic */ void access$showLoading(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        widgetGuildStickerSheet.showLoading();
    }

    private final void configureButtons(boolean isUserPremium, boolean isUserInGuild, Guild guild) {
        WidgetGuildStickerSheetBinding binding = getBinding();
        if (guild == null) {
            FrameLayout frameLayout = binding.f2453b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "guildStickerSheetButtonContainer");
            frameLayout.setVisibility(8);
            return;
        }
        if (!isUserPremium) {
            FrameLayout frameLayout2 = binding.f2453b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "guildStickerSheetButtonContainer");
            frameLayout2.setVisibility(0);
            MaterialButton materialButton = binding.l;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "guildStickerSheetPremiumBtn");
            materialButton.setVisibility(0);
            MaterialButton materialButton2 = binding.k;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "guildStickerSheetJoinBtn");
            materialButton2.setVisibility(8);
            binding.l.setOnClickListener(new WidgetGuildStickerSheet3(this, guild, isUserPremium, isUserInGuild));
            return;
        }
        if (isUserInGuild) {
            FrameLayout frameLayout3 = binding.f2453b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "guildStickerSheetButtonContainer");
            frameLayout3.setVisibility(8);
            return;
        }
        FrameLayout frameLayout4 = binding.f2453b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout4, "guildStickerSheetButtonContainer");
        frameLayout4.setVisibility(0);
        MaterialButton materialButton3 = binding.l;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "guildStickerSheetPremiumBtn");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = binding.k;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "guildStickerSheetJoinBtn");
        materialButton4.setVisibility(0);
        binding.k.setOnClickListener(new WidgetGuildStickerSheet4(this, guild, isUserPremium, isUserInGuild));
    }

    private final void configureGuildSection(Guild guild, boolean isCurrentGuild, boolean isGuildPublic, Integer approximateOnline) {
        WidgetGuildStickerSheetBinding binding = getBinding();
        if (guild == null || isCurrentGuild) {
            LinearLayout linearLayout = binding.e;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildStickerSheetGuildContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = binding.e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "guildStickerSheetGuildContainer");
        linearLayout2.setVisibility(0);
        if (guild.hasIcon()) {
            SimpleDraweeView simpleDraweeView = binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "guildStickerSheetGuildIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, guild, 0, (MGImages.ChangeDetector) null, true, 12, (Object) null);
        } else {
            binding.h.setBackgroundResource(R.drawable.drawable_circle_black);
            int themedColor = ColorCompat.getThemedColor(requireContext(), R.attr.colorBackgroundSecondary);
            FrameLayout frameLayout = binding.h;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "guildStickerSheetGuildIconWrapper");
            frameLayout.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            TextView textView = binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "guildStickerSheetGuildIconText");
            textView.setText(guild.getShortName());
        }
        int i = guild.getFeatures().contains(GuildFeature.PARTNERED) ? R.drawable.ic_partnered_badge_banner : guild.getFeatures().contains(GuildFeature.VERIFIED) ? R.drawable.ic_verified_badge_banner : 0;
        TextView textView2 = binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "guildStickerSheetGuildName");
        DrawableCompat.setCompoundDrawablesCompat(textView2, i, 0, 0, 0);
        TextView textView3 = binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView3, "guildStickerSheetGuildName");
        textView3.setText(guild.getName());
        int i2 = isGuildPublic ? R.string.sticker_popout_public_server : R.string.sticker_popout_private_server;
        String str = null;
        CharSequence charSequenceK = FormatUtils.k(this, i2, new Object[0], null, 4);
        if (approximateOnline != null) {
            str = FormatUtils.k(this, R.string.instant_invite_guild_members_online, new Object[]{NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext())).format(Integer.valueOf(approximateOnline.intValue()))}, null, 4).toString() + " • ";
        }
        if (str == null) {
            str = "";
        }
        TextView textView4 = binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView4, "guildStickerSheetGuildInfo");
        textView4.setText(str + charSequenceK);
    }

    private final void configureUI(GuildStickerSheetViewModel.ViewState.Loaded viewState) {
        Sticker sticker = viewState.getSticker();
        boolean isUserPremium = viewState.getIsUserPremium();
        boolean isCurrentGuild = viewState.getIsCurrentGuild();
        boolean isPublic = viewState.getGuildStickerGuildInfo().getIsPublic();
        boolean isUserInGuild = viewState.getGuildStickerGuildInfo().getIsUserInGuild();
        GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo = viewState.getGuildStickerGuildInfo();
        if (!(guildStickerGuildInfo instanceof GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known)) {
            guildStickerGuildInfo = null;
        }
        GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known known = (GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known) guildStickerGuildInfo;
        getBinding().m.d(sticker, 0);
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildStickerSheetStickerName");
        textView.setText(sticker.getName());
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildStickerSheetDescription");
        textView2.setText(getString(getCustomStickerInfoText(isCurrentGuild, isUserInGuild, isPublic, isUserPremium)));
        configureButtons(isUserPremium, isUserInGuild, known != null ? known.getGuild() : null);
        configureGuildSection(known != null ? known.getGuild() : null, isCurrentGuild, isPublic, known != null ? known.getApproximateOnline() : null);
        AppViewFlipper appViewFlipper = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildStickerSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final WidgetGuildStickerSheetBinding getBinding() {
        return (WidgetGuildStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getCustomStickerInfoText(boolean isCurrentGuild, boolean isUserInGuild, boolean isGuildPublic, boolean isUserPremium) {
        return (!isCurrentGuild || isUserPremium) ? (isCurrentGuild && isUserPremium) ? R.string.sticker_popout_premium_current_guild_description : (!isUserInGuild || isUserPremium) ? (isUserInGuild && isUserPremium) ? R.string.sticker_popout_premium_joined_guild_description : (!isGuildPublic || isUserPremium) ? (isGuildPublic && isUserPremium) ? R.string.sticker_popout_premium_unjoined_discoverable_guild_description : R.string.sticker_popout_premium_unjoined_private_guild_description : R.string.sticker_popout_unjoined_discoverable_guild_description : R.string.sticker_popout_joined_guild_description : R.string.sticker_popout_current_guild_description;
    }

    private final GuildStickerSheetViewModel getViewModel() {
        return (GuildStickerSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker) {
        INSTANCE.show(fragmentManager, sticker);
    }

    private final void showLoading() {
        AppViewFlipper appViewFlipper = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildStickerSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildStickerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_sticker_sheet;
    }
}
