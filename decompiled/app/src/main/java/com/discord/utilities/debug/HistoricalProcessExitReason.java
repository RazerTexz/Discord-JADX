package com.discord.utilities.debug;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.lifecycle.ApplicationProvider;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: HistoricalProcessExitReason.kt */
/* loaded from: classes2.dex */
public final class HistoricalProcessExitReason {
    public static final HistoricalProcessExitReason INSTANCE = new HistoricalProcessExitReason();

    /* renamed from: lastReason$delegate, reason: from kotlin metadata */
    private static final Lazy lastReason = LazyJVM.lazy(HistoricalProcessExitReason2.INSTANCE);

    /* compiled from: HistoricalProcessExitReason.kt */
    public static final /* data */ class Reason {
        private final String description;
        private final String reason;

        public Reason(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
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
            Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
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
            return Intrinsics3.areEqual(this.reason, reason.reason) && Intrinsics3.areEqual(this.description, reason.description);
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
            StringBuilder sbM833U = outline.m833U("Reason(reason=");
            sbM833U.append(this.reason);
            sbM833U.append(", description=");
            return outline.m822J(sbM833U, this.description, ")");
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
        Map mapMapOf = Maps6.mapOf(Tuples.m10073to(6, "ANR"), Tuples.m10073to(4, "CRASH"), Tuples.m10073to(5, "CRASH_NATIVE"), Tuples.m10073to(12, "DEPENDENCY_DIED"), Tuples.m10073to(9, "EXCESSIVE_RESOURCE_USAGE"), Tuples.m10073to(1, "EXIT_SELF"), Tuples.m10073to(7, "INITIALIZATION_FAILURE"), Tuples.m10073to(3, "LOW_MEMORY"), Tuples.m10073to(13, "OTHER"), Tuples.m10073to(8, "PERMISSION_CHANGE"), Tuples.m10073to(2, "SIGNALED"), Tuples.m10073to(0, "UNKNOWN"), Tuples.m10073to(10, "USER_REQUESTED"), Tuples.m10073to(11, "USER_STOPPED"));
        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null) {
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 1);
            Intrinsics3.checkNotNullExpressionValue(historicalProcessExitReasons, "activityManager.getHisto…ssExitReasons(null, 0, 1)");
            ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) _Collections.firstOrNull((List) historicalProcessExitReasons);
            if (applicationExitInfo != null) {
                String string = (String) mapMapOf.get(Integer.valueOf(applicationExitInfo.getReason()));
                if (string == null) {
                    StringBuilder sbM833U = outline.m833U("Unknown ");
                    sbM833U.append(applicationExitInfo.getReason());
                    string = sbM833U.toString();
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
