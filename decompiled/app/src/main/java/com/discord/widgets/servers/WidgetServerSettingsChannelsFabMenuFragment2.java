package com.discord.widgets.servers;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsChannelsSortFabMenuBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannelsFabMenuFragment2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsChannelsSortFabMenuBinding> {
    public static final WidgetServerSettingsChannelsFabMenuFragment2 INSTANCE = new WidgetServerSettingsChannelsFabMenuFragment2();

    public WidgetServerSettingsChannelsFabMenuFragment2() {
        super(1, WidgetServerSettingsChannelsSortFabMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsSortFabMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannelsSortFabMenuBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsChannelsSortFabMenuBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.fab_menu_add_category;
        TableRow tableRow = (TableRow) view.findViewById(C5419R.id.fab_menu_add_category);
        if (tableRow != null) {
            i = C5419R.id.fab_menu_add_text;
            TableRow tableRow2 = (TableRow) view.findViewById(C5419R.id.fab_menu_add_text);
            if (tableRow2 != null) {
                i = C5419R.id.fab_menu_add_voice;
                TableRow tableRow3 = (TableRow) view.findViewById(C5419R.id.fab_menu_add_voice);
                if (tableRow3 != null) {
                    i = C5419R.id.fab_menu_main;
                    TableRow tableRow4 = (TableRow) view.findViewById(C5419R.id.fab_menu_main);
                    if (tableRow4 != null) {
                        i = C5419R.id.fab_menu_main_fab;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.fab_menu_main_fab);
                        if (floatingActionButton != null) {
                            TableLayout tableLayout = (TableLayout) view;
                            return new WidgetServerSettingsChannelsSortFabMenuBinding(tableLayout, tableRow, tableRow2, tableRow3, tableRow4, floatingActionButton, tableLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
