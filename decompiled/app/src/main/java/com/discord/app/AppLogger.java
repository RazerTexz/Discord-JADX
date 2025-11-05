package com.discord.app;

import com.discord.api.science.AnalyticsSchema;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.e0.KProperty3;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: AppLogger.kt */
/* loaded from: classes.dex */
public final class AppLogger {

    /* renamed from: a, reason: from kotlin metadata */
    public boolean hasLoggedImpression;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public AnalyticsSchema previousAnalyticsSchema;

    /* renamed from: c, reason: from kotlin metadata */
    public final a provider;

    /* renamed from: d, reason: from kotlin metadata */
    public final AnalyticsUtils.Tracker tracker;

    /* renamed from: e, reason: from kotlin metadata */
    public final boolean isImpressionLoggingEnabled;

    /* compiled from: AppLogger.kt */
    public interface a {
        AppLogger2 getLoggingConfig();
    }

    public AppLogger(a aVar, AnalyticsUtils.Tracker tracker, boolean z2, int i) {
        AnalyticsUtils.Tracker companion = (i & 2) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : null;
        z2 = (i & 4) != 0 ? GrowthTeamFeatures.INSTANCE.isImpressionLoggingEnabled() : z2;
        Intrinsics3.checkNotNullParameter(aVar, "provider");
        Intrinsics3.checkNotNullParameter(companion, "tracker");
        this.provider = aVar;
        this.tracker = companion;
        this.isImpressionLoggingEnabled = z2;
    }

    public final void a(AnalyticsSchema analyticsSchema) {
        Function0<AnalyticsSchema> function0;
        AnalyticsSchema analyticsSchemaInvoke;
        if (analyticsSchema != null) {
            this.tracker.track(analyticsSchema);
            return;
        }
        AppLogger2 loggingConfig = this.provider.getLoggingConfig();
        if (loggingConfig == null || (function0 = loggingConfig.impressionSchemaProvider) == null || (analyticsSchemaInvoke = function0.invoke()) == null) {
            return;
        }
        this.tracker.track(analyticsSchemaInvoke);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void b() {
        AnalyticsSchema analyticsSchemaInvoke;
        boolean z2;
        if (this.isImpressionLoggingEnabled) {
            AppLogger2 loggingConfig = this.provider.getLoggingConfig();
            if (loggingConfig != null) {
                Function0<AnalyticsSchema> function0 = loggingConfig.impressionSchemaProvider;
                if (function0 == null || (analyticsSchemaInvoke = function0.invoke()) == null) {
                    return;
                }
                boolean z3 = false;
                if (this.previousAnalyticsSchema == null) {
                    z3 = true;
                    if (this.hasLoggedImpression || z3) {
                        this.previousAnalyticsSchema = analyticsSchemaInvoke;
                        this.hasLoggedImpression = true;
                        a(analyticsSchemaInvoke);
                        return;
                    }
                    return;
                }
                if (loggingConfig.autoLogImpressionOnChanged) {
                    if (!loggingConfig.autoLogImpressionProperties.isEmpty() || !(!Intrinsics3.areEqual(r2, analyticsSchemaInvoke))) {
                        List<KProperty3<?, ?>> list = loggingConfig.autoLogImpressionProperties;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                KProperty3 kProperty3 = (KProperty3) it.next();
                                if ((!(kProperty3 instanceof KProperty3) ? null : kProperty3) != null ? !Intrinsics3.areEqual(kProperty3.get(analyticsSchemaInvoke), kProperty3.get(r2)) : false) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                if (this.hasLoggedImpression) {
                }
                this.previousAnalyticsSchema = analyticsSchemaInvoke;
                this.hasLoggedImpression = true;
                a(analyticsSchemaInvoke);
                return;
            }
        }
    }
}
