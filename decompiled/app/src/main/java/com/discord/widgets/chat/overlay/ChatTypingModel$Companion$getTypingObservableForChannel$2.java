package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ChatTypingModel.kt */
/* loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingObservableForChannel$2<T, R> implements b<Channel, Observable<? extends ChatTypingModel>> {
    public static final ChatTypingModel$Companion$getTypingObservableForChannel$2 INSTANCE = new ChatTypingModel$Companion$getTypingObservableForChannel$2();

    /* compiled from: ChatTypingModel.kt */
    /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<GuildVerificationLevel, Observable<? extends ChatTypingModel>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: ChatTypingModel.kt */
        /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04031<T1, T2, R> implements Func2<List<? extends CharSequence>, Integer, ChatTypingModel.Typing> {
            public C04031() {
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ ChatTypingModel.Typing call(List<? extends CharSequence> list, Integer num) {
                return call2(list, num);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ChatTypingModel.Typing call2(List<? extends CharSequence> list, Integer num) {
                m.checkNotNullExpressionValue(list, "typingUsers");
                int rateLimitPerUser = AnonymousClass1.this.$channel.getRateLimitPerUser();
                m.checkNotNullExpressionValue(num, "cooldownSecs");
                return new ChatTypingModel.Typing(list, rateLimitPerUser, num.intValue());
            }
        }

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(GuildVerificationLevel guildVerificationLevel) {
            return call2(guildVerificationLevel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ChatTypingModel> call2(GuildVerificationLevel guildVerificationLevel) {
            return guildVerificationLevel.compareTo(GuildVerificationLevel.NONE) > 0 ? new k(ChatTypingModel.Hide.INSTANCE) : Observable.j(ChatTypingModel.Companion.access$getTypingUsers(ChatTypingModel.INSTANCE, this.$channel), StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(this.$channel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE), new C04031());
        }
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Channel channel) {
        return channel == null ? new k(ChatTypingModel.Hide.INSTANCE) : GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null).Y(new AnonymousClass1(channel));
    }
}
