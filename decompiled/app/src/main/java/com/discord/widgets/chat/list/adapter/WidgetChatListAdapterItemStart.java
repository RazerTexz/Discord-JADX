package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R;
import com.discord.api.channel.ForumTag;
import com.discord.databinding.WidgetChatListAdapterItemStartBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StartOfChatEntry;
import com.discord.widgets.forums.ForumPostTagView;
import com.discord.widgets.forums.PostTagData;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemStart.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStart extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStartBinding binding;

    /* compiled from: WidgetChatListAdapterItemStart.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.INSTANCE.launch(this.$channelId, WidgetChatListAdapterItemStart.access$getAdapter$p(WidgetChatListAdapterItemStart.this).getContext());
        }
    }

    /* compiled from: WidgetChatListAdapterItemStart.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ GuildMember $threadCreatorMember;
        public final /* synthetic */ String $threadCreatorName;

        /* compiled from: WidgetChatListAdapterItemStart.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03951 extends o implements Function1<Hook, Unit> {
            public C03951() {
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
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                hook.replacementText = anonymousClass1.$threadCreatorName;
                FontUtils fontUtils = FontUtils.INSTANCE;
                Context context = anonymousClass1.$context;
                m.checkNotNullExpressionValue(context, "context");
                Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_semibold);
                if (themedFont != null) {
                    hook.styles.add(new TypefaceSpanCompat(themedFont));
                }
                List<Object> list = hook.styles;
                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                list.add(new ForegroundColorSpan(WidgetChatListAdapterItemStart.access$getAuthorTextColor(WidgetChatListAdapterItemStart.this, anonymousClass12.$threadCreatorMember)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Context context, GuildMember guildMember) {
            super(1);
            this.$threadCreatorName = str;
            this.$context = context;
            this.$threadCreatorMember = guildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("usernameHook", new C03951());
        }
    }

    /* compiled from: WidgetChatListAdapterItemStart.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $autoArchiveString;
        public final /* synthetic */ Context $context;

        /* compiled from: WidgetChatListAdapterItemStart.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {
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
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                hook.replacementText = anonymousClass2.$autoArchiveString;
                FontUtils fontUtils = FontUtils.INSTANCE;
                Context context = anonymousClass2.$context;
                m.checkNotNullExpressionValue(context, "context");
                Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_normal);
                if (themedFont != null) {
                    hook.styles.add(new TypefaceSpanCompat(themedFont));
                }
                hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(AnonymousClass2.this.$context, R.attr.colorHeaderPrimary)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Context context) {
            super(1);
            this.$autoArchiveString = str;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("autoArchiveDurationHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetChatListAdapterItemStart.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;

        public AnonymousClass3(long j) {
            this.$channelId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadSettings.INSTANCE.launch(this.$channelId, WidgetChatListAdapterItemStart.access$getAdapter$p(WidgetChatListAdapterItemStart.this).getContext());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStart(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_start, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_edit_channel;
        TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_edit_channel);
        if (textView != null) {
            i = R.id.chat_list_adapter_item_header;
            TextView textView2 = (TextView) view.findViewById(R.id.chat_list_adapter_item_header);
            if (textView2 != null) {
                i = R.id.chat_list_adapter_item_subheader1;
                TextView textView3 = (TextView) view.findViewById(R.id.chat_list_adapter_item_subheader1);
                if (textView3 != null) {
                    i = R.id.chat_list_adapter_item_subheader2;
                    TextView textView4 = (TextView) view.findViewById(R.id.chat_list_adapter_item_subheader2);
                    if (textView4 != null) {
                        i = R.id.chat_list_adapter_tags;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R.id.chat_list_adapter_tags);
                        if (flexboxLayout != null) {
                            i = R.id.chat_list_adapter_thread_header_icon;
                            ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_adapter_thread_header_icon);
                            if (imageView != null) {
                                WidgetChatListAdapterItemStartBinding widgetChatListAdapterItemStartBinding = new WidgetChatListAdapterItemStartBinding((LinearLayout) view, textView, textView2, textView3, textView4, flexboxLayout, imageView);
                                m.checkNotNullExpressionValue(widgetChatListAdapterItemStartBinding, "WidgetChatListAdapterIte…artBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemStartBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStart widgetChatListAdapterItemStart) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStart.adapter;
    }

    public static final /* synthetic */ int access$getAuthorTextColor(WidgetChatListAdapterItemStart widgetChatListAdapterItemStart, GuildMember guildMember) {
        return widgetChatListAdapterItemStart.getAuthorTextColor(guildMember);
    }

    private final void configureChannel(long channelId, String channelName, boolean isTextInVoice, boolean canReadMessageHistory, boolean canManageChannel) {
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemHeader");
        b.n(textView, R.string.android_welcome_message_title_channel, new Object[]{channelName}, null, 4);
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemSubheader1");
        textView2.setVisibility(8);
        if (isTextInVoice) {
            ImageView imageView = this.binding.g;
            m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
            imageView.setVisibility(0);
            this.binding.g.setImageResource(R.drawable.ic_chat_message_white_24dp);
        } else {
            ImageView imageView2 = this.binding.g;
            m.checkNotNullExpressionValue(imageView2, "binding.chatListAdapterThreadHeaderIcon");
            imageView2.setVisibility(8);
        }
        if (canReadMessageHistory) {
            TextView textView3 = this.binding.e;
            m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemSubheader2");
            b.n(textView3, R.string.android_welcome_message_subtitle_channel, new Object[]{channelName}, null, 4);
        } else {
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemSubheader2");
            b.n(textView4, R.string.beginning_channel_no_history, new Object[]{channelName}, null, 4);
        }
        this.binding.f2333b.setOnClickListener(new AnonymousClass1(channelId));
        TextView textView5 = this.binding.f2333b;
        m.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemEditChannel");
        b.n(textView5, R.string.edit_channel, new Object[0], null, 4);
        TextView textView6 = this.binding.f2333b;
        m.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemEditChannel");
        textView6.setVisibility(canManageChannel ? 0 : 8);
    }

    private final void configureForumPost(String channelName, List<Long> appliedTags, List<ForumTag> availableTags) {
        List listEmptyList;
        ForumPostTagView forumPostTagView;
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemSubheader1");
        textView.setVisibility(8);
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemSubheader2");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.f2333b;
        m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemEditChannel");
        textView3.setVisibility(8);
        ImageView imageView = this.binding.g;
        m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
        imageView.setVisibility(0);
        TextView textView4 = this.binding.c;
        m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemHeader");
        textView4.setText(channelName);
        this.binding.g.setImageResource(R.drawable.ic_channel_forum_post);
        if (availableTags != null) {
            listEmptyList = new ArrayList();
            for (Object obj : availableTags) {
                if (appliedTags != null ? appliedTags.contains(Long.valueOf(((ForumTag) obj).getId())) : false) {
                    listEmptyList.add(obj);
                }
            }
        } else {
            listEmptyList = n.emptyList();
        }
        FlexboxLayout flexboxLayout = this.binding.f;
        m.checkNotNullExpressionValue(flexboxLayout, "binding.chatListAdapterTags");
        flexboxLayout.setVisibility(listEmptyList.isEmpty() ^ true ? 0 : 8);
        FlexboxLayout flexboxLayout2 = this.binding.f;
        m.checkNotNullExpressionValue(flexboxLayout2, "binding.chatListAdapterTags");
        int childCount = flexboxLayout2.getChildCount();
        for (int size = listEmptyList.size(); size < childCount; size++) {
            View childAt = this.binding.f.getChildAt(size);
            m.checkNotNullExpressionValue(childAt, "binding.chatListAdapterTags.getChildAt(i)");
            childAt.setVisibility(8);
        }
        int i = 0;
        int i2 = 0;
        for (Object obj2 : listEmptyList) {
            int i3 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            ForumTag forumTag = (ForumTag) obj2;
            if (i2 < childCount) {
                View childAt2 = this.binding.f.getChildAt(i2);
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type com.discord.widgets.forums.ForumPostTagView");
                forumPostTagView = (ForumPostTagView) childAt2;
                i2++;
            } else {
                FlexboxLayout flexboxLayout3 = this.binding.f;
                m.checkNotNullExpressionValue(flexboxLayout3, "binding.chatListAdapterTags");
                Context context = flexboxLayout3.getContext();
                m.checkNotNullExpressionValue(context, "binding.chatListAdapterTags.context");
                forumPostTagView = new ForumPostTagView(context, null, 0, 6, null);
                this.binding.f.addView(forumPostTagView);
            }
            forumPostTagView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = forumPostTagView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, DimenUtils.dpToPixels(6), DimenUtils.dpToPixels(6));
            forumPostTagView.setLayoutParams(marginLayoutParams);
            forumPostTagView.configureTag(PostTagData.INSTANCE.fromTag(forumTag, false));
            i = i3;
        }
    }

    private final void configureThread(long channelId, String channelName, boolean canReadMessageHistory, boolean canManageThread, GuildMember threadCreatorMember, String threadCreatorName, Integer threadAutoArchiveDuration) throws Resources.NotFoundException {
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemHeader");
        Context context = textView.getContext();
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemHeader");
        textView2.setText(channelName);
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemSubheader1");
        textView3.setVisibility(0);
        TextView textView4 = this.binding.e;
        m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemSubheader2");
        textView4.setVisibility(0);
        ImageView imageView = this.binding.g;
        m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
        imageView.setVisibility(0);
        FlexboxLayout flexboxLayout = this.binding.f;
        m.checkNotNullExpressionValue(flexboxLayout, "binding.chatListAdapterTags");
        flexboxLayout.setVisibility(8);
        this.binding.g.setImageResource(R.drawable.ic_thread);
        TextView textView5 = this.binding.d;
        m.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemSubheader1");
        b.m(textView5, R.string.thread_started_by, new Object[]{threadCreatorName}, new AnonymousClass1(threadCreatorName, context, threadCreatorMember));
        if (canReadMessageHistory) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            m.checkNotNullExpressionValue(context, "context");
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(context, threadAutoArchiveDuration != null ? threadAutoArchiveDuration.intValue() : 0);
            TextView textView6 = this.binding.e;
            m.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemSubheader2");
            b.m(textView6, R.string.beginning_thread_archive_description, new Object[]{strAutoArchiveDurationName}, new AnonymousClass2(strAutoArchiveDurationName, context));
        } else {
            TextView textView7 = this.binding.e;
            m.checkNotNullExpressionValue(textView7, "binding.chatListAdapterItemSubheader2");
            b.n(textView7, R.string.beginning_channel_no_history, new Object[]{channelName}, null, 4);
        }
        this.binding.f2333b.setOnClickListener(new AnonymousClass3(channelId));
        TextView textView8 = this.binding.f2333b;
        m.checkNotNullExpressionValue(textView8, "binding.chatListAdapterItemEditChannel");
        b.n(textView8, R.string.edit_thread, new Object[0], null, 4);
        TextView textView9 = this.binding.f2333b;
        m.checkNotNullExpressionValue(textView9, "binding.chatListAdapterItemEditChannel");
        textView9.setVisibility(canManageThread ? 0 : 8);
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), R.attr.colorHeaderPrimary));
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
        StartOfChatEntry startOfChatEntry = (StartOfChatEntry) data;
        long jComponent1 = startOfChatEntry.getChannelId();
        String strComponent2 = startOfChatEntry.getChannelName();
        boolean zComponent3 = startOfChatEntry.getCanReadMessageHistory();
        boolean zComponent4 = startOfChatEntry.getCanManageChannel();
        boolean zComponent5 = startOfChatEntry.getCanManageThread();
        if (startOfChatEntry.isGuildForumPost() && startOfChatEntry.getCanAccessRedesignedForumChannels()) {
            configureForumPost(strComponent2, startOfChatEntry.getAppliedTags(), startOfChatEntry.getAvailableTags());
        } else if (startOfChatEntry.isThread()) {
            configureThread(jComponent1, strComponent2, zComponent3, zComponent5, startOfChatEntry.getThreadCreatorMember(), startOfChatEntry.getThreadCreatorName(), startOfChatEntry.getThreadAutoArchiveDuration());
        } else {
            configureChannel(jComponent1, strComponent2, startOfChatEntry.isTextInVoice(), zComponent3, zComponent4);
        }
    }
}
