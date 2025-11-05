package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import d0.z.d.g0.a;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class MenuKt {

    /* compiled from: Menu.kt */
    /* renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, a {
        public final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ MenuItem next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu menu = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            menu.removeItem(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            MenuItem item = menu.getItem(i);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        m.checkNotNullParameter(menu, "<this>");
        m.checkNotNullParameter(menuItem, "item");
        int size = menu.size();
        if (size > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (m.areEqual(menu.getItem(i), menuItem)) {
                    return true;
                }
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> function1) {
        m.checkNotNullParameter(menu, "<this>");
        m.checkNotNullParameter(function1, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            MenuItem item = menu.getItem(i);
            m.checkNotNullExpressionValue(item, "getItem(index)");
            function1.invoke(item);
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> function2) {
        m.checkNotNullParameter(menu, "<this>");
        m.checkNotNullParameter(function2, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Integer numValueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            m.checkNotNullExpressionValue(item, "getItem(index)");
            function2.invoke(numValueOf, item);
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final MenuItem get(Menu menu, int i) {
        m.checkNotNullParameter(menu, "<this>");
        MenuItem item = menu.getItem(i);
        m.checkNotNullExpressionValue(item, "getItem(index)");
        return item;
    }

    public static final Sequence<MenuItem> getChildren(Menu menu) {
        m.checkNotNullParameter(menu, "<this>");
        return new MenuKt$children$1(menu);
    }

    public static final int getSize(Menu menu) {
        m.checkNotNullParameter(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        m.checkNotNullParameter(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        m.checkNotNullParameter(menu, "<this>");
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        m.checkNotNullParameter(menu, "<this>");
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        m.checkNotNullParameter(menu, "<this>");
        m.checkNotNullParameter(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
