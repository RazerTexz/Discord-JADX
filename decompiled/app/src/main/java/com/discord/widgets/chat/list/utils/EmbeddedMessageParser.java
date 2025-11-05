package com.discord.widgets.chat.list.utils;

import android.content.Context;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.Regex;

/* compiled from: EmbeddedMessageParser.kt */
/* loaded from: classes2.dex */
public final class EmbeddedMessageParser {
    public static final EmbeddedMessageParser INSTANCE = new EmbeddedMessageParser();

    /* compiled from: EmbeddedMessageParser.kt */
    public static final /* data */ class ParserData {
        private final WidgetChatListAdapter adapter;
        private final boolean animateEmojis;
        private final Context context;
        private final Integer maxNodes;
        private final Message message;
        private final StoreMessageState.State messageState;
        private final Map<Long, String> nickOrUsernames;
        private final Map<Long, GuildRole> roleMentions;

        public ParserData(Context context, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, StoreMessageState.State state, Integer num, Message message, WidgetChatListAdapter widgetChatListAdapter) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(map2, "nickOrUsernames");
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(widgetChatListAdapter, "adapter");
            this.context = context;
            this.roleMentions = map;
            this.nickOrUsernames = map2;
            this.animateEmojis = z2;
            this.messageState = state;
            this.maxNodes = num;
            this.message = message;
            this.adapter = widgetChatListAdapter;
        }

        public static /* synthetic */ ParserData copy$default(ParserData parserData, Context context, Map map, Map map2, boolean z2, StoreMessageState.State state, Integer num, Message message, WidgetChatListAdapter widgetChatListAdapter, int i, Object obj) {
            return parserData.copy((i & 1) != 0 ? parserData.context : context, (i & 2) != 0 ? parserData.roleMentions : map, (i & 4) != 0 ? parserData.nickOrUsernames : map2, (i & 8) != 0 ? parserData.animateEmojis : z2, (i & 16) != 0 ? parserData.messageState : state, (i & 32) != 0 ? parserData.maxNodes : num, (i & 64) != 0 ? parserData.message : message, (i & 128) != 0 ? parserData.adapter : widgetChatListAdapter);
        }

        /* renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        public final Map<Long, GuildRole> component2() {
            return this.roleMentions;
        }

        public final Map<Long, String> component3() {
            return this.nickOrUsernames;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        /* renamed from: component5, reason: from getter */
        public final StoreMessageState.State getMessageState() {
            return this.messageState;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getMaxNodes() {
            return this.maxNodes;
        }

        /* renamed from: component7, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component8, reason: from getter */
        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final ParserData copy(Context context, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, StoreMessageState.State messageState, Integer maxNodes, Message message, WidgetChatListAdapter adapter) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(adapter, "adapter");
            return new ParserData(context, roleMentions, nickOrUsernames, animateEmojis, messageState, maxNodes, message, adapter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParserData)) {
                return false;
            }
            ParserData parserData = (ParserData) other;
            return m.areEqual(this.context, parserData.context) && m.areEqual(this.roleMentions, parserData.roleMentions) && m.areEqual(this.nickOrUsernames, parserData.nickOrUsernames) && this.animateEmojis == parserData.animateEmojis && m.areEqual(this.messageState, parserData.messageState) && m.areEqual(this.maxNodes, parserData.maxNodes) && m.areEqual(this.message, parserData.message) && m.areEqual(this.adapter, parserData.adapter);
        }

        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final Context getContext() {
            return this.context;
        }

        public final Integer getMaxNodes() {
            return this.maxNodes;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final StoreMessageState.State getMessageState() {
            return this.messageState;
        }

        public final Map<Long, String> getNickOrUsernames() {
            return this.nickOrUsernames;
        }

        public final Map<Long, GuildRole> getRoleMentions() {
            return this.roleMentions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Context context = this.context;
            int iHashCode = (context != null ? context.hashCode() : 0) * 31;
            Map<Long, GuildRole> map = this.roleMentions;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, String> map2 = this.nickOrUsernames;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.animateEmojis;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            StoreMessageState.State state = this.messageState;
            int iHashCode4 = (i2 + (state != null ? state.hashCode() : 0)) * 31;
            Integer num = this.maxNodes;
            int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
            Message message = this.message;
            int iHashCode6 = (iHashCode5 + (message != null ? message.hashCode() : 0)) * 31;
            WidgetChatListAdapter widgetChatListAdapter = this.adapter;
            return iHashCode6 + (widgetChatListAdapter != null ? widgetChatListAdapter.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ParserData(context=");
            sbU.append(this.context);
            sbU.append(", roleMentions=");
            sbU.append(this.roleMentions);
            sbU.append(", nickOrUsernames=");
            sbU.append(this.nickOrUsernames);
            sbU.append(", animateEmojis=");
            sbU.append(this.animateEmojis);
            sbU.append(", messageState=");
            sbU.append(this.messageState);
            sbU.append(", maxNodes=");
            sbU.append(this.maxNodes);
            sbU.append(", message=");
            sbU.append(this.message);
            sbU.append(", adapter=");
            sbU.append(this.adapter);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: EmbeddedMessageParser.kt */
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function3<Context, String, String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            m.checkNotNullParameter(context, "clickContext");
            m.checkNotNullParameter(str, "url");
            UriHandler.handleOrUntrusted(context, str, str2);
        }
    }

    /* compiled from: EmbeddedMessageParser.kt */
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<String, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "url");
            this.$parserData.getAdapter().getEventHandler().onUrlLongClicked(str);
        }
    }

    /* compiled from: EmbeddedMessageParser.kt */
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Long, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = this.$parserData.getAdapter().getData();
            this.$parserData.getAdapter().getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* compiled from: EmbeddedMessageParser.kt */
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Long, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$parserData.getContext(), j);
        }
    }

    private EmbeddedMessageParser() {
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState, Integer maxNodes) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, false, maxNodes);
    }

    private final MessageRenderContext getMessageRenderContext(ParserData parserData) {
        return new MessageRenderContext(parserData.getContext(), parserData.getAdapter().getData().getUserId(), parserData.getAnimateEmojis(), parserData.getNickOrUsernames(), parserData.getAdapter().getData().getChannelNames(), parserData.getRoleMentions(), R.attr.colorTextLink, AnonymousClass1.INSTANCE, new AnonymousClass2(parserData), ColorCompat.getThemedColor(parserData.getContext(), R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(parserData.getContext(), R.attr.theme_chat_spoiler_bg_visible), null, new AnonymousClass3(parserData), new AnonymousClass4(parserData));
    }

    public final DraweeSpanStringBuilder parse(ParserData parserData) {
        m.checkNotNullParameter(parserData, "parserData");
        MessageRenderContext messageRenderContext = getMessageRenderContext(parserData);
        User author = parserData.getMessage().getAuthor();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(author != null ? author.getId() : 0L, parserData.getMessage(), parserData.getMessageState(), parserData.getMaxNodes());
        String content = parserData.getMessage().getContent();
        if (content == null) {
            content = "";
        }
        Context context = parserData.getContext();
        String property = System.getProperty("line.separator");
        Objects.requireNonNull(property);
        m.checkNotNullExpressionValue(property, "Objects.requireNonNull(S…operty(\"line.separator\"))");
        return DiscordParser.parseChannelMessage(context, new Regex(property).replace(content, " "), messageRenderContext, messagePreprocessor, DiscordParser.ParserOptions.REPLY, false);
    }
}
