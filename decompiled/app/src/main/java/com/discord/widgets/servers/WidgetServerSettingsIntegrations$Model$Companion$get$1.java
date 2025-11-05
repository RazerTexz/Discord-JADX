package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsIntegrations;
import d0.t.k;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import rx.functions.Func5;

/* compiled from: WidgetServerSettingsIntegrations.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations$Model$Companion$get$1<T1, T2, T3, T4, T5, R> implements Func5<Map<Long, ? extends ModelGuildIntegration>, MeUser, Long, Guild, Map<Long, ? extends GuildRole>, WidgetServerSettingsIntegrations.Model> {
    public static final WidgetServerSettingsIntegrations$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsIntegrations$Model$Companion$get$1();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsIntegrations.Model call(Map<Long, ? extends ModelGuildIntegration> map, MeUser meUser, Long l, Guild guild, Map<Long, ? extends GuildRole> map2) {
        return call2(map, meUser, l, guild, (Map<Long, GuildRole>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsIntegrations.Model call2(Map<Long, ? extends ModelGuildIntegration> map, MeUser meUser, Long l, Guild guild, Map<Long, GuildRole> map2) {
        boolean z2 = false;
        if (l != null && guild != null && (guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel()))) {
            z2 = true;
        }
        if (!z2 || map == null || map2 == null || guild == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, ? extends ModelGuildIntegration>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            ModelGuildIntegration value = it.next().getValue();
            String[] strArr = ModelGuildIntegration.SUPPORTED_TYPES;
            m.checkNotNullExpressionValue(strArr, "ModelGuildIntegration.SUPPORTED_TYPES");
            WidgetServerSettingsIntegrations.Model.IntegrationItem integrationItem = k.contains(strArr, value.getType()) ? new WidgetServerSettingsIntegrations.Model.IntegrationItem(value, guild.getId()) : null;
            if (integrationItem != null) {
                arrayList.add(integrationItem);
            }
        }
        return new WidgetServerSettingsIntegrations.Model(guild.getId(), guild.getName(), arrayList);
    }
}
