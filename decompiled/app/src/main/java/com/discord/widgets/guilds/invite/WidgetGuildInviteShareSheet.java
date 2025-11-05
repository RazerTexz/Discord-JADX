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
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteShareSheetBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.SearchInputView;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import com.discord.widgets.home.WidgetHome;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;

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
    private final LoggingConfig loggingConfig;
    private boolean restoredSearchQueryFromViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteShareSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareSheetBinding;", 0)};

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
            m.checkNotNullParameter(source, "source");
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            notices.requestToShow(new StoreNotices.Notice(getNoticeName(), null, ClockFactory.get().currentTimeMillis(), 0, false, d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildInviteShareSheet$Companion$enqueueNoticeForHomeTab$notice$1(channelId, guildId, source, notices, getNoticeName()), Opcodes.I2C, null));
        }

        public final void show(FragmentManager fragmentManager, Long channelId, long guildId, String source) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(source, "source");
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
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<InviteSuggestionItemV2, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            invoke2(inviteSuggestionItemV2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            m.checkNotNullParameter(inviteSuggestionItemV2, "item");
            WidgetGuildInviteShareSheet.access$getViewModel$p(WidgetGuildInviteShareSheet.this).sendInvite(inviteSuggestionItemV2);
        }
    }

    /* compiled from: WidgetGuildInviteShareSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<GuildInviteShareSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteShareSheetViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteShareSheetViewModel.ViewState viewState) throws Resources.NotFoundException {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetGuildInviteShareSheet.this.configureUI(viewState);
        }
    }

    /* compiled from: WidgetGuildInviteShareSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$setUpSearchBar$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "searchQuery");
            WidgetGuildInviteShareSheet.access$getViewModel$p(WidgetGuildInviteShareSheet.this).onSearchTextChanged(str);
        }
    }

    public WidgetGuildInviteShareSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShareSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareSheet$viewModel$2 widgetGuildInviteShareSheet$viewModel$2 = new WidgetGuildInviteShareSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildInviteShareSheetViewModel.class), new WidgetGuildInviteShareSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteShareSheet$viewModel$2));
        this.guildInviteSettingsLauncher = WidgetGuildInviteSettings.INSTANCE.registerForResult(this, new WidgetGuildInviteShareSheet$guildInviteSettingsLauncher$1(this));
        this.analyticsSource = "";
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildInviteShareSheet$loggingConfig$1(this), 3);
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
            FrameLayout frameLayout = getBinding().j;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$doOnLayout$1());
            } else {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = -1;
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        AppViewFlipper appViewFlipper = binding.n;
        m.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(0);
        NestedScrollView nestedScrollView = binding.f;
        m.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(true);
        GuildInvite invite = viewState.getInvite();
        ModelInvite.Settings inviteSettings = viewState.getInviteSettings();
        CharSequence inviteSettingsText = null;
        if (invite != null) {
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            TextView textView = binding.d;
            m.checkNotNullExpressionValue(textView, "emptyStateInviteLink");
            textView.setText(invite.toLink());
            TextView textView2 = binding.g;
            m.checkNotNullExpressionValue(textView2, "emptyStateSettingsSubtext");
            if (inviteSettings != null) {
                Context contextRequireContext = requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                inviteSettingsText = GuildInviteUiHelperKt.getInviteSettingsText(contextRequireContext, expirationTimeMs, inviteSettings.getMaxUses());
            }
            textView2.setText(inviteSettingsText);
        } else {
            TextView textView3 = binding.d;
            m.checkNotNullExpressionValue(textView3, "emptyStateInviteLink");
            textView3.setText(getString(R.string.loading));
            TextView textView4 = binding.g;
            m.checkNotNullExpressionValue(textView4, "emptyStateSettingsSubtext");
            textView4.setText((CharSequence) null);
        }
        binding.d.setOnClickListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$1(invite, this, viewState));
        binding.h.setOnClickListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$2(invite, this, viewState));
        ImageButton imageButton = binding.e;
        m.checkNotNullExpressionValue(imageButton, "emptyStateLinkOptions");
        imageButton.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.e.setOnClickListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$3(invite, this, viewState));
    }

    private final void configureNormalUI(GuildInviteShareSheetViewModel.ViewState viewState) {
        if (!this.isFixedHeight) {
            this.isFixedHeight = true;
            FrameLayout frameLayout = getBinding().j;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$doOnLayout$1(this));
            } else {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                m.checkNotNullExpressionValue(getResources(), "resources");
                layoutParams2.height = (int) (r3.getDisplayMetrics().heightPixels * 0.9d);
                frameLayout.setLayoutParams(layoutParams2);
                access$getBinding$p(this).m.requestLayout();
            }
        }
        String searchQuery = viewState.getSearchQuery();
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        if (!this.restoredSearchQueryFromViewModel && (!t.isBlank(searchQuery))) {
            this.restoredSearchQueryFromViewModel = true;
            binding.k.setText(searchQuery);
        }
        AppViewFlipper appViewFlipper = binding.n;
        m.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(1);
        NestedScrollView nestedScrollView = binding.f;
        m.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(false);
        if (viewState.getChannel() != null) {
            SearchInputView searchInputView = binding.k;
            Channel channel = viewState.getChannel();
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            searchInputView.setHint(b.k(this, R.string.invite_your_friends_channel_mobile, new Object[]{ChannelUtils.e(channel, contextRequireContext, false, 2)}, null, 4));
        } else {
            SearchInputView searchInputView2 = binding.k;
            String string = getString(R.string.invite_your_friends);
            m.checkNotNullExpressionValue(string, "getString(R.string.invite_your_friends)");
            searchInputView2.setHint(string);
        }
        GuildInvite invite = viewState.getInvite();
        if (invite != null) {
            CardView cardView = binding.l;
            m.checkNotNullExpressionValue(cardView, "shareButton");
            cardView.setContentDescription(b.k(this, R.string.share_invite_mobile, new Object[]{invite}, null, 4));
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            String link = invite.toLink();
            Context contextRequireContext2 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence inviteSettingsText = GuildInviteUiHelperKt.getInviteSettingsText(contextRequireContext2, expirationTimeMs);
            TextView textView = binding.c;
            m.checkNotNullExpressionValue(textView, "copyLinkSubtitle");
            textView.setText(link + ' ' + inviteSettingsText);
            binding.l.setOnClickListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$1(invite, this, searchQuery, viewState));
            binding.f2422b.setOnClickListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$2(invite, this, searchQuery, viewState));
        }
        CardView cardView2 = binding.l;
        m.checkNotNullExpressionValue(cardView2, "shareButton");
        cardView2.setVisibility(invite != null ? 0 : 8);
        FrameLayout frameLayout2 = binding.i;
        m.checkNotNullExpressionValue(frameLayout2, "inviteSettingsButton");
        frameLayout2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.i.setOnClickListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3(invite, this, searchQuery, viewState));
        InviteSuggestionsAdapter inviteSuggestionsAdapter = this.adapter;
        if (inviteSuggestionsAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter.setOnClick(new AnonymousClass3());
        InviteSuggestionsAdapter inviteSuggestionsAdapter2 = this.adapter;
        if (inviteSuggestionsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
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
        getBinding().k.a(this, new AnonymousClass1());
    }

    public final void configureUI(GuildInviteShareSheetViewModel.ViewState viewState) throws Resources.NotFoundException {
        m.checkNotNullParameter(viewState, "viewState");
        if (viewState.getHasResults()) {
            configureNormalUI(viewState);
        } else {
            configureEmptyStateUI(viewState);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_invite_share_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildInviteShareSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString(ARG_ANALYTICS_SOURCE);
        if (string == null) {
            string = "";
        }
        this.analyticsSource = string;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView, "binding.suggestionList");
        this.adapter = (InviteSuggestionsAdapter) companion.configure(new InviteSuggestionsAdapter(recyclerView));
        setUpSearchBar();
    }
}
