package com.discord.widgets.channels.memberlist;

import com.discord.utilities.collections.SparseMutableList;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import java.util.Set;
import java.util.SortedMap;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildMemberListItemGenerator.kt */
/* renamed from: com.discord.widgets.channels.memberlist.GuildMemberListItems, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GuildMemberListItemGenerator3 implements WidgetChannelMembersListViewModel.MemberList {
    private final SortedMap<Integer, String> groupIndices;
    private final String listId;
    private final SparseMutableList<ChannelMembersListAdapter.Item> listItems;
    private final int size;

    public GuildMemberListItemGenerator3(String str, int i, SparseMutableList<ChannelMembersListAdapter.Item> sparseMutableList, SortedMap<Integer, String> sortedMap) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        Intrinsics3.checkNotNullParameter(sparseMutableList, "listItems");
        Intrinsics3.checkNotNullParameter(sortedMap, "groupIndices");
        this.listId = str;
        this.size = i;
        this.listItems = sparseMutableList;
        this.groupIndices = sortedMap;
    }

    private final SparseMutableList<ChannelMembersListAdapter.Item> component3() {
        return this.listItems;
    }

    private final SortedMap<Integer, String> component4() {
        return this.groupIndices;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildMemberListItemGenerator3 copy$default(GuildMemberListItemGenerator3 guildMemberListItemGenerator3, String str, int i, SparseMutableList sparseMutableList, SortedMap sortedMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = guildMemberListItemGenerator3.getListId();
        }
        if ((i2 & 2) != 0) {
            i = guildMemberListItemGenerator3.getSize();
        }
        if ((i2 & 4) != 0) {
            sparseMutableList = guildMemberListItemGenerator3.listItems;
        }
        if ((i2 & 8) != 0) {
            sortedMap = guildMemberListItemGenerator3.groupIndices;
        }
        return guildMemberListItemGenerator3.copy(str, i, sparseMutableList, sortedMap);
    }

    public final String component1() {
        return getListId();
    }

    public final int component2() {
        return getSize();
    }

    public final GuildMemberListItemGenerator3 copy(String listId, int size, SparseMutableList<ChannelMembersListAdapter.Item> listItems, SortedMap<Integer, String> groupIndices) {
        Intrinsics3.checkNotNullParameter(listId, "listId");
        Intrinsics3.checkNotNullParameter(listItems, "listItems");
        Intrinsics3.checkNotNullParameter(groupIndices, "groupIndices");
        return new GuildMemberListItemGenerator3(listId, size, listItems, groupIndices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberListItemGenerator3)) {
            return false;
        }
        GuildMemberListItemGenerator3 guildMemberListItemGenerator3 = (GuildMemberListItemGenerator3) other;
        return Intrinsics3.areEqual(getListId(), guildMemberListItemGenerator3.getListId()) && getSize() == guildMemberListItemGenerator3.getSize() && Intrinsics3.areEqual(this.listItems, guildMemberListItemGenerator3.listItems) && Intrinsics3.areEqual(this.groupIndices, guildMemberListItemGenerator3.groupIndices);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public ChannelMembersListAdapter.Item get(int index) {
        ChannelMembersListAdapter.Item item = this.listItems.get(index);
        return item != null ? item : (ChannelMembersListAdapter.Item) GuildMemberListItemGenerator.access$getPLACEHOLDER_INSTANCES$p().get(index % GuildMemberListItemGenerator.access$getPLACEHOLDER_INSTANCES$p().size());
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public Integer getHeaderPositionForItem(int itemPosition) {
        Set<Integer> setKeySet = this.groupIndices.keySet();
        Intrinsics3.checkNotNullExpressionValue(setKeySet, "groupIndices.keys");
        Object obj = null;
        for (Object obj2 : setKeySet) {
            if (((Integer) obj2).intValue() < itemPosition + 1) {
                obj = obj2;
            }
        }
        return (Integer) obj;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public int getSize() {
        return this.size;
    }

    public int hashCode() {
        String listId = getListId();
        int size = (getSize() + ((listId != null ? listId.hashCode() : 0) * 31)) * 31;
        SparseMutableList<ChannelMembersListAdapter.Item> sparseMutableList = this.listItems;
        int iHashCode = (size + (sparseMutableList != null ? sparseMutableList.hashCode() : 0)) * 31;
        SortedMap<Integer, String> sortedMap = this.groupIndices;
        return iHashCode + (sortedMap != null ? sortedMap.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildMemberListItems(listId=");
        sbM833U.append(getListId());
        sbM833U.append(", size=");
        sbM833U.append(getSize());
        sbM833U.append(", listItems=");
        sbM833U.append(this.listItems);
        sbM833U.append(", groupIndices=");
        sbM833U.append(this.groupIndices);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
