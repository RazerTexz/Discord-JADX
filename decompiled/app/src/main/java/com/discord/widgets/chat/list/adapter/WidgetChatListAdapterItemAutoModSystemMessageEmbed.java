package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.AutoModSystemMessageEmbedEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed extends WidgetChatListItem {
    private final WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding binding;
    private final ChannelSelector channelSelector;

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$1 */
    public static final class C80261 extends Lambda implements Function3<Context, String, String, Unit> {
        public static final C80261 INSTANCE = new C80261();

        public C80261() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            Intrinsics3.checkNotNullParameter(context, "clickContext");
            Intrinsics3.checkNotNullParameter(str, "url");
            UriHandler.handleOrUntrusted(context, str, str2);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$2 */
    public static final class C80272 extends Lambda implements Function1<String, Unit> {
        public C80272() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onUrlLongClicked(str);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$3 */
    public static final class C80283 extends Lambda implements Function1<SpoilerNode<?>, Unit> {
        public static final C80283 INSTANCE = new C80283();

        public C80283() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            Intrinsics3.checkNotNullParameter(spoilerNode, "it");
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$4 */
    public static final class C80294 extends Lambda implements Function1<Long, Unit> {
        public C80294() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getData();
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$5 */
    public static final class C80305 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80305(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$context, j);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$1 */
    public static final class ViewOnClickListenerC80311 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public ViewOnClickListenerC80311(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onMessageAuthorLongClicked(this.$messageEntry.getMessage(), this.$messageEntry.getMessage().getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$2 */
    public static final class ViewOnClickListenerC80322 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public ViewOnClickListenerC80322(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onMessageAuthorLongClicked(this.$messageEntry.getMessage(), this.$messageEntry.getMessage().getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3 */
    public static final class C80333 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ int $channelNameLength;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80333(int i) {
            super(1);
            this.$channelNameLength = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("channelHook", new AnonymousClass1());
        }

        /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new SimpleRoundedBackgroundSpan(0, C80333.this.$channelNameLength, DimenUtils.dpToPixels(4), 0, ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), C5419R.attr.colorBackgroundModifierSelected), DimenUtils.dpToPixels(4), Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), C5419R.attr.colorHeaderPrimary)), false, null, 0, 896, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$4 */
    public static final class ViewOnClickListenerC80344 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public ViewOnClickListenerC80344(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector.selectChannel$default(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getChannelSelector$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this), this.$channel, null, StoreChannelsSelected3.THREAD_BROWSER, 2, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$5 */
    public static final class ViewOnClickListenerC80355 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public ViewOnClickListenerC80355(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onReportIssueWithAutoMod(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), this.$messageEntry.getMessage());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$6 */
    public static final class ViewOnClickListenerC80366 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public ViewOnClickListenerC80366(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler();
            Message message = this.$messageEntry.getMessage();
            GuildMember author = this.$messageEntry.getAuthor();
            eventHandler.onMessageAuthorLongClicked(message, author != null ? Long.valueOf(author.getGuildId()) : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModSystemMessageEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_auto_mod_system_message_embed, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.actions_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.actions_button);
        if (textView != null) {
            i = C5419R.id.blocked_message_background;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.blocked_message_background);
            if (imageView != null) {
                i = C5419R.id.blue_shield;
                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.blue_shield);
                if (imageView2 != null) {
                    i = C5419R.id.chat_list_adapter_item_text_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_adapter_item_text_avatar);
                    if (simpleDraweeView != null) {
                        i = C5419R.id.dot_separator;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.dot_separator);
                        if (textView2 != null) {
                            i = C5419R.id.footer_text;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.footer_text);
                            if (textView3 != null) {
                                i = C5419R.id.message_content;
                                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.message_content);
                                if (simpleDraweeSpanTextView != null) {
                                    i = C5419R.id.report_button;
                                    TextView textView4 = (TextView) view.findViewById(C5419R.id.report_button);
                                    if (textView4 != null) {
                                        i = C5419R.id.username;
                                        TextView textView5 = (TextView) view.findViewById(C5419R.id.username);
                                        if (textView5 != null) {
                                            WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding widgetChatListAdapterItemAutoModSystemMessageEmbedBinding = new WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding((ConstraintLayout) view, textView, imageView, imageView2, simpleDraweeView, textView2, textView3, simpleDraweeSpanTextView, textView4, textView5);
                                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemAutoModSystemMessageEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                            this.binding = widgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
                                            this.channelSelector = ChannelSelector.INSTANCE.getInstance();
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemAutoModSystemMessageEmbed.adapter;
    }

    public static final /* synthetic */ ChannelSelector access$getChannelSelector$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed) {
        return widgetChatListAdapterItemAutoModSystemMessageEmbed.channelSelector;
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, AutoModSystemMessageEmbedEntry messageEntry) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), C5419R.attr.colorTextLink, C80261.INSTANCE, new C80272(), ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_spoiler_bg_visible), C80283.INSTANCE, new C80294(), new C80305(context));
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, AutoModSystemMessageEmbedEntry messageEntry, MessageEmbed embed) {
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        String description = embed.getDescription();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, description, getMessageRenderContext(context, messageEntry), messagePreprocessor, DiscordParser.ParserOptions.DEFAULT, z2);
        textView.setVisibility(channelMessage.length() > 0 ? 0 : 8);
        textView.setDraweeSpanStringBuilder(channelMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry = (AutoModSystemMessageEmbedEntry) data;
        int themedColor = ColorCompat.getThemedColor(((WidgetChatListAdapter) this.adapter).getContext(), C5419R.attr.colorHeaderPrimary);
        GuildMember.Companion companion = GuildMember.INSTANCE;
        int color = companion.getColor(autoModSystemMessageEmbedEntry.getAuthor(), themedColor);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16164e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.messageContent");
        processMessageText(simpleDraweeSpanTextView, autoModSystemMessageEmbedEntry, autoModSystemMessageEmbedEntry.getEmbed());
        if (autoModSystemMessageEmbedEntry.getMessage().getAuthor() != null) {
            CoreUser coreUser = new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor());
            SimpleDraweeView simpleDraweeView = this.binding.f16162c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListAdapterItemTextAvatar");
            IconUtils.setIcon$default(simpleDraweeView, new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor()), C5419R.dimen.avatar_size_chat, null, null, autoModSystemMessageEmbedEntry.getAuthor(), 24, null);
            TextView textView = this.binding.f16166g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.username");
            FormatUtils.m223o(textView, companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser), new Object[0], null, 4);
            String nickOrUsername = companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser);
            TextView textView2 = this.binding.f16166g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.username");
            FormatUtils.m223o(textView2, nickOrUsername, new Object[0], null, 4);
            this.binding.f16166g.setTextColor(color);
        }
        this.binding.f16166g.setOnClickListener(new ViewOnClickListenerC80311(autoModSystemMessageEmbedEntry));
        this.binding.f16162c.setOnClickListener(new ViewOnClickListenerC80322(autoModSystemMessageEmbedEntry));
        AutoModUtils autoModUtils = AutoModUtils.INSTANCE;
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(Long.parseLong(autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbed2.getAUTOMOD_EMBED_FIELD_CHANNEL_ID())));
        String strM7681e = channel != null ? ChannelUtils.m7681e(channel, ((WidgetChatListAdapter) this.adapter).getContext(), false, 2) : null;
        int length = strM7681e != null ? strM7681e.length() : 0;
        TextView textView3 = this.binding.f16163d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.footerText");
        FormatUtils.m221m(textView3, C5419R.string.guild_automod_channel_rule_subtext, new Object[]{strM7681e, autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbed2.getAUTOMOD_EMBED_FIELD_RULE_NAME())}, new C80333(length));
        this.binding.f16163d.setOnClickListener(new ViewOnClickListenerC80344(channel));
        this.binding.f16165f.setOnClickListener(new ViewOnClickListenerC80355(autoModSystemMessageEmbedEntry));
        this.binding.f16161b.setOnClickListener(new ViewOnClickListenerC80366(autoModSystemMessageEmbedEntry));
    }
}
