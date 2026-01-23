package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountBackupCodes3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountBackupCodesBinding> {
    public static final WidgetSettingsAccountBackupCodes3 INSTANCE = new WidgetSettingsAccountBackupCodes3();

    public WidgetSettingsAccountBackupCodes3() {
        super(1, WidgetSettingsAccountBackupCodesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountBackupCodesBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountBackupCodesBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.settings_backup_codes_generate;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.settings_backup_codes_generate);
            if (materialButton != null) {
                i = C5419R.id.settings_backup_codes_info;
                TextView textView = (TextView) view.findViewById(C5419R.id.settings_backup_codes_info);
                if (textView != null) {
                    i = C5419R.id.settings_backup_codes_rv;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.settings_backup_codes_rv);
                    if (recyclerView != null) {
                        return new WidgetSettingsAccountBackupCodesBinding((CoordinatorLayout) view, dimmerView, materialButton, textView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
