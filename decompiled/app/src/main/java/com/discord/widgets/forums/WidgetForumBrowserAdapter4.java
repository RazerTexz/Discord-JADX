package com.discord.widgets.forums;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.dimen.DimenUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserAdapter$itemDecoration$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter4 extends RecyclerView.ItemDecoration {
    public final /* synthetic */ WidgetForumBrowserAdapter this$0;

    public WidgetForumBrowserAdapter4(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        this.this$0 = widgetForumBrowserAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(outRect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        boolean z2 = childAdapterPosition == 0;
        int type = ((ForumBrowserItem) WidgetForumBrowserAdapter.access$getInternalData$p(this.this$0).get(childAdapterPosition)).getType();
        if (type == 0) {
            outRect.top = DimenUtils.dpToPixels(24);
            outRect.bottom = DimenUtils.dpToPixels(8);
            outRect.left = DimenUtils.dpToPixels(16);
        }
        if (type == 1) {
            outRect.bottom = DimenUtils.dpToPixels(12);
            outRect.top = z2 ? DimenUtils.dpToPixels(12) : 0;
        }
    }
}
