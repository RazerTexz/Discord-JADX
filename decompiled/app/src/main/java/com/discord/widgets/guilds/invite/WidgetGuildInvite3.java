package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.error.Error;
import com.discord.widgets.home.HomeConfig;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.AppScreen2;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.boxing;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1 */
    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1", m10085f = "WidgetGuildInvite.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C86461 extends ContinuationImpl6 implements Function2<Error, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public C86461(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C86461 c86461 = WidgetGuildInvite3.this.new C86461(continuation);
            c86461.L$0 = obj;
            return c86461;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Error error, Continuation<? super Unit> continuation) {
            return ((C86461) create(error, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            WidgetGuildInvite.access$configureUIFailure(WidgetGuildInvite3.this.this$0, (Error) this.L$0);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2 */
    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2", m10085f = "WidgetGuildInvite.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C86472 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public C86472(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C86472 c86472 = WidgetGuildInvite3.this.new C86472(continuation);
            c86472.L$0 = obj;
            return c86472;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((C86472) create(modelInvite, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            ModelInvite modelInvite = (ModelInvite) this.L$0;
            Intent intentAddFlags = new Intent().addFlags(268468224);
            Guild guild = modelInvite.guild;
            Long lBoxLong = boxing.boxBoolean(modelInvite.isNewMember()).booleanValue() ? guild != null ? boxing.boxLong(guild.getId()) : null : null;
            GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
            intentAddFlags.putExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG", new HomeConfig(lBoxLong, guildScheduledEvent != null ? boxing.boxLong(guildScheduledEvent.getId()) : null, false, 4, null));
            Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent()\n               …      )\n                }");
            Context context = WidgetGuildInvite3.this.this$0.getContext();
            if (context != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                AppScreen2.m155c(context, false, intentAddFlags, 2);
                AppActivity appActivity = WidgetGuildInvite3.this.this$0.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite3(WidgetGuildInvite widgetGuildInvite, ModelInvite modelInvite) {
        super(0);
        this.this$0 = widgetGuildInvite;
        this.$invite = modelInvite;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        InviteJoinHelper.joinViaInvite$default(InviteJoinHelper.INSTANCE, this.$invite, this.this$0.getClass(), this.this$0, "Accept Invite Page", new C86461(null), null, new C86472(null), null, Opcodes.IF_ICMPNE, null);
    }
}
