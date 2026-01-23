package com.discord.widgets.user;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ViewUserStatusPresenceBinding;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserStatusSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetUserStatusUpdateBinding> {
    public static final WidgetUserStatusSheet2 INSTANCE = new WidgetUserStatusSheet2();

    public WidgetUserStatusSheet2() {
        super(1, WidgetUserStatusUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserStatusUpdateBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserStatusUpdateBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = C5419R.id.user_status_update_custom;
            UserStatusPresenceCustomView userStatusPresenceCustomView = (UserStatusPresenceCustomView) view.findViewById(C5419R.id.user_status_update_custom);
            if (userStatusPresenceCustomView != null) {
                i = C5419R.id.user_status_update_dnd;
                View viewFindViewById = view.findViewById(C5419R.id.user_status_update_dnd);
                if (viewFindViewById != null) {
                    ViewUserStatusPresenceBinding viewUserStatusPresenceBindingM198a = ViewUserStatusPresenceBinding.m198a(viewFindViewById);
                    i = C5419R.id.user_status_update_idle;
                    View viewFindViewById2 = view.findViewById(C5419R.id.user_status_update_idle);
                    if (viewFindViewById2 != null) {
                        ViewUserStatusPresenceBinding viewUserStatusPresenceBindingM198a2 = ViewUserStatusPresenceBinding.m198a(viewFindViewById2);
                        i = C5419R.id.user_status_update_invisible;
                        View viewFindViewById3 = view.findViewById(C5419R.id.user_status_update_invisible);
                        if (viewFindViewById3 != null) {
                            ViewUserStatusPresenceBinding viewUserStatusPresenceBindingM198a3 = ViewUserStatusPresenceBinding.m198a(viewFindViewById3);
                            i = C5419R.id.user_status_update_online;
                            View viewFindViewById4 = view.findViewById(C5419R.id.user_status_update_online);
                            if (viewFindViewById4 != null) {
                                return new WidgetUserStatusUpdateBinding((NestedScrollView) view, textView, userStatusPresenceCustomView, viewUserStatusPresenceBindingM198a, viewUserStatusPresenceBindingM198a2, viewUserStatusPresenceBindingM198a3, ViewUserStatusPresenceBinding.m198a(viewFindViewById4));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
