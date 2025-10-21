package com.discord.widgets.channels;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelTopicBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.utilities.channel.GuildChannelIconUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.user.WidgetUserMutualGuilds;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.badge.BadgeDrawable;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChannelTopic.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelTopic extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelTopic.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelTopicBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean isDm;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelTopic.kt */
    public static final /* data */ class RenderedTopic {
        public static final int MAX_LINES = 40;
        public static final int MIN_LINES = 2;
        private final int autoLinkMask;
        private final CharSequence channelName;
        private final CharSequence topic;

        public RenderedTopic() {
            this(null, null, 0, 7, null);
        }

        public RenderedTopic(CharSequence charSequence, CharSequence charSequence2, int i) {
            this.channelName = charSequence;
            this.topic = charSequence2;
            this.autoLinkMask = i;
        }

        public static /* synthetic */ RenderedTopic copy$default(RenderedTopic renderedTopic, CharSequence charSequence, CharSequence charSequence2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = renderedTopic.channelName;
            }
            if ((i2 & 2) != 0) {
                charSequence2 = renderedTopic.topic;
            }
            if ((i2 & 4) != 0) {
                i = renderedTopic.autoLinkMask;
            }
            return renderedTopic.copy(charSequence, charSequence2, i);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getChannelName() {
            return this.channelName;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getTopic() {
            return this.topic;
        }

        /* renamed from: component3, reason: from getter */
        public final int getAutoLinkMask() {
            return this.autoLinkMask;
        }

        public final RenderedTopic copy(CharSequence channelName, CharSequence topic, int autoLinkMask) {
            return new RenderedTopic(channelName, topic, autoLinkMask);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RenderedTopic)) {
                return false;
            }
            RenderedTopic renderedTopic = (RenderedTopic) other;
            return Intrinsics3.areEqual(this.channelName, renderedTopic.channelName) && Intrinsics3.areEqual(this.topic, renderedTopic.topic) && this.autoLinkMask == renderedTopic.autoLinkMask;
        }

        public final int getAutoLinkMask() {
            return this.autoLinkMask;
        }

        public final CharSequence getChannelName() {
            return this.channelName;
        }

        public final CharSequence getTopic() {
            return this.topic;
        }

        public int hashCode() {
            CharSequence charSequence = this.channelName;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.topic;
            return ((iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31) + this.autoLinkMask;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RenderedTopic(channelName=");
            sbU.append(this.channelName);
            sbU.append(", topic=");
            sbU.append(this.topic);
            sbU.append(", autoLinkMask=");
            return outline.B(sbU, this.autoLinkMask, ")");
        }

        public /* synthetic */ RenderedTopic(String str, CharSequence charSequence, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : charSequence, (i2 & 4) != 0 ? 0 : i);
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$configureEllipsis$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelTopic.access$onToggleTopicExpansionState(WidgetChannelTopic.this);
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelTopicViewModel.ViewState $viewState;

        public AnonymousClass1(WidgetChannelTopicViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Long recipientUserId = ((WidgetChannelTopicViewModel.ViewState.DM) this.$viewState).getRecipientUserId();
            if (recipientUserId != null) {
                WidgetUserMutualGuilds.INSTANCE.show(WidgetChannelTopic.this.requireContext(), recipientUserId.longValue());
            }
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelTopicViewModel.ViewState $viewState;

        public AnonymousClass2(WidgetChannelTopicViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelTopic.access$onClickMore(WidgetChannelTopic.this, this.$viewState);
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$onToggleTopicExpansionState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(WidgetChannelTopic.access$getBinding$p(WidgetChannelTopic.this).g, "maxLines", i);
            Intrinsics3.checkNotNullExpressionValue(objectAnimatorOfInt, "animation");
            objectAnimatorOfInt.setDuration(150L);
            objectAnimatorOfInt.addListener(new WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1(this));
            objectAnimatorOfInt.start();
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelTopic.access$onToggleTopicExpansionState(WidgetChannelTopic.this);
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetChannelTopicViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelTopicViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelTopicViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetChannelTopic.access$handleEvent(WidgetChannelTopic.this, event);
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetChannelTopicViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelTopicViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelTopicViewModel.ViewState viewState) throws Resources.NotFoundException {
            WidgetChannelTopic widgetChannelTopic = WidgetChannelTopic.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetChannelTopic.access$configureUI(widgetChannelTopic, viewState);
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$showContextMenu$1, reason: invalid class name */
    public static final class AnonymousClass1 implements MenuItem.OnMenuItemClickListener {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            WidgetChannelPinnedMessages.INSTANCE.show(WidgetChannelTopic.this.requireContext(), this.$channelId);
            return true;
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$showContextMenu$2, reason: invalid class name */
    public static final class AnonymousClass2 implements MenuItem.OnMenuItemClickListener {
        public final /* synthetic */ long $channelId;

        public AnonymousClass2(long j) {
            this.$channelId = j;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppToast.c(WidgetChannelTopic.this.requireContext(), String.valueOf(this.$channelId), 0, 4);
            return true;
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$showContextMenu$3, reason: invalid class name */
    public static final class AnonymousClass3 implements MenuItem.OnMenuItemClickListener {
        public final /* synthetic */ long $channelId;

        public AnonymousClass3(long j) {
            this.$channelId = j;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            WidgetChannelGroupDMSettings.INSTANCE.create(this.$channelId, WidgetChannelTopic.this.requireContext());
            return true;
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$showContextMenu$4, reason: invalid class name */
    public static final class AnonymousClass4 implements MenuItem.OnMenuItemClickListener {
        public final /* synthetic */ CharSequence $channelTitle;

        /* compiled from: WidgetChannelTopic.kt */
        /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$showContextMenu$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "v");
                WidgetChannelTopicViewModel widgetChannelTopicViewModelAccess$getViewModel$p = WidgetChannelTopic.access$getViewModel$p(WidgetChannelTopic.this);
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "v.context");
                widgetChannelTopicViewModelAccess$getViewModel$p.handleClosePrivateChannel(context);
            }
        }

        public AnonymousClass4(CharSequence charSequence) {
            this.$channelTitle = charSequence;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelTopic.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.k(WidgetChannelTopic.this, R.string.leave_group_dm_title, new Object[]{this.$channelTitle}, null, 4), FormatUtils.k(WidgetChannelTopic.this, R.string.leave_group_dm_body, new Object[]{this.$channelTitle}, null, 4), FormatUtils.k(WidgetChannelTopic.this, R.string.leave_group_dm, new Object[0], null, 4), FormatUtils.k(WidgetChannelTopic.this, R.string.cancel, new Object[0], null, 4), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1())), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
            return true;
        }
    }

    /* compiled from: WidgetChannelTopic.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopic$showContextMenu$5, reason: invalid class name */
    public static final class AnonymousClass5 implements MenuItem.OnMenuItemClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            WidgetChannelTopic.access$getViewModel$p(WidgetChannelTopic.this).handleClosePrivateChannel(WidgetChannelTopic.this.requireContext());
            return true;
        }
    }

    public WidgetChannelTopic() {
        super(R.layout.widget_channel_topic);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelTopic2.INSTANCE, null, 2, null);
        WidgetChannelTopic5 widgetChannelTopic5 = WidgetChannelTopic5.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelTopicViewModel.class), new WidgetChannelTopic$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelTopic5));
    }

    public static final /* synthetic */ void access$configureEllipsis(WidgetChannelTopic widgetChannelTopic) {
        widgetChannelTopic.configureEllipsis();
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel.ViewState viewState) throws Resources.NotFoundException {
        widgetChannelTopic.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetChannelTopicBinding access$getBinding$p(WidgetChannelTopic widgetChannelTopic) {
        return widgetChannelTopic.getBinding();
    }

    public static final /* synthetic */ WidgetChannelTopicViewModel access$getViewModel$p(WidgetChannelTopic widgetChannelTopic) {
        return widgetChannelTopic.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel.Event event) {
        widgetChannelTopic.handleEvent(event);
    }

    public static final /* synthetic */ void access$onClickMore(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel.ViewState viewState) {
        widgetChannelTopic.onClickMore(viewState);
    }

    public static final /* synthetic */ void access$onToggleTopicExpansionState(WidgetChannelTopic widgetChannelTopic) {
        widgetChannelTopic.onToggleTopicExpansionState();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureChannelTopicTitle(RenderedTopic renderedTopic) {
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        CharSequence topic = renderedTopic.getTopic();
        boolean z2 = true;
        if (topic == null) {
            z2 = false;
        } else {
            if (!(topic.length() > 0)) {
            }
        }
        linkifiedTextView.setVisibility(z2 ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.channelTopicTitle");
        linkifiedTextView2.setAutoLinkMask(renderedTopic.getAutoLinkMask());
        CharSequence topic2 = renderedTopic.getTopic();
        if (topic2 instanceof DraweeSpanStringBuilder) {
            getBinding().g.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) topic2);
            return;
        }
        LinkifiedTextView linkifiedTextView3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.channelTopicTitle");
        linkifiedTextView3.setText(topic2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureEllipsis() {
        boolean z2;
        Lifecycle lifecycle = getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED)) {
            getBinding().d.setOnClickListener(new AnonymousClass1());
            ImageView imageView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelTopicEllipsis");
            if (!this.isDm) {
                LinkifiedTextView linkifiedTextView = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
                if (linkifiedTextView.getLineCount() > 2) {
                    LinkifiedTextView linkifiedTextView2 = getBinding().g;
                    Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.channelTopicTitle");
                    z2 = linkifiedTextView2.getMaxLines() != 40;
                }
            }
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(WidgetChannelTopicViewModel.ViewState viewState) throws Resources.NotFoundException {
        RenderedTopic renderedTopicForGDM;
        boolean z2;
        if (viewState instanceof WidgetChannelTopicViewModel.ViewState.NoChannel) {
            View view = getView();
            if (view != null) {
                ViewKt.setVisible(view, false);
            }
            ImageView imageView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelTopicMoreIcon");
            imageView.setVisibility(8);
            setChannelIcon(GuildChannelIconUtils2.mapGuildChannelTypeToIcon(GuildChannelIconUtils.Text.INSTANCE));
            renderedTopicForGDM = new RenderedTopic(null, null, 0, 7, null);
        } else if (viewState instanceof WidgetChannelTopicViewModel.ViewState.Guild) {
            View view2 = getView();
            if (view2 != null) {
                ViewKt.setVisible(view2, true);
            }
            ImageView imageView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.channelTopicMoreIcon");
            imageView2.setVisibility(8);
            setChannelIcon(GuildChannelIconUtils2.mapGuildChannelTypeToIcon(((WidgetChannelTopicViewModel.ViewState.Guild) viewState).getChannelIconType()));
            if (viewState instanceof WidgetChannelTopicViewModel.ViewState.Guild.DefaultTopic) {
                renderedTopicForGDM = getRenderedTopicForDefaultTopic((WidgetChannelTopicViewModel.ViewState.Guild.DefaultTopic) viewState);
            } else {
                Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild.Topic");
                renderedTopicForGDM = getRenderedTopicForTopic((WidgetChannelTopicViewModel.ViewState.Guild.Topic) viewState);
            }
        } else if (viewState instanceof WidgetChannelTopicViewModel.ViewState.DM) {
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            ImageView imageView3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.channelTopicMoreIcon");
            imageView3.setVisibility(0);
            setChannelIcon(R.drawable.ic_direct_message_header);
            WidgetChannelTopicViewModel.ViewState.DM dm = (WidgetChannelTopicViewModel.ViewState.DM) viewState;
            getBinding().f2281b.configure(dm.getGuildMembers());
            renderedTopicForGDM = new RenderedTopic(dm.getRecipientName(), null, 0, 6, null);
        } else {
            if (!(viewState instanceof WidgetChannelTopicViewModel.ViewState.GDM)) {
                throw new NoWhenBranchMatchedException();
            }
            View view4 = getView();
            if (view4 != null) {
                ViewKt.setVisible(view4, true);
            }
            ImageView imageView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.channelTopicMoreIcon");
            imageView4.setVisibility(0);
            WidgetChannelTopicViewModel.ViewState.GDM gdm = (WidgetChannelTopicViewModel.ViewState.GDM) viewState;
            setChannelIconForGDM(gdm.getChannel());
            renderedTopicForGDM = getRenderedTopicForGDM(gdm);
        }
        configureChannelTopicTitle(renderedTopicForGDM);
        boolean z3 = viewState instanceof WidgetChannelTopicViewModel.ViewState.DM;
        if (z3) {
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.DM");
            WidgetChannelTopicViewModel.ViewState.DM dm2 = (WidgetChannelTopicViewModel.ViewState.DM) viewState;
            Set<String> recipientNicknames = dm2.getRecipientNicknames();
            List<GuildMember> guildMembers = dm2.getGuildMembers();
            if ((guildMembers instanceof Collection) && guildMembers.isEmpty()) {
                z2 = false;
                getBinding().f2281b.setOnClickListener(new AnonymousClass1(viewState));
                UserAkaView userAkaView = getBinding().f2281b;
                Intrinsics3.checkNotNullExpressionValue(userAkaView, "binding.channelAka");
                if (recipientNicknames != null) {
                    if (recipientNicknames != null || recipientNicknames.isEmpty()) {
                        userAkaView.setVisibility(!((recipientNicknames != null || recipientNicknames.isEmpty()) || z2) ? 0 : 8);
                    }
                }
            } else {
                Iterator<T> it = guildMembers.iterator();
                while (it.hasNext()) {
                    if (((GuildMember) it.next()).hasAvatar()) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                getBinding().f2281b.setOnClickListener(new AnonymousClass1(viewState));
                UserAkaView userAkaView2 = getBinding().f2281b;
                Intrinsics3.checkNotNullExpressionValue(userAkaView2, "binding.channelAka");
                userAkaView2.setVisibility(!((recipientNicknames != null || recipientNicknames.isEmpty()) || z2) ? 0 : 8);
            }
        } else {
            UserAkaView userAkaView3 = getBinding().f2281b;
            Intrinsics3.checkNotNullExpressionValue(userAkaView3, "binding.channelAka");
            userAkaView3.setVisibility(8);
        }
        this.isDm = z3;
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        CharSequence topic = renderedTopicForGDM.getTopic();
        linkifiedTextView.setVisibility(((topic == null || StringsJVM.isBlank(topic)) || z3) ? false : true ? 0 : 8);
        configureEllipsis();
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelTopicName");
        textView.setText(renderedTopicForGDM.getChannelName());
        getBinding().e.setOnClickListener(new AnonymousClass2(viewState));
    }

    private final WidgetChannelTopicBinding getBinding() {
        return (WidgetChannelTopicBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final RenderedTopic getRenderedTopicForDefaultTopic(WidgetChannelTopicViewModel.ViewState.Guild.DefaultTopic viewState) {
        return new RenderedTopic(ChannelUtils.d(viewState.getChannel(), requireContext(), false), "", 0);
    }

    private final RenderedTopic getRenderedTopicForGDM(WidgetChannelTopicViewModel.ViewState.GDM viewState) {
        return new RenderedTopic(ChannelUtils.d(viewState.getChannel(), requireContext(), false), null, 0, 4, null);
    }

    private final RenderedTopic getRenderedTopicForTopic(WidgetChannelTopicViewModel.ViewState.Guild.Topic viewState) {
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        Context context = linkifiedTextView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.channelTopicTitle.context");
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(viewState.getAst(), new MessageRenderContext(context, 0L, viewState.getAllowAnimatedEmojis(), viewState.getUserNames(), viewState.getChannelNames(), viewState.getRoles(), 0, null, WidgetChannelTopic3.INSTANCE, 0, 0, new WidgetChannelTopic4(getViewModel()), null, null, 14016, null));
        return new RenderedTopic(ChannelUtils.d(viewState.getChannel(), requireContext(), false), draweeSpanStringBuilderRender, (draweeSpanStringBuilderRender.length() > 200 || viewState.isLinkifyConflicting()) ? 0 : 15);
    }

    private final WidgetChannelTopicViewModel getViewModel() {
        return (WidgetChannelTopicViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetChannelTopicViewModel.Event event) {
        if (event instanceof WidgetChannelTopicViewModel.Event.FocusFirstElement) {
            getBinding().f.sendAccessibilityEvent(8);
        }
    }

    private final void onClickMore(WidgetChannelTopicViewModel.ViewState viewState) {
        if (viewState instanceof WidgetChannelTopicViewModel.ViewState.GDM) {
            WidgetChannelTopicViewModel.ViewState.GDM gdm = (WidgetChannelTopicViewModel.ViewState.GDM) viewState;
            showContextMenu(true, gdm.getChannelId(), ChannelUtils.d(gdm.getChannel(), requireContext(), false), gdm.getDeveloperModeEnabled());
        } else if (viewState instanceof WidgetChannelTopicViewModel.ViewState.DM) {
            WidgetChannelTopicViewModel.ViewState.DM dm = (WidgetChannelTopicViewModel.ViewState.DM) viewState;
            showContextMenu$default(this, false, dm.getChannelId(), null, dm.getDeveloperModeEnabled(), 4, null);
        }
    }

    private final void onToggleTopicExpansionState() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        if (linkifiedTextView.getMaxLines() != 40) {
            anonymousClass1.invoke(40);
        } else {
            anonymousClass1.invoke(2);
        }
    }

    private final void setChannelIcon(@DrawableRes int channelIconResource) {
        getBinding().c.setImageResource(channelIconResource);
        SimpleDraweeView simpleDraweeView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelTopicChannelIcon");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, DimenUtils.dpToPixels(4), marginLayoutParams.bottomMargin);
    }

    private final void setChannelIconForGDM(Channel channel) {
        SimpleDraweeView simpleDraweeView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelTopicChannelIcon");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForChannel$default(channel, null, 2, null), R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        SimpleDraweeView simpleDraweeView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelTopicChannelIcon");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, DimenUtils.dpToPixels(8), marginLayoutParams.bottomMargin);
    }

    private final void showContextMenu(boolean isGroup, long channelId, CharSequence channelTitle, boolean developerModeEnabled) {
        ImageView imageView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelTopicMoreIcon");
        PopupMenu popupMenu = new PopupMenu(imageView.getContext(), getBinding().e, BadgeDrawable.BOTTOM_START);
        popupMenu.inflate(R.menu.menu_private_channel_sidebar);
        popupMenu.getMenu().findItem(R.id.menu_private_channel_sidebar_pinned_messages).setOnMenuItemClickListener(new AnonymousClass1(channelId));
        MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R.id.menu_private_channel_sidebar_copy_id);
        Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "copyChannelIdAction");
        menuItemFindItem.setVisible(developerModeEnabled);
        menuItemFindItem.setOnMenuItemClickListener(new AnonymousClass2(channelId));
        MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.menu_private_channel_sidebar_customize_gorup);
        Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "customizeGroupAction");
        menuItemFindItem2.setVisible(isGroup);
        menuItemFindItem2.setOnMenuItemClickListener(new AnonymousClass3(channelId));
        MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.menu_private_channel_sidebar_close);
        if (isGroup) {
            menuItemFindItem3.setTitle(R.string.leave_group_dm);
            menuItemFindItem3.setOnMenuItemClickListener(new AnonymousClass4(channelTitle));
        } else {
            menuItemFindItem3.setTitle(R.string.close_dm);
            menuItemFindItem3.setOnMenuItemClickListener(new AnonymousClass5());
        }
        popupMenu.show();
    }

    public static /* synthetic */ void showContextMenu$default(WidgetChannelTopic widgetChannelTopic, boolean z2, long j, CharSequence charSequence, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence = null;
        }
        widgetChannelTopic.showContextMenu(z2, j, charSequence, (i & 8) != 0 ? false : z3);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().g.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetChannelTopic.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<WidgetChannelTopicViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetChannelTopic.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        linkifiedTextView.setMaxLines(2);
    }
}
