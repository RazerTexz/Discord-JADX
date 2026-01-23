package com.discord.widgets.servers.settings.invites;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsInstantInvitesBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsInstantInvites5 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsInstantInvitesBinding> {
    public static final WidgetServerSettingsInstantInvites5 INSTANCE = new WidgetServerSettingsInstantInvites5();

    public WidgetServerSettingsInstantInvites5() {
        super(1, WidgetServerSettingsInstantInvitesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsInstantInvitesBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsInstantInvitesBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.no_invites_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.no_invites_body);
        if (textView != null) {
            i = C5419R.id.no_invites_header;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.no_invites_header);
            if (textView2 != null) {
                i = C5419R.id.server_settings_instant_invites_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.server_settings_instant_invites_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.server_settings_instant_invites_view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.server_settings_instant_invites_view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsInstantInvitesBinding((CoordinatorLayout) view, textView, textView2, recyclerView, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
