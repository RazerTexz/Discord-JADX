package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteShareBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetGuildInviteShare.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShare extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteShare.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_INVITE_STORE_KEY = "INTENT_INVITE_STORE_KEY";
    public static final String INTENT_IS_NUX_FLOW = "INTENT_IS_NUX_FLOW";
    private PrivateChannelAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;
    private final LoggingConfig loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildInviteShare.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, FragmentManager fragmentManager, long j, Long l, boolean z2, Long l2, String str, String str2, int i, Object obj) {
            companion.launch(context, fragmentManager, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : str, str2);
        }

        public final void launch(Context context, FragmentManager fragmentManager, long guildId, Long channelId, boolean isNuxFlow, Long guildScheduledEventId, String inviteStoreKey, String source) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(source, "source");
            if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                WidgetGuildInviteShareSheet.INSTANCE.show(fragmentManager, channelId, guildId, source);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, isNuxFlow);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId != null ? channelId.longValue() : 0L);
            intent.putExtra("com.discord.intent.ORIGIN_SOURCE", source);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            intent.putExtra(WidgetGuildInviteShare.INTENT_INVITE_STORE_KEY, inviteStoreKey);
            Observable observableJ = Observable.j(StoreStream.INSTANCE.getExperiments().observeUserExperiment("2020-01_mobile_invite_suggestion_compact", true), new InviteSuggestionsManager(null, null, null, null, null, 31, null).observeInviteSuggestions(), WidgetGuildInviteShare$Companion$launch$1.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…-> exp to inviteService }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout(ObservableExtensionsKt.computationLatest(observableJ), 50L, false), WidgetGuildInviteShare.class, (Context) null, (Function1) null, new WidgetGuildInviteShare$Companion$launch$2(source, context, intent), (Function0) null, (Function0) null, new WidgetGuildInviteShare$Companion$launch$3(source, context, intent), 54, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<InviteSuggestionItem, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
            invoke2(inviteSuggestionItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
            m.checkNotNullParameter(inviteSuggestionItem, "item");
            WidgetGuildInviteShare.access$sendInvite(WidgetGuildInviteShare.this, inviteSuggestionItem, this.$viewState, this.$invite);
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context context = WidgetGuildInviteShare.access$getAdapter$p(WidgetGuildInviteShare.this).getContext();
            String string = WidgetGuildInviteShare.this.getString(R.string.invite_sent);
            m.checkNotNullExpressionValue(string, "getString(R.string.invite_sent)");
            accessibilityUtils.sendAnnouncement(context, string);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass4(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildInviteUiHelperKt.copyLinkClick(a.x(view, "it", "it.context"), this.$invite, WidgetGuildInviteShare.this.getMostRecentIntent());
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Experiment $inviteExperiment;
        public final /* synthetic */ WidgetInviteModel $widgetInviteModel;

        public AnonymousClass5(WidgetInviteModel widgetInviteModel, Experiment experiment) {
            this.$widgetInviteModel = widgetInviteModel;
            this.$inviteExperiment = experiment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).e.toggle();
            ModelInvite.Settings settings = this.$widgetInviteModel.getSettings();
            if (settings != null) {
                WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModelAccess$getViewModel$p = WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this);
                CheckedSetting checkedSetting = WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).e;
                m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
                if (checkedSetting.isChecked()) {
                    i = 0;
                } else {
                    Experiment experiment = this.$inviteExperiment;
                    i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                }
                ModelInvite.Settings settingsMergeMaxAge = settings.mergeMaxAge(i);
                m.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                widgetGuildInviteShareViewModelAccess$getViewModel$p.updateInviteSettings(settingsMergeMaxAge);
            }
            Channel targetChannel = this.$widgetInviteModel.getTargetChannel();
            if (targetChannel != null) {
                WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this).generateInviteLink(Long.valueOf(targetChannel.getId()).longValue());
            }
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass6(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelperKt.shareLinkClick(WidgetGuildInviteShare.this.getContext(), modelInvite);
            }
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$initBottomSheet$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$initBottomSheetBehavior$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BottomSheetBehavior.BottomSheetCallback {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            m.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            m.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 5) {
                WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this).refreshUi();
                WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).f.sendAccessibilityEvent(8);
            } else if (newState == 3) {
                WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).k.sendAccessibilityEvent(8);
                WidgetGuildInviteShare.this.getAppLogger().a(null);
            }
            ViewExtensions.fadeBy$default(WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).f2418b, newState != 5, 0L, 2, null);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public final /* synthetic */ boolean $isNuxFlow;

        public AnonymousClass1(boolean z2) {
            this.$isNuxFlow = z2;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            if (WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).getState() != 5) {
                WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
                return Boolean.TRUE;
            }
            if (!this.$isNuxFlow) {
                return Boolean.FALSE;
            }
            j.c(WidgetGuildInviteShare.this.requireContext(), false, null, 6);
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            m.checkNotNullParameter(editable, "editable");
            WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this).updateSearchQuery(editable.toString());
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(3);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetGuildInviteShare widgetGuildInviteShare) {
            super(1, widgetGuildInviteShare, WidgetGuildInviteShare.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            m.checkNotNullParameter(loaded, "p1");
            WidgetGuildInviteShare.access$configureUI((WidgetGuildInviteShare) this.receiver, loaded);
        }
    }

    public WidgetGuildInviteShare() {
        super(R.layout.widget_guild_invite_share);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShare$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShare$viewModel$2 widgetGuildInviteShare$viewModel$2 = new WidgetGuildInviteShare$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShare$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteShare$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildInviteShare$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildInviteShare widgetGuildInviteShare, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
        widgetGuildInviteShare.configureUI(loaded);
    }

    public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        PrivateChannelAdapter privateChannelAdapter = widgetGuildInviteShare.adapter;
        if (privateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        return privateChannelAdapter;
    }

    public static final /* synthetic */ WidgetGuildInviteShareBinding access$getBinding$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        return widgetGuildInviteShare.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShare.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ WidgetGuildInviteShareViewModel access$getViewModel$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        return widgetGuildInviteShare.getViewModel();
    }

    public static final /* synthetic */ void access$sendInvite(WidgetGuildInviteShare widgetGuildInviteShare, InviteSuggestionItem inviteSuggestionItem, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
        widgetGuildInviteShare.sendInvite(inviteSuggestionItem, loaded, modelInvite);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetGuildInviteShare widgetGuildInviteShare, PrivateChannelAdapter privateChannelAdapter) {
        widgetGuildInviteShare.adapter = privateChannelAdapter;
    }

    public static final /* synthetic */ void access$setBottomSheetBehavior$p(WidgetGuildInviteShare widgetGuildInviteShare, BottomSheetBehavior bottomSheetBehavior) {
        widgetGuildInviteShare.bottomSheetBehavior = bottomSheetBehavior;
    }

    private final void configureUI(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        Guild guild;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        List<InviteSuggestionItem> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        ModelInvite invite = widgetInviteModel.getInvite();
        AppViewFlipper appViewFlipper = getBinding().j;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildInviteSuggestionsFlipper");
        appViewFlipper.setDisplayedChild(!inviteSuggestionItems.isEmpty() ? 1 : 0);
        if (inviteSuggestionItems.size() == 1 && (u.firstOrNull((List) inviteSuggestionItems) instanceof InviteSuggestionItem.Companion)) {
            inviteSuggestionItems = null;
        }
        if (inviteSuggestionItems == null) {
            inviteSuggestionItems = n.emptyList();
        }
        if ((!inviteSuggestionItems.isEmpty()) && !this.hasTrackedSuggestionsViewed) {
            ModelInvite invite2 = widgetInviteModel.getInvite();
            long id2 = (invite2 == null || (guild = invite2.guild) == null) ? 0L : guild.getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj : inviteSuggestionItems) {
                if (obj instanceof InviteSuggestionItem.ChannelItem) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((InviteSuggestionItem.ChannelItem) it.next()).getChannel());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : inviteSuggestionItems) {
                if (obj2 instanceof InviteSuggestionItem.UserItem) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((InviteSuggestionItem.UserItem) it2.next()).getUser());
            }
            analyticsTracker.inviteSuggestionOpened(id2, arrayList2, arrayList4);
            this.hasTrackedSuggestionsViewed = true;
        }
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.guildInviteEmptyResults");
        textView.setVisibility(inviteSuggestionItems.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        recyclerView.setVisibility(inviteSuggestionItems.isEmpty() ^ true ? 0 : 8);
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter.setData(inviteSuggestionItems);
        PrivateChannelAdapter privateChannelAdapter2 = this.adapter;
        if (privateChannelAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter2.setOnClick(new AnonymousClass3(viewState, invite));
        getBinding().k.configureUi(viewState.getWidgetInviteModel());
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildInviteLink");
        textView2.setText(getInviteLink(invite));
        getBinding().d.setOnClickListener(new AnonymousClass4(invite));
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.i(getBinding().e, GuildInviteUiHelperKt.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().e.e(new AnonymousClass5(widgetInviteModel, defaultInviteExperiment));
        getBinding().g.setOnClickListener(new AnonymousClass6(invite));
        ImageView imageView = getBinding().f;
        m.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        CheckedSetting checkedSetting2 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteNeverExpire");
        checkedSetting2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
    }

    private final WidgetGuildInviteShareBinding getBinding() {
        return (WidgetGuildInviteShareBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().k.setOnGenerateLinkListener(new AnonymousClass1());
        getBinding().k.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new AnonymousClass1());
        bottomSheetBehavior.setUpdateImportantForAccessibilityOnSiblings(true);
    }

    public static final void launch(Context context, FragmentManager fragmentManager, long j, Long l, boolean z2, Long l2, String str, String str2) {
        INSTANCE.launch(context, fragmentManager, j, l, z2, l2, str, str2);
    }

    private final void sendInvite(InviteSuggestionItem item, WidgetGuildInviteShareViewModel.ViewState.Loaded viewState, ModelInvite invite) {
        if (item instanceof InviteSuggestionItem.ChannelItem) {
            getViewModel().sendInviteToChannel(((InviteSuggestionItem.ChannelItem) item).getChannel().getId(), viewState, invite);
        } else if (item instanceof InviteSuggestionItem.UserItem) {
            getViewModel().sendInviteToUser(((InviteSuggestionItem.UserItem) item).getUser().getId(), viewState, invite);
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Window window;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) companion.configure(new PrivateChannelAdapter(recyclerView));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(R.string.close) : null);
        setActionBarTitle(R.string.invite_people);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(booleanExtra), 0, 2, null);
        TextInputLayout textInputLayout = getBinding().h;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().k);
        m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f.setOnClickListener(new AnonymousClass3());
        getBinding().f2418b.setOnClickListener(new AnonymousClass4());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel.ViewState> observableK = getViewModel().observeViewState().K();
        m.checkNotNullExpressionValue(observableK, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableG = observableK.y(WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle(observableG, this, privateChannelAdapter), WidgetGuildInviteShare.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
