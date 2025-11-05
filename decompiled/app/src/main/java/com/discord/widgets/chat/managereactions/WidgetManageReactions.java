package com.discord.widgets.chat.managereactions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetManageReactionsBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import d0.z.d.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetManageReactions.kt */
/* loaded from: classes2.dex */
public final class WidgetManageReactions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetManageReactions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetManageReactionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMOJI_KEY = "com.discord.intent.extra.EXTRA_EMOJI_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ManageReactionsEmojisAdapter emojisAdapter;
    private ManageReactionsModelProvider modelProvider;
    private ManageReactionsResultsAdapter resultsAdapter;

    /* compiled from: WidgetManageReactions.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, long j, long j2, Context context, MessageReaction messageReaction, int i, Object obj) {
            if ((i & 8) != 0) {
                messageReaction = null;
            }
            companion.create(j, j2, context, messageReaction);
        }

        public final void create(long channelId, long messageId, Context context, MessageReaction targetedReaction) {
            MessageReactionEmoji emoji;
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId).putExtra(WidgetManageReactions.EXTRA_EMOJI_KEY, (targetedReaction == null || (emoji = targetedReaction.getEmoji()) == null) ? null : emoji.c());
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…eaction?.emoji?.getKey())");
            j.d(context, WidgetManageReactions.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetManageReactions.kt */
    /* renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$1, reason: invalid class name */
    public final /* synthetic */ class AnonymousClass1 extends q {
        public AnonymousClass1(WidgetManageReactions widgetManageReactions) {
            super(widgetManageReactions, WidgetManageReactions.class, "modelProvider", "getModelProvider()Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", 0);
        }

        @Override // d0.z.d.q, kotlin.reflect.KProperty0
        public Object get() {
            return WidgetManageReactions.access$getModelProvider$p((WidgetManageReactions) this.receiver);
        }

        @Override // d0.z.d.q
        public void set(Object obj) {
            WidgetManageReactions.access$setModelProvider$p((WidgetManageReactions) this.receiver, (ManageReactionsModelProvider) obj);
        }
    }

    /* compiled from: WidgetManageReactions.kt */
    /* renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<String, Unit> {
        public AnonymousClass2(ManageReactionsModelProvider manageReactionsModelProvider) {
            super(1, manageReactionsModelProvider, ManageReactionsModelProvider.class, "onEmojiTargeted", "onEmojiTargeted(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "p1");
            ((ManageReactionsModelProvider) this.receiver).onEmojiTargeted(str);
        }
    }

    /* compiled from: WidgetManageReactions.kt */
    /* renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ManageReactionsModel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManageReactionsModel manageReactionsModel) {
            invoke2(manageReactionsModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManageReactionsModel manageReactionsModel) {
            WidgetManageReactions.access$configureUI(WidgetManageReactions.this, manageReactionsModel);
        }
    }

    public WidgetManageReactions() {
        super(R.layout.widget_manage_reactions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetManageReactions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetManageReactions widgetManageReactions, ManageReactionsModel manageReactionsModel) {
        widgetManageReactions.configureUI(manageReactionsModel);
    }

    public static final /* synthetic */ ManageReactionsModelProvider access$getModelProvider$p(WidgetManageReactions widgetManageReactions) {
        ManageReactionsModelProvider manageReactionsModelProvider = widgetManageReactions.modelProvider;
        if (manageReactionsModelProvider == null) {
            m.throwUninitializedPropertyAccessException("modelProvider");
        }
        return manageReactionsModelProvider;
    }

    public static final /* synthetic */ void access$setModelProvider$p(WidgetManageReactions widgetManageReactions, ManageReactionsModelProvider manageReactionsModelProvider) {
        widgetManageReactions.modelProvider = manageReactionsModelProvider;
    }

    private final void configureUI(ManageReactionsModel data) {
        if (data == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        manageReactionsEmojisAdapter.setData(data.getReactionItems());
        ManageReactionsResultsAdapter manageReactionsResultsAdapter = this.resultsAdapter;
        if (manageReactionsResultsAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        manageReactionsResultsAdapter.setData(data.getUserItems());
    }

    public static final void create(long j, long j2, Context context, MessageReaction messageReaction) {
        INSTANCE.create(j, j2, context, messageReaction);
    }

    private final WidgetManageReactionsBinding getBinding() {
        return (WidgetManageReactionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.reactions);
        if (this.modelProvider == null) {
            this.modelProvider = new ManageReactionsModelProvider(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), getMostRecentIntent().getStringExtra(EXTRA_EMOJI_KEY), null, null, null, 56, null);
        }
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2482b;
        m.checkNotNullExpressionValue(recyclerView, "binding.manageReactionsEmojisRecycler");
        this.emojisAdapter = (ManageReactionsEmojisAdapter) companion.configure(new ManageReactionsEmojisAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView2, "binding.manageReactionsResultsRecycler");
        this.resultsAdapter = (ManageReactionsResultsAdapter) companion.configure(new ManageReactionsResultsAdapter(recyclerView2));
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        ManageReactionsModelProvider manageReactionsModelProvider = this.modelProvider;
        if (manageReactionsModelProvider == null) {
            m.throwUninitializedPropertyAccessException("modelProvider");
        }
        manageReactionsEmojisAdapter.setOnEmojiSelectedListener(new AnonymousClass2(manageReactionsModelProvider));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ManageReactionsModelProvider manageReactionsModelProvider = this.modelProvider;
        if (manageReactionsModelProvider == null) {
            m.throwUninitializedPropertyAccessException("modelProvider");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(manageReactionsModelProvider.get(), this, null, 2, null), WidgetManageReactions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
