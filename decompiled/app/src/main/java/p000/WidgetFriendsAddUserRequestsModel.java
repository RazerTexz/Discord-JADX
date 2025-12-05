package p000;

import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class WidgetFriendsAddUserRequestsModel {

    /* renamed from: a, reason: from kotlin metadata */
    public final Set<Long> outgoingIds;

    /* renamed from: b, reason: from kotlin metadata */
    public final Set<Long> incomingIds;

    public WidgetFriendsAddUserRequestsModel(Set<Long> set, Set<Long> set2) {
        Intrinsics3.checkNotNullParameter(set, "outgoingIds");
        Intrinsics3.checkNotNullParameter(set2, "incomingIds");
        this.outgoingIds = set;
        this.incomingIds = set2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetFriendsAddUserRequestsModel)) {
            return false;
        }
        WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel = (WidgetFriendsAddUserRequestsModel) other;
        return Intrinsics3.areEqual(this.outgoingIds, widgetFriendsAddUserRequestsModel.outgoingIds) && Intrinsics3.areEqual(this.incomingIds, widgetFriendsAddUserRequestsModel.incomingIds);
    }

    public int hashCode() {
        Set<Long> set = this.outgoingIds;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Set<Long> set2 = this.incomingIds;
        return iHashCode + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("WidgetFriendsAddUserRequestsModel(outgoingIds=");
        sbM833U.append(this.outgoingIds);
        sbM833U.append(", incomingIds=");
        return outline.m826N(sbM833U, this.incomingIds, ")");
    }
}
