package com.discord.widgets.channels.memberlist;

import com.discord.utilities.lazy.memberlist.MemberListRow;
import java.util.Comparator;

/* compiled from: ThreadMemberListItemGenerator.kt */
/* loaded from: classes2.dex */
public final class ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1<T> implements Comparator<MemberListRow.Member> {
    public static final ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1 INSTANCE = new ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1();

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(MemberListRow.Member member, MemberListRow.Member member2) {
        return member.getName().compareTo(member2.getName());
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(MemberListRow.Member member, MemberListRow.Member member2) {
        return compare2(member, member2);
    }
}
