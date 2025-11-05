package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerPackStoreSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.chat.input.sticker.StickerFullSizeDialog;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.stickers.StickerPurchaseLocation;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStickerPackStoreSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetStickerPackStoreSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_pack_Store_sheet_analytics_location";
    private static final String ANALYTICS_LOCATION_SECTION = "widget_sticker_pack_Store_sheet_analytics_location_section";
    private static final String VIEW_TYPE = "widget_sticker_pack_store_sheet_view_type";
    private WidgetStickerAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStickerPackStoreSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType stickerPackStoreSheetViewType, String str, StickerPurchaseLocation stickerPurchaseLocation, int i, Object obj) {
            companion.show(fragmentManager, sticker, stickerPackStoreSheetViewType, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : stickerPurchaseLocation);
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType viewType, String location, StickerPurchaseLocation purchaseLocation) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(sticker, "sticker");
            m.checkNotNullParameter(viewType, "viewType");
            if (sticker.getType() != StickerType.STANDARD) {
                return;
            }
            WidgetStickerPackStoreSheet widgetStickerPackStoreSheet = new WidgetStickerPackStoreSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            bundle.putSerializable(WidgetStickerPackStoreSheet.VIEW_TYPE, viewType);
            bundle.putString(WidgetStickerPackStoreSheet.ANALYTICS_LOCATION, location);
            bundle.putSerializable(WidgetStickerPackStoreSheet.ANALYTICS_LOCATION_SECTION, purchaseLocation);
            widgetStickerPackStoreSheet.setArguments(bundle);
            widgetStickerPackStoreSheet.show(fragmentManager, WidgetStickerPackStoreSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StickerPackStoreSheetViewModel.ViewState $viewState;

        public AnonymousClass1(StickerPackStoreSheetViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.$viewState.isPackEnabled() || this.$viewState.canUserAccessToPremiumStickers()) {
                return;
            }
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Context contextRequireContext = WidgetStickerPackStoreSheet.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, 1, null, 4, null);
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StickerPackStoreSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerPackStoreSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerPackStoreSheetViewModel.ViewState viewState) {
            WidgetStickerPackStoreSheet.access$configureUI((WidgetStickerPackStoreSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onViewCreated$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StickerItem, Unit> {
        public AnonymousClass1(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "onStickerItemSelected", "onStickerItemSelected(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerItem stickerItem) {
            invoke2(stickerItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerItem stickerItem) {
            m.checkNotNullParameter(stickerItem, "p1");
            WidgetStickerPackStoreSheet.access$onStickerItemSelected((WidgetStickerPackStoreSheet) this.receiver, stickerItem);
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onViewCreated$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<StoreHeaderItem, Unit> {
        public AnonymousClass2(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "onStickerHeaderItemsClicked", "onStickerHeaderItemsClicked(Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreHeaderItem storeHeaderItem) {
            invoke2(storeHeaderItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreHeaderItem storeHeaderItem) {
            m.checkNotNullParameter(storeHeaderItem, "p1");
            WidgetStickerPackStoreSheet.access$onStickerHeaderItemsClicked((WidgetStickerPackStoreSheet) this.receiver, storeHeaderItem);
        }
    }

    public WidgetStickerPackStoreSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStickerPackStoreSheet$binding$2.INSTANCE, null, 2, null);
        WidgetStickerPackStoreSheet$viewModel$2 widgetStickerPackStoreSheet$viewModel$2 = new WidgetStickerPackStoreSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(StickerPackStoreSheetViewModel.class), new WidgetStickerPackStoreSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStickerPackStoreSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerPackStoreSheetViewModel.ViewState viewState) {
        widgetStickerPackStoreSheet.configureUI(viewState);
    }

    public static final /* synthetic */ void access$onStickerHeaderItemsClicked(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StoreHeaderItem storeHeaderItem) {
        widgetStickerPackStoreSheet.onStickerHeaderItemsClicked(storeHeaderItem);
    }

    public static final /* synthetic */ void access$onStickerItemSelected(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerItem stickerItem) {
        widgetStickerPackStoreSheet.onStickerItemSelected(stickerItem);
    }

    private final void configureUI(StickerPackStoreSheetViewModel.ViewState viewState) {
        if (viewState != null) {
            setBottomSheetState(3);
            WidgetStickerAdapter widgetStickerAdapter = this.adapter;
            if (widgetStickerAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            widgetStickerAdapter.setData(viewState.getStickerItems());
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            CharSequence stickerPackPremiumPriceLabel = stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, viewState.getStickerPack(), viewState.getMeUserPremiumTier(), viewState.isPackEnabled());
            boolean zIsStickerPackFreeForPremiumTier = stickerUtils.isStickerPackFreeForPremiumTier(viewState.getStickerPack(), PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY);
            getBinding().e.setText(stickerPackPremiumPriceLabel);
            LoadingButton loadingButton = getBinding().e;
            m.checkNotNullExpressionValue(loadingButton, "binding.stickerStoreBuyButtonPremium");
            loadingButton.setVisibility(viewState.isPackEnabled() && !viewState.canUserAccessToPremiumStickers() ? 0 : 8);
            getBinding().e.setOnClickListener(new AnonymousClass1(viewState));
            LoadingButton loadingButton2 = getBinding().e;
            m.checkNotNullExpressionValue(loadingButton2, "binding.stickerStoreBuyButtonPremium");
            loadingButton2.setEnabled(true);
            getBinding().e.setIsLoading(false);
            getBinding().e.setIconVisibility(!zIsStickerPackFreeForPremiumTier);
            String bannerCDNAssetUrl = stickerUtils.getBannerCDNAssetUrl(viewState.getStickerPack(), 1024);
            if (!(bannerCDNAssetUrl.length() > 0)) {
                SimpleDraweeView simpleDraweeView = getBinding().d;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerPackViewAllBanner");
                simpleDraweeView.setVisibility(8);
            } else {
                SimpleDraweeView simpleDraweeView2 = getBinding().d;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerPackViewAllBanner");
                MGImages.setImage$default(simpleDraweeView2, bannerCDNAssetUrl, 0, 0, false, null, null, 124, null);
                SimpleDraweeView simpleDraweeView3 = getBinding().d;
                m.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerPackViewAllBanner");
                simpleDraweeView3.setVisibility(0);
            }
        }
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build.VERSION.SDK_INT >= 29) {
            return DimenUtils.dpToPixels(8);
        }
        return 0;
    }

    private final WidgetStickerPackStoreSheetBinding getBinding() {
        return (WidgetStickerPackStoreSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StickerPackStoreSheetViewModel getViewModel() {
        return (StickerPackStoreSheetViewModel) this.viewModel.getValue();
    }

    private final void onStickerHeaderItemsClicked(StoreHeaderItem storeHeaderItem) {
        WidgetStickerPackDetailsDialog.Companion companion = WidgetStickerPackDetailsDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        companion.show(childFragmentManager, storeHeaderItem.getPack().getId(), Integer.valueOf(DimenUtils.dpToPixels(80)));
    }

    private final void onStickerItemSelected(StickerItem stickerItem) {
        StickerFullSizeDialog.Companion companion = StickerFullSizeDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        companion.show(childFragmentManager, stickerItem.getSticker());
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, StickerPackStoreSheetViewType stickerPackStoreSheetViewType, String str, StickerPurchaseLocation stickerPurchaseLocation) {
        INSTANCE.show(fragmentManager, sticker, stickerPackStoreSheetViewType, str, stickerPurchaseLocation);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_sticker_pack_store_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStickerPackStoreSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RelativeLayout relativeLayout = getBinding().f2660b;
        m.checkNotNullExpressionValue(relativeLayout, "binding.stickerPackStoreSheetContainer");
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.stickerPackStoreSheetRecycler");
        this.adapter = new WidgetStickerAdapter(recyclerView, new AnonymousClass1(this), new AnonymousClass2(this), null, this, true, 8, null);
        getViewModel().fetchStickersData();
    }
}
