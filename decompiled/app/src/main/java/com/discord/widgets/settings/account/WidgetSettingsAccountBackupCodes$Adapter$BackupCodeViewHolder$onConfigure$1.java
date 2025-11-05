package com.discord.widgets.settings.account;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import com.discord.R;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import d0.z.d.m;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder$onConfigure$1(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m.checkNotNullExpressionValue(view, "it");
        ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("backup code", ((WidgetSettingsAccountBackupCodes.BackupCodeItem) this.$data).getBackupCode().getCode());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        b.a.d.m.g(view.getContext(), R.string.copied_text, 0, null, 12);
    }
}
