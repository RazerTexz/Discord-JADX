package com.discord.widgets.voice.fullscreen.grid;

import androidx.recyclerview.widget.GridLayoutManager;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;

/* compiled from: VideoCallGridAdapter.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter$spanSizeLookup$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VideoCallGridAdapter2 extends GridLayoutManager.SpanSizeLookup {
    public final /* synthetic */ VideoCallGridAdapter this$0;

    public VideoCallGridAdapter2(VideoCallGridAdapter videoCallGridAdapter) {
        this.this$0 = videoCallGridAdapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int position) {
        if (this.this$0.getItemCount() == 2) {
            return 2;
        }
        return (this.this$0.getItemCount() % 2 == 1 && position == Collections2.getLastIndex(VideoCallGridAdapter.access$getData$p(this.this$0))) ? 2 : 1;
    }
}
