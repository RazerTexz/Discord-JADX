package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;

/* compiled from: DialogSimpleSelectorBinding.java */
/* renamed from: b.a.i.l, reason: use source file name */
/* loaded from: classes.dex */
public final class DialogSimpleSelectorBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1008a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1009b;

    /* renamed from: c */
    @NonNull
    public final MaxHeightRecyclerView f1010c;

    /* renamed from: d */
    @NonNull
    public final TextView f1011d;

    public DialogSimpleSelectorBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaxHeightRecyclerView maxHeightRecyclerView, @NonNull TextView textView) {
        this.f1008a = linearLayout;
        this.f1009b = materialButton;
        this.f1010c = maxHeightRecyclerView;
        this.f1011d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1008a;
    }
}
