package com.discord.utilities.recycler;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SelfHealingLinearLayoutManager.kt */
/* loaded from: classes2.dex */
public final class SelfHealingLinearLayoutManager extends LinearLayoutManager {
    private final RecyclerView.Adapter<?> adapter;
    private final RecyclerView recyclerView;

    /* compiled from: SelfHealingLinearLayoutManager.kt */
    /* renamed from: com.discord.utilities.recycler.SelfHealingLinearLayoutManager$resetAdapter$1 */
    public static final class RunnableC68501 implements Runnable {
        public RunnableC68501() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SelfHealingLinearLayoutManager.access$getAdapter$p(SelfHealingLinearLayoutManager.this).notifyDataSetChanged();
            SelfHealingLinearLayoutManager.access$getRecyclerView$p(SelfHealingLinearLayoutManager.this).invalidate();
        }
    }

    public /* synthetic */ SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView.Adapter adapter, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, adapter, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? false : z2);
    }

    public static final /* synthetic */ RecyclerView.Adapter access$getAdapter$p(SelfHealingLinearLayoutManager selfHealingLinearLayoutManager) {
        return selfHealingLinearLayoutManager.adapter;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(SelfHealingLinearLayoutManager selfHealingLinearLayoutManager) {
        return selfHealingLinearLayoutManager.recyclerView;
    }

    private final void logWarning(Throwable exception) {
        StringBuilder sbM833U = outline.m833U("Triggered in adapter: ");
        sbM833U.append(this.adapter.getClass());
        AppLog.f14950g.mo8370w("Invalid adapter configuration.", new Exception(sbM833U.toString(), exception));
    }

    private final void resetAdapter(Throwable exception) {
        this.recyclerView.post(new RunnableC68501());
        logWarning(exception);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        String message;
        Intrinsics3.checkNotNullParameter(recycler, "recycler");
        Intrinsics3.checkNotNullParameter(state, "state");
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IllegalArgumentException e) {
            resetAdapter(e);
        } catch (IndexOutOfBoundsException e2) {
            resetAdapter(e2);
        } catch (RuntimeException e3) {
            String message2 = e3.getMessage();
            if ((message2 == null || !Strings4.contains$default((CharSequence) message2, (CharSequence) "trying to unhide", false, 2, (Object) null)) && ((message = e3.getMessage()) == null || !Strings4.contains$default((CharSequence) message, (CharSequence) "trying to hide", false, 2, (Object) null))) {
                throw e3;
            }
            resetAdapter(e3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter, int i, boolean z2) {
        super(recyclerView.getContext(), i, z2);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = adapter;
    }
}
