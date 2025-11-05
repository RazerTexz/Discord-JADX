package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.search.SearchUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$4 extends o implements Function2<Channel, String, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;

    /* compiled from: WidgetGlobalSearchModel.kt */
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$4$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<WidgetGlobalSearchModel.MatchedResult> {
        public final /* synthetic */ String $channelFilter;
        public final /* synthetic */ Channel $this_toItemChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, String str) {
            super(0);
            this.$this_toItemChannel = channel;
            this.$channelFilter = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.MatchedResult invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @SuppressLint({"DefaultLocale"})
        public final WidgetGlobalSearchModel.MatchedResult invoke() {
            String name;
            Guild guild = (Guild) a.c(this.$this_toItemChannel, WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getGuilds());
            if (guild == null || (name = guild.getName()) == null) {
                name = "";
            }
            Channel channel = WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getChannels().get(Long.valueOf(this.$this_toItemChannel.getParentId()));
            String strC = channel != null ? ChannelUtils.c(channel) : "";
            SearchUtils searchUtils = SearchUtils.INSTANCE;
            String str = this.$channelFilter;
            Locale locale = Locale.ROOT;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String str2 = ChannelUtils.c(this.$this_toItemChannel) + ' ' + strC + ' ' + name;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = str2.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (searchUtils.fuzzyMatch(lowerCase, lowerCase2)) {
                return new WidgetGlobalSearchModel.MatchedResult(ChannelUtils.c(this.$this_toItemChannel), -1, this.$channelFilter.length());
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$4(WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.SearchContext searchContext) {
        super(2);
        this.$channelContext = channelContext;
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$searchContext = searchContext;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel, String str) {
        return invoke2(channel, str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemDataPayload invoke2(Channel channel, String str) {
        m.checkNotNullParameter(channel, "$this$toItemChannel");
        m.checkNotNullParameter(str, "channelFilter");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channel, str);
        if (channel.getType() == 1) {
            User userA = ChannelUtils.a(channel);
            if (userA != null) {
                return this.$toItemUser$2.invoke2(userA, str, channel);
            }
            return null;
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult = WidgetGlobalSearchModel.INSTANCE.toMatchedResult(ChannelUtils.c(channel), str);
        if (matchedResult == null) {
            matchedResult = anonymousClass1.invoke();
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult2 = matchedResult;
        if (matchedResult2 == null) {
            return null;
        }
        Channel channel2 = this.$channelContext.getChannels().get(Long.valueOf(channel.getParentId()));
        Guild guild = (Guild) a.c(channel, this.$channelContext.getGuilds());
        Integer num = (Integer) a.d(channel, this.$searchContext.getMentionCounts());
        return new WidgetGlobalSearchModel.ItemChannel(matchedResult2, channel, channel2, guild, num != null ? num.intValue() : 0, this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(channel.getId())));
    }
}
