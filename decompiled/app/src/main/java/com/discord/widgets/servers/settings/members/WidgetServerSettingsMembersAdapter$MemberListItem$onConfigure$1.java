package com.discord.widgets.servers.settings.members;

import android.view.View;
import com.discord.api.role.GuildRole;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersAdapter;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.t.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsMembersAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter$MemberListItem$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsMembersModel.MemberItem $data;
    public final /* synthetic */ WidgetServerSettingsMembersAdapter.MemberListItem this$0;

    public WidgetServerSettingsMembersAdapter$MemberListItem$onConfigure$1(WidgetServerSettingsMembersAdapter.MemberListItem memberListItem, WidgetServerSettingsMembersModel.MemberItem memberItem) {
        this.this$0 = memberListItem;
        this.$data = memberItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getMemberSelectedListener$p = WidgetServerSettingsMembersAdapter.access$getMemberSelectedListener$p(WidgetServerSettingsMembersAdapter.MemberListItem.access$getAdapter$p(this.this$0));
        Long lValueOf = Long.valueOf(this.$data.getUser().getId());
        List<GuildRole> roles = this.$data.getRoles();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(roles, 10));
        Iterator<T> it = roles.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((GuildRole) it.next()).getId()));
        }
        function2Access$getMemberSelectedListener$p.invoke(lValueOf, arrayList);
    }
}
