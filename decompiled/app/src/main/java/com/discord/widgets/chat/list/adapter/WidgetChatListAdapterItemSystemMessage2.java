package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.textprocessing.FontColorSpan;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$actorRenderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorRoleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage2(int i) {
        super(1);
        this.$authorRoleColor = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$actorRenderContext$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new FontColorSpan(WidgetChatListAdapterItemSystemMessage2.this.$authorRoleColor));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8422a("actorHook", new AnonymousClass1());
    }
}
