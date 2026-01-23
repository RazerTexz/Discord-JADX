package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelsListItemChannelActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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

    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canCreateInstantInvite;
        private final boolean canManageChannel;
        private final Channel channel;
        private final Guild guild;
        private final boolean isDeveloper;
        private final boolean isMuted;
        private final Long permissions;

        /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new WidgetChannelsListItemChannelActions$Model$Companion$get$1(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream.getChannels(…        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream.getChannels(…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, Long l, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
            this.isMuted = z2;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
            this.canManageChannel = PermissionUtils.can(16L, l) || ChannelUtils.m7702z(channel);
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        public final Model copy(Channel channel, Guild guild, Long permissions, boolean isMuted) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            return Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.permissions, model.permissions) && this.isMuted == model.isMuted;
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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return (this.isMuted && ChannelUtils.m7687k(channel)) ? FormatUtils.m216h(context, C5419R.string.unmute_category, new Object[0], null, 4) : (this.isMuted || !ChannelUtils.m7687k(channel)) ? this.isMuted ? FormatUtils.m216h(context, C5419R.string.unmute_channel_generic, new Object[0], null, 4) : FormatUtils.m216h(context, C5419R.string.mute_channel_generic, new Object[0], null, 4) : FormatUtils.m216h(context, C5419R.string.mute_category, new Object[0], null, 4);
        }

        public final int getMuteIconResId(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, this.isMuted ? C5419R.attr.ic_channel_muted : C5419R.attr.ic_channel_mute, 0, 2, (Object) null);
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z2 = this.isMuted;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        /* JADX INFO: renamed from: isDeveloper, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", permissions=");
            sbM833U.append(this.permissions);
            sbM833U.append(", isMuted=");
            return outline.m827O(sbM833U, this.isMuted, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final class C74521 extends Lambda implements Function1<Model, Unit> {
        public C74521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelsListItemChannelActions.access$configureUI(WidgetChannelsListItemChannelActions.this, model);
        }
    }

    public WidgetChannelsListItemChannelActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelsListItemChannelActions$binding$2.INSTANCE, null, 2, null);
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
            SimpleDraweeView simpleDraweeView = getBinding().f15989f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f15989f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().f15990g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListItemTextActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.m7681e(channel, contextRequireContext, false, 2));
        User userM7677a = ChannelUtils.m7677a(model.getChannel());
        TextView textView2 = getBinding().f15992i;
        boolean z2 = true;
        textView2.setVisibility(userM7677a != null ? 0 : 8);
        textView2.setOnClickListener(new ViewOnClickListenerC7453x3de54558(this, userM7677a));
        TextView textView3 = getBinding().f15988e;
        textView3.setVisibility(model.getCanCreateInstantInvite() ? 0 : 8);
        setOnClickAndDismissListener(textView3, new C7454x3de54559(textView3, this, model));
        TextView textView4 = getBinding().f15994k;
        textView4.setVisibility(ChannelUtils.m7671F(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) ? 0 : 8);
        setOnClickAndDismissListener(textView4, new C7455x3de5455a(textView4, this, model));
        Context context = textView4.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView4.setCompoundDrawablesWithIntrinsicBounds(model.getMuteIconResId(context), 0, 0, 0);
        Context context2 = textView4.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        textView4.setText(model.getMuteChannelText(context2, model.getChannel()));
        TextView textView5 = getBinding().f15995l;
        textView5.setVisibility(ThreadUtils.INSTANCE.isThreadsEnabled(model.getChannel().getGuildId()) && ChannelUtils.m7674I(model.getChannel()) && !ChannelUtils.m7693q(model.getChannel()) && !model.getChannel().getNsfw() ? 0 : 8);
        setOnClickAndDismissListener(textView5, new C7456x3de5455b(textView5, this, model));
        TextView textView6 = getBinding().f15986c;
        textView6.setVisibility(model.getCanManageChannel() ? 0 : 8);
        setOnClickAndDismissListener(textView6, new C7457x3de5455c(this, model));
        textView6.setText(getSettingsText(model.getChannel(), model.getCanManageChannel()));
        TextView textView7 = getBinding().f15985b;
        textView7.setVisibility(ChannelUtils.m7698v(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) || (ChannelUtils.m7669D(model.getChannel()) && (guild = model.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY)) ? 0 : 8);
        textView7.setOnClickListener(new ViewOnClickListenerC7458x3de5455d(model));
        View view = getBinding().f15993j;
        if (!ChannelUtils.m7671F(model.getChannel()) && !ChannelUtils.m7687k(model.getChannel())) {
            z2 = false;
        }
        view.setVisibility(z2 ? 0 : 8);
        setOnClickAndDismissListener(view, new C7459x3de5455e(this, model));
        View view2 = getBinding().f15991h;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.developerDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        View view3 = getBinding().f15987d;
        view3.setVisibility(model.getIsDeveloper() ? 0 : 8);
        setOnClickAndDismissListener(view3, new C7460x3de5455f(this, model));
    }

    private final WidgetChannelsListItemActionsBinding getBinding() {
        return (WidgetChannelsListItemActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSettingsText(Channel channel, boolean z2) {
        String string = getString(ChannelUtils.m7687k(channel) ? C5419R.string.edit_category : z2 ? C5419R.string.edit_channel : !z2 ? C5419R.string.channel_settings : C5419R.string.sample_empty_string);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(\n      when {\n…_empty_string\n      }\n  )");
        return string;
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetChannelsListItemChannelActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C74521(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channels_list_item_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
