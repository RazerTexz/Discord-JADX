package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.a.i.y4;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.message.embed.EmbedAuthor;
import com.discord.api.message.embed.EmbedField;
import com.discord.api.message.embed.EmbedFooter;
import com.discord.api.message.embed.EmbedProvider;
import com.discord.api.message.embed.EmbedThumbnail;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChatListAdapterItemEmbedBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Tags;
import com.discord.utilities.textprocessing.TagsBuilder;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import d0.g0.s;
import d0.g0.t;
import d0.g0.w;
import d0.g0.y;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.a.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed extends WidgetChatListItem implements FragmentLifecycleListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String EMBED_TYPE_DESC = "desc";
    private static final String EMBED_TYPE_FIELD_NAME = "f_name";
    private static final String EMBED_TYPE_FIELD_VALUE = "f_value";
    private static final String EMBED_TYPE_TITLE = "title";
    private static final int MAX_IMAGE_VIEW_HEIGHT_PX;
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> UI_THREAD_TITLES_PARSER;
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> UI_THREAD_VALUES_PARSER;
    private final WidgetChatListAdapterItemEmbedBinding binding;
    private final int embedThumbnailMaxSize;
    private final int embedTinyIconSize;
    private final int maxEmbedImageWidth;
    private Subscription subscription;
    private final StoreUserSettings userSettings;

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<TextView, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: WidgetChatListAdapterItemEmbed.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$1$1, reason: invalid class name and collision with other inner class name */
        public static final class ViewOnLongClickListenerC03911 implements View.OnLongClickListener {
            public final /* synthetic */ TextView $this_copyTextOnLongPress;

            public ViewOnLongClickListenerC03911(TextView textView) {
                this.$this_copyTextOnLongPress = textView;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Context context = this.$this_copyTextOnLongPress.getContext();
                m.checkNotNullExpressionValue(context, "context");
                CharSequence text = this.$this_copyTextOnLongPress.getText();
                m.checkNotNullExpressionValue(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                b.a.d.m.c(context, text, 0, 4);
                return false;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            m.checkNotNullParameter(textView, "$this$copyTextOnLongPress");
            textView.setOnLongClickListener(new ViewOnLongClickListenerC03911(textView));
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$bindUrlOnClick(Companion companion, View view, String str, String str2) {
            companion.bindUrlOnClick(view, str, str2);
        }

        public static final /* synthetic */ List access$getEmbedFieldVisibleIndices(Companion companion, Map map, int i, String str) {
            return companion.getEmbedFieldVisibleIndices(map, i, str);
        }

        public static final /* synthetic */ Observable access$getModel(Companion companion, Model model) {
            return companion.getModel(model);
        }

        private final void bindUrlOnClick(View view, String str, String str2) {
            if (str != null) {
                view.setOnClickListener(new WidgetChatListAdapterItemEmbed$Companion$bindUrlOnClick$1(str, str2));
            } else {
                view.setOnClickListener(null);
            }
        }

        private final List<Integer> getEmbedFieldVisibleIndices(Map<Integer, ? extends Set<String>> map, int i, String str) {
            Set<String> set = map.get(Integer.valueOf(i));
            ArrayList arrayList = null;
            if (set != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : set) {
                    if (t.startsWith$default((String) obj, str, false, 2, null)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Integer intOrNull = s.toIntOrNull(y.drop((String) it.next(), str.length() + 1));
                    if (intOrNull != null) {
                        arrayList.add(intOrNull);
                    }
                }
            }
            return arrayList;
        }

        private final Observable<Model> getModel(Model initialModel) {
            EmbedEntry embedEntry = initialModel.getEmbedEntry();
            Collection<Node<MessageRenderContext>> parsedDescription = initialModel.getParsedDescription();
            List<Model.ParsedField> parsedFields = initialModel.getParsedFields();
            TagsBuilder tagsBuilder = new TagsBuilder();
            if (parsedDescription != null) {
                tagsBuilder.processAst(parsedDescription);
            }
            if (parsedFields != null) {
                for (Model.ParsedField parsedField : parsedFields) {
                    tagsBuilder.processAst(parsedField.getParsedName());
                    tagsBuilder.processAst(parsedField.getParsedValue());
                }
            }
            Tags tagsBuild = tagsBuilder.build();
            if (tagsBuild.getIsEmpty()) {
                Observable observable = d.k;
                m.checkNotNullExpressionValue(observable, "Observable.never()");
                return observable;
            }
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableH = Observable.h(companion.getUsers().observeMeId(), companion.getChannels().observeNames(tagsBuild.getChannels()), Observable.j(companion.getGuilds().observeComputed(embedEntry.getGuildId(), tagsBuild.getUsers()), companion.getUsers().observeUsernames(tagsBuild.getUsers()), WidgetChatListAdapterItemEmbed$Companion$getModel$1.INSTANCE), companion.getGuilds().observeRoles(embedEntry.getGuildId(), tagsBuild.getRoles()), new WidgetChatListAdapterItemEmbed$Companion$getModel$2(embedEntry, parsedDescription, parsedFields));
            m.checkNotNullExpressionValue(observableH, "Observable\n          .co… roles, myId)\n          }");
            Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableH).r();
            m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
            return observableR;
        }

        public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> createTitlesParser() {
            return DiscordParser.createParser$default(false, false, false, false, false, 28, null);
        }

        public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getUI_THREAD_TITLES_PARSER() {
            return WidgetChatListAdapterItemEmbed.access$getUI_THREAD_TITLES_PARSER$cp();
        }

        public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getUI_THREAD_VALUES_PARSER() {
            return WidgetChatListAdapterItemEmbed.access$getUI_THREAD_VALUES_PARSER$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedDescription$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<SpoilerNode<?>, Unit> {
        public final /* synthetic */ int $embedIndex;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i) {
            super(1);
            this.$messageId = j;
            this.$embedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            m.checkNotNullParameter(spoilerNode, "node");
            StoreMessageState messageState = StoreStream.INSTANCE.getMessageState();
            long j = this.$messageId;
            int i = this.$embedIndex;
            StringBuilder sbU = a.U("desc:");
            sbU.append(spoilerNode.getId());
            messageState.revealSpoilerEmbedData(j, i, sbU.toString());
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedFields$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<Collection<? extends Node<MessageRenderContext>>, String, DraweeSpanStringBuilder> {
        public final /* synthetic */ int $embedIndex;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ Model $model;
        public final /* synthetic */ MessageRenderContext $renderContext;
        public final /* synthetic */ Map $visibleSpoilerEmbedMap;

        /* compiled from: WidgetChatListAdapterItemEmbed.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedFields$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03921 extends o implements Function1<SpoilerNode<?>, Unit> {
            public final /* synthetic */ String $prefixKey;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03921(String str) {
                super(1);
                this.$prefixKey = str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
                invoke2(spoilerNode);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SpoilerNode<?> spoilerNode) {
                m.checkNotNullParameter(spoilerNode, "node");
                StoreMessageState messageState = StoreStream.INSTANCE.getMessageState();
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                messageState.revealSpoilerEmbedData(anonymousClass1.$messageId, anonymousClass1.$embedIndex, this.$prefixKey + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + spoilerNode.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model, Map map, int i, MessageRenderContext messageRenderContext, long j) {
            super(2);
            this.$model = model;
            this.$visibleSpoilerEmbedMap = map;
            this.$embedIndex = i;
            this.$renderContext = messageRenderContext;
            this.$messageId = j;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ DraweeSpanStringBuilder invoke(Collection<? extends Node<MessageRenderContext>> collection, String str) {
            return invoke2(collection, str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final DraweeSpanStringBuilder invoke2(Collection<? extends Node<MessageRenderContext>> collection, String str) {
            m.checkNotNullParameter(collection, "$this$toDraweeSpanStringBuilder");
            m.checkNotNullParameter(str, "prefixKey");
            long myId = this.$model.getMyId();
            Map map = this.$visibleSpoilerEmbedMap;
            new MessagePreprocessor(myId, map != null ? Companion.access$getEmbedFieldVisibleIndices(WidgetChatListAdapterItemEmbed.INSTANCE, map, this.$embedIndex, str) : null, null, false, null, 28, null).process(collection);
            return AstRenderer.render(collection, MessageRenderContext.copy$default(this.$renderContext, null, 0L, false, null, null, null, 0, null, null, 0, 0, new C03921(str), null, null, 14335, null));
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedTitle$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<SpoilerNode<?>, Unit> {
        public final /* synthetic */ int $embedIndex;
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model, int i) {
            super(1);
            this.$model = model;
            this.$embedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            m.checkNotNullParameter(spoilerNode, "node");
            StoreMessageState messageState = StoreStream.INSTANCE.getMessageState();
            long id2 = this.$model.getEmbedEntry().getMessage().getId();
            int i = this.$embedIndex;
            StringBuilder sbU = a.U("title:");
            sbU.append(spoilerNode.getId());
            messageState.revealSpoilerEmbedData(id2, i, sbU.toString());
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(0.9f);
            viewPropertyAnimator.scaleY(0.9f);
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ EmbedEntry $data;
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model, EmbedEntry embedEntry) {
            this.$model = model;
            this.$data = embedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getData().getIsSpoilerClickAllowed()) {
                StoreStream.INSTANCE.getMessageState().revealSpoilerEmbed(this.$model.getEmbedEntry().getMessage().getId(), this.$data.getEmbedIndex());
            } else {
                WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler().onMessageClicked(this.$model.getEmbedEntry().getMessage(), this.$data.isThreadStarterMessage());
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
        public final /* synthetic */ ChatListEntry $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChatListEntry chatListEntry) {
            super(1);
            this.$data = chatListEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler().onMessageLongClicked(((EmbedEntry) this.$data).getMessage(), "", ((EmbedEntry) this.$data).isThreadStarterMessage());
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ ChatListEntry $data;

        public AnonymousClass2(ChatListEntry chatListEntry) {
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler().onMessageClicked(((EmbedEntry) this.$data).getMessage(), ((EmbedEntry) this.$data).isThreadStarterMessage());
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemEmbed.access$setSubscription$p(WidgetChatListAdapterItemEmbed.this, subscription);
        }
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$onConfigure$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Model, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(a.x(WidgetChatListAdapterItemEmbed.this.itemView, "itemView", "itemView.context"), WidgetChatListAdapterItemEmbed.access$getAdapter$p(WidgetChatListAdapterItemEmbed.this).getEventHandler());
            WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed = WidgetChatListAdapterItemEmbed.this;
            m.checkNotNullExpressionValue(model, "model");
            WidgetChatListAdapterItemEmbed.access$configureEmbedTitle(widgetChatListAdapterItemEmbed, model, messageRenderContextCreateRenderContext);
            WidgetChatListAdapterItemEmbed.access$configureEmbedDescription(WidgetChatListAdapterItemEmbed.this, model, messageRenderContextCreateRenderContext);
            WidgetChatListAdapterItemEmbed.access$configureEmbedFields(WidgetChatListAdapterItemEmbed.this, model, messageRenderContextCreateRenderContext);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        MAX_IMAGE_VIEW_HEIGHT_PX = DimenUtils.dpToPixels(360);
        UI_THREAD_TITLES_PARSER = companion.createTitlesParser();
        UI_THREAD_VALUES_PARSER = DiscordParser.createParser$default(true, true, false, false, false, 28, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_embed, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R.id.chat_list_item_embed_author_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.chat_list_item_embed_author_icon);
                if (simpleDraweeView != null) {
                    i = R.id.chat_list_item_embed_author_text;
                    TextView textView = (TextView) view.findViewById(R.id.chat_list_item_embed_author_text);
                    if (textView != null) {
                        i = R.id.chat_list_item_embed_barrier_data;
                        Barrier barrier = (Barrier) view.findViewById(R.id.chat_list_item_embed_barrier_data);
                        if (barrier != null) {
                            i = R.id.chat_list_item_embed_barrier_header;
                            Barrier barrier2 = (Barrier) view.findViewById(R.id.chat_list_item_embed_barrier_header);
                            if (barrier2 != null) {
                                i = R.id.chat_list_item_embed_container_card;
                                MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.chat_list_item_embed_container_card);
                                if (materialCardView != null) {
                                    i = R.id.chat_list_item_embed_content;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.chat_list_item_embed_content);
                                    if (constraintLayout != null) {
                                        i = R.id.chat_list_item_embed_description;
                                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.chat_list_item_embed_description);
                                        if (linkifiedTextView != null) {
                                            i = R.id.chat_list_item_embed_divider;
                                            View viewFindViewById3 = view.findViewById(R.id.chat_list_item_embed_divider);
                                            if (viewFindViewById3 != null) {
                                                i = R.id.chat_list_item_embed_fields;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.chat_list_item_embed_fields);
                                                if (linearLayout != null) {
                                                    i = R.id.chat_list_item_embed_footer_icon;
                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.chat_list_item_embed_footer_icon);
                                                    if (simpleDraweeView2 != null) {
                                                        i = R.id.chat_list_item_embed_footer_text;
                                                        TextView textView2 = (TextView) view.findViewById(R.id.chat_list_item_embed_footer_text);
                                                        if (textView2 != null) {
                                                            i = R.id.chat_list_item_embed_image;
                                                            SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) view.findViewById(R.id.chat_list_item_embed_image);
                                                            if (simpleDraweeView3 != null) {
                                                                i = R.id.chat_list_item_embed_image_icons;
                                                                ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_item_embed_image_icons);
                                                                if (imageView != null) {
                                                                    i = R.id.chat_list_item_embed_image_thumbnail;
                                                                    SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) view.findViewById(R.id.chat_list_item_embed_image_thumbnail);
                                                                    if (simpleDraweeView4 != null) {
                                                                        i = R.id.chat_list_item_embed_provider;
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.chat_list_item_embed_provider);
                                                                        if (textView3 != null) {
                                                                            i = R.id.chat_list_item_embed_spoiler;
                                                                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.chat_list_item_embed_spoiler);
                                                                            if (frameLayout != null) {
                                                                                i = R.id.chat_list_item_embed_title;
                                                                                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R.id.chat_list_item_embed_title);
                                                                                if (linkifiedTextView2 != null) {
                                                                                    i = R.id.embed_image_container;
                                                                                    CardView cardView = (CardView) view.findViewById(R.id.embed_image_container);
                                                                                    if (cardView != null) {
                                                                                        i = R.id.embed_inline_media;
                                                                                        InlineMediaView inlineMediaView = (InlineMediaView) view.findViewById(R.id.embed_inline_media);
                                                                                        if (inlineMediaView != null) {
                                                                                            WidgetChatListAdapterItemEmbedBinding widgetChatListAdapterItemEmbedBinding = new WidgetChatListAdapterItemEmbedBinding((ConstraintLayout) view, viewFindViewById, viewFindViewById2, simpleDraweeView, textView, barrier, barrier2, materialCardView, constraintLayout, linkifiedTextView, viewFindViewById3, linearLayout, simpleDraweeView2, textView2, simpleDraweeView3, imageView, simpleDraweeView4, textView3, frameLayout, linkifiedTextView2, cardView, inlineMediaView);
                                                                                            m.checkNotNullExpressionValue(widgetChatListAdapterItemEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                                                                            this.binding = widgetChatListAdapterItemEmbedBinding;
                                                                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
                                                                                            m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedProvider");
                                                                                            anonymousClass1.invoke2(textView3);
                                                                                            m.checkNotNullExpressionValue(linkifiedTextView2, "binding.chatListItemEmbedTitle");
                                                                                            anonymousClass1.invoke2((TextView) linkifiedTextView2);
                                                                                            m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedAuthorText");
                                                                                            anonymousClass1.invoke2(textView);
                                                                                            m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedDescription");
                                                                                            anonymousClass1.invoke2((TextView) linkifiedTextView);
                                                                                            m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedFooterText");
                                                                                            anonymousClass1.invoke2(textView2);
                                                                                            this.userSettings = StoreStream.INSTANCE.getUserSettings();
                                                                                            View view2 = this.itemView;
                                                                                            m.checkNotNullExpressionValue(view2, "itemView");
                                                                                            this.embedTinyIconSize = (int) view2.getResources().getDimension(R.dimen.embed_tiny_icon_size);
                                                                                            View view3 = this.itemView;
                                                                                            m.checkNotNullExpressionValue(view3, "itemView");
                                                                                            this.embedThumbnailMaxSize = (int) view3.getResources().getDimension(R.dimen.embed_thumbnail_max_size);
                                                                                            EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
                                                                                            View view4 = this.itemView;
                                                                                            m.checkNotNullExpressionValue(view4, "itemView");
                                                                                            Context context = view4.getContext();
                                                                                            m.checkNotNullExpressionValue(context, "itemView.context");
                                                                                            this.maxEmbedImageWidth = embedResourceUtils.computeMaximumImageWidthPx(context);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static final /* synthetic */ void access$configureEmbedDescription(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, Model model, MessageRenderContext messageRenderContext) {
        widgetChatListAdapterItemEmbed.configureEmbedDescription(model, messageRenderContext);
    }

    public static final /* synthetic */ void access$configureEmbedFields(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, Model model, MessageRenderContext messageRenderContext) {
        widgetChatListAdapterItemEmbed.configureEmbedFields(model, messageRenderContext);
    }

    public static final /* synthetic */ void access$configureEmbedTitle(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, Model model, MessageRenderContext messageRenderContext) {
        widgetChatListAdapterItemEmbed.configureEmbedTitle(model, messageRenderContext);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemEmbed.adapter;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed) {
        return widgetChatListAdapterItemEmbed.subscription;
    }

    public static final /* synthetic */ Parser access$getUI_THREAD_TITLES_PARSER$cp() {
        return UI_THREAD_TITLES_PARSER;
    }

    public static final /* synthetic */ Parser access$getUI_THREAD_VALUES_PARSER$cp() {
        return UI_THREAD_VALUES_PARSER;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, Subscription subscription) {
        widgetChatListAdapterItemEmbed.subscription = subscription;
    }

    private final void configureEmbedAuthor(EmbedAuthor author) {
        if (author != null) {
            TextView textView = this.binding.e;
            m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedAuthorText");
            textView.setText(author.getName());
            Companion companion = INSTANCE;
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedAuthorText");
            Companion.access$bindUrlOnClick(companion, textView2, author.getUrl(), author.getName());
            TextView textView3 = this.binding.e;
            m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedAuthorText");
            textView3.setVisibility(0);
        } else {
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.chatListItemEmbedAuthorText");
            textView4.setVisibility(8);
        }
        if ((author != null ? author.getProxyIconUrl() : null) == null) {
            SimpleDraweeView simpleDraweeView = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedAuthorIcon");
            simpleDraweeView.setVisibility(8);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedAuthorIcon");
        simpleDraweeView2.setVisibility(0);
        SimpleDraweeView simpleDraweeView3 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedAuthorIcon");
        int i = this.embedTinyIconSize;
        configureEmbedImage$default(this, simpleDraweeView3, i, i, i, author.getProxyIconUrl(), 0, 32, null);
    }

    private final void configureEmbedDescription(Model model, MessageRenderContext renderContext) {
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        if (model.getParsedDescription() == null) {
            LinkifiedTextView linkifiedTextView = this.binding.h;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedDescription");
            linkifiedTextView.setVisibility(8);
            return;
        }
        long id2 = model.getEmbedEntry().getMessage().getId();
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        long myId = model.getMyId();
        StoreMessageState.State messageState = model.getEmbedEntry().getMessageState();
        new MessagePreprocessor(myId, (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null) ? null : Companion.access$getEmbedFieldVisibleIndices(INSTANCE, visibleSpoilerEmbedMap, embedIndex, EMBED_TYPE_DESC), null, false, null, 28, null).process(model.getParsedDescription());
        this.binding.h.setDraweeSpanStringBuilder(AstRenderer.render(model.getParsedDescription(), MessageRenderContext.copy$default(renderContext, null, 0L, false, null, null, null, 0, null, null, 0, 0, new AnonymousClass1(id2, embedIndex), null, null, 14335, null)));
        LinkifiedTextView linkifiedTextView2 = this.binding.h;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.chatListItemEmbedDescription");
        linkifiedTextView2.setVisibility(0);
    }

    private final void configureEmbedDivider(Integer color) {
        int themedColor;
        View view = this.binding.i;
        if (color != null) {
            themedColor = ColorUtils.setAlphaComponent(color.intValue(), 255);
        } else {
            m.checkNotNullExpressionValue(view, "binding.chatListItemEmbedDivider");
            themedColor = ColorCompat.getThemedColor(view.getContext(), R.attr.colorBackgroundModifierAccent);
        }
        view.setBackgroundColor(themedColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.widget.LinearLayout] */
    private final void configureEmbedFields(Model model, MessageRenderContext renderContext) {
        ?? childAt;
        List<Model.ParsedField> parsedFields = model.getParsedFields();
        this.binding.j.removeAllViews();
        if (parsedFields == null) {
            LinearLayout linearLayout = this.binding.j;
            m.checkNotNullExpressionValue(linearLayout, "binding.chatListItemEmbedFields");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.binding.j;
        m.checkNotNullExpressionValue(linearLayout2, "binding.chatListItemEmbedFields");
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = this.binding.j;
        m.checkNotNullExpressionValue(linearLayout3, "binding.chatListItemEmbedFields");
        Context context = linearLayout3.getContext();
        long id2 = model.getEmbedEntry().getMessage().getId();
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        StoreMessageState.State messageState = model.getEmbedEntry().getMessageState();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(model, messageState != null ? messageState.getVisibleSpoilerEmbedMap() : null, embedIndex, renderContext, id2);
        int size = parsedFields.size();
        for (int i = 0; i < size; i++) {
            LinearLayout linearLayout4 = this.binding.j;
            m.checkNotNullExpressionValue(linearLayout4, "binding.chatListItemEmbedFields");
            int childCount = linearLayout4.getChildCount();
            int i2 = R.id.chat_list_item_embed_field_value;
            if (i >= childCount) {
                View viewInflate = LayoutInflater.from(context).inflate(R.layout.widget_chat_list_adapter_item_embed_field, (ViewGroup) this.binding.j, false);
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.chat_list_item_embed_field_name);
                if (linkifiedTextView != null) {
                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewInflate.findViewById(R.id.chat_list_item_embed_field_value);
                    if (linkifiedTextView2 != null) {
                        childAt = (LinearLayout) viewInflate;
                        m.checkNotNullExpressionValue(new y4(childAt, linkifiedTextView, linkifiedTextView2), "WidgetChatListAdapterIte…edFields, false\n        )");
                    }
                } else {
                    i2 = R.id.chat_list_item_embed_field_name;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
            }
            childAt = this.binding.j.getChildAt(i);
            ((SimpleDraweeSpanTextView) childAt.findViewById(R.id.chat_list_item_embed_field_name)).setDraweeSpanStringBuilder(anonymousClass1.invoke2((Collection<? extends Node<MessageRenderContext>>) parsedFields.get(i).getParsedName(), a.q("f_name:", i)));
            ((SimpleDraweeSpanTextView) childAt.findViewById(R.id.chat_list_item_embed_field_value)).setDraweeSpanStringBuilder(anonymousClass1.invoke2((Collection<? extends Node<MessageRenderContext>>) parsedFields.get(i).getParsedValue(), "f_value:" + i));
            this.binding.j.addView(childAt);
        }
    }

    private final void configureEmbedImage(MessageEmbed embed) {
        Integer num;
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        RenderableEmbedMedia previewImage = embedResourceUtils.getPreviewImage(embed);
        if (previewImage == null) {
            CardView cardView = this.binding.f2316s;
            m.checkNotNullExpressionValue(cardView, "binding.embedImageContainer");
            cardView.setVisibility(8);
            return;
        }
        boolean zShouldRenderMedia = shouldRenderMedia();
        Integer num2 = previewImage.width;
        boolean z2 = num2 != null && d0.a0.a.getSign(num2.intValue()) == 1 && (num = previewImage.height) != null && d0.a0.a.getSign(num.intValue()) == 1;
        if (zShouldRenderMedia && z2) {
            SimpleDraweeView simpleDraweeView = this.binding.m;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImage");
            int i = this.maxEmbedImageWidth;
            int i2 = i / 2;
            Integer num3 = previewImage.width;
            int iIntValue = num3 != null ? num3.intValue() : 0;
            Integer num4 = previewImage.height;
            configureEmbedImage(simpleDraweeView, i, iIntValue, num4 != null ? num4.intValue() : 0, previewImage.url, i2);
            CardView cardView2 = this.binding.f2316s;
            m.checkNotNullExpressionValue(cardView2, "binding.embedImageContainer");
            cardView2.setVisibility(0);
        } else {
            CardView cardView3 = this.binding.f2316s;
            m.checkNotNullExpressionValue(cardView3, "binding.embedImageContainer");
            cardView3.setVisibility(8);
        }
        ImageView imageView = this.binding.n;
        m.checkNotNullExpressionValue(imageView, "binding.chatListItemEmbedImageIcons");
        imageView.setVisibility(embedResourceUtils.isPlayable(embed) && zShouldRenderMedia ? 0 : 8);
        this.binding.m.setOnClickListener(new WidgetChatListAdapterItemEmbed$configureEmbedImage$$inlined$apply$lambda$1(embed, this, previewImage, embed));
    }

    public static /* synthetic */ void configureEmbedImage$default(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, EmbedThumbnail embedThumbnail, ImageView imageView, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        widgetChatListAdapterItemEmbed.configureEmbedImage(embedThumbnail, imageView, i, i2);
    }

    private final void configureEmbedProvider(MessageEmbed embed, MessageRenderContext context) {
        EmbedProvider provider = embed.getProvider();
        if (provider == null) {
            TextView textView = this.binding.p;
            m.checkNotNullExpressionValue(textView, "binding.chatListItemEmbedProvider");
            textView.setVisibility(8);
            return;
        }
        String name = provider.getName();
        TextView textView2 = this.binding.p;
        m.checkNotNullExpressionValue(textView2, "binding.chatListItemEmbedProvider");
        textView2.setText(name);
        Companion companion = INSTANCE;
        TextView textView3 = this.binding.p;
        m.checkNotNullExpressionValue(textView3, "binding.chatListItemEmbedProvider");
        Companion.access$bindUrlOnClick(companion, textView3, provider.getUrl(), provider.getName());
        TextView textView4 = this.binding.p;
        m.checkNotNullExpressionValue(textView4, "binding.chatListItemEmbedProvider");
        textView4.setVisibility(0);
    }

    private final void configureEmbedThumbnail(MessageEmbed embed) {
        boolean z2 = embed.getType() == EmbedType.LINK || embed.getType() == EmbedType.HTML || embed.getType() == EmbedType.RICH;
        EmbedThumbnail thumbnail = embed.getThumbnail();
        if (!z2 || thumbnail == null) {
            SimpleDraweeView simpleDraweeView = this.binding.o;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImageThumbnail");
            simpleDraweeView.setVisibility(8);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.o;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedImageThumbnail");
            simpleDraweeView2.setVisibility(0);
            SimpleDraweeView simpleDraweeView3 = this.binding.o;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedImageThumbnail");
            configureEmbedImage$default(this, thumbnail, simpleDraweeView3, this.embedThumbnailMaxSize, 0, 8, null);
        }
    }

    private final void configureEmbedTitle(Model model, MessageRenderContext renderContext) {
        int themedColor;
        Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        MessageEmbed embed = model.getEmbedEntry().getEmbed();
        String title = embed.getTitle();
        if (title == null) {
            LinkifiedTextView linkifiedTextView = this.binding.r;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.chatListItemEmbedTitle");
            linkifiedTextView.setVisibility(8);
            return;
        }
        int embedIndex = model.getEmbedEntry().getEmbedIndex();
        List list = Parser.parse$default(UI_THREAD_TITLES_PARSER, title, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
        long myId = model.getMyId();
        StoreMessageState.State messageState = model.getEmbedEntry().getMessageState();
        new MessagePreprocessor(myId, (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null) ? null : Companion.access$getEmbedFieldVisibleIndices(INSTANCE, visibleSpoilerEmbedMap, embedIndex, EMBED_TYPE_TITLE), null, false, null, 28, null).process(list);
        this.binding.r.setDraweeSpanStringBuilder(AstRenderer.render(list, MessageRenderContext.copy$default(renderContext, null, 0L, false, null, null, null, 0, null, null, 0, 0, new AnonymousClass1(model, embedIndex), null, null, 14335, null)));
        LinkifiedTextView linkifiedTextView2 = this.binding.r;
        if (embed.getUrl() != null) {
            LinkifiedTextView linkifiedTextView3 = this.binding.r;
            m.checkNotNullExpressionValue(linkifiedTextView3, "binding.chatListItemEmbedTitle");
            themedColor = ColorCompat.getThemedColor(linkifiedTextView3, R.attr.colorTextLink);
        } else {
            LinkifiedTextView linkifiedTextView4 = this.binding.r;
            m.checkNotNullExpressionValue(linkifiedTextView4, "binding.chatListItemEmbedTitle");
            themedColor = ColorCompat.getThemedColor(linkifiedTextView4, R.attr.primary_100);
        }
        linkifiedTextView2.setTextColor(themedColor);
        Companion companion = INSTANCE;
        LinkifiedTextView linkifiedTextView5 = this.binding.r;
        m.checkNotNullExpressionValue(linkifiedTextView5, "binding.chatListItemEmbedTitle");
        Companion.access$bindUrlOnClick(companion, linkifiedTextView5, embed.getUrl(), embed.getTitle());
        LinkifiedTextView linkifiedTextView6 = this.binding.r;
        m.checkNotNullExpressionValue(linkifiedTextView6, "binding.chatListItemEmbedTitle");
        linkifiedTextView6.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.CharSequence] */
    private final void configureFooter(EmbedFooter footer, UtcDateTime timestamp) {
        String text = null;
        String text2 = footer != null ? footer.getText() : null;
        if (text2 == null || text2.length() == 0) {
            SimpleDraweeView simpleDraweeView = this.binding.k;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedFooterIcon");
            simpleDraweeView.setVisibility(8);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.k;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.chatListItemEmbedFooterIcon");
            simpleDraweeView2.setVisibility((footer != null ? footer.getProxyIconUrl() : null) != null ? 0 : 8);
            SimpleDraweeView simpleDraweeView3 = this.binding.k;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.chatListItemEmbedFooterIcon");
            int i = this.embedTinyIconSize;
            configureEmbedImage$default(this, simpleDraweeView3, i, i, i, footer != null ? footer.getProxyIconUrl() : null, 0, 32, null);
        }
        String readableTimeString$default = timestamp != null ? TimeUtils.toReadableTimeString$default(a.I(this.binding.l, "binding.chatListItemEmbedFooterText", "binding.chatListItemEmbedFooterText.context"), timestamp.getDateTimeMillis(), null, 4, null) : null;
        TextView textView = this.binding.l;
        if (footer != null && readableTimeString$default != null) {
            text = footer.getText() + " | " + ((CharSequence) readableTimeString$default);
        } else if (footer != null) {
            text = footer.getText();
        } else if (readableTimeString$default != null) {
            text = readableTimeString$default;
        }
        textView.setText(text);
        CharSequence text3 = textView.getText();
        m.checkNotNullExpressionValue(text3, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        textView.setVisibility(text3.length() > 0 ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureInlineEmbed(MessageEmbed embed, boolean autoPlayGifs) {
        RenderableEmbedMedia previewImage;
        boolean z2;
        if (!shouldRenderMedia()) {
            InlineMediaView inlineMediaView = this.binding.t;
            m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
            inlineMediaView.setVisibility(8);
            return;
        }
        EmbedVideo video = embed.getVideo();
        if (video != null) {
            m.checkNotNullParameter(video, "$this$asRenderableEmbedMedia");
            String proxyUrl = video.getProxyUrl();
            if (proxyUrl == null) {
                proxyUrl = video.getUrl();
            }
            previewImage = new RenderableEmbedMedia(proxyUrl, video.getWidth(), video.getHeight());
        } else {
            previewImage = EmbedResourceUtils.INSTANCE.getPreviewImage(embed);
        }
        if (previewImage != null) {
            Integer num = previewImage.width;
            if ((num != null ? num.intValue() : 0) > 0) {
                z2 = true;
                if (z2) {
                    InlineMediaView inlineMediaView2 = this.binding.t;
                    m.checkNotNullExpressionValue(inlineMediaView2, "binding.embedInlineMedia");
                    inlineMediaView2.setVisibility(8);
                } else {
                    EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
                    Integer num2 = previewImage.width;
                    int iIntValue = num2 != null ? num2.intValue() : 0;
                    Integer num3 = previewImage.height;
                    int iIntValue2 = num3 != null ? num3.intValue() : 0;
                    int i = this.maxEmbedImageWidth;
                    int i2 = MAX_IMAGE_VIEW_HEIGHT_PX;
                    InlineMediaView inlineMediaView3 = this.binding.t;
                    m.checkNotNullExpressionValue(inlineMediaView3, "binding.embedInlineMedia");
                    Resources resources = inlineMediaView3.getResources();
                    m.checkNotNullExpressionValue(resources, "binding.embedInlineMedia.resources");
                    Pair pairCalculateScaledSize$default = EmbedResourceUtils.calculateScaledSize$default(embedResourceUtils, iIntValue, iIntValue2, i, i2, resources, 0, 32, null);
                    int iIntValue3 = ((Number) pairCalculateScaledSize$default.component1()).intValue();
                    int iIntValue4 = ((Number) pairCalculateScaledSize$default.component2()).intValue();
                    InlineMediaView inlineMediaView4 = this.binding.t;
                    m.checkNotNullExpressionValue(inlineMediaView4, "binding.embedInlineMedia");
                    inlineMediaView4.setVisibility(0);
                    this.binding.t.updateUIWithEmbed(embed, Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue4), autoPlayGifs);
                }
            } else {
                Integer num4 = previewImage.height;
                if ((num4 != null ? num4.intValue() : 0) <= 0) {
                    z2 = false;
                }
                if (z2) {
                }
            }
        } else {
            InlineMediaView inlineMediaView5 = this.binding.t;
            m.checkNotNullExpressionValue(inlineMediaView5, "binding.embedInlineMedia");
            inlineMediaView5.setVisibility(8);
        }
        InlineMediaView inlineMediaView6 = this.binding.t;
        inlineMediaView6.setOnClickListener(new WidgetChatListAdapterItemEmbed$configureInlineEmbed$$inlined$apply$lambda$1(inlineMediaView6, embed));
    }

    private final void configureUI(Model model) {
        EmbedEntry embedEntry = model.getEmbedEntry();
        MessageEmbed embed = embedEntry.getEmbed();
        MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(a.x(this.itemView, "itemView", "itemView.context"), ((WidgetChatListAdapter) this.adapter).getEventHandler());
        if (model.getIsSpoilerHidden()) {
            ViewExtensions.fadeIn$default(this.binding.q, 50L, null, AnonymousClass1.INSTANCE, null, 10, null);
        } else {
            ViewExtensions.fadeOut$default(this.binding.q, 200L, AnonymousClass2.INSTANCE, null, 4, null);
        }
        this.binding.q.setOnClickListener(new AnonymousClass3(model, embedEntry));
        try {
            if (EmbedResourceUtils.INSTANCE.isInlineEmbed(embed)) {
                ConstraintLayout constraintLayout = this.binding.g;
                m.checkNotNullExpressionValue(constraintLayout, "binding.chatListItemEmbedContent");
                constraintLayout.setVisibility(8);
                View view = this.binding.i;
                m.checkNotNullExpressionValue(view, "binding.chatListItemEmbedDivider");
                view.setVisibility(8);
                SimpleDraweeView simpleDraweeView = this.binding.o;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListItemEmbedImageThumbnail");
                simpleDraweeView.setVisibility(8);
                InlineMediaView inlineMediaView = this.binding.t;
                m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
                inlineMediaView.setVisibility(0);
                configureInlineEmbed(embed, embedEntry.getAutoPlayGifs());
                MaterialCardView materialCardView = this.binding.f;
                View view2 = this.itemView;
                m.checkNotNullExpressionValue(view2, "itemView");
                materialCardView.setCardBackgroundColor(ColorCompat.getColor(view2, R.color.transparent));
                MaterialCardView materialCardView2 = this.binding.f;
                m.checkNotNullExpressionValue(materialCardView2, "binding.chatListItemEmbedContainerCard");
                materialCardView2.setStrokeWidth(0);
            } else {
                ConstraintLayout constraintLayout2 = this.binding.g;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.chatListItemEmbedContent");
                constraintLayout2.setVisibility(0);
                View view3 = this.binding.i;
                m.checkNotNullExpressionValue(view3, "binding.chatListItemEmbedDivider");
                view3.setVisibility(0);
                InlineMediaView inlineMediaView2 = this.binding.t;
                m.checkNotNullExpressionValue(inlineMediaView2, "binding.embedInlineMedia");
                inlineMediaView2.setVisibility(8);
                configureEmbedDivider(!model.getIsSpoilerHidden() ? embed.getColor() : null);
                configureEmbedProvider(embed, messageRenderContextCreateRenderContext);
                configureEmbedAuthor(embed.getAuthor());
                configureEmbedTitle(model, messageRenderContextCreateRenderContext);
                configureEmbedDescription(model, messageRenderContextCreateRenderContext);
                configureEmbedThumbnail(embed);
                configureEmbedImage(embed);
                configureEmbedFields(model, messageRenderContextCreateRenderContext);
                configureFooter(embed.getFooter(), embed.getTimestamp());
                MaterialCardView materialCardView3 = this.binding.f;
                View view4 = this.itemView;
                m.checkNotNullExpressionValue(view4, "itemView");
                materialCardView3.setCardBackgroundColor(ColorCompat.getThemedColor(view4, R.attr.colorBackgroundSecondary));
                MaterialCardView materialCardView4 = this.binding.f;
                m.checkNotNullExpressionValue(materialCardView4, "binding.chatListItemEmbedContainerCard");
                MaterialCardView materialCardView5 = this.binding.f;
                m.checkNotNullExpressionValue(materialCardView5, "binding.chatListItemEmbedContainerCard");
                materialCardView4.setStrokeWidth(materialCardView5.getResources().getDimensionPixelSize(R.dimen.chat_embed_card_stroke_width));
            }
            View view5 = this.itemView;
            m.checkNotNullExpressionValue(view5, "itemView");
            view5.setVisibility(0);
        } catch (Exception e) {
            View view6 = this.itemView;
            m.checkNotNullExpressionValue(view6, "itemView");
            view6.setVisibility(8);
            Logger.e$default(AppLog.g, "Unable to render embed.", e, null, 4, null);
        }
    }

    private final List<Model.ParsedField> parseFields(List<EmbedField> fields, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> nameParser, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> valueParser) {
        if (fields == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(fields, 10));
        for (EmbedField embedField : fields) {
            String name = embedField.getName();
            MessageParseState.Companion companion = MessageParseState.INSTANCE;
            arrayList.add(new Model.ParsedField(Parser.parse$default(nameParser, name, companion.getInitialState(), null, 4, null), Parser.parse$default(valueParser, embedField.getValue(), companion.getInitialState(), null, 4, null)));
        }
        return arrayList;
    }

    private final boolean shouldRenderMedia() {
        return this.userSettings.getIsEmbedMediaInlined() && this.userSettings.getIsRenderEmbedsEnabled();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        this.binding.t.onPause();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        this.binding.t.onResume();
    }

    public static /* synthetic */ void configureEmbedImage$default(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, ImageView imageView, int i, int i2, int i3, String str, int i4, int i5, Object obj) {
        widgetChatListAdapterItemEmbed.configureEmbedImage(imageView, i, i2, i3, str, (i5 & 32) != 0 ? 0 : i4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        EmbedEntry embedEntry = (EmbedEntry) data;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view, new AnonymousClass1(data));
        this.itemView.setOnClickListener(new AnonymousClass2(data));
        Message message = embedEntry.getMessage();
        View view2 = this.binding.c;
        m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        View view3 = this.binding.f2315b;
        m.checkNotNullExpressionValue(view3, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view2, view3);
        String description = embedEntry.getEmbed().getDescription();
        Model model = new Model(embedEntry, description != null ? Parser.parse$default(UI_THREAD_VALUES_PARSER, description, MessageParseState.INSTANCE.getInitialState(), null, 4, null) : null, parseFields(embedEntry.getEmbed().d(), UI_THREAD_TITLES_PARSER, UI_THREAD_VALUES_PARSER), null, null, null, 0L, 120, null);
        configureUI(model);
        Observable observableZ = Companion.access$getModel(INSTANCE, model).Z(1);
        m.checkNotNullExpressionValue(observableZ, "getModel(initialModel)\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableZ), WidgetChatListAdapterItemEmbed.class, (Context) null, new AnonymousClass3(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 58, (Object) null);
    }

    /* compiled from: WidgetChatListAdapterItemEmbed.kt */
    public static final /* data */ class Model {
        private final Map<Long, String> channelNames;
        private final EmbedEntry embedEntry;
        private final boolean isEmbedUrlFoundInVisibleSpoilerNode;
        private final boolean isSpoilerHidden;
        private final long myId;
        private final Collection<Node<MessageRenderContext>> parsedDescription;
        private final List<ParsedField> parsedFields;
        private final Map<Long, GuildRole> roles;
        private final List<SpoilerNode<?>> spoilers;
        private final Map<Long, String> userNames;

        /* compiled from: WidgetChatListAdapterItemEmbed.kt */
        public static final /* data */ class ParsedField {
            private final Collection<Node<MessageRenderContext>> parsedName;
            private final Collection<Node<MessageRenderContext>> parsedValue;

            /* JADX WARN: Multi-variable type inference failed */
            public ParsedField(Collection<? extends Node<MessageRenderContext>> collection, Collection<? extends Node<MessageRenderContext>> collection2) {
                m.checkNotNullParameter(collection, "parsedName");
                m.checkNotNullParameter(collection2, "parsedValue");
                this.parsedName = collection;
                this.parsedValue = collection2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ParsedField copy$default(ParsedField parsedField, Collection collection, Collection collection2, int i, Object obj) {
                if ((i & 1) != 0) {
                    collection = parsedField.parsedName;
                }
                if ((i & 2) != 0) {
                    collection2 = parsedField.parsedValue;
                }
                return parsedField.copy(collection, collection2);
            }

            public final Collection<Node<MessageRenderContext>> component1() {
                return this.parsedName;
            }

            public final Collection<Node<MessageRenderContext>> component2() {
                return this.parsedValue;
            }

            public final ParsedField copy(Collection<? extends Node<MessageRenderContext>> parsedName, Collection<? extends Node<MessageRenderContext>> parsedValue) {
                m.checkNotNullParameter(parsedName, "parsedName");
                m.checkNotNullParameter(parsedValue, "parsedValue");
                return new ParsedField(parsedName, parsedValue);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ParsedField)) {
                    return false;
                }
                ParsedField parsedField = (ParsedField) other;
                return m.areEqual(this.parsedName, parsedField.parsedName) && m.areEqual(this.parsedValue, parsedField.parsedValue);
            }

            public final Collection<Node<MessageRenderContext>> getParsedName() {
                return this.parsedName;
            }

            public final Collection<Node<MessageRenderContext>> getParsedValue() {
                return this.parsedValue;
            }

            public int hashCode() {
                Collection<Node<MessageRenderContext>> collection = this.parsedName;
                int iHashCode = (collection != null ? collection.hashCode() : 0) * 31;
                Collection<Node<MessageRenderContext>> collection2 = this.parsedValue;
                return iHashCode + (collection2 != null ? collection2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("ParsedField(parsedName=");
                sbU.append(this.parsedName);
                sbU.append(", parsedValue=");
                sbU.append(this.parsedValue);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Model(EmbedEntry embedEntry, Collection<? extends Node<MessageRenderContext>> collection, List<ParsedField> list, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, long j) {
            boolean z2;
            boolean z3;
            Set<Integer> visibleSpoilerNodeIndices;
            m.checkNotNullParameter(embedEntry, "embedEntry");
            this.embedEntry = embedEntry;
            this.parsedDescription = collection;
            this.parsedFields = list;
            this.channelNames = map;
            this.userNames = map2;
            this.roles = map3;
            this.myId = j;
            Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parserCreateTitlesParser = WidgetChatListAdapterItemEmbed.INSTANCE.createTitlesParser();
            String content = embedEntry.getMessage().getContent();
            List list2 = Parser.parse$default(parserCreateTitlesParser, content == null ? "" : content, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
            MessagePreprocessor messagePreprocessor = new MessagePreprocessor(j, embedEntry.getMessageState());
            messagePreprocessor.process(list2);
            List<SpoilerNode<?>> spoilers = messagePreprocessor.getSpoilers();
            this.spoilers = spoilers;
            if (spoilers == null) {
                z2 = false;
            } else {
                StoreMessageState.State messageState = embedEntry.getMessageState();
                if (messageState == null || (visibleSpoilerNodeIndices = messageState.getVisibleSpoilerNodeIndices()) == null) {
                    z3 = false;
                    if (!z3) {
                        z2 = true;
                    }
                } else {
                    ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(visibleSpoilerNodeIndices, 10));
                    Iterator<T> it = visibleSpoilerNodeIndices.iterator();
                    while (it.hasNext()) {
                        arrayList.add(this.spoilers.get(((Number) it.next()).intValue()));
                    }
                    try {
                        b.c.a.a0.d.i2(arrayList, new WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$1(embedEntry.getEmbed().getUrl()));
                        z3 = false;
                    } catch (WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$MatchFoundException unused) {
                        z3 = true;
                    }
                    if (!z3) {
                    }
                }
            }
            this.isEmbedUrlFoundInVisibleSpoilerNode = z2;
            this.isSpoilerHidden = !isSpoilerEmbedRevealed(this.embedEntry) && isSpoilerEmbed();
        }

        public static /* synthetic */ Model copy$default(Model model, EmbedEntry embedEntry, Collection collection, List list, Map map, Map map2, Map map3, long j, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.embedEntry : embedEntry, (i & 2) != 0 ? model.parsedDescription : collection, (i & 4) != 0 ? model.parsedFields : list, (i & 8) != 0 ? model.channelNames : map, (i & 16) != 0 ? model.userNames : map2, (i & 32) != 0 ? model.roles : map3, (i & 64) != 0 ? model.myId : j);
        }

        private final boolean isSpoilerEmbed() {
            boolean z2;
            List<SpoilerNode<?>> list = this.spoilers;
            if (list != null) {
                if (list.isEmpty()) {
                    z2 = false;
                    if (!z2 && !this.isEmbedUrlFoundInVisibleSpoilerNode) {
                        return true;
                    }
                } else {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (w.contains$default((CharSequence) ((SpoilerNode) it.next()).getContent(), (CharSequence) "http", false, 2, (Object) null)) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
            return false;
        }

        private final boolean isSpoilerEmbedRevealed(EmbedEntry embedEntry) {
            Map<Integer, Set<String>> visibleSpoilerEmbedMap;
            StoreMessageState.State messageState = embedEntry.getMessageState();
            return (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null || !visibleSpoilerEmbedMap.containsKey(Integer.valueOf(embedEntry.getEmbedIndex()))) ? false : true;
        }

        /* renamed from: component1, reason: from getter */
        public final EmbedEntry getEmbedEntry() {
            return this.embedEntry;
        }

        public final Collection<Node<MessageRenderContext>> component2() {
            return this.parsedDescription;
        }

        public final List<ParsedField> component3() {
            return this.parsedFields;
        }

        public final Map<Long, String> component4() {
            return this.channelNames;
        }

        public final Map<Long, String> component5() {
            return this.userNames;
        }

        public final Map<Long, GuildRole> component6() {
            return this.roles;
        }

        /* renamed from: component7, reason: from getter */
        public final long getMyId() {
            return this.myId;
        }

        public final Model copy(EmbedEntry embedEntry, Collection<? extends Node<MessageRenderContext>> parsedDescription, List<ParsedField> parsedFields, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, long myId) {
            m.checkNotNullParameter(embedEntry, "embedEntry");
            return new Model(embedEntry, parsedDescription, parsedFields, channelNames, userNames, roles, myId);
        }

        public final MessageRenderContext createRenderContext(Context androidContext, WidgetChatListAdapter.EventHandler eventHandler) {
            m.checkNotNullParameter(androidContext, "androidContext");
            m.checkNotNullParameter(eventHandler, "eventHandler");
            return new MessageRenderContext(androidContext, this.myId, this.embedEntry.getAllowAnimatedEmojis(), this.userNames, this.channelNames, this.roles, 0, null, new WidgetChatListAdapterItemEmbed$Model$createRenderContext$1(eventHandler), 0, 0, null, null, null, 16064, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.embedEntry, model.embedEntry) && m.areEqual(this.parsedDescription, model.parsedDescription) && m.areEqual(this.parsedFields, model.parsedFields) && m.areEqual(this.channelNames, model.channelNames) && m.areEqual(this.userNames, model.userNames) && m.areEqual(this.roles, model.roles) && this.myId == model.myId;
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final EmbedEntry getEmbedEntry() {
            return this.embedEntry;
        }

        public final long getMyId() {
            return this.myId;
        }

        public final Collection<Node<MessageRenderContext>> getParsedDescription() {
            return this.parsedDescription;
        }

        public final List<ParsedField> getParsedFields() {
            return this.parsedFields;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, String> getUserNames() {
            return this.userNames;
        }

        public int hashCode() {
            EmbedEntry embedEntry = this.embedEntry;
            int iHashCode = (embedEntry != null ? embedEntry.hashCode() : 0) * 31;
            Collection<Node<MessageRenderContext>> collection = this.parsedDescription;
            int iHashCode2 = (iHashCode + (collection != null ? collection.hashCode() : 0)) * 31;
            List<ParsedField> list = this.parsedFields;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, String> map = this.channelNames;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, String> map2 = this.userNames;
            int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map3 = this.roles;
            return b.a(this.myId) + ((iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31);
        }

        /* renamed from: isSpoilerHidden, reason: from getter */
        public final boolean getIsSpoilerHidden() {
            return this.isSpoilerHidden;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(embedEntry=");
            sbU.append(this.embedEntry);
            sbU.append(", parsedDescription=");
            sbU.append(this.parsedDescription);
            sbU.append(", parsedFields=");
            sbU.append(this.parsedFields);
            sbU.append(", channelNames=");
            sbU.append(this.channelNames);
            sbU.append(", userNames=");
            sbU.append(this.userNames);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", myId=");
            return a.C(sbU, this.myId, ")");
        }

        public /* synthetic */ Model(EmbedEntry embedEntry, Collection collection, List list, Map map, Map map2, Map map3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(embedEntry, collection, list, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : map2, (i & 32) != 0 ? null : map3, (i & 64) != 0 ? 0L : j);
        }
    }

    private final void configureEmbedImage(EmbedThumbnail thumbnail, ImageView view, int maxWidth, int minWidth) {
        Integer width = thumbnail.getWidth();
        int iIntValue = width != null ? width.intValue() : 0;
        Integer height = thumbnail.getHeight();
        configureEmbedImage(view, maxWidth, iIntValue, height != null ? height.intValue() : 0, thumbnail.getProxyUrl(), minWidth);
    }

    private final void configureEmbedImage(ImageView view, int maxWidth, int width, int height, String imageProxyUrl, int minWidth) {
        if (imageProxyUrl == null) {
            return;
        }
        view.setVisibility(0);
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        InlineMediaView inlineMediaView = this.binding.t;
        m.checkNotNullExpressionValue(inlineMediaView, "binding.embedInlineMedia");
        Resources resources = inlineMediaView.getResources();
        m.checkNotNullExpressionValue(resources, "binding.embedInlineMedia.resources");
        Pair<Integer, Integer> pairCalculateScaledSize = embedResourceUtils.calculateScaledSize(width, height, maxWidth, maxWidth, resources, minWidth);
        int iIntValue = pairCalculateScaledSize.component1().intValue();
        int iIntValue2 = pairCalculateScaledSize.component2().intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != iIntValue || layoutParams.height != iIntValue2) {
            layoutParams.width = iIntValue;
            layoutParams.height = iIntValue2;
            view.requestLayout();
        }
        MGImages.setImage$default(view, EmbedResourceUtils.getPreviewUrls$default(embedResourceUtils, imageProxyUrl, iIntValue, iIntValue2, false, 8, null), 0, 0, false, null, null, null, 252, null);
    }
}
