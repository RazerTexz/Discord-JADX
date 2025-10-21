package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChannelsSelected;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: ChatTypingModel.kt */
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel2<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends ChatTypingModel>> {
    public static final ChatTypingModel2 INSTANCE = new ChatTypingModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel ? ChatTypingModel.Companion.access$getTypingObservableForChannel(ChatTypingModel.INSTANCE, ((StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel).getChannel()) : resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft ? ChatTypingModel.Companion.access$getTypingObservableForDraft(ChatTypingModel.INSTANCE, ((StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel).getParentChannel()) : new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE);
    }
}
