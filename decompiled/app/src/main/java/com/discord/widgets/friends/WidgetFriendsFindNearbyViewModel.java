package com.discord.widgets.friends;

import kotlin.Unit;
import p007b.p008a.p018d.AppViewModel;

/* JADX INFO: compiled from: WidgetFriendsFindNearbyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
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
