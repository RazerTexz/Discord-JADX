package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsEmojisEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsEmojisEdit.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmojisEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsEmojisEditBinding> {
    public static final WidgetServerSettingsEmojisEdit2 INSTANCE = new WidgetServerSettingsEmojisEdit2();

    public WidgetServerSettingsEmojisEdit2() {
        super(1, WidgetServerSettingsEmojisEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojisEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmojisEditBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.server_settings_emojis_edit_alias;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.server_settings_emojis_edit_alias);
        if (textInputLayout != null) {
            i = C5419R.id.server_settings_emojis_edit_alias_save;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.server_settings_emojis_edit_alias_save);
            if (floatingActionButton != null) {
                return new WidgetServerSettingsEmojisEditBinding((CoordinatorLayout) view, textInputLayout, floatingActionButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
