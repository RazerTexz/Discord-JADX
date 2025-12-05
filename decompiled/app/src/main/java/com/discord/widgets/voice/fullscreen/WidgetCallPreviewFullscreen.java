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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
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
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.GuildVideoAtCapacityDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.LayoutFullscreenCallPreviewEmptyBinding;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.functions.Func0;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetCallPreviewFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("transition", transition);
            AppScreen2.m156d(context, WidgetCallPreviewFullscreen.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$1 */
    public static final class ViewOnClickListenerC105221 implements View.OnClickListener {
        public ViewOnClickListenerC105221() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$2 */
    public static final class C105232<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetCallPreviewFullscreenViewModel.ViewState $viewState;

        public C105232(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != C5419R.id.menu_invite) {
                return;
            }
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetCallPreviewFullscreen.this, this.$viewState.getVoiceChannel(), WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$3 */
    public static final class C105243<T> implements Action1<Menu> {
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

        public C105243(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            boolean z2 = this.$viewState.isChannelNsfw() && (this.$viewState.isNsfwUnconsented() || this.$viewState.getNsfwAllowed() == NsfwAllowance.DISALLOWED);
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_text_in_voice);
            boolean z3 = this.$viewState.getTextInVoiceEnabled() && this.$viewState.isConnectEnabled() && !z2;
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
            menuItemFindItem.setVisible(z3);
            if (z3) {
                View actionView = menuItemFindItem.getActionView();
                TextView textView = actionView != null ? (TextView) actionView.findViewById(C5419R.id.text_in_voice_count) : null;
                View actionView2 = menuItemFindItem.getActionView();
                ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(C5419R.id.text_in_voice_icon) : null;
                int channelMentionsCount = this.$viewState.getChannelMentionsCount();
                if (channelMentionsCount > 0) {
                    if (textView != null) {
                        ViewKt.setVisible(textView, true);
                    }
                    if (imageView != null) {
                        imageView.setImageResource(C5419R.drawable.ic_text_in_voice_cutout);
                    }
                    if (textView != null) {
                        textView.setBackground(ContextCompat.getDrawable(WidgetCallPreviewFullscreen.this.requireContext(), C5419R.drawable.drawable_circle_red));
                    }
                    if (textView != null) {
                        textView.setText(String.valueOf(Math.min(99, channelMentionsCount)));
                    }
                    if (textView != null) {
                        textView.setTextColor(ContextCompat.getColor(WidgetCallPreviewFullscreen.this.requireContext(), C5419R.color.white));
                    }
                } else {
                    if (textView != null) {
                        ViewKt.setVisible(textView, false);
                    }
                    if (imageView != null) {
                        imageView.setImageResource(C5419R.drawable.ic_text_in_voice);
                    }
                }
                menuItemFindItem.getActionView().setOnClickListener(new AnonymousClass1());
            }
            MenuItem menuItemFindItem2 = menu.findItem(C5419R.id.menu_invite);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "inviteMenuItem");
            menuItemFindItem2.setVisible(!z2);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$1 */
    public static final /* synthetic */ class C105251 extends FunctionReferenceImpl implements Function1<StreamContext, Unit> {
        public C105251(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            Intrinsics3.checkNotNullParameter(streamContext, "p1");
            WidgetCallPreviewFullscreen.access$onStreamPreviewClicked((WidgetCallPreviewFullscreen) this.receiver, streamContext);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$2 */
    public static final class C105262 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105262(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "clickedUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(this.$channel.getId());
            FragmentManager childFragmentManager = WidgetCallPreviewFullscreen.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$3 */
    public static final class C105273 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105273(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetCallPreviewFullscreen.this, this.$channel, WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$4 */
    public static final class C105284 extends Lambda implements Function0<Unit> {
        public C105284() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetCallPreviewFullscreen.this.requireContext();
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(C5419R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(C5419R.string.embedded_activities_desktop_only_modal_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1 */
    public static final class ViewOnClickListenerC105291 implements View.OnClickListener {

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetCallPreviewFullscreenViewModel.tryConnectToVoice$default(WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this), false, 1, null);
            }
        }

        public ViewOnClickListenerC105291() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnimatableValueParser.m473S1(WidgetCallPreviewFullscreen.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2 */
    public static final class ViewOnClickListenerC105302 implements View.OnClickListener {

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).tryConnectToVoice(true);
            }
        }

        public ViewOnClickListenerC105302() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnimatableValueParser.m473S1(WidgetCallPreviewFullscreen.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$3 */
    public static final /* synthetic */ class C105313 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public C105313(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetCallPreviewFullscreen.access$onNsfwToggle((WidgetCallPreviewFullscreen) this.receiver, z2);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$4 */
    public static final /* synthetic */ class C105324 extends FunctionReferenceImpl implements Function0<Unit> {
        public C105324(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(0, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onDenyNsfw", "onDenyNsfw()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallPreviewFullscreen.access$onDenyNsfw((WidgetCallPreviewFullscreen) this.receiver);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onStreamPreviewClicked$1 */
    public static final class C105331 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StreamContext $streamContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105331(StreamContext streamContext) {
            super(0);
            this.$streamContext = streamContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$1 */
    public static final class C105341 implements OnApplyWindowInsetsListener {
        public static final C105341 INSTANCE = new C105341();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
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
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$2 */
    public static final class C105352 implements OnApplyWindowInsetsListener {
        public static final C105352 INSTANCE = new C105352();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
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
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$3 */
    public static final class C105363 implements OnApplyWindowInsetsListener {
        public static final C105363 INSTANCE = new C105363();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
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
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$4 */
    public static final class C105374 implements OnApplyWindowInsetsListener {
        public static final C105374 INSTANCE = new C105374();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$5 */
    public static final class C105385 implements OnApplyWindowInsetsListener {
        public C105385() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "windowView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
            Resources resources = WidgetCallPreviewFullscreen.this.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginLeftDp(resources)) + systemWindowInsetLeft;
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            Resources resources2 = WidgetCallPreviewFullscreen.this.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginDp(resources2)) + systemWindowInsetTop;
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$6 */
    public static final class C105396 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public C105396() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$7 */
    public static final class C105407 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public C105407() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            WidgetCallPreviewFullscreenBinding widgetCallPreviewFullscreenBindingAccess$getBinding$p = WidgetCallPreviewFullscreen.access$getBinding$p(WidgetCallPreviewFullscreen.this);
            Intrinsics3.checkNotNullExpressionValue(widgetCallPreviewFullscreenBindingAccess$getBinding$p, "binding");
            ConstraintLayout constraintLayout = widgetCallPreviewFullscreenBindingAccess$getBinding$p.f15783a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, context, GuildScheduledEventModel2.toModel(guildScheduledEvent), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), null, false, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1 */
    public static final class C105411 extends Lambda implements Function1<WidgetCallPreviewFullscreenViewModel.ViewState, Unit> {
        public C105411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetCallPreviewFullscreen.access$configureUI(WidgetCallPreviewFullscreen.this, viewState);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2 */
    public static final /* synthetic */ class C105422 extends FunctionReferenceImpl implements Function1<WidgetCallPreviewFullscreenViewModel.Event, Unit> {
        public C105422(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetCallPreviewFullscreen.access$handleEvent((WidgetCallPreviewFullscreen) this.receiver, event);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$3 */
    public static final class C105433 extends Lambda implements Function1<Subscription, Unit> {
        public C105433() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetCallPreviewFullscreen.access$setViewModelEventSubscription$p(WidgetCallPreviewFullscreen.this, subscription);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$4 */
    public static final class C105444<R> implements Func0<Boolean> {
        public C105444() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
            return Boolean.TRUE;
        }
    }

    public WidgetCallPreviewFullscreen() {
        super(C5419R.layout.widget_call_preview_fullscreen);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCallPreviewFullscreen2.INSTANCE, null, 2, null);
        WidgetCallPreviewFullscreen3 widgetCallPreviewFullscreen3 = new WidgetCallPreviewFullscreen3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetCallPreviewFullscreenViewModel.class), new WidgetCallPreviewFullscreen$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetCallPreviewFullscreen3));
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
        TextView textView = getBinding().f15787e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getOtherChannelsMentionsCount()));
        TextView textView2 = getBinding().f15787e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.callFullscreenMentions");
        textView2.setVisibility(z2 ? 0 : 8);
        Toolbar toolbar = getBinding().f15784b;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext(), z2 ? C5419R.drawable.ic_call_toolbar_stage_minimize_cutout : C5419R.drawable.ic_call_toolbar_stage_minimize));
        getBinding().f15784b.setNavigationOnClickListener(new ViewOnClickListenerC105221());
        setActionBarOptionsMenu(C5419R.menu.menu_call_preview_fullscreen, new C105232(viewState), new C105243(viewState));
        int color = ColorCompat.getColor(this, C5419R.color.transparent);
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
            LayoutFullscreenCallPreviewEmptyBinding layoutFullscreenCallPreviewEmptyBinding = getBinding().f15794l;
            Intrinsics3.checkNotNullExpressionValue(layoutFullscreenCallPreviewEmptyBinding, "binding.empty");
            ConstraintLayout constraintLayout = layoutFullscreenCallPreviewEmptyBinding.f1142a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.empty.root");
            constraintLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().f15793k;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
            WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty empty = (WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty) participantsList;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        LayoutFullscreenCallPreviewEmptyBinding layoutFullscreenCallPreviewEmptyBinding2 = getBinding().f15794l;
        Intrinsics3.checkNotNullExpressionValue(layoutFullscreenCallPreviewEmptyBinding2, "binding.empty");
        ConstraintLayout constraintLayout2 = layoutFullscreenCallPreviewEmptyBinding2.f1142a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.empty.root");
        constraintLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().f15793k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callPreviewVoiceSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems) participantsList).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new C105251(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new C105262(channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnInviteFriendsClicked(new C105273(channel));
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnEmbeddedActivityClicked(new C105284());
    }

    private final void configureUI(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        configureActionBar(viewState);
        configureParticipants(viewState.getParticipantsList(), viewState.getVoiceChannel());
        if (viewState.isConnectEnabled()) {
            getBinding().f15791i.setText(C5419R.string.join_voice);
            getBinding().f15790h.setText(C5419R.string.join_muted);
            MaterialButton materialButton = getBinding().f15791i;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.callPreviewJoinVoice");
            materialButton.setEnabled(true);
            MaterialButton materialButton2 = getBinding().f15790h;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.callPreviewJoinMuted");
            materialButton2.setEnabled(true);
        } else {
            getBinding().f15791i.setText(C5419R.string.channel_locked_short);
            MaterialButton materialButton3 = getBinding().f15791i;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.callPreviewJoinVoice");
            materialButton3.setEnabled(false);
            getBinding().f15790h.setText(C5419R.string.channel_locked_short);
            MaterialButton materialButton4 = getBinding().f15790h;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.callPreviewJoinMuted");
            materialButton4.setEnabled(false);
        }
        getBinding().f15791i.setOnClickListener(new ViewOnClickListenerC105291());
        getBinding().f15790h.setOnClickListener(new ViewOnClickListenerC105302());
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getVoiceChannel().getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().f15792j, new C105313(this), new C105324(this));
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
            requireAppActivity().overridePendingTransition(0, C5419R.anim.anim_slide_out_down);
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
        if (Intrinsics3.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            GuildVideoAtCapacityDialog.Companion companion = GuildVideoAtCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.m140a(parentFragmentManager);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowOverlayNux.INSTANCE)) {
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
        ConstraintLayout constraintLayout = getBinding().f15786d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenBody");
        constraintLayout.setVisibility(isHidden ^ true ? 0 : 8);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        AnimatableValueParser.m473S1(this, null, new C105331(streamContext), 1, null);
    }

    private final void transitionActivity() {
        finishActivity$default(this, false, false, 3, null);
        requireAppActivity().overridePendingTransition(C5419R.anim.activity_slide_horizontal_open_in, C5419R.anim.activity_slide_horizontal_open_out);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15789g, C105341.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15794l.f1143b, C105352.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15793k, C105363.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15785c, C105374.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15787e, new C105385());
        ConstraintLayout constraintLayout = getBinding().f15788f;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenParent");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f15793k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, true, true));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new C105396());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new C105407());
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C105411(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, new C105433(), (Function1) null, (Function0) null, (Function0) null, new C105422(this), 58, (Object) null);
        AppFragment.setOnBackPressed$default(this, new C105444(), 0, 2, null);
    }
}
