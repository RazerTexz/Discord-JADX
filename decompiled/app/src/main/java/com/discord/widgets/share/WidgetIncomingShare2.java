package com.discord.widgets.share;

import android.net.Uri;
import android.view.View;
import com.discord.widgets.share.WidgetIncomingShare;

/* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$Adapter$ViewHolder$bind$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare2 implements View.OnClickListener {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ WidgetIncomingShare.Adapter.ViewHolder this$0;

    public WidgetIncomingShare2(WidgetIncomingShare.Adapter.ViewHolder viewHolder, Uri uri) {
        this.this$0 = viewHolder;
        this.$uri = uri;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetIncomingShare.Adapter.access$getOnItemClickListener$p(this.this$0.this$0).invoke(this.$uri);
    }
}
