package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemGuildTemplateBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import com.discord.widgets.guilds.create.WidgetGuildClone;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildTemplateBinding binding;
    private GuildTemplateEntry item;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static abstract class Model {

        /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final class Invalid extends Model {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final /* data */ class Resolved extends Model {
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGuildTemplate modelGuildTemplate) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
                this.guildTemplate = modelGuildTemplate;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGuildTemplate modelGuildTemplate, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildTemplate = resolved.guildTemplate;
                }
                return resolved.copy(modelGuildTemplate);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public final Resolved copy(ModelGuildTemplate guildTemplate) {
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new Resolved(guildTemplate);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.guildTemplate, ((Resolved) other).guildTemplate);
                }
                return true;
            }

            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public int hashCode() {
                ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
                if (modelGuildTemplate != null) {
                    return modelGuildTemplate.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public final Observable<Model> get(GuildTemplateEntry item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            Observable observableY = StoreStream.INSTANCE.getGuildTemplates().observeGuildTemplate(item.getGuildTemplateCode()).v(new WidgetChatListAdapterItemGuildTemplate2(item)).Y(WidgetChatListAdapterItemGuildTemplate3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…tes\n          }\n        }");
            return observableY;
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$configureResolvedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ModelGuildTemplate $guildTemplate;

        public AnonymousClass1(ModelGuildTemplate modelGuildTemplate) {
            this.$guildTemplate = modelGuildTemplate;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemGuildTemplate.access$openGuildTemplate(WidgetChatListAdapterItemGuildTemplate.this, outline.x(view, "it", "it.context"), this.$guildTemplate);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
            super(1, widgetChatListAdapterItemGuildTemplate, WidgetChatListAdapterItemGuildTemplate.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemGuildTemplate.access$configureUI((WidgetChatListAdapterItemGuildTemplate) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGuildTemplate.access$configureInvalidUI(WidgetChatListAdapterItemGuildTemplate.this);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
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
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildTemplate.access$setSubscription$p(WidgetChatListAdapterItemGuildTemplate.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_guild_template, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.item_guild_template_header;
        TextView textView = (TextView) view.findViewById(R.id.item_guild_template_header);
        if (textView != null) {
            i = R.id.item_guild_template_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.item_guild_template_image);
            if (imageView != null) {
                i = R.id.item_guild_template_join_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_guild_template_join_button);
                if (materialButton != null) {
                    i = R.id.item_guild_template_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.item_guild_template_name);
                    if (textView2 != null) {
                        i = R.id.item_guild_template_subtext;
                        TextView textView3 = (TextView) view.findViewById(R.id.item_guild_template_subtext);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            WidgetChatListAdapterItemGuildTemplateBinding widgetChatListAdapterItemGuildTemplateBinding = new WidgetChatListAdapterItemGuildTemplateBinding(constraintLayout, textView, imageView, materialButton, textView2, textView3, constraintLayout);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildTemplateBinding, "WidgetChatListAdapterIte…ateBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemGuildTemplateBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureInvalidUI(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        widgetChatListAdapterItemGuildTemplate.configureInvalidUI();
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Model model) {
        widgetChatListAdapterItemGuildTemplate.configureUI(model);
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        return widgetChatListAdapterItemGuildTemplate.subscription;
    }

    public static final /* synthetic */ void access$openGuildTemplate(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Context context, ModelGuildTemplate modelGuildTemplate) {
        widgetChatListAdapterItemGuildTemplate.openGuildTemplate(context, modelGuildTemplate);
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Subscription subscription) {
        widgetChatListAdapterItemGuildTemplate.subscription = subscription;
    }

    private final void configureInvalidUI() {
        this.binding.c.setText(R.string.guild_template_invalid_title);
        this.binding.d.setText(R.string.guild_template_invalid_subtitle);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(0);
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureLoadingUI() {
        this.binding.c.setText(R.string.guild_template_resolving_title);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(8);
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureResolvedUI(Model.Resolved model) {
        ModelGuildTemplate guildTemplate = model.getGuildTemplate();
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateName");
        textView.setText(guildTemplate.getName());
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGuildTemplateSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, StringResourceUtils.getI18nPluralString(outline.I(this.binding.d, "binding.itemGuildTemplateSubtext", "binding.itemGuildTemplateSubtext.context"), R.plurals.guild_template_usages_usageCount, guildTemplate.getUsageCount(), Integer.valueOf(guildTemplate.getUsageCount())));
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(0);
        this.binding.f2323b.setOnClickListener(new AnonymousClass1(guildTemplate));
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            configureLoadingUI();
        } else if (model instanceof Model.Resolved) {
            configureResolvedUI((Model.Resolved) model);
        } else {
            if (!(model instanceof Model.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI();
        }
    }

    private final void openGuildTemplate(Context context, ModelGuildTemplate guildTemplate) {
        WidgetGuildClone.INSTANCE.show(context, guildTemplate.getCode(), "Guild Template Embed");
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildTemplateEntry guildTemplateEntry = (GuildTemplateEntry) data;
        this.item = guildTemplateEntry;
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        if (guildTemplateEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        Observable observableUi = ObservableExtensionsKt.ui(modelProvider.get(guildTemplateEntry));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
        ObservableExtensionsKt.appSubscribe$default(observableUi, WidgetChatListAdapterItemGuildTemplate.class, (Context) null, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
    }
}
