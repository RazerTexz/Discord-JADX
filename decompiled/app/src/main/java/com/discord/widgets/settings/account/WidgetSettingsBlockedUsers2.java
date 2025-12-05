package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBlockedUsersBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetSettingsBlockedUsers.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsBlockedUsers2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsBlockedUsersBinding> {
    public static final WidgetSettingsBlockedUsers2 INSTANCE = new WidgetSettingsBlockedUsers2();

    public WidgetSettingsBlockedUsers2() {
        super(1, WidgetSettingsBlockedUsersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsBlockedUsersBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsBlockedUsersBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.blocked_users_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.blocked_users_flipper);
        if (appViewFlipper != null) {
            i = C5419R.id.blocked_users_list_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.blocked_users_list_recycler);
            if (recyclerView != null) {
                i = C5419R.id.friends_list_item_empty_no_blocked;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.friends_list_item_empty_no_blocked);
                if (imageView != null) {
                    return new WidgetSettingsBlockedUsersBinding((CoordinatorLayout) view, appViewFlipper, recyclerView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
