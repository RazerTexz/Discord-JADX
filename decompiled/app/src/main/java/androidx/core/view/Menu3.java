package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: androidx.core.view.MenuKt$children$1, reason: use source file name */
/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Menu3 implements Sequence<MenuItem> {
    public final /* synthetic */ Menu $this_children;

    public Menu3(Menu menu) {
        this.$this_children = menu;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<MenuItem> iterator() {
        return Menu2.iterator(this.$this_children);
    }
}
