package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserSheetBinding;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUserNotes;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.application.ApplicationUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.roles.RolesListView;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.WidgetBanUser;
import com.discord.widgets.user.WidgetKickUser;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.user.presence.ViewHolderStreamRichPresence;
import com.discord.widgets.user.presence.ViewHolderUserRichPresence;
import com.discord.widgets.user.profile.UserProfileAdminView;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import p000.C12807l;
import p007b.p008a.p009a.FriendRequestDialogs;
import p007b.p008a.p009a.p013d.UserActionsDialog;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetUserSheet.kt */
/* loaded from: classes.dex */
public final class WidgetUserSheet extends AppBottomSheet {
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_FRIEND_TOKEN = "ARG_FRIEND_TOKEN";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final String ARG_IS_VOICE_CONTEXT = "ARG_IS_VOICE_CONTEXT";
    private static final String ARG_STREAM_PREVIEW_CLICK_BEHAVIOR = "ARG_STREAM_PREVIEW_CLICK_BEHAVIOR";
    private static final String ARG_USER_ID = "ARG_USER_ID";
    private static final String REQUEST_KEY_MOVE_USER = "REQUEST_KEY_MOVE_USER";
    private ViewHolderUserRichPresence activityViewHolder;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private PrivateCallLauncher privateCallLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: viewModelUserProfileHeader$delegate, reason: from kotlin metadata */
    private final Lazy viewModelUserProfileHeader;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetUserSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void enqueueNotice$default(Companion companion, long j, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.enqueueNotice(j, str);
        }

        private final String getNoticeName(long userId) {
            String str = "User Sheet Notice for user ID: " + userId;
            Intrinsics3.checkNotNullExpressionValue(str, "StringBuilder(\"User Shee…)\n            .toString()");
            return str;
        }

        public static /* synthetic */ void show$default(Companion companion, long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior, String str, int i, Object obj) {
            companion.show(j, (i & 2) != 0 ? null : l, fragmentManager, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? StreamPreviewClickBehavior.TARGET_AND_LAUNCH_SPECTATE : streamPreviewClickBehavior, (i & 64) != 0 ? null : str);
        }

