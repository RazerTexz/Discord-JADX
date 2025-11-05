package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.m;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.i.q0;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetCallPreviewFullscreenBinding;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/* compiled from: WidgetCallPreviewFullscreen.kt */
/* loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen extends AppFragment {
    private static final String ANALYTICS_SOURCE = "Fullscreen Voice Channel Preview";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetHomePanelNsfw panelNsfw;
    private CallParticipantsAdapter participantsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private Subscription viewModelEventSubscription;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCallPreviewFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, AppTransitionActivity.Transition transition, int i, Object obj) {
            if ((i & 4) != 0) {
                transition = null;
            }
            companion.launch(context, j, transition);
        }

        public final void launch(Context context, long channelId, AppTransitionActivity.Transition transition) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("transition", transition);
            j.d(context, WidgetCallPreviewFullscreen.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetCallPreviewFullscreenViewModel.ViewState $viewState;

        public AnonymousClass2(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_invite) {
                return;
            }
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetCallPreviewFullscreen.this, this.$viewState.getVoiceChannel(), WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Menu> {
        public final /* synthetic */ WidgetCallPreviewFullscreenViewModel.ViewState $viewState;

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$3$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallPreviewFullscreen.access$transitionActivity(WidgetCallPreviewFullscreen.this);
                WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).onTextInVoiceTapped();
            }
        }

        public AnonymousClass3(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            boolean z2 = this.$viewState.isChannelNsfw() && (this.$viewState.isNsfwUnconsented() || this.$viewState.getNsfwAllowed() == NsfwAllowance.DISALLOWED);
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_text_in_voice);
            boolean z3 = this.$viewState.getTextInVoiceEnabled() && this.$viewState.isConnectEnabled() && !z2;
            m.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
            menuItemFindItem.setVisible(z3);
            if (z3) {
                View actionView = menuItemFindItem.getActionView();
                TextView textView = actionView != null ? (TextView) actionView.findViewById(R.id.text_in_voice_count) : null;
                View actionView2 = menuItemFindItem.getActionView();
                ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(R.id.text_in_voice_icon) : null;
                int channelMentionsCount = this.$viewState.getChannelMentionsCount();
                if (channelMentionsCount > 0) {
                    if (textView != null) {
                        ViewKt.setVisible(textView, true);
                    }
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.ic_text_in_voice_cutout);
                    }
                    if (textView != null) {
                        textView.setBackground(ContextCompat.getDrawable(WidgetCallPreviewFullscreen.this.requireContext(), R.drawable.drawable_circle_red));
                    }
                    if (textView != null) {
                        textView.setText(String.valueOf(Math.min(99, channelMentionsCount)));
                    }
                    if (textView != null) {
                        textView.setTextColor(ContextCompat.getColor(WidgetCallPreviewFullscreen.this.requireContext(), R.color.white));
                    }
                } else {
                    if (textView != null) {
                        ViewKt.setVisible(textView, false);
                    }
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.ic_text_in_voice);
                    }
                }
                menuItemFindItem.getActionView().setOnClickListener(new AnonymousClass1());
            }
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_invite);
            m.checkNotNullExpressionValue(menuItemFindItem2, "inviteMenuItem");
            menuItemFindItem2.setVisible(!z2);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StreamContext, Unit> {
        public AnonymousClass1(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            m.checkNotNullParameter(streamContext, "p1");
            WidgetCallPreviewFullscreen.access$onStreamPreviewClicked((WidgetCallPreviewFullscreen) this.receiver, streamContext);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            m.checkNotNullParameter(voiceUser, "clickedUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(this.$channel.getId());
            FragmentManager childFragmentManager = WidgetCallPreviewFullscreen.this.getChildFragmentManager();
            m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetCallPreviewFullscreen.this, this.$channel, WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetCallPreviewFullscreen.this.requireContext();
            m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            m.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_description);
            m.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04841 extends o implements Function0<Unit> {
            public C04841() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetCallPreviewFullscreenViewModel.tryConnectToVoice$default(WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this), false, 1, null);
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.S1(WidgetCallPreviewFullscreen.this, null, new C04841(), 1, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2$1, reason: invalid class name */
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
                WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).tryConnectToVoice(true);
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.S1(WidgetCallPreviewFullscreen.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<Boolean, Unit> {
        public AnonymousClass3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetCallPreviewFullscreen.access$onNsfwToggle((WidgetCallPreviewFullscreen) this.receiver, z2);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function0<Unit> {
        public AnonymousClass4(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(0, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onDenyNsfw", "onDenyNsfw()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallPreviewFullscreen.access$onDenyNsfw((WidgetCallPreviewFullscreen) this.receiver);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onStreamPreviewClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ StreamContext $streamContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StreamContext streamContext) {
            super(0);
            this.$streamContext = streamContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            m.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = insets.bottom;
            layoutParams2.setMarginStart(insets.left);
            layoutParams2.setMarginEnd(insets.right);
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            m.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(insets.left);
            layoutParams2.setMarginEnd(insets.right);
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            m.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(insets.left);
            layoutParams2.setMarginEnd(insets.right);
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            m.checkNotNullExpressionValue(view, "view");
            m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements OnApplyWindowInsetsListener {
        public AnonymousClass5() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            m.checkNotNullExpressionValue(view, "windowView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
            Resources resources = WidgetCallPreviewFullscreen.this.getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginLeftDp(resources)) + systemWindowInsetLeft;
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            Resources resources2 = WidgetCallPreviewFullscreen.this.getResources();
            m.checkNotNullExpressionValue(resources2, "resources");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginDp(resources2)) + systemWindowInsetTop;
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 extends o implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            m.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 extends o implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            m.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            WidgetCallPreviewFullscreenBinding widgetCallPreviewFullscreenBindingAccess$getBinding$p = WidgetCallPreviewFullscreen.access$getBinding$p(WidgetCallPreviewFullscreen.this);
            m.checkNotNullExpressionValue(widgetCallPreviewFullscreenBindingAccess$getBinding$p, "binding");
            ConstraintLayout constraintLayout = widgetCallPreviewFullscreenBindingAccess$getBinding$p.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            m.checkNotNullExpressionValue(context, "binding.root.context");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, context, GuildScheduledEventModelKt.toModel(guildScheduledEvent), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), null, false, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetCallPreviewFullscreenViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "it");
            WidgetCallPreviewFullscreen.access$configureUI(WidgetCallPreviewFullscreen.this, viewState);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<WidgetCallPreviewFullscreenViewModel.Event, Unit> {
        public AnonymousClass2(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetCallPreviewFullscreen.access$handleEvent((WidgetCallPreviewFullscreen) this.receiver, event);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetCallPreviewFullscreen.access$setViewModelEventSubscription$p(WidgetCallPreviewFullscreen.this, subscription);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4<R> implements Func0<Boolean> {
        public AnonymousClass4() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
            return Boolean.TRUE;
        }
    }

    public WidgetCallPreviewFullscreen() {
        super(R.layout.widget_call_preview_fullscreen);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCallPreviewFullscreen$binding$2.INSTANCE, null, 2, null);
        WidgetCallPreviewFullscreen$viewModel$2 widgetCallPreviewFullscreen$viewModel$2 = new WidgetCallPreviewFullscreen$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetCallPreviewFullscreenViewModel.class), new WidgetCallPreviewFullscreen$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetCallPreviewFullscreen$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        widgetCallPreviewFullscreen.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetCallPreviewFullscreenBinding access$getBinding$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getBinding();
    }

    public static final /* synthetic */ WidgetCallPreviewFullscreenViewModel access$getViewModel$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getViewModel();
    }

    public static final /* synthetic */ Subscription access$getViewModelEventSubscription$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.viewModelEventSubscription;
    }

    public static final /* synthetic */ long access$getVoiceChannelId(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getVoiceChannelId();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel.Event event) {
        widgetCallPreviewFullscreen.handleEvent(event);
    }

    public static final /* synthetic */ void access$onDenyNsfw(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        widgetCallPreviewFullscreen.onDenyNsfw();
    }

    public static final /* synthetic */ void access$onNsfwToggle(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, boolean z2) {
        widgetCallPreviewFullscreen.onNsfwToggle(z2);
    }

    public static final /* synthetic */ void access$onStreamPreviewClicked(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, StreamContext streamContext) {
        widgetCallPreviewFullscreen.onStreamPreviewClicked(streamContext);
    }

    public static final /* synthetic */ void access$setViewModelEventSubscription$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, Subscription subscription) {
        widgetCallPreviewFullscreen.viewModelEventSubscription = subscription;
    }

    public static final /* synthetic */ void access$transitionActivity(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        widgetCallPreviewFullscreen.transitionActivity();
    }

    private final void configureActionBar(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        boolean z2 = viewState.getOtherChannelsMentionsCount() > 0;
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getOtherChannelsMentionsCount()));
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.callFullscreenMentions");
        textView2.setVisibility(z2 ? 0 : 8);
        Toolbar toolbar = getBinding().f2249b;
        m.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext(), z2 ? R.drawable.ic_call_toolbar_stage_minimize_cutout : R.drawable.ic_call_toolbar_stage_minimize));
        getBinding().f2249b.setNavigationOnClickListener(new AnonymousClass1());
        setActionBarOptionsMenu(R.menu.menu_call_preview_fullscreen, new AnonymousClass2(viewState), new AnonymousClass3(viewState));
        int color = ColorCompat.getColor(this, R.color.transparent);
        String titleText = viewState.getTitleText();
        if (titleText == null) {
            titleText = "";
        }
        setActionBarTitle(titleText);
        setActionBarTitleColor(-1);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
    }

    private final void configureParticipants(WidgetCallPreviewFullscreenViewModel.ParticipantsList participantsList, Channel channel) {
        if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems)) {
            if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            q0 q0Var = getBinding().l;
            m.checkNotNullExpressionValue(q0Var, "binding.empty");
            ConstraintLayout constraintLayout = q0Var.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.empty.root");
            constraintLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().k;
            m.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
            WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty empty = (WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty) participantsList;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                m.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        q0 q0Var2 = getBinding().l;
        m.checkNotNullExpressionValue(q0Var2, "binding.empty");
        ConstraintLayout constraintLayout2 = q0Var2.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.empty.root");
        constraintLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView2, "binding.callPreviewVoiceSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems) participantsList).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new AnonymousClass1(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new AnonymousClass2(channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnInviteFriendsClicked(new AnonymousClass3(channel));
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnEmbeddedActivityClicked(new AnonymousClass4());
    }

    private final void configureUI(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        configureActionBar(viewState);
        configureParticipants(viewState.getParticipantsList(), viewState.getVoiceChannel());
        if (viewState.isConnectEnabled()) {
            getBinding().i.setText(R.string.join_voice);
            getBinding().h.setText(R.string.join_muted);
            MaterialButton materialButton = getBinding().i;
            m.checkNotNullExpressionValue(materialButton, "binding.callPreviewJoinVoice");
            materialButton.setEnabled(true);
            MaterialButton materialButton2 = getBinding().h;
            m.checkNotNullExpressionValue(materialButton2, "binding.callPreviewJoinMuted");
            materialButton2.setEnabled(true);
        } else {
            getBinding().i.setText(R.string.channel_locked_short);
            MaterialButton materialButton3 = getBinding().i;
            m.checkNotNullExpressionValue(materialButton3, "binding.callPreviewJoinVoice");
            materialButton3.setEnabled(false);
            getBinding().h.setText(R.string.channel_locked_short);
            MaterialButton materialButton4 = getBinding().h;
            m.checkNotNullExpressionValue(materialButton4, "binding.callPreviewJoinMuted");
            materialButton4.setEnabled(false);
        }
        getBinding().i.setOnClickListener(new AnonymousClass1());
        getBinding().h.setOnClickListener(new AnonymousClass2());
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getVoiceChannel().getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().j, new AnonymousClass3(this), new AnonymousClass4(this));
        }
    }

    private final void finishActivity(boolean selectTextChannel, boolean transition) {
        if (selectTextChannel) {
            getViewModel().selectTextChannelAfterFinish();
        }
        Subscription subscription = this.viewModelEventSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        requireAppActivity().finish();
        if (transition) {
            requireAppActivity().overridePendingTransition(0, R.anim.anim_slide_out_down);
        }
    }

    public static /* synthetic */ void finishActivity$default(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        widgetCallPreviewFullscreen.finishActivity(z2, z3);
    }

    private final WidgetCallPreviewFullscreenBinding getBinding() {
        return (WidgetCallPreviewFullscreenBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetCallPreviewFullscreenViewModel getViewModel() {
        return (WidgetCallPreviewFullscreenViewModel) this.viewModel.getValue();
    }

    private final long getVoiceChannelId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final void handleEvent(WidgetCallPreviewFullscreenViewModel.Event event) {
        if (m.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            m.Companion companion = b.a.a.m.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.a(parentFragmentManager);
            return;
        }
        if (d0.z.d.m.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.INSTANCE.enqueue();
        } else {
            if (!(event instanceof WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall)) {
                throw new NoWhenBranchMatchedException();
            }
            finishActivity$default(this, false, false, 1, null);
            WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall launchVideoCall = (WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall) event;
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), launchVideoCall.getChannelId(), false, launchVideoCall.getAutoTargetStreamKey(), null, 20, null);
        }
    }

    public static final void launch(Context context, long j, AppTransitionActivity.Transition transition) {
        INSTANCE.launch(context, j, transition);
    }

    private final void onDenyNsfw() {
        finishActivity$default(this, true, false, 2, null);
    }

    private final void onNsfwToggle(boolean isHidden) {
        ConstraintLayout constraintLayout = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenBody");
        constraintLayout.setVisibility(isHidden ^ true ? 0 : 8);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        d.S1(this, null, new AnonymousClass1(streamContext), 1, null);
    }

    private final void transitionActivity() {
        finishActivity$default(this, false, false, 3, null);
        requireAppActivity().overridePendingTransition(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().g, AnonymousClass1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().l.f183b, AnonymousClass2.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().k, AnonymousClass3.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, AnonymousClass4.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().e, new AnonymousClass5());
        ConstraintLayout constraintLayout = getBinding().f;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenParent");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().k;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, true, true));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new AnonymousClass6());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new AnonymousClass7());
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, new AnonymousClass3(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 58, (Object) null);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass4(), 0, 2, null);
    }
}
