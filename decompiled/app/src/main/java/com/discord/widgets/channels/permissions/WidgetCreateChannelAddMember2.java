package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetCreateChannelAddMemberBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetCreateChannelAddMember.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateChannelAddMember2 extends FunctionReferenceImpl implements Function1<View, WidgetCreateChannelAddMemberBinding> {
    public static final WidgetCreateChannelAddMember2 INSTANCE = new WidgetCreateChannelAddMember2();

    public WidgetCreateChannelAddMember2() {
        super(1, WidgetCreateChannelAddMemberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCreateChannelAddMemberBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCreateChannelAddMemberBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(C5419R.id.content);
        if (fragmentContainerView != null) {
            return new WidgetCreateChannelAddMemberBinding((LinearLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.content)));
    }
}
