package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildHubProfileActionsBinding;
import com.discord.databinding.WidgetGuildProfileActionsBinding;
import com.discord.databinding.WidgetGuildProfileSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.MutablePropertyReference0Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildProfileSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildProfileSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_FROM_UPSELL = "EXTRA_FROM_UPSELL";
    private static final int LOADED_VIEW_INDEX = 1;
    private static final int LOADING_VIEW_INDEX = 0;
    private static final int NUM_ROWS_EMOJIS = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Long channelId;
    private AlertDialog dialog;
    private final WidgetGuildProfileSheetEmojisAdapter emojisAdapter;

    /* JADX INFO: renamed from: fromGuildEventUpsell$delegate, reason: from kotlin metadata */
    private final Lazy fromGuildEventUpsell;
    private WidgetGuildProfileActionsBinding guildActionBinding;
    private WidgetGuildHubProfileActionsBinding guildHubActionBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, boolean z2, long j, long j2, boolean z3, int i, Object obj) {
            companion.show(fragmentManager, z2, j, (i & 8) != 0 ? 0L : j2, (i & 16) != 0 ? false : z3);
        }

        public final void show(FragmentManager fragmentManager, boolean viewingGuild, long guildId, long channelId, boolean fromGuildEventUpsell) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildProfileSheet widgetGuildProfileSheet = new WidgetGuildProfileSheet();
            Bundle bundleM832T = outline.m832T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleM832T.putBoolean("com.discord.intent.extra.EXTRA_VIEWING_GUILD", viewingGuild);
            bundleM832T.putBoolean(WidgetGuildProfileSheet.EXTRA_FROM_UPSELL, fromGuildEventUpsell);
            widgetGuildProfileSheet.setArguments(bundleM832T);
            widgetGuildProfileSheet.show(fragmentManager, WidgetGuildProfileSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetGuildProfileSheetViewModel.Banner.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetGuildProfileSheetViewModel.Banner.Type.BANNER.ordinal()] = 1;
            iArr[WidgetGuildProfileSheetViewModel.Banner.Type.SPLASH.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureGuildActions$1 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final class ViewOnClickListenerC87871 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC87871(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildProfileSheet.access$getViewModel$p(WidgetGuildProfileSheet.this).onClickMarkAsRead(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureGuildActions$11 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final class ViewOnClickListenerC878811 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC878811(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetGuildProfileSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            AppToast.m165c(contextRequireContext, String.valueOf(this.$guildId), 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureGuildHubActions$1 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final class ViewOnClickListenerC87911 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC87911(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildProfileSheet.access$launchInvite(WidgetGuildProfileSheet.this, this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureGuildHubActions$2 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final class C87922 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87922(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
            if (userExperiment != null && userExperiment.getBucket() == 1) {
                WidgetEditUserOrGuildMemberProfile.Companion companion = WidgetEditUserOrGuildMemberProfile.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                WidgetEditUserOrGuildMemberProfile.Companion.launch$default(companion, context, null, Long.valueOf(this.$guildId), 2, null);
                return;
            }
            WidgetChangeGuildIdentity.Companion companion2 = WidgetChangeGuildIdentity.INSTANCE;
            long j = this.$guildId;
            Context context2 = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
            companion2.launch(j, "Guild Bottom Sheet", context2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public final /* synthetic */ class C87971 extends MutablePropertyReference0Impl {
        public C87971(WidgetGuildProfileSheet widgetGuildProfileSheet) {
            super(widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "guildHubActionBinding", "getGuildHubActionBinding()Lcom/discord/databinding/WidgetGuildHubProfileActionsBinding;", 0);
        }

        @Override // p507d0.p592z.p594d.MutablePropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return WidgetGuildProfileSheet.access$getGuildHubActionBinding$p((WidgetGuildProfileSheet) this.receiver);
        }

        @Override // p507d0.p592z.p594d.MutablePropertyReference0Impl
        public void set(Object obj) {
            WidgetGuildProfileSheet.access$setGuildHubActionBinding$p((WidgetGuildProfileSheet) this.receiver, (WidgetGuildHubProfileActionsBinding) obj);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureUI$2 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public final /* synthetic */ class C87982 extends MutablePropertyReference0Impl {
        public C87982(WidgetGuildProfileSheet widgetGuildProfileSheet) {
            super(widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "guildActionBinding", "getGuildActionBinding()Lcom/discord/databinding/WidgetGuildProfileActionsBinding;", 0);
        }

        @Override // p507d0.p592z.p594d.MutablePropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return WidgetGuildProfileSheet.access$getGuildActionBinding$p((WidgetGuildProfileSheet) this.receiver);
        }

        @Override // p507d0.p592z.p594d.MutablePropertyReference0Impl
        public void set(Object obj) {
            WidgetGuildProfileSheet.access$setGuildActionBinding$p((WidgetGuildProfileSheet) this.receiver, (WidgetGuildProfileActionsBinding) obj);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final /* synthetic */ class C87991 extends FunctionReferenceImpl implements Function1<WidgetGuildProfileSheetViewModel.ViewState, Unit> {
        public C87991(WidgetGuildProfileSheet widgetGuildProfileSheet) {
            super(1, widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "handleViewState", "handleViewState(Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildProfileSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildProfileSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildProfileSheet.access$handleViewState((WidgetGuildProfileSheet) this.receiver, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final /* synthetic */ class C88002 extends FunctionReferenceImpl implements Function1<WidgetGuildProfileSheetViewModel.Event, Unit> {
        public C88002(WidgetGuildProfileSheet widgetGuildProfileSheet) {
            super(1, widgetGuildProfileSheet, WidgetGuildProfileSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildProfileSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildProfileSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildProfileSheet.access$handleEvent((WidgetGuildProfileSheet) this.receiver, event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
    public static final class C88013 extends Lambda implements Function0<Unit> {
        public C88013() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildProfileSheet.access$getViewModel$p(WidgetGuildProfileSheet.this).onClickEmoji();
        }
    }

    public WidgetGuildProfileSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildProfileSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildProfileSheet$viewModel$2 widgetGuildProfileSheet$viewModel$2 = new WidgetGuildProfileSheet$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildProfileSheetViewModel.class), new WidgetGuildProfileSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildProfileSheet$viewModel$2));
        this.fromGuildEventUpsell = LazyJVM.lazy(new WidgetGuildProfileSheet$fromGuildEventUpsell$2(this));
        this.emojisAdapter = new WidgetGuildProfileSheetEmojisAdapter();
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        return widgetGuildProfileSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildProfileActionsBinding access$getGuildActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = widgetGuildProfileSheet.guildActionBinding;
        if (widgetGuildProfileActionsBinding == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        return widgetGuildProfileActionsBinding;
    }

    public static final /* synthetic */ WidgetGuildHubProfileActionsBinding access$getGuildHubActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding = widgetGuildProfileSheet.guildHubActionBinding;
        if (widgetGuildHubProfileActionsBinding == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildHubActionBinding");
        }
        return widgetGuildHubProfileActionsBinding;
    }

    public static final /* synthetic */ WidgetGuildProfileSheetViewModel access$getViewModel$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        return widgetGuildProfileSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel.Event event) {
        widgetGuildProfileSheet.handleEvent(event);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel.ViewState viewState) {
        widgetGuildProfileSheet.handleViewState(viewState);
    }

    public static final /* synthetic */ void access$launchInvite(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        widgetGuildProfileSheet.launchInvite(j);
    }

    public static final /* synthetic */ void access$setGuildActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding) {
        widgetGuildProfileSheet.guildActionBinding = widgetGuildProfileActionsBinding;
    }

    public static final /* synthetic */ void access$setGuildHubActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding) {
        widgetGuildProfileSheet.guildHubActionBinding = widgetGuildHubProfileActionsBinding;
    }

    public static final /* synthetic */ void access$showLeaveServerDialog(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        widgetGuildProfileSheet.showLeaveServerDialog(j);
    }

    private final void configureBottomActions(long guildId, Long channelId, WidgetGuildProfileSheetViewModel.BottomActions bottomActions) {
        boolean showUploadEmoji = bottomActions.getShowUploadEmoji();
        boolean showJoinServer = bottomActions.getShowJoinServer();
        boolean showViewServer = bottomActions.getShowViewServer();
        if (!showUploadEmoji && !showJoinServer && !showViewServer) {
            WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
            if (widgetGuildProfileActionsBinding == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
            }
            LinearLayout linearLayout = widgetGuildProfileActionsBinding.f16864e;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildActionBinding.guildProfileSheetBottomActions");
            linearLayout.setVisibility(8);
            return;
        }
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout2 = widgetGuildProfileActionsBinding2.f16864e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "guildActionBinding.guildProfileSheetBottomActions");
        linearLayout2.setVisibility(0);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        View view = widgetGuildProfileActionsBinding3.f16885z;
        view.setVisibility(showUploadEmoji ? 0 : 8);
        setOnClickAndDismissListener(view, new C8777xf99beb2e(this, showUploadEmoji, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        MaterialButton materialButton = widgetGuildProfileActionsBinding4.f16877r;
        materialButton.setVisibility(showJoinServer ? 0 : 8);
        setOnClickAndDismissListener(materialButton, new C8778xf99beb2f(materialButton, this, showJoinServer, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding5 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        View view2 = widgetGuildProfileActionsBinding5.f16858A;
        view2.setVisibility(showViewServer ? 0 : 8);
        setOnClickAndDismissListener(view2, new C8779xf99beb30(this, showViewServer, guildId, channelId));
        Intrinsics3.checkNotNullExpressionValue(view2, "guildActionBinding.guild…dId, channelId) }\n      }");
    }

    private final void configureEmojis(WidgetGuildProfileSheetViewModel.EmojisData emojisData) {
        boolean zIsPremium = emojisData.isPremium();
        boolean zIsExpanded = emojisData.isExpanded();
        List<Emoji> emojis = emojisData.getEmojis();
        int size = emojis.size();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView = widgetGuildProfileActionsBinding.f16874o;
        Intrinsics3.checkNotNullExpressionValue(textView, "guildActionBinding.guildProfileSheetEmojisCount");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        textView.setText(StringResourceUtils.getQuantityString(resources, C5419R.plurals.emojis_title_count, C5419R.string.no_emoji_title, size, Integer.valueOf(size)));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        ImageView imageView = widgetGuildProfileActionsBinding2.f16882w;
        Intrinsics3.checkNotNullExpressionValue(imageView, "guildActionBinding.guild…PremiumUpsellDotSeparator");
        imageView.setVisibility(zIsPremium ^ true ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView2 = widgetGuildProfileActionsBinding3.f16883x;
        Intrinsics3.checkNotNullExpressionValue(textView2, "guildActionBinding.guild…ileSheetPremiumUpsellText");
        textView2.setVisibility(zIsPremium ^ true ? 0 : 8);
        if (size == 0) {
            WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
            if (widgetGuildProfileActionsBinding4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
            }
            CardView cardView = widgetGuildProfileActionsBinding4.f16873n;
            Intrinsics3.checkNotNullExpressionValue(cardView, "guildActionBinding.guildProfileSheetEmojisCard");
            cardView.setVisibility(8);
            return;
        }
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding5 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView2 = widgetGuildProfileActionsBinding5.f16873n;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "guildActionBinding.guildProfileSheetEmojisCard");
        cardView2.setVisibility(0);
        int iMaxEmojisPerRow = maxEmojisPerRow();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding6 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        RecyclerView recyclerView = widgetGuildProfileActionsBinding6.f16872m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "guildActionBinding.guildProfileSheetEmojis");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) layoutManager).setSpanCount(iMaxEmojisPerRow);
        this.emojisAdapter.setData(emojis, zIsExpanded ? emojis.size() : iMaxEmojisPerRow * 2);
    }

    private final void configureGuildActions(long guildId, long userId, WidgetGuildProfileSheetViewModel.Actions actions) {
        if (actions == null) {
            WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
            if (widgetGuildProfileActionsBinding == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
            }
            LinearLayout linearLayout = widgetGuildProfileActionsBinding.f16862c;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildActionBinding.guildProfileSheetActions");
            linearLayout.setVisibility(8);
            return;
        }
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout2 = widgetGuildProfileActionsBinding2.f16862c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "guildActionBinding.guildProfileSheetActions");
        linearLayout2.setVisibility(0);
        boolean zIsUnread = actions.isUnread();
        boolean canManageChannels = actions.getCanManageChannels();
        boolean canManageEvents = actions.getCanManageEvents();
        String nick = actions.getNick();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView = widgetGuildProfileActionsBinding3.f16880u;
        Intrinsics3.checkNotNullExpressionValue(cardView, "guildActionBinding.guild…fileSheetMarkAsReadAction");
        cardView.setVisibility(zIsUnread ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        widgetGuildProfileActionsBinding4.f16879t.setOnClickListener(new ViewOnClickListenerC87871(guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding5 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView2 = widgetGuildProfileActionsBinding5.f16884y;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "guildActionBinding.guildProfileSheetPrimaryActions");
        cardView2.setVisibility(canManageChannels || canManageEvents ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding6 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView = widgetGuildProfileActionsBinding6.f16867h;
        textView.setVisibility(canManageChannels ? 0 : 8);
        setOnClickAndDismissListener(textView, new C8780x6f508c54(textView, this, canManageChannels, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding7 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView2 = widgetGuildProfileActionsBinding7.f16868i;
        textView2.setVisibility(canManageChannels ? 0 : 8);
        setOnClickAndDismissListener(textView2, new C8781x6f508c55(textView2, this, canManageChannels, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding8 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        ConstraintLayout constraintLayout = widgetGuildProfileActionsBinding8.f16869j;
        constraintLayout.setVisibility(canManageEvents ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding9 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding9 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView3 = widgetGuildProfileActionsBinding9.f16870k;
        Intrinsics3.checkNotNullExpressionValue(textView3, "guildActionBinding.guildProfileSheetCreateEventNew");
        textView3.setVisibility(getFromGuildEventUpsell() ? 0 : 8);
        setOnClickAndDismissListener(constraintLayout, new C8782x6f508c56(constraintLayout, this, canManageEvents, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding10 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding10 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        setOnClickAndDismissListener(widgetGuildProfileActionsBinding10.f16861b, new C8783x6f508c57(this, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding11 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding11 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView4 = widgetGuildProfileActionsBinding11.f16881v;
        textView4.setVisibility(actions.getDisplayGuildIdentityRow() ? 0 : 8);
        if (nick == null) {
            nick = actions.getUsername();
        }
        textView4.setText(nick);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding12 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding12 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        SimpleDraweeView simpleDraweeView = widgetGuildProfileActionsBinding12.f16875p;
        String guildAvatar = actions.getGuildAvatar();
        simpleDraweeView.setVisibility((guildAvatar == null || guildAvatar.length() == 0) ^ true ? 0 : 8);
        simpleDraweeView.setImageURI(IconUtils.INSTANCE.getForGuildMember(actions.getGuildAvatar(), guildId, userId, Integer.valueOf(DimenUtils.dpToPixels(16)), false));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding13 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding13 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout3 = widgetGuildProfileActionsBinding13.f16859B;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "guildActionBinding.perGuildIdentityContainer");
        linearLayout3.setVisibility(actions.getDisplayGuildIdentityRow() ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding14 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding14 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CheckedSetting checkedSetting = widgetGuildProfileActionsBinding14.f16863d;
        checkedSetting.setChecked(actions.isAllowDMChecked());
        checkedSetting.setOnCheckedListener(new C8784x6f508c58(this, actions, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding15 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding15 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CheckedSetting checkedSetting2 = widgetGuildProfileActionsBinding15.f16876q;
        checkedSetting2.setChecked(actions.getHideMutedChannels());
        checkedSetting2.setOnCheckedListener(new C8785x6f508c59(this, actions, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding16 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding16 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        View view = widgetGuildProfileActionsBinding16.f16878s;
        view.setVisibility(actions.getCanLeaveGuild() ? 0 : 8);
        setOnClickAndDismissListener(view, new C8786x6f508c5a(this, actions, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding17 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding17 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView3 = widgetGuildProfileActionsBinding17.f16871l;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "guildActionBinding.guild…fileSheetDeveloperActions");
        cardView3.setVisibility(actions.isDeveloper() ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding18 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding18 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        widgetGuildProfileActionsBinding18.f16866g.setOnClickListener(new ViewOnClickListenerC878811(guildId));
    }

    private final void configureGuildBanner(WidgetGuildProfileSheetViewModel.Banner guildBanner) {
        String bannerForGuild$default;
        if (guildBanner.getHash() == null) {
            SimpleDraweeView simpleDraweeView = getBinding().f16890b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetBanner");
            simpleDraweeView.setVisibility(8);
            constrainIconToParent();
            return;
        }
        int iOrdinal = guildBanner.getType().ordinal();
        if (iOrdinal == 0) {
            bannerForGuild$default = IconUtils.getBannerForGuild$default(IconUtils.INSTANCE, Long.valueOf(guildBanner.getGuildId()), guildBanner.getHash(), Integer.valueOf(getResources().getDimensionPixelSize(C5419R.dimen.nav_panel_width)), false, 8, null);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            bannerForGuild$default = IconUtils.INSTANCE.getGuildSplashUrl(guildBanner.getGuildId(), guildBanner.getHash(), Integer.valueOf(getResources().getDimensionPixelSize(C5419R.dimen.nav_panel_width)));
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f16890b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetBanner");
        MGImages.setImage$default(simpleDraweeView2, bannerForGuild$default, 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView3 = getBinding().f16890b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildProfileSheetBanner");
        simpleDraweeView3.setVisibility(0);
        constrainIconToBanner();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureGuildContent(String name, String description, Integer verifiedPartneredIconRes) {
        TextView textView = getBinding().f16903o;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildProfileSheetName");
        textView.setText(name);
        if (description == null) {
            TextView textView2 = getBinding().f16894f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildProfileSheetDescription");
            textView2.setVisibility(8);
        } else {
            if (description.length() > 0) {
                TextView textView3 = getBinding().f16894f;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildProfileSheetDescription");
                textView3.setText(description);
                TextView textView4 = getBinding().f16894f;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildProfileSheetDescription");
                textView4.setVisibility(0);
            }
        }
        if (verifiedPartneredIconRes == null) {
            ImageView imageView = getBinding().f16896h;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildProfileSheetGuildVerifiedPremiumIcon");
            imageView.setVisibility(8);
        } else {
            getBinding().f16896h.setImageResource(verifiedPartneredIconRes.intValue());
            ImageView imageView2 = getBinding().f16896h;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildProfileSheetGuildVerifiedPremiumIcon");
            imageView2.setVisibility(0);
        }
    }

    private final void configureGuildHubActions(long guildId, long userId, WidgetGuildProfileSheetViewModel.Actions actions) {
        if (actions != null) {
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            widgetGuildHubProfileActionsBinding.f16783d.setOnClickListener(new ViewOnClickListenerC87911(guildId));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding2 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            View view = widgetGuildHubProfileActionsBinding2.f16781b;
            Intrinsics3.checkNotNullExpressionValue(view, "guildHubActionBinding.gu…rofileSheetChangeNickname");
            setOnClickAndDismissListener(view, new C87922(guildId));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding3 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            TextView textView = widgetGuildHubProfileActionsBinding3.f16785f;
            textView.setVisibility(actions.getDisplayGuildIdentityRow() ? 0 : 8);
            String nick = actions.getNick();
            if (nick == null) {
                nick = actions.getUsername();
            }
            textView.setText(nick);
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding4 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            SimpleDraweeView simpleDraweeView = widgetGuildHubProfileActionsBinding4.f16782c;
            String guildAvatar = actions.getGuildAvatar();
            simpleDraweeView.setVisibility((guildAvatar == null || guildAvatar.length() == 0) ^ true ? 0 : 8);
            simpleDraweeView.setImageURI(IconUtils.INSTANCE.getForGuildMember(actions.getGuildAvatar(), guildId, userId, Integer.valueOf(DimenUtils.dpToPixels(16)), false));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding5 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding5 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            View view2 = widgetGuildHubProfileActionsBinding5.f16784e;
            view2.setVisibility(actions.getCanLeaveGuild() ? 0 : 8);
            setOnClickAndDismissListener(view2, new C8789x5213d837(this, actions, guildId));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding6 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding6 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            TextView textView2 = widgetGuildHubProfileActionsBinding6.f16786g;
            textView2.setVisibility(0);
            setOnClickAndDismissListener(textView2, new C8790x5213d838(textView2, this, guildId));
        }
    }

    private final void configureGuildIcon(long guildId, String iconHash, String shortName) {
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guildId), iconHash, null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_xxlarge))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().f16899k;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildProfileSheetIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().f16897i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f16897i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetIcon");
        IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView2 = getBinding().f16899k;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildProfileSheetIconName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().f16899k;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildProfileSheetIconName");
        textView3.setText(shortName);
    }

    private final void configureMemberCount(Integer approximatePresenceCount, Integer approximateMemberCount) {
        if (approximatePresenceCount != null) {
            LinearLayout linearLayout = getBinding().f16905q;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildProfileSheetOnlineCount");
            linearLayout.setVisibility(0);
            TextView textView = getBinding().f16906r;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildProfileSheetOnlineCountText");
            int iIntValue = approximatePresenceCount.intValue();
            LinearLayout linearLayout2 = getBinding().f16905q;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.guildProfileSheetOnlineCount");
            Context context = linearLayout2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.guildProfileSheetOnlineCount.context");
            FormatUtils.m222n(textView, C5419R.string.instant_invite_guild_members_online, new Object[]{StringUtils2.format(iIntValue, context)}, null, 4);
        } else {
            LinearLayout linearLayout3 = getBinding().f16905q;
            Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.guildProfileSheetOnlineCount");
            linearLayout3.setVisibility(8);
        }
        if (approximateMemberCount == null) {
            LinearLayout linearLayout4 = getBinding().f16901m;
            Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.guildProfileSheetMemberCount");
            linearLayout4.setVisibility(8);
            return;
        }
        LinearLayout linearLayout5 = getBinding().f16901m;
        Intrinsics3.checkNotNullExpressionValue(linearLayout5, "binding.guildProfileSheetMemberCount");
        linearLayout5.setVisibility(0);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources, contextRequireContext, C5419R.plurals.instant_invite_guild_members_total_count, approximateMemberCount.intValue(), approximateMemberCount);
        TextView textView2 = getBinding().f16902n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildProfileSheetMemberCountText");
        FormatUtils.m222n(textView2, C5419R.string.instant_invite_guild_members_total, new Object[]{quantityString}, null, 4);
    }

    private final void configureTabItems(long guildId, WidgetGuildProfileSheetViewModel.TabItems tabItems, boolean isGuildHub) {
        if (tabItems == null || isGuildHub) {
            LinearLayout linearLayout = getBinding().f16908t;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildProfileSheetTabItems");
            linearLayout.setVisibility(8);
            View view = getBinding().f16893e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.guildProfileShee…entContainerBottomDivider");
            view.setVisibility(8);
            return;
        }
        boolean canAccessSettings = tabItems.getCanAccessSettings();
        boolean ableToInstantInvite = tabItems.getAbleToInstantInvite();
        int premiumSubscriptionCount = tabItems.getPremiumSubscriptionCount();
        LinearLayout linearLayout2 = getBinding().f16908t;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.guildProfileSheetTabItems");
        linearLayout2.setVisibility(0);
        View view2 = getBinding().f16893e;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildProfileShee…entContainerBottomDivider");
        view2.setVisibility(0);
        int themedColor = ColorCompat.getThemedColor(this, C5419R.attr.colorInteractiveNormal);
        MaterialButton materialButton = getBinding().f16891c;
        Resources resources = materialButton.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        materialButton.setText(StringResourceUtils.getQuantityString(resources, C5419R.plurals.premium_guild_perks_modal_header_subscription_count_subscriptions, C5419R.string.premium_guild_subscription, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
        materialButton.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton, new C8793x71cb1475(this, premiumSubscriptionCount, themedColor, guildId));
        MaterialButton materialButton2 = getBinding().f16904p;
        ColorCompat2.setDrawableColor(materialButton2, themedColor);
        materialButton2.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton2, new C8794x71cb1476(this, themedColor, guildId));
        MaterialButton materialButton3 = getBinding().f16907s;
        materialButton3.setVisibility(canAccessSettings ? 0 : 8);
        ColorCompat2.setDrawableColor(materialButton3, themedColor);
        materialButton3.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton3, new C8795x71cb1477(this, canAccessSettings, themedColor, guildId));
        MaterialButton materialButton4 = getBinding().f16900l;
        materialButton4.setVisibility(ableToInstantInvite ? 0 : 8);
        ColorCompat2.setDrawableColor(materialButton4, themedColor);
        materialButton4.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton4, new C8796x71cb1478(this, ableToInstantInvite, themedColor, guildId));
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.guildProfileShee…Invite(guildId) }\n      }");
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0354  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(WidgetGuildProfileSheetViewModel.ViewState.Loaded viewState) {
        WidgetGuildProfileSheetViewModel.Actions actions;
        int i;
        WidgetGuildProfileSheetViewModel.TabItems tabItems;
        int i2;
        long jComponent1 = viewState.getGuildId();
        String strComponent2 = viewState.getGuildName();
        String strComponent3 = viewState.getGuildShortName();
        String strComponent4 = viewState.getGuildIcon();
        String strComponent5 = viewState.getGuildDescription();
        Integer numComponent6 = viewState.getVerifiedPartneredIconRes();
        WidgetGuildProfileSheetViewModel.Banner bannerComponent7 = viewState.getBanner();
        Integer numComponent8 = viewState.getOnlineCount();
        Integer numComponent9 = viewState.getMemberCount();
        WidgetGuildProfileSheetViewModel.TabItems tabItemsComponent10 = viewState.getTabItems();
        WidgetGuildProfileSheetViewModel.Actions actionsComponent11 = viewState.getActions();
        WidgetGuildProfileSheetViewModel.EmojisData emojisDataComponent12 = viewState.getEmojisData();
        WidgetGuildProfileSheetViewModel.BottomActions bottomActionsComponent13 = viewState.getBottomActions();
        boolean zComponent14 = viewState.getIsGuildHub();
        MeUser meUserComponent15 = viewState.getMeUser();
        if (zComponent14 && this.guildHubActionBinding == null) {
            View viewInflate = getBinding().f16909u.inflate();
            actions = actionsComponent11;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.guild_profile_sheet_actions);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(C5419R.id.guild_profile_sheet_change_nickname);
                if (linearLayout3 != null) {
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.guild_profile_sheet_guild_avatar);
                    if (simpleDraweeView != null) {
                        i2 = C5419R.id.guild_profile_sheet_invite;
                        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.guild_profile_sheet_invite);
                        if (textView != null) {
                            CardView cardView = (CardView) viewInflate.findViewById(C5419R.id.guild_profile_sheet_invite_action);
                            if (cardView != null) {
                                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.guild_profile_sheet_leave_server);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.guild_profile_sheet_nickname);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.guild_profile_sheet_notifications);
                                        if (textView4 != null) {
                                            CardView cardView2 = (CardView) viewInflate.findViewById(C5419R.id.guild_profile_sheet_secondary_actions);
                                            if (cardView2 != null) {
                                                LinearLayout linearLayout4 = (LinearLayout) viewInflate.findViewById(C5419R.id.per_guild_identity_container);
                                                if (linearLayout4 != null) {
                                                    WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding = new WidgetGuildHubProfileActionsBinding(linearLayout2, linearLayout, linearLayout2, linearLayout3, simpleDraweeView, textView, cardView, textView2, textView3, textView4, cardView2, linearLayout4);
                                                    Intrinsics3.checkNotNullExpressionValue(widgetGuildHubProfileActionsBinding, "WidgetGuildHubProfileActionsBinding.bind(view)");
                                                    this.guildHubActionBinding = widgetGuildHubProfileActionsBinding;
                                                } else {
                                                    i2 = C5419R.id.per_guild_identity_container;
                                                }
                                            } else {
                                                i2 = C5419R.id.guild_profile_sheet_secondary_actions;
                                            }
                                        } else {
                                            i2 = C5419R.id.guild_profile_sheet_notifications;
                                        }
                                    } else {
                                        i2 = C5419R.id.guild_profile_sheet_nickname;
                                    }
                                } else {
                                    i2 = C5419R.id.guild_profile_sheet_leave_server;
                                }
                            } else {
                                i2 = C5419R.id.guild_profile_sheet_invite_action;
                            }
                        }
                    } else {
                        i2 = C5419R.id.guild_profile_sheet_guild_avatar;
                    }
                } else {
                    i2 = C5419R.id.guild_profile_sheet_change_nickname;
                }
            } else {
                i2 = C5419R.id.guild_profile_sheet_actions;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
        actions = actionsComponent11;
        if (!zComponent14 && this.guildActionBinding == null) {
            View viewInflate2 = getBinding().f16910v.inflate();
            LinearLayout linearLayout5 = (LinearLayout) viewInflate2.findViewById(C5419R.id.change_identity);
            if (linearLayout5 != null) {
                TextView textView5 = (TextView) viewInflate2.findViewById(C5419R.id.change_identity_header);
                if (textView5 != null) {
                    LinearLayout linearLayout6 = (LinearLayout) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_actions);
                    if (linearLayout6 != null) {
                        CheckedSetting checkedSetting = (CheckedSetting) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_allow_dm);
                        if (checkedSetting != null) {
                            LinearLayout linearLayout7 = (LinearLayout) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_bottom_actions);
                            if (linearLayout7 != null) {
                                LinearLayout linearLayout8 = (LinearLayout) viewInflate2;
                                TextView textView6 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_copy_id);
                                if (textView6 != null) {
                                    TextView textView7 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_create_category);
                                    if (textView7 != null) {
                                        TextView textView8 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_create_channel);
                                        if (textView8 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_create_event);
                                            if (constraintLayout != null) {
                                                TextView textView9 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_create_event_label);
                                                if (textView9 != null) {
                                                    TextView textView10 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_create_event_new);
                                                    if (textView10 != null) {
                                                        CardView cardView3 = (CardView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_developer_actions);
                                                        if (cardView3 != null) {
                                                            RecyclerView recyclerView = (RecyclerView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_emojis);
                                                            if (recyclerView != null) {
                                                                tabItems = tabItemsComponent10;
                                                                i = C5419R.id.guild_profile_sheet_emojis_card;
                                                                CardView cardView4 = (CardView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_emojis_card);
                                                                if (cardView4 != null) {
                                                                    TextView textView11 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_emojis_count);
                                                                    if (textView11 != null) {
                                                                        i = C5419R.id.guild_profile_sheet_guild_avatar;
                                                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_guild_avatar);
                                                                        if (simpleDraweeView2 != null) {
                                                                            i = C5419R.id.guild_profile_sheet_hide_muted_channels;
                                                                            CheckedSetting checkedSetting2 = (CheckedSetting) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_hide_muted_channels);
                                                                            if (checkedSetting2 != null) {
                                                                                MaterialButton materialButton = (MaterialButton) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_join_server);
                                                                                if (materialButton != null) {
                                                                                    i = C5419R.id.guild_profile_sheet_leave_server;
                                                                                    TextView textView12 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_leave_server);
                                                                                    if (textView12 != null) {
                                                                                        i = C5419R.id.guild_profile_sheet_mark_as_read;
                                                                                        TextView textView13 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_mark_as_read);
                                                                                        if (textView13 != null) {
                                                                                            CardView cardView5 = (CardView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_mark_as_read_action);
                                                                                            if (cardView5 != null) {
                                                                                                i = C5419R.id.guild_profile_sheet_nickname;
                                                                                                TextView textView14 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_nickname);
                                                                                                if (textView14 != null) {
                                                                                                    i = C5419R.id.guild_profile_sheet_premium_upsell_dot_separator;
                                                                                                    ImageView imageView = (ImageView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_premium_upsell_dot_separator);
                                                                                                    if (imageView != null) {
                                                                                                        i = C5419R.id.guild_profile_sheet_premium_upsell_text;
                                                                                                        TextView textView15 = (TextView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_premium_upsell_text);
                                                                                                        if (textView15 != null) {
                                                                                                            CardView cardView6 = (CardView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_primary_actions);
                                                                                                            if (cardView6 != null) {
                                                                                                                i = C5419R.id.guild_profile_sheet_secondary_actions;
                                                                                                                CardView cardView7 = (CardView) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_secondary_actions);
                                                                                                                if (cardView7 != null) {
                                                                                                                    i = C5419R.id.guild_profile_sheet_upload_emoji;
                                                                                                                    MaterialButton materialButton2 = (MaterialButton) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_upload_emoji);
                                                                                                                    if (materialButton2 != null) {
                                                                                                                        MaterialButton materialButton3 = (MaterialButton) viewInflate2.findViewById(C5419R.id.guild_profile_sheet_view_server);
                                                                                                                        if (materialButton3 != null) {
                                                                                                                            i = C5419R.id.per_guild_identity_container;
                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) viewInflate2.findViewById(C5419R.id.per_guild_identity_container);
                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = new WidgetGuildProfileActionsBinding(linearLayout8, linearLayout5, textView5, linearLayout6, checkedSetting, linearLayout7, linearLayout8, textView6, textView7, textView8, constraintLayout, textView9, textView10, cardView3, recyclerView, cardView4, textView11, simpleDraweeView2, checkedSetting2, materialButton, textView12, textView13, cardView5, textView14, imageView, textView15, cardView6, cardView7, materialButton2, materialButton3, linearLayout9);
                                                                                                                                Intrinsics3.checkNotNullExpressionValue(widgetGuildProfileActionsBinding, "WidgetGuildProfileActionsBinding.bind(view)");
                                                                                                                                this.guildActionBinding = widgetGuildProfileActionsBinding;
                                                                                                                                if (widgetGuildProfileActionsBinding == null) {
                                                                                                                                    Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
                                                                                                                                }
                                                                                                                                Intrinsics3.checkNotNullExpressionValue(recyclerView, "guildActionBinding.guildProfileSheetEmojis");
                                                                                                                                recyclerView.setAdapter(this.emojisAdapter);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            i = C5419R.id.guild_profile_sheet_view_server;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            } else {
                                                                                                                i = C5419R.id.guild_profile_sheet_primary_actions;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                i = C5419R.id.guild_profile_sheet_mark_as_read_action;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    i = C5419R.id.guild_profile_sheet_join_server;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i = C5419R.id.guild_profile_sheet_emojis_count;
                                                                    }
                                                                }
                                                            } else {
                                                                i = C5419R.id.guild_profile_sheet_emojis;
                                                            }
                                                        } else {
                                                            i = C5419R.id.guild_profile_sheet_developer_actions;
                                                        }
                                                    } else {
                                                        i = C5419R.id.guild_profile_sheet_create_event_new;
                                                    }
                                                } else {
                                                    i = C5419R.id.guild_profile_sheet_create_event_label;
                                                }
                                            } else {
                                                i = C5419R.id.guild_profile_sheet_create_event;
                                            }
                                        } else {
                                            i = C5419R.id.guild_profile_sheet_create_channel;
                                        }
                                    } else {
                                        i = C5419R.id.guild_profile_sheet_create_category;
                                    }
                                } else {
                                    i = C5419R.id.guild_profile_sheet_copy_id;
                                }
                            } else {
                                i = C5419R.id.guild_profile_sheet_bottom_actions;
                            }
                        } else {
                            i = C5419R.id.guild_profile_sheet_allow_dm;
                        }
                    } else {
                        i = C5419R.id.guild_profile_sheet_actions;
                    }
                } else {
                    i = C5419R.id.change_identity_header;
                }
            } else {
                i = C5419R.id.change_identity;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
        }
        configureGuildIcon(jComponent1, strComponent4, strComponent3);
        configureGuildBanner(bannerComponent7);
        configureGuildContent(strComponent2, strComponent5, numComponent6);
        configureMemberCount(numComponent8, numComponent9);
        configureTabItems(jComponent1, tabItems, zComponent14);
        if (!zComponent14) {
            configureGuildHubActions(jComponent1, meUserComponent15.getId(), actions);
            return;
        }
        configureGuildActions(jComponent1, meUserComponent15.getId(), actions);
        configureEmojis(emojisDataComponent12);
        configureBottomActions(jComponent1, this.channelId, bottomActionsComponent13);
        return;
        tabItems = tabItemsComponent10;
        configureGuildIcon(jComponent1, strComponent4, strComponent3);
        configureGuildBanner(bannerComponent7);
        configureGuildContent(strComponent2, strComponent5, numComponent6);
        configureMemberCount(numComponent8, numComponent9);
        configureTabItems(jComponent1, tabItems, zComponent14);
        if (!zComponent14) {
        }
    }

    private final void constrainIconToBanner() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getBinding().f16892d);
        CardView cardView = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView.getId(), 3);
        CardView cardView2 = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView2.getId(), 4);
        CardView cardView3 = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.guildProfileSheetIconCard");
        int id2 = cardView3.getId();
        SimpleDraweeView simpleDraweeView = getBinding().f16890b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetBanner");
        constraintSet.connect(id2, 3, simpleDraweeView.getId(), 4);
        CardView cardView4 = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.guildProfileSheetIconCard");
        int id3 = cardView4.getId();
        SimpleDraweeView simpleDraweeView2 = getBinding().f16890b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetBanner");
        constraintSet.connect(id3, 4, simpleDraweeView2.getId(), 4);
        constraintSet.applyTo(getBinding().f16892d);
    }

    private final void constrainIconToParent() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getBinding().f16892d);
        CardView cardView = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView.getId(), 3);
        CardView cardView2 = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView2.getId(), 4);
        CardView cardView3 = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.guildProfileSheetIconCard");
        int id2 = cardView3.getId();
        ConstraintLayout constraintLayout = getBinding().f16892d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildProfileSheetConstraintLayout");
        int id3 = constraintLayout.getId();
        CardView cardView4 = getBinding().f16898j;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.guildProfileSheetIconCard");
        ViewGroup.LayoutParams layoutParams = cardView4.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        constraintSet.connect(id2, 3, id3, 3, marginLayoutParams == null ? 0 : marginLayoutParams.topMargin);
        constraintSet.applyTo(getBinding().f16892d);
    }

    private final Unit dismissAlert() {
        Unit unit;
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            unit = Unit.f27425a;
        } else {
            unit = null;
        }
        hideKeyboard(getView());
        return unit;
    }

    private final WidgetGuildProfileSheetBinding getBinding() {
        return (WidgetGuildProfileSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean getFromGuildEventUpsell() {
        return ((Boolean) this.fromGuildEventUpsell.getValue()).booleanValue();
    }

    private final WidgetGuildProfileSheetViewModel getViewModel() {
        return (WidgetGuildProfileSheetViewModel) this.viewModel.getValue();
    }

    private final void handleDismissAndShowToast(WidgetGuildProfileSheetViewModel.Event.DismissAndShowToast event) {
        AppToast.m171i(this, event.getStringRes(), 0, 4);
        dismiss();
    }

    private final void handleEvent(WidgetGuildProfileSheetViewModel.Event event) {
        if (event instanceof WidgetGuildProfileSheetViewModel.Event.DismissAndShowToast) {
            handleDismissAndShowToast((WidgetGuildProfileSheetViewModel.Event.DismissAndShowToast) event);
        }
    }

    private final void handleViewState(WidgetGuildProfileSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildProfileSheetViewModel.ViewState.Loading) {
            showLoadingView();
        } else if (viewState instanceof WidgetGuildProfileSheetViewModel.ViewState.Invalid) {
            dismiss();
        } else {
            if (!(viewState instanceof WidgetGuildProfileSheetViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            updateView((WidgetGuildProfileSheetViewModel.ViewState.Loaded) viewState);
        }
    }

    private final void launchInvite(long guildId) {
        WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildInviteShare.Companion.launch$default(companion, context, parentFragmentManager, guildId, null, false, null, null, "Guild Profile", 120, null);
        }
    }

    private final int maxEmojisPerRow() {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView = widgetGuildProfileActionsBinding.f16873n;
        Intrinsics3.checkNotNullExpressionValue(cardView, "guildActionBinding.guildProfileSheetEmojisCard");
        int contentPaddingLeft = cardView.getContentPaddingLeft();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView2 = widgetGuildProfileActionsBinding2.f16873n;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "guildActionBinding.guildProfileSheetEmojisCard");
        int contentPaddingRight = cardView2.getContentPaddingRight() + contentPaddingLeft;
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout = widgetGuildProfileActionsBinding3.f16865f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildActionBinding.guild…ofileSheetBottomContainer");
        int paddingStart = linearLayout.getPaddingStart();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout2 = widgetGuildProfileActionsBinding4.f16865f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "guildActionBinding.guild…ofileSheetBottomContainer");
        return ((i - contentPaddingRight) - (linearLayout2.getPaddingEnd() + paddingStart)) / getResources().getDimensionPixelSize(C5419R.dimen.emoji_size);
    }

    public static final void show(FragmentManager fragmentManager, boolean z2, long j, long j2, boolean z3) {
        INSTANCE.show(fragmentManager, z2, j, j2, z3);
    }

    private final void showLeaveServerDialog(long guildId) {
        WidgetLeaveGuildDialog.Companion companion = WidgetLeaveGuildDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId);
        dismissAlert();
    }

    private final void showLoadingView() {
        AppViewFlipper appViewFlipper = getBinding().f16895g;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildProfileSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final void updateView(WidgetGuildProfileSheetViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f16895g;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildProfileSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
        configureUI(viewState);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_profile_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.channelId = Long.valueOf(getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildProfileSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87991(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildProfileSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88002(this), 62, (Object) null);
        this.emojisAdapter.setOnClickEmoji(new C88013());
    }
}
