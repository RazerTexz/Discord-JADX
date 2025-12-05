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
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Func0;

/* compiled from: WidgetGuildInviteShare.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShare extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildInviteShare.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_INVITE_STORE_KEY = "INTENT_INVITE_STORE_KEY";
    public static final String INTENT_IS_NUX_FLOW = "INTENT_IS_NUX_FLOW";
    private PrivateChannelAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;
    private final AppLogger2 loggingConfig;

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(source, "source");
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
            Observable observableM11076j = Observable.m11076j(StoreStream.INSTANCE.getExperiments().observeUserExperiment("2020-01_mobile_invite_suggestion_compact", true), new InviteSuggestionsManager(null, null, null, null, null, 31, null).observeInviteSuggestions(), WidgetGuildInviteShare2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…-> exp to inviteService }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout(ObservableExtensionsKt.computationLatest(observableM11076j), 50L, false), WidgetGuildInviteShare.class, (Context) null, (Function1) null, new WidgetGuildInviteShare3(source, context, intent), (Function0) null, (Function0) null, new WidgetGuildInviteShare4(source, context, intent), 54, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$3 */
    public static final class C86593 extends Lambda implements Function1<InviteSuggestionItem, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C86593(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
            invoke2(inviteSuggestionItem);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItem, "item");
            WidgetGuildInviteShare.access$sendInvite(WidgetGuildInviteShare.this, inviteSuggestionItem, this.$viewState, this.$invite);
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context context = WidgetGuildInviteShare.access$getAdapter$p(WidgetGuildInviteShare.this).getContext();
            String string = WidgetGuildInviteShare.this.getString(C5419R.string.invite_sent);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.invite_sent)");
            accessibilityUtils.sendAnnouncement(context, string);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$4 */
    public static final class ViewOnClickListenerC86604 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public ViewOnClickListenerC86604(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildInviteUiHelper.copyLinkClick(outline.m885x(view, "it", "it.context"), this.$invite, WidgetGuildInviteShare.this.getMostRecentIntent());
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$5 */
    public static final class ViewOnClickListenerC86615 implements View.OnClickListener {
        public final /* synthetic */ Experiment $inviteExperiment;
        public final /* synthetic */ WidgetInviteModel $widgetInviteModel;

        public ViewOnClickListenerC86615(WidgetInviteModel widgetInviteModel, Experiment experiment) {
            this.$widgetInviteModel = widgetInviteModel;
            this.$inviteExperiment = experiment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).f16808e.toggle();
            ModelInvite.Settings settings = this.$widgetInviteModel.getSettings();
            if (settings != null) {
                WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModelAccess$getViewModel$p = WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this);
                CheckedSetting checkedSetting = WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).f16808e;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
                if (checkedSetting.isChecked()) {
                    i = 0;
                } else {
                    Experiment experiment = this.$inviteExperiment;
                    i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                }
                ModelInvite.Settings settingsMergeMaxAge = settings.mergeMaxAge(i);
                Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                widgetGuildInviteShareViewModelAccess$getViewModel$p.updateInviteSettings(settingsMergeMaxAge);
            }
            Channel targetChannel = this.$widgetInviteModel.getTargetChannel();
            if (targetChannel != null) {
                WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this).generateInviteLink(Long.valueOf(targetChannel.getId()).longValue());
            }
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$6 */
    public static final class ViewOnClickListenerC86626 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public ViewOnClickListenerC86626(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelper.shareLinkClick(WidgetGuildInviteShare.this.getContext(), modelInvite);
            }
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$initBottomSheet$1 */
    public static final class C86631 extends Lambda implements Function0<Unit> {
        public C86631() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$initBottomSheetBehavior$1 */
    public static final class C86641 extends BottomSheetBehavior.BottomSheetCallback {
        public C86641() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 5) {
                WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this).refreshUi();
                WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).f16809f.sendAccessibilityEvent(8);
            } else if (newState == 3) {
                WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).f16814k.sendAccessibilityEvent(8);
                WidgetGuildInviteShare.this.getAppLogger().m8371a(null);
            }
            ViewExtensions.fadeBy$default(WidgetGuildInviteShare.access$getBinding$p(WidgetGuildInviteShare.this).f16805b, newState != 5, 0L, 2, null);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$1 */
    public static final class C86651<R> implements Func0<Boolean> {
        public final /* synthetic */ boolean $isNuxFlow;

        public C86651(boolean z2) {
            this.$isNuxFlow = z2;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            if (WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).getState() != 5) {
                WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
                return Boolean.TRUE;
            }
            if (!this.$isNuxFlow) {
                return Boolean.FALSE;
            }
            AppScreen2.m155c(WidgetGuildInviteShare.this.requireContext(), false, null, 6);
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$2 */
    public static final class C86662 extends Lambda implements Function1<Editable, Unit> {
        public C86662() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGuildInviteShare.access$getViewModel$p(WidgetGuildInviteShare.this).updateSearchQuery(editable.toString());
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$3 */
    public static final class ViewOnClickListenerC86673 implements View.OnClickListener {
        public ViewOnClickListenerC86673() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(3);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$4 */
    public static final class ViewOnClickListenerC86684 implements View.OnClickListener {
        public ViewOnClickListenerC86684() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShare.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C86691 extends FunctionReferenceImpl implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public C86691(WidgetGuildInviteShare widgetGuildInviteShare) {
            super(1, widgetGuildInviteShare, WidgetGuildInviteShare.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetGuildInviteShare.access$configureUI((WidgetGuildInviteShare) this.receiver, loaded);
        }
    }

    public WidgetGuildInviteShare() {
        super(C5419R.layout.widget_guild_invite_share);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShare5.INSTANCE, null, 2, null);
        WidgetGuildInviteShare7 widgetGuildInviteShare7 = new WidgetGuildInviteShare7(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShare$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShare7));
        this.loggingConfig = new AppLogger2(false, null, new WidgetGuildInviteShare6(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildInviteShare widgetGuildInviteShare, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
        widgetGuildInviteShare.configureUI(loaded);
    }

    public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        PrivateChannelAdapter privateChannelAdapter = widgetGuildInviteShare.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return privateChannelAdapter;
    }

    public static final /* synthetic */ WidgetGuildInviteShareBinding access$getBinding$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        return widgetGuildInviteShare.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShare.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
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
        AppViewFlipper appViewFlipper = getBinding().f16813j;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildInviteSuggestionsFlipper");
        appViewFlipper.setDisplayedChild(!inviteSuggestionItems.isEmpty() ? 1 : 0);
        if (inviteSuggestionItems.size() == 1 && (_Collections.firstOrNull((List) inviteSuggestionItems) instanceof InviteSuggestionItem.Companion)) {
            inviteSuggestionItems = null;
        }
        if (inviteSuggestionItems == null) {
            inviteSuggestionItems = Collections2.emptyList();
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
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
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
            ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((InviteSuggestionItem.UserItem) it2.next()).getUser());
            }
            analyticsTracker.inviteSuggestionOpened(id2, arrayList2, arrayList4);
            this.hasTrackedSuggestionsViewed = true;
        }
        TextView textView = getBinding().f16806c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteEmptyResults");
        textView.setVisibility(inviteSuggestionItems.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().f16812i;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        recyclerView.setVisibility(inviteSuggestionItems.isEmpty() ^ true ? 0 : 8);
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter.setData(inviteSuggestionItems);
        PrivateChannelAdapter privateChannelAdapter2 = this.adapter;
        if (privateChannelAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter2.setOnClick(new C86593(viewState, invite));
        getBinding().f16814k.configureUi(viewState.getWidgetInviteModel());
        TextView textView2 = getBinding().f16807d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildInviteLink");
        textView2.setText(getInviteLink(invite));
        getBinding().f16807d.setOnClickListener(new ViewOnClickListenerC86604(invite));
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().f16808e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.m8524i(getBinding().f16808e, GuildInviteUiHelper.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().f16808e.m8527e(new ViewOnClickListenerC86615(widgetInviteModel, defaultInviteExperiment));
        getBinding().f16810g.setOnClickListener(new ViewOnClickListenerC86626(invite));
        ImageView imageView = getBinding().f16809f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        CheckedSetting checkedSetting2 = getBinding().f16808e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteNeverExpire");
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
        getBinding().f16814k.setOnGenerateLinkListener(new C86631());
        getBinding().f16814k.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new C86641());
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

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Window window;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16812i;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) companion.configure(new PrivateChannelAdapter(recyclerView));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(C5419R.string.close) : null);
        setActionBarTitle(C5419R.string.invite_people);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setOnBackPressed$default(this, new C86651(booleanExtra), 0, 2, null);
        TextInputLayout textInputLayout = getBinding().f16811h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C86662());
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().f16814k);
        Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f16809f.setOnClickListener(new ViewOnClickListenerC86673());
        getBinding().f16805b.setOnClickListener(new ViewOnClickListenerC86684());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel.ViewState> observableM11085K = getViewModel().observeViewState().m11085K();
        Intrinsics3.checkNotNullExpressionValue(observableM11085K, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableM11083G = observableM11085K.m11118y(WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).m11083G(WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle(observableM11083G, this, privateChannelAdapter), WidgetGuildInviteShare.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C86691(this), 62, (Object) null);
    }
}
