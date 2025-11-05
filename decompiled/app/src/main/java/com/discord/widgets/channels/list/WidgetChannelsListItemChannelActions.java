package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemActionsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelsListItemChannelActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions = new WidgetChannelsListItemChannelActions();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChannelsListItemChannelActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            widgetChannelsListItemChannelActions.setArguments(bundle);
            widgetChannelsListItemChannelActions.show(fragmentManager, WidgetChannelsListItemChannelActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canCreateInstantInvite;
        private final boolean canManageChannel;
        private final Channel channel;
        private final Guild guild;
        private final boolean isDeveloper;
        private final boolean isMuted;
        private final Long permissions;

        /* compiled from: WidgetChannelsListItemChannelActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new WidgetChannelsListItemChannelActions$Model$Companion$get$1(channelId));
                m.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                m.checkNotNullExpressionValue(observableR, "StoreStream.getChannels(…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, Long l, boolean z2) {
            m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
            this.isMuted = z2;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
            this.canManageChannel = PermissionUtils.can(16L, l) || ChannelUtils.z(channel);
            this.canCreateInstantInvite = PermissionUtils.can(1L, l);
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, Guild guild, Long l, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = model.channel;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                l = model.permissions;
            }
            if ((i & 8) != 0) {
                z2 = model.isMuted;
            }
            return model.copy(channel, guild, l, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        public final Model copy(Channel channel, Guild guild, Long permissions, boolean isMuted) {
            m.checkNotNullParameter(channel, "channel");
            return new Model(channel, guild, permissions, isMuted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.channel, model.channel) && m.areEqual(this.guild, model.guild) && m.areEqual(this.permissions, model.permissions) && this.isMuted == model.isMuted;
        }

        public final boolean getCanCreateInstantInvite() {
            return this.canCreateInstantInvite;
        }

        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final CharSequence getMuteChannelText(Context context, Channel channel) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(channel, "channel");
            return (this.isMuted && ChannelUtils.k(channel)) ? b.h(context, R.string.unmute_category, new Object[0], null, 4) : (this.isMuted || !ChannelUtils.k(channel)) ? this.isMuted ? b.h(context, R.string.unmute_channel_generic, new Object[0], null, 4) : b.h(context, R.string.mute_channel_generic, new Object[0], null, 4) : b.h(context, R.string.mute_category, new Object[0], null, 4);
        }

        public final int getMuteIconResId(Context context) {
            m.checkNotNullParameter(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, this.isMuted ? R.attr.ic_channel_muted : R.attr.ic_channel_mute, 0, 2, (Object) null);
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z2 = this.isMuted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        /* renamed from: isDeveloper, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", isMuted=");
            return a.O(sbU, this.isMuted, ")");
        }
    }

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelsListItemChannelActions.access$configureUI(WidgetChannelsListItemChannelActions.this, model);
        }
    }

    public WidgetChannelsListItemChannelActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelsListItemChannelActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, Model model) {
        widgetChannelsListItemChannelActions.configureUI(model);
    }

    private final void configureUI(Model model) {
        Guild guild;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.channelsListItemTextActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        User userA = ChannelUtils.a(model.getChannel());
        TextView textView2 = getBinding().i;
        boolean z2 = true;
        textView2.setVisibility(userA != null ? 0 : 8);
        textView2.setOnClickListener(new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$1(this, userA));
        TextView textView3 = getBinding().e;
        textView3.setVisibility(model.getCanCreateInstantInvite() ? 0 : 8);
        setOnClickAndDismissListener(textView3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$2(textView3, this, model));
        TextView textView4 = getBinding().k;
        textView4.setVisibility(ChannelUtils.F(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        setOnClickAndDismissListener(textView4, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$3(textView4, this, model));
        Context context = textView4.getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView4.setCompoundDrawablesWithIntrinsicBounds(model.getMuteIconResId(context), 0, 0, 0);
        Context context2 = textView4.getContext();
        m.checkNotNullExpressionValue(context2, "context");
        textView4.setText(model.getMuteChannelText(context2, model.getChannel()));
        TextView textView5 = getBinding().l;
        textView5.setVisibility(ThreadUtils.INSTANCE.isThreadsEnabled(model.getChannel().getGuildId()) && ChannelUtils.I(model.getChannel()) && !ChannelUtils.q(model.getChannel()) && !model.getChannel().getNsfw() ? 0 : 8);
        setOnClickAndDismissListener(textView5, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$4(textView5, this, model));
        TextView textView6 = getBinding().c;
        textView6.setVisibility(model.getCanManageChannel() ? 0 : 8);
        setOnClickAndDismissListener(textView6, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$5(this, model));
        textView6.setText(getSettingsText(model.getChannel(), model.getCanManageChannel()));
        TextView textView7 = getBinding().f2283b;
        textView7.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) || (ChannelUtils.D(model.getChannel()) && (guild = model.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY)) ? 0 : 8);
        textView7.setOnClickListener(new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6(model));
        View view = getBinding().j;
        if (!ChannelUtils.F(model.getChannel()) && !ChannelUtils.k(model.getChannel())) {
            z2 = false;
        }
        view.setVisibility(z2 ? 0 : 8);
        setOnClickAndDismissListener(view, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$7(this, model));
        View view2 = getBinding().h;
        m.checkNotNullExpressionValue(view2, "binding.developerDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        View view3 = getBinding().d;
        view3.setVisibility(model.getIsDeveloper() ? 0 : 8);
        setOnClickAndDismissListener(view3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$8(this, model));
    }

    private final WidgetChannelsListItemActionsBinding getBinding() {
        return (WidgetChannelsListItemActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSettingsText(Channel channel, boolean z2) {
        String string = getString(ChannelUtils.k(channel) ? R.string.edit_category : z2 ? R.string.edit_channel : !z2 ? R.string.channel_settings : R.string.sample_empty_string);
        m.checkNotNullExpressionValue(string, "getString(\n      when {\n…_empty_string\n      }\n  )");
        return string;
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetChannelsListItemChannelActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channels_list_item_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
