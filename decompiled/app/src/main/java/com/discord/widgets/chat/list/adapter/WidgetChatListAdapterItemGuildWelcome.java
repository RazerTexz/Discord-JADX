package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemGuildWelcomeBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildWelcome extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildWelcomeBinding binding;
    private final Clock clock;

    /* compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome$onConfigure$1 */
    public static final class ViewOnClickListenerC80871 implements View.OnClickListener {
        public final /* synthetic */ ChatListEntry $data;

        public ViewOnClickListenerC80871(ChatListEntry chatListEntry) {
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.INSTANCE.create(outline.m885x(view, "view", "view.context"), ((GuildWelcomeEntry) this.$data).getGuildId(), true);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome$onConfigure$2 */
    public static final class ViewOnClickListenerC80882 implements View.OnClickListener {
        public final /* synthetic */ ChatListEntry $data;

        public ViewOnClickListenerC80882(ChatListEntry chatListEntry) {
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShare.Companion.launch$default(WidgetGuildInviteShare.INSTANCE, outline.m885x(view, "view", "view.context"), WidgetChatListAdapterItemGuildWelcome.access$getAdapter$p(WidgetChatListAdapterItemGuildWelcome.this).getFragmentManager(), ((GuildWelcomeEntry) this.$data).getGuildId(), null, false, null, null, "Welcome Message", 120, null);
        }
    }

    public /* synthetic */ WidgetChatListAdapterItemGuildWelcome(WidgetChatListAdapter widgetChatListAdapter, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChatListAdapter, (i & 2) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildWelcome widgetChatListAdapterItemGuildWelcome) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildWelcome.adapter;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildWelcome(WidgetChatListAdapter widgetChatListAdapter, Clock clock) {
        super(C5419R.layout.widget_chat_list_adapter_item_guild_welcome, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        View view = this.itemView;
        int i = C5419R.id.item_guild_welcome_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.item_guild_welcome_header);
        if (textView != null) {
            i = C5419R.id.item_guild_welcome_subheader;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.item_guild_welcome_subheader);
            if (linkifiedTextView != null) {
                i = C5419R.id.item_guild_welcome_subheader_intro;
                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(C5419R.id.item_guild_welcome_subheader_intro);
                if (linkifiedTextView2 != null) {
                    i = C5419R.id.welcome_card_invite_friends;
                    ChatActionItem chatActionItem = (ChatActionItem) view.findViewById(C5419R.id.welcome_card_invite_friends);
                    if (chatActionItem != null) {
                        i = C5419R.id.welcome_card_upload_icon;
                        ChatActionItem chatActionItem2 = (ChatActionItem) view.findViewById(C5419R.id.welcome_card_upload_icon);
                        if (chatActionItem2 != null) {
                            WidgetChatListAdapterItemGuildWelcomeBinding widgetChatListAdapterItemGuildWelcomeBinding = new WidgetChatListAdapterItemGuildWelcomeBinding((LinearLayout) view, textView, linkifiedTextView, linkifiedTextView2, chatActionItem, chatActionItem2);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildWelcomeBinding, "WidgetChatListAdapterIte…omeBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemGuildWelcomeBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof GuildWelcomeEntry) {
            TextView textView = this.binding.f16233b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildWelcomeHeader");
            boolean z2 = true;
            GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) data;
            FormatUtils.m222n(textView, C5419R.string.welcome_cta_title_mobile, new Object[]{guildWelcomeEntry.getGuildName()}, null, 4);
            boolean z3 = (guildWelcomeEntry.getGuildId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < this.clock.currentTimeMillis() - WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD;
            ChatActionItem chatActionItem = this.binding.f16237f;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem, "binding.welcomeCardUploadIcon");
            chatActionItem.setVisibility(!guildWelcomeEntry.getGuildHasIcon() && guildWelcomeEntry.isOwner() ? 0 : 8);
            this.binding.f16237f.setOnClickListener(new ViewOnClickListenerC80871(data));
            ChatActionItem chatActionItem2 = this.binding.f16236e;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem2, "binding.welcomeCardInviteFriends");
            chatActionItem2.setVisibility(guildWelcomeEntry.getCanInvite() ? 0 : 8);
            this.binding.f16236e.setOnClickListener(new ViewOnClickListenerC80882(data));
            String strM822J = outline.m822J(new StringBuilder(), AppHelpDesk.f507a.m149a(360045138571L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-new-user&utm_content=--t%3Apm");
            LinkifiedTextView linkifiedTextView = this.binding.f16235d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.itemGuildWelcomeSubheaderIntro");
            FormatUtils.m222n(linkifiedTextView, C5419R.string.welcome_cta_subtitle_action_with_guide, new Object[]{strM822J}, null, 4);
            LinkifiedTextView linkifiedTextView2 = this.binding.f16235d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.itemGuildWelcomeSubheaderIntro");
            ChatActionItem chatActionItem3 = this.binding.f16237f;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem3, "binding.welcomeCardUploadIcon");
            if (!(chatActionItem3.getVisibility() == 0)) {
                ChatActionItem chatActionItem4 = this.binding.f16236e;
                Intrinsics3.checkNotNullExpressionValue(chatActionItem4, "binding.welcomeCardInviteFriends");
                if (!(chatActionItem4.getVisibility() == 0)) {
                    z2 = false;
                }
            }
            linkifiedTextView2.setVisibility(z2 ? 0 : 8);
            LinkifiedTextView linkifiedTextView3 = this.binding.f16234c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.itemGuildWelcomeSubheader");
            FormatUtils.m222n(linkifiedTextView3, z3 ? C5419R.string.welcome_cta_subtitle_existing_server : guildWelcomeEntry.isOwner() ? C5419R.string.welcome_cta_subtitle_owner : C5419R.string.welcome_cta_subtitle_member, new Object[0], null, 4);
        }
    }
}
