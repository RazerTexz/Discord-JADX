package com.discord.widgets.channels.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.databinding.WidgetChannelsListItemActiveEventBinding;
import com.discord.databinding.WidgetChannelsListItemAudienceCountBinding;
import com.discord.databinding.WidgetChannelsListItemCategoryBinding;
import com.discord.databinding.WidgetChannelsListItemChannelBinding;
import com.discord.databinding.WidgetChannelsListItemChannelPrivateBinding;
import com.discord.databinding.WidgetChannelsListItemChannelStageVoiceBinding;
import com.discord.databinding.WidgetChannelsListItemChannelVoiceBinding;
import com.discord.databinding.WidgetChannelsListItemDirectoryBinding;
import com.discord.databinding.WidgetChannelsListItemGuildJoinRequestBinding;
import com.discord.databinding.WidgetChannelsListItemGuildRoleSubsBinding;
import com.discord.databinding.WidgetChannelsListItemGuildScheduledEventsBinding;
import com.discord.databinding.WidgetChannelsListItemHeaderBinding;
import com.discord.databinding.WidgetChannelsListItemMfaBinding;
import com.discord.databinding.WidgetChannelsListItemThreadBinding;
import com.discord.databinding.WidgetChannelsListItemVoiceUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.views.VoiceUserLimitView;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListBottomNavSpaceItem;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEventData;
import com.discord.widgets.channels.list.items.ChannelListItemAddServer;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import com.discord.widgets.channels.list.items.ChannelListItemDirectory;
import com.discord.widgets.channels.list.items.ChannelListItemGuildJoinRequest;
import com.discord.widgets.channels.list.items.ChannelListItemGuildScheduledEvents;
import com.discord.widgets.channels.list.items.ChannelListItemHeader;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;
import com.discord.widgets.channels.list.items.ChannelListItemStageAudienceCount;
import com.discord.widgets.channels.list.items.ChannelListItemStageVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemTextChannel;
import com.discord.widgets.channels.list.items.ChannelListItemThread;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import com.discord.widgets.channels.list.items.ChannelListVocalItem;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter extends MGRecyclerAdapterSimple<ChannelListItem> {
    private int bottomNavHeight;
    private final FragmentManager fragmentManager;
    private Function0<Unit> onAddServer;
    private Function1<? super Channel, Unit> onCallChannel;
    private Function2<? super Channel, ? super Boolean, Unit> onCollapseCategory;
    private Function1<? super Channel, Unit> onSelectChannel;
    private Function1<? super Channel, Unit> onSelectChannelOptions;
    private Function1<? super Channel, Unit> onSelectGuildRoleSubscriptionLockedChannel;
    private Function1<? super View, Unit> onSelectInvite;
    private Function2<? super User, ? super Channel, Unit> onSelectUserOptions;
    private Function0<Unit> onViewGuildRoleSubscriptions;
    private Function1<? super Guild, Unit> onViewGuildScheduledEvents;
    private long selectedGuildId;

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static abstract class Item extends MGRecyclerViewHolder<WidgetChannelsListAdapter, ChannelListItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(@LayoutRes int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        }

        public final void setBackground(View view, boolean z2, Channel channel) {
            int themedDrawableRes$default;
            m.checkNotNullParameter(view, "$this$setBackground");
            m.checkNotNullParameter(channel, "channel");
            if (!z2 || ChannelUtils.w(channel)) {
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "context");
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.drawable_overlay_channels, 0, 2, (Object) null);
            } else {
                Context context2 = view.getContext();
                m.checkNotNullExpressionValue(context2, "context");
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context2, R.attr.drawable_overlay_channels_selected, 0, 2, (Object) null);
            }
            ViewExtensions.setBackgroundAndKeepPadding(view, ContextCompat.getDrawable(view.getContext(), themedDrawableRes$default));
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelAddServer extends Item {
        private final WidgetChannelsListItemDirectoryBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelAddServer(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            WidgetChannelsListItemDirectoryBinding widgetChannelsListItemDirectoryBindingA = WidgetChannelsListItemDirectoryBinding.a(this.itemView);
            m.checkNotNullExpressionValue(widgetChannelsListItemDirectoryBindingA, "WidgetChannelsListItemDi…oryBinding.bind(itemView)");
            this.binding = widgetChannelsListItemDirectoryBindingA;
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelAddServer itemChannelAddServer) {
            return (WidgetChannelsListAdapter) itemChannelAddServer.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data instanceof ChannelListItemAddServer) {
                this.binding.c.setText(R.string.hub_sidebar_add_servers);
                this.binding.f2291b.setImageResource(R.drawable.ic_add_24dp);
                this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelAddServer$onConfigure$$inlined$apply$lambda$1(this));
            }
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelCategory extends Item {
        private static final long ANIMATION_DURATION = 300;
        private static final RotateAnimation ARROW_ANIM_COLLAPSE;
        private static final RotateAnimation ARROW_ANIM_EXPAND;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final WidgetChannelsListItemCategoryBinding binding;
        private boolean isCollapsed;

        /* compiled from: WidgetChannelsListAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ RotateAnimation access$getAnimation(Companion companion, boolean z2) {
                return companion.getAnimation(z2);
            }

            public static final /* synthetic */ int access$getArrowDrawable(Companion companion, ChannelListItemCategory channelListItemCategory) {
                return companion.getArrowDrawable(channelListItemCategory);
            }

            public static final /* synthetic */ int access$getChannelColor(Companion companion, ChannelListItemCategory channelListItemCategory, Context context) {
                return companion.getChannelColor(channelListItemCategory, context);
            }

            private final RotateAnimation getAnimation(boolean expand) {
                RotateAnimation rotateAnimation = new RotateAnimation(expand ? -90.0f : 90.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                rotateAnimation.setDuration(300L);
                return rotateAnimation;
            }

            @DrawableRes
            private final int getArrowDrawable(ChannelListItemCategory channelListItemCategory) {
                if (channelListItemCategory.isCollapsed()) {
                    return R.drawable.ic_chevron_right_grey_12dp;
                }
                if (channelListItemCategory.isCollapsed()) {
                    return 0;
                }
                return R.drawable.ic_chevron_down_grey_12dp;
            }

            @ColorInt
            private final int getChannelColor(ChannelListItemCategory channelListItemCategory, Context context) {
                return channelListItemCategory.isMuted() ? ColorCompat.getThemedColor(context, R.attr.colorInteractiveMuted) : ColorCompat.getThemedColor(context, R.attr.colorChannelDefault);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            Companion companion = new Companion(null);
            INSTANCE = companion;
            ARROW_ANIM_EXPAND = Companion.access$getAnimation(companion, true);
            ARROW_ANIM_COLLAPSE = Companion.access$getAnimation(companion, false);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelCategory(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_item_category_add;
            ImageView imageView = (ImageView) view.findViewById(R.id.channels_item_category_add);
            if (imageView != null) {
                i2 = R.id.channels_item_category_arrow;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.channels_item_category_arrow);
                if (imageView2 != null) {
                    i2 = R.id.channels_item_category_name;
                    TextView textView = (TextView) view.findViewById(R.id.channels_item_category_name);
                    if (textView != null) {
                        WidgetChannelsListItemCategoryBinding widgetChannelsListItemCategoryBinding = new WidgetChannelsListItemCategoryBinding((LinearLayout) view, imageView, imageView2, textView);
                        m.checkNotNullExpressionValue(widgetChannelsListItemCategoryBinding, "WidgetChannelsListItemCa…oryBinding.bind(itemView)");
                        this.binding = widgetChannelsListItemCategoryBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelCategory itemChannelCategory) {
            return (WidgetChannelsListAdapter) itemChannelCategory.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemCategory channelListItemCategory = (ChannelListItemCategory) data;
            LinearLayout linearLayout = this.binding.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(linearLayout, new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$1(this, data));
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$2(this, data));
            TextView textView = this.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.channelsItemCategoryName");
            textView.setText(ChannelUtils.c(channelListItemCategory.getChannel()));
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.channelsItemCategoryName");
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.channelsItemCategoryName");
            Object[] objArr = new Object[2];
            objArr[0] = ChannelUtils.c(channelListItemCategory.getChannel());
            TextView textView4 = this.binding.d;
            m.checkNotNullExpressionValue(textView4, "binding.channelsItemCategoryName");
            objArr[1] = b.j(textView4, channelListItemCategory.isCollapsed() ? R.string.collapsed : R.string.expanded, new Object[0], null, 4);
            textView2.setContentDescription(b.j(textView3, R.string.category_a11y_label_with_expanded_state, objArr, null, 4));
            Companion companion = INSTANCE;
            TextView textView5 = this.binding.d;
            m.checkNotNullExpressionValue(textView5, "binding.channelsItemCategoryName");
            Context context = textView5.getContext();
            m.checkNotNullExpressionValue(context, "binding.channelsItemCategoryName.context");
            int iAccess$getChannelColor = Companion.access$getChannelColor(companion, channelListItemCategory, context);
            this.binding.d.setTextColor(iAccess$getChannelColor);
            ViewCompat.setAccessibilityDelegate(this.binding.d, new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$3());
            this.binding.c.setImageResource(Companion.access$getArrowDrawable(companion, channelListItemCategory));
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.channelsItemCategoryArrow");
            imageView.setImageTintList(ColorStateList.valueOf(iAccess$getChannelColor));
            if (this.isCollapsed != channelListItemCategory.isCollapsed()) {
                this.isCollapsed = channelListItemCategory.isCollapsed();
                this.binding.c.startAnimation(channelListItemCategory.isCollapsed() ? ARROW_ANIM_COLLAPSE : ARROW_ANIM_EXPAND);
            }
            ImageView imageView2 = this.binding.f2286b;
            m.checkNotNullExpressionValue(imageView2, "binding.channelsItemCategoryAdd");
            imageView2.setVisibility(channelListItemCategory.getCanManageChannels() ? 0 : 8);
            ImageView imageView3 = this.binding.f2286b;
            m.checkNotNullExpressionValue(imageView3, "binding.channelsItemCategoryAdd");
            imageView3.setImageTintList(ColorStateList.valueOf(iAccess$getChannelColor));
            this.binding.f2286b.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4(this, channelListItemCategory));
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelDirectory extends Item {
        private final WidgetChannelsListItemDirectoryBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelDirectory(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            WidgetChannelsListItemDirectoryBinding widgetChannelsListItemDirectoryBindingA = WidgetChannelsListItemDirectoryBinding.a(this.itemView);
            m.checkNotNullExpressionValue(widgetChannelsListItemDirectoryBindingA, "WidgetChannelsListItemDi…oryBinding.bind(itemView)");
            this.binding = widgetChannelsListItemDirectoryBindingA;
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelDirectory itemChannelDirectory) {
            return (WidgetChannelsListAdapter) itemChannelDirectory.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemDirectory channelListItemDirectory = (ChannelListItemDirectory) data;
            boolean zX = ChannelUtils.x(channelListItemDirectory.getChannel());
            if (zX) {
                TextView textView = this.binding.c;
                m.checkNotNullExpressionValue(textView, "binding.directoryChannelName");
                String name = channelListItemDirectory.getChannel().getName();
                if (name == null) {
                    name = "";
                }
                textView.setText(name);
            } else {
                this.binding.c.setText(R.string.hub_sidebar_join_servers);
            }
            this.binding.f2291b.setImageResource(zX ? R.drawable.ic_hub_24dp : R.drawable.ic_compass);
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.directoryChannelUnreadCount");
            b.a(textView2, channelListItemDirectory.getUnreadCount() > 0 ? String.valueOf(channelListItemDirectory.getUnreadCount()) : null);
            LinearLayout linearLayout = this.binding.a;
            linearLayout.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelDirectory$onConfigure$$inlined$apply$lambda$1(this, channelListItemDirectory));
            linearLayout.setSelected(channelListItemDirectory.getSelected());
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelPrivate extends Item {
        private final WidgetChannelsListItemChannelPrivateBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelPrivate(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channel_list_item_private_status;
            StatusView statusView = (StatusView) view.findViewById(R.id.channel_list_item_private_status);
            if (statusView != null) {
                i2 = R.id.channels_list_item_private_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.channels_list_item_private_avatar);
                if (simpleDraweeView != null) {
                    i2 = R.id.channels_list_item_private_desc;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.channels_list_item_private_desc);
                    if (simpleDraweeSpanTextView != null) {
                        i2 = R.id.channels_list_item_private_mentions;
                        TextView textView = (TextView) view.findViewById(R.id.channels_list_item_private_mentions);
                        if (textView != null) {
                            i2 = R.id.channels_list_item_private_name;
                            TextView textView2 = (TextView) view.findViewById(R.id.channels_list_item_private_name);
                            if (textView2 != null) {
                                i2 = R.id.channels_list_item_private_tag;
                                TextView textView3 = (TextView) view.findViewById(R.id.channels_list_item_private_tag);
                                if (textView3 != null) {
                                    WidgetChannelsListItemChannelPrivateBinding widgetChannelsListItemChannelPrivateBinding = new WidgetChannelsListItemChannelPrivateBinding((RelativeLayout) view, statusView, simpleDraweeView, simpleDraweeSpanTextView, textView, textView2, textView3);
                                    m.checkNotNullExpressionValue(widgetChannelsListItemChannelPrivateBinding, "WidgetChannelsListItemCh…ateBinding.bind(itemView)");
                                    this.binding = widgetChannelsListItemChannelPrivateBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelPrivate itemChannelPrivate) {
            return (WidgetChannelsListAdapter) itemChannelPrivate.adapter;
        }

        private final CharSequence getContentDescription(ChannelListItemPrivate channelListItemPrivate, CharSequence channelName) {
            if (ChannelUtils.p(channelListItemPrivate.getChannel()) && channelListItemPrivate.getMentionCount() > 0) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return b.j(view, R.string.group_message_a11y_label_with_unreads, new Object[]{channelName}, null, 4);
            }
            if (ChannelUtils.p(channelListItemPrivate.getChannel())) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                return b.j(view2, R.string.group_message_a11y_label, new Object[]{channelName}, null, 4);
            }
            if (channelListItemPrivate.getMentionCount() > 0) {
                View view3 = this.itemView;
                m.checkNotNullExpressionValue(view3, "itemView");
                return b.j(view3, R.string.direct_message_a11y_label_with_unreads, new Object[]{channelName}, null, 4);
            }
            View view4 = this.itemView;
            m.checkNotNullExpressionValue(view4, "itemView");
            return b.j(view4, R.string.direct_message_a11y_label, new Object[]{channelName}, null, 4);
        }

        @SuppressLint({"SetTextI18n"})
        private final String getMemberCount(Channel channel, Context context) {
            List<com.discord.api.user.User> listZ = channel.z();
            int size = listZ != null ? listZ.size() : 0;
            CharSequence charSequenceH = b.h(context, R.string.members, new Object[0], null, 4);
            StringBuilder sb = new StringBuilder();
            sb.append(size + 1);
            sb.append(' ');
            sb.append(charSequenceH);
            return sb.toString();
        }

        private final int getPresenceBg(boolean selected) {
            if (selected) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return ColorCompat.getThemedColor(view, R.attr.color_bg_private_channel_presence_selected);
            }
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return ColorCompat.getThemedColor(view2, R.attr.colorBackgroundSecondary);
        }

        @ColorInt
        private final int getTextColor(ChannelListItemPrivate channelListItemPrivate) {
            if (channelListItemPrivate.getSelected()) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return ColorCompat.getThemedColor(view, R.attr.colorInteractiveActive);
            }
            if (channelListItemPrivate.getMuted()) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                return ColorCompat.getThemedColor(view2, R.attr.colorInteractiveMuted);
            }
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            return ColorCompat.getThemedColor(view3, R.attr.colorChannelDefault);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0166  */
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onConfigure2(int position, ChannelListItem data) {
            String strE;
            String str;
            int i;
            boolean z2;
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemPrivate channelListItemPrivate = (ChannelListItemPrivate) data;
            Channel channel = channelListItemPrivate.getChannel();
            Presence presence = channelListItemPrivate.getPresence();
            boolean selected = channelListItemPrivate.getSelected();
            int iComponent4 = channelListItemPrivate.component4();
            boolean isApplicationStreaming = channelListItemPrivate.getIsApplicationStreaming();
            if (ChannelUtils.m(channel)) {
                strE = ChannelUtils.c(channel);
            } else {
                TextView textView = this.binding.f;
                m.checkNotNullExpressionValue(textView, "binding.channelsListItemPrivateName");
                Context context = textView.getContext();
                m.checkNotNullExpressionValue(context, "binding.channelsListItemPrivateName.context");
                strE = ChannelUtils.e(channel, context, false, 2);
            }
            RelativeLayout relativeLayout = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout, new WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$1(this, data));
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$2(this, data));
            RelativeLayout relativeLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
            relativeLayout2.setContentDescription(getContentDescription(channelListItemPrivate, strE));
            TextView textView2 = this.binding.f;
            m.checkNotNullExpressionValue(textView2, "binding.channelsListItemPrivateName");
            textView2.setText(strE);
            this.binding.f.setTextColor(getTextColor(channelListItemPrivate));
            TextView textView3 = this.binding.g;
            m.checkNotNullExpressionValue(textView3, "binding.channelsListItemPrivateTag");
            textView3.setVisibility(ChannelUtils.E(channel) ? 0 : 8);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "it");
            IconUtils.setIcon$default(simpleDraweeView, channel, R.dimen.avatar_size_standard, (MGImages.ChangeDetector) null, 8, (Object) null);
            StatusView statusView = this.binding.f2288b;
            m.checkNotNullExpressionValue(statusView, "binding.channelListItemPrivateStatus");
            statusView.setVisibility(ChannelUtils.n(channel, presence) ? 0 : 8);
            this.binding.f2288b.setPresence(presence);
            this.binding.f2288b.setBackgroundColor(getPresenceBg(selected));
            if (ChannelUtils.E(channel)) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.channelsListItemPrivateDesc");
                SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.channelsListItemPrivateDesc");
                ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView, b.j(simpleDraweeSpanTextView2, R.string.system_dm_activity_text, new Object[0], null, 4));
            } else {
                if (!ChannelUtils.z(channel)) {
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = this.binding.d;
                    m.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.channelsListItemPrivateDesc");
                    str = "binding.root";
                    i = iComponent4;
                    z2 = selected;
                    PresenceUtils.setPresenceText$default(presence, isApplicationStreaming, simpleDraweeSpanTextView3, false, false, 24, null);
                    TextView textView4 = this.binding.e;
                    m.checkNotNullExpressionValue(textView4, "binding.channelsListItemPrivateMentions");
                    textView4.setText(String.valueOf(Math.min(99, i)));
                    TextView textView5 = this.binding.e;
                    m.checkNotNullExpressionValue(textView5, "binding.channelsListItemPrivateMentions");
                    textView5.setVisibility(!(i <= 0) ? 0 : 8);
                    RelativeLayout relativeLayout3 = this.binding.a;
                    m.checkNotNullExpressionValue(relativeLayout3, str);
                    relativeLayout3.setSelected(z2);
                    RelativeLayout relativeLayout4 = this.binding.a;
                    m.checkNotNullExpressionValue(relativeLayout4, str);
                    setBackground(relativeLayout4, z2, channel);
                }
                SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.channelsListItemPrivateDesc");
                SimpleDraweeSpanTextView simpleDraweeSpanTextView5 = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView5, "binding.channelsListItemPrivateDesc");
                Context context2 = simpleDraweeSpanTextView5.getContext();
                m.checkNotNullExpressionValue(context2, "binding.channelsListItemPrivateDesc.context");
                ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView4, getMemberCount(channel, context2));
            }
            str = "binding.root";
            i = iComponent4;
            z2 = selected;
            TextView textView42 = this.binding.e;
            m.checkNotNullExpressionValue(textView42, "binding.channelsListItemPrivateMentions");
            textView42.setText(String.valueOf(Math.min(99, i)));
            TextView textView52 = this.binding.e;
            m.checkNotNullExpressionValue(textView52, "binding.channelsListItemPrivateMentions");
            textView52.setVisibility(!(i <= 0) ? 0 : 8);
            RelativeLayout relativeLayout32 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout32, str);
            relativeLayout32.setSelected(z2);
            RelativeLayout relativeLayout42 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout42, str);
            setBackground(relativeLayout42, z2, channel);
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelStageVoice extends Item {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final WidgetChannelsListItemChannelStageVoiceBinding binding;

        /* compiled from: WidgetChannelsListAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ int access$getVoiceChannelColor(Companion companion, boolean z2, Context context) {
                return companion.getVoiceChannelColor(z2, context);
            }

            @ColorInt
            private final int getVoiceChannelColor(boolean isSelected, Context context) {
                return isSelected ? ColorCompat.getThemedColor(context, R.attr.colorInteractiveActive) : ColorCompat.getThemedColor(context, R.attr.colorChannelDefault);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelStageVoice(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_item_stage_voice_channel_guild_role_subscription_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.channels_item_stage_voice_channel_guild_role_subscription_icon);
            if (imageView != null) {
                i2 = R.id.stage_channel_item_stage_channel_icon;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.stage_channel_item_stage_channel_icon);
                if (imageView2 != null) {
                    i2 = R.id.stage_channel_item_voice_channel_name;
                    TextView textView = (TextView) view.findViewById(R.id.stage_channel_item_voice_channel_name);
                    if (textView != null) {
                        i2 = R.id.stage_channel_item_voice_channel_topic;
                        TextView textView2 = (TextView) view.findViewById(R.id.stage_channel_item_voice_channel_topic);
                        if (textView2 != null) {
                            WidgetChannelsListItemChannelStageVoiceBinding widgetChannelsListItemChannelStageVoiceBinding = new WidgetChannelsListItemChannelStageVoiceBinding((RelativeLayout) view, imageView, imageView2, textView, textView2);
                            m.checkNotNullExpressionValue(widgetChannelsListItemChannelStageVoiceBinding, "WidgetChannelsListItemCh…iceBinding.bind(itemView)");
                            this.binding = widgetChannelsListItemChannelStageVoiceBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelStageVoice itemChannelStageVoice) {
            return (WidgetChannelsListAdapter) itemChannelStageVoice.adapter;
        }

        private final CharSequence getContentDescription(ChannelListVocalItem data, int userLimit) {
            if (userLimit > 0) {
                RelativeLayout relativeLayout = this.binding.a;
                m.checkNotNullExpressionValue(relativeLayout, "binding.root");
                return b.j(relativeLayout, R.string.guild_sidebar_voice_channel_a11y_label_with_limit, new Object[]{ChannelUtils.c(data.getChannel()), Integer.valueOf(data.getNumUsersConnected()), Integer.valueOf(userLimit)}, null, 4);
            }
            if (data.getNumUsersConnected() <= 0) {
                RelativeLayout relativeLayout2 = this.binding.a;
                m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
                return b.j(relativeLayout2, R.string.guild_sidebar_voice_channel_a11y_label, new Object[]{ChannelUtils.c(data.getChannel())}, null, 4);
            }
            RelativeLayout relativeLayout3 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout3, "binding.root");
            RelativeLayout relativeLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
            Context context = relativeLayout4.getContext();
            m.checkNotNullExpressionValue(context, "binding.root.context");
            return b.j(relativeLayout3, R.string.guild_sidebar_voice_channel_a11y_label_with_users, new Object[]{ChannelUtils.c(data.getChannel()), StringResourceUtilsKt.getI18nPluralString(context, R.plurals.guild_sidebar_voice_channel_a11y_label_with_users_userCount, data.getNumUsersConnected(), Integer.valueOf(data.getNumUsersConnected()))}, null, 4);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            ColorStateList colorStateListValueOf;
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemStageVoiceChannel channelListItemStageVoiceChannel = (ChannelListItemStageVoiceChannel) data;
            Channel channelComponent1 = channelListItemStageVoiceChannel.component1();
            boolean selected = channelListItemStageVoiceChannel.getSelected();
            Long permission = channelListItemStageVoiceChannel.getPermission();
            boolean isLocked = channelListItemStageVoiceChannel.getIsLocked();
            StageInstance stageInstance = channelListItemStageVoiceChannel.getStageInstance();
            boolean isGuildRoleSubscriptionLockedChannel = channelListItemStageVoiceChannel.getIsGuildRoleSubscriptionLockedChannel();
            boolean isGuildRoleSubscriptionChannel = channelListItemStageVoiceChannel.getIsGuildRoleSubscriptionChannel();
            boolean z2 = stageInstance != null;
            boolean zCan = PermissionUtils.can(Permission.CONNECT, permission);
            Companion companion = INSTANCE;
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "itemView.context");
            int iAccess$getVoiceChannelColor = Companion.access$getVoiceChannelColor(companion, selected, context);
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$1(this, isGuildRoleSubscriptionLockedChannel, data));
            RelativeLayout relativeLayout = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout, "binding.root");
            relativeLayout.setSelected(selected);
            RelativeLayout relativeLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
            setBackground(relativeLayout2, selected, channelComponent1);
            TextView textView = this.binding.d;
            textView.setText(ChannelUtils.c(channelComponent1));
            textView.setTextColor(iAccess$getVoiceChannelColor);
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.stageChannelItemVoiceChannelTopic");
            ViewExtensions.setTextAndVisibilityBy(textView2, stageInstance != null ? stageInstance.getTopic() : null);
            ImageView imageView = this.binding.f2289b;
            m.checkNotNullExpressionValue(imageView, "binding.channelsItemStag…GuildRoleSubscriptionIcon");
            imageView.setVisibility(isGuildRoleSubscriptionChannel ? 0 : 8);
            if (isGuildRoleSubscriptionLockedChannel) {
                this.binding.f2289b.setImageResource(R.drawable.ic_premium_channel_locked);
            } else if (isGuildRoleSubscriptionChannel) {
                this.binding.f2289b.setImageResource(R.drawable.ic_premium_channel_unlocked);
            }
            int i = !zCan ? R.drawable.ic_channel_lock_16dp : isLocked ? R.drawable.ic_channel_stage_locked : R.drawable.ic_channel_stage_24dp;
            ImageView imageView2 = this.binding.c;
            imageView2.setImageResource(i);
            if (z2 && zCan) {
                RelativeLayout relativeLayout3 = this.binding.a;
                m.checkNotNullExpressionValue(relativeLayout3, "binding.root");
                colorStateListValueOf = ColorStateList.valueOf(ColorCompat.getColor(relativeLayout3.getContext(), R.color.status_green_600));
            } else {
                colorStateListValueOf = ColorStateList.valueOf(iAccess$getVoiceChannelColor);
            }
            imageView2.setImageTintList(colorStateListValueOf);
            RelativeLayout relativeLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
            relativeLayout4.setContentDescription(getContentDescription((ChannelListVocalItem) data, channelComponent1.getUserLimit()));
            RelativeLayout relativeLayout5 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout5, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout5, new WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$4(this, channelComponent1));
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelText extends Item {
        private final WidgetChannelsListItemChannelBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelText(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_item_channel_guild_role_subscription_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.channels_item_channel_guild_role_subscription_icon);
            if (imageView != null) {
                i2 = R.id.channels_item_channel_hash;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.channels_item_channel_hash);
                if (imageView2 != null) {
                    i2 = R.id.channels_item_channel_mentions;
                    TextView textView = (TextView) view.findViewById(R.id.channels_item_channel_mentions);
                    if (textView != null) {
                        i2 = R.id.channels_item_channel_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.channels_item_channel_name);
                        if (textView2 != null) {
                            i2 = R.id.channels_item_channel_unread;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.channels_item_channel_unread);
                            if (imageView3 != null) {
                                WidgetChannelsListItemChannelBinding widgetChannelsListItemChannelBinding = new WidgetChannelsListItemChannelBinding((RelativeLayout) view, imageView, imageView2, textView, textView2, imageView3);
                                m.checkNotNullExpressionValue(widgetChannelsListItemChannelBinding, "WidgetChannelsListItemCh…nelBinding.bind(itemView)");
                                this.binding = widgetChannelsListItemChannelBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelText itemChannelText) {
            return (WidgetChannelsListAdapter) itemChannelText.adapter;
        }

        @DrawableRes
        private final int getAnnouncementsIcon(ChannelListItemTextChannel channelListItemTextChannel) {
            return channelListItemTextChannel.getChannel().getNsfw() ? channelListItemTextChannel.getHasActiveThreads() ? R.drawable.ic_channel_announcements_thread_nsfw : R.drawable.ic_channel_announcements_nsfw : channelListItemTextChannel.isLocked() ? channelListItemTextChannel.getHasActiveThreads() ? R.drawable.ic_channel_announcements_thread_locked : R.drawable.ic_channel_announcements_locked : channelListItemTextChannel.getHasActiveThreads() ? R.drawable.ic_channel_announcements_thread : R.drawable.ic_channel_announcements;
        }

        private final CharSequence getContentDescription(ChannelListItemTextChannel channelListItemTextChannel, boolean z2) {
            if (z2 && channelListItemTextChannel.getMentionCount() > 0) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return b.j(view, R.string.guild_sidebar_announcement_channel_a11y_label_with_mentions, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R.plurals.guild_sidebar_announcement_channel_a11y_label_with_mentions_mentionCount, channelListItemTextChannel.getMentionCount(), Integer.valueOf(channelListItemTextChannel.getMentionCount())), ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
            }
            if (z2 && channelListItemTextChannel.getIsUnread()) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                return b.j(view2, R.string.guild_sidebar_announcement_channel_a11y_label_with_unreads, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
            }
            if (z2) {
                View view3 = this.itemView;
                m.checkNotNullExpressionValue(view3, "itemView");
                return b.j(view3, R.string.guild_sidebar_announcement_channel_a11y_label, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
            }
            if (channelListItemTextChannel.getMentionCount() > 0) {
                View view4 = this.itemView;
                m.checkNotNullExpressionValue(view4, "itemView");
                return b.j(view4, R.string.guild_sidebar_default_channel_a11y_label_with_mentions, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R.plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemTextChannel.getMentionCount(), Integer.valueOf(channelListItemTextChannel.getMentionCount())), ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
            }
            if (channelListItemTextChannel.getIsUnread()) {
                View view5 = this.itemView;
                m.checkNotNullExpressionValue(view5, "itemView");
                return b.j(view5, R.string.guild_sidebar_default_channel_a11y_label_with_unreads, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
            }
            View view6 = this.itemView;
            m.checkNotNullExpressionValue(view6, "itemView");
            return b.j(view6, R.string.guild_sidebar_default_channel_a11y_label, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
        }

        @DrawableRes
        private final int getForumIcon(ChannelListItemTextChannel channelListItemTextChannel) {
            return channelListItemTextChannel.getChannel().getNsfw() ? R.drawable.ic_channel_forum_nsfw : channelListItemTextChannel.isLocked() ? R.drawable.ic_channel_forum_locked : R.drawable.ic_channel_forum;
        }

        @ColorInt
        private final int getHashColor(ChannelListItemTextChannel channelListItemTextChannel) {
            if (channelListItemTextChannel.getMuted()) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return ColorCompat.getThemedColor(view, R.attr.colorInteractiveMuted);
            }
            if (channelListItemTextChannel.getIsUnread()) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                return ColorCompat.getThemedColor(view2, R.attr.colorInteractiveActive);
            }
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            return ColorCompat.getThemedColor(view3, R.attr.colorChannelDefault);
        }

        @DrawableRes
        private final int getHashIcon(ChannelListItemTextChannel channelListItemTextChannel) {
            return channelListItemTextChannel.getChannel().getNsfw() ? channelListItemTextChannel.getHasActiveThreads() ? R.drawable.ic_thread_nsfw : R.drawable.ic_channel_text_nsfw : channelListItemTextChannel.isLocked() ? channelListItemTextChannel.getHasActiveThreads() ? R.drawable.ic_thread_locked : R.drawable.ic_channel_text_locked : channelListItemTextChannel.getHasActiveThreads() ? R.drawable.ic_thread : R.drawable.ic_channel_text;
        }

        @ColorInt
        private final int getTextColor(ChannelListItemTextChannel channelListItemTextChannel, boolean z2) {
            if (z2) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return ColorCompat.getThemedColor(view, R.attr.colorInteractiveActive);
            }
            if (channelListItemTextChannel.getMuted()) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                return ColorCompat.getThemedColor(view2, R.attr.colorInteractiveMuted);
            }
            if (channelListItemTextChannel.getIsUnread()) {
                View view3 = this.itemView;
                m.checkNotNullExpressionValue(view3, "itemView");
                return ColorCompat.getThemedColor(view3, R.attr.colorInteractiveActive);
            }
            View view4 = this.itemView;
            m.checkNotNullExpressionValue(view4, "itemView");
            return ColorCompat.getThemedColor(view4, R.attr.colorChannelDefault);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemTextChannel channelListItemTextChannel = (ChannelListItemTextChannel) data;
            boolean z2 = channelListItemTextChannel.getChannel().getType() == 5;
            RelativeLayout relativeLayout = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout, new WidgetChannelsListAdapter$ItemChannelText$onConfigure$1(this, data));
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelText$onConfigure$2(this, channelListItemTextChannel, data));
            RelativeLayout relativeLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
            setBackground(relativeLayout2, channelListItemTextChannel.getSelected(), channelListItemTextChannel.getChannel());
            RelativeLayout relativeLayout3 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout3, "binding.root");
            relativeLayout3.setContentDescription(getContentDescription(channelListItemTextChannel, z2));
            TextView textView = this.binding.e;
            m.checkNotNullExpressionValue(textView, "binding.channelsItemChannelName");
            textView.setText(ChannelUtils.c(channelListItemTextChannel.getChannel()));
            this.binding.e.setTextColor(getTextColor(channelListItemTextChannel, channelListItemTextChannel.getSelected()));
            ImageView imageView = this.binding.c;
            int type = channelListItemTextChannel.getChannel().getType();
            imageView.setImageResource(type != 5 ? type != 15 ? getHashIcon(channelListItemTextChannel) : getForumIcon(channelListItemTextChannel) : getAnnouncementsIcon(channelListItemTextChannel));
            ImageView imageView2 = this.binding.c;
            m.checkNotNullExpressionValue(imageView2, "binding.channelsItemChannelHash");
            imageView2.setImageTintList(ColorStateList.valueOf(getHashColor(channelListItemTextChannel)));
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.channelsItemChannelMentions");
            textView2.setVisibility(channelListItemTextChannel.getMentionCount() > 0 ? 0 : 8);
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.channelsItemChannelMentions");
            textView3.setText(String.valueOf(Math.min(99, channelListItemTextChannel.getMentionCount())));
            ImageView imageView3 = this.binding.f;
            m.checkNotNullExpressionValue(imageView3, "binding.channelsItemChannelUnread");
            imageView3.setVisibility((!channelListItemTextChannel.getIsUnread() || channelListItemTextChannel.getSelected() || channelListItemTextChannel.getMuted()) ? false : true ? 0 : 8);
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.channelsItemChannelName");
            FontUtils fontUtils = FontUtils.INSTANCE;
            RelativeLayout relativeLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
            Context context = relativeLayout4.getContext();
            m.checkNotNullExpressionValue(context, "binding.root.context");
            textView4.setTypeface(fontUtils.getThemedFont(context, (channelListItemTextChannel.getIsUnread() || channelListItemTextChannel.getSelected()) ? R.attr.font_primary_semibold : R.attr.font_primary_normal));
            ImageView imageView4 = this.binding.f2287b;
            m.checkNotNullExpressionValue(imageView4, "binding.channelsItemChan…GuildRoleSubscriptionIcon");
            imageView4.setVisibility(channelListItemTextChannel.isGuildRoleSubscriptionChannel() ? 0 : 8);
            if (channelListItemTextChannel.isGuildRoleSubscriptionLockedChannel()) {
                this.binding.f2287b.setImageResource(R.drawable.ic_premium_channel_locked);
            } else if (channelListItemTextChannel.isGuildRoleSubscriptionChannel()) {
                this.binding.f2287b.setImageResource(R.drawable.ic_premium_channel_unlocked);
            }
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelThread extends Item {
        private final WidgetChannelsListItemThreadBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelThread(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_item_thread_content;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.channels_item_thread_content);
            if (constraintLayout != null) {
                i2 = R.id.channels_item_thread_mentions;
                TextView textView = (TextView) view.findViewById(R.id.channels_item_thread_mentions);
                if (textView != null) {
                    i2 = R.id.channels_item_thread_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.channels_item_thread_name);
                    if (textView2 != null) {
                        i2 = R.id.channels_item_thread_spine;
                        ImageView imageView = (ImageView) view.findViewById(R.id.channels_item_thread_spine);
                        if (imageView != null) {
                            i2 = R.id.channels_item_thread_unread;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.channels_item_thread_unread);
                            if (imageView2 != null) {
                                WidgetChannelsListItemThreadBinding widgetChannelsListItemThreadBinding = new WidgetChannelsListItemThreadBinding((ConstraintLayout) view, constraintLayout, textView, textView2, imageView, imageView2);
                                m.checkNotNullExpressionValue(widgetChannelsListItemThreadBinding, "WidgetChannelsListItemThreadBinding.bind(itemView)");
                                this.binding = widgetChannelsListItemThreadBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelThread itemChannelThread) {
            return (WidgetChannelsListAdapter) itemChannelThread.adapter;
        }

        private final CharSequence getContentDescription(ChannelListItemThread channelListItemThread) {
            if (channelListItemThread.getMentionCount() > 0) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return b.j(view, R.string.guild_sidebar_default_channel_a11y_label_with_mentions, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R.plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemThread.getMentionCount(), Integer.valueOf(channelListItemThread.getMentionCount())), channelListItemThread.getChannel().getName()}, null, 4);
            }
            if (channelListItemThread.getIsUnread()) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                return b.j(view2, R.string.guild_sidebar_default_channel_a11y_label_with_unreads, new Object[]{channelListItemThread.getChannel().getName()}, null, 4);
            }
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            return b.j(view3, R.string.guild_sidebar_default_channel_a11y_label, new Object[]{channelListItemThread.getChannel().getName()}, null, 4);
        }

        private final int getSpineResourceId(WidgetChannelListModel.ThreadSpineType spineType) {
            return m.areEqual(spineType, WidgetChannelListModel.ThreadSpineType.Single.INSTANCE) ? R.drawable.ic_spine_short_cap : m.areEqual(spineType, WidgetChannelListModel.ThreadSpineType.Start.INSTANCE) ? R.drawable.ic_spine_long_cap : m.areEqual(spineType, WidgetChannelListModel.ThreadSpineType.End.INSTANCE) ? R.drawable.ic_spine_short_no_cap : R.drawable.ic_spine_long_no_cap;
        }

        @ColorInt
        private final int getTextColor(ChannelListItemThread channelListItemThread, boolean z2) {
            if (z2) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                return ColorCompat.getThemedColor(view, R.attr.colorInteractiveActive);
            }
            if (channelListItemThread.getMuted()) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                return ColorCompat.getThemedColor(view2, R.attr.colorInteractiveMuted);
            }
            if (channelListItemThread.getIsUnread()) {
                View view3 = this.itemView;
                m.checkNotNullExpressionValue(view3, "itemView");
                return ColorCompat.getThemedColor(view3, R.attr.colorInteractiveActive);
            }
            View view4 = this.itemView;
            m.checkNotNullExpressionValue(view4, "itemView");
            return ColorCompat.getThemedColor(view4, R.attr.colorChannelDefault);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemThread channelListItemThread = (ChannelListItemThread) data;
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout, new WidgetChannelsListAdapter$ItemChannelThread$onConfigure$1(this, data));
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelThread$onConfigure$2(this, data));
            ConstraintLayout constraintLayout2 = this.binding.f2298b;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.channelsItemThreadContent");
            setBackground(constraintLayout2, channelListItemThread.getSelected(), channelListItemThread.getChannel());
            ConstraintLayout constraintLayout3 = this.binding.f2298b;
            m.checkNotNullExpressionValue(constraintLayout3, "binding.channelsItemThreadContent");
            constraintLayout3.setContentDescription(getContentDescription(channelListItemThread));
            TextView textView = this.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.channelsItemThreadName");
            textView.setText(channelListItemThread.getChannel().getName());
            this.binding.d.setTextColor(getTextColor(channelListItemThread, channelListItemThread.getSelected()));
            TextView textView2 = this.binding.c;
            m.checkNotNullExpressionValue(textView2, "binding.channelsItemThreadMentions");
            textView2.setVisibility(channelListItemThread.getMentionCount() > 0 ? 0 : 8);
            TextView textView3 = this.binding.c;
            m.checkNotNullExpressionValue(textView3, "binding.channelsItemThreadMentions");
            textView3.setText(String.valueOf(Math.min(99, channelListItemThread.getMentionCount())));
            ImageView imageView = this.binding.f;
            m.checkNotNullExpressionValue(imageView, "binding.channelsItemThreadUnread");
            imageView.setVisibility((!channelListItemThread.getIsUnread() || channelListItemThread.getSelected() || channelListItemThread.getMuted()) ? false : true ? 0 : 8);
            TextView textView4 = this.binding.d;
            m.checkNotNullExpressionValue(textView4, "binding.channelsItemThreadName");
            FontUtils fontUtils = FontUtils.INSTANCE;
            ConstraintLayout constraintLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
            Context context = constraintLayout4.getContext();
            m.checkNotNullExpressionValue(context, "binding.root.context");
            textView4.setTypeface(fontUtils.getThemedFont(context, (channelListItemThread.getIsUnread() || channelListItemThread.getSelected()) ? R.attr.font_primary_semibold : R.attr.font_primary_normal));
            this.binding.e.setImageResource(getSpineResourceId(channelListItemThread.getSpineType()));
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemChannelVoice extends Item {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final WidgetChannelsListItemChannelVoiceBinding binding;

        /* compiled from: WidgetChannelsListAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ int access$getVoiceChannelColor(Companion companion, boolean z2, Context context) {
                return companion.getVoiceChannelColor(z2, context);
            }

            @ColorInt
            private final int getVoiceChannelColor(boolean isSelected, Context context) {
                return isSelected ? ColorCompat.getThemedColor(context, R.attr.colorInteractiveActive) : ColorCompat.getThemedColor(context, R.attr.colorChannelDefault);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemChannelVoice(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_item_channel_mentions;
            TextView textView = (TextView) view.findViewById(R.id.channels_item_channel_mentions);
            if (textView != null) {
                i2 = R.id.channels_item_channel_unread;
                ImageView imageView = (ImageView) view.findViewById(R.id.channels_item_channel_unread);
                if (imageView != null) {
                    i2 = R.id.channels_item_voice_channel_event_topic;
                    TextView textView2 = (TextView) view.findViewById(R.id.channels_item_voice_channel_event_topic);
                    if (textView2 != null) {
                        i2 = R.id.channels_item_voice_channel_guild_role_subscription_icon;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.channels_item_voice_channel_guild_role_subscription_icon);
                        if (imageView2 != null) {
                            i2 = R.id.channels_item_voice_channel_name;
                            TextView textView3 = (TextView) view.findViewById(R.id.channels_item_voice_channel_name);
                            if (textView3 != null) {
                                i2 = R.id.channels_item_voice_channel_speaker;
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.channels_item_voice_channel_speaker);
                                if (imageView3 != null) {
                                    i2 = R.id.channels_item_voice_channel_user_limit;
                                    VoiceUserLimitView voiceUserLimitView = (VoiceUserLimitView) view.findViewById(R.id.channels_item_voice_channel_user_limit);
                                    if (voiceUserLimitView != null) {
                                        i2 = R.id.channels_item_voice_channel_wrapper;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.channels_item_voice_channel_wrapper);
                                        if (linearLayout != null) {
                                            WidgetChannelsListItemChannelVoiceBinding widgetChannelsListItemChannelVoiceBinding = new WidgetChannelsListItemChannelVoiceBinding((ConstraintLayout) view, textView, imageView, textView2, imageView2, textView3, imageView3, voiceUserLimitView, linearLayout);
                                            m.checkNotNullExpressionValue(widgetChannelsListItemChannelVoiceBinding, "WidgetChannelsListItemCh…iceBinding.bind(itemView)");
                                            this.binding = widgetChannelsListItemChannelVoiceBinding;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemChannelVoice itemChannelVoice) {
            return (WidgetChannelsListAdapter) itemChannelVoice.adapter;
        }

        private final CharSequence getContentDescription(ChannelListItemVoiceChannel channelListItemVoiceChannel, ChannelListItemVoiceChannel channelListItemVoiceChannel2, int i) {
            if (i > 0 && channelListItemVoiceChannel.getMentionCount() > 0) {
                ConstraintLayout constraintLayout = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout, "binding.root");
                ConstraintLayout constraintLayout2 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
                Context context = constraintLayout2.getContext();
                m.checkNotNullExpressionValue(context, "binding.root.context");
                return b.j(constraintLayout, R.string.guild_sidebar_voice_channel_a11y_label_with_limit_with_mentions, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R.plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemVoiceChannel.getMentionCount(), Integer.valueOf(channelListItemVoiceChannel.getMentionCount())), ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()), Integer.valueOf(i)}, null, 4);
            }
            if (i > 0) {
                ConstraintLayout constraintLayout3 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
                return b.j(constraintLayout3, R.string.guild_sidebar_voice_channel_a11y_label_with_limit, new Object[]{ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()), Integer.valueOf(i)}, null, 4);
            }
            if (channelListItemVoiceChannel2.getNumUsersConnected() > 0 && channelListItemVoiceChannel.getMentionCount() > 0) {
                ConstraintLayout constraintLayout4 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
                ConstraintLayout constraintLayout5 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout5, "binding.root");
                Context context2 = constraintLayout5.getContext();
                m.checkNotNullExpressionValue(context2, "binding.root.context");
                int mentionCount = channelListItemVoiceChannel.getMentionCount();
                Object[] objArr = {Integer.valueOf(channelListItemVoiceChannel.getMentionCount())};
                ConstraintLayout constraintLayout6 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout6, "binding.root");
                Context context3 = constraintLayout6.getContext();
                m.checkNotNullExpressionValue(context3, "binding.root.context");
                return b.j(constraintLayout4, R.string.guild_sidebar_voice_channel_a11y_label_with_users_with_mentions, new Object[]{StringResourceUtilsKt.getI18nPluralString(context2, R.plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, mentionCount, objArr), ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), StringResourceUtilsKt.getI18nPluralString(context3, R.plurals.guild_sidebar_voice_channel_a11y_label_with_users_userCount, channelListItemVoiceChannel2.getNumUsersConnected(), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()))}, null, 4);
            }
            if (channelListItemVoiceChannel2.getNumUsersConnected() > 0) {
                ConstraintLayout constraintLayout7 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout7, "binding.root");
                ConstraintLayout constraintLayout8 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout8, "binding.root");
                Context context4 = constraintLayout8.getContext();
                m.checkNotNullExpressionValue(context4, "binding.root.context");
                return b.j(constraintLayout7, R.string.guild_sidebar_voice_channel_a11y_label_with_users, new Object[]{ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), StringResourceUtilsKt.getI18nPluralString(context4, R.plurals.guild_sidebar_voice_channel_a11y_label_with_users_userCount, channelListItemVoiceChannel2.getNumUsersConnected(), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()))}, null, 4);
            }
            if (channelListItemVoiceChannel.getMentionCount() <= 0) {
                ConstraintLayout constraintLayout9 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout9, "binding.root");
                return b.j(constraintLayout9, R.string.guild_sidebar_voice_channel_a11y_label, new Object[]{ChannelUtils.c(channelListItemVoiceChannel2.getChannel())}, null, 4);
            }
            ConstraintLayout constraintLayout10 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout10, "binding.root");
            ConstraintLayout constraintLayout11 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout11, "binding.root");
            Context context5 = constraintLayout11.getContext();
            m.checkNotNullExpressionValue(context5, "binding.root.context");
            return b.j(constraintLayout10, R.string.guild_sidebar_voice_channel_a11y_label_with_mentions, new Object[]{StringResourceUtilsKt.getI18nPluralString(context5, R.plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemVoiceChannel.getMentionCount(), Integer.valueOf(channelListItemVoiceChannel.getMentionCount())), ChannelUtils.c(channelListItemVoiceChannel2.getChannel())}, null, 4);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemVoiceChannel channelListItemVoiceChannel = (ChannelListItemVoiceChannel) data;
            Channel channelComponent1 = channelListItemVoiceChannel.component1();
            boolean textSelected = channelListItemVoiceChannel.getTextSelected();
            boolean voiceSelected = channelListItemVoiceChannel.getVoiceSelected();
            Long permission = channelListItemVoiceChannel.getPermission();
            int iComponent5 = channelListItemVoiceChannel.component5();
            boolean zComponent6 = channelListItemVoiceChannel.component6();
            int iComponent7 = channelListItemVoiceChannel.component7();
            boolean isLocked = channelListItemVoiceChannel.getIsLocked();
            boolean isNsfw = channelListItemVoiceChannel.getIsNsfw();
            boolean isAnyoneUsingVideo = channelListItemVoiceChannel.getIsAnyoneUsingVideo();
            GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = channelListItemVoiceChannel.getGuildMaxVideoChannelUsers();
            boolean isGuildRoleSubscriptionLockedChannel = channelListItemVoiceChannel.getIsGuildRoleSubscriptionLockedChannel();
            boolean isGuildRoleSubscriptionChannel = channelListItemVoiceChannel.getIsGuildRoleSubscriptionChannel();
            GuildScheduledEvent guildScheduledEvent = channelListItemVoiceChannel.getGuildScheduledEvent();
            boolean zCan = PermissionUtils.can(Permission.CONNECT, permission);
            Companion companion = INSTANCE;
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "itemView.context");
            int iAccess$getVoiceChannelColor = Companion.access$getVoiceChannelColor(companion, voiceSelected, context);
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$1(this, isGuildRoleSubscriptionLockedChannel, data));
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            constraintLayout.setSelected(voiceSelected);
            ConstraintLayout constraintLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            setBackground(constraintLayout2, voiceSelected, channelComponent1);
            TextView textView = this.binding.f;
            m.checkNotNullExpressionValue(textView, "binding.channelsItemVoiceChannelName");
            textView.setText(ChannelUtils.c(channelComponent1));
            this.binding.f.setTextColor(iAccess$getVoiceChannelColor);
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.channelsItemVoiceChannelEventTopic");
            ViewExtensions.setTextAndVisibilityBy(textView2, guildScheduledEvent != null ? guildScheduledEvent.getName() : null);
            TextView textView3 = this.binding.f2290b;
            m.checkNotNullExpressionValue(textView3, "binding.channelsItemChannelMentions");
            textView3.setVisibility(iComponent5 > 0 ? 0 : 8);
            TextView textView4 = this.binding.f2290b;
            m.checkNotNullExpressionValue(textView4, "binding.channelsItemChannelMentions");
            textView4.setText(String.valueOf(Math.min(99, iComponent5)));
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.channelsItemChannelUnread");
            imageView.setVisibility(zComponent6 && !textSelected ? 0 : 8);
            ImageView imageView2 = this.binding.e;
            m.checkNotNullExpressionValue(imageView2, "binding.channelsItemVoic…GuildRoleSubscriptionIcon");
            imageView2.setVisibility(isGuildRoleSubscriptionChannel ? 0 : 8);
            if (isGuildRoleSubscriptionLockedChannel) {
                this.binding.e.setImageResource(R.drawable.ic_premium_channel_locked);
            } else if (isGuildRoleSubscriptionChannel) {
                this.binding.e.setImageResource(R.drawable.ic_premium_channel_unlocked);
            }
            int i = !zCan ? R.drawable.ic_channel_lock_16dp : isNsfw ? R.drawable.ic_voice_nsfw : isLocked ? R.drawable.ic_channel_voice_locked : R.drawable.ic_channel_voice;
            if (guildScheduledEvent != null) {
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                iAccess$getVoiceChannelColor = ColorCompat.getColor(view2.getContext(), R.color.status_green_600);
            }
            this.binding.g.setImageResource(i);
            ImageView imageView3 = this.binding.g;
            m.checkNotNullExpressionValue(imageView3, "binding.channelsItemVoiceChannelSpeaker");
            imageView3.setImageTintList(ColorStateList.valueOf(iAccess$getVoiceChannelColor));
            GuildMaxVideoChannelUsers.Limited limited = (GuildMaxVideoChannelUsers.Limited) (!(guildMaxVideoChannelUsers instanceof GuildMaxVideoChannelUsers.Limited) ? null : guildMaxVideoChannelUsers);
            int limit = limited != null ? limited.getLimit() : 0;
            int iMin = Math.min(channelComponent1.getUserLimit(), limit);
            if (iMin > 0) {
                boolean z2 = isAnyoneUsingVideo && iMin == limit;
                if (!z2) {
                    limit = channelComponent1.getUserLimit();
                }
                VoiceUserLimitView voiceUserLimitView = this.binding.h;
                m.checkNotNullExpressionValue(voiceUserLimitView, "binding.channelsItemVoiceChannelUserLimit");
                voiceUserLimitView.setVisibility(limit > 0 && zCan ? 0 : 8);
                this.binding.h.a(iComponent7, limit, z2);
                ConstraintLayout constraintLayout3 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
                constraintLayout3.setContentDescription(getContentDescription(channelListItemVoiceChannel, channelListItemVoiceChannel, limit));
            } else {
                VoiceUserLimitView voiceUserLimitView2 = this.binding.h;
                m.checkNotNullExpressionValue(voiceUserLimitView2, "binding.channelsItemVoiceChannelUserLimit");
                voiceUserLimitView2.setVisibility(8);
                ConstraintLayout constraintLayout4 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
                constraintLayout4.setContentDescription(getContentDescription(channelListItemVoiceChannel, channelListItemVoiceChannel, iMin));
            }
            if (PermissionUtils.can(16L, permission)) {
                ConstraintLayout constraintLayout5 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout5, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout5, new WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$2(this, channelComponent1));
            } else {
                ConstraintLayout constraintLayout6 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout6, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout6, WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$3.INSTANCE);
            }
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemGuildJoinRequest extends Item {
        private final WidgetChannelsListItemGuildJoinRequestBinding binding;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ApplicationStatus.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[ApplicationStatus.STARTED.ordinal()] = 1;
                iArr[ApplicationStatus.PENDING.ordinal()] = 2;
                iArr[ApplicationStatus.REJECTED.ordinal()] = 3;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGuildJoinRequest(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.channels_list_item_guild_join_request_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.channels_list_item_guild_join_request_button);
            if (materialButton != null) {
                i2 = R.id.channels_list_item_guild_join_request_label;
                TextView textView = (TextView) view.findViewById(R.id.channels_list_item_guild_join_request_label);
                if (textView != null) {
                    WidgetChannelsListItemGuildJoinRequestBinding widgetChannelsListItemGuildJoinRequestBinding = new WidgetChannelsListItemGuildJoinRequestBinding((ConstraintLayout) view, constraintLayout, materialButton, textView);
                    m.checkNotNullExpressionValue(widgetChannelsListItemGuildJoinRequestBinding, "WidgetChannelsListItemGu…estBinding.bind(itemView)");
                    this.binding = widgetChannelsListItemGuildJoinRequestBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemGuildJoinRequest itemGuildJoinRequest) {
            return (WidgetChannelsListAdapter) itemGuildJoinRequest.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data instanceof ChannelListItemGuildJoinRequest) {
                ConstraintLayout constraintLayout = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout, "binding.root");
                Context context = constraintLayout.getContext();
                ChannelListItemGuildJoinRequest channelListItemGuildJoinRequest = (ChannelListItemGuildJoinRequest) data;
                ApplicationStatus applicationStatus = channelListItemGuildJoinRequest.getGuildJoinRequest().getApplicationStatus();
                GuildMember member = channelListItemGuildJoinRequest.getMember();
                this.binding.c.setOnClickListener(new WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1(this, context));
                if (!member.getPending()) {
                    ConstraintLayout constraintLayout2 = this.binding.f2292b;
                    m.checkNotNullExpressionValue(constraintLayout2, "binding.channelsListItemGuildJoinRequest");
                    constraintLayout2.setVisibility(8);
                }
                int iOrdinal = applicationStatus.ordinal();
                if (iOrdinal == 0) {
                    this.binding.d.setText(R.string.member_verification_notice_text);
                    this.binding.c.setText(R.string.member_verification_notice_cta);
                    this.binding.c.setBackgroundColor(ColorCompat.getThemedColor(context, R.attr.color_brand));
                    ConstraintLayout constraintLayout3 = this.binding.f2292b;
                    m.checkNotNullExpressionValue(constraintLayout3, "binding.channelsListItemGuildJoinRequest");
                    constraintLayout3.setVisibility(0);
                    return;
                }
                if (iOrdinal == 1) {
                    this.binding.d.setText(R.string.member_verification_pending_application_notice_title);
                    this.binding.c.setText(R.string.member_verification_pending_application_modal_cancel);
                    this.binding.c.setBackgroundColor(ColorCompat.getThemedColor(context, R.attr.colorBackgroundAccent));
                    ConstraintLayout constraintLayout4 = this.binding.f2292b;
                    m.checkNotNullExpressionValue(constraintLayout4, "binding.channelsListItemGuildJoinRequest");
                    constraintLayout4.setVisibility(0);
                    return;
                }
                if (iOrdinal != 2) {
                    ConstraintLayout constraintLayout5 = this.binding.f2292b;
                    m.checkNotNullExpressionValue(constraintLayout5, "binding.channelsListItemGuildJoinRequest");
                    constraintLayout5.setVisibility(8);
                } else {
                    this.binding.d.setText(R.string.member_verification_application_rejected_notice_title);
                    this.binding.c.setText(R.string.member_verification_learn_more);
                    this.binding.c.setBackgroundColor(ColorCompat.getThemedColor(context, R.attr.colorBackgroundAccent));
                    ConstraintLayout constraintLayout6 = this.binding.f2292b;
                    m.checkNotNullExpressionValue(constraintLayout6, "binding.channelsListItemGuildJoinRequest");
                    constraintLayout6.setVisibility(0);
                }
            }
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemGuildRoleSubscriptionsOverview extends Item {
        private final WidgetChannelsListItemGuildRoleSubsBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGuildRoleSubscriptionsOverview(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.directory_channel_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.directory_channel_icon);
            if (imageView != null) {
                i2 = R.id.directory_channel_name;
                TextView textView = (TextView) view.findViewById(R.id.directory_channel_name);
                if (textView != null) {
                    WidgetChannelsListItemGuildRoleSubsBinding widgetChannelsListItemGuildRoleSubsBinding = new WidgetChannelsListItemGuildRoleSubsBinding((LinearLayout) view, imageView, textView);
                    m.checkNotNullExpressionValue(widgetChannelsListItemGuildRoleSubsBinding, "WidgetChannelsListItemGu…ubsBinding.bind(itemView)");
                    this.binding = widgetChannelsListItemGuildRoleSubsBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemGuildRoleSubscriptionsOverview itemGuildRoleSubscriptionsOverview) {
            return (WidgetChannelsListAdapter) itemGuildRoleSubscriptionsOverview.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            LinearLayout linearLayout = this.binding.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.root");
            Context context = linearLayout.getContext();
            m.checkNotNullExpressionValue(context, "context");
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.drawable_overlay_channels, 0, 2, (Object) null);
            LinearLayout linearLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(linearLayout2, "binding.root");
            ViewExtensions.setBackgroundAndKeepPadding(linearLayout2, ContextCompat.getDrawable(context, themedDrawableRes$default));
            this.binding.f2293b.setText(R.string.guild_role_subscriptions_channel_label);
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview$onConfigure$1(this));
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemGuildScheduledEvents extends Item {
        private final WidgetChannelsListItemGuildScheduledEventsBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGuildScheduledEvents(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_list_item_guild_scheduled_event_count;
            TextView textView = (TextView) view.findViewById(R.id.channels_list_item_guild_scheduled_event_count);
            if (textView != null) {
                i2 = R.id.channels_list_item_guild_scheduled_event_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.channels_list_item_guild_scheduled_event_icon);
                if (imageView != null) {
                    i2 = R.id.channels_list_item_guild_scheduled_event_label;
                    TextView textView2 = (TextView) view.findViewById(R.id.channels_list_item_guild_scheduled_event_label);
                    if (textView2 != null) {
                        WidgetChannelsListItemGuildScheduledEventsBinding widgetChannelsListItemGuildScheduledEventsBinding = new WidgetChannelsListItemGuildScheduledEventsBinding((ConstraintLayout) view, textView, imageView, textView2);
                        m.checkNotNullExpressionValue(widgetChannelsListItemGuildScheduledEventsBinding, "WidgetChannelsListItemGu…ntsBinding.bind(itemView)");
                        this.binding = widgetChannelsListItemGuildScheduledEventsBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemGuildScheduledEvents itemGuildScheduledEvents) {
            return (WidgetChannelsListAdapter) itemGuildScheduledEvents.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents = (ChannelListItemGuildScheduledEvents) data;
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            TextView textView = this.binding.f2294b;
            m.checkNotNullExpressionValue(textView, "binding.channelsListItemGuildScheduledEventCount");
            textView.setVisibility(channelListItemGuildScheduledEvents.getData().isEmpty() ^ true ? 0 : 8);
            TextView textView2 = this.binding.f2294b;
            m.checkNotNullExpressionValue(textView2, "binding.channelsListItemGuildScheduledEventCount");
            textView2.setText(String.valueOf(channelListItemGuildScheduledEvents.getData().size()));
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            m.checkNotNullExpressionValue(context, "context");
            ViewExtensions.setBackgroundAndKeepPadding(constraintLayout, ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, R.attr.drawable_overlay_channels, 0, 2, (Object) null)));
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemGuildScheduledEvents$onConfigure$1(this, channelListItemGuildScheduledEvents));
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemHeader extends Item {
        private final WidgetChannelsListItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHeader(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_list_item_header;
            TextView textView = (TextView) view.findViewById(R.id.channels_list_item_header);
            if (textView != null) {
                i2 = R.id.channels_list_new;
                ImageView imageView = (ImageView) view.findViewById(R.id.channels_list_new);
                if (imageView != null) {
                    WidgetChannelsListItemHeaderBinding widgetChannelsListItemHeaderBinding = new WidgetChannelsListItemHeaderBinding((RelativeLayout) view, textView, imageView);
                    m.checkNotNullExpressionValue(widgetChannelsListItemHeaderBinding, "WidgetChannelsListItemHeaderBinding.bind(itemView)");
                    this.binding = widgetChannelsListItemHeaderBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemHeader channelListItemHeader = (ChannelListItemHeader) data;
            int textResId = channelListItemHeader.getTextResId();
            boolean ableToManageChannel = channelListItemHeader.getAbleToManageChannel();
            long selectedGuildId = channelListItemHeader.getSelectedGuildId();
            if (!ableToManageChannel) {
                ImageView imageView = this.binding.c;
                m.checkNotNullExpressionValue(imageView, "binding.channelsListNew");
                imageView.setVisibility(4);
                this.binding.c.setOnClickListener(null);
            } else if (textResId == R.string.others_online) {
                ImageView imageView2 = this.binding.c;
                m.checkNotNullExpressionValue(imageView2, "binding.channelsListNew");
                imageView2.setVisibility(4);
                this.binding.c.setOnClickListener(null);
            } else if (textResId == R.string.text_channels) {
                ImageView imageView3 = this.binding.c;
                m.checkNotNullExpressionValue(imageView3, "binding.channelsListNew");
                imageView3.setVisibility(0);
                this.binding.c.setOnClickListener(new WidgetChannelsListAdapter$ItemHeader$onConfigure$1(selectedGuildId));
            } else if (textResId == R.string.voice_channels) {
                ImageView imageView4 = this.binding.c;
                m.checkNotNullExpressionValue(imageView4, "binding.channelsListNew");
                imageView4.setVisibility(0);
                this.binding.c.setOnClickListener(new WidgetChannelsListAdapter$ItemHeader$onConfigure$2(selectedGuildId));
            }
            this.binding.f2295b.setText(textResId);
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemInvite extends Item {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemInvite(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemInvite itemInvite) {
            return (WidgetChannelsListAdapter) itemInvite.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data instanceof ChannelListItemInvite) {
                this.itemView.setOnClickListener(new WidgetChannelsListAdapter$ItemInvite$onConfigure$1(this, data));
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetChannelsListAdapter$ItemInvite$onConfigure$2(this));
                if (((ChannelListItemInvite) data).isHub()) {
                    WidgetChannelsListItemDirectoryBinding widgetChannelsListItemDirectoryBindingA = WidgetChannelsListItemDirectoryBinding.a(this.itemView);
                    m.checkNotNullExpressionValue(widgetChannelsListItemDirectoryBindingA, "WidgetChannelsListItemDi…oryBinding.bind(itemView)");
                    widgetChannelsListItemDirectoryBindingA.c.setText(R.string.invite_a_friend);
                    widgetChannelsListItemDirectoryBindingA.f2291b.setImageResource(R.drawable.ic_guild_invite_24dp);
                }
            }
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemMFA extends MGRecyclerViewHolder<WidgetChannelsListAdapter, ChannelListItem> {
        private final WidgetChannelsListItemMfaBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemMFA(@LayoutRes int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.channels_list_item_mfa_text);
            if (linkifiedTextView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.channels_list_item_mfa_text)));
            }
            WidgetChannelsListItemMfaBinding widgetChannelsListItemMfaBinding = new WidgetChannelsListItemMfaBinding((LinearLayout) view, linkifiedTextView);
            m.checkNotNullExpressionValue(widgetChannelsListItemMfaBinding, "WidgetChannelsListItemMfaBinding.bind(itemView)");
            this.binding = widgetChannelsListItemMfaBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            LinkifiedTextView linkifiedTextView = this.binding.f2296b;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelsListItemMfaText");
            b.m(linkifiedTextView, R.string.two_fa_guild_mfa_warning, new Object[0], WidgetChannelsListAdapter$ItemMFA$onConfigure$1.INSTANCE);
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemSpace extends MGRecyclerViewHolder<WidgetChannelsListAdapter, ChannelListItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemSpace(@LayoutRes int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = WidgetChannelsListAdapter.access$getBottomNavHeight$p((WidgetChannelsListAdapter) this.adapter);
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            view2.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemStageActiveEvent extends Item {
        private final WidgetChannelsListItemActiveEventBinding binding;

        /* compiled from: WidgetChannelsListAdapter.kt */
        /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemStageActiveEvent$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ WidgetChannelsListAdapter $adapter;

            public AnonymousClass1(WidgetChannelsListAdapter widgetChannelsListAdapter) {
                this.$adapter = widgetChannelsListAdapter;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildScheduledEventLocationInfo.ChannelLocation channelLocation;
                Channel channel;
                if (ItemStageActiveEvent.this.getAdapterPosition() != -1) {
                    ChannelListItem item = this.$adapter.getItem(ItemStageActiveEvent.this.getAdapterPosition());
                    if (!(item instanceof ChannelListItemActiveEvent)) {
                        item = null;
                    }
                    ChannelListItemActiveEvent channelListItemActiveEvent = (ChannelListItemActiveEvent) item;
                    if (channelListItemActiveEvent != null) {
                        GuildScheduledEventLocationInfo locationInfo = channelListItemActiveEvent.getData().getLocationInfo();
                        if ((locationInfo instanceof GuildScheduledEventLocationInfo.ChannelLocation) && (channel = (channelLocation = (GuildScheduledEventLocationInfo.ChannelLocation) locationInfo).getChannel()) != null && ChannelUtils.w(channel)) {
                            this.$adapter.getOnCallChannel().invoke(channelLocation.getChannel());
                        } else {
                            if (!(locationInfo instanceof GuildScheduledEventLocationInfo.ExternalLocation) || channelListItemActiveEvent.getData().getEventId() == null) {
                                return;
                            }
                            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.showForGuild(WidgetChannelsListAdapter.access$getFragmentManager$p(this.$adapter), channelListItemActiveEvent.getData().getEventId().longValue());
                        }
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemStageActiveEvent(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channel_separator;
            ImageView imageView = (ImageView) view.findViewById(R.id.channel_separator);
            if (imageView != null) {
                i2 = R.id.event_channel;
                TextView textView = (TextView) view.findViewById(R.id.event_channel);
                if (textView != null) {
                    i2 = R.id.event_connect_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.event_connect_button);
                    if (materialButton != null) {
                        i2 = R.id.event_topic;
                        TextView textView2 = (TextView) view.findViewById(R.id.event_topic);
                        if (textView2 != null) {
                            i2 = R.id.live_now_dot;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.live_now_dot);
                            if (imageView2 != null) {
                                i2 = R.id.live_now_label;
                                TextView textView3 = (TextView) view.findViewById(R.id.live_now_label);
                                if (textView3 != null) {
                                    i2 = R.id.stage_event_listeners;
                                    TextView textView4 = (TextView) view.findViewById(R.id.stage_event_listeners);
                                    if (textView4 != null) {
                                        i2 = R.id.user_summary;
                                        UserSummaryView userSummaryView = (UserSummaryView) view.findViewById(R.id.user_summary);
                                        if (userSummaryView != null) {
                                            i2 = R.id.user_summary_label;
                                            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.user_summary_label);
                                            if (materialTextView != null) {
                                                WidgetChannelsListItemActiveEventBinding widgetChannelsListItemActiveEventBinding = new WidgetChannelsListItemActiveEventBinding((ConstraintLayout) view, imageView, textView, materialButton, textView2, imageView2, textView3, textView4, userSummaryView, materialTextView);
                                                m.checkNotNullExpressionValue(widgetChannelsListItemActiveEventBinding, "WidgetChannelsListItemAc…entBinding.bind(itemView)");
                                                this.binding = widgetChannelsListItemActiveEventBinding;
                                                materialButton.setOnClickListener(new AnonymousClass1(widgetChannelsListAdapter));
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onConfigure2(int position, ChannelListItem data) {
            String locationName;
            CharSequence username;
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemActiveEventData data2 = ((ChannelListItemActiveEvent) data).getData();
            GuildScheduledEventLocationInfo locationInfo = data2.getLocationInfo();
            if (!(locationInfo instanceof GuildScheduledEventLocationInfo.ChannelLocation)) {
                locationInfo = null;
            }
            GuildScheduledEventLocationInfo.ChannelLocation channelLocation = (GuildScheduledEventLocationInfo.ChannelLocation) locationInfo;
            Channel channel = channelLocation != null ? channelLocation.getChannel() : null;
            int audienceSize = data2.getAudienceSize();
            boolean z2 = channel != null && channel.getType() == 13;
            int i = z2 ? R.drawable.ic_channel_stage_16dp : (channel == null || channel.getType() != 2) ? R.drawable.ic_location_16dp : R.drawable.ic_channel_voice_16dp;
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Drawable drawable = ContextCompat.getDrawable(constraintLayout.getContext(), i);
            this.binding.f.setText(data2.getLocationInfo() instanceof GuildScheduledEventLocationInfo.ExternalLocation ? R.string.live_event : R.string.stage_channel_live_now);
            TextView textView = this.binding.e;
            m.checkNotNullExpressionValue(textView, "binding.eventTopic");
            textView.setText(data2.getTopic());
            TextView textView2 = this.binding.c;
            m.checkNotNullExpressionValue(textView2, "binding.eventChannel");
            if (channel != null) {
                ConstraintLayout constraintLayout2 = this.binding.a;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
                Context context = constraintLayout2.getContext();
                m.checkNotNullExpressionValue(context, "binding.root.context");
                locationName = ChannelUtils.e(channel, context, false, 2);
                if (locationName == null) {
                    locationName = data2.getLocationInfo().getLocationName();
                }
            }
            textView2.setText(locationName);
            this.binding.c.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView3 = this.binding.g;
            m.checkNotNullExpressionValue(textView3, "binding.stageEventListeners");
            textView3.setVisibility(z2 ? 0 : 8);
            TextView textView4 = this.binding.g;
            m.checkNotNullExpressionValue(textView4, "binding.stageEventListeners");
            b.n(textView4, R.string.listening_count, new Object[]{Integer.valueOf(audienceSize)}, null, 4);
            ImageView imageView = this.binding.f2284b;
            m.checkNotNullExpressionValue(imageView, "binding.channelSeparator");
            imageView.setVisibility(z2 ? 0 : 8);
            UserSummaryView userSummaryView = this.binding.h;
            userSummaryView.setVisibility(data2.getSpeakers().isEmpty() ^ true ? 0 : 8);
            if (!data2.getSpeakers().isEmpty()) {
                UserSummaryView.b(userSummaryView, data2.getSpeakers(), false, 2);
            }
            MaterialTextView materialTextView = this.binding.i;
            materialTextView.setVisibility(data2.getSpeakers().isEmpty() ^ true ? 0 : 8);
            if (!data2.getSpeakers().isEmpty()) {
                if (data2.getSpeakers().size() != 1) {
                    Context context2 = materialTextView.getContext();
                    m.checkNotNullExpressionValue(context2, "context");
                    username = b.j(materialTextView, R.string.user_summary_with_others, new Object[]{data2.getSpeakers().get(0).getUser().getUsername(), StringResourceUtilsKt.getI18nPluralString(context2, R.plurals.user_summary_with_others_count, data2.getSpeakers().size() - 1, Integer.valueOf(data2.getSpeakers().size() - 1))}, null, 4);
                } else {
                    username = data2.getSpeakers().get(0).getUser().getUsername();
                }
                materialTextView.setText(username);
            }
            this.binding.d.setText(data2.getLocationInfo() instanceof GuildScheduledEventLocationInfo.ExternalLocation ? R.string.see_detail : !z2 ? R.string.join : R.string.stage_channel_join_button);
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemStageChannelAudienceCount extends Item {
        private final WidgetChannelsListItemAudienceCountBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemStageChannelAudienceCount(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.stage_channel_audience_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.stage_channel_audience_icon);
            if (imageView != null) {
                i2 = R.id.stage_channels_audience_count;
                TextView textView = (TextView) view.findViewById(R.id.stage_channels_audience_count);
                if (textView != null) {
                    WidgetChannelsListItemAudienceCountBinding widgetChannelsListItemAudienceCountBinding = new WidgetChannelsListItemAudienceCountBinding((RelativeLayout) view, imageView, textView);
                    m.checkNotNullExpressionValue(widgetChannelsListItemAudienceCountBinding, "WidgetChannelsListItemAu…untBinding.bind(itemView)");
                    this.binding = widgetChannelsListItemAudienceCountBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemStageAudienceCount channelListItemStageAudienceCount = (ChannelListItemStageAudienceCount) data;
            TextView textView = this.binding.f2285b;
            if (channelListItemStageAudienceCount.getAudienceSize() != 0) {
                b.n(textView, R.string.stage_channel_audience_count, new Object[]{Integer.valueOf(channelListItemStageAudienceCount.getAudienceSize())}, null, 4);
            } else {
                textView.setText(R.string.stage_channel_no_audience);
            }
        }
    }

    /* compiled from: WidgetChannelsListAdapter.kt */
    public static final class ItemVoiceUser extends Item {
        private final WidgetChannelsListItemVoiceUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemVoiceUser(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
            super(i, widgetChannelsListAdapter);
            m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.channels_item_voice_user_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.channels_item_voice_user_avatar);
            if (simpleDraweeView != null) {
                i2 = R.id.channels_item_voice_user_camera;
                ImageView imageView = (ImageView) view.findViewById(R.id.channels_item_voice_user_camera);
                if (imageView != null) {
                    i2 = R.id.channels_item_voice_user_headphones;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.channels_item_voice_user_headphones);
                    if (imageView2 != null) {
                        i2 = R.id.channels_item_voice_user_live;
                        TextView textView = (TextView) view.findViewById(R.id.channels_item_voice_user_live);
                        if (textView != null) {
                            i2 = R.id.channels_item_voice_user_microphone;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.channels_item_voice_user_microphone);
                            if (imageView3 != null) {
                                i2 = R.id.channels_item_voice_user_name;
                                TextView textView2 = (TextView) view.findViewById(R.id.channels_item_voice_user_name);
                                if (textView2 != null) {
                                    i2 = R.id.indicators_container;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.indicators_container);
                                    if (linearLayout != null) {
                                        WidgetChannelsListItemVoiceUserBinding widgetChannelsListItemVoiceUserBinding = new WidgetChannelsListItemVoiceUserBinding((RelativeLayout) view, simpleDraweeView, imageView, imageView2, textView, imageView3, textView2, linearLayout);
                                        m.checkNotNullExpressionValue(widgetChannelsListItemVoiceUserBinding, "WidgetChannelsListItemVo…serBinding.bind(itemView)");
                                        this.binding = widgetChannelsListItemVoiceUserBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(ItemVoiceUser itemVoiceUser) {
            return (WidgetChannelsListAdapter) itemVoiceUser.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
            onConfigure2(i, channelListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelListItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelListItemVoiceUser channelListItemVoiceUser = (ChannelListItemVoiceUser) data;
            Channel channel = channelListItemVoiceUser.getChannel();
            VoiceState voiceState = channelListItemVoiceUser.getVoiceState();
            User user = channelListItemVoiceUser.getUser();
            GuildMember computed = channelListItemVoiceUser.getComputed();
            boolean isApplicationStreaming = channelListItemVoiceUser.getIsApplicationStreaming();
            boolean hasChannelConnectPermission = channelListItemVoiceUser.getHasChannelConnectPermission();
            SimpleDraweeView simpleDraweeView = this.binding.f2299b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsItemVoiceUserAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, R.dimen.avatar_size_small, null, null, channelListItemVoiceUser.getComputed(), 24, null);
            RelativeLayout relativeLayout = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout, new WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$1(this, data));
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$2(this, data));
            TextView textView = this.binding.g;
            m.checkNotNullExpressionValue(textView, "binding.channelsItemVoiceUserName");
            textView.setText(GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, user, computed, channel, null, 8, null));
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.channelsItemVoiceUserCamera");
            imageView.setVisibility(voiceState.getSelfVideo() ? 0 : 8);
            ImageView imageView2 = this.binding.f;
            m.checkNotNullExpressionValue(imageView2, "binding.channelsItemVoiceUserMicrophone");
            imageView2.setVisibility(d.V0(voiceState) ? 0 : 8);
            ImageView imageView3 = this.binding.d;
            m.checkNotNullExpressionValue(imageView3, "binding.channelsItemVoiceUserHeadphones");
            imageView3.setVisibility(voiceState.getSelfDeaf() || voiceState.getDeaf() ? 0 : 8);
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.channelsItemVoiceUserLive");
            textView2.setVisibility(isApplicationStreaming && hasChannelConnectPermission ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter(RecyclerView recyclerView, FragmentManager fragmentManager) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.onSelectChannel = WidgetChannelsListAdapter$onSelectChannel$1.INSTANCE;
        this.onSelectChannelOptions = WidgetChannelsListAdapter$onSelectChannelOptions$1.INSTANCE;
        this.onSelectUserOptions = WidgetChannelsListAdapter$onSelectUserOptions$1.INSTANCE;
        this.onSelectInvite = WidgetChannelsListAdapter$onSelectInvite$1.INSTANCE;
        this.onSelectGuildRoleSubscriptionLockedChannel = WidgetChannelsListAdapter$onSelectGuildRoleSubscriptionLockedChannel$1.INSTANCE;
        this.onCallChannel = WidgetChannelsListAdapter$onCallChannel$1.INSTANCE;
        this.onViewGuildScheduledEvents = WidgetChannelsListAdapter$onViewGuildScheduledEvents$1.INSTANCE;
        this.onViewGuildRoleSubscriptions = WidgetChannelsListAdapter$onViewGuildRoleSubscriptions$1.INSTANCE;
        this.onCollapseCategory = WidgetChannelsListAdapter$onCollapseCategory$1.INSTANCE;
        this.onAddServer = WidgetChannelsListAdapter$onAddServer$1.INSTANCE;
    }

    public static final /* synthetic */ int access$getBottomNavHeight$p(WidgetChannelsListAdapter widgetChannelsListAdapter) {
        return widgetChannelsListAdapter.bottomNavHeight;
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetChannelsListAdapter widgetChannelsListAdapter) {
        return widgetChannelsListAdapter.fragmentManager;
    }

    public static final /* synthetic */ void access$setBottomNavHeight$p(WidgetChannelsListAdapter widgetChannelsListAdapter, int i) {
        widgetChannelsListAdapter.bottomNavHeight = i;
    }

    public final Function0<Unit> getOnAddServer() {
        return this.onAddServer;
    }

    public final Function1<Channel, Unit> getOnCallChannel() {
        return this.onCallChannel;
    }

    public final Function2<Channel, Boolean, Unit> getOnCollapseCategory() {
        return this.onCollapseCategory;
    }

    public final Function1<Channel, Unit> getOnSelectChannel() {
        return this.onSelectChannel;
    }

    public final Function1<Channel, Unit> getOnSelectChannelOptions() {
        return this.onSelectChannelOptions;
    }

    public final Function1<Channel, Unit> getOnSelectGuildRoleSubscriptionLockedChannel() {
        return this.onSelectGuildRoleSubscriptionLockedChannel;
    }

    public final Function1<View, Unit> getOnSelectInvite() {
        return this.onSelectInvite;
    }

    public final Function2<User, Channel, Unit> getOnSelectUserOptions() {
        return this.onSelectUserOptions;
    }

    public final Function0<Unit> getOnViewGuildRoleSubscriptions() {
        return this.onViewGuildRoleSubscriptions;
    }

    public final Function1<Guild, Unit> getOnViewGuildScheduledEvents() {
        return this.onViewGuildScheduledEvents;
    }

    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final void handleBottomNavHeight(int height) {
        this.bottomNavHeight = height;
        notifyItemChanged(getInternalData().lastIndexOf(new ChannelListBottomNavSpaceItem(this.selectedGuildId)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnAddServer(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onAddServer = function0;
    }

    public final void setOnCallChannel(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onCallChannel = function1;
    }

    public final void setOnCollapseCategory(Function2<? super Channel, ? super Boolean, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onCollapseCategory = function2;
    }

    public final void setOnSelectChannel(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectChannel = function1;
    }

    public final void setOnSelectChannelOptions(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectChannelOptions = function1;
    }

    public final void setOnSelectGuildRoleSubscriptionLockedChannel(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectGuildRoleSubscriptionLockedChannel = function1;
    }

    public final void setOnSelectInvite(Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectInvite = function1;
    }

    public final void setOnSelectUserOptions(Function2<? super User, ? super Channel, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onSelectUserOptions = function2;
    }

    public final void setOnViewGuildRoleSubscriptions(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onViewGuildRoleSubscriptions = function0;
    }

    public final void setOnViewGuildScheduledEvents(Function1<? super Guild, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onViewGuildScheduledEvents = function1;
    }

    public final void setSelectedGuildId(long j) {
        this.selectedGuildId = j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ChannelListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        MGRecyclerViewHolder<?, ChannelListItem> itemChannelDirectory;
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ItemChannelText(R.layout.widget_channels_list_item_channel, this);
            case 1:
                return new ItemChannelVoice(R.layout.widget_channels_list_item_channel_voice, this);
            case 2:
                return new ItemVoiceUser(R.layout.widget_channels_list_item_voice_user, this);
            case 3:
                return new ItemChannelPrivate(R.layout.widget_channels_list_item_channel_private, this);
            case 4:
            case 5:
            case 10:
            default:
                throw invalidViewTypeException(viewType);
            case 6:
                return new ItemHeader(R.layout.widget_channels_list_item_header, this);
            case 7:
                return new ItemMFA(R.layout.widget_channels_list_item_mfa, this);
            case 8:
                return new ItemChannelCategory(R.layout.widget_channels_list_item_category, this);
            case 9:
                return new ItemInvite(R.layout.widget_channels_list_item_invite, this);
            case 11:
                return new ItemSpace(R.layout.recycler_item_bottom_nav_space, this);
            case 12:
                return new ItemChannelThread(R.layout.widget_channels_list_item_thread, this);
            case 13:
                return new ItemChannelStageVoice(R.layout.widget_channels_list_item_channel_stage_voice, this);
            case 14:
                return new MGRecyclerViewHolder<>(R.layout.widget_channels_list_item_stage_events_separator, this);
            case 15:
                return new ItemStageActiveEvent(R.layout.widget_channels_list_item_active_event, this);
            case 16:
                return new ItemStageChannelAudienceCount(R.layout.widget_channels_list_item_audience_count, this);
            case 17:
                itemChannelDirectory = new ItemChannelDirectory(R.layout.widget_channels_list_item_directory, this);
                break;
            case 18:
                itemChannelDirectory = new ItemChannelAddServer(R.layout.widget_channels_list_item_directory, this);
                break;
            case 19:
                return new ItemGuildScheduledEvents(R.layout.widget_channels_list_item_guild_scheduled_events, this);
            case 20:
                itemChannelDirectory = new ItemInvite(R.layout.widget_channels_list_item_directory, this);
                break;
            case 21:
                return new ItemGuildRoleSubscriptionsOverview(R.layout.widget_channels_list_item_guild_role_subs, this);
            case 22:
                return new ItemGuildJoinRequest(R.layout.widget_channels_list_item_guild_join_request, this);
        }
        return itemChannelDirectory;
    }
}
