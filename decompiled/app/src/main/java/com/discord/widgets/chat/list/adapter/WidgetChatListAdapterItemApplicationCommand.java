package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemApplicationCommandBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand extends WidgetChatListItem {
    private final WidgetChatListAdapterItemApplicationCommandBinding binding;

    /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$1 */
    public static final class C80081 extends Lambda implements Function1<TextView, Unit> {
        public static final C80081 INSTANCE = new C80081();

        /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$1$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnLongClickListener {
            public final /* synthetic */ TextView $this_copyTextOnLongPress;

            public AnonymousClass1(TextView textView) {
                this.$this_copyTextOnLongPress = textView;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Context context = this.$this_copyTextOnLongPress.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                CharSequence text = this.$this_copyTextOnLongPress.getText();
                Intrinsics3.checkNotNullExpressionValue(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                AppToast.m165c(context, text, 0, 4);
                return false;
            }
        }

        public C80081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "$this$copyTextOnLongPress");
            textView.setOnLongClickListener(new AnonymousClass1(textView));
        }
    }

    /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$2 */
    public static final class ViewOnClickListenerC80092 implements View.OnClickListener {
        public ViewOnClickListenerC80092() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextView textView = WidgetChatListAdapterItemApplicationCommand.access$getBinding$p(WidgetChatListAdapterItemApplicationCommand.this).f16139b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextCommand");
            if (textView.getMaxLines() == 1) {
                TextView textView2 = WidgetChatListAdapterItemApplicationCommand.access$getBinding$p(WidgetChatListAdapterItemApplicationCommand.this).f16139b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemTextCommand");
                textView2.setMaxLines(Integer.MAX_VALUE);
            } else {
                TextView textView3 = WidgetChatListAdapterItemApplicationCommand.access$getBinding$p(WidgetChatListAdapterItemApplicationCommand.this).f16139b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemTextCommand");
                textView3.setMaxLines(1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemApplicationCommand(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_application_command, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_text_avatar;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_item_text_avatar);
        if (imageView != null) {
            i = C5419R.id.chat_list_adapter_item_text_command;
            TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_command);
            if (textView != null) {
                i = C5419R.id.chat_list_adapter_item_text_decorator;
                CardView cardView = (CardView) view.findViewById(C5419R.id.chat_list_adapter_item_text_decorator);
                if (cardView != null) {
                    i = C5419R.id.chat_list_adapter_item_text_decorator_reply_link_icon;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_reply_link_icon);
                    if (frameLayout != null) {
                        i = C5419R.id.chat_list_adapter_item_text_header;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.chat_list_adapter_item_text_header);
                        if (constraintLayout != null) {
                            i = C5419R.id.chat_list_adapter_item_text_name;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_name);
                            if (textView2 != null) {
                                i = C5419R.id.chat_list_adapter_item_text_timestamp;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_timestamp);
                                if (textView3 != null) {
                                    i = C5419R.id.uikit_chat_guideline;
                                    Guideline guideline = (Guideline) view.findViewById(C5419R.id.uikit_chat_guideline);
                                    if (guideline != null) {
                                        WidgetChatListAdapterItemApplicationCommandBinding widgetChatListAdapterItemApplicationCommandBinding = new WidgetChatListAdapterItemApplicationCommandBinding((ConstraintLayout) view, imageView, textView, cardView, frameLayout, constraintLayout, textView2, textView3, guideline);
                                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemApplicationCommandBinding, "WidgetChatListAdapterIte…andBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemApplicationCommandBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemApplicationCommand widgetChatListAdapterItemApplicationCommand) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemApplicationCommand.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemApplicationCommandBinding access$getBinding$p(WidgetChatListAdapterItemApplicationCommand widgetChatListAdapterItemApplicationCommand) {
        return widgetChatListAdapterItemApplicationCommand.binding;
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), C5419R.attr.colorHeaderPrimary));
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onConfigure(int position, ChatListEntry data) {
        String strGroup;
        String strGroup2;
        String str;
        Integer type;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        Message message = messageEntry.getMessage();
        GuildMember author = messageEntry.getAuthor();
        Map<Long, String> nickOrUsernames = messageEntry.getNickOrUsernames();
        int authorTextColor = getAuthorTextColor(author);
        C80081 c80081 = C80081.INSTANCE;
        Pattern patternCompile = Pattern.compile("^<(/[^:]+):([0-9]*)>(.*)");
        String content = message.getContent();
        String str2 = "";
        if (content == null) {
            content = "";
        }
        Matcher matcher = patternCompile.matcher(content);
        if (matcher.matches()) {
            strGroup = matcher.group(1);
            if (strGroup == null) {
                strGroup = "";
            }
            strGroup2 = matcher.group(3);
            if (strGroup2 == null) {
            }
            User author2 = message.getAuthor();
            str = nickOrUsernames.get(author2 == null ? Long.valueOf(author2.getId()) : null);
            if (str == null) {
                str = "";
            }
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int themedColor = ColorCompat.getThemedColor(view, C5419R.attr.color_brand_500);
            TextView textView = this.binding.f16142e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextName");
            CharSequence charSequenceM212d = FormatUtils.m212d(textView, C5419R.string.system_message_application_command_used_short_mobile, new Object[]{str, strGroup}, new WidgetChatListAdapterItemApplicationCommand2(this, authorTextColor, message, themedColor));
            TextView textView2 = this.binding.f16142e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemTextName");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView3 = this.binding.f16142e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemTextName");
            textView3.setText(charSequenceM212d);
            TextView textView4 = this.binding.f16139b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemTextCommand");
            textView4.setMaxLines(1);
            this.binding.f16139b.setOnClickListener(new ViewOnClickListenerC80092());
            boolean z2 = !StringsJVM.isBlank(strGroup2);
            CardView cardView = this.binding.f16140c;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.chatListAdapterItemTextDecorator");
            cardView.setVisibility(!z2 ? 0 : 8);
            FrameLayout frameLayout = this.binding.f16141d;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.chatListAdapterI…extDecoratorReplyLinkIcon");
            frameLayout.setVisibility(z2 ? 0 : 8);
            TextView textView5 = this.binding.f16139b;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemTextCommand");
            Context contextM885x = outline.m885x(this.itemView, "itemView", "itemView.context");
            Object[] objArr = new Object[2];
            type = message.getType();
            if (type != null && type.intValue() == 20) {
                str2 = strGroup;
            }
            objArr[0] = str2;
            objArr[1] = strGroup2;
            textView5.setText(FormatUtils.m216h(contextM885x, C5419R.string.command_display_string, objArr, null, 4));
            TextView textView6 = this.binding.f16139b;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemTextCommand");
            c80081.invoke2(textView6);
            TextView textView7 = this.binding.f16143f;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.chatListAdapterItemTextTimestamp");
            Context contextM885x2 = outline.m885x(this.itemView, "itemView", "itemView.context");
            UtcDateTime timestamp = message.getTimestamp();
            textView7.setText(TimeUtils.toReadableTimeString$default(contextM885x2, timestamp == null ? timestamp.getDateTimeMillis() : 0L, null, 4, null));
        }
        strGroup = AutocompleteViewModel.COMMAND_DISCOVER_TOKEN;
        strGroup2 = "";
        User author22 = message.getAuthor();
        str = nickOrUsernames.get(author22 == null ? Long.valueOf(author22.getId()) : null);
        if (str == null) {
        }
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        int themedColor2 = ColorCompat.getThemedColor(view2, C5419R.attr.color_brand_500);
        TextView textView8 = this.binding.f16142e;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.chatListAdapterItemTextName");
        CharSequence charSequenceM212d2 = FormatUtils.m212d(textView8, C5419R.string.system_message_application_command_used_short_mobile, new Object[]{str, strGroup}, new WidgetChatListAdapterItemApplicationCommand2(this, authorTextColor, message, themedColor2));
        TextView textView22 = this.binding.f16142e;
        Intrinsics3.checkNotNullExpressionValue(textView22, "binding.chatListAdapterItemTextName");
        textView22.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView32 = this.binding.f16142e;
        Intrinsics3.checkNotNullExpressionValue(textView32, "binding.chatListAdapterItemTextName");
        textView32.setText(charSequenceM212d2);
        TextView textView42 = this.binding.f16139b;
        Intrinsics3.checkNotNullExpressionValue(textView42, "binding.chatListAdapterItemTextCommand");
        textView42.setMaxLines(1);
        this.binding.f16139b.setOnClickListener(new ViewOnClickListenerC80092());
        boolean z22 = !StringsJVM.isBlank(strGroup2);
        CardView cardView2 = this.binding.f16140c;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.chatListAdapterItemTextDecorator");
        cardView2.setVisibility(!z22 ? 0 : 8);
        FrameLayout frameLayout2 = this.binding.f16141d;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.chatListAdapterI…extDecoratorReplyLinkIcon");
        frameLayout2.setVisibility(z22 ? 0 : 8);
        TextView textView52 = this.binding.f16139b;
        Intrinsics3.checkNotNullExpressionValue(textView52, "binding.chatListAdapterItemTextCommand");
        Context contextM885x3 = outline.m885x(this.itemView, "itemView", "itemView.context");
        Object[] objArr2 = new Object[2];
        type = message.getType();
        if (type != null) {
            str2 = strGroup;
        }
        objArr2[0] = str2;
        objArr2[1] = strGroup2;
        textView52.setText(FormatUtils.m216h(contextM885x3, C5419R.string.command_display_string, objArr2, null, 4));
        TextView textView62 = this.binding.f16139b;
        Intrinsics3.checkNotNullExpressionValue(textView62, "binding.chatListAdapterItemTextCommand");
        c80081.invoke2(textView62);
        TextView textView72 = this.binding.f16143f;
        Intrinsics3.checkNotNullExpressionValue(textView72, "binding.chatListAdapterItemTextTimestamp");
        Context contextM885x22 = outline.m885x(this.itemView, "itemView", "itemView.context");
        UtcDateTime timestamp2 = message.getTimestamp();
        textView72.setText(TimeUtils.toReadableTimeString$default(contextM885x22, timestamp2 == null ? timestamp2.getDateTimeMillis() : 0L, null, 4, null));
    }
}
