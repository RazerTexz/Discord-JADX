package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.ChatInputViewModel;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import rx.subjects.PublishSubject;

/* compiled from: ChatInputViewModel.kt */
/* loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$onFilesTooLarge$1 extends Lambda implements Function2<Integer, Boolean, Unit> {
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ Function0 $messageResendCompressedHandler;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$onFilesTooLarge$1(ChatInputViewModel chatInputViewModel, ChatInputViewModel.AttachmentContext attachmentContext, Function0 function0) {
        super(2);
        this.this$0 = chatInputViewModel;
        this.$attachmentsContext = attachmentContext;
        this.$messageResendCompressedHandler = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool) {
        invoke(num.intValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(int i, boolean z2) {
        PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(this.this$0);
        publishSubjectAccess$getEventSubject$p.k.onNext(new ChatInputViewModel.Event.FilesTooLarge(i, this.$attachmentsContext.getCurrentFileSizeMB(), this.$attachmentsContext.getMaxAttachmentSizeMB(), z2, this.$attachmentsContext.getAttachments(), this.$attachmentsContext.getHasImage(), this.$attachmentsContext.getHasVideo(), this.$attachmentsContext.getHasGif(), this.$messageResendCompressedHandler));
    }
}
