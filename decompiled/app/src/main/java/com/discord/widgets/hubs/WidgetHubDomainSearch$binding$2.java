package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetHubDomainSearchBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubDomainSearch.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDomainSearch$binding$2 extends k implements Function1<View, WidgetHubDomainSearchBinding> {
    public static final WidgetHubDomainSearch$binding$2 INSTANCE = new WidgetHubDomainSearch$binding$2();

    public WidgetHubDomainSearch$binding$2() {
        super(1, WidgetHubDomainSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDomainSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubDomainSearchBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDomainSearchBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
        if (appBarLayout != null) {
            i = R.id.barrier;
            Barrier barrier = (Barrier) view.findViewById(R.id.barrier);
            if (barrier != null) {
                i = R.id.empty_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.empty_description);
                if (linkifiedTextView != null) {
                    i = R.id.empty_state;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.empty_state);
                    if (linearLayout != null) {
                        i = R.id.empty_title;
                        TextView textView = (TextView) view.findViewById(R.id.empty_title);
                        if (textView != null) {
                            i = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                            if (recyclerView != null) {
                                i = R.id.search;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.search);
                                if (floatingActionButton != null) {
                                    i = R.id.search_bar;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.search_bar);
                                    if (textInputLayout != null) {
                                        i = R.id.search_bar_text;
                                        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.search_bar_text);
                                        if (textInputEditText != null) {
                                            return new WidgetHubDomainSearchBinding((ConstraintLayout) view, appBarLayout, barrier, linkifiedTextView, linearLayout, textView, recyclerView, floatingActionButton, textInputLayout, textInputEditText);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
