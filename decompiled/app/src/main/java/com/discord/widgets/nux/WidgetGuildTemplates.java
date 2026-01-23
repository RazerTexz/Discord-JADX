package com.discord.widgets.nux;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.GuildTemplatesAdapter2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildTemplates extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildTemplates.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GuildTemplatesAdapter adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetGuildTemplates.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, CreateGuildTrigger trigger, boolean isNux) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(trigger, "trigger");
            String str = isNux ? GuildTemplateAnalytics.STEP_GUILD_TEMPLATE : GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE;
            String string = context.getString(C5419R.string.guild_template_selector_title);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…_template_selector_title)");
            String string2 = context.getString(C5419R.string.guild_template_selector_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ate_selector_description)");
            launch(context, new WidgetGuildTemplates2(isNux, str, trigger, new WidgetGuildTemplates3(string, string2, null, false, false, 28, null), false, 16, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(Context context, WidgetGuildTemplates2 args) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(args, "args");
            AppScreen2.m156d(context, WidgetGuildTemplates.class, args);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetGuildTemplates$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildTemplates.kt */
    public static final class C91041<R> implements Func0<Boolean> {
        public C91041() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetGuildTemplates.access$trackPostRegistrationSkip(WidgetGuildTemplates.this);
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetGuildTemplates$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetGuildTemplates.kt */
    public static final class ViewOnClickListenerC91053 implements View.OnClickListener {
        public ViewOnClickListenerC91053() {
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
        super(C5419R.layout.widget_nux_guild_template);
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
        AppFragment.setOnBackPressed$default(this, new C91041(), 0, 2, null);
        RecyclerView recyclerView = getBinding().f17328f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        TextView textView = getBinding().f17327e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.nuxGuildTemplateSectionTitle");
        textView.setText(getArgs().getGuildTemplate().getTitle());
        TextView textView2 = getBinding().f17326d;
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
        getBinding().f17324b.setOnClickListener(new ViewOnClickListenerC91053());
        LinearLayout linearLayout = getBinding().f17325c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.nuxGuildTemplateSectionBottom");
        linearLayout.setVisibility(getArgs().getGuildTemplate().getShowInvitePrompt() ? 0 : 8);
    }
}
