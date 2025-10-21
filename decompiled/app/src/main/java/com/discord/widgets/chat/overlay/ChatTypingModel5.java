package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import rx.Observable;

/* compiled from: ChatTypingModel.kt */
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForDraft$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel5<T, R> implements Func1<Integer, Observable<? extends ChatTypingModel>> {
    public final /* synthetic */ Channel $parentChannel;

    public ChatTypingModel5(Channel channel) {
        this.$parentChannel = channel;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Integer num) {
        return call2(num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Integer num) {
        List listEmptyList = Collections2.emptyList();
        int rateLimitPerUser = this.$parentChannel.getRateLimitPerUser();
        Intrinsics3.checkNotNullExpressionValue(num, "cooldownSecs");
        return new ScalarSynchronousObservable(new ChatTypingModel.Typing(listEmptyList, rateLimitPerUser, num.intValue()));
    }
}
