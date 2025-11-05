package com.discord.widgets.guildscheduledevent;

import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventDateView.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CharSequence $eventEndingTimeString$inlined;
    public final /* synthetic */ CharSequence $eventStartingTimeString$inlined;
    public final /* synthetic */ GuildScheduledEventTiming $timing$inlined;
    public final /* synthetic */ GuildScheduledEventDateView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1(GuildScheduledEventDateView guildScheduledEventDateView, CharSequence charSequence, CharSequence charSequence2, GuildScheduledEventTiming guildScheduledEventTiming) {
        super(1);
        this.this$0 = guildScheduledEventDateView;
        this.$eventStartingTimeString$inlined = charSequence;
        this.$eventEndingTimeString$inlined = charSequence2;
        this.$timing$inlined = guildScheduledEventTiming;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* compiled from: GuildScheduledEventDateView.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            m.checkNotNullParameter(hook, "$receiver");
            List<Object> list = hook.styles;
            GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 = GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1.this;
            list.add(new ForegroundColorSpan(GuildScheduledEventDateView.access$getTextColorViaTiming(guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1.this$0, guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1.$timing$inlined)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("startHook", new AnonymousClass1());
    }
}
