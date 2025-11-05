package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ChatTypingModel.kt */
/* loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingUsers$1<T, R> implements b<Set<? extends Long>, Observable<? extends List<? extends String>>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: ChatTypingModel.kt */
    /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends String>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends String> call(Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2) {
            return call2(map, (Map<Long, GuildMember>) map2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<String> call2(Map<Long, ? extends User> map, Map<Long, GuildMember> map2) {
            Collection<? extends User> collectionValues = map.values();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                arrayList.add(GuildMember.INSTANCE.getNickOrUsername((GuildMember) a.f(user, map2), user));
            }
            return arrayList;
        }
    }

    public ChatTypingModel$Companion$getTypingUsers$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends String>> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<String>> call2(Set<Long> set) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreUser users = companion.getUsers();
        m.checkNotNullExpressionValue(set, "userIds");
        return Observable.j(users.observeUsers(set), companion.getGuilds().observeComputed(this.$channel.getGuildId(), set), AnonymousClass1.INSTANCE);
    }
}
