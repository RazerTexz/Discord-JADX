package com.discord.widgets.servers.settings.members;

import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import java.util.Comparator;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsMembersModel.kt */
/* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel3<T> implements Comparator<WidgetServerSettingsMembersModel.MemberItem> {
    public static final WidgetServerSettingsMembersModel3 INSTANCE = new WidgetServerSettingsMembersModel3();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(WidgetServerSettingsMembersModel.MemberItem memberItem, WidgetServerSettingsMembersModel.MemberItem memberItem2) {
        return compare2(memberItem, memberItem2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(WidgetServerSettingsMembersModel.MemberItem memberItem, WidgetServerSettingsMembersModel.MemberItem memberItem2) {
        Intrinsics3.checkNotNullParameter(memberItem, "member1");
        Intrinsics3.checkNotNullParameter(memberItem2, "member2");
        int iCompareTo = StringsJVM.compareTo(memberItem.getUserDisplayName(), memberItem2.getUserDisplayName(), true);
        return iCompareTo != 0 ? iCompareTo : (memberItem.getUser().getId() > memberItem2.getUser().getId() ? 1 : (memberItem.getUser().getId() == memberItem2.getUser().getId() ? 0 : -1));
    }
}
