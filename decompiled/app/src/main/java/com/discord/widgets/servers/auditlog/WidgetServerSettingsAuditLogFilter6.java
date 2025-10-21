package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import d0.f0._Sequences2;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter6<T1, T2, T3, R> implements Func3<Guild, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Set<? extends Long>> {
    public static final WidgetServerSettingsAuditLogFilter6 INSTANCE = new WidgetServerSettingsAuditLogFilter6();

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends GuildMember>, Boolean> {
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ Map $roles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild, Map map) {
            super(1);
            this.$guild = guild;
            this.$roles = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends GuildMember> entry) {
            return Boolean.valueOf(invoke2((Map.Entry<Long, GuildMember>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Map.Entry<Long, GuildMember> entry) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
            long jLongValue = entry.getKey().longValue();
            GuildMember value = entry.getValue();
            Guild guild = this.$guild;
            if (guild != null && jLongValue == guild.getOwnerId()) {
                return true;
            }
            List<Long> roles = value.getRoles();
            if ((roles instanceof Collection) && roles.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = roles.iterator();
                while (it.hasNext()) {
                    GuildRole guildRole = (GuildRole) this.$roles.get(Long.valueOf(((Number) it.next()).longValue()));
                    if (((guildRole != null ? guildRole.getPermissions() : 0L) & Permission.MANAGEMENT_PERMISSIONS) > 0) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            return z2;
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends GuildMember>, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends GuildMember> entry) {
            return Long.valueOf(invoke2((Map.Entry<Long, GuildMember>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2(Map.Entry<Long, GuildMember> entry) {
            Intrinsics3.checkNotNullParameter(entry, "it");
            return entry.getKey().longValue();
        }
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Guild guild, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2) {
        return call2(guild, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2) {
        Intrinsics3.checkNotNullExpressionValue(map2, "members");
        return _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Maps.asSequence(map2), new AnonymousClass1(guild, map)), AnonymousClass2.INSTANCE));
    }
}
