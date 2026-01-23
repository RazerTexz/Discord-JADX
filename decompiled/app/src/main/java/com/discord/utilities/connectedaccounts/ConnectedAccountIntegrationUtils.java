package com.discord.utilities.connectedaccounts;

import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationAccount;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.connectedaccounts.ConnectedAccountIntegrationUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: ConnectedAccountIntegrationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectedAccountIntegrationUtils {
    public static final String TWITCH_URL_PREFIX = "twitch.tv/";
    public static final String TYPE_TWITCH = "twitch";
    public static final String TYPE_YOUTUBE = "youtube";
    public static final String YOUTUBE_URL_PREFIX = "youtube.com/channel/";

    public static final String getDisplayName(ConnectedAccountIntegration connectedAccountIntegration) {
        Intrinsics3.checkNotNullParameter(connectedAccountIntegration, "$this$getDisplayName");
        if (Intrinsics3.areEqual("twitch", connectedAccountIntegration.getType())) {
            StringBuilder sbM833U = outline.m833U(TWITCH_URL_PREFIX);
            ConnectedIntegrationAccount account = connectedAccountIntegration.getAccount();
            sbM833U.append(account != null ? account.getName() : null);
            return sbM833U.toString();
        }
        if (Intrinsics3.areEqual("youtube", connectedAccountIntegration.getType())) {
            StringBuilder sbM833U2 = outline.m833U(YOUTUBE_URL_PREFIX);
            ConnectedIntegrationAccount account2 = connectedAccountIntegration.getAccount();
            sbM833U2.append(account2 != null ? account2.getName() : null);
            return sbM833U2.toString();
        }
        ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
        if (guild != null) {
            return guild.getName();
        }
        return null;
    }
}
