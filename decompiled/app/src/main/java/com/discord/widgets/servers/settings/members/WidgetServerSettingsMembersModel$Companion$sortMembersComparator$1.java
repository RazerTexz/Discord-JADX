package com.discord.widgets.servers.settings.members;

import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.g0.t;
import d0.z.d.m;
import java.util.Comparator;

/* compiled from: WidgetServerSettingsMembersModel.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1<T> implements Comparator<WidgetServerSettingsMembersModel.MemberItem> {
    public static final WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1 INSTANCE = new WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(WidgetServerSettingsMembersModel.MemberItem memberItem, WidgetServerSettingsMembersModel.MemberItem memberItem2) {
        return compare2(memberItem, memberItem2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(WidgetServerSettingsMembersModel.MemberItem memberItem, WidgetServerSettingsMembersModel.MemberItem memberItem2) {
        m.checkNotNullParameter(memberItem, "member1");
        m.checkNotNullParameter(memberItem2, "member2");
        int iCompareTo = t.compareTo(memberItem.getUserDisplayName(), memberItem2.getUserDisplayName(), true);
        return iCompareTo != 0 ? iCompareTo : (memberItem.getUser().getId() > memberItem2.getUser().getId() ? 1 : (memberItem.getUser().getId() == memberItem2.getUser().getId() ? 0 : -1));
    }
}
