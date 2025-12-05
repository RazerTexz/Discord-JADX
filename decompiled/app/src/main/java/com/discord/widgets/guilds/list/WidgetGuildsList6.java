package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildsListBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildsList.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildsList6 extends FunctionReferenceImpl implements Function1<View, WidgetGuildsListBinding> {
    public static final WidgetGuildsList6 INSTANCE = new WidgetGuildsList6();

    public WidgetGuildsList6() {
        super(1, WidgetGuildsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildsListBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildsListBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.guild_list);
        if (recyclerView != null) {
            i = C5419R.id.guild_list_unreads_stub;
            ViewStub viewStub = (ViewStub) view.findViewById(C5419R.id.guild_list_unreads_stub);
            if (viewStub != null) {
                return new WidgetGuildsListBinding((RelativeLayout) view, recyclerView, viewStub);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
