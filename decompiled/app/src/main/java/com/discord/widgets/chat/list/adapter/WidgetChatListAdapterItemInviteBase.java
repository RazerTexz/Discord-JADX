package com.discord.widgets.chat.list.adapter;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.ViewKt;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChatListAdapterItemInviteBase extends WidgetChatListItem {

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$1", m10085f = "WidgetChatListAdapterItemInviteBase.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C80961 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public C80961(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C80961(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((C80961) create(modelInvite, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$2", m10085f = "WidgetChatListAdapterItemInviteBase.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C80972 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public C80972(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C80972(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((C80972) create(modelInvite, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInviteBase(@LayoutRes int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job joinServerOrDM$default(WidgetChatListAdapterItemInviteBase widgetChatListAdapterItemInviteBase, Class cls, ModelInvite modelInvite, Function2 function2, Function2 function22, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinServerOrDM");
        }
        if ((i & 4) != 0) {
            function2 = new C80961(null);
        }
        if ((i & 8) != 0) {
            function22 = new C80972(null);
        }
        return widgetChatListAdapterItemInviteBase.joinServerOrDM(cls, modelInvite, function2, function22);
    }

    public final Job joinServerOrDM(Class<?> javaClass, ModelInvite invite, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished) {
        Intrinsics3.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        InviteJoinHelper inviteJoinHelper = InviteJoinHelper.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return InviteJoinHelper.joinViaInvite$default(inviteJoinHelper, invite, javaClass, (AppFragment) ViewKt.findFragment(view), "Invite Button Embed", null, onInvitePostSuccess, onInviteFlowFinished, null, Opcodes.D2F, null);
    }
}
