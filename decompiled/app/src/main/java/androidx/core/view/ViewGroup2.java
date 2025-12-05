package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* compiled from: ViewGroup.kt */
/* renamed from: androidx.core.view.ViewGroupKt$children$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewGroup2 implements Sequence<View> {
    public final /* synthetic */ ViewGroup $this_children;

    public ViewGroup2(ViewGroup viewGroup) {
        this.$this_children = viewGroup;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<View> iterator() {
        return ViewGroup.iterator(this.$this_children);
    }
}
