package com.discord.widgets.voice.fullscreen.stage;

import androidx.recyclerview.widget.GridLayoutManager;
import com.discord.models.domain.ModelAuditLogEntry;

/* compiled from: StageCallAdapter.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallAdapter$spanSizeLookup$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallAdapter3 extends GridLayoutManager.SpanSizeLookup {
    public final /* synthetic */ StageCallAdapter this$0;

    public StageCallAdapter3(StageCallAdapter stageCallAdapter) {
        this.this$0 = stageCallAdapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int position) {
        int type = ((StageCallItem) StageCallAdapter.access$getInternalData$p(this.this$0).get(position)).getType();
        if (type == 1) {
            int iAccess$getNumSpeakers$p = StageCallAdapter.access$getNumSpeakers$p(this.this$0);
            if (iAccess$getNumSpeakers$p != 1) {
                return iAccess$getNumSpeakers$p != 2 ? 4 : 6;
            }
        } else if (type == 3) {
            return 3;
        }
        return 12;
    }
}
