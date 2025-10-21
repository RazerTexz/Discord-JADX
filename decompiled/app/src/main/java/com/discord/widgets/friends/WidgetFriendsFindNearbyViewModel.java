package com.discord.widgets.friends;

import b.a.d.AppViewModel;
import kotlin.Unit;

/* compiled from: WidgetFriendsFindNearbyViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearbyViewModel extends AppViewModel<Unit> {
    private Integer discriminator;
    private String username;

    public WidgetFriendsFindNearbyViewModel() {
        super(null, 1, null);
    }

    public final Integer getDiscriminator() {
        return this.discriminator;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setDiscriminator(Integer num) {
        this.discriminator = num;
    }

    public final void setUsername(String str) {
        this.username = str;
    }
}
