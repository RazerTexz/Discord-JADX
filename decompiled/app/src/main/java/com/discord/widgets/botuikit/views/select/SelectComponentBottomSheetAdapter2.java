package com.discord.widgets.botuikit.views.select;

import b.d.b.a.outline;
import com.discord.api.botuikit.SelectComponent2;
import d0.z.d.Intrinsics3;

/* compiled from: SelectComponentBottomSheetAdapter.kt */
/* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheetItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class SelectComponentBottomSheetAdapter2 {
    private final SelectComponent2 selectItem;
    private final boolean selected;

    public SelectComponentBottomSheetAdapter2(SelectComponent2 selectComponent2, boolean z2) {
        Intrinsics3.checkNotNullParameter(selectComponent2, "selectItem");
        this.selectItem = selectComponent2;
        this.selected = z2;
    }

    public static /* synthetic */ SelectComponentBottomSheetAdapter2 copy$default(SelectComponentBottomSheetAdapter2 selectComponentBottomSheetAdapter2, SelectComponent2 selectComponent2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            selectComponent2 = selectComponentBottomSheetAdapter2.selectItem;
        }
        if ((i & 2) != 0) {
            z2 = selectComponentBottomSheetAdapter2.selected;
        }
        return selectComponentBottomSheetAdapter2.copy(selectComponent2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final SelectComponent2 getSelectItem() {
        return this.selectItem;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final SelectComponentBottomSheetAdapter2 copy(SelectComponent2 selectItem, boolean selected) {
        Intrinsics3.checkNotNullParameter(selectItem, "selectItem");
        return new SelectComponentBottomSheetAdapter2(selectItem, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponentBottomSheetAdapter2)) {
            return false;
        }
        SelectComponentBottomSheetAdapter2 selectComponentBottomSheetAdapter2 = (SelectComponentBottomSheetAdapter2) other;
        return Intrinsics3.areEqual(this.selectItem, selectComponentBottomSheetAdapter2.selectItem) && this.selected == selectComponentBottomSheetAdapter2.selected;
    }

    public final SelectComponent2 getSelectItem() {
        return this.selectItem;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        SelectComponent2 selectComponent2 = this.selectItem;
        int iHashCode = (selectComponent2 != null ? selectComponent2.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectComponentBottomSheetItem(selectItem=");
        sbU.append(this.selectItem);
        sbU.append(", selected=");
        return outline.O(sbU, this.selected, ")");
    }
}
