package com.discord.widgets.quickmentions;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetQuickMentionsDialog.kt */
/* renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetQuickMentionsDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetQuickMentionsDialogBinding> {
    public static final WidgetQuickMentionsDialog2 INSTANCE = new WidgetQuickMentionsDialog2();

    public WidgetQuickMentionsDialog2() {
        super(1, WidgetQuickMentionsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetQuickMentionsDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetQuickMentionsDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.tab_contents;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(C5419R.id.tab_contents);
        if (viewPager2 != null) {
            i = C5419R.id.tabs;
            TabLayout tabLayout = (TabLayout) view.findViewById(C5419R.id.tabs);
            if (tabLayout != null) {
                return new WidgetQuickMentionsDialogBinding((ConstraintLayout) view, viewPager2, tabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
