package com.lytefast.flexinput.utils;

import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.g.SelectionCoordinator2;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: SelectionCoordinator.kt */
/* loaded from: classes3.dex */
public class SelectionCoordinator<I, T extends I> {

    /* renamed from: a, reason: from kotlin metadata */
    public RecyclerView.Adapter<?> adapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<T, Integer> selectedItemPositionMap;

    /* renamed from: c, reason: from kotlin metadata */
    public ItemSelectionListener<? super I> itemSelectionListener;

    /* compiled from: SelectionCoordinator.kt */
    public interface ItemSelectionListener<I> {
        void onItemSelected(I item);

        void onItemUnselected(I item);

        void unregister();
    }

    /* compiled from: SelectionCoordinator.kt */
    public static final class RestorationException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RestorationException(String str) {
            super(str);
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        }
    }

    /* compiled from: SelectionCoordinator.kt */
    public static final class a<T> {
        public final T a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3171b;

        public a(T t, boolean z2) {
            this.a = t;
            this.f3171b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && this.f3171b == aVar.f3171b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            T t = this.a;
            int iHashCode = (t != null ? t.hashCode() : 0) * 31;
            boolean z2 = this.f3171b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SelectionEvent(item=");
            sbU.append(this.a);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.f3171b, ")");
        }
    }

    public SelectionCoordinator() {
        this(null, null, 3);
    }

    public SelectionCoordinator(ArrayMap arrayMap, ItemSelectionListener itemSelectionListener, int i) {
        ArrayMap<T, Integer> arrayMap2 = (i & 1) != 0 ? new ArrayMap<>(4) : null;
        SelectionCoordinator2 selectionCoordinator2 = (i & 2) != 0 ? new SelectionCoordinator2() : null;
        Intrinsics3.checkNotNullParameter(arrayMap2, "selectedItemPositionMap");
        Intrinsics3.checkNotNullParameter(selectionCoordinator2, "itemSelectionListener");
        this.selectedItemPositionMap = arrayMap2;
        this.itemSelectionListener = selectionCoordinator2;
    }

    public final boolean a(T item, int position) {
        Integer num = this.selectedItemPositionMap.get(item);
        if (num == null) {
            return false;
        }
        if (position == num.intValue()) {
            return true;
        }
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        return true;
    }

    public final void b(ArrayList<? extends I> selectedItems) throws RestorationException {
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        if (this.adapter != null) {
            throw new RestorationException("cannot restoreSelections after adapter set: prevents mismatches");
        }
        Iterator<? extends I> it = selectedItems.iterator();
        while (it.hasNext()) {
            I next = it.next();
            if (!(next instanceof Object)) {
                next = null;
            }
            if (next != null) {
                this.selectedItemPositionMap.put(next, -1);
            }
        }
    }

    public final void c(T item, int position) {
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(position, new a(item, true));
        }
        this.itemSelectionListener.onItemSelected(item);
    }

    public final boolean d(I item) {
        ArrayMap<T, Integer> arrayMap = this.selectedItemPositionMap;
        Objects.requireNonNull(arrayMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        Integer num = (Integer) TypeIntrinsics.asMutableMap(arrayMap).remove(item);
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(iIntValue, new a(item, false));
        }
        this.itemSelectionListener.onItemUnselected(item);
        return true;
    }
}
