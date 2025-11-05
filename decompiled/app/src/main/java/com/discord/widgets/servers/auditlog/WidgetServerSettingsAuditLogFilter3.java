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
import d0.f0._Sequences2;
import d0.f0.n;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.functions.Func5;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter3<T1, T2, T3, T4, T5, R> implements Func5<StoreAuditLog.AuditLogState, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends Integer>, String, WidgetServerSettingsAuditLogFilter.Model> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $filterType;

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Boolean> {
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
            Intrinsics3.checkNotNullExpressionValue(str, "filterText");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String string = WidgetServerSettingsAuditLogFilter3.this.$context.getString(AuditLogUtils.INSTANCE.getActionName(i));
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = string.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            return searchUtils.fuzzyMatch(lowerCase, lowerCase2);
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem> {
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
            String string = WidgetServerSettingsAuditLogFilter3.this.$context.getString(AuditLogUtils.INSTANCE.getActionName(i));
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
            return new WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem(i, string, this.$auditLogState.getFilter().getActionFilter() == i);
        }
    }

    public WidgetServerSettingsAuditLogFilter3(int i, Context context) {
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
            Intrinsics3.checkNotNullExpressionValue(list, "actions");
            return new WidgetServerSettingsAuditLogFilter.Model(_Sequences2.toList(_Sequences2.sortedWith(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(list), new AnonymousClass1(str)), new AnonymousClass2(auditLogState)), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$2())));
        }
        Intrinsics3.checkNotNullExpressionValue(str, "filterText");
        if (StringsJVM.isBlank(str)) {
            sequenceEmptySequence = _Collections.asSequence(CollectionsJVM.listOf(new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(null, null, 0L, this.$context.getString(R.string.guild_settings_filter_all_users), null, auditLogState.getFilter().getUserFilter() == 0)));
        } else {
            sequenceEmptySequence = n.emptySequence();
        }
        return new WidgetServerSettingsAuditLogFilter.Model(_Sequences2.toList(_Sequences2.sortedWith(_Sequences2.plus(sequenceEmptySequence, _Sequences2.map(_Sequences2.filterNotNull(_Sequences2.filter(_Collections.asSequence(map.values()), new WidgetServerSettingsAuditLogFilter4(str))), new WidgetServerSettingsAuditLogFilter5(map2, auditLogState))), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$1())));
    }
}
