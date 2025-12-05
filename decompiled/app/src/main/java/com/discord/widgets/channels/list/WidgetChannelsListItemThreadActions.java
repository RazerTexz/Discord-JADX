package com.discord.widgets.channels.list;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemThreadActionsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetThreadArchiveActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetChannelsListItemThreadActions.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelsListItemThreadActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions = new WidgetChannelsListItemThreadActions();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChannelsListItemThreadActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            widgetChannelsListItemThreadActions.setArguments(bundle);
            widgetChannelsListItemThreadActions.show(fragmentManager, WidgetChannelsListItemThreadActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageThread;
        private final boolean canUnarchiveThread;
        private final Channel channel;
        private final Guild guild;
        private final boolean isActiveThread;
        private final boolean isDeveloper;
        private final boolean isModerator;
        private final boolean isMuted;
        private final StoreThreadsJoined.JoinedThread joinedThread;
        private final MeUser meUser;
        private final int notificationSetting;
        private final Channel parentChannel;

        /* compiled from: WidgetChannelsListItemThreadActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(WidgetChannelsListItemThreadActions2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined.JoinedThread joinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.meUser = meUser;
            this.channel = channel;
            this.guild = guild;
            this.parentChannel = channel2;
            this.notificationSetting = i;
            this.joinedThread = joinedThread;
            this.isActiveThread = z2;
            this.isModerator = z3;
            this.canManageThread = z4;
            this.canUnarchiveThread = z5;
            this.isMuted = z6;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined.JoinedThread joinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
            return model.copy((i2 & 1) != 0 ? model.meUser : meUser, (i2 & 2) != 0 ? model.channel : channel, (i2 & 4) != 0 ? model.guild : guild, (i2 & 8) != 0 ? model.parentChannel : channel2, (i2 & 16) != 0 ? model.notificationSetting : i, (i2 & 32) != 0 ? model.joinedThread : joinedThread, (i2 & 64) != 0 ? model.isActiveThread : z2, (i2 & 128) != 0 ? model.isModerator : z3, (i2 & 256) != 0 ? model.canManageThread : z4, (i2 & 512) != 0 ? model.canUnarchiveThread : z5, (i2 & 1024) != 0 ? model.isMuted : z6);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getCanUnarchiveThread() {
            return this.canUnarchiveThread;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component4, reason: from getter */
        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* renamed from: component5, reason: from getter */
        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        /* renamed from: component6, reason: from getter */
        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsActiveThread() {
            return this.isActiveThread;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final Model copy(MeUser meUser, Channel channel, Guild guild, Channel parentChannel, int notificationSetting, StoreThreadsJoined.JoinedThread joinedThread, boolean isActiveThread, boolean isModerator, boolean canManageThread, boolean canUnarchiveThread, boolean isMuted) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(meUser, channel, guild, parentChannel, notificationSetting, joinedThread, isActiveThread, isModerator, canManageThread, canUnarchiveThread, isMuted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.meUser, model.meUser) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.parentChannel, model.parentChannel) && this.notificationSetting == model.notificationSetting && Intrinsics3.areEqual(this.joinedThread, model.joinedThread) && this.isActiveThread == model.isActiveThread && this.isModerator == model.isModerator && this.canManageThread == model.canManageThread && this.canUnarchiveThread == model.canUnarchiveThread && this.isMuted == model.isMuted;
        }

        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final boolean getCanUnarchiveThread() {
            return this.canUnarchiveThread;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel2 = this.parentChannel;
            int iHashCode4 = (((iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31) + this.notificationSetting) * 31;
            StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
            int iHashCode5 = (iHashCode4 + (joinedThread != null ? joinedThread.hashCode() : 0)) * 31;
            boolean z2 = this.isActiveThread;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            boolean z3 = this.isModerator;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canManageThread;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.canUnarchiveThread;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.isMuted;
            return i8 + (z6 ? 1 : z6 ? 1 : 0);
        }

        public final boolean isActiveThread() {
            return this.isActiveThread;
        }

        /* renamed from: isDeveloper, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", parentChannel=");
            sbM833U.append(this.parentChannel);
            sbM833U.append(", notificationSetting=");
            sbM833U.append(this.notificationSetting);
            sbM833U.append(", joinedThread=");
            sbM833U.append(this.joinedThread);
            sbM833U.append(", isActiveThread=");
            sbM833U.append(this.isActiveThread);
            sbM833U.append(", isModerator=");
            sbM833U.append(this.isModerator);
            sbM833U.append(", canManageThread=");
            sbM833U.append(this.canManageThread);
            sbM833U.append(", canUnarchiveThread=");
            sbM833U.append(this.canUnarchiveThread);
            sbM833U.append(", isMuted=");
            return outline.m827O(sbM833U, this.isMuted, ")");
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$bindSubscriptions$1 */
    public static final class C74631 extends Lambda implements Function1<Model, Unit> {
        public C74631() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            WidgetChannelsListItemThreadActions.access$configureUI(WidgetChannelsListItemThreadActions.this, model);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$1 */
    public static final class C74641 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74641(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getMessageAck().ack(this.$this_configureUI.getChannel().getId(), false, true);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$2 */
    public static final class C74652 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74652(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (this.$this_configureUI.isMuted()) {
                StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                Context contextRequireContext = WidgetChannelsListItemThreadActions.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                StoreUserGuildSettings.setChannelMuted$default(userGuildSettings, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, null, 8, null);
                return;
            }
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(id2, parentFragmentManager);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$3 */
    public static final class ViewOnClickListenerC74663 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC74663(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context contextRequireContext = WidgetChannelsListItemThreadActions.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, 4, null);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$4 */
    public static final class C74674 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74674(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadSettings.Companion companion = WidgetThreadSettings.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            companion.launch(id2, context);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$5 */
    public static final class C74685 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74685(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadArchiveActions.Companion companion = WidgetThreadArchiveActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$this_configureUI.getChannel().getId(), this.$this_configureUI.getChannel().getGuildId());
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$6 */
    public static final class ViewOnClickListenerC74696 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC74696(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelsListItemThreadActions.access$unarchiveThread(WidgetChannelsListItemThreadActions.this, this.$this_configureUI.getChannel(), this.$this_configureUI.isModerator());
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$7 */
    public static final class ViewOnClickListenerC74707 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC74707(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelsListItemThreadActions.access$leaveThread(WidgetChannelsListItemThreadActions.this, this.$this_configureUI.getChannel());
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$8 */
    public static final class C74718 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74718(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppToast.m165c(context, String.valueOf(this.$this_configureUI.getChannel().getId()), 0, 4);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$leaveThread$1 */
    public static final class C74721 extends Lambda implements Function1<Void, Unit> {
        public C74721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$1 */
    public static final class C74731 extends Lambda implements Function1<Error, Unit> {
        public C74731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
            AppToast.m169g(WidgetChannelsListItemThreadActions.this.getContext(), abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : C5419R.string.network_error_bad_request, 0, null, 12);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$2 */
    public static final class C74742 extends Lambda implements Function1<Channel, Unit> {
        public C74742() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    public WidgetChannelsListItemThreadActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelsListItemThreadActions3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Model model) throws Resources.NotFoundException {
        widgetChannelsListItemThreadActions.configureUI(model);
    }

    public static final /* synthetic */ void access$leaveThread(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Channel channel) {
        widgetChannelsListItemThreadActions.leaveThread(channel);
    }

    public static final /* synthetic */ void access$unarchiveThread(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Channel channel, boolean z2) {
        widgetChannelsListItemThreadActions.unarchiveThread(channel, z2);
    }

    private final void configureUI(Model model) throws Resources.NotFoundException {
        ThreadMetadata threadMetadata;
        ThreadMetadata threadMetadata2;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f16062i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f16062i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().f16066m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListItemThreadActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.m7681e(channel, contextRequireContext, false, 2));
        TextView textView2 = getBinding().f16064k;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelsListItemThreadActionsMarkAsRead");
        setOnClickAndDismissListener(textView2, new C74641(model));
        TextView textView3 = getBinding().f16065l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelsListItemThreadActionsMute");
        Channel channel2 = model.getChannel();
        boolean zIsMuted = model.isMuted();
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        textView3.setText(getMuteThreadText(channel2, zIsMuted, contextRequireContext2));
        TextView textView4 = getBinding().f16065l;
        boolean zIsMuted2 = model.isMuted();
        Context contextRequireContext3 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
        textView4.setCompoundDrawablesWithIntrinsicBounds(getMuteIconResId(zIsMuted2, contextRequireContext3), 0, 0, 0);
        TextView textView5 = getBinding().f16065l;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.channelsListItemThreadActionsMute");
        setOnClickAndDismissListener(textView5, new C74652(model));
        getBinding().f16057d.setOnClickListener(new ViewOnClickListenerC74663(model));
        View view = getBinding().f16060g;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelsListItemThreadActionsDivider");
        view.setVisibility(model.isActiveThread() ? 0 : 8);
        TextView textView6 = getBinding().f16061h;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.channelsListItemThreadActionsEdit");
        textView6.setVisibility(model.getCanManageThread() ? 0 : 8);
        TextView textView7 = getBinding().f16061h;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelsListItemThreadActionsEdit");
        setOnClickAndDismissListener(textView7, new C74674(model));
        boolean z2 = model.getCanManageThread() && ((threadMetadata2 = model.getChannel().getThreadMetadata()) == null || !threadMetadata2.getArchived());
        LinearLayout linearLayout = getBinding().f16055b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelsListItem…eadActionsArchiveSettings");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Context contextRequireContext4 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
            ThreadMetadata threadMetadata3 = model.getChannel().getThreadMetadata();
            Intrinsics3.checkNotNull(threadMetadata3);
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(contextRequireContext4, threadMetadata3.getAutoArchiveDuration());
            TextView textView8 = getBinding().f16056c;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.channelsListItem…sArchiveSettingsSubheader");
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            textView8.setText(FormatUtils.m219k(this, C5419R.string.auto_archive_thread_after, new Object[]{lowerCase}, null, 4));
        }
        LinearLayout linearLayout2 = getBinding().f16055b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelsListItem…eadActionsArchiveSettings");
        setOnClickAndDismissListener(linearLayout2, new C74685(model));
        TextView textView9 = getBinding().f16067n;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.channelsListItemThreadActionsUnarchive");
        textView9.setVisibility(model.getCanUnarchiveThread() && (threadMetadata = model.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() ? 0 : 8);
        getBinding().f16067n.setOnClickListener(new ViewOnClickListenerC74696(model));
        TextView textView10 = getBinding().f16063j;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.channelsListItemThreadActionsLeave");
        textView10.setVisibility(model.getJoinedThread() != null ? 0 : 8);
        getBinding().f16063j.setOnClickListener(new ViewOnClickListenerC74707(model));
        View view2 = getBinding().f16059f;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.channelsListItem…adActionsDeveloperDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView11 = getBinding().f16058e;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.channelsListItemThreadActionsCopyId");
        textView11.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView12 = getBinding().f16058e;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.channelsListItemThreadActionsCopyId");
        setOnClickAndDismissListener(textView12, new C74718(model));
    }

    private final WidgetChannelsListItemThreadActionsBinding getBinding() {
        return (WidgetChannelsListItemThreadActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getMuteIconResId(boolean isMuted, Context context) {
        return DrawableCompat.getThemedDrawableRes$default(context, isMuted ? C5419R.attr.ic_channel_muted : C5419R.attr.ic_channel_mute, 0, 2, (Object) null);
    }

    private final CharSequence getMuteThreadText(Channel channel, boolean isMuted, Context context) {
        return isMuted ? FormatUtils.m216h(context, C5419R.string.unmute, new Object[0], null, 4) : FormatUtils.m216h(context, C5419R.string.mute_channel, new Object[]{ChannelUtils.m7681e(channel, context, false, 2)}, null, 4);
    }

    private final void leaveThread(Channel channel) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channel.getId(), "Context Menu"), false, 1, null), this, null, 2, null), getContext(), "REST: leaveThread", (Function1) null, new C74721(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    private final void unarchiveThread(Channel channel, boolean unlockThread) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.FALSE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, unlockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), getContext(), "REST: unarchiveThread", (Function1) null, new C74742(), new C74731(), (Function0) null, (Function0) null, 100, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetChannelsListItemThreadActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C74631(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channels_list_item_thread_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
