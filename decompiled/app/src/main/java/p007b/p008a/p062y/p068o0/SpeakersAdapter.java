package p007b.p008a.p062y.p068o0;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SpeakersAdapter.kt */
/* renamed from: b.a.y.o0.c, reason: use source file name */
/* loaded from: classes2.dex */
public final class SpeakersAdapter extends MGRecyclerAdapterSimple<SpeakersItem> {

    /* renamed from: a */
    public final GridLayoutManager.SpanSizeLookup f2054a;

    /* compiled from: SpeakersAdapter.kt */
    /* renamed from: b.a.y.o0.c$a */
    public static final class a extends GridLayoutManager.SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        this.f2054a = new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return new SpeakersViewHolder(this);
        }
        if (i == 1) {
            return new SpeakersViewHolder2(this);
        }
        throw new IllegalStateException(outline.m871q("Invalid view type: ", i));
    }
}