        public final void enqueueNotice(long userId, String friendToken) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String noticeName = getNoticeName(userId);
            notices.requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new WidgetUserSheet$Companion$enqueueNotice$showUserSheetNotice$1(userId, friendToken, notices, noticeName), Opcodes.INVOKEVIRTUAL, null));
        }

        public final void show(long j, FragmentManager fragmentManager) {
            show$default(this, j, null, fragmentManager, null, null, null, null, 122, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager) {
            show$default(this, j, l, fragmentManager, null, null, null, null, 120, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager, Long l2) {
            show$default(this, j, l, fragmentManager, l2, null, null, null, 112, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool) {
            show$default(this, j, l, fragmentManager, l2, bool, null, null, 96, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior) {
            show$default(this, j, l, fragmentManager, l2, bool, streamPreviewClickBehavior, null, 64, null);
        }

        public final void show(long userId, Long channelId, FragmentManager fragmentManager, Long guildId, Boolean isVoiceContext, StreamPreviewClickBehavior streamPreviewClickBehavior, String friendToken) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(streamPreviewClickBehavior, "streamPreviewClickBehavior");
            WidgetUserSheet widgetUserSheet = new WidgetUserSheet();
            Bundle bundleM832T = outline.m832T(WidgetUserSheet.ARG_USER_ID, userId);
            if (channelId != null) {
                bundleM832T.putLong(WidgetUserSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            if (friendToken != null) {
                bundleM832T.putString(WidgetUserSheet.ARG_FRIEND_TOKEN, friendToken);
            }
            if (guildId != null) {
                bundleM832T.putLong(WidgetUserSheet.ARG_GUILD_ID, guildId.longValue());
            }
            bundleM832T.putBoolean(WidgetUserSheet.ARG_IS_VOICE_CONTEXT, isVoiceContext != null ? isVoiceContext.booleanValue() : false);
            bundleM832T.putSerializable(WidgetUserSheet.ARG_STREAM_PREVIEW_CLICK_BEHAVIOR, streamPreviewClickBehavior);
            widgetUserSheet.setArguments(bundleM832T);
            widgetUserSheet.show(fragmentManager, WidgetUserSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    public enum StreamPreviewClickBehavior {
        TARGET_AND_LAUNCH_SPECTATE,
        TARGET_AND_DISMISS
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$bindSubscriptions$1 */
    public static final /* synthetic */ class C103411 extends FunctionReferenceImpl implements Function1<WidgetUserSheetViewModel.ViewState, Unit> {
        public C103411(WidgetUserSheet widgetUserSheet) {
            super(1, widgetUserSheet, WidgetUserSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetUserSheet.access$configureUI((WidgetUserSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$bindSubscriptions$2 */
    public static final /* synthetic */ class C103422 extends FunctionReferenceImpl implements Function1<WidgetUserSheetViewModel.Event, Unit> {
        public C103422(WidgetUserSheet widgetUserSheet) {
            super(1, widgetUserSheet, WidgetUserSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetUserSheet.access$handleEvent((WidgetUserSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureAboutMe$1 */
    public static final class ViewOnClickListenerC103431 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC103431(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getHasGuildMemberBio()) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                AppToast.m170h(view.getContext(), FormatUtils.m219k(WidgetUserSheet.this, C5419R.string.guild_identity_bio_toast, new Object[]{this.$viewState.getGuildName()}, null, 4), 0, null, 12);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureIncomingFriendRequest$1 */
    public static final class ViewOnClickListenerC103481 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC103481(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$acceptFriendRequest(WidgetUserSheet.this, this.$viewState.getUser().getUsername());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureIncomingFriendRequest$2 */
    public static final class ViewOnClickListenerC103492 implements View.OnClickListener {
        public ViewOnClickListenerC103492() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$ignoreFriendRequest(WidgetUserSheet.this);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$1 */
    public static final class ViewOnClickListenerC103501 implements View.OnClickListener {
        public final /* synthetic */ UserProfile $userProfile;

        public ViewOnClickListenerC103501(UserProfile userProfile) {
            this.$userProfile = userProfile;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ApplicationUtils applicationUtils = ApplicationUtils.INSTANCE;
            UserProfile userProfile = this.$userProfile;
            Uri applicationUri = applicationUtils.getApplicationUri(userProfile != null ? userProfile.getApplication() : null);
            if (applicationUri != null) {
                Context contextM885x = outline.m885x(view, "view", "view.context");
                String string = applicationUri.toString();
                Intrinsics3.checkNotNullExpressionValue(string, "uri.toString()");
                UriHandler.handleOrUntrusted$default(contextM885x, string, null, 4, null);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$2 */
    public static final class ViewOnClickListenerC103512 implements View.OnClickListener {
        public ViewOnClickListenerC103512() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditUserOrGuildMemberProfile.Companion companion = WidgetEditUserOrGuildMemberProfile.INSTANCE;
            Context contextRequireContext = WidgetUserSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
            WidgetEditUserOrGuildMemberProfile.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$3 */
    public static final class ViewOnClickListenerC103523 implements View.OnClickListener {
        public final /* synthetic */ Long $guildId;

        public ViewOnClickListenerC103523(Long l) {
            this.$guildId = l;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$guildId != null) {
                Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
                if (userExperiment != null && userExperiment.getBucket() == 1) {
                    WidgetEditUserOrGuildMemberProfile.Companion.launch$default(WidgetEditUserOrGuildMemberProfile.INSTANCE, outline.m885x(view, "it", "it.context"), null, this.$guildId, 2, null);
                    return;
                }
                WidgetChangeGuildIdentity.Companion companion = WidgetChangeGuildIdentity.INSTANCE;
                long jLongValue = this.$guildId.longValue();
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion.launch(jLongValue, "User Bottom Sheet", context);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$4 */
    public static final class ViewOnClickListenerC103534 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC103534(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector companion = ChannelSelector.INSTANCE.getInstance();
            Context contextRequireContext = WidgetUserSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
            companion.findAndSetDirectMessage(contextRequireContext, this.$viewState.getUser().getId());
            WidgetUserSheet.this.dismiss();
            StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
            AppActivity appActivityRequireAppActivity = WidgetUserSheet.this.requireAppActivity();
            Context contextRequireContext2 = WidgetUserSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            appActivityRequireAppActivity.m8349j(contextRequireContext2);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$5 */
    public static final class ViewOnClickListenerC103545 implements View.OnClickListener {
        public ViewOnClickListenerC103545() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).launchVoiceCall();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$6 */
    public static final class ViewOnClickListenerC103556 implements View.OnClickListener {
        public ViewOnClickListenerC103556() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).launchVideoCall();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$7 */
    public static final class ViewOnClickListenerC103567 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC103567(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$addFriend(WidgetUserSheet.this, this.$viewState.getUser().getUsername());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8 */
    public static final class ViewOnClickListenerC103578 implements View.OnClickListener {
        public final /* synthetic */ int $userRelationshipType;
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$1, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
            public AnonymousClass1(WidgetUserSheetViewModel widgetUserSheetViewModel) {
                super(1, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "removeRelationship", "removeRelationship(I)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f27425a;
            }

            public final void invoke(int i) {
                ((WidgetUserSheetViewModel) this.receiver).removeRelationship(i);
            }
        }

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ViewOnClickListenerC103578 viewOnClickListenerC103578 = ViewOnClickListenerC103578.this;
                WidgetUserSheet.access$acceptFriendRequest(WidgetUserSheet.this, viewOnClickListenerC103578.$viewState.getUser().getUsername());
            }
        }

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetUserSheet.access$ignoreFriendRequest(WidgetUserSheet.this);
            }
        }

        public ViewOnClickListenerC103578(int i, WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$userRelationshipType = i;
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.$userRelationshipType;
            Integer numValueOf = Integer.valueOf(C5419R.id.notice_ok);
            if (i == 3) {
                FragmentManager parentFragmentManager = WidgetUserSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                Context contextRequireContext = WidgetUserSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                AnonymousClass3 anonymousClass3 = new AnonymousClass3();
                Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
                Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
                Intrinsics3.checkNotNullParameter(anonymousClass2, "onAccept");
                Intrinsics3.checkNotNullParameter(anonymousClass3, "onIgnore");
                WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, parentFragmentManager, FormatUtils.m216h(contextRequireContext, C5419R.string.incoming_friend_request, new Object[0], null, 4), FormatUtils.m216h(contextRequireContext, C5419R.string.user_profile_incoming_friend_request_dialog_body, new Object[0], null, 4), FormatUtils.m216h(contextRequireContext, C5419R.string.friend_request_accept, new Object[0], null, 4), FormatUtils.m216h(contextRequireContext, C5419R.string.friend_request_ignore, new Object[0], null, 4), Maps6.mapOf(Tuples.m10073to(numValueOf, new C12807l(0, anonymousClass2)), Tuples.m10073to(Integer.valueOf(C5419R.id.notice_cancel), new C12807l(1, anonymousClass3))), null, null, null, null, null, null, 0, null, 16320, null);
                return;
            }
            if (i != 4) {
                return;
            }
            User user = this.$viewState.getUser();
            Context contextRequireContext2 = WidgetUserSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            FragmentManager parentFragmentManager2 = WidgetUserSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this));
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(contextRequireContext2, "context");
            Intrinsics3.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            Intrinsics3.checkNotNullParameter(anonymousClass1, "onConfirm");
            WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, parentFragmentManager2, FormatUtils.m216h(contextRequireContext2, C5419R.string.outgoing_friend_request, new Object[0], null, 4), FormatUtils.m216h(contextRequireContext2, C5419R.string.outgoing_friend_request_delete_msg, new Object[]{user.getUsername()}, null, 4), FormatUtils.m216h(contextRequireContext2, C5419R.string.delete, new Object[0], null, 4), FormatUtils.m216h(contextRequireContext2, C5419R.string.cancel, new Object[0], null, 4), MapsJVM.mapOf(Tuples.m10073to(numValueOf, new FriendRequestDialogs(anonymousClass1))), null, null, null, Integer.valueOf(C5419R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$1 */
    public static final class C103581 extends Lambda implements Function0<Unit> {
        public C103581() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModelUserProfileHeader$p(WidgetUserSheet.this).toggleAllowAnimationInReducedMotion();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$3 */
    public static final class C103593 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103593(WidgetUserSheetViewModel.ViewState viewState) {
            super(0);
            this.$model = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$onStreamPreviewClicked(WidgetUserSheet.this, ((WidgetUserSheetViewModel.ViewState.Loaded) this.$model).getStreamContext());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$4 */
    public static final /* synthetic */ class C103604 extends FunctionReferenceImpl implements Function5<Context, Long, String, Long, Integer, Unit> {
        public C103604(WidgetUserSheetViewModel widgetUserSheetViewModel) {
            super(5, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "onActivityCustomButtonClicked", "onActivityCustomButtonClicked(Landroid/content/Context;JLjava/lang/String;JI)V", 0);
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Context context, Long l, String str, Long l2, Integer num) {
            invoke(context, l.longValue(), str, l2.longValue(), num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(Context context, long j, String str, long j2, int i) {
            Intrinsics3.checkNotNullParameter(context, "p1");
            Intrinsics3.checkNotNullParameter(str, "p3");
            ((WidgetUserSheetViewModel) this.receiver).onActivityCustomButtonClicked(context, j, str, j2, i);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$handleRequestPermissionsForSpectateStream$1 */
    public static final class C103611 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103611(WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream requestPermissionsForSpectateStream) {
            super(0);
            this.$event = requestPermissionsForSpectateStream;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).onSpectatePermissionsGranted(this.$event.getStream());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$1 */
    public static final class ViewOnClickListenerC103621 implements View.OnClickListener {
        public final /* synthetic */ long $userId;

        public ViewOnClickListenerC103621(long j) {
            this.$userId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserActionsDialog.Companion bVar = UserActionsDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetUserSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            long j = this.$userId;
            long j2 = WidgetUserSheet.access$getArgumentsOrDefault$p(WidgetUserSheet.this).getLong(WidgetUserSheet.ARG_CHANNEL_ID);
            Objects.requireNonNull(bVar);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            UserActionsDialog userActionsDialog = new UserActionsDialog();
            Bundle bundleM832T = outline.m832T("com.discord.intent.extra.EXTRA_USER_ID", j);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", j2);
            userActionsDialog.setArguments(bundleM832T);
            userActionsDialog.show(parentFragmentManager, UserActionsDialog.class.getName());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$10 */
    public static final class C1036310 extends Lambda implements Function0<Unit> {
        public C1036310() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).disableCommunication();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$11 */
    public static final class C1036411 extends Lambda implements Function0<Unit> {
        public C1036411() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).guildMuteUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$12 */
    public static final class C1036512 extends Lambda implements Function0<Unit> {
        public C1036512() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).guildDeafenUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$13 */
    public static final class C1036613 extends Lambda implements Function0<Unit> {
        public C1036613() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).guildMoveForUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$14 */
    public static final class C1036714 extends Lambda implements Function0<Unit> {
        public C1036714() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheetViewModel.disconnectUser$default(WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this), null, 1, null);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$15 */
    public static final class ViewOnFocusChangeListenerC1036815 implements View.OnFocusChangeListener {
        public ViewOnFocusChangeListenerC1036815() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z2) {
            if (z2) {
                return;
            }
            WidgetUserSheetViewModel widgetUserSheetViewModelAccess$getViewModel$p = WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this);
            Context context = WidgetUserSheet.this.getContext();
            TextInputLayout textInputLayout = WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            widgetUserSheetViewModelAccess$getViewModel$p.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$16 */
    public static final class C1036916 extends Lambda implements Function1<TextView, Unit> {
        public final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1036916(View view) {
            super(1);
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetUserSheetViewModel widgetUserSheetViewModelAccess$getViewModel$p = WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this);
            Context context = WidgetUserSheet.this.getContext();
            TextInputLayout textInputLayout = WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            widgetUserSheetViewModelAccess$getViewModel$p.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
            WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).f18388B.clearFocus();
            WidgetUserSheet.this.hideKeyboard(this.$view);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$17 */
    public static final class C1037017 extends AccessibilityDelegateCompat {
        public C1037017() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics3.checkNotNullParameter(host, "host");
            Intrinsics3.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setTraversalAfter(WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).f18419o);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$18 */
    public static final class C1037118 extends Lambda implements Function2<Long, String, Unit> {
        public C1037118() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).moveUserToChannel(j);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2 */
    public static final class C103722 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isMe;

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2$1, reason: invalid class name */
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
                AppToast.m169g(WidgetUserSheet.this.getContext(), C5419R.string.stage_channel_permission_microphone_denied, 0, null, 12);
            }
        }

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).setUserSuppressedInChannel(false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103722(boolean z2) {
            super(0);
            this.$isMe = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$isMe) {
                WidgetUserSheet.this.requestMicrophone(new AnonymousClass1(), new AnonymousClass2());
            } else {
                WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).inviteUserToSpeak();
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$3 */
    public static final class C103733 extends Lambda implements Function0<Unit> {
        public C103733() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).setUserSuppressedInChannel(true);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$4 */
    public static final class C103744 extends Lambda implements Function1<Boolean, Unit> {
        public C103744() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).toggleMute(z2);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$5 */
    public static final class C103755 extends Lambda implements Function1<Boolean, Unit> {
        public C103755() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).toggleDeafen(z2);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$6 */
    public static final class C103766 extends Lambda implements Function2<Float, Boolean, Unit> {
        public C103766() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Float f, Boolean bool) {
            invoke(f.floatValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(float f, boolean z2) {
            if (z2) {
                WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).setUserOutputVolume(f);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$7 */
    public static final class C103777 extends Lambda implements Function0<Unit> {
        public C103777() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).editMember();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$8 */
    public static final class C103788 extends Lambda implements Function0<Unit> {
        public C103788() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).kickUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$9 */
    public static final class C103799 extends Lambda implements Function0<Unit> {
        public C103799() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).banUser();
        }
    }

    public WidgetUserSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserSheet$binding$2.INSTANCE, null, 2, null);
        WidgetUserSheet$viewModelUserProfileHeader$2 widgetUserSheet$viewModelUserProfileHeader$2 = new WidgetUserSheet$viewModelUserProfileHeader$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserSheet$viewModelUserProfileHeader$2));
        WidgetUserSheet$viewModel$2 widgetUserSheet$viewModel$2 = new WidgetUserSheet$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates32 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserSheetViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$2(appViewModelDelegates32), new AppViewModelDelegates5(widgetUserSheet$viewModel$2));
    }

    private final void acceptFriendRequest(String username) {
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, C5419R.string.accept_request_button_after, null, 8, null);
    }

    public static final /* synthetic */ void access$acceptFriendRequest(WidgetUserSheet widgetUserSheet, String str) {
        widgetUserSheet.acceptFriendRequest(str);
    }

    public static final /* synthetic */ void access$addFriend(WidgetUserSheet widgetUserSheet, String str) {
        widgetUserSheet.addFriend(str);
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel.ViewState viewState) {
        widgetUserSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetUserSheetBinding access$getBinding$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getBinding();
    }

    public static final /* synthetic */ WidgetUserSheetViewModel access$getViewModel$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getViewModel();
    }

    public static final /* synthetic */ UserProfileHeaderViewModel access$getViewModelUserProfileHeader$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getViewModelUserProfileHeader();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel.Event event) {
        widgetUserSheet.handleEvent(event);
    }

    public static final /* synthetic */ void access$ignoreFriendRequest(WidgetUserSheet widgetUserSheet) {
        widgetUserSheet.ignoreFriendRequest();
    }

    public static final /* synthetic */ void access$onStreamPreviewClicked(WidgetUserSheet widgetUserSheet, StreamContext streamContext) {
        widgetUserSheet.onStreamPreviewClicked(streamContext);
    }

    private final void addFriend(String username) {
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, C5419R.string.friend_request_sent, null, 8, null);
    }

    private final void configureAboutMe(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        String strComputeShortName;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        getBinding().f18410f.setOnClickListener(new ViewOnClickListenerC103431(viewState));
        TextView textView = getBinding().f18409e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.aboutMeHeader");
        textView.setVisibility(bioAst != null ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().f18407c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.aboutMeGuildIcon");
        simpleDraweeView.setVisibility(viewState.getHasGuildMemberBio() ? 0 : 8);
        String guildIconURL = viewState.getGuildIconURL();
        if (guildIconURL == null || guildIconURL.length() == 0) {
            SimpleDraweeView simpleDraweeView2 = getBinding().f18407c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView2 = getBinding().f18408d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.aboutMeGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().f18408d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.aboutMeGuildIconName");
            String guildName = viewState.getGuildName();
            if (guildName == null || (strComputeShortName = GuildUtils.computeShortName(guildName)) == null) {
                strComputeShortName = "";
            }
            textView3.setText(strComputeShortName);
        } else {
            SimpleDraweeView simpleDraweeView3 = getBinding().f18407c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView3, viewState.getGuildIconURL(), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView4 = getBinding().f18408d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.aboutMeGuildIconName");
            textView4.setVisibility(8);
        }
        CardView cardView = getBinding().f18406b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.aboutMeCard");
        cardView.setVisibility(bioAst != null ? 0 : 8);
        if (bioAst != null) {
            LinkifiedTextView linkifiedTextView = getBinding().f18411g;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.aboutMeText");
            Context context = linkifiedTextView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.aboutMeText.context");
            getBinding().f18411g.setDraweeSpanStringBuilder(AstRenderer.render(viewState.getBioAst(), new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetUserSheet$configureAboutMe$renderContext$1(getViewModel()), null, null, 14328, null)));
        }
    }

    private final void configureConnectionsSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        UserProfileConnectionsView.ViewState connectionsViewState = viewState.getConnectionsViewState();
        TextView textView = getBinding().f18417m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userSheetConnectionsHeader");
        textView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        UserProfileConnectionsView userProfileConnectionsView = getBinding().f18418n;
        Intrinsics3.checkNotNullExpressionValue(userProfileConnectionsView, "binding.userSheetConnectionsView");
        userProfileConnectionsView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        C10344xa5617a90 c10344xa5617a90 = new C10344xa5617a90(this);
        User user = viewState.getUser();
        getBinding().f18418n.updateViewState(connectionsViewState, c10344xa5617a90, new C10346xf08aeacd(this, user), new C10345x54a729c2(this, user));
    }

    private final void configureDeveloperSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        TextView textView = getBinding().f18419o;
        textView.setVisibility(StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode() ? 0 : 8);
        textView.setOnClickListener(new ViewOnClickListenerC10347x347522d0(textView, this, viewState));
        TextView textView2 = getBinding().f18419o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userSheetCopyId");
        boolean z2 = textView2.getVisibility() == 0;
        TextView textView3 = getBinding().f18420p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.userSheetDeveloperHeader");
        textView3.setVisibility(z2 ? 0 : 8);
    }

    private final void configureGuildSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        List<GuildRole> roleItems = viewState.getRoleItems();
        UserProfileAdminView.ViewState adminViewState = viewState.getAdminViewState();
        boolean zShouldShowRoles = viewState.shouldShowRoles();
        boolean z2 = true;
        boolean z3 = adminViewState != null && adminViewState.isAdminSectionEnabled();
        LinearLayout linearLayout = getBinding().f18424t;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.userSheetGuildContainer");
        if (!zShouldShowRoles && !z3) {
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        RolesListView rolesListView = getBinding().f18402P;
        Intrinsics3.checkNotNullExpressionValue(rolesListView, "binding.userSheetRolesList");
        rolesListView.setVisibility(zShouldShowRoles ? 0 : 8);
        Long guildId = viewState.getGuildId();
        if (zShouldShowRoles && guildId != null) {
            RolesListView rolesListView2 = getBinding().f18402P;
            RolesListView rolesListView3 = getBinding().f18402P;
            Intrinsics3.checkNotNullExpressionValue(rolesListView3, "binding.userSheetRolesList");
            rolesListView2.updateView(roleItems, ColorCompat.getThemedColor(rolesListView3.getContext(), C5419R.attr.primary_300), guildId.longValue());
        }
        String guildSectionHeaderText = viewState.getGuildSectionHeaderText();
        if (guildSectionHeaderText != null) {
            TextView textView = getBinding().f18425u;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.userSheetGuildHeader");
            textView.setText(guildSectionHeaderText);
        }
        CardView cardView = getBinding().f18414j;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.userSheetAdminCard");
        cardView.setVisibility(z3 ? 0 : 8);
        UserProfileAdminView userProfileAdminView = getBinding().f18415k;
        Intrinsics3.checkNotNullExpressionValue(userProfileAdminView, "binding.userSheetAdminView");
        userProfileAdminView.setVisibility(z3 ? 0 : 8);
        if (adminViewState != null) {
            getBinding().f18415k.updateView(adminViewState);
        }
    }

    private final void configureIncomingFriendRequest(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        boolean z2 = ModelUserRelationship.getType(Integer.valueOf(viewState.getUserRelationshipType())) == 3;
        TextView textView = getBinding().f18426v;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userSheetIncomingFriendRequestHeader");
        textView.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18423s;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.userSheetFriendRequestIncomingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        getBinding().f18421q.setOnClickListener(new ViewOnClickListenerC103481(viewState));
        getBinding().f18422r.setOnClickListener(new ViewOnClickListenerC103492());
    }

    private final void configureNote(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        getBinding().f18387A.setRawInputType(1);
        StoreUserNotes.UserNoteState userNoteFetchState = viewState.getUserNoteFetchState();
        if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Empty) {
            TextInputLayout textInputLayout = getBinding().f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            textInputLayout.setHint(getString(C5419R.string.note_placeholder_mobile));
            TextInputLayout textInputLayout2 = getBinding().f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
            textInputLayout2.setEnabled(true);
        } else if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Loading) {
            TextInputLayout textInputLayout3 = getBinding().f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.userSheetNoteTextFieldWrap");
            textInputLayout3.setHint(getString(C5419R.string.loading_note));
            TextInputLayout textInputLayout4 = getBinding().f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.userSheetNoteTextFieldWrap");
            textInputLayout4.setEnabled(false);
        } else if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Loaded) {
            TextInputLayout textInputLayout5 = getBinding().f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.userSheetNoteTextFieldWrap");
            textInputLayout5.setHint(getString(C5419R.string.note_placeholder_mobile));
            TextInputLayout textInputLayout6 = getBinding().f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.userSheetNoteTextFieldWrap");
            textInputLayout6.setEnabled(true);
        }
        if (viewState.getUserNote() != null) {
            TextInputLayout textInputLayout7 = getBinding().f18388B;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.userSheetNoteTextFieldWrap");
            ViewExtensions.setTextIfDifferent(textInputLayout7, viewState.getUserNote());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureProfileActionButtons(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        boolean z2;
        boolean zIsMe = viewState.isMe();
        Long currentGuildId = viewState.getCurrentGuildId();
        UserProfile userProfile = viewState.getUserProfile();
        FrameLayout frameLayout = getBinding().f18393G;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.userSheetProfileAddToServerContainer");
        frameLayout.setVisibility(ApplicationUtils.INSTANCE.canInstallApplication(userProfile != null ? userProfile.getApplication() : null) ? 0 : 8);
        getBinding().f18392F.setOnClickListener(new ViewOnClickListenerC103501(userProfile));
        FlexboxLayout flexboxLayout = getBinding().f18395I;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.userSheetProfileEditContainer");
        flexboxLayout.setVisibility(zIsMe ? 0 : 8);
        getBinding().f18394H.setOnClickListener(new ViewOnClickListenerC103512());
        MaterialButton materialButton = getBinding().f18397K;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.userSheetProfileIdentityButton");
        if (zIsMe) {
            if ((currentGuildId != null ? currentGuildId.longValue() : 0L) > 0) {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        materialButton.setVisibility(z2 ? 0 : 8);
        getBinding().f18397K.setOnClickListener(new ViewOnClickListenerC103523(currentGuildId));
        boolean isBot = viewState.getUser().getIsBot();
        boolean isSystemUser = viewState.getUser().getIsSystemUser();
        int userRelationshipType = viewState.getUserRelationshipType();
        boolean z3 = (zIsMe || isSystemUser) ? false : true;
        View view = getBinding().f18391E;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.userSheetProfileActionsDivider");
        view.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18390D;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.userSheetProfileActionsContainer");
        linearLayout.setVisibility(z3 ? 0 : 8);
        if (z3) {
            Button button = getBinding().f18428x;
            Intrinsics3.checkNotNullExpressionValue(button, "binding.userSheetMessageActionButton");
            Channel channel = viewState.getChannel();
            button.setVisibility(channel == null || channel.getType() != 1 ? 0 : 8);
            getBinding().f18428x.setOnClickListener(new ViewOnClickListenerC103534(viewState));
            getBinding().f18416l.setOnClickListener(new ViewOnClickListenerC103545());
            getBinding().f18403Q.setOnClickListener(new ViewOnClickListenerC103556());
            if (userRelationshipType == 0) {
                Button button2 = getBinding().f18413i;
                Intrinsics3.checkNotNullExpressionValue(button2, "binding.userSheetAddFriendActionButton");
                button2.setVisibility(0);
                Button button3 = getBinding().f18389C;
                Intrinsics3.checkNotNullExpressionValue(button3, "binding.userSheetPendingFriendRequestActionButton");
                button3.setVisibility(8);
            } else if (userRelationshipType == 3 || userRelationshipType == 4) {
                Button button4 = getBinding().f18413i;
                Intrinsics3.checkNotNullExpressionValue(button4, "binding.userSheetAddFriendActionButton");
                button4.setVisibility(8);
                Button button5 = getBinding().f18389C;
                Intrinsics3.checkNotNullExpressionValue(button5, "binding.userSheetPendingFriendRequestActionButton");
                button5.setVisibility(0);
            } else {
                Button button6 = getBinding().f18413i;
                Intrinsics3.checkNotNullExpressionValue(button6, "binding.userSheetAddFriendActionButton");
                button6.setVisibility(8);
                Button button7 = getBinding().f18389C;
                Intrinsics3.checkNotNullExpressionValue(button7, "binding.userSheetPendingFriendRequestActionButton");
                button7.setVisibility(8);
            }
            boolean z4 = (zIsMe || isBot || userRelationshipType != 0) ? false : true;
            Button button8 = getBinding().f18413i;
            Intrinsics3.checkNotNullExpressionValue(button8, "binding.userSheetAddFriendActionButton");
            button8.setVisibility(z4 ? 0 : 8);
            getBinding().f18413i.setOnClickListener(new ViewOnClickListenerC103567(viewState));
            getBinding().f18389C.setOnClickListener(new ViewOnClickListenerC103578(userRelationshipType, viewState));
        }
    }

    private final void configureStageActionsSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        getBinding().f18399M.updateView(viewState.getStageViewState());
        CardView cardView = getBinding().f18398L;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.userSheetProfileStageActionsCard");
        UserProfileStageActionsView userProfileStageActionsView = getBinding().f18399M;
        Intrinsics3.checkNotNullExpressionValue(userProfileStageActionsView, "binding.userSheetProfileStageActionsView");
        cardView.setVisibility(userProfileStageActionsView.getVisibility() == 0 ? 0 : 8);
    }

    private final void configureUI(WidgetUserSheetViewModel.ViewState model) {
        if (model instanceof WidgetUserSheetViewModel.ViewState.Uninitialized) {
            FrameLayout frameLayout = getBinding().f18427w;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.userSheetLoadingContainer");
            frameLayout.setVisibility(0);
            return;
        }
        if (!(model instanceof WidgetUserSheetViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        FrameLayout frameLayout2 = getBinding().f18427w;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.userSheetLoadingContainer");
        frameLayout2.setVisibility(8);
        WidgetUserSheetViewModel.ViewState.Loaded loaded = (WidgetUserSheetViewModel.ViewState.Loaded) model;
        Presence presence = loaded.getPresence();
        Activity primaryActivity = presence != null ? PresenceUtils.INSTANCE.getPrimaryActivity(presence) : null;
        boolean zIsMe = loaded.isMe();
        boolean isSystemUser = loaded.getUser().getIsSystemUser();
        if (!getViewModel().getOpenPopoutLogged() && loaded.getProfileLoaded()) {
            AnalyticsTracker.INSTANCE.openUserSheet(loaded.getHasPremiumCustomization(), primaryActivity != null ? primaryActivity.getName() : null, primaryActivity != null ? ActivityUtils.getGamePlatform(primaryActivity) : null, loaded.getGuildMember());
            getViewModel().setOpenPopoutLogged(true);
        }
        getBinding().f18396J.setOnBannerPress(new C103581());
        ImageView imageView = getBinding().f18429y;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.userSheetMoreButton");
        imageView.setVisibility((zIsMe || isSystemUser) ? false : true ? 0 : 8);
        if (loaded.getConnectionsViewState().getShowConnectionsSection()) {
            setPeekHeightBottomView(getBinding().f18417m);
        }
        ViewHolderUserRichPresence.Companion companion = ViewHolderUserRichPresence.INSTANCE;
        FrameLayout frameLayout3 = getBinding().f18412h;
        Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.richPresenceContainer");
        ViewHolderUserRichPresence richPresence = companion.setRichPresence(frameLayout3, primaryActivity, loaded.getStreamContext(), this.activityViewHolder);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        StreamContext streamContext = loaded.getStreamContext();
        boolean zIsMe2 = loaded.isMe();
        User user = loaded.getUser();
        Context applicationContext = requireAppActivity().getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "requireAppActivity().applicationContext");
        richPresence.configureUi(parentFragmentManager, streamContext, zIsMe2, user, applicationContext, loaded.getRichPresence(), loaded.getUserInSameVoiceChannel());
        richPresence.configureUiTimestamp(primaryActivity, this);
        this.activityViewHolder = richPresence;
        ViewHolderStreamRichPresence viewHolderStreamRichPresence = (ViewHolderStreamRichPresence) (richPresence instanceof ViewHolderStreamRichPresence ? richPresence : null);
        if (loaded.getStreamContext() != null && viewHolderStreamRichPresence != null) {
            viewHolderStreamRichPresence.setOnStreamPreviewClicked(new C103593(model));
        }
        ViewHolderUserRichPresence viewHolderUserRichPresence = this.activityViewHolder;
        if (viewHolderUserRichPresence != null) {
            viewHolderUserRichPresence.setOnActivityCustomButtonClicked(new C103604(getViewModel()));
        }
        configureProfileActionButtons(loaded);
        configureStageActionsSection(loaded);
        configureAboutMe(loaded);
        configureIncomingFriendRequest(loaded);
        configureVoiceSection(loaded);
        configureGuildSection(loaded);
        configureConnectionsSection(loaded);
        configureNote(loaded);
        configureDeveloperSection(loaded);
    }

    private final void configureVoiceSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        UserProfileVoiceSettingsView.ViewState voiceSettingsViewState = viewState.getVoiceSettingsViewState();
        boolean showVoiceSettings = viewState.getShowVoiceSettings();
        TextView textView = getBinding().f18400N;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userSheetProfileVoiceSettingsHeader");
        textView.setVisibility(showVoiceSettings ? 0 : 8);
        CardView cardView = getBinding().f18404R;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.voiceSettingsViewCard");
        cardView.setVisibility(showVoiceSettings ? 0 : 8);
        getBinding().f18401O.updateView(voiceSettingsViewState);
    }

    private final WidgetUserSheetBinding getBinding() {
        return (WidgetUserSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserSheetViewModel getViewModel() {
        return (WidgetUserSheetViewModel) this.viewModel.getValue();
    }

    private final UserProfileHeaderViewModel getViewModelUserProfileHeader() {
        return (UserProfileHeaderViewModel) this.viewModelUserProfileHeader.getValue();
    }

    private final void handleBanUser(WidgetUserSheetViewModel.Event.LaunchBanUser event) {
        WidgetBanUser.INSTANCE.launch(event.getUsername(), event.getGuildId(), event.getUserId(), getParentFragmentManager());
    }

    private final void handleDisableCommunication(WidgetUserSheetViewModel.Event.LaunchDisableCommunication event) {
        WidgetDisableGuildCommunication.Companion companion = WidgetDisableGuildCommunication.INSTANCE;
        long userId = event.getUserId();
        long guildId = event.getGuildId();
        WidgetUserSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.f18405a;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        companion.launch(userId, guildId, context);
    }

    private final void handleDismissSheet() {
        dismiss();
    }

    private final void handleEnableCommunication(WidgetUserSheetViewModel.Event.LaunchEnableCommunication event) {
        WidgetEnableGuildCommunication.Companion companion = WidgetEnableGuildCommunication.INSTANCE;
        long userId = event.getUserId();
        long guildId = event.getGuildId();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(userId, guildId, parentFragmentManager);
    }

    private final void handleEvent(WidgetUserSheetViewModel.Event event) {
        if (event instanceof WidgetUserSheetViewModel.Event.ShowToast) {
            handleShowToast((WidgetUserSheetViewModel.Event.ShowToast) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.ShowFriendRequestErrorToast) {
            handleShowFriendRequestErrorToast((WidgetUserSheetViewModel.Event.ShowFriendRequestErrorToast) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchVoiceCall) {
            handleLaunchVoiceCall((WidgetUserSheetViewModel.Event.LaunchVoiceCall) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchVideoCall) {
            handleLaunchVideoCall((WidgetUserSheetViewModel.Event.LaunchVideoCall) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchSpectate) {
            handleLaunchSpectate((WidgetUserSheetViewModel.Event.LaunchSpectate) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchEditMember) {
            handleLaunchEditMember((WidgetUserSheetViewModel.Event.LaunchEditMember) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchKickUser) {
            handleKickUser((WidgetUserSheetViewModel.Event.LaunchKickUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchBanUser) {
            handleBanUser((WidgetUserSheetViewModel.Event.LaunchBanUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchDisableCommunication) {
            handleDisableCommunication((WidgetUserSheetViewModel.Event.LaunchDisableCommunication) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchEnableCommunication) {
            handleEnableCommunication((WidgetUserSheetViewModel.Event.LaunchEnableCommunication) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchMoveUser) {
            handleMoveUser((WidgetUserSheetViewModel.Event.LaunchMoveUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream) {
            handleRequestPermissionsForSpectateStream((WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.UserNotFound) {
            AppToast.m171i(this, C5419R.string.user_profile_failure_to_open_message, 0, 4);
            handleDismissSheet();
        } else {
            if (!(event instanceof WidgetUserSheetViewModel.Event.DismissSheet)) {
                throw new NoWhenBranchMatchedException();
            }
            handleDismissSheet();
        }
    }

    private final void handleKickUser(WidgetUserSheetViewModel.Event.LaunchKickUser event) {
        WidgetKickUser.Companion companion = WidgetKickUser.INSTANCE;
        String username = event.getUsername();
        long guildId = event.getGuildId();
        long userId = event.getUserId();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(username, guildId, userId, parentFragmentManager);
    }

    private final void handleLaunchEditMember(WidgetUserSheetViewModel.Event.LaunchEditMember event) {
        WidgetServerSettingsEditMember.Companion companion = WidgetServerSettingsEditMember.INSTANCE;
        long guildId = event.getGuildId();
        long userId = event.getUserId();
        WidgetUserSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.f18405a;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        companion.launch(guildId, userId, context);
    }

    private final void handleLaunchSpectate(WidgetUserSheetViewModel.Event.LaunchSpectate event) {
        WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetCallFullscreen.Companion.launch$default(companion, contextRequireContext, event.getStream().getChannelId(), false, event.getStream().getEncodedStreamKey(), null, 20, null);
        dismiss();
    }

    private final void handleLaunchVideoCall(WidgetUserSheetViewModel.Event.LaunchVideoCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVideoCall(event.getChannelId());
    }

    private final void handleLaunchVoiceCall(WidgetUserSheetViewModel.Event.LaunchVoiceCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleMoveUser(WidgetUserSheetViewModel.Event.LaunchMoveUser event) {
        WidgetChannelSelector.Companion.launchForVocal$default(WidgetChannelSelector.INSTANCE, this, event.getGuildId(), REQUEST_KEY_MOVE_USER, false, 0, 24, null);
    }

    private final void handleRequestPermissionsForSpectateStream(WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream event) {
        AnimatableValueParser.m473S1(this, null, new C103611(event), 1, null);
    }

    private final void handleShowFriendRequestErrorToast(WidgetUserSheetViewModel.Event.ShowFriendRequestErrorToast event) {
        AppToast.m172j(this, RestAPIAbortMessages.ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(WidgetUserSheetViewModel.Event.ShowToast event) {
        AppToast.m171i(this, event.getStringRes(), 0, 4);
    }

    private final void ignoreFriendRequest() {
        getViewModel().removeRelationship(C5419R.string.friend_request_ignored);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        getViewModel().onStreamPreviewClicked(streamContext);
    }

    public static final void show(long j, FragmentManager fragmentManager) {
        Companion.show$default(INSTANCE, j, null, fragmentManager, null, null, null, null, 122, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, null, null, null, null, 120, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, l2, null, null, null, 112, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, l2, bool, null, null, 96, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, l2, bool, streamPreviewClickBehavior, null, 64, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior, String str) {
        INSTANCE.show(j, l, fragmentManager, l2, bool, streamPreviewClickBehavior, str);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C103411(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetUserSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C103422(this), 62, (Object) null);
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().f18396J;
        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSheetProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_user_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        ViewHolderUserRichPresence viewHolderUserRichPresence = this.activityViewHolder;
        if (viewHolderUserRichPresence != null) {
            viewHolderUserRichPresence.disposeSubscriptions();
        }
        long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        long j2 = getArgumentsOrDefault().getLong(ARG_GUILD_ID);
        if (j > 0 && j2 > 0) {
            StoreStream.INSTANCE.getGuildSubscriptions().unsubscribeUser(j2, j);
        }
        hideKeyboard(getBinding().f18388B);
        WidgetUserSheetViewModel viewModel = getViewModel();
        Context context = getContext();
        TextInputLayout textInputLayout = getBinding().f18388B;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        viewModel.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        long j2 = getArgumentsOrDefault().getLong(ARG_GUILD_ID);
        if (j <= 0 || j2 <= 0) {
            return;
        }
        StoreStream.INSTANCE.getGuildSubscriptions().subscribeUser(j2, j);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        boolean z2 = j == StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
        getBinding().f18429y.setOnClickListener(new ViewOnClickListenerC103621(j));
        UserProfileHeaderView userProfileHeaderView = getBinding().f18396J;
        Badge.Companion companion = Badge.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        userProfileHeaderView.setOnBadgeClick(companion.onBadgeClick(parentFragmentManager, contextRequireContext));
        getBinding().f18399M.setOnInviteToSpeak(new C103722(z2));
        getBinding().f18399M.setOnMoveToAudience(new C103733());
        getBinding().f18401O.setOnMuteChecked(new C103744());
        getBinding().f18401O.setOnDeafenChecked(new C103755());
        getBinding().f18401O.setOnVolumeChange(new C103766());
        getBinding().f18415k.setOnEditMember(new C103777());
        getBinding().f18415k.setOnKick(new C103788());
        getBinding().f18415k.setOnBan(new C103799());
        getBinding().f18415k.setOnDisableCommunication(new C1036310());
        getBinding().f18415k.setOnServerMute(new C1036411());
        getBinding().f18415k.setOnServerDeafen(new C1036512());
        getBinding().f18415k.setOnServerMove(new C1036613());
        getBinding().f18415k.setOnDisconnect(new C1036714());
        TextInputLayout textInputLayout = getBinding().f18388B;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new ViewOnFocusChangeListenerC1036815());
        TextInputLayout textInputLayout2 = getBinding().f18388B;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new C1036916(view), 1, null);
        ViewCompat.setAccessibilityDelegate(getBinding().f18429y, new C1037017());
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f18417m, getBinding().f18425u, getBinding().f18430z, getBinding().f18420p, getBinding().f18426v, getBinding().f18400N})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
        WidgetChannelSelector.Companion.registerForResult$default(WidgetChannelSelector.INSTANCE, this, REQUEST_KEY_MOVE_USER, false, new C1037118(), 4, null);
    }
}
