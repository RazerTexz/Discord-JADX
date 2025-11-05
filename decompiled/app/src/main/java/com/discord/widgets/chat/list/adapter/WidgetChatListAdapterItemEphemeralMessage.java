package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.a.d.f;
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemEphemeralMessageBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EphemeralMessageEntry;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage extends WidgetChatListItem {
    private final WidgetChatListAdapterItemEphemeralMessageBinding binding;

    /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            ImageView imageView = WidgetChatListAdapterItemEphemeralMessage.access$getBinding$p(WidgetChatListAdapterItemEphemeralMessage.this).d;
            m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterItemIconHelp");
            Context context = imageView.getContext();
            m.checkNotNullExpressionValue(context, "binding.chatListAdapterItemIconHelp.context");
            UriHandler.handle$default(uriHandler, context, f.a.a(1500000580222L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Message $message;

        /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {

            /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
            /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03931 extends o implements Function2<String, View, Unit> {
                public C03931() {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, View view) {
                    invoke2(str, view);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, View view) {
                    m.checkNotNullParameter(str, "<anonymous parameter 0>");
                    m.checkNotNullParameter(view, "<anonymous parameter 1>");
                    WidgetChatListAdapterItemEphemeralMessage.access$getAdapter$p(WidgetChatListAdapterItemEphemeralMessage.this).getEventHandler().onDismissClicked(AnonymousClass2.this.$message);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                m.checkNotNullParameter(hook, "$receiver");
                View view = WidgetChatListAdapterItemEphemeralMessage.this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                Integer numValueOf = Integer.valueOf(ColorCompat.getColor(view, R.color.brand));
                C03931 c03931 = new C03931();
                Objects.requireNonNull(hook);
                m.checkNotNullParameter(c03931, "onClick");
                hook.clickHandler = new Hook.a(numValueOf, c03931);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("handleDelete", new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEphemeralMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_ephemeral_message, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R.id.chat_list_adapter_item_icon_help;
                ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_adapter_item_icon_help);
                if (imageView != null) {
                    i = R.id.chat_list_adapter_item_text_dismiss;
                    TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_text_dismiss);
                    if (textView != null) {
                        i = R.id.chat_list_adapter_item_visibility_icon;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.chat_list_adapter_item_visibility_icon);
                        if (imageView2 != null) {
                            i = R.id.uikit_chat_guideline;
                            Guideline guideline = (Guideline) view.findViewById(R.id.uikit_chat_guideline);
                            if (guideline != null) {
                                WidgetChatListAdapterItemEphemeralMessageBinding widgetChatListAdapterItemEphemeralMessageBinding = new WidgetChatListAdapterItemEphemeralMessageBinding((ConstraintLayout) view, viewFindViewById, viewFindViewById2, imageView, textView, imageView2, guideline);
                                m.checkNotNullExpressionValue(widgetChatListAdapterItemEphemeralMessageBinding, "WidgetChatListAdapterIte…ageBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemEphemeralMessageBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemEphemeralMessage.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemEphemeralMessageBinding access$getBinding$p(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        return widgetChatListAdapterItemEphemeralMessage.binding;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) throws Resources.NotFoundException {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) throws Resources.NotFoundException {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        Message message = ((EphemeralMessageEntry) data).getMessage();
        View view = this.binding.f2318b;
        m.checkNotNullExpressionValue(view, "binding.chatListAdapterItemGutterBg");
        View view2 = this.binding.c;
        m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        configureCellHighlight(message, view2, view);
        this.binding.d.setOnClickListener(new AnonymousClass1());
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextDismiss");
        String quantityString = textView.getResources().getQuantityString(R.plurals.only_you_can_see_and_delete_these_count, 1);
        m.checkNotNullExpressionValue(quantityString, "itemDismiss.resources.ge…nd_delete_these_count, 1)");
        String quantityString2 = textView.getResources().getQuantityString(R.plurals.only_you_can_see_and_delete_these_countMessages, 1);
        m.checkNotNullExpressionValue(quantityString2, "itemDismiss.resources.ge…e_these_countMessages, 1)");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(b.d(textView, R.string.only_you_can_see_and_delete_these, new Object[]{quantityString, quantityString2}, new AnonymousClass2(message)));
    }
}
