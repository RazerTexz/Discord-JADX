package com.discord.widgets.hubs;

import com.discord.models.guild.Guild;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubAddNameViewModel.kt */
/* renamed from: com.discord.widgets.hubs.AddNameState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubAddNameViewModel2 {
    private final RestCallState<Void> changeNicknameAsync;
    private final Guild guild;
    private final String nickname;

    public WidgetHubAddNameViewModel2() {
        this(null, null, null, 7, null);
    }

    public WidgetHubAddNameViewModel2(String str, Guild guild, RestCallState<Void> restCallState) {
        Intrinsics3.checkNotNullParameter(str, "nickname");
        Intrinsics3.checkNotNullParameter(restCallState, "changeNicknameAsync");
        this.nickname = str;
        this.guild = guild;
        this.changeNicknameAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubAddNameViewModel2 copy$default(WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2, String str, Guild guild, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubAddNameViewModel2.nickname;
        }
        if ((i & 2) != 0) {
            guild = widgetHubAddNameViewModel2.guild;
        }
        if ((i & 4) != 0) {
            restCallState = widgetHubAddNameViewModel2.changeNicknameAsync;
        }
        return widgetHubAddNameViewModel2.copy(str, guild, restCallState);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final RestCallState<Void> component3() {
        return this.changeNicknameAsync;
    }

    public final WidgetHubAddNameViewModel2 copy(String nickname, Guild guild, RestCallState<Void> changeNicknameAsync) {
        Intrinsics3.checkNotNullParameter(nickname, "nickname");
        Intrinsics3.checkNotNullParameter(changeNicknameAsync, "changeNicknameAsync");
        return new WidgetHubAddNameViewModel2(nickname, guild, changeNicknameAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAddNameViewModel2)) {
            return false;
        }
        WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2 = (WidgetHubAddNameViewModel2) other;
        return Intrinsics3.areEqual(this.nickname, widgetHubAddNameViewModel2.nickname) && Intrinsics3.areEqual(this.guild, widgetHubAddNameViewModel2.guild) && Intrinsics3.areEqual(this.changeNicknameAsync, widgetHubAddNameViewModel2.changeNicknameAsync);
    }

    public final RestCallState<Void> getChangeNicknameAsync() {
        return this.changeNicknameAsync;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        String str = this.nickname;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        RestCallState<Void> restCallState = this.changeNicknameAsync;
        return iHashCode2 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("AddNameState(nickname=");
        sbM833U.append(this.nickname);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", changeNicknameAsync=");
        sbM833U.append(this.changeNicknameAsync);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ WidgetHubAddNameViewModel2(String str, Guild guild, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : guild, (i & 4) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
