package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareSheetBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import com.discord.widgets.home.WidgetHome;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetGuildInviteShareSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet extends AppBottomSheet {
    private static final String ARG_ANALYTICS_SOURCE = "ARG_ANALYTICS_SOURCE";
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private InviteSuggestionsAdapter adapter;
    private String analyticsSource;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> guildInviteSettingsLauncher;
    private boolean isFixedHeight;
    private final AppLogger2 loggingConfig;
    private boolean restoredSearchQueryFromViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildInviteShareSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void enqueueNoticeForHomeTab$default(Companion companion, Long l, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            companion.enqueueNoticeForHomeTab(l, j, str);
        }

        private final String getNoticeName() {
            return WidgetGuildInviteShareSheet.class.getSimpleName() + " - " + ClockFactory.get().currentTimeMillis();
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Long l, long j, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                l = null;
            }
            companion.show(fragmentManager, l, j, str);
        }

        public final void enqueueNoticeForHomeTab(Long channelId, long guildId, String source) {
            Intrinsics3.checkNotNullParameter(source, "source");
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            notices.requestToShow(new StoreNotices.Notice(getNoticeName(), null, ClockFactory.get().currentTimeMillis(), 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new C8695x9a7ac400(channelId, guildId, source, notices, getNoticeName()), Opcodes.I2C, null));
        }

        public final void show(FragmentManager fragmentManager, Long channelId, long guildId, String source) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(source, "source");
            AnalyticsTracker.INSTANCE.openPopout("Instant Invite", source);
            WidgetGuildInviteShareSheet widgetGuildInviteShareSheet = new WidgetGuildInviteShareSheet();
            Bundle bundle = new Bundle();
            if (channelId != null) {
                bundle.putLong(WidgetGuildInviteShareSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            bundle.putLong(WidgetGuildInviteShareSheet.ARG_GUILD_ID, guildId);
            bundle.putString(WidgetGuildInviteShareSheet.ARG_ANALYTICS_SOURCE, source);
            widgetGuildInviteShareSheet.setArguments(bundle);
            widgetGuildInviteShareSheet.show(fragmentManager, WidgetGuildInviteShareSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildInviteShareSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$3 */
    public static final class C87043 extends Lambda implements Function1<InviteSuggestionItemV2, Unit> {
        public C87043() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            invoke2(inviteSuggestionItemV2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItemV2, "item");
            WidgetGuildInviteShareSheet.access$getViewModel$p(WidgetGuildInviteShareSheet.this).sendInvite(inviteSuggestionItemV2);
        }
    }

    /* compiled from: WidgetGuildInviteShareSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$onResume$1 */
    public static final class C87051 extends Lambda implements Function1<GuildInviteShareSheetViewModel.ViewState, Unit> {
        public C87051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteShareSheetViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteShareSheetViewModel.ViewState viewState) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetGuildInviteShareSheet.this.configureUI(viewState);
        }
    }

    /* compiled from: WidgetGuildInviteShareSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$setUpSearchBar$1 */
    public static final class C87061 extends Lambda implements Function1<String, Unit> {
        public C87061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetGuildInviteShareSheet.access$getViewModel$p(WidgetGuildInviteShareSheet.this).onSearchTextChanged(str);
        }
    }

    public WidgetGuildInviteShareSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShareSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareSheet$viewModel$2 widgetGuildInviteShareSheet$viewModel$2 = new WidgetGuildInviteShareSheet$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildInviteShareSheetViewModel.class), new WidgetGuildInviteShareSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShareSheet$viewModel$2));
        this.guildInviteSettingsLauncher = WidgetGuildInviteSettings.INSTANCE.registerForResult(this, new WidgetGuildInviteShareSheet$guildInviteSettingsLauncher$1(this));
        this.analyticsSource = "";
        this.loggingConfig = new AppLogger2(false, null, new WidgetGuildInviteShareSheet$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ String access$getAnalyticsSource$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.analyticsSource;
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildInviteShareSheetBinding access$getBinding$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getGuildInviteSettingsLauncher$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.guildInviteSettingsLauncher;
    }

    public static final /* synthetic */ GuildInviteShareSheetViewModel access$getViewModel$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.getViewModel();
    }

    public static final /* synthetic */ void access$setAnalyticsSource$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, String str) {
        widgetGuildInviteShareSheet.analyticsSource = str;
    }

    private final void configureEmptyStateUI(GuildInviteShareSheetViewModel.ViewState viewState) throws Resources.NotFoundException {
        if (this.isFixedHeight) {
            this.isFixedHeight = false;
            FrameLayout frameLayout = getBinding().f16846j;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC8696x3bab2b2c());
            } else {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = -1;
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        AppViewFlipper appViewFlipper = binding.f16850n;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(0);
        NestedScrollView nestedScrollView = binding.f16842f;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(true);
        GuildInvite invite = viewState.getInvite();
        ModelInvite.Settings inviteSettings = viewState.getInviteSettings();
        CharSequence inviteSettingsText = null;
        if (invite != null) {
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            TextView textView = binding.f16840d;
            Intrinsics3.checkNotNullExpressionValue(textView, "emptyStateInviteLink");
            textView.setText(invite.toLink());
            TextView textView2 = binding.f16843g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "emptyStateSettingsSubtext");
            if (inviteSettings != null) {
                Context contextRequireContext = requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                inviteSettingsText = GuildInviteUiHelper.getInviteSettingsText(contextRequireContext, expirationTimeMs, inviteSettings.getMaxUses());
            }
            textView2.setText(inviteSettingsText);
        } else {
            TextView textView3 = binding.f16840d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "emptyStateInviteLink");
            textView3.setText(getString(C5419R.string.loading));
            TextView textView4 = binding.f16843g;
            Intrinsics3.checkNotNullExpressionValue(textView4, "emptyStateSettingsSubtext");
            textView4.setText((CharSequence) null);
        }
        binding.f16840d.setOnClickListener(new ViewOnClickListenerC8697xdc893a07(invite, this, viewState));
        binding.f16844h.setOnClickListener(new ViewOnClickListenerC8698xdc893a08(invite, this, viewState));
        ImageButton imageButton = binding.f16841e;
        Intrinsics3.checkNotNullExpressionValue(imageButton, "emptyStateLinkOptions");
        imageButton.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.f16841e.setOnClickListener(new ViewOnClickListenerC8699xdc893a09(invite, this, viewState));
    }

    private final void configureNormalUI(GuildInviteShareSheetViewModel.ViewState viewState) {
        if (!this.isFixedHeight) {
            this.isFixedHeight = true;
            FrameLayout frameLayout = getBinding().f16846j;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC8700x657b34cf(this));
            } else {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                Intrinsics3.checkNotNullExpressionValue(getResources(), "resources");
                layoutParams2.height = (int) (r3.getDisplayMetrics().heightPixels * 0.9d);
                frameLayout.setLayoutParams(layoutParams2);
                access$getBinding$p(this).f16849m.requestLayout();
            }
        }
        String searchQuery = viewState.getSearchQuery();
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        if (!this.restoredSearchQueryFromViewModel && (!StringsJVM.isBlank(searchQuery))) {
            this.restoredSearchQueryFromViewModel = true;
            binding.f16847k.setText(searchQuery);
        }
        AppViewFlipper appViewFlipper = binding.f16850n;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(1);
        NestedScrollView nestedScrollView = binding.f16842f;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(false);
        if (viewState.getChannel() != null) {
            SearchInputView searchInputView = binding.f16847k;
            Channel channel = viewState.getChannel();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            searchInputView.setHint(FormatUtils.m219k(this, C5419R.string.invite_your_friends_channel_mobile, new Object[]{ChannelUtils.m7681e(channel, contextRequireContext, false, 2)}, null, 4));
        } else {
            SearchInputView searchInputView2 = binding.f16847k;
            String string = getString(C5419R.string.invite_your_friends);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.invite_your_friends)");
            searchInputView2.setHint(string);
        }
        GuildInvite invite = viewState.getInvite();
        if (invite != null) {
            CardView cardView = binding.f16848l;
            Intrinsics3.checkNotNullExpressionValue(cardView, "shareButton");
            cardView.setContentDescription(FormatUtils.m219k(this, C5419R.string.share_invite_mobile, new Object[]{invite}, null, 4));
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            String link = invite.toLink();
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence inviteSettingsText = GuildInviteUiHelper.getInviteSettingsText(contextRequireContext2, expirationTimeMs);
            TextView textView = binding.f16839c;
            Intrinsics3.checkNotNullExpressionValue(textView, "copyLinkSubtitle");
            textView.setText(link + ' ' + inviteSettingsText);
            binding.f16848l.setOnClickListener(new ViewOnClickListenerC8701xecba64c4(invite, this, searchQuery, viewState));
            binding.f16838b.setOnClickListener(new ViewOnClickListenerC8702xecba64c5(invite, this, searchQuery, viewState));
        }
        CardView cardView2 = binding.f16848l;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "shareButton");
        cardView2.setVisibility(invite != null ? 0 : 8);
        FrameLayout frameLayout2 = binding.f16845i;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "inviteSettingsButton");
        frameLayout2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.f16845i.setOnClickListener(new ViewOnClickListenerC8703xecba64c6(invite, this, searchQuery, viewState));
        InviteSuggestionsAdapter inviteSuggestionsAdapter = this.adapter;
        if (inviteSuggestionsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter.setOnClick(new C87043());
        InviteSuggestionsAdapter inviteSuggestionsAdapter2 = this.adapter;
        if (inviteSuggestionsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter2.setData(viewState.getInviteSuggestionItems());
    }

    private final WidgetGuildInviteShareSheetBinding getBinding() {
        return (WidgetGuildInviteShareSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildInviteShareSheetViewModel getViewModel() {
        return (GuildInviteShareSheetViewModel) this.viewModel.getValue();
    }

    private final void setUpSearchBar() {
        getBinding().f16847k.m8553a(this, new C87061());
    }

    public final void configureUI(GuildInviteShareSheetViewModel.ViewState viewState) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (viewState.getHasResults()) {
            configureNormalUI(viewState);
        } else {
            configureEmptyStateUI(viewState);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_invite_share_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildInviteShareSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87051(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString(ARG_ANALYTICS_SOURCE);
        if (string == null) {
            string = "";
        }
        this.analyticsSource = string;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16849m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.suggestionList");
        this.adapter = (InviteSuggestionsAdapter) companion.configure(new InviteSuggestionsAdapter(recyclerView));
        setUpSearchBar();
    }
}
