package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.ChatInputViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$onMessageTooLong$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$onMessageTooLong$1(ChatInputViewModel chatInputViewModel) {
        super(2);
        this.this$0 = chatInputViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.f27425a;
    }

    public final void invoke(int i, int i2) {
        PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(this.this$0);
        publishSubjectAccess$getEventSubject$p.f27650k.onNext(new ChatInputViewModel.Event.MessageTooLong(i, i2));
    }
}
