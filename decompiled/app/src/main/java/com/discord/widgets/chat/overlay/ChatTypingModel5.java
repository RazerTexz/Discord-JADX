package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForDraft$1, reason: use source file name */
/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel5<T, R> implements Func1<Integer, Observable<? extends ChatTypingModel>> {
    public final /* synthetic */ Channel $parentChannel;

    public ChatTypingModel5(Channel channel) {
        this.$parentChannel = channel;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Integer num) {
        List listEmptyList = Collections2.emptyList();
        int rateLimitPerUser = this.$parentChannel.getRateLimitPerUser();
        Intrinsics3.checkNotNullExpressionValue(num, "cooldownSecs");
        return new ScalarSynchronousObservable(new ChatTypingModel.Typing(listEmptyList, rateLimitPerUser, num.intValue()));
    }
}
