package com.discord.utilities.lazy.memberlist;

import com.discord.utilities.collections.SparseMutableList;
import java.util.SortedMap;

/* compiled from: MemberList.kt */
/* loaded from: classes2.dex */
public interface MemberList {
    SortedMap<Integer, String> getGroupIndices();

    int getInitialSize();

    String getListId();

    SparseMutableList<MemberListRow> getRows();

    int getSize();
}
