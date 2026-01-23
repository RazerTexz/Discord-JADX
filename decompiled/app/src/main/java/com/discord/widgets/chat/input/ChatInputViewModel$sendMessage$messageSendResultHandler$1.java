package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.ChatInputViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageSendResultHandler$1 extends Lambda implements Function2<MessageQueue4, Guild, Unit> {
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isThreadDraft;
    public final /* synthetic */ ChatInputViewModel.ViewState.Loaded $loadedViewState;
    public final /* synthetic */ Function0 $messageResendCompressedHandler;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$messageSendResultHandler$1$1 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class C76971 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Guild $guild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C76971(Guild guild) {
            super(0);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            Guild guild = this.$guild;
            int iMax = Math.max(premiumUtils.getGuildMaxFileSizeMB(guild != null ? guild.getPremiumTier() : 0), premiumUtils.getMaxFileSizeMB(ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$loadedViewState.getMe()));
            PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.this$0);
            MeUser me2 = ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$loadedViewState.getMe();
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(new ChatInputViewModel.Event.FilesTooLarge(iMax, Float.MAX_VALUE, Float.MAX_VALUE, me2 != null ? UserUtils.INSTANCE.isPremium(me2) : false, ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getAttachments(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getHasImage(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getHasVideo(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getHasGif(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$messageResendCompressedHandler));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$messageSendResultHandler$1$2 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class C76982 extends Lambda implements Function0<Unit> {
        public C76982() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.this$0);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(ChatInputViewModel.Event.FailedDeliveryToRecipient.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$messageSendResultHandler$1(ChatInputViewModel chatInputViewModel, Context context, ChatInputViewModel.ViewState.Loaded loaded, ChatInputViewModel.AttachmentContext attachmentContext, Function0 function0, boolean z2) {
        super(2);
        this.this$0 = chatInputViewModel;
        this.$context = context;
        this.$loadedViewState = loaded;
        this.$attachmentsContext = attachmentContext;
        this.$messageResendCompressedHandler = function0;
        this.$isThreadDraft = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4, Guild guild) {
        invoke2(messageQueue4, guild);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageQueue4 messageQueue4, Guild guild) {
        Intrinsics3.checkNotNullParameter(messageQueue4, "messageResult");
        if (messageQueue4 instanceof MessageQueue4.CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageQueue4.CaptchaRequired) messageQueue4);
        } else if (messageQueue4 instanceof MessageQueue4.UnknownFailure) {
            SendUtils.INSTANCE.handleSendError(((MessageQueue4.UnknownFailure) messageQueue4).getError(), this.$context, new C76971(guild), new C76982());
        } else if (this.$isThreadDraft) {
            ChatInputViewModel.access$getStoreThreadDraft$p(this.this$0).clearDraftState();
        }
    }
}
