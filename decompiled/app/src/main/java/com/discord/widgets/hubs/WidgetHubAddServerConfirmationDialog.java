package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.HubAddServerConfirmationDialogBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.FormatUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubAddServerConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetHubAddServerConfirmationDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetHubAddServerConfirmationDialog show(FragmentManager fragmentManager, WidgetHubAddServerConfirmationDialog2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetHubAddServerConfirmationDialog widgetHubAddServerConfirmationDialog = new WidgetHubAddServerConfirmationDialog();
            widgetHubAddServerConfirmationDialog.setArguments(AnimatableValueParser.m514e2(args));
            widgetHubAddServerConfirmationDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(WidgetHubAddServerConfirmationDialog.class).toString());
            return widgetHubAddServerConfirmationDialog;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHubAddServerConfirmationDialog.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog$onViewBoundOrOnResume$1 */
    public static final class ViewOnClickListenerC89981 implements View.OnClickListener {
        public ViewOnClickListenerC89981() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubAddServerConfirmationDialog.this.dismiss();
        }
    }

    public WidgetHubAddServerConfirmationDialog() {
        super(C5419R.layout.hub_add_server_confirmation_dialog);
        this.args = LazyJVM.lazy(new WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAddServerConfirmationDialog3.INSTANCE, null, 2, null);
    }

    private final WidgetHubAddServerConfirmationDialog2 getArgs() {
        return (WidgetHubAddServerConfirmationDialog2) this.args.getValue();
    }

    private final HubAddServerConfirmationDialogBinding getBinding() {
        return (HubAddServerConfirmationDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f15164d.setOnClickListener(new ViewOnClickListenerC89981());
        TextView textView = getBinding().f15162b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.addServerConfirmationDialogDescription");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.m209a(textView, FormatUtils.m216h(contextRequireContext, C5419R.string.hub_add_server_confirmation_subtitle, new Object[]{getArgs().getHubName()}, null, 4));
        getBinding().f15163c.m8546b();
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(getArgs().getGuildId());
        if (guild != null) {
            getBinding().f15163c.m8545a(IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, false, null, 28, null), guild.getShortName());
        }
    }
}
