package com.discord.widgets.forums;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ForumBrowserLayoutManager.kt */
/* loaded from: classes2.dex */
public final class ForumBrowserLayoutManager extends LinearLayoutManager {
    private Function0<Unit> onLayoutCompletedCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserLayoutManager(RecyclerView recyclerView) {
        super(recyclerView.getContext(), 1, false);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        Function0<Unit> function0 = this.onLayoutCompletedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setOnLayoutCompletedCallback(Function0<Unit> onLayoutCompleted) {
        Intrinsics3.checkNotNullParameter(onLayoutCompleted, "onLayoutCompleted");
        this.onLayoutCompletedCallback = onLayoutCompleted;
    }
}
