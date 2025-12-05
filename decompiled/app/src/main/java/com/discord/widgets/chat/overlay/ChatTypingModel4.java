package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: ChatTypingModel.kt */
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel4<T, R> implements Func1<Channel, Observable<? extends ChatTypingModel>> {
    public static final ChatTypingModel4 INSTANCE = new ChatTypingModel4();

    /* compiled from: ChatTypingModel.kt */
    /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2$1 */
    public static final class C81851<T, R> implements Func1<GuildVerificationLevel, Observable<? extends ChatTypingModel>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: ChatTypingModel.kt */
        /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, R> implements Func2<List<? extends CharSequence>, Integer, ChatTypingModel.Typing> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ ChatTypingModel.Typing call(List<? extends CharSequence> list, Integer num) {
                return call2(list, num);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ChatTypingModel.Typing call2(List<? extends CharSequence> list, Integer num) {
                Intrinsics3.checkNotNullExpressionValue(list, "typingUsers");
                int rateLimitPerUser = C81851.this.$channel.getRateLimitPerUser();
                Intrinsics3.checkNotNullExpressionValue(num, "cooldownSecs");
                return new ChatTypingModel.Typing(list, rateLimitPerUser, num.intValue());
            }
        }

        public C81851(Channel channel) {
            this.$channel = channel;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(GuildVerificationLevel guildVerificationLevel) {
            return call2(guildVerificationLevel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ChatTypingModel> call2(GuildVerificationLevel guildVerificationLevel) {
            return guildVerificationLevel.compareTo(GuildVerificationLevel.NONE) > 0 ? new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE) : Observable.m11076j(ChatTypingModel.Companion.access$getTypingUsers(ChatTypingModel.INSTANCE, this.$channel), StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(this.$channel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE), new AnonymousClass1());
        }
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE) : GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null).m11099Y(new C81851(channel));
    }
}
