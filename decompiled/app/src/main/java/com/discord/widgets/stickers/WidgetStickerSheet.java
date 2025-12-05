package com.discord.widgets.stickers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.chat.input.expression.ExpressionPickerEvent;
import com.discord.widgets.chat.input.expression.ExpressionPickerEventBus;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet2;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import com.discord.widgets.stickers.StickerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetStickerSheet.kt */
/* loaded from: classes.dex */
public final class WidgetStickerSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_sheet_analytics_location";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetStickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker, long channelId) {
            Channel channelFindChannelById;
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            if (sticker.getType() == StickerType.STANDARD && (channelFindChannelById = StoreStream.INSTANCE.getChannels().findChannelById(channelId)) != null) {
                String str = channelFindChannelById.getGuildId() == 0 ? "DM Channel" : Traits.Location.Page.GUILD_CHANNEL;
                WidgetStickerSheet widgetStickerSheet = new WidgetStickerSheet();
                Bundle bundle = new Bundle();
                bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
                bundle.putString(WidgetStickerSheet.ANALYTICS_LOCATION, str);
                widgetStickerSheet.setArguments(bundle);
                widgetStickerSheet.show(fragmentManager, WidgetStickerSheet.class.getName());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$bindSubscriptions$1 */
    public static final /* synthetic */ class C101361 extends FunctionReferenceImpl implements Function1<StickerSheetViewModel.ViewState, Unit> {
        public C101361(WidgetStickerSheet widgetStickerSheet) {
            super(1, widgetStickerSheet, WidgetStickerSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetStickerSheet.access$configureUI((WidgetStickerSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$1 */
    public static final class ViewOnClickListenerC101371 implements View.OnClickListener {
        public ViewOnClickListenerC101371() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = WidgetStickerSheet.this.requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            WidgetSettingsPremium.Companion.launch$default(companion, fragmentActivityRequireActivity, null, "Sticker Nitro Upsell Popout", 2, null);
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2 */
    public static final class C101382 extends Lambda implements Function1<RenderContext, Unit> {
        public static final C101382 INSTANCE = new C101382();

        /* compiled from: WidgetStickerSheet.kt */
        /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, "Sticker Nitro Upsell Popout", 2, null);
            }
        }

        public C101382() {
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
            renderContext.m8423b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$3 */
    public static final class ViewOnClickListenerC101393 implements View.OnClickListener {
        public final /* synthetic */ boolean $isPackEnabled;
        public final /* synthetic */ StickerSheetViewModel.ViewState $viewState;

        public ViewOnClickListenerC101393(boolean z2, StickerSheetViewModel.ViewState viewState) {
            this.$isPackEnabled = z2;
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.$isPackEnabled || this.$viewState.getCanUsePremiumStickers()) {
                return;
            }
            WidgetStickerSheet.this.dismiss();
            StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.STICKER_POPOUT, null, null, null, 29, null));
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$4 */
    public static final class ViewOnClickListenerC101404 implements View.OnClickListener {
        public final /* synthetic */ boolean $isPackEnabled;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Sticker $sticker;
        public final /* synthetic */ ModelStickerPack $stickerPack;
        public final /* synthetic */ StickerSheetViewModel.ViewState $viewState;

        public ViewOnClickListenerC101404(boolean z2, StickerSheetViewModel.ViewState viewState, Sticker sticker, String str, ModelStickerPack modelStickerPack) {
            this.$isPackEnabled = z2;
            this.$viewState = viewState;
            this.$sticker = sticker;
            this.$location = str;
            this.$stickerPack = modelStickerPack;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$isPackEnabled && this.$viewState.getCanUsePremiumStickers()) {
                ExpressionPickerEventBus.INSTANCE.getINSTANCE().emitEvent(new ExpressionPickerEvent.OpenStickerPicker(this.$sticker.getPackId(), null, false, 2, null));
            } else {
                WidgetStickerPackStoreSheet.Companion companion = WidgetStickerPackStoreSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, this.$sticker, WidgetStickerPackStoreSheet2.STICKER_POPOUT_VIEW_ALL, this.$location, StickerPurchaseLocation.INSTANCE.getPopoutPurchaseLocation(this.$stickerPack.canBePurchased()));
            }
            WidgetStickerSheet.this.dismiss();
        }
    }

    public WidgetStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerSheet2.INSTANCE, null, 2, null);
        WidgetStickerSheet3 widgetStickerSheet3 = new WidgetStickerSheet3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StickerSheetViewModel.class), new WidgetStickerSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStickerSheet3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerSheet widgetStickerSheet, StickerSheetViewModel.ViewState viewState) {
        widgetStickerSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStickerSheet widgetStickerSheet) {
        return widgetStickerSheet.getArgumentsOrDefault();
    }

    private final void configureUI(StickerSheetViewModel.ViewState viewState) {
        ModelStickerPack stickerPack = viewState.getStickerPack();
        Sticker sticker = viewState.getSticker();
        PremiumTier meUserPremiumTier = viewState.getMeUserPremiumTier();
        boolean isStickerPackEnabled = viewState.getIsStickerPackEnabled();
        TextView textView = getBinding().f18210d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerSheetStickerName");
        textView.setText(sticker.getName());
        if (!viewState.getCanUsePremiumStickers()) {
            getBinding().f18209c.setOnClickListener(new ViewOnClickListenerC101371());
        }
        TextView textView2 = getBinding().f18209c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stickerSheetStickerInfo");
        textView2.setText((isStickerPackEnabled || viewState.getCanUsePremiumStickers() || stickerPack.isPremiumPack()) ? FormatUtils.m219k(this, C5419R.string.sticker_popout_pack_info_premium, new Object[]{stickerPack.getName()}, null, 4) : !stickerPack.canBePurchased() ? FormatUtils.m219k(this, C5419R.string.sticker_popout_pack_info_unavailable, new Object[]{stickerPack.getName()}, null, 4) : FormatUtils.m213e(this, C5419R.string.sticker_popout_pack_info, new Object[]{stickerPack.getName(), String.valueOf(StickerUtils.INSTANCE.calculatePremiumStickerPackDiscount())}, C101382.INSTANCE));
        try {
            getBinding().f18214h.m8616d(stickerPack.getStickers().get(0), 0);
            getBinding().f18215i.m8616d(stickerPack.getStickers().get(1), 0);
            getBinding().f18216j.m8616d(stickerPack.getStickers().get(2), 0);
            getBinding().f18217k.m8616d(stickerPack.getStickers().get(3), 0);
        } catch (IndexOutOfBoundsException unused) {
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ANALYTICS_LOCATION) : null;
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().f18208b.setText(stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, stickerPack, meUserPremiumTier, isStickerPackEnabled));
        getBinding().f18208b.setIsLoading(false);
        getBinding().f18208b.setOnClickListener(new ViewOnClickListenerC101393(isStickerPackEnabled, viewState));
        LoadingButton loadingButton = getBinding().f18208b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.stickerSheetBuyButton");
        loadingButton.setVisibility(isStickerPackEnabled && !viewState.getCanUsePremiumStickers() ? 0 : 8);
        MaterialButton materialButton = getBinding().f18211e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.stickerSheetViewButton");
        materialButton.setVisibility(isStickerPackEnabled ? 0 : 8);
        getBinding().f18211e.setOnClickListener(new ViewOnClickListenerC101404(isStickerPackEnabled, viewState, sticker, string, stickerPack));
        RelativeLayout relativeLayout = getBinding().f18213g;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.stickerSheetViewLimitedContainer");
        relativeLayout.setVisibility(stickerPack.isLimitedPack() ? 0 : 8);
        Chip chip = getBinding().f18212f;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.stickerSheetViewLimitedChip");
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        chip.setText(stickerUtils.getLimitedTimeLeftString(contextRequireContext2, stickerPack.getStoreListing()));
    }

    private final WidgetStickerSheetBinding getBinding() {
        return (WidgetStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StickerSheetViewModel getViewModel() {
        return (StickerSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, long j) {
        INSTANCE.show(fragmentManager, sticker, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableM11112r, WidgetStickerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101361(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_sticker_sheet;
    }
}
