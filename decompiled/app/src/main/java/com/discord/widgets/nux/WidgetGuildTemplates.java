package com.discord.widgets.nux;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.GuildTemplatesAdapter2;
import d0.LazyJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Func0;

/* compiled from: WidgetGuildTemplates.kt */
/* loaded from: classes2.dex */
public class WidgetGuildTemplates extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildTemplates.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GuildTemplatesAdapter adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetGuildTemplates.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, CreateGuildTrigger trigger, boolean isNux) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(trigger, "trigger");
            String str = isNux ? GuildTemplateAnalytics.STEP_GUILD_TEMPLATE : GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE;
            String string = context.getString(R.string.guild_template_selector_title);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…_template_selector_title)");
            String string2 = context.getString(R.string.guild_template_selector_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ate_selector_description)");
            launch(context, new WidgetGuildTemplates2(isNux, str, trigger, new WidgetGuildTemplates3(string, string2, null, false, false, 28, null), false, 16, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(Context context, WidgetGuildTemplates2 args) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(args, "args");
            AppScreen2.d(context, WidgetGuildTemplates.class, args);
        }
    }

    /* compiled from: WidgetGuildTemplates.kt */
    /* renamed from: com.discord.widgets.nux.WidgetGuildTemplates$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetGuildTemplates.access$trackPostRegistrationSkip(WidgetGuildTemplates.this);
            return Boolean.FALSE;
        }
    }

    /* compiled from: WidgetGuildTemplates.kt */
    /* renamed from: com.discord.widgets.nux.WidgetGuildTemplates$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildTemplates.access$trackPostRegistrationTransition(WidgetGuildTemplates.this, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_GUILD_JOIN);
            WidgetNuxPostRegistrationJoin.INSTANCE.show(WidgetGuildTemplates.this.requireContext());
            FragmentActivity activity = WidgetGuildTemplates.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WidgetGuildTemplates() {
        super(R.layout.widget_nux_guild_template);
        this.args = LazyJVM.lazy(new WidgetGuildTemplates$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildTemplates5.INSTANCE, null, 2, null);
        this.adapter = new GuildTemplatesAdapter(new WidgetGuildTemplates4(this));
    }

    public static final /* synthetic */ WidgetGuildTemplates2 access$getArgs$p(WidgetGuildTemplates widgetGuildTemplates) {
        return widgetGuildTemplates.getArgs();
    }

    public static final /* synthetic */ void access$trackPostRegistrationSkip(WidgetGuildTemplates widgetGuildTemplates) {
        widgetGuildTemplates.trackPostRegistrationSkip();
    }

    public static final /* synthetic */ void access$trackPostRegistrationTransition(WidgetGuildTemplates widgetGuildTemplates, String str, String str2) {
        widgetGuildTemplates.trackPostRegistrationTransition(str, str2);
    }

    private final WidgetGuildTemplates2 getArgs() {
        return (WidgetGuildTemplates2) this.args.getValue();
    }

    private final WidgetNuxGuildTemplateBinding getBinding() {
        return (WidgetNuxGuildTemplateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void trackPostRegistrationSkip() {
        if (getArgs().isNux()) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationSkip$app_productionGoogleRelease(GuildTemplateAnalytics.STEP_GUILD_TEMPLATE);
        }
    }

    private final void trackPostRegistrationTransition(String fromStep, String toStep) {
        if (getArgs().isNux()) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationTransition$app_productionGoogleRelease(fromStep, toStep);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        trackPostRegistrationTransition(GuildTemplateAnalytics.STEP_REGISTRATION, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(), 0, 2, null);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.nuxGuildTemplateSectionTitle");
        textView.setText(getArgs().getGuildTemplate().getTitle());
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nuxGuildTemplateSectionCustomLabel");
        textView2.setText(getArgs().getGuildTemplate().getSubtitle());
        GuildTemplatesAdapter guildTemplatesAdapter = this.adapter;
        List<GuildTemplates> templates = getArgs().getGuildTemplate().getTemplates();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(templates, 10));
        Iterator<T> it = templates.iterator();
        while (it.hasNext()) {
            arrayList.add(new GuildTemplatesAdapter2.Template((GuildTemplates) it.next()));
        }
        guildTemplatesAdapter.setItems(arrayList);
        getBinding().f2505b.setOnClickListener(new AnonymousClass3());
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.nuxGuildTemplateSectionBottom");
        linearLayout.setVisibility(getArgs().getGuildTemplate().getShowInvitePrompt() ? 0 : 8);
    }
}
