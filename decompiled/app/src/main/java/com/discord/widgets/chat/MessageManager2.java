package com.discord.widgets.chat;

import com.discord.C5419R;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MessageManager.kt */
/* renamed from: com.discord.widgets.chat.MessageManager$defaultMessageResultHandler$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageManager2 extends Lambda implements Function1<MessageManager.MessageSendResult, Unit> {
    public final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager2(MessageManager messageManager) {
        super(1);
        this.this$0 = messageManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager.MessageSendResult messageSendResult) {
        invoke2(messageSendResult);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager.MessageSendResult messageSendResult) {
        Intrinsics3.checkNotNullParameter(messageSendResult, "messageSendResult");
        MessageQueue4 messageResult = messageSendResult.getMessageResult();
        if (messageResult instanceof MessageQueue4.CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageQueue4.CaptchaRequired) messageResult);
        } else if (messageResult instanceof MessageQueue4.UnknownFailure) {
            SendUtils.handleSendError$default(SendUtils.INSTANCE, ((MessageQueue4.UnknownFailure) messageResult).getError(), MessageManager.access$getContext$p(this.this$0), null, null, 12, null);
        } else if (messageResult instanceof MessageQueue4.Slowmode) {
            AppToast.m169g(MessageManager.access$getContext$p(this.this$0), C5419R.string.channel_slowmode_desc_short, 0, null, 12);
        }
    }
}
