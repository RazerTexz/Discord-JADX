package com.discord.utilities.debug;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.g;
import d0.o;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;

/* compiled from: HistoricalProcessExitReason.kt */
/* loaded from: classes2.dex */
public final class HistoricalProcessExitReason {
    public static final HistoricalProcessExitReason INSTANCE = new HistoricalProcessExitReason();

    /* renamed from: lastReason$delegate, reason: from kotlin metadata */
    private static final Lazy lastReason = g.lazy(HistoricalProcessExitReason$lastReason$2.INSTANCE);

    /* compiled from: HistoricalProcessExitReason.kt */
    public static final /* data */ class Reason {
        private final String description;
        private final String reason;

        public Reason(String str, String str2) {
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
            this.reason = str;
            this.description = str2;
        }

        public static /* synthetic */ Reason copy$default(Reason reason, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reason.reason;
            }
            if ((i & 2) != 0) {
                str2 = reason.description;
            }
            return reason.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Reason copy(String reason, String description) {
            m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
            return new Reason(reason, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Reason)) {
                return false;
            }
            Reason reason = (Reason) other;
            return m.areEqual(this.reason, reason.reason) && m.areEqual(this.description, reason.description);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            String str = this.reason;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Reason(reason=");
            sbU.append(this.reason);
            sbU.append(", description=");
            return a.J(sbU, this.description, ")");
        }
    }

    private HistoricalProcessExitReason() {
    }

    public static final /* synthetic */ Reason access$createLastReason(HistoricalProcessExitReason historicalProcessExitReason) {
        return historicalProcessExitReason.createLastReason();
    }

    private final Reason createLastReason() {
        Reason reason = null;
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Map mapMapOf = h0.mapOf(o.to(6, "ANR"), o.to(4, "CRASH"), o.to(5, "CRASH_NATIVE"), o.to(12, "DEPENDENCY_DIED"), o.to(9, "EXCESSIVE_RESOURCE_USAGE"), o.to(1, "EXIT_SELF"), o.to(7, "INITIALIZATION_FAILURE"), o.to(3, "LOW_MEMORY"), o.to(13, "OTHER"), o.to(8, "PERMISSION_CHANGE"), o.to(2, "SIGNALED"), o.to(0, "UNKNOWN"), o.to(10, "USER_REQUESTED"), o.to(11, "USER_STOPPED"));
        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null) {
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 1);
            m.checkNotNullExpressionValue(historicalProcessExitReasons, "activityManager.getHisto…ssExitReasons(null, 0, 1)");
            ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) u.firstOrNull((List) historicalProcessExitReasons);
            if (applicationExitInfo != null) {
                String string = (String) mapMapOf.get(Integer.valueOf(applicationExitInfo.getReason()));
                if (string == null) {
                    StringBuilder sbU = a.U("Unknown ");
                    sbU.append(applicationExitInfo.getReason());
                    string = sbU.toString();
                }
                reason = new Reason(string, applicationExitInfo.getDescription());
            }
        }
        return reason;
    }

    public final Reason getLastReason() {
        return (Reason) lastReason.getValue();
    }
}
