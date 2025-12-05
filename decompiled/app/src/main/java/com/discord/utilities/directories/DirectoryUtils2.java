package com.discord.utilities.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.DirectoryEntryData;
import java.util.ArrayList;
import java.util.List;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DirectoryUtils.kt */
/* renamed from: com.discord.utilities.directories.DirectoryUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class DirectoryUtils2 {
    private static final int MAXIMUM_SIZE = 200;
    public static final int MAX_HOME_CATEGORY_COUNT = 5;
    public static final int MAX_RECOMMENDATION_COUNT = 5;
    private static final int MINIMUM_MEMBER_COUNT = 5;
    private static final int MINIMUM_SIZE = 5;

    public static final boolean hasMinimumMemberCount(DirectoryEntryGuild directoryEntryGuild) {
        Intrinsics3.checkNotNullParameter(directoryEntryGuild, "$this$hasMinimumMemberCount");
        Integer approximateMemberCount = directoryEntryGuild.getGuild().getApproximateMemberCount();
        return (approximateMemberCount != null ? approximateMemberCount.intValue() : 0) >= 5;
    }

    public static final List<DirectoryEntryData> rank(List<DirectoryEntryData> list, Integer num) {
        Intrinsics3.checkNotNullParameter(list, "$this$rank");
        return _Collections.sortedWith(list, new DirectoryUtilsKt$rank$$inlined$sortedBy$1(num));
    }

    public static /* synthetic */ List rank$default(List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return rank(list, num);
    }

    public static final List<DirectoryEntryData> sortByAdded(List<DirectoryEntryData> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortByAdded");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            DirectoryEntryData directoryEntryData = (DirectoryEntryData) obj;
            if (Intrinsics3.areEqual(directoryEntryData.getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE) && hasMinimumMemberCount(directoryEntryData.getEntry())) {
                arrayList.add(obj);
            }
        }
        return _Collections.take(_Collections.sortedWith(arrayList, new DirectoryUtilsKt$sortByAdded$$inlined$sortedByDescending$1()), 5);
    }

    public static final List<DirectoryEntryData> sortByRanking(List<DirectoryEntryData> list, int i) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortByRanking");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics3.areEqual(((DirectoryEntryData) obj).getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        return _Collections.take(rank$default(arrayList, null, 1, null), i);
    }
}
