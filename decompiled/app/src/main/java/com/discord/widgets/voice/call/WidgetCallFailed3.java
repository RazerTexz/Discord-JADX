package com.discord.widgets.voice.call;

import android.view.View;
import com.discord.models.user.User;

/* compiled from: WidgetCallFailed.kt */
/* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$configureUI$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallFailed3 implements View.OnClickListener {
    public final /* synthetic */ User $this_configureUI$inlined;
    public final /* synthetic */ WidgetCallFailed this$0;

    public WidgetCallFailed3(WidgetCallFailed widgetCallFailed, User user) {
        this.this$0 = widgetCallFailed;
        this.$this_configureUI$inlined = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCallFailed.sendFriendRequest$default(this.this$0, this.$this_configureUI$inlined.getId(), this.$this_configureUI$inlined.getUsername(), null, 4, null);
    }
}
