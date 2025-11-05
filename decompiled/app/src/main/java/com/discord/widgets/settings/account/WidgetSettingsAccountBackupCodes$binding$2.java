package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountBackupCodes$binding$2 extends k implements Function1<View, WidgetSettingsAccountBackupCodesBinding> {
    public static final WidgetSettingsAccountBackupCodes$binding$2 INSTANCE = new WidgetSettingsAccountBackupCodes$binding$2();

    public WidgetSettingsAccountBackupCodes$binding$2() {
        super(1, WidgetSettingsAccountBackupCodesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountBackupCodesBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountBackupCodesBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.settings_backup_codes_generate;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_backup_codes_generate);
            if (materialButton != null) {
                i = R.id.settings_backup_codes_info;
                TextView textView = (TextView) view.findViewById(R.id.settings_backup_codes_info);
                if (textView != null) {
                    i = R.id.settings_backup_codes_rv;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.settings_backup_codes_rv);
                    if (recyclerView != null) {
                        return new WidgetSettingsAccountBackupCodesBinding((CoordinatorLayout) view, dimmerView, materialButton, textView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
