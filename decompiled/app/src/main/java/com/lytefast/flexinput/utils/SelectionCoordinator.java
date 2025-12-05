package com.lytefast.flexinput.utils;

import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Objects;
import p007b.p076b.p077a.p082g.SelectionCoordinator2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.TypeIntrinsics;

/* compiled from: SelectionCoordinator.kt */
/* loaded from: classes3.dex */
public class SelectionCoordinator<I, T extends I> {

    /* renamed from: a, reason: from kotlin metadata */
    public RecyclerView.Adapter<?> adapter;

    /* renamed from: b, reason: from kotlin metadata */
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
    /* renamed from: com.lytefast.flexinput.utils.SelectionCoordinator$a */
    public static final class C11192a<T> {

        /* renamed from: a */
        public final T f22089a;

        /* renamed from: b */
        public final boolean f22090b;

        public C11192a(T t, boolean z2) {
            this.f22089a = t;
            this.f22090b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C11192a)) {
                return false;
            }
            C11192a c11192a = (C11192a) obj;
            return Intrinsics3.areEqual(this.f22089a, c11192a.f22089a) && this.f22090b == c11192a.f22090b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            T t = this.f22089a;
            int iHashCode = (t != null ? t.hashCode() : 0) * 31;
            boolean z2 = this.f22090b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("SelectionEvent(item=");
            sbM833U.append(this.f22089a);
            sbM833U.append(", isSelected=");
            return outline.m827O(sbM833U, this.f22090b, ")");
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

    /* renamed from: a */
    public final boolean m9298a(T item, int position) {
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

    /* renamed from: b */
    public final void m9299b(ArrayList<? extends I> selectedItems) throws RestorationException {
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        if (this.adapter != null) {
            throw new RestorationException("cannot restoreSelections after adapter set: prevents mismatches");
        }
        for (I i : selectedItems) {
            if (!(i instanceof Object)) {
                i = null;
            }
            if (i != null) {
                this.selectedItemPositionMap.put(i, -1);
            }
        }
    }

    /* renamed from: c */
    public final void m9300c(T item, int position) {
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(position, new C11192a(item, true));
        }
        this.itemSelectionListener.onItemSelected(item);
    }

    /* renamed from: d */
    public final boolean m9301d(I item) {
        ArrayMap<T, Integer> arrayMap = this.selectedItemPositionMap;
        Objects.requireNonNull(arrayMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        Integer num = (Integer) TypeIntrinsics.asMutableMap(arrayMap).remove(item);
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(iIntValue, new C11192a(item, false));
        }
        this.itemSelectionListener.onItemUnselected(item);
        return true;
    }
}
