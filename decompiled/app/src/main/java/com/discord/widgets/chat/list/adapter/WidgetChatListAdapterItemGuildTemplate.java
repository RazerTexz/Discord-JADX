package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemGuildTemplateBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import com.discord.widgets.guilds.create.WidgetGuildClone;
import com.google.android.material.button.MaterialButton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildTemplateBinding binding;
    private GuildTemplateEntry item;
    private Subscription subscription;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static abstract class Model {

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final class Invalid extends Model {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
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

            /* JADX INFO: renamed from: component1, reason: from getter */
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
                StringBuilder sbM833U = outline.m833U("Resolved(guildTemplate=");
                sbM833U.append(this.guildTemplate);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public final Observable<Model> get(GuildTemplateEntry item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            Observable observableM11099Y = StoreStream.INSTANCE.getGuildTemplates().observeGuildTemplate(item.getGuildTemplateCode()).m11116v(new WidgetChatListAdapterItemGuildTemplate2(item)).m11099Y(WidgetChatListAdapterItemGuildTemplate3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…tes\n          }\n        }");
            return observableM11099Y;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$configureResolvedUI$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class ViewOnClickListenerC80831 implements View.OnClickListener {
        public final /* synthetic */ ModelGuildTemplate $guildTemplate;

        public ViewOnClickListenerC80831(ModelGuildTemplate modelGuildTemplate) {
            this.$guildTemplate = modelGuildTemplate;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemGuildTemplate.access$openGuildTemplate(WidgetChatListAdapterItemGuildTemplate.this, outline.m885x(view, "it", "it.context"), this.$guildTemplate);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final /* synthetic */ class C80841 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C80841(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
            super(1, widgetChatListAdapterItemGuildTemplate, WidgetChatListAdapterItemGuildTemplate.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemGuildTemplate.access$configureUI((WidgetChatListAdapterItemGuildTemplate) this.receiver, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class C80852 extends Lambda implements Function1<Error, Unit> {
        public C80852() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGuildTemplate.access$configureInvalidUI(WidgetChatListAdapterItemGuildTemplate.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    public static final class C80863 extends Lambda implements Function1<Subscription, Unit> {
        public C80863() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildTemplate.access$setSubscription$p(WidgetChatListAdapterItemGuildTemplate.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_guild_template, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.item_guild_template_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.item_guild_template_header);
        if (textView != null) {
            i = C5419R.id.item_guild_template_image;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.item_guild_template_image);
            if (imageView != null) {
                i = C5419R.id.item_guild_template_join_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.item_guild_template_join_button);
                if (materialButton != null) {
                    i = C5419R.id.item_guild_template_name;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.item_guild_template_name);
                    if (textView2 != null) {
                        i = C5419R.id.item_guild_template_subtext;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.item_guild_template_subtext);
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
        this.binding.f16230c.setText(C5419R.string.guild_template_invalid_title);
        this.binding.f16231d.setText(C5419R.string.guild_template_invalid_subtitle);
        TextView textView = this.binding.f16231d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(0);
        MaterialButton materialButton = this.binding.f16229b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureLoadingUI() {
        this.binding.f16230c.setText(C5419R.string.guild_template_resolving_title);
        TextView textView = this.binding.f16231d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(8);
        MaterialButton materialButton = this.binding.f16229b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureResolvedUI(Model.Resolved model) {
        ModelGuildTemplate guildTemplate = model.getGuildTemplate();
        TextView textView = this.binding.f16230c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateName");
        textView.setText(guildTemplate.getName());
        TextView textView2 = this.binding.f16231d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGuildTemplateSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, StringResourceUtils.getI18nPluralString(outline.m821I(this.binding.f16231d, "binding.itemGuildTemplateSubtext", "binding.itemGuildTemplateSubtext.context"), C5419R.plurals.guild_template_usages_usageCount, guildTemplate.getUsageCount(), Integer.valueOf(guildTemplate.getUsageCount())));
        MaterialButton materialButton = this.binding.f16229b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(0);
        this.binding.f16229b.setOnClickListener(new ViewOnClickListenerC80831(guildTemplate));
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
        Observable observableM8518ui = ObservableExtensionsKt.m8518ui(modelProvider.get(guildTemplateEntry));
        C80841 c80841 = new C80841(this);
        ObservableExtensionsKt.appSubscribe$default(observableM8518ui, WidgetChatListAdapterItemGuildTemplate.class, (Context) null, new C80863(), new C80852(), (Function0) null, (Function0) null, c80841, 50, (Object) null);
    }
}
