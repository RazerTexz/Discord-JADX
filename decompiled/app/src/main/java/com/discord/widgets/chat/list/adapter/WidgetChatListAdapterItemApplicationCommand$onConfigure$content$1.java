package com.discord.widgets.chat.list.adapter;

import android.text.style.StyleSpan;
import android.view.View;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorTextColor;
    public final /* synthetic */ int $cmdColor;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemApplicationCommand this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1(WidgetChatListAdapterItemApplicationCommand widgetChatListAdapterItemApplicationCommand, int i, Message message, int i2) {
        super(1);
        this.this$0 = widgetChatListAdapterItemApplicationCommand;
        this.$authorTextColor = i;
        this.$message = message;
        this.$cmdColor = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new AnonymousClass1());
        renderContext.a("commandNameOnClick", new AnonymousClass2());
    }

    /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {

        /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03891 extends o implements Function1<View, Unit> {
            public C03891() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                m.checkNotNullParameter(view, "it");
                WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemApplicationCommand.access$getAdapter$p(WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1.this.this$0).getEventHandler();
                WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1 widgetChatListAdapterItemApplicationCommand$onConfigure$content$1 = WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1.this;
                eventHandler.onMessageAuthorAvatarClicked(widgetChatListAdapterItemApplicationCommand$onConfigure$content$1.$message, WidgetChatListAdapterItemApplicationCommand.access$getAdapter$p(widgetChatListAdapterItemApplicationCommand$onConfigure$content$1.this$0).getData().getGuildId());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1.this.$authorTextColor), false, null, new C03891(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Hook, Unit> {

        /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                m.checkNotNullParameter(view, "it");
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1.this.$cmdColor), false, null, AnonymousClass1.INSTANCE, 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
