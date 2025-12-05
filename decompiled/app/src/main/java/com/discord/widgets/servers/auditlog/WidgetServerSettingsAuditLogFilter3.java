package com.discord.widgets.servers.auditlog;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.search.SearchUtils;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Func5;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter3<T1, T2, T3, T4, T5, R> implements Func5<StoreAuditLog.AuditLogState, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends Integer>, String, WidgetServerSettingsAuditLogFilter.Model> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $filterType;

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$1 */
    public static final class C93331 extends Lambda implements Function1<Integer, Boolean> {
        public final /* synthetic */ String $filterText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C93331(String str) {
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
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$2 */
    public static final class C93342 extends Lambda implements Function1<Integer, WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem> {
        public final /* synthetic */ StoreAuditLog.AuditLogState $auditLogState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C93342(StoreAuditLog.AuditLogState auditLogState) {
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

    @Override // p658rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilter.Model call(StoreAuditLog.AuditLogState auditLogState, Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2, List<? extends Integer> list, String str) {
        return call2(auditLogState, map, (Map<Long, GuildMember>) map2, (List<Integer>) list, str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLogFilter.Model call2(StoreAuditLog.AuditLogState auditLogState, Map<Long, ? extends User> map, Map<Long, GuildMember> map2, List<Integer> list, String str) {
        Sequence sequenceEmptySequence;
        if (this.$filterType != 0) {
            Intrinsics3.checkNotNullExpressionValue(list, "actions");
            return new WidgetServerSettingsAuditLogFilter.Model(_Sequences2.toList(_Sequences2.sortedWith(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(list), new C93331(str)), new C93342(auditLogState)), new C9332xfe5b3dfc())));
        }
        Intrinsics3.checkNotNullExpressionValue(str, "filterText");
        if (StringsJVM.isBlank(str)) {
            sequenceEmptySequence = _Collections.asSequence(CollectionsJVM.listOf(new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(null, null, 0L, this.$context.getString(C5419R.string.guild_settings_filter_all_users), null, auditLogState.getFilter().getUserFilter() == 0)));
        } else {
            sequenceEmptySequence = C12075n.emptySequence();
        }
        return new WidgetServerSettingsAuditLogFilter.Model(_Sequences2.toList(_Sequences2.sortedWith(_Sequences2.plus(sequenceEmptySequence, _Sequences2.map(_Sequences2.filterNotNull(_Sequences2.filter(_Collections.asSequence(map.values()), new WidgetServerSettingsAuditLogFilter4(str))), new WidgetServerSettingsAuditLogFilter5(map2, auditLogState))), new C9331xfe5b3dfb())));
    }
}
