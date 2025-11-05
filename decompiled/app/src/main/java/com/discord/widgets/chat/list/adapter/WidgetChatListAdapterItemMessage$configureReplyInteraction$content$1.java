package com.discord.widgets.chat.list.adapter;

import android.text.style.StyleSpan;
import android.view.View;
import com.discord.R;
import com.discord.api.interaction.Interaction;
import com.discord.api.user.User;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemMessage.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Interaction $interaction;
    public final /* synthetic */ User $interactionUser;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Interaction interaction, Message message, User user) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$interaction = interaction;
        this.$message = message;
        this.$interactionUser = user;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("commandNameOnClick", new AnonymousClass1());
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {

        /* compiled from: WidgetChatListAdapterItemMessage.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03941 extends o implements Function1<View, Unit> {
            public C03941() {
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
                Guild guild = WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.this$0).getData().getGuild();
                Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
                Long id2 = WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$interaction.getId();
                if (id2 != null) {
                    long jLongValue = id2.longValue();
                    if (!WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$message.isLocalApplicationCommand() || WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$message.isFailed()) {
                        Integer type = WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$message.getType();
                        if (type != null && type.intValue() == 23) {
                            return;
                        }
                        WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.this$0).getEventHandler();
                        long channelId = WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$message.getChannelId();
                        long id3 = WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$message.getId();
                        long id4 = WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$interactionUser.getId();
                        User author = WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$message.getAuthor();
                        m.checkNotNull(author);
                        eventHandler.onCommandClicked(jLongValue, lValueOf, channelId, id3, id4, author.getId(), WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.$message.getNonce());
                    }
                }
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemMessage.access$getReplyText$p(WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1.this.this$0), R.attr.colorTextLink)), false, null, new C03941(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
