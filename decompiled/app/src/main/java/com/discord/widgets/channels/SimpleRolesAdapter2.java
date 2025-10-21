package com.discord.widgets.channels;

import android.view.View;
import com.discord.widgets.channels.SimpleRolesAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: SimpleRolesAdapter.kt */
/* renamed from: com.discord.widgets.channels.SimpleRolesAdapter$RoleAdapterItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SimpleRolesAdapter2 implements View.OnClickListener {
    public final /* synthetic */ SimpleRolesAdapter.RoleItem $data;
    public final /* synthetic */ SimpleRolesAdapter.RoleAdapterItem this$0;

    public SimpleRolesAdapter2(SimpleRolesAdapter.RoleAdapterItem roleAdapterItem, SimpleRolesAdapter.RoleItem roleItem) {
        this.this$0 = roleAdapterItem;
        this.$data = roleItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getOnRoleClickedListener$p = SimpleRolesAdapter.access$getOnRoleClickedListener$p(SimpleRolesAdapter.RoleAdapterItem.access$getAdapter$p(this.this$0));
        if (function1Access$getOnRoleClickedListener$p != null) {
        }
    }
}
