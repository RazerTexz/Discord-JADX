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
import b.a.a.d.a;
import b.a.d.i0;
import b.a.k.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
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
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
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
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import defpackage.l;
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
import rx.subscriptions.CompositeSubscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSheetBinding;", 0)};

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
            m.checkNotNullExpressionValue(str, "StringBuilder(\"User Shee…)\n            .toString()");
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
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(streamPreviewClickBehavior, "streamPreviewClickBehavior");
            WidgetUserSheet widgetUserSheet = new WidgetUserSheet();
            Bundle bundleT = a.T(WidgetUserSheet.ARG_USER_ID, userId);
            if (channelId != null) {
                bundleT.putLong(WidgetUserSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            if (friendToken != null) {
                bundleT.putString(WidgetUserSheet.ARG_FRIEND_TOKEN, friendToken);
            }
            if (guildId != null) {
                bundleT.putLong(WidgetUserSheet.ARG_GUILD_ID, guildId.longValue());
            }
            bundleT.putBoolean(WidgetUserSheet.ARG_IS_VOICE_CONTEXT, isVoiceContext != null ? isVoiceContext.booleanValue() : false);
            bundleT.putSerializable(WidgetUserSheet.ARG_STREAM_PREVIEW_CLICK_BEHAVIOR, streamPreviewClickBehavior);
            widgetUserSheet.setArguments(bundleT);
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
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$bindSubscriptions$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetUserSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetUserSheet widgetUserSheet) {
            super(1, widgetUserSheet, WidgetUserSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSheetViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetUserSheet.access$configureUI((WidgetUserSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$bindSubscriptions$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<WidgetUserSheetViewModel.Event, Unit> {
        public AnonymousClass2(WidgetUserSheet widgetUserSheet) {
            super(1, widgetUserSheet, WidgetUserSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSheetViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetUserSheet.access$handleEvent((WidgetUserSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureAboutMe$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getHasGuildMemberBio()) {
                m.checkNotNullExpressionValue(view, "it");
                b.a.d.m.h(view.getContext(), b.k(WidgetUserSheet.this, R.string.guild_identity_bio_toast, new Object[]{this.$viewState.getGuildName()}, null, 4), 0, null, 12);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureIncomingFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$acceptFriendRequest(WidgetUserSheet.this, this.$viewState.getUser().getUsername());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureIncomingFriendRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$ignoreFriendRequest(WidgetUserSheet.this);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ UserProfile $userProfile;

        public AnonymousClass1(UserProfile userProfile) {
            this.$userProfile = userProfile;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ApplicationUtils applicationUtils = ApplicationUtils.INSTANCE;
            UserProfile userProfile = this.$userProfile;
            Uri applicationUri = applicationUtils.getApplicationUri(userProfile != null ? userProfile.getApplication() : null);
            if (applicationUri != null) {
                Context contextX = a.x(view, "view", "view.context");
                String string = applicationUri.toString();
                m.checkNotNullExpressionValue(string, "uri.toString()");
                UriHandler.handleOrUntrusted$default(contextX, string, null, 4, null);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditUserOrGuildMemberProfile.Companion companion = WidgetEditUserOrGuildMemberProfile.INSTANCE;
            Context contextRequireContext = WidgetUserSheet.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
            WidgetEditUserOrGuildMemberProfile.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Long $guildId;

        public AnonymousClass3(Long l) {
            this.$guildId = l;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$guildId != null) {
                Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
                if (userExperiment != null && userExperiment.getBucket() == 1) {
                    WidgetEditUserOrGuildMemberProfile.Companion.launch$default(WidgetEditUserOrGuildMemberProfile.INSTANCE, a.x(view, "it", "it.context"), null, this.$guildId, 2, null);
                    return;
                }
                WidgetChangeGuildIdentity.Companion companion = WidgetChangeGuildIdentity.INSTANCE;
                long jLongValue = this.$guildId.longValue();
                m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "it.context");
                companion.launch(jLongValue, "User Bottom Sheet", context);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public AnonymousClass4(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector companion = ChannelSelector.INSTANCE.getInstance();
            Context contextRequireContext = WidgetUserSheet.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
            companion.findAndSetDirectMessage(contextRequireContext, this.$viewState.getUser().getId());
            WidgetUserSheet.this.dismiss();
            StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
            AppActivity appActivityRequireAppActivity = WidgetUserSheet.this.requireAppActivity();
            Context contextRequireContext2 = WidgetUserSheet.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            appActivityRequireAppActivity.j(contextRequireContext2);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).launchVoiceCall();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).launchVideoCall();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        public AnonymousClass7(WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSheet.access$addFriend(WidgetUserSheet.this, this.$viewState.getUser().getUsername());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ int $userRelationshipType;
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$1, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Integer, Unit> {
            public AnonymousClass1(WidgetUserSheetViewModel widgetUserSheetViewModel) {
                super(1, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "removeRelationship", "removeRelationship(I)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                ((WidgetUserSheetViewModel) this.receiver).removeRelationship(i);
            }
        }

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                WidgetUserSheet.access$acceptFriendRequest(WidgetUserSheet.this, anonymousClass8.$viewState.getUser().getUsername());
            }
        }

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$3, reason: invalid class name */
        public static final class AnonymousClass3 extends o implements Function0<Unit> {
            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetUserSheet.access$ignoreFriendRequest(WidgetUserSheet.this);
            }
        }

        public AnonymousClass8(int i, WidgetUserSheetViewModel.ViewState.Loaded loaded) {
            this.$userRelationshipType = i;
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.$userRelationshipType;
            Integer numValueOf = Integer.valueOf(R.id.notice_ok);
            if (i == 3) {
                FragmentManager parentFragmentManager = WidgetUserSheet.this.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                Context contextRequireContext = WidgetUserSheet.this.requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                AnonymousClass3 anonymousClass3 = new AnonymousClass3();
                m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
                m.checkNotNullParameter(contextRequireContext, "context");
                m.checkNotNullParameter(anonymousClass2, "onAccept");
                m.checkNotNullParameter(anonymousClass3, "onIgnore");
                WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, parentFragmentManager, b.h(contextRequireContext, R.string.incoming_friend_request, new Object[0], null, 4), b.h(contextRequireContext, R.string.user_profile_incoming_friend_request_dialog_body, new Object[0], null, 4), b.h(contextRequireContext, R.string.friend_request_accept, new Object[0], null, 4), b.h(contextRequireContext, R.string.friend_request_ignore, new Object[0], null, 4), h0.mapOf(d0.o.to(numValueOf, new l(0, anonymousClass2)), d0.o.to(Integer.valueOf(R.id.notice_cancel), new l(1, anonymousClass3))), null, null, null, null, null, null, 0, null, 16320, null);
                return;
            }
            if (i != 4) {
                return;
            }
            User user = this.$viewState.getUser();
            Context contextRequireContext2 = WidgetUserSheet.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            FragmentManager parentFragmentManager2 = WidgetUserSheet.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this));
            m.checkNotNullParameter(user, "user");
            m.checkNotNullParameter(contextRequireContext2, "context");
            m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            m.checkNotNullParameter(anonymousClass1, "onConfirm");
            WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, parentFragmentManager2, b.h(contextRequireContext2, R.string.outgoing_friend_request, new Object[0], null, 4), b.h(contextRequireContext2, R.string.outgoing_friend_request_delete_msg, new Object[]{user.getUsername()}, null, 4), b.h(contextRequireContext2, R.string.delete, new Object[0], null, 4), b.h(contextRequireContext2, R.string.cancel, new Object[0], null, 4), g0.mapOf(d0.o.to(numValueOf, new b.a.a.l(anonymousClass1))), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$1, reason: invalid class name */
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
            WidgetUserSheet.access$getViewModelUserProfileHeader$p(WidgetUserSheet.this).toggleAllowAnimationInReducedMotion();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetUserSheetViewModel.ViewState viewState) {
            super(0);
            this.$model = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$onStreamPreviewClicked(WidgetUserSheet.this, ((WidgetUserSheetViewModel.ViewState.Loaded) this.$model).getStreamContext());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function5<Context, Long, String, Long, Integer, Unit> {
        public AnonymousClass4(WidgetUserSheetViewModel widgetUserSheetViewModel) {
            super(5, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "onActivityCustomButtonClicked", "onActivityCustomButtonClicked(Landroid/content/Context;JLjava/lang/String;JI)V", 0);
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Context context, Long l, String str, Long l2, Integer num) {
            invoke(context, l.longValue(), str, l2.longValue(), num.intValue());
            return Unit.a;
        }

        public final void invoke(Context context, long j, String str, long j2, int i) {
            m.checkNotNullParameter(context, "p1");
            m.checkNotNullParameter(str, "p3");
            ((WidgetUserSheetViewModel) this.receiver).onActivityCustomButtonClicked(context, j, str, j2, i);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$handleRequestPermissionsForSpectateStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream requestPermissionsForSpectateStream) {
            super(0);
            this.$event = requestPermissionsForSpectateStream;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).onSpectatePermissionsGranted(this.$event.getStream());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j) {
            this.$userId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.Companion bVar = b.a.a.d.a.INSTANCE;
            FragmentManager parentFragmentManager = WidgetUserSheet.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            long j = this.$userId;
            long j2 = WidgetUserSheet.access$getArgumentsOrDefault$p(WidgetUserSheet.this).getLong(WidgetUserSheet.ARG_CHANNEL_ID);
            Objects.requireNonNull(bVar);
            m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            b.a.a.d.a aVar = new b.a.a.d.a();
            Bundle bundleT = b.d.b.a.a.T("com.discord.intent.extra.EXTRA_USER_ID", j);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", j2);
            aVar.setArguments(bundleT);
            aVar.show(parentFragmentManager, b.a.a.d.a.class.getName());
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$10, reason: invalid class name */
    public static final class AnonymousClass10 extends o implements Function0<Unit> {
        public AnonymousClass10() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).disableCommunication();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$11, reason: invalid class name */
    public static final class AnonymousClass11 extends o implements Function0<Unit> {
        public AnonymousClass11() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).guildMuteUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$12, reason: invalid class name */
    public static final class AnonymousClass12 extends o implements Function0<Unit> {
        public AnonymousClass12() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).guildDeafenUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$13, reason: invalid class name */
    public static final class AnonymousClass13 extends o implements Function0<Unit> {
        public AnonymousClass13() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).guildMoveForUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$14, reason: invalid class name */
    public static final class AnonymousClass14 extends o implements Function0<Unit> {
        public AnonymousClass14() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheetViewModel.disconnectUser$default(WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this), null, 1, null);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$15, reason: invalid class name */
    public static final class AnonymousClass15 implements View.OnFocusChangeListener {
        public AnonymousClass15() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z2) {
            if (z2) {
                return;
            }
            WidgetUserSheetViewModel widgetUserSheetViewModelAccess$getViewModel$p = WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this);
            Context context = WidgetUserSheet.this.getContext();
            TextInputLayout textInputLayout = WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).B;
            m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            widgetUserSheetViewModelAccess$getViewModel$p.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$16, reason: invalid class name */
    public static final class AnonymousClass16 extends o implements Function1<TextView, Unit> {
        public final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass16(View view) {
            super(1);
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            m.checkNotNullParameter(textView, "it");
            WidgetUserSheetViewModel widgetUserSheetViewModelAccess$getViewModel$p = WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this);
            Context context = WidgetUserSheet.this.getContext();
            TextInputLayout textInputLayout = WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).B;
            m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            widgetUserSheetViewModelAccess$getViewModel$p.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
            WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).B.clearFocus();
            WidgetUserSheet.this.hideKeyboard(this.$view);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$17, reason: invalid class name */
    public static final class AnonymousClass17 extends AccessibilityDelegateCompat {
        public AnonymousClass17() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            m.checkNotNullParameter(host, "host");
            m.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setTraversalAfter(WidgetUserSheet.access$getBinding$p(WidgetUserSheet.this).o);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$18, reason: invalid class name */
    public static final class AnonymousClass18 extends o implements Function2<Long, String, Unit> {
        public AnonymousClass18() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).moveUserToChannel(j);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public final /* synthetic */ boolean $isMe;

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2$1, reason: invalid class name */
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
                b.a.d.m.g(WidgetUserSheet.this.getContext(), R.string.stage_channel_permission_microphone_denied, 0, null, 12);
            }
        }

        /* compiled from: WidgetUserSheet.kt */
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C04732 extends o implements Function0<Unit> {
            public C04732() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).setUserSuppressedInChannel(false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2) {
            super(0);
            this.$isMe = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$isMe) {
                WidgetUserSheet.this.requestMicrophone(new AnonymousClass1(), new C04732());
            } else {
                WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).inviteUserToSpeak();
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).setUserSuppressedInChannel(true);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).toggleMute(z2);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).toggleDeafen(z2);
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$6, reason: invalid class name */
    public static final class AnonymousClass6 extends o implements Function2<Float, Boolean, Unit> {
        public AnonymousClass6() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Float f, Boolean bool) {
            invoke(f.floatValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(float f, boolean z2) {
            if (z2) {
                WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).setUserOutputVolume(f);
            }
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$7, reason: invalid class name */
    public static final class AnonymousClass7 extends o implements Function0<Unit> {
        public AnonymousClass7() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).editMember();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$8, reason: invalid class name */
    public static final class AnonymousClass8 extends o implements Function0<Unit> {
        public AnonymousClass8() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).kickUser();
        }
    }

    /* compiled from: WidgetUserSheet.kt */
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$9, reason: invalid class name */
    public static final class AnonymousClass9 extends o implements Function0<Unit> {
        public AnonymousClass9() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.access$getViewModel$p(WidgetUserSheet.this).banUser();
        }
    }

    public WidgetUserSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserSheet$binding$2.INSTANCE, null, 2, null);
        WidgetUserSheet$viewModelUserProfileHeader$2 widgetUserSheet$viewModelUserProfileHeader$2 = new WidgetUserSheet$viewModelUserProfileHeader$2(this);
        b.a.d.g0 g0Var = new b.a.d.g0(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetUserSheet$viewModelUserProfileHeader$2));
        WidgetUserSheet$viewModel$2 widgetUserSheet$viewModel$2 = new WidgetUserSheet$viewModel$2(this);
        b.a.d.g0 g0Var2 = new b.a.d.g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetUserSheetViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$2(g0Var2), new i0(widgetUserSheet$viewModel$2));
    }

    private final void acceptFriendRequest(String username) {
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, R.string.accept_request_button_after, null, 8, null);
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
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, R.string.friend_request_sent, null, 8, null);
    }

    private final void configureAboutMe(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        String strComputeShortName;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        getBinding().f.setOnClickListener(new AnonymousClass1(viewState));
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.aboutMeHeader");
        textView.setVisibility(bioAst != null ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.aboutMeGuildIcon");
        simpleDraweeView.setVisibility(viewState.getHasGuildMemberBio() ? 0 : 8);
        String guildIconURL = viewState.getGuildIconURL();
        if (guildIconURL == null || guildIconURL.length() == 0) {
            SimpleDraweeView simpleDraweeView2 = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.aboutMeGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().d;
            m.checkNotNullExpressionValue(textView3, "binding.aboutMeGuildIconName");
            String guildName = viewState.getGuildName();
            if (guildName == null || (strComputeShortName = GuildUtilsKt.computeShortName(guildName)) == null) {
                strComputeShortName = "";
            }
            textView3.setText(strComputeShortName);
        } else {
            SimpleDraweeView simpleDraweeView3 = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView3, viewState.getGuildIconURL(), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView4 = getBinding().d;
            m.checkNotNullExpressionValue(textView4, "binding.aboutMeGuildIconName");
            textView4.setVisibility(8);
        }
        CardView cardView = getBinding().f2693b;
        m.checkNotNullExpressionValue(cardView, "binding.aboutMeCard");
        cardView.setVisibility(bioAst != null ? 0 : 8);
        if (bioAst != null) {
            LinkifiedTextView linkifiedTextView = getBinding().g;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.aboutMeText");
            Context context = linkifiedTextView.getContext();
            m.checkNotNullExpressionValue(context, "binding.aboutMeText.context");
            getBinding().g.setDraweeSpanStringBuilder(AstRenderer.render(viewState.getBioAst(), new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetUserSheet$configureAboutMe$renderContext$1(getViewModel()), null, null, 14328, null)));
        }
    }

    private final void configureConnectionsSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        UserProfileConnectionsView.ViewState connectionsViewState = viewState.getConnectionsViewState();
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.userSheetConnectionsHeader");
        textView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        UserProfileConnectionsView userProfileConnectionsView = getBinding().n;
        m.checkNotNullExpressionValue(userProfileConnectionsView, "binding.userSheetConnectionsView");
        userProfileConnectionsView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1 widgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1 = new WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1(this);
        User user = viewState.getUser();
        getBinding().n.updateViewState(connectionsViewState, widgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1, new WidgetUserSheet$configureConnectionsSection$onMutualGuildsItemClick$1(this, user), new WidgetUserSheet$configureConnectionsSection$onMutualFriendsItemClick$1(this, user));
    }

    private final void configureDeveloperSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        TextView textView = getBinding().o;
        textView.setVisibility(StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode() ? 0 : 8);
        textView.setOnClickListener(new WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1(textView, this, viewState));
        TextView textView2 = getBinding().o;
        m.checkNotNullExpressionValue(textView2, "binding.userSheetCopyId");
        boolean z2 = textView2.getVisibility() == 0;
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.userSheetDeveloperHeader");
        textView3.setVisibility(z2 ? 0 : 8);
    }

    private final void configureGuildSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        List<GuildRole> roleItems = viewState.getRoleItems();
        UserProfileAdminView.ViewState adminViewState = viewState.getAdminViewState();
        boolean zShouldShowRoles = viewState.shouldShowRoles();
        boolean z2 = true;
        boolean z3 = adminViewState != null && adminViewState.isAdminSectionEnabled();
        LinearLayout linearLayout = getBinding().t;
        m.checkNotNullExpressionValue(linearLayout, "binding.userSheetGuildContainer");
        if (!zShouldShowRoles && !z3) {
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        RolesListView rolesListView = getBinding().P;
        m.checkNotNullExpressionValue(rolesListView, "binding.userSheetRolesList");
        rolesListView.setVisibility(zShouldShowRoles ? 0 : 8);
        Long guildId = viewState.getGuildId();
        if (zShouldShowRoles && guildId != null) {
            RolesListView rolesListView2 = getBinding().P;
            RolesListView rolesListView3 = getBinding().P;
            m.checkNotNullExpressionValue(rolesListView3, "binding.userSheetRolesList");
            rolesListView2.updateView(roleItems, ColorCompat.getThemedColor(rolesListView3.getContext(), R.attr.primary_300), guildId.longValue());
        }
        String guildSectionHeaderText = viewState.getGuildSectionHeaderText();
        if (guildSectionHeaderText != null) {
            TextView textView = getBinding().u;
            m.checkNotNullExpressionValue(textView, "binding.userSheetGuildHeader");
            textView.setText(guildSectionHeaderText);
        }
        CardView cardView = getBinding().j;
        m.checkNotNullExpressionValue(cardView, "binding.userSheetAdminCard");
        cardView.setVisibility(z3 ? 0 : 8);
        UserProfileAdminView userProfileAdminView = getBinding().k;
        m.checkNotNullExpressionValue(userProfileAdminView, "binding.userSheetAdminView");
        userProfileAdminView.setVisibility(z3 ? 0 : 8);
        if (adminViewState != null) {
            getBinding().k.updateView(adminViewState);
        }
    }

    private final void configureIncomingFriendRequest(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        boolean z2 = ModelUserRelationship.getType(Integer.valueOf(viewState.getUserRelationshipType())) == 3;
        TextView textView = getBinding().v;
        m.checkNotNullExpressionValue(textView, "binding.userSheetIncomingFriendRequestHeader");
        textView.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = getBinding().f2694s;
        m.checkNotNullExpressionValue(linearLayout, "binding.userSheetFriendRequestIncomingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        getBinding().q.setOnClickListener(new AnonymousClass1(viewState));
        getBinding().r.setOnClickListener(new AnonymousClass2());
    }

    private final void configureNote(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        getBinding().A.setRawInputType(1);
        StoreUserNotes.UserNoteState userNoteFetchState = viewState.getUserNoteFetchState();
        if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Empty) {
            TextInputLayout textInputLayout = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            textInputLayout.setHint(getString(R.string.note_placeholder_mobile));
            TextInputLayout textInputLayout2 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
            textInputLayout2.setEnabled(true);
        } else if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Loading) {
            TextInputLayout textInputLayout3 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.userSheetNoteTextFieldWrap");
            textInputLayout3.setHint(getString(R.string.loading_note));
            TextInputLayout textInputLayout4 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout4, "binding.userSheetNoteTextFieldWrap");
            textInputLayout4.setEnabled(false);
        } else if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Loaded) {
            TextInputLayout textInputLayout5 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.userSheetNoteTextFieldWrap");
            textInputLayout5.setHint(getString(R.string.note_placeholder_mobile));
            TextInputLayout textInputLayout6 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout6, "binding.userSheetNoteTextFieldWrap");
            textInputLayout6.setEnabled(true);
        }
        if (viewState.getUserNote() != null) {
            TextInputLayout textInputLayout7 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout7, "binding.userSheetNoteTextFieldWrap");
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
        FrameLayout frameLayout = getBinding().G;
        m.checkNotNullExpressionValue(frameLayout, "binding.userSheetProfileAddToServerContainer");
        frameLayout.setVisibility(ApplicationUtils.INSTANCE.canInstallApplication(userProfile != null ? userProfile.getApplication() : null) ? 0 : 8);
        getBinding().F.setOnClickListener(new AnonymousClass1(userProfile));
        FlexboxLayout flexboxLayout = getBinding().I;
        m.checkNotNullExpressionValue(flexboxLayout, "binding.userSheetProfileEditContainer");
        flexboxLayout.setVisibility(zIsMe ? 0 : 8);
        getBinding().H.setOnClickListener(new AnonymousClass2());
        MaterialButton materialButton = getBinding().K;
        m.checkNotNullExpressionValue(materialButton, "binding.userSheetProfileIdentityButton");
        if (zIsMe) {
            if ((currentGuildId != null ? currentGuildId.longValue() : 0L) > 0) {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        materialButton.setVisibility(z2 ? 0 : 8);
        getBinding().K.setOnClickListener(new AnonymousClass3(currentGuildId));
        boolean isBot = viewState.getUser().getIsBot();
        boolean isSystemUser = viewState.getUser().getIsSystemUser();
        int userRelationshipType = viewState.getUserRelationshipType();
        boolean z3 = (zIsMe || isSystemUser) ? false : true;
        View view = getBinding().E;
        m.checkNotNullExpressionValue(view, "binding.userSheetProfileActionsDivider");
        view.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout = getBinding().D;
        m.checkNotNullExpressionValue(linearLayout, "binding.userSheetProfileActionsContainer");
        linearLayout.setVisibility(z3 ? 0 : 8);
        if (z3) {
            Button button = getBinding().f2695x;
            m.checkNotNullExpressionValue(button, "binding.userSheetMessageActionButton");
            Channel channel = viewState.getChannel();
            button.setVisibility(channel == null || channel.getType() != 1 ? 0 : 8);
            getBinding().f2695x.setOnClickListener(new AnonymousClass4(viewState));
            getBinding().l.setOnClickListener(new AnonymousClass5());
            getBinding().Q.setOnClickListener(new AnonymousClass6());
            if (userRelationshipType == 0) {
                Button button2 = getBinding().i;
                m.checkNotNullExpressionValue(button2, "binding.userSheetAddFriendActionButton");
                button2.setVisibility(0);
                Button button3 = getBinding().C;
                m.checkNotNullExpressionValue(button3, "binding.userSheetPendingFriendRequestActionButton");
                button3.setVisibility(8);
            } else if (userRelationshipType == 3 || userRelationshipType == 4) {
                Button button4 = getBinding().i;
                m.checkNotNullExpressionValue(button4, "binding.userSheetAddFriendActionButton");
                button4.setVisibility(8);
                Button button5 = getBinding().C;
                m.checkNotNullExpressionValue(button5, "binding.userSheetPendingFriendRequestActionButton");
                button5.setVisibility(0);
            } else {
                Button button6 = getBinding().i;
                m.checkNotNullExpressionValue(button6, "binding.userSheetAddFriendActionButton");
                button6.setVisibility(8);
                Button button7 = getBinding().C;
                m.checkNotNullExpressionValue(button7, "binding.userSheetPendingFriendRequestActionButton");
                button7.setVisibility(8);
            }
            boolean z4 = (zIsMe || isBot || userRelationshipType != 0) ? false : true;
            Button button8 = getBinding().i;
            m.checkNotNullExpressionValue(button8, "binding.userSheetAddFriendActionButton");
            button8.setVisibility(z4 ? 0 : 8);
            getBinding().i.setOnClickListener(new AnonymousClass7(viewState));
            getBinding().C.setOnClickListener(new AnonymousClass8(userRelationshipType, viewState));
        }
    }

    private final void configureStageActionsSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        getBinding().M.updateView(viewState.getStageViewState());
        CardView cardView = getBinding().L;
        m.checkNotNullExpressionValue(cardView, "binding.userSheetProfileStageActionsCard");
        UserProfileStageActionsView userProfileStageActionsView = getBinding().M;
        m.checkNotNullExpressionValue(userProfileStageActionsView, "binding.userSheetProfileStageActionsView");
        cardView.setVisibility(userProfileStageActionsView.getVisibility() == 0 ? 0 : 8);
    }

    private final void configureUI(WidgetUserSheetViewModel.ViewState model) {
        if (model instanceof WidgetUserSheetViewModel.ViewState.Uninitialized) {
            FrameLayout frameLayout = getBinding().w;
            m.checkNotNullExpressionValue(frameLayout, "binding.userSheetLoadingContainer");
            frameLayout.setVisibility(0);
            return;
        }
        if (!(model instanceof WidgetUserSheetViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        FrameLayout frameLayout2 = getBinding().w;
        m.checkNotNullExpressionValue(frameLayout2, "binding.userSheetLoadingContainer");
        frameLayout2.setVisibility(8);
        WidgetUserSheetViewModel.ViewState.Loaded loaded = (WidgetUserSheetViewModel.ViewState.Loaded) model;
        Presence presence = loaded.getPresence();
        Activity primaryActivity = presence != null ? PresenceUtils.INSTANCE.getPrimaryActivity(presence) : null;
        boolean zIsMe = loaded.isMe();
        boolean isSystemUser = loaded.getUser().getIsSystemUser();
        if (!getViewModel().getOpenPopoutLogged() && loaded.getProfileLoaded()) {
            AnalyticsTracker.INSTANCE.openUserSheet(loaded.getHasPremiumCustomization(), primaryActivity != null ? primaryActivity.getName() : null, primaryActivity != null ? ActivityUtilsKt.getGamePlatform(primaryActivity) : null, loaded.getGuildMember());
            getViewModel().setOpenPopoutLogged(true);
        }
        getBinding().J.setOnBannerPress(new AnonymousClass1());
        ImageView imageView = getBinding().f2696y;
        m.checkNotNullExpressionValue(imageView, "binding.userSheetMoreButton");
        imageView.setVisibility((zIsMe || isSystemUser) ? false : true ? 0 : 8);
        if (loaded.getConnectionsViewState().getShowConnectionsSection()) {
            setPeekHeightBottomView(getBinding().m);
        }
        ViewHolderUserRichPresence.Companion companion = ViewHolderUserRichPresence.INSTANCE;
        FrameLayout frameLayout3 = getBinding().h;
        m.checkNotNullExpressionValue(frameLayout3, "binding.richPresenceContainer");
        ViewHolderUserRichPresence richPresence = companion.setRichPresence(frameLayout3, primaryActivity, loaded.getStreamContext(), this.activityViewHolder);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        StreamContext streamContext = loaded.getStreamContext();
        boolean zIsMe2 = loaded.isMe();
        User user = loaded.getUser();
        Context applicationContext = requireAppActivity().getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "requireAppActivity().applicationContext");
        richPresence.configureUi(parentFragmentManager, streamContext, zIsMe2, user, applicationContext, loaded.getRichPresence(), loaded.getUserInSameVoiceChannel());
        richPresence.configureUiTimestamp(primaryActivity, this);
        this.activityViewHolder = richPresence;
        ViewHolderStreamRichPresence viewHolderStreamRichPresence = (ViewHolderStreamRichPresence) (richPresence instanceof ViewHolderStreamRichPresence ? richPresence : null);
        if (loaded.getStreamContext() != null && viewHolderStreamRichPresence != null) {
            viewHolderStreamRichPresence.setOnStreamPreviewClicked(new AnonymousClass3(model));
        }
        ViewHolderUserRichPresence viewHolderUserRichPresence = this.activityViewHolder;
        if (viewHolderUserRichPresence != null) {
            viewHolderUserRichPresence.setOnActivityCustomButtonClicked(new AnonymousClass4(getViewModel()));
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
        TextView textView = getBinding().N;
        m.checkNotNullExpressionValue(textView, "binding.userSheetProfileVoiceSettingsHeader");
        textView.setVisibility(showVoiceSettings ? 0 : 8);
        CardView cardView = getBinding().R;
        m.checkNotNullExpressionValue(cardView, "binding.voiceSettingsViewCard");
        cardView.setVisibility(showVoiceSettings ? 0 : 8);
        getBinding().O.updateView(voiceSettingsViewState);
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
        m.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.a;
        m.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
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
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
            b.a.d.m.i(this, R.string.user_profile_failure_to_open_message, 0, 4);
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
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(username, guildId, userId, parentFragmentManager);
    }

    private final void handleLaunchEditMember(WidgetUserSheetViewModel.Event.LaunchEditMember event) {
        WidgetServerSettingsEditMember.Companion companion = WidgetServerSettingsEditMember.INSTANCE;
        long guildId = event.getGuildId();
        long userId = event.getUserId();
        WidgetUserSheetBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.a;
        m.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        companion.launch(guildId, userId, context);
    }

    private final void handleLaunchSpectate(WidgetUserSheetViewModel.Event.LaunchSpectate event) {
        WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetCallFullscreen.Companion.launch$default(companion, contextRequireContext, event.getStream().getChannelId(), false, event.getStream().getEncodedStreamKey(), null, 20, null);
        dismiss();
    }

    private final void handleLaunchVideoCall(WidgetUserSheetViewModel.Event.LaunchVideoCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVideoCall(event.getChannelId());
    }

    private final void handleLaunchVoiceCall(WidgetUserSheetViewModel.Event.LaunchVoiceCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleMoveUser(WidgetUserSheetViewModel.Event.LaunchMoveUser event) {
        WidgetChannelSelector.Companion.launchForVocal$default(WidgetChannelSelector.INSTANCE, this, event.getGuildId(), REQUEST_KEY_MOVE_USER, false, 0, 24, null);
    }

    private final void handleRequestPermissionsForSpectateStream(WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream event) {
        d.S1(this, null, new AnonymousClass1(event), 1, null);
    }

    private final void handleShowFriendRequestErrorToast(WidgetUserSheetViewModel.Event.ShowFriendRequestErrorToast event) {
        b.a.d.m.j(this, RestAPIAbortMessages.ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(WidgetUserSheetViewModel.Event.ShowToast event) {
        b.a.d.m.i(this, event.getStringRes(), 0, 4);
    }

    private final void ignoreFriendRequest() {
        getViewModel().removeRelationship(R.string.friend_request_ignored);
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
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetUserSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().J;
        m.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSheetProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_user_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        hideKeyboard(getBinding().B);
        WidgetUserSheetViewModel viewModel = getViewModel();
        Context context = getContext();
        TextInputLayout textInputLayout = getBinding().B;
        m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
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
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        boolean z2 = j == StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
        getBinding().f2696y.setOnClickListener(new AnonymousClass1(j));
        UserProfileHeaderView userProfileHeaderView = getBinding().J;
        Badge.Companion companion = Badge.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        userProfileHeaderView.setOnBadgeClick(companion.onBadgeClick(parentFragmentManager, contextRequireContext));
        getBinding().M.setOnInviteToSpeak(new AnonymousClass2(z2));
        getBinding().M.setOnMoveToAudience(new AnonymousClass3());
        getBinding().O.setOnMuteChecked(new AnonymousClass4());
        getBinding().O.setOnDeafenChecked(new AnonymousClass5());
        getBinding().O.setOnVolumeChange(new AnonymousClass6());
        getBinding().k.setOnEditMember(new AnonymousClass7());
        getBinding().k.setOnKick(new AnonymousClass8());
        getBinding().k.setOnBan(new AnonymousClass9());
        getBinding().k.setOnDisableCommunication(new AnonymousClass10());
        getBinding().k.setOnServerMute(new AnonymousClass11());
        getBinding().k.setOnServerDeafen(new AnonymousClass12());
        getBinding().k.setOnServerMove(new AnonymousClass13());
        getBinding().k.setOnDisconnect(new AnonymousClass14());
        TextInputLayout textInputLayout = getBinding().B;
        m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new AnonymousClass15());
        TextInputLayout textInputLayout2 = getBinding().B;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new AnonymousClass16(view), 1, null);
        ViewCompat.setAccessibilityDelegate(getBinding().f2696y, new AnonymousClass17());
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().m, getBinding().u, getBinding().f2697z, getBinding().p, getBinding().v, getBinding().N})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
        WidgetChannelSelector.Companion.registerForResult$default(WidgetChannelSelector.INSTANCE, this, REQUEST_KEY_MOVE_USER, false, new AnonymousClass18(), 4, null);
    }
}
