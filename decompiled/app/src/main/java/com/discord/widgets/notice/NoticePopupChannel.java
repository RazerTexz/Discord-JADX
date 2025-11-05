package com.discord.widgets.notice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.g0.t;
import d0.t.n;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import rx.Observable;

/* compiled from: NoticePopupChannel.kt */
/* loaded from: classes2.dex */
public final class NoticePopupChannel {
    public static final NoticePopupChannel INSTANCE = new NoticePopupChannel();

    /* compiled from: NoticePopupChannel.kt */
    public static final /* data */ class Model {
        private final DraweeSpanStringBuilder noticeBody;
        private Drawable noticeBodyBackgroundDrawable;
        private Drawable noticeBodyImageDrawable;
        private String noticeBodyImageUrl;
        private final Drawable noticeIconTopRight;
        private final String noticeIconUrl;
        private final List<Sticker> noticeStickers;
        private final CharSequence noticeSubtitle;
        private final CharSequence noticeTitle;
        private final Function1<View, Unit> onClickTopRightIcon;

        /* JADX WARN: Multi-variable type inference failed */
        public Model(CharSequence charSequence, CharSequence charSequence2, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, Drawable drawable, String str2, Drawable drawable2, Drawable drawable3, Function1<? super View, Unit> function1, List<Sticker> list) {
            m.checkNotNullParameter(charSequence, "noticeTitle");
            m.checkNotNullParameter(draweeSpanStringBuilder, "noticeBody");
            m.checkNotNullParameter(function1, "onClickTopRightIcon");
            this.noticeTitle = charSequence;
            this.noticeSubtitle = charSequence2;
            this.noticeBody = draweeSpanStringBuilder;
            this.noticeIconUrl = str;
            this.noticeBodyBackgroundDrawable = drawable;
            this.noticeBodyImageUrl = str2;
            this.noticeBodyImageDrawable = drawable2;
            this.noticeIconTopRight = drawable3;
            this.onClickTopRightIcon = function1;
            this.noticeStickers = list;
        }

        public static /* synthetic */ Model copy$default(Model model, CharSequence charSequence, CharSequence charSequence2, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, Drawable drawable, String str2, Drawable drawable2, Drawable drawable3, Function1 function1, List list, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.noticeTitle : charSequence, (i & 2) != 0 ? model.noticeSubtitle : charSequence2, (i & 4) != 0 ? model.noticeBody : draweeSpanStringBuilder, (i & 8) != 0 ? model.noticeIconUrl : str, (i & 16) != 0 ? model.noticeBodyBackgroundDrawable : drawable, (i & 32) != 0 ? model.noticeBodyImageUrl : str2, (i & 64) != 0 ? model.noticeBodyImageDrawable : drawable2, (i & 128) != 0 ? model.noticeIconTopRight : drawable3, (i & 256) != 0 ? model.onClickTopRightIcon : function1, (i & 512) != 0 ? model.noticeStickers : list);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getNoticeTitle() {
            return this.noticeTitle;
        }

        public final List<Sticker> component10() {
            return this.noticeStickers;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getNoticeSubtitle() {
            return this.noticeSubtitle;
        }

        /* renamed from: component3, reason: from getter */
        public final DraweeSpanStringBuilder getNoticeBody() {
            return this.noticeBody;
        }

        /* renamed from: component4, reason: from getter */
        public final String getNoticeIconUrl() {
            return this.noticeIconUrl;
        }

        /* renamed from: component5, reason: from getter */
        public final Drawable getNoticeBodyBackgroundDrawable() {
            return this.noticeBodyBackgroundDrawable;
        }

        /* renamed from: component6, reason: from getter */
        public final String getNoticeBodyImageUrl() {
            return this.noticeBodyImageUrl;
        }

        /* renamed from: component7, reason: from getter */
        public final Drawable getNoticeBodyImageDrawable() {
            return this.noticeBodyImageDrawable;
        }

        /* renamed from: component8, reason: from getter */
        public final Drawable getNoticeIconTopRight() {
            return this.noticeIconTopRight;
        }

        public final Function1<View, Unit> component9() {
            return this.onClickTopRightIcon;
        }

        public final Model copy(CharSequence noticeTitle, CharSequence noticeSubtitle, DraweeSpanStringBuilder noticeBody, String noticeIconUrl, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, Drawable noticeIconTopRight, Function1<? super View, Unit> onClickTopRightIcon, List<Sticker> noticeStickers) {
            m.checkNotNullParameter(noticeTitle, "noticeTitle");
            m.checkNotNullParameter(noticeBody, "noticeBody");
            m.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
            return new Model(noticeTitle, noticeSubtitle, noticeBody, noticeIconUrl, noticeBodyBackgroundDrawable, noticeBodyImageUrl, noticeBodyImageDrawable, noticeIconTopRight, onClickTopRightIcon, noticeStickers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.noticeTitle, model.noticeTitle) && m.areEqual(this.noticeSubtitle, model.noticeSubtitle) && m.areEqual(this.noticeBody, model.noticeBody) && m.areEqual(this.noticeIconUrl, model.noticeIconUrl) && m.areEqual(this.noticeBodyBackgroundDrawable, model.noticeBodyBackgroundDrawable) && m.areEqual(this.noticeBodyImageUrl, model.noticeBodyImageUrl) && m.areEqual(this.noticeBodyImageDrawable, model.noticeBodyImageDrawable) && m.areEqual(this.noticeIconTopRight, model.noticeIconTopRight) && m.areEqual(this.onClickTopRightIcon, model.onClickTopRightIcon) && m.areEqual(this.noticeStickers, model.noticeStickers);
        }

        public final DraweeSpanStringBuilder getNoticeBody() {
            return this.noticeBody;
        }

        public final Drawable getNoticeBodyBackgroundDrawable() {
            return this.noticeBodyBackgroundDrawable;
        }

        public final Drawable getNoticeBodyImageDrawable() {
            return this.noticeBodyImageDrawable;
        }

        public final String getNoticeBodyImageUrl() {
            return this.noticeBodyImageUrl;
        }

        public final Drawable getNoticeIconTopRight() {
            return this.noticeIconTopRight;
        }

        public final String getNoticeIconUrl() {
            return this.noticeIconUrl;
        }

        public final List<Sticker> getNoticeStickers() {
            return this.noticeStickers;
        }

        public final CharSequence getNoticeSubtitle() {
            return this.noticeSubtitle;
        }

        public final CharSequence getNoticeTitle() {
            return this.noticeTitle;
        }

        public final Function1<View, Unit> getOnClickTopRightIcon() {
            return this.onClickTopRightIcon;
        }

        public int hashCode() {
            CharSequence charSequence = this.noticeTitle;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.noticeSubtitle;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            DraweeSpanStringBuilder draweeSpanStringBuilder = this.noticeBody;
            int iHashCode3 = (iHashCode2 + (draweeSpanStringBuilder != null ? draweeSpanStringBuilder.hashCode() : 0)) * 31;
            String str = this.noticeIconUrl;
            int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            Drawable drawable = this.noticeBodyBackgroundDrawable;
            int iHashCode5 = (iHashCode4 + (drawable != null ? drawable.hashCode() : 0)) * 31;
            String str2 = this.noticeBodyImageUrl;
            int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Drawable drawable2 = this.noticeBodyImageDrawable;
            int iHashCode7 = (iHashCode6 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
            Drawable drawable3 = this.noticeIconTopRight;
            int iHashCode8 = (iHashCode7 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31;
            Function1<View, Unit> function1 = this.onClickTopRightIcon;
            int iHashCode9 = (iHashCode8 + (function1 != null ? function1.hashCode() : 0)) * 31;
            List<Sticker> list = this.noticeStickers;
            return iHashCode9 + (list != null ? list.hashCode() : 0);
        }

        public final void setNoticeBodyBackgroundDrawable(Drawable drawable) {
            this.noticeBodyBackgroundDrawable = drawable;
        }

        public final void setNoticeBodyImageDrawable(Drawable drawable) {
            this.noticeBodyImageDrawable = drawable;
        }

        public final void setNoticeBodyImageUrl(String str) {
            this.noticeBodyImageUrl = str;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(noticeTitle=");
            sbU.append(this.noticeTitle);
            sbU.append(", noticeSubtitle=");
            sbU.append(this.noticeSubtitle);
            sbU.append(", noticeBody=");
            sbU.append((Object) this.noticeBody);
            sbU.append(", noticeIconUrl=");
            sbU.append(this.noticeIconUrl);
            sbU.append(", noticeBodyBackgroundDrawable=");
            sbU.append(this.noticeBodyBackgroundDrawable);
            sbU.append(", noticeBodyImageUrl=");
            sbU.append(this.noticeBodyImageUrl);
            sbU.append(", noticeBodyImageDrawable=");
            sbU.append(this.noticeBodyImageDrawable);
            sbU.append(", noticeIconTopRight=");
            sbU.append(this.noticeIconTopRight);
            sbU.append(", onClickTopRightIcon=");
            sbU.append(this.onClickTopRightIcon);
            sbU.append(", noticeStickers=");
            return a.L(sbU, this.noticeStickers, ")");
        }
    }

    /* compiled from: NoticePopupChannel.kt */
    /* renamed from: com.discord.widgets.notice.NoticePopupChannel$enqueue$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function9<Context, Message, Guild, Channel, Map<Long, ? extends GuildMember>, Long, User, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, Model> {
        public AnonymousClass1(NoticePopupChannel noticePopupChannel) {
            super(9, noticePopupChannel, NoticePopupChannel.class, "createModel", "createModel(Landroid/content/Context;Lcom/discord/models/message/Message;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/models/user/User;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/notice/NoticePopupChannel$Model;", 0);
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ Model invoke(Context context, Message message, Guild guild, Channel channel, Map<Long, ? extends GuildMember> map, Long l, User user, Map<Long, ? extends String> map2, Map<Long, ? extends GuildRole> map3) {
            return invoke2(context, message, guild, channel, (Map<Long, GuildMember>) map, l, user, (Map<Long, String>) map2, (Map<Long, GuildRole>) map3);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Model invoke2(Context context, Message message, Guild guild, Channel channel, Map<Long, GuildMember> map, Long l, User user, Map<Long, String> map2, Map<Long, GuildRole> map3) {
            m.checkNotNullParameter(context, "p1");
            m.checkNotNullParameter(message, "p2");
            m.checkNotNullParameter(map, "p5");
            m.checkNotNullParameter(user, "p7");
            m.checkNotNullParameter(map2, "p8");
            m.checkNotNullParameter(map3, "p9");
            return NoticePopupChannel.access$createModel((NoticePopupChannel) this.receiver, context, message, guild, channel, map, l, user, map2, map3);
        }
    }

    /* compiled from: NoticePopupChannel.kt */
    /* renamed from: com.discord.widgets.notice.NoticePopupChannel$enqueue$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Model, Unit> {
        public final /* synthetic */ String $noticeName;
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Function1 function1) {
            super(1);
            this.$noticeName = str;
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            if (model != null) {
                NoticePopup.enqueue$default(NoticePopup.INSTANCE, this.$noticeName, model.getNoticeTitle(), model.getNoticeSubtitle(), model.getNoticeBody(), model.getNoticeBodyBackgroundDrawable(), model.getNoticeBodyImageUrl(), model.getNoticeBodyImageDrawable(), model.getNoticeStickers(), model.getNoticeIconUrl(), null, model.getNoticeIconTopRight(), null, null, model.getOnClickTopRightIcon(), this.$onClick, 6656, null);
            }
        }
    }

    private NoticePopupChannel() {
    }

    public static final /* synthetic */ Model access$createModel(NoticePopupChannel noticePopupChannel, Context context, Message message, Guild guild, Channel channel, Map map, Long l, User user, Map map2, Map map3) {
        return noticePopupChannel.createModel(context, message, guild, channel, map, l, user, map2, map3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.discord.api.message.attachment.MessageAttachment] */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.graphics.drawable.Drawable] */
    private final Model createModel(Context context, Message message, Guild guild, Channel channel, Map<Long, GuildMember> members, Long selectedChannel, User meUser, Map<Long, String> channelNames, Map<Long, GuildRole> roles) {
        DraweeSpanStringBuilder draweeSpanStringBuilder;
        Pair pair;
        Integer num;
        Channel channel2;
        String forChannel$default;
        Context context2;
        int i;
        Object proxyUrl;
        Object drawable$default;
        Object obj;
        Object obj2;
        MessageEmbed messageEmbed;
        if (channel != null) {
            long id2 = channel.getId();
            if (selectedChannel == null || selectedChannel.longValue() != id2) {
                MessageRenderContext messageRenderContext = new MessageRenderContext(context, meUser.getId(), true, MessageUtils.getNickOrUsernames$default(message, channel, members, null, 8, null), channelNames, roles, 0, null, NoticePopupChannel$createModel$messageRenderContext$1.INSTANCE, ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_inapp_bg), 0, null, null, null, 15552, null);
                String content = message.getContent();
                if (content == null || (draweeSpanStringBuilder = AstRenderer.render(Parser.parse$default(DiscordParser.createParser$default(false, true, false, false, false, 28, null), content, MessageParseState.INSTANCE.getInitialState(), null, 4, null), messageRenderContext)) == null) {
                    draweeSpanStringBuilder = new DraweeSpanStringBuilder();
                }
                DraweeSpanStringBuilder draweeSpanStringBuilder2 = draweeSpanStringBuilder;
                if (t.isBlank(draweeSpanStringBuilder2)) {
                    List<MessageEmbed> embeds = message.getEmbeds();
                    String title = (embeds == null || (messageEmbed = (MessageEmbed) u.firstOrNull((List) embeds)) == null) ? null : messageEmbed.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    draweeSpanStringBuilder2.append((CharSequence) title);
                }
                long guildId = channel.getGuildId();
                if (guildId == -1 || guildId == 0) {
                    pair = d0.o.to(ChannelUtils.c(channel), null);
                    num = null;
                } else {
                    String name = guild != null ? guild.getName() : null;
                    String str = name != null ? name : "";
                    StringBuilder sbQ = a.Q(MentionUtilsKt.CHANNELS_CHAR);
                    sbQ.append(ChannelUtils.c(channel));
                    num = null;
                    pair = d0.o.to(str, sbQ.toString());
                }
                String str2 = (String) pair.component1();
                String str3 = (String) pair.component2();
                if (ChannelUtils.v(channel)) {
                    forChannel$default = IconUtils.getForGuild$default(guild, IconUtils.DEFAULT_ICON_BLURPLE, false, null, 12, null);
                    channel2 = channel;
                } else {
                    channel2 = channel;
                    forChannel$default = IconUtils.getForChannel$default(channel2, num, 2, num);
                }
                String str4 = forChannel$default;
                if (ChannelUtils.m(channel)) {
                    context2 = context;
                    i = 2;
                } else {
                    com.discord.api.user.User author = message.getAuthor();
                    m.checkNotNull(author);
                    CoreUser coreUser = new CoreUser(author);
                    i = 2;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a.w(GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, coreUser, members.get(Long.valueOf(coreUser.getId())), channel, null, 8, null), ": "));
                    context2 = context;
                    Iterator it = n.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context2, R.attr.primary_000)), new StyleSpan(1)).iterator();
                    while (it.hasNext()) {
                        spannableStringBuilder.setSpan(it.next(), 0, spannableStringBuilder.length(), 33);
                    }
                    draweeSpanStringBuilder2.insert(0, (CharSequence) spannableStringBuilder);
                }
                List<MessageAttachment> attachments = message.getAttachments();
                ?? r0 = attachments != null ? (MessageAttachment) u.firstOrNull((List) attachments) : num;
                if (r0 == 0 || !r0.h()) {
                    if ((r0 != 0 ? r0.e() : num) == MessageAttachmentType.IMAGE) {
                        proxyUrl = r0.getProxyUrl();
                    } else {
                        if ((r0 != 0 ? r0.e() : num) == MessageAttachmentType.VIDEO) {
                            Object drawable$default2 = DrawableCompat.getDrawable$default(context, R.drawable.rounded_rectangle_4dp_radius, ColorCompat.getThemedColor(context2, R.attr.colorBackgroundSecondary), false, 4, null);
                            drawable$default = DrawableCompat.getDrawable$default(context, R.drawable.ic_play_circle_outline_white_24dp, ColorCompat.getThemedColor(context2, R.attr.colorInteractiveActive), false, 4, null);
                            obj = num;
                            obj2 = drawable$default2;
                        } else {
                            proxyUrl = num;
                        }
                    }
                    drawable$default = num;
                    obj2 = drawable$default;
                    obj = proxyUrl;
                } else {
                    drawable$default = ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, R.attr.theme_chat_spoiler_inapp_bg, 0, i, num));
                    Object obj3 = num;
                    obj2 = obj3;
                    obj = obj3;
                }
                return new Model(str2, str3, draweeSpanStringBuilder2, str4, obj2, obj, drawable$default, ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, ChannelUtils.B(channel) ? R.attr.ic_close_24dp : R.attr.ic_settings, 0, i, num)), new NoticePopupChannel$createModel$onClickTopRightIcon$1(channel2, context2), message.getStickers());
            }
        }
        return null;
    }

    public final void enqueue(Context context, String noticeName, Message message, Function1<? super View, Unit> onClick) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(noticeName, "noticeName");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(onClick, "onClick");
        j0.l.e.k kVar = new j0.l.e.k(context);
        j0.l.e.k kVar2 = new j0.l.e.k(message);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Guild> observableObserveFromChannelId = companion.getGuilds().observeFromChannelId(message.getChannelId());
        Observable<Channel> observableObserveChannel = companion.getChannels().observeChannel(message.getChannelId());
        StoreGuilds guilds = companion.getGuilds();
        Long guildId = message.getGuildId();
        Observable<Map<Long, GuildMember>> observableObserveComputed = guilds.observeComputed(guildId != null ? guildId.longValue() : 0L);
        Observable<Long> observableObserveId = companion.getChannelsSelected().observeId();
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
        Observable<Map<Long, String>> observableObserveNames = companion.getChannels().observeNames();
        StoreGuilds guilds2 = companion.getGuilds();
        Long guildId2 = message.getGuildId();
        Observable observableC = Observable.c(kVar, kVar2, observableObserveFromChannelId, observableObserveChannel, observableObserveComputed, observableObserveId, observableObserveMe$default, observableObserveNames, guilds2.observeRoles(guildId2 != null ? guildId2.longValue() : 0L), new NoticePopupChannel$sam$rx_functions_Func9$0(new AnonymousClass1(this)));
        m.checkNotNullExpressionValue(observableC, "Observable\n        .comb…is::createModel\n        )");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableC, 0L, false, 3, null))), NoticePopupChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(noticeName, onClick), 62, (Object) null);
    }
}
