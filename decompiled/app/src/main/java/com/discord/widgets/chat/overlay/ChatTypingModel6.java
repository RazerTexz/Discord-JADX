package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: ChatTypingModel.kt */
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel6<T, R> implements Func1<Set<? extends Long>, Observable<? extends List<? extends String>>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: ChatTypingModel.kt */
    /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1$1 */
    public static final class C81861<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends String>> {
        public static final C81861 INSTANCE = new C81861();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends String> call(Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2) {
            return call2(map, (Map<Long, GuildMember>) map2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<String> call2(Map<Long, ? extends User> map, Map<Long, GuildMember> map2) {
            Collection<? extends User> collectionValues = map.values();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                arrayList.add(GuildMember.INSTANCE.getNickOrUsername((GuildMember) outline.m849f(user, map2), user));
            }
            return arrayList;
        }
    }

    public ChatTypingModel6(Channel channel) {
        this.$channel = channel;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends String>> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<String>> call2(Set<Long> set) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreUser users = companion.getUsers();
        Intrinsics3.checkNotNullExpressionValue(set, "userIds");
        return Observable.m11076j(users.observeUsers(set), companion.getGuilds().observeComputed(this.$channel.getGuildId(), set), C81861.INSTANCE);
    }
}
