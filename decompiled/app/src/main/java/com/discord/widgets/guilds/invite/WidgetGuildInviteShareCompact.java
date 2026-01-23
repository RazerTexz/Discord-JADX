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
import com.discord.BuildConfig;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildInviteShareCompact.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", 0)};
    private PrivateChannelAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class PrivateChannelAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItem> {
        private Function1<? super InviteSuggestionItem, Unit> onClick;

        /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
        public static final class Item extends MGRecyclerViewHolder<PrivateChannelAdapter, InviteSuggestionItem> {
            private final WidgetGuildInviteShareItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(PrivateChannelAdapter privateChannelAdapter) {
                super(C5419R.layout.widget_guild_invite_share_item, privateChannelAdapter);
                Intrinsics3.checkNotNullParameter(privateChannelAdapter, "adapter");
                WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingM8417a = WidgetGuildInviteShareItemBinding.m8417a(this.itemView);
                Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingM8417a, "WidgetGuildInviteShareItemBinding.bind(itemView)");
                this.binding = widgetGuildInviteShareItemBindingM8417a;
            }

            public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(Item item) {
                return (PrivateChannelAdapter) item.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItem inviteSuggestionItem) {
                onConfigure2(i, inviteSuggestionItem);
            }

            /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, InviteSuggestionItem data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                boolean z2 = data instanceof InviteSuggestionItem.ChannelItem;
                if (z2) {
                    InviteSuggestionItem.ChannelItem channelItem = (InviteSuggestionItem.ChannelItem) data;
                    if (channelItem.getChannel().getType() != 1) {
                        SimpleDraweeView simpleDraweeView = this.binding.f16833b;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView, channelItem.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
                    } else {
                        SimpleDraweeView simpleDraweeView2 = this.binding.f16833b;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView2, ChannelUtils.m7677a(channelItem.getChannel()), 0, null, null, null, 60, null);
                    }
                    TextView textView = this.binding.f16835d;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
                    textView.setText(ChannelUtils.m7679c(channelItem.getChannel()));
                } else if (data instanceof InviteSuggestionItem.UserItem) {
                    SimpleDraweeView simpleDraweeView3 = this.binding.f16833b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
                    InviteSuggestionItem.UserItem userItem = (InviteSuggestionItem.UserItem) data;
                    IconUtils.setIcon$default(simpleDraweeView3, userItem.getUser(), 0, null, null, null, 60, null);
                    TextView textView2 = this.binding.f16835d;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
                    textView2.setText(userItem.getUser().getUsername());
                }
                if (z2 || (data instanceof InviteSuggestionItem.UserItem)) {
                    MaterialButton materialButton = this.binding.f16836e;
                    Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                    materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                    MaterialButton materialButton2 = this.binding.f16834c;
                    Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                    materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                    this.binding.f16834c.setOnClickListener(new WidgetGuildInviteShareCompact2(this, data));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateChannelAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.onClick = WidgetGuildInviteShareCompact3.INSTANCE;
        }

        public final Function1<InviteSuggestionItem, Unit> getOnClick() {
            return this.onClick;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setOnClick(Function1<? super InviteSuggestionItem, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "<set-?>");
            this.onClick = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Item onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new Item(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$configureUI$3 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class C86723 extends Lambda implements Function1<InviteSuggestionItem, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C86723(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
            invoke2(inviteSuggestionItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItem, "item");
            WidgetGuildInviteShareCompact.access$sendInvite(WidgetGuildInviteShareCompact.this, inviteSuggestionItem, this.$viewState, this.$invite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$configureUI$4 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class ViewOnClickListenerC86734 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public ViewOnClickListenerC86734(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelper.shareLinkClick(WidgetGuildInviteShareCompact.this.getContext(), modelInvite);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$initBottomSheet$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class C86741 extends Lambda implements Function0<Unit> {
        public C86741() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$initBottomSheetBehavior$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class C86751 extends BottomSheetBehavior.BottomSheetCallback {
        public C86751() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 5) {
                WidgetGuildInviteShareCompact.access$getViewModel$p(WidgetGuildInviteShareCompact.this).refreshUi();
            }
            ViewExtensions.fadeBy$default(WidgetGuildInviteShareCompact.access$getBinding$p(WidgetGuildInviteShareCompact.this).f16816b, newState != 5, 0L, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class C86761<R> implements Func0<Boolean> {
        public final /* synthetic */ boolean $isNuxFlow;

        public C86761(boolean z2) {
            this.$isNuxFlow = z2;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            if (WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).getState() != 5) {
                WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
                return Boolean.TRUE;
            }
            if (!this.$isNuxFlow) {
                return Boolean.FALSE;
            }
            AppScreen2.m155c(WidgetGuildInviteShareCompact.this.requireContext(), false, null, 6);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class C86772 extends Lambda implements Function1<Editable, Unit> {
        public C86772() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGuildInviteShareCompact.access$getViewModel$p(WidgetGuildInviteShareCompact.this).updateSearchQuery(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class ViewOnClickListenerC86783 implements View.OnClickListener {
        public ViewOnClickListenerC86783() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class ViewOnClickListenerC86794 implements View.OnClickListener {
        public ViewOnClickListenerC86794() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class ViewOnClickListenerC86805 implements View.OnClickListener {
        public ViewOnClickListenerC86805() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final /* synthetic */ class C86831 extends FunctionReferenceImpl implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public C86831(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
            super(1, widgetGuildInviteShareCompact, WidgetGuildInviteShareCompact.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetGuildInviteShareCompact.access$configureUI((WidgetGuildInviteShareCompact) this.receiver, loaded);
        }
    }

    public WidgetGuildInviteShareCompact() {
        super(C5419R.layout.widget_guild_invite_share_compact);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShareCompact4.INSTANCE, null, 2, null);
        WidgetGuildInviteShareCompact5 widgetGuildInviteShareCompact5 = new WidgetGuildInviteShareCompact5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new C8671xdacc81dd(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShareCompact5));
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
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
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
        AppViewFlipper appViewFlipper = getBinding().f16823i;
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
        TextView textView = getBinding().f16817c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteEmptyResults");
        textView.setVisibility(inviteSuggestionItems.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().f16822h;
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
        privateChannelAdapter2.setOnClick(new C86723(viewState, invite));
        getBinding().f16824j.configureUi(viewState.getWidgetInviteModel());
        MaterialButton materialButton = getBinding().f16820f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildInviteShareBtn");
        materialButton.setText(getInviteLink(invite));
        getBinding().f16820f.setOnClickListener(new ViewOnClickListenerC86734(invite));
        ImageView imageView = getBinding().f16819e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView2 = getBinding().f16818d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildInviteNeverExpire");
        textView2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView3 = getBinding().f16818d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildInviteNeverExpire");
        textView3.setText(GuildInviteUiHelper.getInviteLinkText(requireContext(), getViewModel().getDefaultInviteExperiment()));
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
        getBinding().f16824j.setOnGenerateLinkListener(new C86741());
        getBinding().f16824j.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new C86751());
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16822h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) companion.configure(new PrivateChannelAdapter(recyclerView));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(C5419R.string.close) : null);
        setActionBarTitle(C5419R.string.invite_people);
        AppFragment.setOnBackPressed$default(this, new C86761(booleanExtra), 0, 2, null);
        TextInputLayout textInputLayout = getBinding().f16821g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareCompactSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C86772());
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().f16824j);
        Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f16818d.setOnClickListener(new ViewOnClickListenerC86783());
        getBinding().f16819e.setOnClickListener(new ViewOnClickListenerC86794());
        getBinding().f16816b.setOnClickListener(new ViewOnClickListenerC86805());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableM11083G = getViewModel().observeViewState().m11118y(C8681xef41c609.INSTANCE).m11083G(C8682xef41c60a.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle(observableM11083G, this, privateChannelAdapter), WidgetGuildInviteShareCompact.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C86831(this), 62, (Object) null);
    }
}
