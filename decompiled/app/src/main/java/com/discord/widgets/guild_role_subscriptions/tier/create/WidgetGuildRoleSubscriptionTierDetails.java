package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionDetailsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
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
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildRoleSubscriptionTierDetails.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_IS_EDIT_MODE = "INTENT_IS_EDIT_MODE";
    private static final String REQUEST_KEY_PRICE_TIER_PICKER = "REQUEST_KEY_PRICE_TIER_PICKER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: isEditMode$delegate, reason: from kotlin metadata */
    private final Lazy isEditMode;
    private final Action1<String> tierImageSelectedResult;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierDetails newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionTierDetails newInstance(boolean isEditMode) {
            WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = new WidgetGuildRoleSubscriptionTierDetails();
            widgetGuildRoleSubscriptionTierDetails.setArguments(Bundle2.bundleOf(Tuples.m10073to(WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, Boolean.valueOf(isEditMode))));
            return widgetGuildRoleSubscriptionTierDetails;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$configureUI$1 */
    public static final class ViewOnClickListenerC85091 implements View.OnClickListener {
        public ViewOnClickListenerC85091() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPriceTierPickerBottomSheet.INSTANCE.launch(WidgetGuildRoleSubscriptionTierDetails.this, WidgetGuildRoleSubscriptionTierDetails.REQUEST_KEY_PRICE_TIER_PICKER);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$isEditMode$2 */
    public static final class C85102 extends Lambda implements Function0<Boolean> {
        public C85102() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            Bundle arguments = WidgetGuildRoleSubscriptionTierDetails.this.getArguments();
            if (arguments != null) {
                return arguments.getBoolean(WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, false);
            }
            return false;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$1 */
    public static final class C85111 extends Lambda implements Function1<Integer, Unit> {
        public C85111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails.this).updatePriceTier(i);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$2 */
    public static final class C85122 extends Lambda implements Function0<Unit> {
        public static final C85122 INSTANCE = new C85122();

        public C85122() {
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

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$3 */
    public static final class C85133 extends Lambda implements Function0<Unit> {
        public C85133() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildRoleSubscriptionTierDetails.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$4 */
    public static final class C85144 extends Lambda implements Function1<String, Unit> {
        public C85144() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails.this).updateTierName(str);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$5 */
    public static final class C85155 extends Lambda implements Function1<String, Unit> {
        public C85155() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails.this).updateDescription(str);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBoundOrOnResume$1 */
    public static final class C85161 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C85161() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = WidgetGuildRoleSubscriptionTierDetails.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetGuildRoleSubscriptionTierDetails.access$configureUI(widgetGuildRoleSubscriptionTierDetails, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierDetails() {
        super(C5419R.layout.widget_guild_role_subscription_details);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDetails2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8507x7b20ff5d(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierDetails4.INSTANCE));
        this.tierImageSelectedResult = new WidgetGuildRoleSubscriptionTierDetails3(this);
        this.isEditMode = LazyJVM.lazy(new C85102());
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierDetails.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        return widgetGuildRoleSubscriptionTierDetails.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        TextInputLayout textInputLayout = getBinding().f16916f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.createSubscriptionTierNameLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout, guildRoleSubscriptionTier.getName());
        TextInputLayout textInputLayout2 = getBinding().f16913c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.createSubscriptionTierDescriptionLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout2, guildRoleSubscriptionTier.getDescription());
        getBinding().f16914d.updateImage(guildRoleSubscriptionTier);
        if (guildRoleSubscriptionTier.getPriceTier() == null) {
            getBinding().f16917g.setText(C5419R.string.guild_role_subscription_tier_detail_price_placeholder);
        } else {
            TextView textView = getBinding().f16917g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierPrice");
            int iIntValue = guildRoleSubscriptionTier.getPriceTier().intValue();
            WidgetGuildRoleSubscriptionDetailsBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.f16911a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            textView.setText(PremiumUtils2.getFormattedPriceUsd(iIntValue, context));
        }
        Boolean boolIsPublished = guildRoleSubscriptionTier.isPublished();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics3.areEqual(boolIsPublished, bool)) {
            TextView textView2 = getBinding().f16917g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierPrice");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, C5419R.drawable.ic_lock_white_a60_16dp, 0, 11, null);
        } else {
            getBinding().f16917g.setOnClickListener(new ViewOnClickListenerC85091());
        }
        TextView textView3 = getBinding().f16917g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.createSubscriptionTierPrice");
        textView3.setSelected(guildRoleSubscriptionTier.getPriceTier() != null && (Intrinsics3.areEqual(guildRoleSubscriptionTier.isPublished(), bool) ^ true));
    }

    private final WidgetGuildRoleSubscriptionDetailsBinding getBinding() {
        return (WidgetGuildRoleSubscriptionDetailsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final boolean isEditMode() {
        return ((Boolean) this.isEditMode.getValue()).booleanValue();
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.tierImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.tierImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetPriceTierPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_PRICE_TIER_PICKER, new C85111());
        getBinding().f16914d.configureUI(C85122.INSTANCE, new C85133());
        TextInputEditText textInputEditText = getBinding().f16915e;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.createSubscriptionTierName");
        TextWatcher4.addLifecycleAwareTextWatcher(textInputEditText, this, new C85144());
        TextInputEditText textInputEditText2 = getBinding().f16912b;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.createSubscriptionTierDescription");
        TextWatcher4.addLifecycleAwareTextWatcher(textInputEditText2, this, new C85155());
        TextView textView = getBinding().f16919i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierTitle");
        textView.setVisibility(isEditMode() ^ true ? 0 : 8);
        TextView textView2 = getBinding().f16918h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierSubtitle");
        textView2.setVisibility(isEditMode() ^ true ? 0 : 8);
        View view2 = getBinding().f16920j;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierDetailDivider");
        view2.setVisibility(isEditMode() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetGuildRoleSubscriptionTierDetails.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85161(), 62, (Object) null);
    }
}
