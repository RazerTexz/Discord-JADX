package com.discord.widgets.settings;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAuthorizedAppsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetSettingsAuthorizedApps.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAuthorizedApps4 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAuthorizedAppsBinding> {
    public static final WidgetSettingsAuthorizedApps4 INSTANCE = new WidgetSettingsAuthorizedApps4();

    public WidgetSettingsAuthorizedApps4() {
        super(1, WidgetSettingsAuthorizedAppsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAuthorizedAppsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAuthorizedAppsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.authorized_apps_list);
        if (recyclerView != null) {
            return new WidgetSettingsAuthorizedAppsBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.authorized_apps_list)));
    }
}
