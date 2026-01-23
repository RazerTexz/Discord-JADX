package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;

/* JADX INFO: renamed from: b.a.i.c, reason: use source file name */
/* JADX INFO: compiled from: BottomSheetSimpleSelectorBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetSimpleSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f722a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ConstraintLayout f723b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f724c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaxHeightRecyclerView f725d;

    public BottomSheetSimpleSelectorBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull MaxHeightRecyclerView maxHeightRecyclerView) {
        this.f722a = constraintLayout;
        this.f723b = constraintLayout2;
        this.f724c = textView;
        this.f725d = maxHeightRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f722a;
    }
}
