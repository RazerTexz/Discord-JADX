package com.discord.widgets.chat.input;

import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ChatInputViewModel.kt */
/* loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$sendMessage$1 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ MessageManager.AttachmentsRequest $attachmentsRequest;
    public final /* synthetic */ MessageContent $messageContent;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ Function2 $messageSendResultHandler;
    public final /* synthetic */ Function2 $onFilesTooLarge;
    public final /* synthetic */ Function2 $onMessageTooLong;
    public final /* synthetic */ Function1 $onValidationResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$sendMessage$1(MessageManager messageManager, MessageContent messageContent, MessageManager.AttachmentsRequest attachmentsRequest, Function2 function2, Function2 function22, Function2 function23, Function1 function1) {
        super(1);
        this.$messageManager = messageManager;
        this.$messageContent = messageContent;
        this.$attachmentsRequest = attachmentsRequest;
        this.$messageSendResultHandler = function2;
        this.$onMessageTooLong = function22;
        this.$onFilesTooLarge = function23;
        this.$onValidationResult = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(long j) {
        this.$onValidationResult.invoke(Boolean.valueOf(MessageManager.sendMessage$default(this.$messageManager, this.$messageContent.getTextContent(), this.$messageContent.getMentionedUsers(), this.$attachmentsRequest, Long.valueOf(j), null, false, this.$onMessageTooLong, this.$onFilesTooLarge, new C7699x68c0d97b(this), 48, null)));
    }
}
