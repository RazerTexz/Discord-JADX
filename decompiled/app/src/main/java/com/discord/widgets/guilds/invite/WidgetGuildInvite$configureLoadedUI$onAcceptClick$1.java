package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.error.Error;
import com.discord.widgets.home.HomeConfig;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.b;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.objectweb.asm.Opcodes;

/* compiled from: WidgetGuildInvite.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInvite$configureLoadedUI$onAcceptClick$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* compiled from: WidgetGuildInvite.kt */
    @e(c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1", f = "WidgetGuildInvite.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<Error, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Error error, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(error, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
            WidgetGuildInvite.access$configureUIFailure(WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.this$0, (Error) this.L$0);
            return Unit.a;
        }
    }

    /* compiled from: WidgetGuildInvite.kt */
    @e(c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2", f = "WidgetGuildInvite.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends k implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            AnonymousClass2 anonymousClass2 = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
            ModelInvite modelInvite = (ModelInvite) this.L$0;
            Intent intentAddFlags = new Intent().addFlags(268468224);
            Guild guild = modelInvite.guild;
            Long lBoxLong = b.boxBoolean(modelInvite.isNewMember()).booleanValue() ? guild != null ? b.boxLong(guild.getId()) : null : null;
            GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
            intentAddFlags.putExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG", new HomeConfig(lBoxLong, guildScheduledEvent != null ? b.boxLong(guildScheduledEvent.getId()) : null, false, 4, null));
            m.checkNotNullExpressionValue(intentAddFlags, "Intent()\n               …      )\n                }");
            Context context = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.this$0.getContext();
            if (context != null) {
                m.checkNotNullExpressionValue(context, "context");
                j.c(context, false, intentAddFlags, 2);
                AppActivity appActivity = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.this$0.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite$configureLoadedUI$onAcceptClick$1(WidgetGuildInvite widgetGuildInvite, ModelInvite modelInvite) {
        super(0);
        this.this$0 = widgetGuildInvite;
        this.$invite = modelInvite;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        InviteJoinHelper.joinViaInvite$default(InviteJoinHelper.INSTANCE, this.$invite, this.this$0.getClass(), this.this$0, "Accept Invite Page", new AnonymousClass1(null), null, new AnonymousClass2(null), null, Opcodes.IF_ICMPNE, null);
    }
}
