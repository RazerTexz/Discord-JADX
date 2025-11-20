package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareCompactBinding;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
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
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetGuildInviteShareCompact.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteShareCompact.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", 0)};
    private PrivateChannelAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class PrivateChannelAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItem> {
        private Function1<? super InviteSuggestionItem, Unit> onClick;

        /* compiled from: WidgetGuildInviteShareCompact.kt */
        public static final class Item extends MGRecyclerViewHolder<PrivateChannelAdapter, InviteSuggestionItem> {
            private final WidgetGuildInviteShareItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(PrivateChannelAdapter privateChannelAdapter) {
                super(R.layout.widget_guild_invite_share_item, privateChannelAdapter);
                m.checkNotNullParameter(privateChannelAdapter, "adapter");
                WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
                m.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
                this.binding = widgetGuildInviteShareItemBindingA;
            }

            public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(Item item) {
                return (PrivateChannelAdapter) item.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItem inviteSuggestionItem) {
                onConfigure2(i, inviteSuggestionItem);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, InviteSuggestionItem data) {
                m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                boolean z2 = data instanceof InviteSuggestionItem.ChannelItem;
                if (z2) {
                    InviteSuggestionItem.ChannelItem channelItem = (InviteSuggestionItem.ChannelItem) data;
                    if (channelItem.getChannel().getType() != 1) {
                        SimpleDraweeView simpleDraweeView = this.binding.f2421b;
                        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView, channelItem.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
                    } else {
                        SimpleDraweeView simpleDraweeView2 = this.binding.f2421b;
                        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView2, ChannelUtils.a(channelItem.getChannel()), 0, null, null, null, 60, null);
                    }
                    TextView textView = this.binding.d;
                    m.checkNotNullExpressionValue(textView, "binding.itemNameTv");
                    textView.setText(ChannelUtils.c(channelItem.getChannel()));
                } else if (data instanceof InviteSuggestionItem.UserItem) {
                    SimpleDraweeView simpleDraweeView3 = this.binding.f2421b;
                    m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
                    InviteSuggestionItem.UserItem userItem = (InviteSuggestionItem.UserItem) data;
                    IconUtils.setIcon$default(simpleDraweeView3, userItem.getUser(), 0, null, null, null, 60, null);
                    TextView textView2 = this.binding.d;
                    m.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
                    textView2.setText(userItem.getUser().getUsername());
                }
                if (z2 || (data instanceof InviteSuggestionItem.UserItem)) {
                    MaterialButton materialButton = this.binding.e;
                    m.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                    materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                    MaterialButton materialButton2 = this.binding.c;
                    m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                    materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                    this.binding.c.setOnClickListener(new WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item$onConfigure$1(this, data));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateChannelAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            m.checkNotNullParameter(recyclerView, "recycler");
            this.onClick = WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1.INSTANCE;
        }

        public final Function1<InviteSuggestionItem, Unit> getOnClick() {
            return this.onClick;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setOnClick(Function1<? super InviteSuggestionItem, Unit> function1) {
            m.checkNotNullParameter(function1, "<set-?>");
            this.onClick = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Item onCreateViewHolder(ViewGroup parent, int viewType) {
            m.checkNotNullParameter(parent, "parent");
            return new Item(this);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$configureUI$3, reason: invalid class name */
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
            WidgetGuildInviteShareCompact.access$sendInvite(WidgetGuildInviteShareCompact.this, inviteSuggestionItem, this.$viewState, this.$invite);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass4(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelperKt.shareLinkClick(WidgetGuildInviteShareCompact.this.getContext(), modelInvite);
            }
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$initBottomSheet$1, reason: invalid class name */
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
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$initBottomSheetBehavior$1, reason: invalid class name */
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
                WidgetGuildInviteShareCompact.access$getViewModel$p(WidgetGuildInviteShareCompact.this).refreshUi();
            }
            ViewExtensions.fadeBy$default(WidgetGuildInviteShareCompact.access$getBinding$p(WidgetGuildInviteShareCompact.this).f2419b, newState != 5, 0L, 2, null);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$1, reason: invalid class name */
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
            if (WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).getState() != 5) {
                WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
                return Boolean.TRUE;
            }
            if (!this.$isNuxFlow) {
                return Boolean.FALSE;
            }
            j.c(WidgetGuildInviteShareCompact.this.requireContext(), false, null, 6);
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$2, reason: invalid class name */
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
            WidgetGuildInviteShareCompact.access$getViewModel$p(WidgetGuildInviteShareCompact.this).updateSearchQuery(editable.toString());
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
            super(1, widgetGuildInviteShareCompact, WidgetGuildInviteShareCompact.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            m.checkNotNullParameter(loaded, "p1");
            WidgetGuildInviteShareCompact.access$configureUI((WidgetGuildInviteShareCompact) this.receiver, loaded);
        }
    }

    public WidgetGuildInviteShareCompact() {
        super(R.layout.widget_guild_invite_share_compact);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShareCompact$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareCompact$viewModel$2 widgetGuildInviteShareCompact$viewModel$2 = new WidgetGuildInviteShareCompact$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShareCompact$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteShareCompact$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
        widgetGuildInviteShareCompact.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetGuildInviteShareCompactBinding access$getBinding$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        return widgetGuildInviteShareCompact.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareCompact.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ WidgetGuildInviteShareViewModel access$getViewModel$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        return widgetGuildInviteShareCompact.getViewModel();
    }

    public static final /* synthetic */ void access$sendInvite(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, InviteSuggestionItem inviteSuggestionItem, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
        widgetGuildInviteShareCompact.sendInvite(inviteSuggestionItem, loaded, modelInvite);
    }

    public static final /* synthetic */ void access$setBottomSheetBehavior$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, BottomSheetBehavior bottomSheetBehavior) {
        widgetGuildInviteShareCompact.bottomSheetBehavior = bottomSheetBehavior;
    }

    private final void configureUI(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        Guild guild;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        List<InviteSuggestionItem> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        ModelInvite invite = widgetInviteModel.getInvite();
        AppViewFlipper appViewFlipper = getBinding().i;
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
        RecyclerView recyclerView = getBinding().h;
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
        getBinding().j.configureUi(viewState.getWidgetInviteModel());
        MaterialButton materialButton = getBinding().f;
        m.checkNotNullExpressionValue(materialButton, "binding.guildInviteShareBtn");
        materialButton.setText(getInviteLink(invite));
        getBinding().f.setOnClickListener(new AnonymousClass4(invite));
        ImageView imageView = getBinding().e;
        m.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildInviteNeverExpire");
        textView2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView3 = getBinding().d;
        m.checkNotNullExpressionValue(textView3, "binding.guildInviteNeverExpire");
        textView3.setText(GuildInviteUiHelperKt.getInviteLinkText(requireContext(), getViewModel().getDefaultInviteExperiment()));
    }

    private final WidgetGuildInviteShareCompactBinding getBinding() {
        return (WidgetGuildInviteShareCompactBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().j.setOnGenerateLinkListener(new AnonymousClass1());
        getBinding().j.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new AnonymousClass1());
    }

    private final void sendInvite(InviteSuggestionItem item, WidgetGuildInviteShareViewModel.ViewState.Loaded viewState, ModelInvite invite) {
        if (item instanceof InviteSuggestionItem.ChannelItem) {
            getViewModel().sendInviteToChannel(((InviteSuggestionItem.ChannelItem) item).getChannel().getId(), viewState, invite);
        } else if (item instanceof InviteSuggestionItem.UserItem) {
            getViewModel().sendInviteToUser(((InviteSuggestionItem.UserItem) item).getUser().getId(), viewState, invite);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().h;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) companion.configure(new PrivateChannelAdapter(recyclerView));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(R.string.close) : null);
        setActionBarTitle(R.string.invite_people);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(booleanExtra), 0, 2, null);
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareCompactSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().j);
        m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().d.setOnClickListener(new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4());
        getBinding().f2419b.setOnClickListener(new AnonymousClass5());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle(observableG, this, privateChannelAdapter), WidgetGuildInviteShareCompact.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
