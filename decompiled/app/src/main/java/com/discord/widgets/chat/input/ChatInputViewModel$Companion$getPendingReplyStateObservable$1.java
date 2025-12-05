package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.ChatInputViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: ChatInputViewModel.kt */
/* loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getPendingReplyStateObservable$1<T, R> implements Func1<StorePendingReplies.PendingReply, Observable<? extends ChatInputViewModel.StoreState.Loaded.PendingReply>> {
    public static final ChatInputViewModel$Companion$getPendingReplyStateObservable$1 INSTANCE = new ChatInputViewModel$Companion$getPendingReplyStateObservable$1();

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$Companion$getPendingReplyStateObservable$1$1 */
    public static final class C76861<T1, T2, R> implements Func2<User, GuildMember, ChatInputViewModel.StoreState.Loaded.PendingReply> {
        public final /* synthetic */ StorePendingReplies.PendingReply $pendingReply;

        public C76861(StorePendingReplies.PendingReply pendingReply) {
            this.$pendingReply = pendingReply;
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ ChatInputViewModel.StoreState.Loaded.PendingReply call(User user, GuildMember guildMember) {
            return call2(user, guildMember);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ChatInputViewModel.StoreState.Loaded.PendingReply call2(User user, GuildMember guildMember) {
            return new ChatInputViewModel.StoreState.Loaded.PendingReply(this.$pendingReply, user, guildMember);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatInputViewModel.StoreState.Loaded.PendingReply> call2(StorePendingReplies.PendingReply pendingReply) {
        Observable<R> scalarSynchronousObservable;
        if (pendingReply == null) {
            return new ScalarSynchronousObservable(null);
        }
        if (pendingReply.getOriginalMessage().isWebhook()) {
            com.discord.api.user.User author = pendingReply.getOriginalMessage().getAuthor();
            Intrinsics3.checkNotNull(author);
            return new ScalarSynchronousObservable(new ChatInputViewModel.StoreState.Loaded.PendingReply(pendingReply, new CoreUser(author), null));
        }
        com.discord.api.user.User author2 = pendingReply.getOriginalMessage().getAuthor();
        Intrinsics3.checkNotNull(author2);
        long id2 = author2.getId();
        Long guildId = pendingReply.getMessageReference().getGuildId();
        if (guildId != null) {
            scalarSynchronousObservable = StoreStream.INSTANCE.getGuilds().observeComputed(guildId.longValue()).m11083G(new C7685xa2dc426d(id2)).m11112r();
        } else {
            scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        }
        return Observable.m11076j(StoreStream.INSTANCE.getUsers().observeUser(id2), scalarSynchronousObservable, new C76861(pendingReply));
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatInputViewModel.StoreState.Loaded.PendingReply> call(StorePendingReplies.PendingReply pendingReply) {
        return call2(pendingReply);
    }
}
