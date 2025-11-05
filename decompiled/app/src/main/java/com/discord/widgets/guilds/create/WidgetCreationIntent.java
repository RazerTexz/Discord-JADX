package com.discord.widgets.guilds.create;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetCreationIntentBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import com.google.android.material.card.MaterialCardView;
import d0.g;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetCreationIntent.kt */
/* loaded from: classes2.dex */
public final class WidgetCreationIntent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCreationIntent.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreationIntentBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean IS_FRIENDS_FIRST;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* compiled from: WidgetCreationIntent.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(AppFragment fragment, CreateGuildTrigger trigger, WidgetGuildCreate.Options createGuildOptions) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(trigger, "trigger");
            m.checkNotNullParameter(createGuildOptions, "createGuildOptions");
            j.g(j.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetCreationIntent.class, 0, true, null, new CreationIntentArgs(trigger, createGuildOptions), 40);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCreationIntent.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$configureCommunityButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCreationIntent.access$onSelectionPressed(WidgetCreationIntent.this, Boolean.TRUE);
        }
    }

    /* compiled from: WidgetCreationIntent.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$configureFriendsButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCreationIntent.access$onSelectionPressed(WidgetCreationIntent.this, Boolean.FALSE);
        }
    }

    /* compiled from: WidgetCreationIntent.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetCreationIntent.kt */
        /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04121 extends o implements Function1<View, Unit> {
            public C04121() {
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
                WidgetCreationIntent.access$onSelectionPressed(WidgetCreationIntent.this, null);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onSkip", new C04121());
        }
    }

    static {
        IS_FRIENDS_FIRST = Math.random() < 0.5d;
    }

    public WidgetCreationIntent() {
        this(0, 1, null);
    }

    public WidgetCreationIntent(@LayoutRes int i) {
        super(i);
        this.args = g.lazy(new WidgetCreationIntent$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCreationIntent$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetCreationIntent$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$onSelectionPressed(WidgetCreationIntent widgetCreationIntent, Boolean bool) {
        widgetCreationIntent.onSelectionPressed(bool);
    }

    private final void configureCommunityButton(View container, TextView textView) {
        textView.setText(getString(R.string.creation_intent_option_community));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.drawable_guild_template_creator), (Drawable) null, ContextCompat.getDrawable(requireContext(), R.drawable.icon_carrot), (Drawable) null);
        container.setOnClickListener(new AnonymousClass1());
    }

    private final void configureFriendsButton(View container, TextView textView) {
        textView.setText(getString(R.string.creation_intent_option_friends));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.drawable_guild_template_community), (Drawable) null, ContextCompat.getDrawable(requireContext(), R.drawable.icon_carrot), (Drawable) null);
        container.setOnClickListener(new AnonymousClass1());
    }

    private final WidgetCreationIntentBinding getBinding() {
        return (WidgetCreationIntentBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onSelectionPressed(Boolean isCommunity) {
        AnalyticsTracker.INSTANCE.guildCreationIntentSelected(isCommunity);
        if (getArgs().getTrigger() == CreateGuildTrigger.NUF) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationTransition$app_productionGoogleRelease(GuildTemplateAnalytics.STEP_CREATION_INTENT, "Guild Create");
        } else {
            AnalyticsTracker.openModal$default("Create Guild Step 2", getArgs().getCreateGuildOptions().getAnalyticsLocation(), null, 4, null);
        }
        WidgetGuildCreate.INSTANCE.showFragment(this, getArgs().getCreateGuildOptions());
    }

    public final CreationIntentArgs getArgs() {
        return (CreationIntentArgs) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (IS_FRIENDS_FIRST) {
            MaterialCardView materialCardView = getBinding().f2360b;
            m.checkNotNullExpressionValue(materialCardView, "binding.creationIntentFirstOption");
            TextView textView = getBinding().c;
            m.checkNotNullExpressionValue(textView, "binding.creationIntentFirstOptionText");
            configureFriendsButton(materialCardView, textView);
            MaterialCardView materialCardView2 = getBinding().d;
            m.checkNotNullExpressionValue(materialCardView2, "binding.creationIntentSecondOption");
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.creationIntentSecondOptionText");
            configureCommunityButton(materialCardView2, textView2);
        } else {
            MaterialCardView materialCardView3 = getBinding().f2360b;
            m.checkNotNullExpressionValue(materialCardView3, "binding.creationIntentFirstOption");
            TextView textView3 = getBinding().c;
            m.checkNotNullExpressionValue(textView3, "binding.creationIntentFirstOptionText");
            configureCommunityButton(materialCardView3, textView3);
            MaterialCardView materialCardView4 = getBinding().d;
            m.checkNotNullExpressionValue(materialCardView4, "binding.creationIntentSecondOption");
            TextView textView4 = getBinding().e;
            m.checkNotNullExpressionValue(textView4, "binding.creationIntentSecondOptionText");
            configureFriendsButton(materialCardView4, textView4);
        }
        LinkifiedTextView linkifiedTextView = getBinding().f;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.creationIntentSkipText");
        b.m(linkifiedTextView, R.string.creation_intent_skip, new Object[0], new AnonymousClass1());
    }

    public /* synthetic */ WidgetCreationIntent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_creation_intent : i);
    }
}
