package com.discord.widgets.settings.account;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes2 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public WidgetSettingsAccountBackupCodes2(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("backup code", ((WidgetSettingsAccountBackupCodes.BackupCodeItem) this.$data).getBackupCode().getCode());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        AppToast.g(view.getContext(), R.string.copied_text, 0, null, 12);
    }
}
