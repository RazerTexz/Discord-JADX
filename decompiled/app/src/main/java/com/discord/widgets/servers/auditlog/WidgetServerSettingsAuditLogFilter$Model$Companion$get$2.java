package com.discord.widgets.servers.auditlog;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.search.SearchUtils;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import d0.f0.n;
import d0.f0.q;
import d0.g0.t;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.functions.Func5;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2<T1, T2, T3, T4, T5, R> implements Func5<StoreAuditLog.AuditLogState, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends Integer>, String, WidgetServerSettingsAuditLogFilter.Model> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $filterType;

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, Boolean> {
        public final /* synthetic */ String $filterText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$filterText = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(int i) {
            SearchUtils searchUtils = SearchUtils.INSTANCE;
            String str = this.$filterText;
            m.checkNotNullExpressionValue(str, "filterText");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase();
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String string = WidgetServerSettingsAuditLogFilter$Model$Companion$get$2.this.$context.getString(AuditLogUtils.INSTANCE.getActionName(i));
            m.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = string.toLowerCase();
            m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            return searchUtils.fuzzyMatch(lowerCase, lowerCase2);
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Integer, WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem> {
        public final /* synthetic */ StoreAuditLog.AuditLogState $auditLogState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreAuditLog.AuditLogState auditLogState) {
            super(1);
            this.$auditLogState = auditLogState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem invoke(int i) {
            String string = WidgetServerSettingsAuditLogFilter$Model$Companion$get$2.this.$context.getString(AuditLogUtils.INSTANCE.getActionName(i));
            m.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
            return new WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem(i, string, this.$auditLogState.getFilter().getActionFilter() == i);
        }
    }

    public WidgetServerSettingsAuditLogFilter$Model$Companion$get$2(int i, Context context) {
        this.$filterType = i;
        this.$context = context;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilter.Model call(StoreAuditLog.AuditLogState auditLogState, Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2, List<? extends Integer> list, String str) {
        return call2(auditLogState, map, (Map<Long, GuildMember>) map2, (List<Integer>) list, str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLogFilter.Model call2(StoreAuditLog.AuditLogState auditLogState, Map<Long, ? extends User> map, Map<Long, GuildMember> map2, List<Integer> list, String str) {
        Sequence sequenceEmptySequence;
        if (this.$filterType != 0) {
            m.checkNotNullExpressionValue(list, "actions");
            return new WidgetServerSettingsAuditLogFilter.Model(q.toList(q.sortedWith(q.map(q.filter(u.asSequence(list), new AnonymousClass1(str)), new AnonymousClass2(auditLogState)), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$2())));
        }
        m.checkNotNullExpressionValue(str, "filterText");
        if (t.isBlank(str)) {
            sequenceEmptySequence = u.asSequence(d0.t.m.listOf(new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(null, null, 0L, this.$context.getString(R.string.guild_settings_filter_all_users), null, auditLogState.getFilter().getUserFilter() == 0)));
        } else {
            sequenceEmptySequence = n.emptySequence();
        }
        return new WidgetServerSettingsAuditLogFilter.Model(q.toList(q.sortedWith(q.plus(sequenceEmptySequence, q.map(q.filterNotNull(q.filter(u.asSequence(map.values()), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$1(str))), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2(map2, auditLogState))), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$1())));
    }
}
